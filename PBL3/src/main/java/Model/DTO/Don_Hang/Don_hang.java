package Model.DTO.Don_Hang;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import DataStructures.Pair;
import Model.DTO.Nguoi_Dung.Nguoi_dung;

public class Don_hang{
	protected int id_don_hang;
	protected int tong_tien;
	protected String ten_nhan_vien;
	protected int id_nhan_vien;
	protected String ten_khach_hang;
	protected int id_khach_hang;
	protected Timestamp thoi_gian_dat;
	protected Timestamp thoi_gian_nhan;
	protected String trang_thai_don_hang;
	protected int so_luong;
	protected int so_sao_danh_gia;
	public Don_hang() {
		
	}
	public Don_hang(int id_don_hang, int tong_tien, String ten_nhan_vien, String ten_khach_hang, Timestamp thoi_gian_dat,
			Timestamp thoi_gian_nhan, String trang_thai_don_hang, int so_luong, int so_sao_danh_gia) {
		super();
		this.id_don_hang = id_don_hang;
		this.tong_tien = tong_tien;
		this.ten_nhan_vien = ten_nhan_vien;
		this.ten_khach_hang = ten_khach_hang;
		this.thoi_gian_dat = thoi_gian_dat;
		this.thoi_gian_nhan = thoi_gian_nhan;
		this.trang_thai_don_hang = trang_thai_don_hang;
		this.so_luong = so_luong;
		this.so_sao_danh_gia = so_sao_danh_gia;
	}
	public int getId_don_hang() {
		return id_don_hang;
	}
	public void setId_don_hang(int id_don_hang) {
		this.id_don_hang = id_don_hang;
	}
	public int getTong_tien() {
		return tong_tien;
	}
	public void setTong_tien(int tong_tien) {
		this.tong_tien = tong_tien;
	}
	public String getTen_nhan_vien() {
		return ten_nhan_vien;
	}
	public void setTen_nhan_vien(String ten_nhan_vien) {
		this.ten_nhan_vien = ten_nhan_vien;
	}
	public String getTen_khach_hang() {
		return ten_khach_hang;
	}
	public void setTen_khach_hang(String ten_khach_hang) {
		this.ten_khach_hang = ten_khach_hang;
	}
	public Timestamp getThoi_gian_dat() {
		return thoi_gian_dat;
	}
	public void setThoi_gian_dat(Timestamp thoi_gian_dat) {
		this.thoi_gian_dat = thoi_gian_dat;
	}
	public Timestamp getThoi_gian_nhan() {
		return thoi_gian_nhan;
	}
	public void setThoi_gian_nhan(Timestamp thoi_gian_nhan) {
		this.thoi_gian_nhan = thoi_gian_nhan;
	}
	public String getTrang_thai_don_hang() {
		return trang_thai_don_hang;
	}
	public void setTrang_thai_don_hang(String trang_thai_don_hang) {
		this.trang_thai_don_hang = trang_thai_don_hang;
	}
	public int getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
	public int getSo_sao_danh_gia() {
		return so_sao_danh_gia;
	}
	public void setSo_sao_danh_gia(int so_sao_danh_gia) {
		this.so_sao_danh_gia = so_sao_danh_gia;
	}
	public int getId_nhan_vien() {
		return id_nhan_vien;
	}
	public void setId_nhan_vien(int id_nhan_vien) {
		this.id_nhan_vien = id_nhan_vien;
	}
	public int getId_khach_hang() {
		return id_khach_hang;
	}
	public void setId_khach_hang(int id_khach_hang) {
		this.id_khach_hang = id_khach_hang;
	}
	@Override
	public String toString() {
		return "Don_hang [id_don_hang=" + id_don_hang + ", tong_tien=" + tong_tien + ", ten_nhan_vien=" + ten_nhan_vien
				+ ", ten_khach_hang=" + ten_khach_hang + ", thoi_gian_dat=" + thoi_gian_dat + ", thoi_gian_nhan="
				+ thoi_gian_nhan + ", trang_thai_don_hang=" + trang_thai_don_hang + ", so_luong=" + so_luong
				+ ", so_sao_danh_gia=" + so_sao_danh_gia + "]";
	}
	
	
}
