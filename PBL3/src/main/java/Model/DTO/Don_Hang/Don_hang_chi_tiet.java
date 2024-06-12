package Model.DTO.Don_Hang;

import java.sql.Date;

public class Don_hang_chi_tiet extends Don_hang{
	private String so_dien_thoai;
	private String dia_chi;
	private String ghi_chu;
	private String danh_gia;
	public Don_hang_chi_tiet() {
	}
	
	public Don_hang_chi_tiet(int id_don_hang, int tong_tien, String ten_nhan_vien, String ten_khach_hang,
			Date thoi_gian_dat, Date thoi_gian_nhan, String trang_thai_don_hang, int so_luong, int so_sao_danh_gia,
			String so_dien_thoai, String dia_chi, String ghi_chu, String danh_gia) {
		super(id_don_hang, tong_tien, ten_nhan_vien, ten_khach_hang, thoi_gian_dat, thoi_gian_nhan, trang_thai_don_hang,
				so_luong, so_sao_danh_gia);
		this.so_dien_thoai = so_dien_thoai;
		this.dia_chi = dia_chi;
		this.ghi_chu = ghi_chu;
		this.danh_gia = danh_gia;
	}
	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}
	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getGhi_chu() {
		return ghi_chu;
	}
	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}
	public String getDanh_gia() {
		return danh_gia;
	}
	public void setDanh_gia(String danh_gia) {
		this.danh_gia = danh_gia;
	}
	@Override
	public String toString() {
		return "Don_hang_chi_tiet [so_dien_thoai=" + so_dien_thoai + ", dia_chi=" + dia_chi + ", ghi_chu=" + ghi_chu
				+ ", danh_gia=" + danh_gia + "]";
	}
	
}
