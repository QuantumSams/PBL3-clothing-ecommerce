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
import Model.DAL.DAO.implemet.Chi_tiet_don_hang_DAO;
import Model.DAL.DAO.implemet.Don_hang_DAO;
import Model.DAL.DAO.implemet.Gio_hang_DAO;
import Model.DAL.DAO.implemet.Muc_san_pham_DAO;
import Model.DAL.DAO.implemet.Nguoi_dung_DAO;
import Model.DAL.DAO.implemet.San_pham_DAO;
import Model.DAL.Specification.Implements.Chi_tiet_don_hang.FindDetailOrderByIDOrder;
import Model.DAL.Specification.Implements.Don_hang.FindOrderByIDOrder;
import Model.DAL.Specification.Implements.Don_hang.FindOrderByIDUser;
import Model.DAL.Specification.Implements.Gio_hang.FindCartByID;
import Model.DAL.Specification.Implements.Muc_san_pham.FindProductItemByID;
import Model.DAL.Specification.Implements.Nguoi_dung.FindNguoiDungByID;
import Model.DAL.Specification.Implements.San_pham.FindProductByID;
import Model.DTO.Don_Hang.Chi_tiet_don_hang;
import Model.DTO.Don_Hang.Don_hang;
import Model.DTO.Don_Hang.Gio_hang;
import Model.DTO.Don_Hang.Lich_su_don_hang;
import Model.DTO.Nguoi_Dung.Nguoi_dung;
import Model.DTO.San_Pham.Muc_san_pham;
import Model.DTO.San_Pham.San_pham;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Order_Service {
	public final String doi_xac_nhan = "Đợi xác nhận đơn hàng";
	public final String dang_van_chuyen = "Đang vận chuyển";
	public final String da_xac_nhan_don = "Đã nhận đươc đơn hàng";
	
	Don_hang_DAO don_hang_DAO;
	Muc_san_pham_DAO muc_san_pham_DAO;
	Nguoi_dung_DAO nguoi_dung_DAO;
	Gio_hang_DAO gio_hang_DAO;
	Chi_tiet_don_hang_DAO chi_tiet_don_hang_DAO;
	San_pham_DAO san_pham_DAO;
	
	public Order_Service() {
		don_hang_DAO = new Don_hang_DAO();
		muc_san_pham_DAO = new Muc_san_pham_DAO();
		nguoi_dung_DAO = new Nguoi_dung_DAO();
		gio_hang_DAO = new Gio_hang_DAO();
		chi_tiet_don_hang_DAO = new Chi_tiet_don_hang_DAO();
		san_pham_DAO = new San_pham_DAO();
	}
	
	public void add_order(HttpServletRequest req, HttpServletResponse resp) {
		
		int id_order = new Random().nextInt();System.out.println(id_order);
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
		
		Don_hang don_hang = new Don_hang(id_order, id_khach_hang, id_nhan_vien, so_dien_thoai, dia_chi_giao_dich, ngay_gio_dat, ngay_gio_nhan, ghi_chu, trang_thai_don_hang);
		
		don_hang_DAO.add(don_hang);
		
		try {
			List<Integer> sanPhamValues = new ObjectMapper().readValue(muc_san_pham, new TypeReference<List<Integer>>() {});
			List<Integer> soLuongValues = new ObjectMapper().readValue(so_luong, new TypeReference<List<Integer>>() {});
			
			Muc_san_pham_DAO muc_san_pham_DAO = new Muc_san_pham_DAO();
			Chi_tiet_don_hang_DAO chi_tiet_don_hang_DAO = new Chi_tiet_don_hang_DAO();
			
			for(int i = 0; i < sanPhamValues.size(); ++i) {
				
				Muc_san_pham muc_san_pham1 = muc_san_pham_DAO.findBySpacification(new FindProductItemByID(sanPhamValues.get(i))).get(0);
				
				Chi_tiet_don_hang chi_tiet_don_hang = new Chi_tiet_don_hang(id_order, 
																	muc_san_pham1.getId_muc_san_pham(), 
																	soLuongValues.get(i), 
																	muc_san_pham1.getGia_tien());
				chi_tiet_don_hang_DAO.add(chi_tiet_don_hang);
				System.out.println(sanPhamValues.get(i) + "  " + soLuongValues.get(i));
			}
		} catch (JsonProcessingException e) {}
		
	}
	
	public void create_order(HttpServletRequest req, HttpServletResponse resp) {
		
		String id_ = req.getParameter("gio_hang");
		
		String[] tmp = id_.split(" ");
		
		List<Integer> list_san_phamm_id = new ArrayList<>();
		
		for(String i : tmp) {
			list_san_phamm_id.add(Integer.parseInt(i));
		}
		
		List<Muc_san_pham> muc_san_pham = new ArrayList<>();
		List<Gio_hang> list_gio_hang = new ArrayList<>();
		for(int id : list_san_phamm_id) {
			System.out.println(id);
			Gio_hang gio_hang = gio_hang_DAO.findBySpacification(new FindCartByID(id)).get(0);
			Muc_san_pham muc = muc_san_pham_DAO.findBySpacification(new FindProductItemByID(gio_hang.getId_muc_san_pham())).get(0);
			San_pham san_pham = san_pham_DAO.findBySpacification(new FindProductByID(muc.getId_san_pham())).get(0);
			muc.setSan_pham(san_pham);
			muc.get_ten_san_pham();
			gio_hang.setMuc_san_pham(muc);
			muc_san_pham.add(muc);
			list_gio_hang.add(gio_hang);
			System.out.println(muc.getTen_san_pham());
		}
		
		req.setAttribute("gio_hang", list_gio_hang);
		
		int id = 237;
		Nguoi_dung nguoi_dung = nguoi_dung_DAO.findBySpacification(new FindNguoiDungByID(id)).get(0);
		req.setAttribute("acc", nguoi_dung);
		
	}
	
	public void get_list_lich_su_don_hang (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id_khach_hang = Integer.parseInt(req.getParameter("id_khach_hang"));
		
		List<Don_hang> don_hang = don_hang_DAO.findBySpacification(new FindOrderByIDUser(id_khach_hang));
		
		List<Lich_su_don_hang> ls = new ArrayList<>();
		
		for(Don_hang dh : don_hang) {
			
			int id_don_hang = dh.getId_hoa_don();
			Date ngay_dat = dh.getNgay_gio_dat_don_hang();
			int so_tien = 0;
			int so_luong_san_pham = 0; 
			String trang_thai_don_hang = dh.getTrang_thai_don_hang();
			
			List<Chi_tiet_don_hang> list_chi_tiet_don_hang = new Chi_tiet_don_hang_DAO().findBySpacification(
					new FindDetailOrderByIDOrder(id_don_hang));
			for(Chi_tiet_don_hang chi_tiet_don_hang : list_chi_tiet_don_hang) {
				so_tien += chi_tiet_don_hang.getGia_tien();
				so_luong_san_pham++;
			}
			
			int so_sao_danh_gia;
			try {
				so_sao_danh_gia = 1;
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
		
		Don_hang don_hang = don_hang_DAO.findBySpacification(new FindOrderByIDOrder(id)).get(0);
		
		List<Pair<Muc_san_pham, Integer>> list_san_pham_mua = new ArrayList<Pair<Muc_san_pham,Integer>>();
		
		for(int i = 0; i < don_hang.getList_muc_san_pham().size(); ++i) {
			
			int id_muc_san_pham = don_hang.getList_muc_san_pham().get(i).getKey();
			int so_luong = don_hang.getList_muc_san_pham().get(i).getValue();
			
			Muc_san_pham muc_san_pham =  muc_san_pham_DAO.findBySpacification(new FindProductItemByID(id_muc_san_pham)).get(0);
			muc_san_pham.get_ten_san_pham();
			
			list_san_pham_mua.add(new Pair<Muc_san_pham, Integer>(
							muc_san_pham, 
							so_luong
					));
		}
		
		Nguoi_dung nguoi_dung = nguoi_dung_DAO.findBySpacification(new FindNguoiDungByID(don_hang.getId_khach_hang())).get(0);
		
		req.setAttribute("khach_hang", nguoi_dung);
		req.setAttribute("don_hang", don_hang);
		req.setAttribute("list_san_pham_mua", list_san_pham_mua);
		
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
		
		return don_hang_DAO.getALL();
	}
	
	public Don_hang get_order_by_ID(HttpServletRequest req, HttpServletResponse resp) {
		return don_hang_DAO.findBySpacification(new FindOrderByIDOrder(0)).get(0);
	}
	
	private void postMessageJson( HttpServletResponse resp, String message) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(message);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
}
