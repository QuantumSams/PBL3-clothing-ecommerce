package Control;

import java.io.IOException;
import java.util.List;

import DAO.implemet.Nguoi_dung_DAO;
import DAO.implemet.San_pham_DAO;
import Entity.Nguoi_Dung.Nguoi_dung;
import Entity.San_Pham.San_pham;
import Service.Nguoi_Dung.Nguoi_dung_Service;
import Service.San_Pham.San_pham_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/login"})
public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.sendRedirect("login.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String user = req.getParameter("username");
		String password = req.getParameter("password");
		password = Encode.toSHA1(password);
		
		Nguoi_dung acc = new Nguoi_dung_Service().LayTaiKhoan(user, password);
		
		if(acc == null) {
			req.setAttribute("message1", "Sai tài khoản hoặc mật khẩu");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			System.out.println("Đăng nhập không thành công");
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("acc", acc);
			System.out.println("Đăng nhập thành công");
				
			List<San_pham> list_san_pham = new San_pham_Service().LayTatCaSanPham();
				
			if(list_san_pham != null) session.setAttribute("san_pham", list_san_pham);
				
			System.out.println("Lấy sản phẩm thành công");
			resp.sendRedirect("index.jsp");
		}
	}
}
