package Control;

import java.io.IOException;

import DAO.DAO_Nguoi_dung;
import Entity.Nguoi_Dung.Khach_hang;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class modifyInfor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyInfor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String phoneNumber =  request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String fullName = request.getParameter("fullName");
		System.out.println(fullName);
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		String image = request.getParameter("image");
		HttpSession session = request.getSession();
		// thay doi account thanh nguoi_dung
		Khach_hang acc = (Khach_hang)session.getAttribute("acc");
		acc.setSo_dien_thoai(phoneNumber);
		acc.setDia_chi(address);
		acc.setNgay_sinh(birth);
		acc.setHo_ten(fullName);
		acc.setEmail(email);
		try {
			DAO_Nguoi_dung.cap_nhat_tai_khoan(acc);
		} catch (Exception e) {
			System.out.println("Khong the cap nhat tai khona nguoi dung");
		}
		session.setAttribute("acc",acc);
		
		request.getRequestDispatcher("userInfor.jsp").forward(request, response);
	}

}
