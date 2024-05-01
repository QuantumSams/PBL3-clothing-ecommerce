package Control;

import java.io.IOException;
import java.util.List;

import Entity.Nguoi_Dung.Phan_quyen_nguoi_dung;
import Entity.San_Pham.San_pham;
import Service.Danh_Muc.Danh_muc_Service;
import Service.Nguoi_Dung.Nguoi_dung_Service;
import Service.San_Pham.San_pham_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/trang_chu", "/trang_chu_cua_hang", "/login", "/logout", "/sign_up"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = -5225303616746645511L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		Nguoi_dung_Service nguoi_dung_Service = new Nguoi_dung_Service();
		San_pham_Service san_pham_Service = new San_pham_Service();
		Danh_muc_Service danh_muc_Service = new Danh_muc_Service();
		
		if(action != null && action.equals("/logout")) {
			nguoi_dung_Service.logout(req, resp);
			resp.sendRedirect("trang_chu");
		}
		else if(action != null && action.equals("/trang_chu")) {
			san_pham_Service.load_product_by_session(req, resp);
			danh_muc_Service.load_category_by_session(req, resp);
			resp.sendRedirect("index.jsp");
		}
		else if(action != null && action.equals("/trang_chu_cua_hang")) {
			san_pham_Service.load_product_by_session(req, resp);
			nguoi_dung_Service.load_nhan_vien_by_session(req, resp);
			resp.sendRedirect("chucuahang.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		Nguoi_dung_Service nguoi_dung_Service = new Nguoi_dung_Service();
		
		if(action != null && action.equals("/login")) {
			try {
				String phan_quyen = nguoi_dung_Service.Login(req, resp);
				if(phan_quyen.equals(Phan_quyen_nguoi_dung.KHACH_HANG.toString())){
					resp.sendRedirect("trang_chu");
				}
				else if(phan_quyen.equals(Phan_quyen_nguoi_dung.CHU_CUA_HANG.toString())){
					resp.sendRedirect("trang_chu_cua_hang");
				}
				else if(phan_quyen.equals(Phan_quyen_nguoi_dung.NHAN_VIEN.toString())){
					resp.sendRedirect("trang_chu");
				}
			}
			catch (Exception e) {
				req.setAttribute("message1", e.getMessage());
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			
		}
		else if(action != null && action.equals("/sign_up")) {
			nguoi_dung_Service.Sign_up(req, resp);
		}
		
	}
}
