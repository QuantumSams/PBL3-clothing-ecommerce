package Entity.San_Pham.Thuoc_Tinh_San_Pham;

import Entity.Thong_tin;

public class Chat_lieu implements Thong_tin{

	private int id_chat_lieu;
	private String ten_chat_lieu;
	
	public Chat_lieu(int id_chat_lieu, String ten_chat_lieu) {
		super();
		this.id_chat_lieu = id_chat_lieu;
		this.ten_chat_lieu = ten_chat_lieu;
	}
	
	public int getId_chat_lieu() {
		return id_chat_lieu;
	}
	public void setId_chat_lieu(int id_chat_lieu) {
		this.id_chat_lieu = id_chat_lieu;
	}
	public String getTen_chat_lieu() {
		return ten_chat_lieu;
	}
	public void setTen_chat_lieu(String ten_chat_lieu) {
		this.ten_chat_lieu = ten_chat_lieu;
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
