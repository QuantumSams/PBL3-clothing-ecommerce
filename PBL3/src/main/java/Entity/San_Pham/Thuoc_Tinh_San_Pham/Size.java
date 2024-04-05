package Entity.San_Pham.Thuoc_Tinh_San_Pham;

import Entity.Thong_tin;

public class Size implements Thong_tin{
	private int id_size;
	private String ten_size;
	public Size(int id_size, String ten_size) {
		super();
		this.id_size = id_size;
		this.ten_size = ten_size;
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
}
