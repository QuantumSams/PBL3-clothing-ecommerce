package Controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.BLL.Service.Nguoi_Dung.Nguoi_dung_Service;
import Model.DAL.DAO.implemet.Nguoi_dung_DAO;
import Model.DTO.Nguoi_Dung.Nguoi_dung;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/update_password", "/load_nhan_vien_by_json", 
						"/thong_tin_nhan_vien", "/modify_Infor", 
						"/remove_User", "/tao_nhan_vien"})
@MultipartConfig(
		fileSizeThreshold = 512 * 512 * 10,
		maxFileSize = 1024 *  1024 * 10,
		maxRequestSize = 1024 * 1024 * 100
		)
public class UserController extends HttpServlet{

	private static final long serialVersionUID = -15287231039588276L;
	
	Nguoi_dung_Service nguoi_dung_Service = new Nguoi_dung_Service(new Nguoi_dung_DAO());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action != null && action.equals("/tao_nhan_vien")) {
			req.getRequestDispatcher("usercreate.jsp").forward(req, resp);
		}
		else if(action != null && action.equals("/load_nhan_vien_by_json")) {
			List<Nguoi_dung> list_nhan_vien = nguoi_dung_Service.getNhanVienByName(req, resp);
			
			ObjectMapper mapper = new ObjectMapper();
		    String json = mapper.writeValueAsString(list_nhan_vien);
		    resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write(json);
		}
		else if(action != null && action.equals("/thong_tin_nhan_vien")) {
			List<Nguoi_dung> list = nguoi_dung_Service.getNguoiDungByID(req, resp);
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(-1);
			session.setAttribute("acc", list.get(0));
			req.getRequestDispatcher("userInfor.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action != null && action.equals("/modify_Infor")) {
			try {
				nguoi_dung_Service.UpdateInformation(req, resp);
				postJsonMessage(resp, "Cập nhật thông tin tài khoản thành công");
			} catch (Exception e) {
				postJsonMessage(resp, e.getMessage());
			}
		}
		else if(action != null && action.equals("/update_password")) {
			try {
				nguoi_dung_Service.UpdatePassword(req, resp);
				postJsonMessage(resp, "Cập nhật mật khẩu tài khoản thành công");
			} catch (Exception e) {
				postJsonMessage(resp, e.getMessage());
			}
		}
		
		else if(action != null && action.equals("/remove_User")) {
			try {
				nguoi_dung_Service.remove_User(req, resp);
				postJsonMessage(resp, "Xóa tài khoản thành công");
			} catch (Exception e) {
				postJsonMessage(resp, e.getMessage());
			}
		}
		
		else if(action != null && action.equals("/tao_nhan_vien")) {
			try {
				System.out.println("tao nhan vien");
				nguoi_dung_Service.tao_nhan_vien(req, resp);
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
