package Model.DTO.San_Pham;

import Model.DAL.DAO.implemet.San_pham_DAO;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Size;

public class Muc_san_pham{
	protected int id_muc_san_pham;
	protected int id_san_pham;
	protected String ten_san_pham;
	protected int so_luong_trong_kho;
	protected Mau_sac mau_sac_san_pham;
	protected Size kich_thuoc_san_pham;
	protected int gia_tien;
	protected String anh_chi_tiet;
	protected San_pham san_pham;
	
	public Muc_san_pham() {
		
	}
	public Muc_san_pham(int id_muc_san_pham, int id_san_pham, int so_luong_trong_kho,
			Mau_sac mau_sac_san_pham, Size kich_thuoc_san_pham, int gia_tien,
			String anh_chi_tiet) {
		super();
		this.id_muc_san_pham = id_muc_san_pham;
		this.id_san_pham = id_san_pham;
		this.so_luong_trong_kho = so_luong_trong_kho;
		this.mau_sac_san_pham = mau_sac_san_pham;
		this.kich_thuoc_san_pham = kich_thuoc_san_pham;
		this.gia_tien = gia_tien;
		this.anh_chi_tiet = anh_chi_tiet;
	}
	
	public int getGia_tien() {
		return gia_tien;
	}

	public void setGia_tien(int gia_tien) {
		this.gia_tien = gia_tien;
	}

	public int getId_muc_san_pham() {
		return id_muc_san_pham;
	}

	public void setId_muc_san_pham(int id_muc_san_pham) {
		this.id_muc_san_pham = id_muc_san_pham;
	}

	public int getId_san_pham() {
		return id_san_pham;
	}

	public void setId_san_pham(int id_san_pham) {
		this.id_san_pham = id_san_pham;
	}

	public int getSo_luong_trong_kho() {
		return so_luong_trong_kho;
	}

	public void setSo_luong_trong_kho(int so_luong_trong_kho) {
		this.so_luong_trong_kho = so_luong_trong_kho;
	}

	public Mau_sac getMau_sac_san_pham() {
		return mau_sac_san_pham;
	}

	public void setMau_sac_san_pham(Mau_sac mau_sac_san_pham) {
		this.mau_sac_san_pham = mau_sac_san_pham;
	}

	public Size getKich_thuoc_san_pham() {
		return kich_thuoc_san_pham;
	}

	public void setKich_thuoc_san_pham(Size kich_thuoc_san_pham) {
		this.kich_thuoc_san_pham = kich_thuoc_san_pham;
	}

	public String getAnh_chi_tiet() {
		return anh_chi_tiet;
	}

	public void setAnh_chi_tiet(String anh_chi_tiet) {
		this.anh_chi_tiet = anh_chi_tiet;
	}

	public void get_ten_san_pham() {
		ten_san_pham = san_pham.getTen_san_pham();
	}
	
	public San_pham getSan_pham() {
		return san_pham;
	}
	public void setSan_pham(San_pham san_pham) {
		this.san_pham = san_pham;
	}
	public String getTen_san_pham() {
		return ten_san_pham;
	}

	public void setTen_san_pham(String ten_san_pham) {
		this.ten_san_pham = ten_san_pham;
	}

	@Override
	public String toString() {
		return "Muc_san_pham [id_muc_san_pham=" + id_muc_san_pham + ", id_san_pham=" + id_san_pham
				+ ", so_luong_trong_kho=" + so_luong_trong_kho + ", mau_sac_san_pham=" + mau_sac_san_pham
				+ ", kich_thuoc_san_pham=" + kich_thuoc_san_pham + ", gia_tien=" + gia_tien + ", anh_chi_tiet="
				+ anh_chi_tiet + "]";
	}
	
	
}
