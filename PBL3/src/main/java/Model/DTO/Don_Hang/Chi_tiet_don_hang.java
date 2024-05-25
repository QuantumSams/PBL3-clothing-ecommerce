package Model.DTO.Don_Hang;

import Model.DTO.San_Pham.Muc_san_pham;

public class Chi_tiet_don_hang {
	private int id_don_hang;
	private int id_muc_san_pham;
	private int so_luong;
	private int gia_tien;
	private Muc_san_pham muc_san_pham;
	
	public Chi_tiet_don_hang(int id_don_hang, int id_muc_san_pham, int so_luong, int gia_tien) {
		super();
		this.id_don_hang = id_don_hang;
		this.id_muc_san_pham = id_muc_san_pham;
		this.so_luong = so_luong;
		this.gia_tien = gia_tien;
	}
	public int getId_don_hang() {
		return id_don_hang;
	}
	public void setId_don_hang(int id_don_hang) {
		this.id_don_hang = id_don_hang;
	}
	public int getId_muc_san_pham() {
		return id_muc_san_pham;
	}
	public void setId_muc_san_pham(int id_muc_san_pham) {
		this.id_muc_san_pham = id_muc_san_pham;
	}
	public int getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
	public int getGia_tien() {
		return gia_tien;
	}
	public void setGia_tien(int gia_tien) {
		this.gia_tien = gia_tien;
	}
	public Muc_san_pham getMuc_san_pham() {
		return muc_san_pham;
	}
	public void setMuc_san_pham(Muc_san_pham muc_san_pham) {
		this.muc_san_pham = muc_san_pham;
	}
	
	
}
