package DAO.implemet;

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
	
}
