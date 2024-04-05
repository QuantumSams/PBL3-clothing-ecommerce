package Entity.San_Pham;

import java.util.List;

import Entity.Thong_tin;

public class Danh_muc_san_pham implements Thong_tin{
	
	private int id_danh_muc_san_pham;
	private String ten_loai_san_pham;
	private String ten_doi_tuong_khach_hang;
	private String ten_danh_muc_san_pham;
	
	
	
	public Danh_muc_san_pham(int id_danh_muc_san_pham, String ten_loai_san_pham, String ten_doi_tuong_khach_hang,
			String ten_danh_muc_san_pham) {
		super();
		this.id_danh_muc_san_pham = id_danh_muc_san_pham;
		this.ten_loai_san_pham = ten_loai_san_pham;
		this.ten_doi_tuong_khach_hang = ten_doi_tuong_khach_hang;
		this.ten_danh_muc_san_pham = ten_danh_muc_san_pham;
	}

	public int getId_danh_muc_san_pham() {
		return id_danh_muc_san_pham;
	}

	public void setId_danh_muc_san_pham(int id_danh_muc_san_pham) {
		this.id_danh_muc_san_pham = id_danh_muc_san_pham;
	}

	public String getTen_loai_san_pham() {
		return ten_loai_san_pham;
	}

	public void setTen_loai_san_pham(String ten_loai_san_pham) {
		this.ten_loai_san_pham = ten_loai_san_pham;
	}

	public String getTen_doi_tuong_khach_hang() {
		return ten_doi_tuong_khach_hang;
	}

	public void setTen_doi_tuong_khach_hang(String ten_doi_tuong_khach_hang) {
		this.ten_doi_tuong_khach_hang = ten_doi_tuong_khach_hang;
	}

	public String getTen_danh_muc_san_pham() {
		return ten_danh_muc_san_pham;
	}

	public void setTen_danh_muc_san_pham(String ten_danh_muc_san_pham) {
		this.ten_danh_muc_san_pham = ten_danh_muc_san_pham;
	}

	

	@Override
	public String toString() {
		return "Danh_muc_san_pham [id_danh_muc_san_pham=" + id_danh_muc_san_pham + ", ten_loai_san_pham="
				+ ten_loai_san_pham + ", ten_doi_tuong_khach_hang=" + ten_doi_tuong_khach_hang
				+ ", ten_danh_muc_san_pham=" + ten_danh_muc_san_pham + "]";
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
	
	public List<San_pham> lay_tat_ca_san_pham() {
		return null;
	}

}
