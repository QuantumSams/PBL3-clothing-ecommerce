package Model.DTO.Doanh_Thu;

public class Doanh_thu {
	private int doanh_thu;
	private int tong_so_don;
	private int san_pham_da_ban;
	public Doanh_thu(int doanh_thu, int tong_so_don, int san_pham_da_ban) {
		this.doanh_thu = doanh_thu;
		this.tong_so_don = tong_so_don;
		this.san_pham_da_ban = san_pham_da_ban;
	}
	public int getDoanh_thu() {
		return doanh_thu;
	}
	public void setDoanh_thu(int doanh_thu) {
		this.doanh_thu = doanh_thu;
	}
	public int getTong_so_don() {
		return tong_so_don;
	}
	public void setTong_so_don(int tong_so_don) {
		this.tong_so_don = tong_so_don;
	}
	public int getSan_pham_da_ban() {
		return san_pham_da_ban;
	}
	public void setSan_pham_da_ban(int san_pham_da_ban) {
		this.san_pham_da_ban = san_pham_da_ban;
	}
	@Override
	public String toString() {
		return "Doanh_thu [doanh_thu=" + doanh_thu + ", tong_so_don=" + tong_so_don + ", san_pham_da_ban="
				+ san_pham_da_ban + "]";
	}
	
}
