package Model.DTO.Don_Hang;

import java.sql.Date;

public class Xac_nhan_don_hang {
	private int ma_don_hang;
	private int gia_tri_don;
	private String ten_khach_hang;
	private Date thoi_diem_dat;
	public Xac_nhan_don_hang(int ma_don_hang, int gia_tri_don, String ten_khach_hang, Date thoi_diem_dat) {
		super();
		this.ma_don_hang = ma_don_hang;
		this.gia_tri_don = gia_tri_don;
		this.ten_khach_hang = ten_khach_hang;
		this.thoi_diem_dat = thoi_diem_dat;
	}
	public int getMa_don_hang() {
		return ma_don_hang;
	}
	public void setMa_don_hang(int ma_don_hang) {
		this.ma_don_hang = ma_don_hang;
	}
	public int getGia_tri_don() {
		return gia_tri_don;
	}
	public void setGia_tri_don(int gia_tri_don) {
		this.gia_tri_don = gia_tri_don;
	}
	public String getTen_khach_hang() {
		return ten_khach_hang;
	}
	public void setTen_khach_hang(String ten_khach_hang) {
		this.ten_khach_hang = ten_khach_hang;
	}
	public Date getThoi_diem_dat() {
		return thoi_diem_dat;
	}
	public void setThoi_diem_dat(Date thoi_diem_dat) {
		this.thoi_diem_dat = thoi_diem_dat;
	}
	
	
}
