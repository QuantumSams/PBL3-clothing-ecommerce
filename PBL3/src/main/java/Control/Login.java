package Control;

import java.io.IOException;

import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= {"/login"})
public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.sendRedirect("login.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			int ID = DAO.getIDDangNhap(name, password);
			Cookie cookie = new Cookie("username", name);
			cookie.setMaxAge(30);
			resp.addCookie(cookie);
			System.out.println("Dang nhap thanh cong");
			resp.sendRedirect("/PBL3/welcome");
			
		} catch (Exception e) {
			System.out.println(e);
			resp.sendRedirect("/PBL3/index.html");
		}
	}

}
