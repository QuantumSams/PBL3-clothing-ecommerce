package Model.BLL.Service.Order;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import DataStructures.Pair;
import DataStructures.RandomID;
import Model.DAL.DAO.implemet.Don_hang_DAO;
import Model.DAL.DAO.implemet.Don_hang_chi_tiet_DAO;
import Model.DAL.DAO.implemet.Gio_hang_DAO;
import Model.DAL.DAO.implemet.Muc_san_pham_DAO;
import Model.DAL.DAO.implemet.Muc_sp_don_hang_DAO;
import Model.DAL.DAO.implemet.Nguoi_dung_DAO;
import Model.DAL.DAO.implemet.San_pham_DAO;
import Model.DAL.Specification.Implements.Don_hang.FindDetailOrderByIDOrder;
import Model.DAL.Specification.Implements.Don_hang.FindItemOrderByIDCart;
import Model.DAL.Specification.Implements.Don_hang.FindItemOrderByIDOrder;
import Model.DAL.Specification.Implements.Don_hang.FindOrderByIDOrder;
import Model.DAL.Specification.Implements.Don_hang.FindOrderByIDUser;
import Model.DAL.Specification.Implements.Don_hang.FindOrderByStatus;
import Model.DAL.Specification.Implements.Gio_hang.FindCartByID;
import Model.DAL.Specification.Implements.Gio_hang.RemoveByID;
import Model.DAL.Specification.Implements.Muc_san_pham.FindProductItemByID;
import Model.DAL.Specification.Implements.Nguoi_dung.FindNguoiDungByID;
import Model.DAL.Specification.Implements.San_pham.FindProductByID;
import Model.DTO.Don_Hang.Don_hang;
import Model.DTO.Don_Hang.Don_hang_chi_tiet;
import Model.DTO.Don_Hang.Gio_hang;
import Model.DTO.Don_Hang.Muc_sp_don_hang;
import Model.DTO.Nguoi_Dung.Nguoi_dung;
import Model.DTO.San_Pham.Muc_san_pham;
import Model.DTO.San_Pham.San_pham;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Order_Service {
	public final String doi_xac_nhan = "Đợi xác nhận đơn hàng";
	public final String dang_van_chuyen = "Đang vận chuyển";
	public final String da_xac_nhan_don = "Đã nhận được đơn hàng";
	public final String khach_huy_don = "Khách hàng đã hủy đơn";
	public final String nhan_vien_huy_don = "Nhân viên đã hủy đơn";
	
	Don_hang_DAO don_hang_DAO;
	Muc_san_pham_DAO muc_san_pham_DAO;
	Nguoi_dung_DAO nguoi_dung_DAO;
	Gio_hang_DAO gio_hang_DAO;
	Don_hang_chi_tiet_DAO don_hang_chi_tiet_DAO;
	San_pham_DAO san_pham_DAO;
	Muc_sp_don_hang_DAO muc_sp_don_hang_DAO;
	public Order_Service() {
		don_hang_DAO = new Don_hang_DAO();
		muc_san_pham_DAO = new Muc_san_pham_DAO();
		nguoi_dung_DAO = new Nguoi_dung_DAO();
		gio_hang_DAO = new Gio_hang_DAO();
		don_hang_chi_tiet_DAO = new Don_hang_chi_tiet_DAO();
		san_pham_DAO = new San_pham_DAO();
		muc_sp_don_hang_DAO = new Muc_sp_don_hang_DAO();
	}
	
	public void add_order(HttpServletRequest req, HttpServletResponse resp) {
		
		int id_order = new RandomID().ran();
		int id_khach_hang = Integer.parseInt(req.getParameter("id_khach_hang"));;
		String so_dien_thoai = req.getParameter("so_dien_thoai");
		String dia_chi_giao_dich = req.getParameter("dia_chi");
		long now = new java.util.Date().getTime();
		Date ngay_gio_dat = new Date(now);
		String ghi_chu = req.getParameter("ghi_chu");
		String trang_thai_don_hang = doi_xac_nhan;
		String muc_san_pham = req.getParameter("muc_san_pham");
		String so_luong = req.getParameter("so_luong");
		String list_gio_hang = req.getParameter("gio_hang");
		String[] tmp = list_gio_hang.split(" ");
		
		Don_hang_chi_tiet don_hang = new Don_hang_chi_tiet();
		don_hang.setId_don_hang(id_order);
		don_hang.setId_khach_hang(id_khach_hang);
		don_hang.setSo_dien_thoai(so_dien_thoai);
		don_hang.setDia_chi(dia_chi_giao_dich);
		don_hang.setThoi_gian_dat(ngay_gio_dat);
		don_hang.setGhi_chu(ghi_chu);
		don_hang.setTrang_thai_don_hang(trang_thai_don_hang);
		
		don_hang_chi_tiet_DAO.add(don_hang);
		
		try {
			List<Integer> sanPhamValues = new ObjectMapper().readValue(muc_san_pham, new TypeReference<List<Integer>>() {});
			List<Integer> soLuongValues = new ObjectMapper().readValue(so_luong, new TypeReference<List<Integer>>() {});
			
			for(int i = 0; i < sanPhamValues.size(); ++i) {
				
				Muc_san_pham muc = muc_san_pham_DAO.findBySpacification(new FindProductItemByID(sanPhamValues.get(0))).get(0);
				
				Muc_sp_don_hang muc_sp_don_hang = new Muc_sp_don_hang();
				muc_sp_don_hang.setId_don_hang(id_order);
				muc_sp_don_hang.setId_muc_san_pham(muc.getId_muc_san_pham());
				muc_sp_don_hang.setSo_luong(soLuongValues.get(i));
				muc_sp_don_hang.setGia(muc.getGia_tien());
				
				muc_sp_don_hang_DAO.add(muc_sp_don_hang);
			}
		} catch (JsonProcessingException e) {}
		
		for(String gio_hang : tmp) {
			System.out.println("Remove gio hang: " + gio_hang);
			gio_hang_DAO.removeBySpacification(new RemoveByID(Integer.parseInt(gio_hang)));
		}
	}
	
	public void nhan_vien_xac_nhan(HttpServletRequest req, HttpServletResponse resp) {
		int id_don_hang = Integer.parseInt(req.getParameter("id_don_hang"));
		int id_nhan_vien = Integer.parseInt(req.getParameter("id_nhan_vien"));
		String trang_thai_don_hang = req.getParameter("trang_thai_don_hang");
		
		if(trang_thai_don_hang.equals("xac_nhan")) {
			trang_thai_don_hang = dang_van_chuyen;
		}
		else {
			trang_thai_don_hang = nhan_vien_huy_don;
		}
		
		Don_hang_chi_tiet don_hang_chi_tiet = don_hang_chi_tiet_DAO.findBySpacification(new FindDetailOrderByIDOrder(id_don_hang)).get(0);
		
		don_hang_chi_tiet.setId_nhan_vien(id_nhan_vien);
		don_hang_chi_tiet.setTrang_thai_don_hang(trang_thai_don_hang);
		long now = new java.util.Date().getTime();
		Date ngay_gio_nhan = new Date(now);
		don_hang_chi_tiet.setThoi_gian_nhan(ngay_gio_nhan);
		
		don_hang_chi_tiet_DAO.update(don_hang_chi_tiet);
	}
	
	public void khach_hang_xac_nhan(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id_don_hang = Integer.parseInt(req.getParameter("id_don_hang"));
		String trang_thai_don_hang = req.getParameter("trang_thai_don_hang");
		
		System.out.println("id don hang" + id_don_hang);
		
		if(trang_thai_don_hang.equals("xac_nhan")) {
			trang_thai_don_hang = da_xac_nhan_don;
		}
		else {
			trang_thai_don_hang = khach_huy_don;
		}
		
		Don_hang_chi_tiet don_hang_chi_tiet = new Don_hang_chi_tiet();
		
		don_hang_chi_tiet.setId_don_hang(id_don_hang);
		don_hang_chi_tiet.setTrang_thai_don_hang(trang_thai_don_hang);
		long now = new java.util.Date().getTime();
		Date ngay_gio_nhan = new Date(now);
		don_hang_chi_tiet.setThoi_gian_nhan(ngay_gio_nhan);
		
		don_hang_chi_tiet_DAO.updateKH(don_hang_chi_tiet);
		
		
	}
	
	public List<Muc_sp_don_hang> get_item_order_by_id_cart(HttpServletRequest req, HttpServletResponse resp) {
		String list_gio_hang = req.getParameter("gio_hang");
		String[] tmp = list_gio_hang.split(" ");
		List<Muc_sp_don_hang> list_muc_san_pham = new ArrayList<>();
		
		for(String i : tmp) {
			Gio_hang gio_hang = gio_hang_DAO.findBySpacification(new FindCartByID(Integer.parseInt(i))).get(0);
			System.out.println(gio_hang.getId_gio_hang());
			Muc_sp_don_hang muc_sp_don_hang = muc_sp_don_hang_DAO.findBySpacification(new FindItemOrderByIDCart(gio_hang.getId_gio_hang())).get(0);
			list_muc_san_pham.add(muc_sp_don_hang);
		}
		
		return list_muc_san_pham;
	}
	
	public List<Don_hang> get_all_order(HttpServletRequest req, HttpServletResponse resp) {
		
		return don_hang_DAO.getALL();
	}
	
	public Don_hang_chi_tiet get_detail_order_by_ID(HttpServletRequest req, HttpServletResponse resp) {
		
		int id_don_hang = Integer.parseInt(req.getParameter("id_don_hang"));
		
		return don_hang_chi_tiet_DAO.findBySpacification(new FindDetailOrderByIDOrder(id_don_hang)).get(0);
	}
	
	public List<Don_hang> get_order_by_state(HttpServletRequest req, HttpServletResponse resp){
		String state = req.getParameter("state");
		return don_hang_DAO.findBySpacification(new FindOrderByStatus(state));
	}
	
	public List<Don_hang> get_order_by_state(String state){
		return don_hang_DAO.findBySpacification(new FindOrderByStatus(state));
	}
	
	public List<Don_hang> get_order_by_id_user(HttpServletRequest req, HttpServletResponse resp){
		int id_user = Integer.parseInt(req.getParameter("id_user"));
		
		return don_hang_DAO.findBySpacification(new FindOrderByIDUser(id_user));
	}
	
	public List<Muc_sp_don_hang> get_item_order_by_id(HttpServletRequest req, HttpServletResponse resp)
	{
		int id_don_hang = Integer.parseInt(req.getParameter("id_don_hang"));
		
		return new Muc_sp_don_hang_DAO().findBySpacification(new FindItemOrderByIDOrder(id_don_hang));
	}
	
	private void postMessageJson( HttpServletResponse resp, String message) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(message);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
}
