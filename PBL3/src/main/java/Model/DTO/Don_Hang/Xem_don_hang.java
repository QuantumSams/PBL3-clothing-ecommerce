package Model.DTO.Don_Hang;

import java.sql.Date;

public class Xem_don_hang {
	private int id_don_hang;
	private String ho_ten_nhan_vien;
	private int gia_tri_don;
	private Date thoi_diem_dat;
	private Date thoi_diem_nhan;
	private String trang_thai;
	public Xem_don_hang(int id_don_hang, String ho_ten_nhan_vien, int gia_tri_don, Date thoi_diem_dat,
			Date thoi_diem_nhan, String trang_thai) {
		super();
		this.id_don_hang = id_don_hang;
		this.ho_ten_nhan_vien = ho_ten_nhan_vien;
		this.gia_tri_don = gia_tri_don;
		this.thoi_diem_dat = thoi_diem_dat;
		this.thoi_diem_nhan = thoi_diem_nhan;
		this.trang_thai = trang_thai;
	}
	public int getId_don_hang() {
		return id_don_hang;
	}
	public void setId_don_hang(int id_don_hang) {
		this.id_don_hang = id_don_hang;
	}
	public String getHo_ten_nhan_vien() {
		return ho_ten_nhan_vien;
	}
	public void setHo_ten_nhan_vien(String ho_ten_nhan_vien) {
		this.ho_ten_nhan_vien = ho_ten_nhan_vien;
	}
	public int getGia_tri_don() {
		return gia_tri_don;
	}
	public void setGia_tri_don(int gia_tri_don) {
		this.gia_tri_don = gia_tri_don;
	}
	public Date getThoi_diem_dat() {
		return thoi_diem_dat;
	}
	public void setThoi_diem_dat(Date thoi_diem_dat) {
		this.thoi_diem_dat = thoi_diem_dat;
	}
	public Date getThoi_diem_nhan() {
		return thoi_diem_nhan;
	}
	public void setThoi_diem_nhan(Date thoi_diem_nhan) {
		this.thoi_diem_nhan = thoi_diem_nhan;
	}
	public String getTrang_thai() {
		return trang_thai;
	}
	public void setTrang_thai(String trang_thai) {
		this.trang_thai = trang_thai;
	}
	@Override
	public String toString() {
		return "Xem_don_hang [id_don_hang=" + id_don_hang + ", ho_ten_nhan_vien=" + ho_ten_nhan_vien + ", gia_tri_don="
				+ gia_tri_don + ", thoi_diem_dat=" + thoi_diem_dat + ", thoi_diem_nhan=" + thoi_diem_nhan
				+ ", trang_thai=" + trang_thai + "]";
	}
	
	
}
