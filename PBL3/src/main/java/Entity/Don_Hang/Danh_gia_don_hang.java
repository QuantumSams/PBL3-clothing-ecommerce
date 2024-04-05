package Entity.Don_Hang;

import Entity.Thong_tin;

public class Danh_gia_don_hang implements Thong_tin{
	protected int id_hoa_don;
	protected int so_sao;
	protected String binh_luan;
	
	public Danh_gia_don_hang(int id_hoa_don, int so_sao, String binh_luan) {
		super();
		this.id_hoa_don = id_hoa_don;
		this.so_sao = so_sao;
		this.binh_luan = binh_luan;
	}
	
	

	public int getId_hoa_don() {
		return id_hoa_don;
	}

	public void setId_hoa_don(int id_hoa_don) {
		this.id_hoa_don = id_hoa_don;
	}

	public int getSo_sao() {
		return so_sao;
	}

	public void setSo_sao(int so_sao) {
		this.so_sao = so_sao;
	}

	public String getBinh_luan() {
		return binh_luan;
	}

	public void setBinh_luan(String binh_luan) {
		this.binh_luan = binh_luan;
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
