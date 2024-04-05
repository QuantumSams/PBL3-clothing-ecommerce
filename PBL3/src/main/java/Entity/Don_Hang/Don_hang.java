package Entity.Don_Hang;


import java.sql.Date;

import Entity.Thong_tin;

public class Don_hang implements Thong_tin{
	protected int id_hoa_don;
	protected int id_thong_tin_chi_tiet_san_pham;
	protected int so_luong;
	protected int tong_tien;
	protected int id_khach_hang;
	protected int id_nhan_vien;
	protected String dia_chi_giao_dich;
	protected Date ngay_gio_dat_don_hang;
	protected Date ngay_gio_nhan_don_hang;
	protected String trang_thai_don_hang;
	
	public Don_hang(int id_hoa_don, int id_thong_tin_chi_tiet_san_pham, int so_luong, int tong_tien, int id_khach_hang,
			int id_nhan_vien, String dia_chi_giao_dich, Date ngay_gio_dat_don_hang, Date ngay_gio_nhan_don_hang,
			String trang_thai_don_hang) {
		super();
		this.id_hoa_don = id_hoa_don;
		this.id_thong_tin_chi_tiet_san_pham = id_thong_tin_chi_tiet_san_pham;
		this.so_luong = so_luong;
		this.tong_tien = tong_tien;
		this.id_khach_hang = id_khach_hang;
		this.id_nhan_vien = id_nhan_vien;
		this.dia_chi_giao_dich = dia_chi_giao_dich;
		this.ngay_gio_dat_don_hang = ngay_gio_dat_don_hang;
		this.ngay_gio_nhan_don_hang = ngay_gio_nhan_don_hang;
		this.trang_thai_don_hang = trang_thai_don_hang;
	}
	
	public void xoa_don_hang() {
		
	}
	

	public int getId_hoa_don() {
		return id_hoa_don;
	}

	public void setId_hoa_don(int id_hoa_don) {
		this.id_hoa_don = id_hoa_don;
	}

	public int getId_thong_tin_chi_tiet_san_pham() {
		return id_thong_tin_chi_tiet_san_pham;
	}

	public void setId_thong_tin_chi_tiet_san_pham(int id_thong_tin_chi_tiet_san_pham) {
		this.id_thong_tin_chi_tiet_san_pham = id_thong_tin_chi_tiet_san_pham;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
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

	@Override
	public void them_thong_tin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cap_nhat_thong_tin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void xoa_thong_tin() {
		// TODO Auto-generated method stub
		
	}
	
	
}
