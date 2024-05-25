package Control;

import java.io.IOException;

import Model.BLL.Service.Order.Order_Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {	"/create_order", "/update_order", 
							"/lich_su_don_tong_quat", "/lich_su_don_chi_tiet", 
							"/xac_nhan_dat_don", "/nhan_duoc_don_hang" })
public class OrderController extends HttpServlet{

	private static final long serialVersionUID = 6360439063345108716L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		Order_Service order_Service = new Order_Service();
		
		if(action.equals("/create_order")) {
			order_Service.create_order(req, resp);
			req.getRequestDispatcher("order.jsp").forward(req, resp);
		}
		
		else if(action.equals("/lich_su_don_tong_quat")) {
			order_Service.get_list_lich_su_don_hang(req, resp);
		}
		
		else if(action.equals("/lich_su_don_chi_tiet")) {
			order_Service.get_lich_su_don_hang(req, resp);
			req.getRequestDispatcher("lishsudon.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		Order_Service order_Service = new Order_Service();
		
		if(action.equals("/create_order")) {
			order_Service.add_order(req, resp);
		}
		else if(action.equals("/update_order")) {
			//order_Service.update_order(req, resp);
		}
		else if(action.equals("/xac_nhan_dat_don")) {
			//order_Service.xac_nhan_dat_don(req, resp);
		}
		else if(action.equals("/nhan_duoc_don_hang")) {
			//order_Service.nhan_duoc_don_hang(req, resp);
		}
	}

}
