package Entity.Nguoi_Dung;


import java.sql.Date;

import Entity.Don_Hang.Danh_gia_don_hang;
import Entity.Don_Hang.Don_hang;

public class Khach_hang extends Nguoi_dung{

	public Khach_hang(int id_nguoi_dung, String ho_ten, boolean gioi_tinh, Date ngay_sinhDate, String dia_chi,
			String anh_dai_dien, String so_dien_thoai, String email, String phan_quyen_nguoi_dung) {
		super(id_nguoi_dung, ho_ten, gioi_tinh, ngay_sinhDate, dia_chi, anh_dai_dien, so_dien_thoai, email,
				phan_quyen_nguoi_dung);
	}
	
	public void them_vao_gio_hang(int id_chi_tiet_san_pham) {
		
	}
	
	public void dat_don_hang(Don_hang don_hang) {
		
	}
	
	public void huy_don_hang(int id_hoa_don) {
		
	}
	
	public void danh_gia_don_hang(Danh_gia_don_hang danh_gia_don_hang) {
	
	}
	
	public void xac_nhan_don_hang(int id_don_hang) {
		
	}
	

}
