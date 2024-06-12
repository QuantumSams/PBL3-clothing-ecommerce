package Model.DAL.Mapper.Nguoi_Dung;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DAL.Mapper.RowMapper;
import Model.DTO.Nguoi_Dung.Nguoi_dung;

public class Nguoi_dung_Mapper implements RowMapper<Nguoi_dung>{

	@Override
	public Nguoi_dung mapRow(ResultSet rs) {
		try {
			Nguoi_dung nguoi_dung = new Nguoi_dung(	rs.getInt("id"),
												rs.getString("ho_ten"), 
												rs.getBoolean("gioi_tinh"), 
												rs.getDate("ngay_sinh"), 
												rs.getString("dia_chi"), 
												rs.getString("anh_dai_dien"), 
												rs.getString("so_dien_thoai"), 
												rs.getString("email"), 
												rs.getString("ten_phan_quyen")
												);
			
			return nguoi_dung;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
