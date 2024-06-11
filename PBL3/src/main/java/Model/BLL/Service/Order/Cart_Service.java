package Model.BLL.Service.Order;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;


import Model.DAL.DAO.implemet.Gio_hang_DAO;
import Model.DAL.DAO.implemet.Muc_san_pham_DAO;
import Model.DAL.DAO.implemet.San_pham_DAO;
import Model.DAL.Specification.Implements.Gio_hang.FindCartByIDUser;
import Model.DAL.Specification.Implements.Gio_hang.RemoveByID;
import Model.DAL.Specification.Implements.Muc_san_pham.FindProductItemByID;
import Model.DAL.Specification.Implements.San_pham.FindProductByID;
import Model.DTO.Don_Hang.Gio_hang;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Cart_Service {

	public void them_gio_hang(HttpServletRequest req, HttpServletResponse resp) {
		int id_gio_hang = new Random().nextInt();
		int id_khach_hang = Integer.parseInt(req.getParameter("id_khach_hang"));
		int id_mau_sac = Integer.parseInt(req.getParameter("id_mau_sac"));
		int id_size = Integer.parseInt(req.getParameter("id_size"));
		int so_luong = Integer.parseInt(req.getParameter("so_luong"));
		int id_muc_san_pham = Integer.parseInt(req.getParameter("id_muc_san_pham"));
		
		Gio_hang gio_hang = new Gio_hang(id_gio_hang, id_khach_hang, id_muc_san_pham, so_luong);
		System.out.println(gio_hang.toString());
		new Gio_hang_DAO().add(gio_hang);
	}
	
	public void get_cart_by_id_khach_hang(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		int id_khach_hang = Integer.parseInt(req.getParameter("id_khach_hang"));
		
		Muc_san_pham_DAO muc_san_pham_DAO = new Muc_san_pham_DAO();
		San_pham_DAO san_pham_DAO = new San_pham_DAO();
		
		List<Gio_hang> list_gio_hang = new Gio_hang_DAO().findBySpacification(new FindCartByIDUser(id_khach_hang));
		for(Gio_hang gh : list_gio_hang) {
			gh.setMuc_san_pham(muc_san_pham_DAO.findBySpacification(new FindProductItemByID(gh.getId_muc_san_pham())).get(0));
			gh.getMuc_san_pham().setSan_pham(san_pham_DAO.findBySpacification(new FindProductByID(gh.getMuc_san_pham().getId_san_pham())).get(0));
			gh.getMuc_san_pham().get_ten_san_pham();
		}
		
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(list_gio_hang);
	    System.out.println(json);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
	
	public void delete_cart_by_id(HttpServletRequest req, HttpServletResponse resp) {
		int id_gio_hang = Integer.parseInt(req.getParameter("id_gio_hang"));
		
		new Gio_hang_DAO().removeBySpacification(new RemoveByID(id_gio_hang));;
	}
	
}
