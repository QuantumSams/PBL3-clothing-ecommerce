package Model.DTO.San_Pham.Thuoc_Tinh_San_Pham;

public class Anh_san_pham {
	private int id_anh;
	private int id_san_pham;
	private String duong_dan_anh;
	public Anh_san_pham() {
		
	}
	public Anh_san_pham(int id_anh, int id_san_pham, String duong_dan_anh) {
		super();
		this.id_anh = id_anh;
		this.id_san_pham = id_san_pham;
		this.duong_dan_anh = duong_dan_anh;
	}
	public int getId_anh() {
		return id_anh;
	}
	public void setId_anh(int id_anh) {
		this.id_anh = id_anh;
	}
	public int getId_san_pham() {
		return id_san_pham;
	}
	public void setId_san_pham(int id_san_pham) {
		this.id_san_pham = id_san_pham;
	}
	public String getDuong_dan_anh() {
		return duong_dan_anh;
	}
	public void setDuong_dan_anh(String duong_dan_anh) {
		this.duong_dan_anh = duong_dan_anh;
	}
	
}
