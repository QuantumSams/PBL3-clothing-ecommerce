package Model.BLL.Service.San_Pham;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.BLL.Service.Danh_Muc.Danh_muc_Service;
import Model.BLL.Service.Thuoc_Tinh.Thuoc_tinh_Service;
import Model.DAL.DAO.implemet.Anh_san_pham_DAO;
import Model.DAL.DAO.implemet.Danh_muc_DAO;
import Model.DAL.DAO.implemet.Mau_sac_DAO;
import Model.DAL.DAO.implemet.Muc_san_pham_DAO;
import Model.DAL.DAO.implemet.San_pham_DAO;
import Model.DAL.DAO.implemet.Size_DAO;
import Model.DAL.Mapper.Thuoc_tinh_san_pham.Anh_san_pham_Mapper;
import Model.DAL.Specification.Implements.Anh_san_pham.FindProductIMGByIDProduct;
import Model.DAL.Specification.Implements.Mau_sac.FindColorByID;
import Model.DAL.Specification.Implements.Muc_san_pham.FindProductItemByIDProduct;
import Model.DAL.Specification.Implements.San_pham.FindProductByID;
import Model.DAL.Specification.Implements.San_pham.FindProductByName;
import Model.DAL.Specification.Implements.Size.FindSizeByID;
import Model.DTO.San_Pham.Danh_muc_san_pham;
import Model.DTO.San_Pham.Muc_san_pham;
import Model.DTO.San_Pham.San_pham;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Anh_san_pham;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Size;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

public class San_pham_Service {
	
	private San_pham_DAO san_pham_DAO;
	private Muc_san_pham_DAO muc_san_pham_DAO;
	private Mau_sac_DAO mau_sac_DAO;
	private Size_DAO size_DAO;
	private Anh_san_pham_DAO anh_san_pham_DAO;
	
	public San_pham_Service(San_pham_DAO san_pham_DAO,
							Muc_san_pham_DAO muc_san_pham_DAO,
							Mau_sac_DAO mau_sac_DAO,	
							Size_DAO size_DAO,
							Anh_san_pham_DAO anh_san_pham_DAO) {
		
		this.san_pham_DAO = san_pham_DAO;
		this.muc_san_pham_DAO = muc_san_pham_DAO;
		this.mau_sac_DAO = mau_sac_DAO;
		this.size_DAO = size_DAO;
		this.anh_san_pham_DAO = anh_san_pham_DAO;
	}
	
	public List<San_pham> GetAllProducts(HttpServletRequest req, HttpServletResponse resp) {
		
		List<San_pham> list_san_pham = san_pham_DAO.getALL();
		
		for(San_pham san_pham : list_san_pham) {
			
			List<Anh_san_pham> list_anh = anh_san_pham_DAO.findBySpacification(
								new FindProductIMGByIDProduct(san_pham.getId_san_pham()));
			List<String> anh = new ArrayList<>();
			for(Anh_san_pham anhsanpham : list_anh) {
				anh.add(anhsanpham.getDuong_dan_anh());
			}
			List<Muc_san_pham> list_muc_san_pham = muc_san_pham_DAO.findBySpacification(
								new FindProductItemByIDProduct(san_pham.getId_san_pham()));
			
			san_pham.setMuc_san_pham(list_muc_san_pham);
			san_pham.setAnh_san_pham(anh);
		}
		
		return list_san_pham;
	}
	
	public List<San_pham> SearchProduct(String Search){
		List<San_pham> list_san_pham = san_pham_DAO.findBySpacification(new FindProductByName(Search));
		
		for(San_pham san_pham : list_san_pham) {
			getFullInformationProduct(san_pham);
		}
		
		return list_san_pham;
	}
	
	public List<San_pham> getProductByID(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id_san_pham"));
		List<San_pham> list_san_pham = san_pham_DAO.findBySpacification(new FindProductByID(id));
		
		for(San_pham san_pham : list_san_pham) {
			getFullInformationProduct(san_pham);
		}
		
		return list_san_pham;
	}
	
	public List<San_pham> searchProductByName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String Search = req.getParameter("product_name");
		
		return SearchProduct(Search);
	}

	public void getFullInformationProduct(San_pham san_pham) {
		List<Anh_san_pham> list_anh = anh_san_pham_DAO.findBySpacification(
				new FindProductIMGByIDProduct(san_pham.getId_san_pham()));
		List<String> anh = new ArrayList<>();
		for(Anh_san_pham anhsanpham : list_anh) {
			anh.add(anhsanpham.getDuong_dan_anh());
		}
		
		List<Muc_san_pham> list_muc_san_pham = muc_san_pham_DAO.findBySpacification(
						new FindProductItemByIDProduct(san_pham.getId_san_pham()));
		
		san_pham.setMuc_san_pham(list_muc_san_pham);
		san_pham.setAnh_san_pham(anh);
	}
	
	public void add_san_pham(San_pham san_pham) {
		new San_pham_DAO().add(san_pham);
	}
	
	public void Load_properties(HttpServletRequest req, HttpServletResponse resp) {
		Danh_muc_Service danhmuc = new Danh_muc_Service(new Danh_muc_DAO());
		Thuoc_tinh_Service thuoc_tinh_Service = new Thuoc_tinh_Service();
		
		List<Mau_sac> list_mau_sac = thuoc_tinh_Service.getMau_sac();
		List<Size> list_size = thuoc_tinh_Service.getSize(); 

		danhmuc.LayTatCaDanhMuc();
		List<Danh_muc_san_pham> list_dtkh = danhmuc.Lay_danh_muc_con();
		List<Danh_muc_san_pham> list_ten_loai_san_pham = danhmuc.Lay_danh_muc_con(list_dtkh.get(0));
		List<Danh_muc_san_pham> list_danh_muc_san_pham = danhmuc.Lay_danh_muc_con(list_ten_loai_san_pham.get(0));
		
		req.setAttribute("mau_sac", list_mau_sac);
		req.setAttribute("size", list_size);
		req.setAttribute("doi_tuong_khach_hang", list_dtkh);
		req.setAttribute("ten_loai_san_pham", list_ten_loai_san_pham);
		req.setAttribute("ten_danh_muc_san_pham", list_danh_muc_san_pham);
	}
	
	public void add_product(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		int id_danh_muc = Integer.parseInt(req.getParameter("id_danh_muc"));
		Danh_muc_san_pham danh_muc = new Danh_muc_Service(new Danh_muc_DAO()).getDanh_muc_Id(id_danh_muc);
		
		int id_san_pham = new Random().nextInt(1000000);		
		
		String ten_mat_hang = req.getParameter("ten_mat_hang") ;
		String mo_ta = req.getParameter("mo_ta") ;
		String thong_tin_chi_tiet = req.getParameter("thong_tin_chi_tiet") ;
		String thuong_hieu = req.getParameter("thuong_hieu") ;
		String chat_lieu = req.getParameter("chat_lieu") ;
		String anh_san_pham = req.getParameter("images") ;
		String size_muc_san_pham = req.getParameter("size") ;
		String mau_muc_san_pham = req.getParameter("color") ;
		String anh_muc_san_pham = req.getParameter("image_muc") ;
		String gia_san_pham = req.getParameter("gia") ;
		
		List<String> list_anh_san_pham = null;
		List<Integer> list_size_muc_san_pham = null;
		List<Integer> list_mau_muc_san_pham = null;
		List<Integer> list_gia_san_pham = null;
		List<String> list_anh_muc_san_pham = null;
		
		list_anh_san_pham = new ObjectMapper().readValue(anh_san_pham, new TypeReference<List<String>>() {});
		list_size_muc_san_pham = new ObjectMapper().readValue(size_muc_san_pham, new TypeReference<List<Integer>>() {});
		list_mau_muc_san_pham= new ObjectMapper().readValue(mau_muc_san_pham, new TypeReference<List<Integer>>() {});
		list_gia_san_pham= new ObjectMapper().readValue(gia_san_pham, new TypeReference<List<Integer>>() {});
		list_anh_muc_san_pham = new ObjectMapper().readValue(anh_muc_san_pham, new TypeReference<List<String>>() {});
		
		List<String> fileanh = add_image(list_anh_san_pham, id_san_pham);
		
		
		List<Muc_san_pham> list_muc_san_pham = new ArrayList<>();
		for(int i = 0; i < list_anh_muc_san_pham.size(); ++i) {
			int new_id = new Random().nextInt(10000);
			String path = add_image(list_anh_muc_san_pham.get(i), ""+new_id+id_san_pham);
			
			Muc_san_pham muc_san_pham = new Muc_san_pham(	new_id, 
					id_san_pham, 
					0, 
					new Mau_sac(list_mau_muc_san_pham.get(i), "", ""), 
					new Size(list_size_muc_san_pham.get(i), ""), 
					list_gia_san_pham.get(i), 
					path);
			list_muc_san_pham.add(muc_san_pham);
		}
		
		
		San_pham san_pham = new San_pham(id_san_pham, danh_muc.getCategory(), ten_mat_hang, thuong_hieu, chat_lieu, mo_ta, thong_tin_chi_tiet, fileanh, list_muc_san_pham);
		System.out.println(san_pham.toString());
		san_pham.setId_danh_muc_san_pham(id_danh_muc);
		//san_pham.setAnh_san_pham(fileanh);
		san_pham_DAO.add(san_pham);

		for(String anh : fileanh) {
			Anh_san_pham anh_ = new Anh_san_pham();
			anh_.setId_anh(new Random().nextInt());
			anh_.setId_san_pham(id_san_pham);
			anh_.setDuong_dan_anh(anh);
			
			anh_san_pham_DAO.add(anh_);
		}
		for(Muc_san_pham muc_san_pham : san_pham.getMuc_san_pham()) {
			muc_san_pham_DAO.add(muc_san_pham);
		}
	}
	
	public List<String> add_image(List<String> imageStrings, int id_san_pham) throws IOException, ServletException {
		
		List<String> list_path = new ArrayList<>();
		
		for(int i = 0; i < imageStrings.size(); ++i) {
			 byte[] data1 = Base64.getDecoder().decode(imageStrings.get(i));
			 
			 String path = "img/anh_san_pham/" + id_san_pham + "_" + i + ".png";
			 
			 image(data1, id_san_pham + "_" + i);
			 
			 list_path.add(path);												
		}
		return list_path;
	}
	
	public String add_image(String imageStrings, String id_san_pham) throws IOException, ServletException {
		
		byte[] data1 = Base64.getDecoder().decode(imageStrings);
			 
		String path = "img/anh_san_pham/" + id_san_pham + ".png";
			 
		image(data1, id_san_pham);
			 
		return path;	
	}
	
	public void image(byte[] data1, String name_image) {
		String root = "D:/Language Program/Java_web/PBL3/PBL3-clothing-ecommerce/PBL3/src/main/webapp/";
		String path = root + "img/anh_san_pham/" + name_image + ".png";
		
		try (FileOutputStream fos = new FileOutputStream(path)) {
			fos.write(data1);
			System.out.println("Image saved successfully to: " + path);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public void remove_Product(HttpServletRequest req, HttpServletResponse resp)
	{
		San_pham san_pham = getProductByID(req, resp).get(0);
		
		for(Muc_san_pham muc_san_pham : san_pham.getMuc_san_pham())
		{
			muc_san_pham_DAO.remove(muc_san_pham);
		}
		san_pham_DAO.remove(san_pham);
	}
}
