package Service.Order;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.implemet.Don_hang_DAO;
import DAO.implemet.Nguoi_dung_DAO;
import DAO.implemet.San_pham_DAO;
import DataStructures.Pair;
import Entity.Don_Hang.Don_hang;
import Entity.Nguoi_Dung.Nguoi_dung;
import Entity.San_Pham.Muc_san_pham;
import Entity.San_Pham.San_pham;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Order_Service {
	public final String doi_xac_nhan = "Đợi xác nhận đơn hàng";
	public final String dang_van_chuyen = "Đang vận chuyển";
	public final String da_xac_nhan_don = "Đã nhận đươc đơn hàng";
	
	Don_hang_DAO don_hang_DAO;
	San_pham_DAO muc_san_pham_DAO;
	Nguoi_dung_DAO nguoi_dung_DAO;
	
	public Order_Service() {
		don_hang_DAO = new Don_hang_DAO();
		muc_san_pham_DAO = new San_pham_DAO();
		nguoi_dung_DAO = new Nguoi_dung_DAO();
	}
	
	public void add_order(HttpServletRequest req, HttpServletResponse resp) {
		
		int id_order = new Random().nextInt();System.out.println(id_order);
		int tong_tien = Integer.parseInt(req.getParameter("tong_tien"));
		int id_khach_hang = Integer.parseInt(req.getParameter("id_khach_hang"));;
		int id_nhan_vien = 0;
		String so_dien_thoai = req.getParameter("so_dien_thoai");
		String dia_chi_giao_dich = req.getParameter("dia_chi");
		long now = new java.util.Date().getTime();
		Date ngay_gio_dat = new Date(now);
		Date ngay_gio_nhan = new Date(now);
		String ghi_chu = req.getParameter("ghi_chu");
		String trang_thai_don_hang = doi_xac_nhan;
		
		// <id_muc_san_pham, so_luong>
		String muc_san_pham = req.getParameter("muc_san_pham");
		System.out.println(muc_san_pham);
		ObjectMapper mapper = new ObjectMapper();
		
		Muc_san_pham[] mucSanPhams = null;
		try {
			mucSanPhams = mapper.readValue(muc_san_pham, Muc_san_pham[].class);
		} catch (JsonProcessingException e) {}
		
		
		System.out.println(mucSanPhams.length);
		
		List<Pair<Integer, Integer>> list_muc_san_pham = new ArrayList<>();
		Don_hang don_hang = new Don_hang(id_order, tong_tien, id_khach_hang, id_nhan_vien, so_dien_thoai, dia_chi_giao_dich, ngay_gio_dat, ngay_gio_nhan, ghi_chu, trang_thai_don_hang);
		don_hang.setList_muc_san_pham(list_muc_san_pham);
		System.out.println(don_hang.toString());
		
		don_hang_DAO.add_order(don_hang);
	}
	
	public void load_order(HttpServletRequest req, HttpServletResponse resp) {
		
		List<Integer> list_san_phamm_id = new ArrayList<>();
		
		list_san_phamm_id.add(1);
		list_san_phamm_id.add(2);
		list_san_phamm_id.add(3);
		list_san_phamm_id.add(4);
		
		List<Muc_san_pham> muc_san_pham = new ArrayList<>();
		for(int id : list_san_phamm_id) {
			Muc_san_pham muc = muc_san_pham_DAO.getMuc_san_pham(id);
			muc.get_ten_san_pham();
			muc_san_pham.add(muc);
			System.out.println(muc.getTen_san_pham());
		}
		
		req.setAttribute("muc_san_pham", muc_san_pham);
		
		int id = 237;
		Nguoi_dung nguoi_dung = nguoi_dung_DAO.Get_by_ID(id);
		req.setAttribute("acc", nguoi_dung);
		
	}
	
	public void get_lich_su_don_hang(HttpServletRequest req, HttpServletResponse resp) {
		int id = 1;
		
		Don_hang don_hang = don_hang_DAO.select_order(id);
		
		List<Pair<Muc_san_pham, Integer>> list_san_pham_mua = new ArrayList<Pair<Muc_san_pham,Integer>>();
		
		for(int i = 0; i < don_hang.getList_muc_san_pham().size(); ++i) {
			
			int id_muc_san_pham = don_hang.getList_muc_san_pham().get(i).getKey();
			int so_luong = don_hang.getList_muc_san_pham().get(i).getValue();
			
			Muc_san_pham muc_san_pham =  muc_san_pham_DAO.getMuc_san_pham(id_muc_san_pham);
			muc_san_pham.get_ten_san_pham();
			
			list_san_pham_mua.add(new Pair<Muc_san_pham, Integer>(
							muc_san_pham, 
							so_luong
					));
		}
		
		Nguoi_dung nguoi_dung = nguoi_dung_DAO.Get_by_ID(don_hang.getId_khach_hang());
		
		req.setAttribute("khach_hang", nguoi_dung);
		req.setAttribute("don_hang", don_hang);
		req.setAttribute("list_san_pham_mua", list_san_pham_mua);
		
	}
	
	public void update_order(HttpServletRequest req, HttpServletResponse resp) {
		
		Don_hang don_hang = new Don_hang();
		
		don_hang_DAO.update_order(don_hang);
		
	}
	
	public void xac_nhan_dat_don(HttpServletRequest req, HttpServletResponse resp) {
		
		int id_don_hang = 1;
		int id_nhan_vien = 1;
		
		don_hang_DAO.update_order(id_don_hang, id_nhan_vien, dang_van_chuyen);
		
	}
	
	public void nhan_duoc_don_hang(HttpServletRequest req, HttpServletResponse resp) {
		
		int id_don_hang = 1;
		long now = new java.util.Date().getTime();
		Date currentDate = new Date(now);
		don_hang_DAO.update_order(id_don_hang, currentDate, da_xac_nhan_don);
		
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
