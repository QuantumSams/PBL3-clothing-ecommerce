package Entity.San_Pham.Thuoc_Tinh_San_Pham;

public class Mau_sac{
	
	private int id_mau_sac;
	private String ten_mau;
	private String anh_mau_sac;
	public Mau_sac(int id_mau_sac, String ten_mau, String anh_mau_sac) {
		super();
		this.id_mau_sac = id_mau_sac;
		this.ten_mau = ten_mau;
		this.anh_mau_sac = anh_mau_sac;
	}
	
	public Mau_sac() {
		
	}
		
	public int getId_mau_sac() {
		return id_mau_sac;
	}

	public void setId_mau_sac(int id_mau_sac) {
		this.id_mau_sac = id_mau_sac;
	}

	public String getTen_mau() {
		return ten_mau;
	}

	public void setTen_mau(String ten_mau) {
		this.ten_mau = ten_mau;
	}

	public String getAnh_mau_sac() {
		return anh_mau_sac;
	}

	public void setAnh_mau_sac(String anh_mau_sac) {
		this.anh_mau_sac = anh_mau_sac;
	}

	@Override
	public String toString() {
		return "Mau_sac [id_mau_sac=" + id_mau_sac + ", ten_mau=" + ten_mau + ", anh_mau_sac=" + anh_mau_sac + "]";
	}
}
