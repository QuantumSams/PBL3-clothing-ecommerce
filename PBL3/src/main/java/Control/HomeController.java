package Control;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.BLL.Service.Danh_Muc.Danh_muc_Service;
import Model.BLL.Service.Nguoi_Dung.Nguoi_dung_Service;
import Model.BLL.Service.San_Pham.San_pham_Service;
import Model.DAL.DAO.implemet.Anh_san_pham_DAO;
import Model.DAL.DAO.implemet.Danh_muc_DAO;
import Model.DAL.DAO.implemet.Mau_sac_DAO;
import Model.DAL.DAO.implemet.Muc_san_pham_DAO;
import Model.DAL.DAO.implemet.Nguoi_dung_DAO;
import Model.DAL.DAO.implemet.San_pham_DAO;
import Model.DAL.DAO.implemet.Size_DAO;
import Model.DTO.Nguoi_Dung.Nguoi_dung;
import Model.DTO.Nguoi_Dung.Phan_quyen_nguoi_dung;
import Model.DTO.San_Pham.San_pham;
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
		Nguoi_dung_Service nguoi_dung_Service = new Nguoi_dung_Service(new Nguoi_dung_DAO());
		San_pham_Service san_pham_Service = new San_pham_Service(new San_pham_DAO(), new Muc_san_pham_DAO(), new Mau_sac_DAO(), new Size_DAO(), new Anh_san_pham_DAO());
		Danh_muc_Service danh_muc_Service = new Danh_muc_Service(new Danh_muc_DAO());
		
		if(action != null && action.equals("/logout")) {
			resp.setContentType("text/html;charset=UTF-8");
			HttpSession session = req.getSession();
			session.removeAttribute("acc");
			resp.sendRedirect("trang_chu");
		}
		
		else if(action != null && action.equals("/trang_chu")) {
			List<San_pham> list_san_pham = san_pham_Service.GetAllProducts(req, resp);
			HttpSession session = req.getSession();
			session.setAttribute("san_pham", list_san_pham);
			
			danh_muc_Service.load_category_by_session(req, resp);
			
			resp.sendRedirect("index.jsp");
		}
		
		else if(action != null && action.equals("/trang_chu_cua_hang")) {
			List<San_pham> list_san_pham = san_pham_Service.GetAllProducts(req, resp);
			HttpSession session = req.getSession();
			session.setAttribute("san_pham", list_san_pham);
			
			List<Nguoi_dung> nhan_vien = nguoi_dung_Service.getAllNhanVien(req, resp);
			session.setAttribute("nhan_vien", nhan_vien);
			
			resp.sendRedirect("chucuahang.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		Nguoi_dung_Service nguoi_dung_Service = new Nguoi_dung_Service(new Nguoi_dung_DAO());
		
		if(action != null && action.equals("/login")) {
			try {
				Nguoi_dung nguoi_dung = nguoi_dung_Service.Login(req, resp);
				HttpSession session = req.getSession();
				session.setAttribute("acc", nguoi_dung);
				
				if(nguoi_dung.getPhan_quyen_nguoi_dung().equals(Phan_quyen_nguoi_dung.KHACH_HANG.toString())){
					resp.sendRedirect("trang_chu");
				}
				
				else if(nguoi_dung.getPhan_quyen_nguoi_dung().equals(Phan_quyen_nguoi_dung.CHU_CUA_HANG.toString())){
					resp.sendRedirect("trang_chu_cua_hang");
				}
				
				else if(nguoi_dung.getPhan_quyen_nguoi_dung().equals(Phan_quyen_nguoi_dung.NHAN_VIEN.toString())){
					resp.sendRedirect("trang_chu");
				}
			}
			catch (Exception e) {
				req.setAttribute("message1", e.getMessage());
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			
		}
		
		else if(action != null && action.equals("/sign_up")) {
			try {
				nguoi_dung_Service.Sign_up(req, resp);
				postJsonMessage(resp, "Tạo tài khoản thành công");
				
			} catch (Exception e) {
				postJsonMessage(resp, e.getMessage());
			}
		}
		
	}
	
	private void postJsonMessage( HttpServletResponse resp, String message) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(message);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
}
