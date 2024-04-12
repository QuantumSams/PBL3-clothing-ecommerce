package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;

public class Mau_sac_Mapper implements RowMapper<Mau_sac>{

	@Override
	public Mau_sac mapRow(ResultSet rs) {
		try {
			Mau_sac mau_sac = new Mau_sac();
			
			mau_sac.setId_mau_sac(rs.getInt("id_mau_sac"));
			mau_sac.setAnh_mau_sac(rs.getString("duong_dan_anh"));
			mau_sac.setTen_mau(rs.getString("ten_mau"));
			
			return mau_sac;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
