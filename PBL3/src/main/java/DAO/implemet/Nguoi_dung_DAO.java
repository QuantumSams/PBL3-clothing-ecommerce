package DAO.implemet;

import java.sql.Date;
import java.util.List;

import DAO.AbstractDao;
import Entity.Nguoi_Dung.Nguoi_dung;
import Mapper.Nguoi_Dung.Nguoi_dung_Mapper;

public class Nguoi_dung_DAO extends AbstractDao {
	
	public Nguoi_dung Dang_nhap(String user, String password) {
		String sql1 = "SELECT * FROM thong_tin_dang_nhap WHERE (so_dien_thoai = ? OR email = ?) AND mat_khau = ? ";
		
		int id = new AbstractDao().count(sql1, user, user, password);
		
		String sql2 = 	" SELECT thong_tin_dang_nhap.id, ho_ten, gioi_tinh, ngay_sinh, dia_chi, anh_dai_dien, thong_tin_dang_nhap.so_dien_thoai, thong_tin_dang_nhap.email, phan_quyen_nguoi_dung.ten_phan_quyen"
						+ " FROM thong_tin_nguoi_dung" 
						+ " INNER JOIN thong_tin_dang_nhap ON thong_tin_nguoi_dung.id = thong_tin_dang_nhap.id"
						+ " INNER JOIN phan_quyen_nguoi_dung ON phan_quyen_nguoi_dung.id = thong_tin_dang_nhap.id_phan_quyen_nguoi_dung"
						+ " WHERE thong_tin_dang_nhap.id = ? ";
		List<Nguoi_dung> l = new AbstractDao().query(sql2, new Nguoi_dung_Mapper(), id);
		
		if(l.size() != 0)
			return l.get(0);
		else return null;
	}
	
	public void Dang_ky(Nguoi_dung nguoi_dung) {	
		String query1 = "INSERT INTO thong_tin_dang_nhap VALUES (?, ?, ?, ?, ?);";
		String query2 = "INSERT INTO thong_tin_nguoi_dung VALUES (?, ?, ?, ?, ?, ?)";
		
		new AbstractDao().insert(query1, nguoi_dung.getId_nguoi_dung(), nguoi_dung.getSo_dien_thoai(), nguoi_dung.getEmail(), nguoi_dung.getPassword(), 1);
		new AbstractDao().insert(query2, nguoi_dung.getId_nguoi_dung(), nguoi_dung.getHo_ten(), nguoi_dung.isGioi_tinh(), nguoi_dung.getNgay_sinh(), nguoi_dung.getDia_chi(), nguoi_dung.getAnh_dai_dien());
	}
	
	
	public void Update_thong_tin(Nguoi_dung nguoi_dung) {
		String sql1 = "UPDATE thong_tin_dang_nhap SET so_dien_thoai = ?, email = ? WHERE id = ?;";
		String sql2 = "UPDATE thong_tin_nguoi_dung SET ho_ten = ?, gioi_tinh = ?, ngay_sinh = ?, dia_chi = ?, anh_dai_dien = ? WHERE id = ?;";
		
		new AbstractDao().update(sql1, nguoi_dung.getSo_dien_thoai(), nguoi_dung.getEmail(), nguoi_dung.getId_nguoi_dung());
		new AbstractDao().update(sql2, nguoi_dung.getHo_ten(), nguoi_dung.isGioi_tinh(), nguoi_dung.getNgay_sinh(), nguoi_dung.getDia_chi() , nguoi_dung.getAnh_dai_dien(), nguoi_dung.getId_nguoi_dung());
	}
	
	public int count_email(String email) {
		String query = "SELECT COUNT(email) FROM thong_tin_dang_nhap WHERE email = ?";
		return new AbstractDao().count(query, email);
	}
	
	public int count_so_dien_thoai(String so_dien_thoat) {
		String query = "SELECT COUNT(so_dien_thoai) FROM thong_tin_dang_nhap WHERE so_dien_thoai = ?";
		return new AbstractDao().count(query, so_dien_thoat);
	}
	
	public List<Nguoi_dung> GetNhanVien(){
		String sql = 	" SELECT thong_tin_dang_nhap.id, ho_ten, gioi_tinh, ngay_sinh, dia_chi, anh_dai_dien, thong_tin_dang_nhap.so_dien_thoai, thong_tin_dang_nhap.email, phan_quyen_nguoi_dung.ten_phan_quyen"
						+ " FROM thong_tin_nguoi_dung" 
						+ " INNER JOIN thong_tin_dang_nhap ON thong_tin_nguoi_dung.id = thong_tin_dang_nhap.id"
						+ " INNER JOIN phan_quyen_nguoi_dung ON phan_quyen_nguoi_dung.id = thong_tin_dang_nhap.id_phan_quyen_nguoi_dung"
						+ " WHERE id_phan_quyen_nguoi_dung = 2 ";
		return new AbstractDao().query(sql, new Nguoi_dung_Mapper());
	}
	
	public List<Nguoi_dung> SearchNhanVien(String search){
		String sql = 	" SELECT thong_tin_dang_nhap.id, ho_ten, gioi_tinh, ngay_sinh, dia_chi, anh_dai_dien, thong_tin_dang_nhap.so_dien_thoai, thong_tin_dang_nhap.email, phan_quyen_nguoi_dung.ten_phan_quyen"
						+ " FROM thong_tin_nguoi_dung" 
						+ " INNER JOIN thong_tin_dang_nhap ON thong_tin_nguoi_dung.id = thong_tin_dang_nhap.id"
						+ " INNER JOIN phan_quyen_nguoi_dung ON phan_quyen_nguoi_dung.id = thong_tin_dang_nhap.id_phan_quyen_nguoi_dung"
						+ " WHERE id_phan_quyen_nguoi_dung = 2 AND ho_ten LIKE '%"+search+"%'";
		return new AbstractDao().query(sql, new Nguoi_dung_Mapper());
	}
}
