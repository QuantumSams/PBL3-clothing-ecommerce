package Mapper.Nguoi_Dung;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Nguoi_Dung.Chu_cua_hang;
import Entity.Nguoi_Dung.Khach_hang;
import Entity.Nguoi_Dung.Nguoi_dung;
import Entity.Nguoi_Dung.Nhan_vien;
import Entity.Nguoi_Dung.Phan_quyen_nguoi_dung;
import Mapper.RowMapper;

public class Nguoi_dung_Mapper implements RowMapper<Nguoi_dung>{

	@Override
	public Nguoi_dung mapRow(ResultSet rs) {
		try {
			Nguoi_dung nguoi_dung = null;
			
			String phan_quyen_nguoi_dung = rs.getString("ten_phan_quyen");
			
			if(phan_quyen_nguoi_dung.equals(Phan_quyen_nguoi_dung.CHU_CUA_HANG.toString())) {
				nguoi_dung = new Chu_cua_hang(	rs.getInt("id"),
												rs.getString("ho_ten"), 
												rs.getBoolean("gioi_tinh"), 
												rs.getDate("ngay_sinh"), 
												rs.getString("dia_chi"), 
												rs.getString("anh_dai_dien"), 
												rs.getString("so_dien_thoai"), 
												rs.getString("email"), 
												phan_quyen_nguoi_dung
												);
			}else if(phan_quyen_nguoi_dung.equals(Phan_quyen_nguoi_dung.NHAN_VIEN.toString())) {
				nguoi_dung = new Nhan_vien(		rs.getInt("id"),
												rs.getString("ho_ten"), 
												rs.getBoolean("gioi_tinh"), 
												rs.getDate("ngay_sinh"), 
												rs.getString("dia_chi"), 
												rs.getString("anh_dai_dien"), 
												rs.getString("so_dien_thoai"), 
												rs.getString("email"), 
												phan_quyen_nguoi_dung
												);
			}else if(phan_quyen_nguoi_dung.equals(Phan_quyen_nguoi_dung.KHACH_HANG.toString())) {
				nguoi_dung = new Khach_hang(	rs.getInt("id"),
												rs.getString("ho_ten"), 
												rs.getBoolean("gioi_tinh"), 
												rs.getDate("ngay_sinh"), 
												rs.getString("dia_chi"), 
												rs.getString("anh_dai_dien"), 
												rs.getString("so_dien_thoai"), 
												rs.getString("email"), 
												phan_quyen_nguoi_dung
												);
			}
			return nguoi_dung;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
