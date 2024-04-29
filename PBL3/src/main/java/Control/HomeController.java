package Control;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Random;

import DAO.AbstractDao;
import Entity.Nguoi_Dung.Nguoi_dung;
import Entity.San_Pham.San_pham;
import Mapper.San_Pham.San_pham_Mapper;
import Service.Nguoi_Dung.Nguoi_dung_Service;
import Service.San_Pham.San_pham_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/trang_chu", "/login", "/logout", "/sign_up"})
public class HomeController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5225303616746645511L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action != null && action.equals("/logout")) {
			logout(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action != null && action.equals("/trang_chu")) {
			load_product(req, resp);
		}
		else if(action != null && action.equals("/login")) {
			login(req, resp);
		}
		else if(action != null && action.equals("/sign_up")) {
			sign_up(req, resp);
		}
		
	}
	
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String user = req.getParameter("username");
		String password = req.getParameter("password");
		
		// lấy tài khoản người dùng
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
	
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();
		session.removeAttribute("acc");
		resp.sendRedirect("index.jsp");
	}
	

	public void sign_up(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String email = request.getParameter("email");
		String passWord = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String phoneNumber = request.getParameter("phoneNumber");
		String repass = request.getParameter("repassword");
		
		if(!passWord.equals(repass)) {
			request.setAttribute("message2", "Mật khẩu không trùng khớp");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			try {
				int id = new Random().nextInt(1000);

				Nguoi_dung nguoi_dung = new Nguoi_dung(id, fullname, true, new Date(0), "", "", phoneNumber, email, "KHACH_HANG");
				nguoi_dung.setPassword(passWord);
				new Nguoi_dung_Service().Dang_ky(nguoi_dung);
				response.sendRedirect("login.jsp");
				
			}
			catch(Exception e){
				request.setAttribute("message2", "Số điện thoại hoặc email đăng ký đã tồn tại");
				System.out.println("Khong the dang ky");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}
	}
	
	public void load_product(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String query = "select from * from san_pham";
		List<San_pham> list_san_pham = new AbstractDao().query(query, new San_pham_Mapper());
		
		for(San_pham sp : list_san_pham) {
			System.out.println(sp.toString());
		}
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
