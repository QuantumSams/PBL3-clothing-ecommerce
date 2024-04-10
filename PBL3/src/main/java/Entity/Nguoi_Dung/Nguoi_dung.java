package Entity.Nguoi_Dung;

import java.sql.Date;

import Entity.Thong_tin;

public abstract class Nguoi_dung implements Thong_tin{
	protected int id_nguoi_dung;
	protected String ho_ten;
	protected boolean gioi_tinh;
	protected String ngay_sinh;
	protected String dia_chi;
	protected String anh_dai_dien;
	protected String so_dien_thoai;
	protected String email;
	protected String phan_quyen_nguoi_dung;
	
	public Nguoi_dung(int id_nguoi_dung, String ho_ten, boolean gioi_tinh, String ngay_sinhDate, String dia_chi,
			String anh_dai_dien, String so_dien_thoai, String email, String phan_quyen_nguoi_dung) {
		this.id_nguoi_dung = id_nguoi_dung;
		this.ho_ten = ho_ten;
		this.gioi_tinh = gioi_tinh;
		this.ngay_sinh = ngay_sinhDate;
		this.dia_chi = dia_chi;
		this.anh_dai_dien = anh_dai_dien;
		this.so_dien_thoai = so_dien_thoai;
		this.email = email;
		this.phan_quyen_nguoi_dung = phan_quyen_nguoi_dung;
	}
	public int getId_nguoi_dung() {
		return id_nguoi_dung;
	}
	public void setId_nguoi_dung(int id_nguoi_dung) {
		this.id_nguoi_dung = id_nguoi_dung;
	}
	public String getHo_ten() {
		return ho_ten;
	}
	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}
	public boolean isGioi_tinh() {
		return gioi_tinh;
	}
	public void setGioi_tinh(boolean gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}
	public String getNgay_sinh() {
		return ngay_sinh;
	}
	public void setNgay_sinh(String ngay_sinhDate) {
		this.ngay_sinh = ngay_sinhDate;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getAnh_dai_dien() {
		return anh_dai_dien;
	}
	public void setAnh_dai_dien(String anh_dai_dien) {
		this.anh_dai_dien = anh_dai_dien;
	}
	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}
	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhan_quyen_nguoi_dung() {
		return phan_quyen_nguoi_dung;
	}
	public void setPhan_quyen_nguoi_dung(String phan_quyen_nguoi_dung) {
		this.phan_quyen_nguoi_dung = phan_quyen_nguoi_dung;
	}
	
	@Override
	public String toString() {
		return "Nguoi_dung [id_nguoi_dung=" + id_nguoi_dung + ", ho_ten=" + ho_ten + ", gioi_tinh=" + gioi_tinh
				+ ", ngay_sinh=" + ngay_sinh + ", dia_chi=" + dia_chi + ", anh_dai_dien=" + anh_dai_dien
				+ ", so_dien_thoai=" + so_dien_thoai + ", email=" + email + ", phan_quyen_nguoi_dung="
				+ phan_quyen_nguoi_dung + "]";
	}
	
	
}
