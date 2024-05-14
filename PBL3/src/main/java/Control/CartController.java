package Control;

import java.io.IOException;

import Service.Order.Cart_Service;
import Service.Order.Order_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {	"/don_hang_tong_quat", "/xoa_gio_hang"})
public class CartController extends HttpServlet{

	private static final long serialVersionUID = -7433472997820596567L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		Cart_Service cart_Service = new Cart_Service();
		
		if(action.equals("/don_hang_tong_quat")) {
			cart_Service.get_cart_by_id_khach_hang(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		Cart_Service cart_Service = new Cart_Service();
		
		if(action.equals("/xoa_gio_hang")) {
			cart_Service.delete_cart_by_id(req, resp);
		}
	}
	
}
