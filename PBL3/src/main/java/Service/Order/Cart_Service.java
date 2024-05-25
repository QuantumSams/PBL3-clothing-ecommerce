package Service.Order;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.implemet.Gio_hang_DAO;
import Entity.Don_Hang.Gio_hang;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Cart_Service {
	public void get_cart_by_id_khach_hang(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		int id_khach_hang = Integer.parseInt(req.getParameter("id_khach_hang"));
		
		List<Gio_hang> list_gio_hang = new Gio_hang_DAO().get_list_by_id_khach_hang(id_khach_hang);
		
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(list_gio_hang);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
	
	public void delete_cart_by_id(HttpServletRequest req, HttpServletResponse resp) {
		int id_gio_hang = Integer.parseInt(req.getParameter("id_gio_hang"));
		
		new Gio_hang_DAO().delete_by_id(id_gio_hang);
	}
	
}
