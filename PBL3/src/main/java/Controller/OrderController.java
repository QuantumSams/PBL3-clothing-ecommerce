package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.BLL.Service.Order.Order_Service;
import Model.DAL.DAO.implemet.Gio_hang_DAO;
//import Model.DAL.DAO.implemet.Chi_tiet_don_hang_DAO;
import Model.DAL.DAO.implemet.Muc_san_pham_DAO;
import Model.DAL.DAO.implemet.Nguoi_dung_DAO;
import Model.DAL.DAO.implemet.San_pham_DAO;
import Model.DAL.Specification.Implements.Gio_hang.FindCartByID;
//import Model.DAL.Specification.Implements.Chi_tiet_don_hang.FindDetailOrderByIDOrder;
import Model.DAL.Specification.Implements.Muc_san_pham.FindProductItemByID;
import Model.DAL.Specification.Implements.Nguoi_dung.FindNguoiDungByID;
import Model.DAL.Specification.Implements.San_pham.FindProductByID;
//import Model.DTO.Don_Hang.Chi_tiet_don_hang;
import Model.DTO.Don_Hang.Don_hang;
import Model.DTO.Don_Hang.Don_hang_chi_tiet;
import Model.DTO.Don_Hang.Gio_hang;
import Model.DTO.Don_Hang.Muc_sp_don_hang;
import Model.DTO.Nguoi_Dung.Nguoi_dung;
import Model.DTO.San_Pham.Muc_san_pham;
import Model.DTO.San_Pham.San_pham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {	"/create_order", "/khach_hang_huy_don", "/nhan_vien_huy_don" ,
							"/nhan_vien_xac_nhan_don", "/khach_hang_nhan_don",
							"/lich_su_don_tong_quat", "/lich_su_don_chi_tiet", 
							"/xac_nhan_dat_don", "/nhan_duoc_don_hang", "/xem_don_hang_chi_tiet" })
public class OrderController extends HttpServlet{

	private static final long serialVersionUID = 6360439063345108716L;

	Order_Service order_Service = new Order_Service();
	Gio_hang_DAO gio_hang_DAO = new Gio_hang_DAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		
		if(action.equals("/create_order")) {
			
			List<Muc_sp_don_hang> list_muc_san_pham = order_Service.get_item_order_by_id_cart(req, resp);
			
			req.setAttribute("chi_tiet_don_hang", list_muc_san_pham);
			
			req.getRequestDispatcher("order.jsp").forward(req, resp);
		}
		
		else if(action.equals("/lich_su_don_tong_quat")) {
			List<Don_hang> list_don_hang = order_Service.get_order_by_id_user(req, resp);
			
			ObjectMapper mapper = new ObjectMapper();
		    String json = mapper.writeValueAsString(list_don_hang);
		    resp.setContentType("application/json");
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write(json);
		}
		
		else if(action.equals("/xem_don_hang_chi_tiet")) {
			Don_hang_chi_tiet chi_tiet_don_hang = order_Service.get_detail_order_by_ID(req, resp);
			List<Muc_sp_don_hang> muc_san_pham = order_Service.get_item_order_by_id(req, resp);
			
			req.setAttribute("chi_tiet_don_hang", muc_san_pham);
			req.setAttribute("don_hang", chi_tiet_don_hang);
			req.getRequestDispatcher("orderDetail.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		if(action.equals("/create_order")) {
			order_Service.add_order(req, resp);
			postJsonMessage(resp, "Đơn hàng đã được tạo thành công");
		}
		else if(action.equals("/khach_hang_huy_don")) {
			order_Service.khach_hang_xac_nhan(req, resp);
			postJsonMessage(resp, "Đơn hàng đã hủy");
		}
		else if(action.equals("/nhan_vien_huy_don")) {
			order_Service.nhan_vien_xac_nhan(req, resp);
			
			postJsonMessage(resp, "Đơn hàng đã hủy");
		}
		else if(action.equals("/nhan_vien_xac_nhan_don")) {
			order_Service.nhan_vien_xac_nhan(req, resp);
			postJsonMessage(resp, "Đơn hàng xác nhận thành công!");
		}
		else if(action.equals("/khach_hang_nhan_don")) {
			order_Service.khach_hang_xac_nhan(req, resp);
			postJsonMessage(resp,  "Xác nhận đã nhận đon hàng thành công!");
		}
		
	}


	private void postJsonMessage( HttpServletResponse resp, String message) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(message);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
	
}