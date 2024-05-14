package Entity.Don_Hang;

import Entity.San_Pham.Muc_san_pham;
import Entity.San_Pham.San_pham;

public class Gio_hang {
	protected int id_gio_hang;
	protected int id_muc_san_pham;
	protected int so_luong;
	protected Muc_san_pham muc_san_pham;
	
	public Gio_hang(int id_gio_hang, int id_muc_san_pham, int so_luong) {
		super();
		this.id_gio_hang = id_gio_hang;
		this.id_muc_san_pham = id_muc_san_pham;
		this.so_luong = so_luong;
	}
	public int getId_gio_hang() {
		return id_gio_hang;
	}
	public void setId_gio_hang(int id_gio_hang) {
		this.id_gio_hang = id_gio_hang;
	}
	
	public int getId_muc_san_pham() {
		return id_muc_san_pham;
	}
	public void setId_muc_san_pham(int id_muc_san_pham) {
		this.id_muc_san_pham = id_muc_san_pham;
	}
	public int getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
	public Muc_san_pham getMuc_san_pham() {
		return muc_san_pham;
	}
	public void setMuc_san_pham(Muc_san_pham muc_san_pham) {
		this.muc_san_pham = muc_san_pham;
	}
	
	
}
