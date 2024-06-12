package Model.DTO.Don_Hang;

public class Danh_gia_don_hang {
	private int id_danh_gia;
	private int id_don_hang;
	private int diem_danh_gia;
	private String binh_luan;
	public Danh_gia_don_hang() {
		
	}
	public Danh_gia_don_hang(int id_danh_gia, int id_don_hang, int diem_danh_gia, String binh_luan) {
		super();
		this.id_danh_gia = id_danh_gia;
		this.id_don_hang = id_don_hang;
		this.diem_danh_gia = diem_danh_gia;
		this.binh_luan = binh_luan;
	}
	public int getId_danh_gia() {
		return id_danh_gia;
	}
	public void setId_danh_gia(int id_danh_gia) {
		this.id_danh_gia = id_danh_gia;
	}
	public int getId_don_hang() {
		return id_don_hang;
	}
	public void setId_don_hang(int id_don_hang) {
		this.id_don_hang = id_don_hang;
	}
	public int getDiem_danh_gia() {
		return diem_danh_gia;
	}
	public void setDiem_danh_gia(int diem_danh_gia) {
		this.diem_danh_gia = diem_danh_gia;
	}
	public String getBinh_luan() {
		return binh_luan;
	}
	public void setBinh_luan(String binh_luan) {
		this.binh_luan = binh_luan;
	}
	@Override
	public String toString() {
		return "Danh_gia_don_hang [id_danh_gia=" + id_danh_gia + ", id_don_hang=" + id_don_hang + ", diem_danh_gia="
				+ diem_danh_gia + ", binh_luan=" + binh_luan + "]";
	}

}
