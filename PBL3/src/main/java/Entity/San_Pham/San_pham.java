package Entity.San_Pham;

import java.util.List;

public class San_pham{

	private int id_san_pham;
	private int id_danh_muc_san_pham;
	private String danh_muc_san_pham;
	private String ten_san_pham;
	private String ten_nhan_hang;
	private String chat_lieu;
	private String thong_tin_chung;
	private String thong_tin_chi_tiet;
	private int gia_tien;
	private List<String> anh_san_pham;
	private List<Muc_san_pham> muc_san_pham;
	
	public San_pham(int id_san_pham, String danh_muc_san_pham, String ten_san_pham, String ten_nhan_hang,
			String chat_lieu, String thong_tin_chung, String thong_tin_chi_tiet, List<String> anh_san_pham,
			List<Muc_san_pham> muc_san_pham) {
		super();
		this.id_san_pham = id_san_pham;
		this.danh_muc_san_pham = danh_muc_san_pham;
		this.ten_san_pham = ten_san_pham;
		this.ten_nhan_hang = ten_nhan_hang;
		this.chat_lieu = chat_lieu;
		this.thong_tin_chung = thong_tin_chung;
		this.thong_tin_chi_tiet = thong_tin_chi_tiet;
		this.anh_san_pham = anh_san_pham;
		this.muc_san_pham = muc_san_pham;
	}
	
	public int getMinGiaTien(List<Muc_san_pham> muc_san_pham) {
		int min = Integer.MAX_VALUE;
		for(Muc_san_pham m : muc_san_pham) {
			if(min > m.gia_tien) min = m.gia_tien; 
		}
		return min;
	}

	public String getThong_tin_chi_tiet() {
		return thong_tin_chi_tiet;
	}


	public void setThong_tin_chi_tiet(String thong_tin_chi_tiet) {
		this.thong_tin_chi_tiet = thong_tin_chi_tiet;
	}
	
	public int getId_san_pham() {
		return id_san_pham;
	}

	public void setId_san_pham(int id_san_pham) {
		this.id_san_pham = id_san_pham;
	}

	public String getDanh_muc_san_pham() {
		return danh_muc_san_pham;
	}

	public String getChat_lieu() {
		return chat_lieu;
	}


	public void setChat_lieu(String chat_lieu) {
		this.chat_lieu = chat_lieu;
	}


	public void setDanh_muc_san_pham(String danh_muc_san_pham) {
		this.danh_muc_san_pham = danh_muc_san_pham;
	}

	public String getTen_san_pham() {
		return ten_san_pham;
	}

	public void setTen_san_pham(String ten_san_pham) {
		this.ten_san_pham = ten_san_pham;
	}

	public String getTen_nhan_hang() {
		return ten_nhan_hang;
	}

	public void setTen_nhan_hang(String ten_nhan_hang) {
		this.ten_nhan_hang = ten_nhan_hang;
	}

	public String getThong_tin_chung() {
		return thong_tin_chung;
	}

	public void setThong_tin_chung(String thong_tin_chung) {
		this.thong_tin_chung = thong_tin_chung;
	}

	public List<String> getAnh_san_pham() {
		return anh_san_pham;
	}

	public void setAnh_san_pham(List<String> anh_san_pham) {
		this.anh_san_pham = anh_san_pham;
	}

	public List<Muc_san_pham> getMuc_san_pham() {
		return muc_san_pham;
	}

	public void setMuc_san_pham(List<Muc_san_pham> muc_san_pham) {
		gia_tien = getMinGiaTien(muc_san_pham);
		this.muc_san_pham = muc_san_pham;
	}

	public void gan_danh_muc_san_pham(int id_danh_muc_san_pham) {
		
	}
	
	public List<Muc_san_pham> lay_thong_tin_chi_tiet_san_pham() {
		return null;
	}
	
	public int getId_danh_muc_san_pham() {
		return id_danh_muc_san_pham;
	}

	public void setId_danh_muc_san_pham(int id_danh_muc_san_pham) {
		this.id_danh_muc_san_pham = id_danh_muc_san_pham;
	}

	public int getGia_tien() {
		return gia_tien;
	}

	public void setGia_tien(int gia_tien) {
		this.gia_tien = gia_tien;
	}

	@Override
	public String toString() {
		return "San_pham [id_san_pham=" + id_san_pham + ", danh_muc_san_pham=" + danh_muc_san_pham + ", ten_san_pham="
				+ ten_san_pham + ", ten_nhan_hang=" + ten_nhan_hang + ", chat_lieu=" + chat_lieu + ", thong_tin_chung="
				+ thong_tin_chung + ", thong_tin_chi_tiet=" + thong_tin_chi_tiet + ", anh_san_pham=" + anh_san_pham
				+ ", thon_tin_chi_tiet_san_phan=" + muc_san_pham + "]";
	}

	
}
