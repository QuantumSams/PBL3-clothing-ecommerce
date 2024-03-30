package Control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Entity.Account;
import DAO.DAO;
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
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		String image = request.getParameter("image");;
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute("acc");
		acc.setPhoneNumber(phoneNumber);
		acc.setAddress(address);
		acc.setBirth(birth);
		acc.setFullName(fullName);
		acc.setEmail(email);
		DAO.updateInfor(id, fullName, 1, birth, address, image);
		session.setAttribute("acc",acc);
		
		request.getRequestDispatcher("userInfor.jsp").forward(request, response);
	}

}
