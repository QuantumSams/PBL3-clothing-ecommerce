package Control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import DAO.DAO;
import Entity.Account;

/**
 * Servlet implementation class SignUp
 */

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String phoneNumber = request.getParameter("phoneNumber");
		String repass = request.getParameter("repassword");
		if(!pass.equals(repass)) {
			request.setAttribute("message2", "Mật khẩu không trùng khớp");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			if(!DAO.checkAccount(email, phoneNumber)) {
				pass = Encode.toSHA1(pass);
				DAO.signUP(phoneNumber, email, pass,fullname);
				response.sendRedirect("login.jsp");
				
			}
			else {
				request.setAttribute("message2", "Số điện thoại hoặc email đăng ký đã tồn tại");
				System.out.println("Khong the dang ky");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
}
