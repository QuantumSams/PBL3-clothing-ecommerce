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
import Service.Nguoi_Dung.Nguoi_dung_Service;
import Service.San_Pham.San_pham_Service;
import Service.Thuoc_Tinh.Thuoc_tinh_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/add_product", "/load_nhan_vien_by_json"})
public class AdminController extends HttpServlet{

	private static final long serialVersionUID = 3077274296845015069L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getServletPath();
		San_pham_Service san_pham_Service = new San_pham_Service();
		Nguoi_dung_Service nguoi_dung_Service = new Nguoi_dung_Service();
		
		if(action != null && action.equals("/add_product")) {
			san_pham_Service.Load_properties(req, resp);
			req.getRequestDispatcher("/Crud.jsp").forward(req, resp);
		}
		else if(action != null && action.equals("/load_nhan_vien_by_json")) {
			nguoi_dung_Service.load_nhan_vien_by_json(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		San_pham_Service san_pham_Service = new San_pham_Service();
		
		if(action != null && action.equals("/add_product")) {
			san_pham_Service.add_product(req, resp);
		}
		else if(action != null && action.equals("/")) {
			
		}
		else if(action != null && action.equals("/")) {
			
		}
		
	}
	
}
