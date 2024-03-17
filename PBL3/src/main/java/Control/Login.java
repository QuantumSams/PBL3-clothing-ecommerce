package Control;

import java.io.IOException;


import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Entity.Account;

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
		Account acc = DAO.login(user, password);
			if(acc == null) {
				req.setAttribute("message1", "Sai tài khoản hoặc mật khẩu");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				System.out.print("OKK");
			}
			else {
				HttpSession session = req.getSession();
				session.setAttribute("acc", acc );
				System.out.print("OK");
				resp.sendRedirect("index.jsp");
			}
		}
}
