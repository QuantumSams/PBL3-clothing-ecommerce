package Model.DTO.Don_Hang;

public class Muc_sp_don_hang {
	private int id_muc_san_pham;
	private String ten_san_pham;
	private String ten_size;
	private String ten_mau;
	private int so_luong;
	private int gia;
	private String anh;
	
	private int id_don_hang;
	
	public Muc_sp_don_hang() {
	
	}
	
	public Muc_sp_don_hang(int id_muc_san_pham, String ten_san_pham, String ten_size, String ten_mau, int so_luong,
			int gia, String anh) {
		super();
		this.id_muc_san_pham = id_muc_san_pham;
		this.ten_san_pham = ten_san_pham;
		this.ten_size = ten_size;
		this.ten_mau = ten_mau;
		this.so_luong = so_luong;
		this.gia = gia;
		this.anh = anh;
	}
	
	public int getId_don_hang() {
		return id_don_hang;
	}

	public void setId_don_hang(int id_don_hang) {
		this.id_don_hang = id_don_hang;
	}

	public int getId_muc_san_pham() {
		return id_muc_san_pham;
	}
	public void setId_muc_san_pham(int id_muc_san_pham) {
		this.id_muc_san_pham = id_muc_san_pham;
	}
	public String getTen_san_pham() {
		return ten_san_pham;
	}
	public void setTen_san_pham(String ten_san_pham) {
		this.ten_san_pham = ten_san_pham;
	}
	public String getTen_size() {
		return ten_size;
	}
	public void setTen_size(String ten_size) {
		this.ten_size = ten_size;
	}
	public String getTen_mau() {
		return ten_mau;
	}
	public void setTen_mau(String ten_mau) {
		this.ten_mau = ten_mau;
	}
	public int getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	@Override
	public String toString() {
		return "Muc_sp_don_hang [id_muc_san_pham=" + id_muc_san_pham + ", ten_san_pham=" + ten_san_pham + ", ten_size="
				+ ten_size + ", ten_mau=" + ten_mau + ", so_luong=" + so_luong + ", gia=" + gia + ", anh=" + anh + "]";
	}
	
}
