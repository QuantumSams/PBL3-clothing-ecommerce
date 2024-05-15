package Service.San_Pham;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.implemet.San_pham_DAO;
import Entity.San_Pham.Danh_muc_san_pham;
import Entity.San_Pham.Muc_san_pham;
import Entity.San_Pham.San_pham;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Size;
import Service.Danh_Muc.Danh_muc_Service;
import Service.Thuoc_Tinh.Thuoc_tinh_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

public class San_pham_Service {
	
	private San_pham_DAO san_pham_DAO;
	
	public San_pham_Service() {
		san_pham_DAO = new San_pham_DAO();
	}
	
	public List<San_pham> LayTatCaSanPham() {
		return san_pham_DAO.getList_San_Pham();
	}
	
	public List<San_pham> LaySanPham(String Search){
		return san_pham_DAO.getList_San_Pham(Search);
	}
	
	public void add_san_pham(San_pham san_pham) {
		new San_pham_DAO().add_san_pham(san_pham);
	}
	
	public void load_product_by_session(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<San_pham> list_san_pham = new San_pham_Service().LayTatCaSanPham();
		
		HttpSession session = req.getSession();
		if(list_san_pham != null) session.setAttribute("san_pham", list_san_pham);
	}
	
	public void load_product_by_json(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<San_pham> list_san_pham = new San_pham_Service().LayTatCaSanPham();
		
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(list_san_pham);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
	
	public void load_product(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id_san_pham");
		San_pham san_pham = san_pham_DAO.getProduct_by_ID(id);
		System.out.println(san_pham.getGia_tien() + " " + san_pham.getMuc_san_pham().size());
		for(Muc_san_pham muc_san_pham : san_pham.getMuc_san_pham()) {
			System.out.println(muc_san_pham.getAnh_chi_tiet() + muc_san_pham.getGia_tien());
		}
		HttpSession session = req.getSession();
		session.setAttribute("product", san_pham);
		
		
	}
	
	public void search_product_by_json(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String Search = req.getParameter("product_name");
		
		List<San_pham> list_san_pham = new San_pham_Service().LaySanPham(Search);
		System.out.println(list_san_pham.size());
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(list_san_pham);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
	
	public void Load_properties(HttpServletRequest req, HttpServletResponse resp) {
		Danh_muc_Service danhmuc = new Danh_muc_Service();
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
//		ObjectMapper objectMapper = new ObjectMapper();
//		BufferedReader reader = req.getReader();
//		
//		List<Map<String, Object>> data = objectMapper.readValue(reader, List.class);
//		List<String> imageStrings = (ArrayList<String>) data.get(0).get("images") ;
//
//		int id_danh_muc = Integer.parseInt((String) data.get(0).get("id_danh_muc"));
//		Danh_muc_san_pham danh_muc = new Danh_muc_Service().getDanh_muc_Id(id_danh_muc);
//		
//		int id_san_pham = new Random().nextInt(1000000);		
//		
//		String ten_mat_hang = (String) data.get(0).get("ten_mat_hang") ;
//		String mo_ta = (String) data.get(0).get("mo_ta") ;
//		String thong_tin_chi_tiet = (String) data.get(0).get("thong_tin_chi_tiet") ;
//		String thuong_hieu = (String) data.get(0).get("thuong_hieu") ;
//		String chat_lieu = (String) data.get(0).get("chat_lieu") ;
		
		
		int id_danh_muc = Integer.parseInt(req.getParameter("id_danh_muc"));
		Danh_muc_san_pham danh_muc = new Danh_muc_Service().getDanh_muc_Id(id_danh_muc);
		
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
			list_muc_san_pham.add(new Muc_san_pham(	new_id, 
													id_san_pham, 
													0, 
													new Mau_sac(list_mau_muc_san_pham.get(i), "", ""), 
													new Size(list_size_muc_san_pham.get(i), ""), 
													list_gia_san_pham.get(i), 
													path));
		}
		
		
		San_pham san_pham = new San_pham(id_san_pham, danh_muc.getCategory(), ten_mat_hang, thuong_hieu, chat_lieu, mo_ta, thong_tin_chi_tiet, fileanh, list_muc_san_pham);
		System.out.println(san_pham.toString());
		san_pham.setId_danh_muc_san_pham(id_danh_muc);
		//san_pham.setAnh_san_pham(fileanh);
		san_pham_DAO.add_san_pham(san_pham);
		
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
		
		List<String> list_path = new ArrayList<>();
		
		byte[] data1 = Base64.getDecoder().decode(imageStrings);
			 
		String path = "img/anh_san_pham/" + id_san_pham + ".png";
			 
		image(data1, id_san_pham);
			 
		return path;	
	}
	
	public void image(byte[] data1, String name_image) {
		String root = "D:/Language Program/Java_web/PBL3-clothing-ecommerce/PBL3/src/main/webapp/";
		String path = root + "img/anh_san_pham/" + name_image + ".png";
		
		try (FileOutputStream fos = new FileOutputStream(path)) {
			fos.write(data1);
			System.out.println("Image saved successfully to: " + path);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public List<String> lay_anh_san_pham(HttpServletRequest req) throws IOException, ServletException{
		Part part = req.getPart("images[]");
		List<String> list_anh = new ArrayList<String>();
		
		while (part != null) {
			String path = "D:\\Language Program\\Java_web\\PBL3-clothing-ecommerce\\PBL3\\src\\main\\webapp\\img\\anh_san_pham\\";
			Part filePart = part;
	        String fileName = filePart.getSubmittedFileName();
	        String imagePath = "img/anh_san_pham/" + fileName;
	        filePart.write(path + fileName);
	        list_anh.add(imagePath);
	        System.out.println(imagePath);
            // Get next part
            part = req.getPart("images[]");
        }
		
		return list_anh;
	}
}
