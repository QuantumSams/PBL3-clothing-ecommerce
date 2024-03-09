package Entity;

import java.net.HttpURLConnection;

public class Login{
	public String ten_dang_nhap;
	public String mat_khau;
	
	public Login(String ten_dang_nhap, String mat_khau) {
		this.ten_dang_nhap = ten_dang_nhap;
		this.mat_khau = mat_khau;
	}
	
	public String getTen_dang_nhap() {
		return ten_dang_nhap;
	}
	
	public void setTen_dang_nhap(String ten_dang_nhap) {
		this.ten_dang_nhap = ten_dang_nhap;
	}
	
	public String getMat_khau() {
		return mat_khau;
	}
	
	public void setMat_khau(String mat_khau) {
		this.mat_khau = mat_khau;
	}
	
	@Override
	public String toString(){
		return "ten dang nhap" + ten_dang_nhap + " mat khau: " + mat_khau; 
	}
	
}
