package Entity.Don_Hang;

import java.sql.Date;
import java.util.List;

import DataStructures.Pair;

public class Don_hang{
	protected int id_hoa_don;
	protected List<Pair<Integer, Integer>> list_muc_san_pham; // <id_muc_san_pham, so_luong>
	protected int tong_tien;
	protected int id_khach_hang;
	protected int id_nhan_vien;
	protected String dia_chi_giao_dich;
	protected Date ngay_gio_dat_don_hang;
	protected Date ngay_gio_nhan_don_hang;
	protected String trang_thai_don_hang;
	
	public Don_hang(int id_hoa_don, int tong_tien, int id_khach_hang,
					int id_nhan_vien, String dia_chi_giao_dich, Date ngay_gio_dat_don_hang, 
					Date ngay_gio_nhan_don_hang, String trang_thai_don_hang) {
		super();
		this.id_hoa_don = id_hoa_don;
		this.tong_tien = tong_tien;
		this.id_khach_hang = id_khach_hang;
		this.id_nhan_vien = id_nhan_vien;
		this.dia_chi_giao_dich = dia_chi_giao_dich;
		this.ngay_gio_dat_don_hang = ngay_gio_dat_don_hang;
		this.ngay_gio_nhan_don_hang = ngay_gio_nhan_don_hang;
		this.trang_thai_don_hang = trang_thai_don_hang;
	}
	
	public Don_hang() {
		
	}
	
	public void xoa_don_hang() {
		
	}
	

	public int getId_hoa_don() {
		return id_hoa_don;
	}

	public void setId_hoa_don(int id_hoa_don) {
		this.id_hoa_don = id_hoa_don;
	}

	public List<Pair<Integer, Integer>> getList_muc_san_pham() {
		return list_muc_san_pham;
	}

	public void setList_muc_san_pham(List<Pair<Integer, Integer>> list_muc_san_pham) {
		this.list_muc_san_pham = list_muc_san_pham;
	}

	public int getTong_tien() {
		return tong_tien;
	}

	public void setTong_tien(int tong_tien) {
		this.tong_tien = tong_tien;
	}

	public int getId_khach_hang() {
		return id_khach_hang;
	}

	public void setId_khach_hang(int id_khach_hang) {
		this.id_khach_hang = id_khach_hang;
	}

	public int getId_nhan_vien() {
		return id_nhan_vien;
	}

	public void setId_nhan_vien(int id_nhan_vien) {
		this.id_nhan_vien = id_nhan_vien;
	}

	public String getDia_chi_giao_dich() {
		return dia_chi_giao_dich;
	}

	public void setDia_chi_giao_dich(String dia_chi_giao_dich) {
		this.dia_chi_giao_dich = dia_chi_giao_dich;
	}

	public Date getNgay_gio_dat_don_hang() {
		return ngay_gio_dat_don_hang;
	}

	public void setNgay_gio_dat_don_hang(Date ngay_gio_dat_don_hang) {
		this.ngay_gio_dat_don_hang = ngay_gio_dat_don_hang;
	}

	public Date getNgay_gio_nhan_don_hang() {
		return ngay_gio_nhan_don_hang;
	}

	public void setNgay_gio_nhan_don_hang(Date ngay_gio_nhan_don_hang) {
		this.ngay_gio_nhan_don_hang = ngay_gio_nhan_don_hang;
	}

	public String getTrang_thai_don_hang() {
		return trang_thai_don_hang;
	}

	public void setTrang_thai_don_hang(String trang_thai_don_hang) {
		this.trang_thai_don_hang = trang_thai_don_hang;
	}
}
