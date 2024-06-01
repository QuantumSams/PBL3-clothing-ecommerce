package Controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.BLL.Service.Order.Cart_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {	"/don_hang_tong_quat", "/xoa_gio_hang", "/them_gio_hang"})
public class CartController extends HttpServlet{

	private static final long serialVersionUID = -7433472997820596567L;

	Cart_Service cart_Service = new Cart_Service();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action.equals("/don_hang_tong_quat")) {
			cart_Service.get_cart_by_id_khach_hang(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action.equals("/xoa_gio_hang")) {
			cart_Service.delete_cart_by_id(req, resp);
			postMessageJson(resp, "Đã xóa sản phẩm khỏi giỏ hàng");
		}
		else if(action.equals("/them_gio_hang")) {
			cart_Service.them_gio_hang(req, resp);
			postMessageJson(resp, "Sản phẩm được thêm vào giỏ hàng thành công");
		}
	}

	private void postMessageJson( HttpServletResponse resp, String message) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(message);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
}
