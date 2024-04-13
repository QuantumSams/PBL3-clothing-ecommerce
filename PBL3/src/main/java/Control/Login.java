package Control;

import java.io.IOException;
import java.util.List;

import DAO.AbstractDao;
import DAO.implemet.Dang_nhap_DAO;
import Entity.Nguoi_Dung.Nguoi_dung;
import Mapper.Nguoi_Dung.Nguoi_dung_Mapper;
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
		int id = 0;
		Nguoi_dung acc = null;
		
		try {
			
			String sql1 = "SELECT * FROM thong_tin_dang_nhap WHERE (so_dien_thoai = ? OR email = ?) AND mat_khau = ? ";
			
			id = new Dang_nhap_DAO().getPrimaryKey(sql1, user, user, password);
			
			String sql2 = 	" SELECT thong_tin_dang_nhap.id, ho_ten, gioi_tinh, ngay_sinh, dia_chi, anh_dai_dien, thong_tin_dang_nhap.so_dien_thoai, thong_tin_dang_nhap.email, phan_quyen_nguoi_dung.ten_phan_quyen"
							+ " FROM thong_tin_nguoi_dung" 
							+ " INNER JOIN thong_tin_dang_nhap ON thong_tin_nguoi_dung.id = thong_tin_dang_nhap.id"
							+ " INNER JOIN phan_quyen_nguoi_dung ON phan_quyen_nguoi_dung.id = thong_tin_dang_nhap.id_phan_quyen_nguoi_dung"
							+ " WHERE thong_tin_dang_nhap.id = ? ";
			List<Nguoi_dung> l = new AbstractDao().query(sql2, new Nguoi_dung_Mapper(), id);
			System.out.println(l.size());
			if(l.size() != 0)
				acc = l.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(acc == null) {
				req.setAttribute("message1", "Sai tài khoản hoặc mật khẩu");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				System.out.println("Đăng nhập không thành công");
			}
			else {
				HttpSession session = req.getSession();
				session.setAttribute("acc", acc);
				System.out.println("Đăng nhập thành công");
				resp.sendRedirect("index.jsp");
			}
		}
}
