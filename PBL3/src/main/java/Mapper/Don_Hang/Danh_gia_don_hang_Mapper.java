package Mapper.Don_Hang;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Don_Hang.Danh_gia_don_hang;
import Mapper.RowMapper;

public class Danh_gia_don_hang_Mapper implements RowMapper<Danh_gia_don_hang>{

	@Override
	public Danh_gia_don_hang mapRow(ResultSet rs) {
		try {
			Danh_gia_don_hang danh_gia = new Danh_gia_don_hang(	rs.getInt("id_don_hang"),
																rs.getInt("diem_danh_gia"),
																rs.getString("binh_luan") );
			
			return danh_gia;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
