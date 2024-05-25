package Model.DTO.Don_Hang;

import java.sql.Date;

public class Lich_su_don_hang {
	private int id_don_hang;
	private Date ngay_dat;
	private int so_tien;
	private int so_luong_san_pham;
	private String trang_thai_don_hang;
	private int so_sao_danh_gia;
	public Lich_su_don_hang(int id_don_hang, Date ngay_dat, int so_tien, int so_luong_san_pham, String trang_thai_don_hang,
			int so_sao_danh_gia) {
		super();
		this.id_don_hang = id_don_hang;
		this.ngay_dat = ngay_dat;
		this.so_tien = so_tien;
		this.so_luong_san_pham = so_luong_san_pham;
		this.trang_thai_don_hang = trang_thai_don_hang;
		this.so_sao_danh_gia = so_sao_danh_gia;
	}
	public Lich_su_don_hang() {
		
	}
	public int getId_don_hang() {
		return id_don_hang;
	}
	public void setId_don_hang(int id_don_hang) {
		this.id_don_hang = id_don_hang;
	}
	public Date getNgay_dat() {
		return ngay_dat;
	}
	public void setNgay_dat(Date ngay_dat) {
		this.ngay_dat = ngay_dat;
	}
	public int getSo_tien() {
		return so_tien;
	}
	public void setSo_tien(int so_tien) {
		this.so_tien = so_tien;
	}
	public int getSo_luong_san_pham() {
		return so_luong_san_pham;
	}
	public void setSo_luong_san_pham(int so_luong_san_pham) {
		this.so_luong_san_pham = so_luong_san_pham;
	}
	public String getTrang_thai_don_hang() {
		return trang_thai_don_hang;
	}
	public void setTrang_thai_don_hang(String trang_thai_don_hang) {
		this.trang_thai_don_hang = trang_thai_don_hang;
	}
	public int getSo_sao_danh_gia() {
		return so_sao_danh_gia;
	}
	public void setSo_sao_danh_gia(int so_sao_danh_gia) {
		this.so_sao_danh_gia = so_sao_danh_gia;
	}
	@Override
	public String toString() {
		return "Lich_su_don [id_don_hang=" + id_don_hang + ", ngay_dat=" + ngay_dat + ", so_tien=" + so_tien
				+ ", so_luong_san_pham=" + so_luong_san_pham + ", trang_thai_don_hang=" + trang_thai_don_hang
				+ ", so_sao_danh_gia=" + so_sao_danh_gia + "]";
	}
	
	
}
