package Entity.San_Pham;

import java.util.List;

import Entity.Thong_tin;

public class San_pham implements Thong_tin{

	private int id_san_pham;
	private int id_danh_muc_san_pham;
	private String ten_san_pham;
	private String ten_nhan_hang;
	private String chat_lieu;
	private String thong_tin_chung;
	private List<String> anh_san_pham;
	private List<Thong_tin_chi_tiet_san_pham> thon_tin_chi_tiet_san_phan;
	
	
	public San_pham(int id_san_pham, int id_danh_muc_san_pham, String ten_san_pham, String ten_nhan_hang,
			String chat_lieu, String thong_tin_chung, List<String> anh_san_pham,
			List<Thong_tin_chi_tiet_san_pham> thon_tin_chi_tiet_san_phan) {
		super();
		this.id_san_pham = id_san_pham;
		this.id_danh_muc_san_pham = id_danh_muc_san_pham;
		this.ten_san_pham = ten_san_pham;
		this.ten_nhan_hang = ten_nhan_hang;
		this.chat_lieu = chat_lieu;
		this.thong_tin_chung = thong_tin_chung;
		this.anh_san_pham = anh_san_pham;
		this.thon_tin_chi_tiet_san_phan = thon_tin_chi_tiet_san_phan;
	}

	
	public int getId_san_pham() {
		return id_san_pham;
	}

	public void setId_san_pham(int id_san_pham) {
		this.id_san_pham = id_san_pham;
	}

	public int getId_danh_muc_san_pham() {
		return id_danh_muc_san_pham;
	}

	public String getChat_lieu() {
		return chat_lieu;
	}


	public void setChat_lieu(String chat_lieu) {
		this.chat_lieu = chat_lieu;
	}


	public void setId_danh_muc_san_pham(int id_danh_muc_san_pham) {
		this.id_danh_muc_san_pham = id_danh_muc_san_pham;
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

	public List<Thong_tin_chi_tiet_san_pham> getThon_tin_chi_tiet_san_phan() {
		return thon_tin_chi_tiet_san_phan;
	}

	public void setThon_tin_chi_tiet_san_phan(List<Thong_tin_chi_tiet_san_pham> thon_tin_chi_tiet_san_phan) {
		this.thon_tin_chi_tiet_san_phan = thon_tin_chi_tiet_san_phan;
	}

	
	
	@Override
	public String toString() {
		return "San_pham [id_san_pham=" + id_san_pham + ", id_danh_muc_san_pham=" + id_danh_muc_san_pham
				+ ", ten_san_pham=" + ten_san_pham + ", ten_nhan_hang=" + ten_nhan_hang + ", thong_tin_chung="
				+ thong_tin_chung + "]";
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
	
	public void gan_danh_muc_san_pham(int id_danh_muc_san_pham) {
		
	}
	
	public List<Thong_tin_chi_tiet_san_pham> lay_thong_tin_chi_tiet_san_pham() {
		return null;
	}

}
