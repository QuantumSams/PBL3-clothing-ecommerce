package Entity.San_Pham;

import java.util.List;

import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Size;

public class Chi_tiet_san_pham{
	protected int id_thong_tin_chi_tiet_san_pham;
	protected int id_san_pham;
	protected int so_luong_trong_kho;
	protected Mau_sac mau_sac_san_pham;
	protected Size kich_thuoc_san_pham;
	protected float gia_tien;
	protected List<String> anh_chi_tiet;
	protected String thong_tin_chi_tiet;
	
	public Chi_tiet_san_pham(int id_thong_tin_chi_tiet_san_pham, int id_san_pham, int so_luong_trong_kho,
			Mau_sac mau_sac_san_pham, Size kich_thuoc_san_pham, float gia_tien,
			List<String> anh_chi_tiet, String thong_tin_chi_tiet) {
		super();
		this.id_thong_tin_chi_tiet_san_pham = id_thong_tin_chi_tiet_san_pham;
		this.id_san_pham = id_san_pham;
		this.so_luong_trong_kho = so_luong_trong_kho;
		this.mau_sac_san_pham = mau_sac_san_pham;
		this.kich_thuoc_san_pham = kich_thuoc_san_pham;
		this.gia_tien = gia_tien;
		this.anh_chi_tiet = anh_chi_tiet;
		this.thong_tin_chi_tiet = thong_tin_chi_tiet;
	}

	public float getGia_tien() {
		return gia_tien;
	}

	public void setGia_tien(float gia_tien) {
		this.gia_tien = gia_tien;
	}

	public int getId_thong_tin_chi_tiet_san_pham() {
		return id_thong_tin_chi_tiet_san_pham;
	}

	public void setId_thong_tin_chi_tiet_san_pham(int id_thong_tin_chi_tiet_san_pham) {
		this.id_thong_tin_chi_tiet_san_pham = id_thong_tin_chi_tiet_san_pham;
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

	public List<String> getAnh_chi_tiet() {
		return anh_chi_tiet;
	}

	public void setAnh_chi_tiet(List<String> anh_chi_tiet) {
		this.anh_chi_tiet = anh_chi_tiet;
	}

	public String getThong_tin_chi_tiet() {
		return thong_tin_chi_tiet;
	}

	public void setThong_tin_chi_tiet(String thong_tin_chi_tiet) {
		this.thong_tin_chi_tiet = thong_tin_chi_tiet;
	}
}
