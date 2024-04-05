package Control;

import jakarta.servlet.ServletException;
import Entity.Nguoi_Dung.Khach_hang;
import Entity.Nguoi_Dung.Nguoi_dung;
import Entity.Nguoi_Dung.Phan_quyen_nguoi_dung;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import DAO.DAO;
import DAO.DAO_Nguoi_dung;
import Entity.Account;
import java.util.Random;
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
			try {
				int id = new Random().nextInt(1000);

				Khach_hang khhang = new Khach_hang(id,fullname,true ,new Date(0),null, null, phoneNumber, email,Phan_quyen_nguoi_dung.KHACH_HANG.toString() );
				DAO_Nguoi_dung.tao_tai_khoan(khhang, Encode.toSHA1(pass));
				response.sendRedirect("login.jsp");
			}
			catch(Exception e){
				request.setAttribute("message2", "Số điện thoại hoặc email đăng ký đã tồn tại");
				System.out.println("Khong the dang ky");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}
	}
}
