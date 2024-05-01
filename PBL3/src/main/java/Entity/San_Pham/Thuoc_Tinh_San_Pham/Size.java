package Entity.San_Pham.Thuoc_Tinh_San_Pham;

public class Size{
	private int id_size;
	private String ten_size;
	public Size(int id_size, String ten_size) {
		super();
		this.id_size = id_size;
		this.ten_size = ten_size;
	}
	
	public Size() {
		
	}
	
	public int getId_size() {
		return id_size;
	}

	public void setId_size(int id_size) {
		this.id_size = id_size;
	}

	public String getTen_size() {
		return ten_size;
	}

	public void setTen_size(String ten_size) {
		this.ten_size = ten_size;
	}
}
