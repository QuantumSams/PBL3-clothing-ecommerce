package Model.DTO.Doanh_Thu;

public class Doanh_thu_tung_DTKH {
	private String doi_tuong_khach_hang;
	private int so_san_pham_ban;
	public Doanh_thu_tung_DTKH(String doi_tuong_khach_hang, int so_san_pham_ban) {
		super();
		this.doi_tuong_khach_hang = doi_tuong_khach_hang;
		this.so_san_pham_ban = so_san_pham_ban;
	}
	public String getDoi_tuong_khach_hang() {
		return doi_tuong_khach_hang;
	}
	public void setDoi_tuong_khach_hang(String doi_tuong_khach_hang) {
		this.doi_tuong_khach_hang = doi_tuong_khach_hang;
	}
	public int getSo_san_pham_ban() {
		return so_san_pham_ban;
	}
	public void setSo_san_pham_ban(int so_san_pham_ban) {
		this.so_san_pham_ban = so_san_pham_ban;
	}
	@Override
	public String toString() {
		return "Doanh_thu_tung_DTKH [doi_tuong_khach_hang=" + doi_tuong_khach_hang + ", so_san_pham_ban="
				+ so_san_pham_ban + "]";
	}
	
}
