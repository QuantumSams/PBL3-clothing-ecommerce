package Model.DTO.Don_Hang;

public class Danh_gia_don_hang{
	protected int id_hoa_don;
	protected int so_sao;
	protected String binh_luan;
	
	public Danh_gia_don_hang(int id_hoa_don, int so_sao, String binh_luan) {
		super();
		this.id_hoa_don = id_hoa_don;
		this.so_sao = so_sao;
		this.binh_luan = binh_luan;
	}
	
	public Danh_gia_don_hang() {
		
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
}
