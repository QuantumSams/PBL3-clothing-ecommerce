package Control;

import java.io.IOException;

import Service.Order.Order_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/create_order", "/update_order"})
public class OrderController extends HttpServlet{

	private static final long serialVersionUID = 6360439063345108716L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		Order_Service order_Service = new Order_Service();
		
		if(action.equals("/create_order")) {
			order_Service.add_order(req, resp);
		}
		else if(action.equals("/update_order")) {
			order_Service.update_order(req, resp);
		}
	}
	
}
