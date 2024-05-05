package Service.San_Pham;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.implemet.San_pham_DAO;
import Entity.San_Pham.Danh_muc_san_pham;
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
		int id_danh_muc = Integer.parseInt(req.getParameter("id_danh_muc"));
		
		Danh_muc_san_pham danh_muc = new Danh_muc_Service().getDanh_muc_Id(id_danh_muc);
		
		String ten_mat_hang = req.getParameter("ten_mat_hang");
		String mo_ta = req.getParameter("mo_ta");
		String thong_tin_chi_tiet = req.getParameter("thong_tin_chi_tiet");
		String thuong_hieu = req.getParameter("thuong_hieu");
		String chat_lieu = req.getParameter("chat_lieu");
		
		List<String> fileanh = new ArrayList<>();
		
		int id_san_pham = new Random().nextInt();
		San_pham san_pham = new San_pham(id_san_pham, danh_muc.getCategory(), ten_mat_hang, thuong_hieu, chat_lieu, mo_ta, thong_tin_chi_tiet, fileanh, null);
		System.out.println(san_pham.toString());
		san_pham.setId_danh_muc_san_pham(id_danh_muc);
		new San_pham_Service().add_san_pham(san_pham);
	}
	
	public void add_image(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Part> parts = (List<Part>) req.getParts();
        
        for (Part part : parts) {
            if (part.getName().equals("images[]") && part.getContentType() != null) {
                String fileName = part.getSubmittedFileName();
                System.out.println(fileName);
            }
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
