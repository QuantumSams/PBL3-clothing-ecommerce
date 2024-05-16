package Service.Order;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.implemet.Don_hang_DAO;
import DAO.implemet.Gio_hang_DAO;
import DAO.implemet.Nguoi_dung_DAO;
import DAO.implemet.San_pham_DAO;
import DataStructures.Pair;
import Entity.Don_Hang.Don_hang;
import Entity.Don_Hang.Gio_hang;
import Entity.Don_Hang.Lich_su_don_hang;
import Entity.Nguoi_Dung.Nguoi_dung;
import Entity.San_Pham.Muc_san_pham;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Order_Service {
	public final String doi_xac_nhan = "Đợi xác nhận đơn hàng";
	public final String dang_van_chuyen = "Đang vận chuyển";
	public final String da_xac_nhan_don = "Đã nhận đươc đơn hàng";
	
	Don_hang_DAO don_hang_DAO;
	San_pham_DAO muc_san_pham_DAO;
	Nguoi_dung_DAO nguoi_dung_DAO;
	Gio_hang_DAO gio_hang_DAO;
	
	public Order_Service() {
		don_hang_DAO = new Don_hang_DAO();
		muc_san_pham_DAO = new San_pham_DAO();
		nguoi_dung_DAO = new Nguoi_dung_DAO();
		gio_hang_DAO = new Gio_hang_DAO();
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
		String muc_san_pham = req.getParameter("muc_san_pham");
		String so_luong = req.getParameter("so_luong");
		
		List<Pair<Integer, Integer>> list_muc_san_pham = new ArrayList<>();
		
		try {
			List<Integer> sanPhamValues = new ObjectMapper().readValue(muc_san_pham, new TypeReference<List<Integer>>() {});
			List<Integer> soLuongValues = new ObjectMapper().readValue(so_luong, new TypeReference<List<Integer>>() {});
			for(int i = 0; i < sanPhamValues.size(); ++i) {
				list_muc_san_pham.add(new Pair<Integer, Integer>(sanPhamValues.get(i), soLuongValues.get(i)));
				
				System.out.println(sanPhamValues.get(i) + "  " + soLuongValues.get(i));
			}
		} catch (JsonProcessingException e) {}
		
		
		Don_hang don_hang = new Don_hang(id_order, tong_tien, id_khach_hang, id_nhan_vien, so_dien_thoai, dia_chi_giao_dich, ngay_gio_dat, ngay_gio_nhan, ghi_chu, trang_thai_don_hang);
		don_hang.setList_muc_san_pham(list_muc_san_pham);
		System.out.println(don_hang.toString());
		don_hang_DAO.add_order(don_hang);
	}
	
	public void create_order(HttpServletRequest req, HttpServletResponse resp) {
		
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
	
	public void get_list_lich_su_don_hang (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id_khach_hang = Integer.parseInt(req.getParameter("id_khach_hang"));
		
		List<Don_hang>  don_hang = don_hang_DAO.select_order_by_id_khach_hang(id_khach_hang);
		
		List<Lich_su_don_hang> ls = new ArrayList<>();
		
		for(Don_hang dh : don_hang) {
			
			int id_don_hang = dh.getId_hoa_don();
			Date ngay_dat = dh.getNgay_gio_dat_don_hang();
			System.out.println(ngay_dat);
			int so_tien = dh.getTong_tien();
			int so_luong_san_pham = 0; 
			for(Pair<Integer, Integer> muc_san_pham : dh.getList_muc_san_pham()) {
				so_luong_san_pham += muc_san_pham.getValue();
			}
			String trang_thai_don_hang = dh.getTrang_thai_don_hang();
			
			int so_sao_danh_gia;
			try {
				so_sao_danh_gia = don_hang_DAO.get_danh_gia_don_hang(dh.getId_hoa_don()).getSo_sao();
			} catch (Exception e) {
				so_sao_danh_gia = -1;
			}
			
			ls.add(new Lich_su_don_hang(id_don_hang, 
										ngay_dat,
										so_tien,
										so_luong_san_pham,
										trang_thai_don_hang,
										so_sao_danh_gia));
		}
		
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(ls);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
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
	
	public void them_gio_hang(HttpServletRequest req, HttpServletResponse resp) {
		int id_gio_hang = new Random().nextInt();
		int id_khach_hang = Integer.parseInt(req.getParameter("id_khach_hang"));
		int id_mau_sac = Integer.parseInt(req.getParameter("id_mau_sac"));
		int id_size = Integer.parseInt(req.getParameter("id_size"));
		int so_luong = Integer.parseInt(req.getParameter("so_luong"));
		int id_muc_san_pham = Integer.parseInt(req.getParameter("id_muc_san_pham"));
		
		Gio_hang gio_hang = new Gio_hang(id_gio_hang, id_khach_hang, id_muc_san_pham, so_luong);
		System.out.println(gio_hang.toString());
		gio_hang_DAO.add(gio_hang);
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
