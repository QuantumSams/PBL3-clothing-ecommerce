package Control;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.BLL.Service.Nguoi_Dung.Nguoi_dung_Service;
import Model.DAL.DAO.implemet.Nguoi_dung_DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/update_password", "/modify_Infor", "/order", "/add_cart"})
@MultipartConfig(
		fileSizeThreshold = 512 * 512 * 10,
		maxFileSize = 1024 *  1024 * 10,
		maxRequestSize = 1024 * 1024 * 100
		)
public class ClientController extends HttpServlet{

	private static final long serialVersionUID = -15287231039588276L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		Nguoi_dung_Service nguoi_dung_Service = new Nguoi_dung_Service(new Nguoi_dung_DAO());
		
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
		else if(action != null && action.equals("/order")) {
		}
		else if(action != null && action.equals("/add_cart")) {
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
