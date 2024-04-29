package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Entity.San_Pham.Danh_muc_san_pham;
import Entity.San_Pham.San_pham;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Size;
import Service.Danh_Muc.Danh_muc_Service;
import Service.San_Pham.San_pham_Service;
import Service.Thuoc_Tinh.Thuoc_tinh_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/add_product"})
public class AdminController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3077274296845015069L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action != null && action.equals("/add_product")) {
			Load_properties(req, resp);
			req.getRequestDispatcher("/Crud.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action != null && action.equals("/add_product")) {
			add_product(req, resp);
		}
		else if(action != null && action.equals("/")) {
			
		}
		else if(action != null && action.equals("/")) {
			
		}
		
	}
	
	private void Load_properties(HttpServletRequest req, HttpServletResponse resp) {
		Danh_muc_Service danhmuc = new Danh_muc_Service();
		Thuoc_tinh_Service thuoc_tinh_Service = new Thuoc_tinh_Service();
		
		String sql ;
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
	
	private void add_product(HttpServletRequest req, HttpServletResponse resp) {
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
}
