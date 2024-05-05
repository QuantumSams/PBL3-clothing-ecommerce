package Service.Order;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.implemet.Don_hang_DAO;
import DataStructures.Pair;
import Entity.Don_Hang.Don_hang;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Order_Service {
	public final String doi_xac_nhan = "Đợi xác nhận";
	public final String dang_van_chuyen = "Đang vận chuyển";
	public final String da_xac_nhan_don = "Đã xác nhận đơn hàng";
	
	Don_hang_DAO don_hang_DAO;
	
	public Order_Service() {
		don_hang_DAO = new Don_hang_DAO();
	}
	
	public void add_order(HttpServletRequest req, HttpServletResponse resp) {
		
		int id_order = 0;
		int tong_tien = 0;
		int id_khach_hang = 0;
		int id_nhan_vien = 0;
		String dia_chi_giao_dich = "";
		long now = new java.util.Date().getTime();
		Date ngay_gio_dat = new Date(now);
		Date ngay_gio_nhan = new Date(now);
		String trang_thai_don_hang = doi_xac_nhan;
		
		// <id_muc_san_pham, so_luong>
		List<Pair<Integer, Integer>> list_muc_san_pham = new ArrayList<>();
		Don_hang don_hang = new Don_hang(id_order, tong_tien, id_khach_hang, id_nhan_vien, dia_chi_giao_dich, ngay_gio_dat, ngay_gio_nhan, trang_thai_don_hang);
	
		don_hang.setList_muc_san_pham(list_muc_san_pham);
		
		don_hang_DAO.add_order(don_hang);
	}
	
	public void update_order(HttpServletRequest req, HttpServletResponse resp) {
		
		Don_hang don_hang = new Don_hang();
		
		don_hang_DAO.update_order(don_hang);
		
	}
	
	public List<Don_hang> get_all_order(HttpServletRequest req, HttpServletResponse resp) {
		
		return don_hang_DAO.select_order();
	}
	
	public Don_hang get_order_by_ID(HttpServletRequest req, HttpServletResponse resp) {
		return don_hang_DAO.select_order(0);
	}
	
	private void postMessageJson( HttpServletResponse resp, String message) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(message);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
}
