package Control;

import java.io.IOException;

import Service.Nguoi_Dung.Nguoi_dung_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/modify_Infor", "/order", "/add_cart"})
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
		Nguoi_dung_Service nguoi_dung_Service = new Nguoi_dung_Service();
		
		if(action != null && action.equals("/modify_Infor")) {
			nguoi_dung_Service.UpdateInfor(req);
			req.getRequestDispatcher("userInfor.jsp").forward(req, resp);
		}
		else if(action != null && action.equals("/order")) {
		}
		else if(action != null && action.equals("/add_cart")) {
		}	
	}
	
}
