package Mapper.San_Pham;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.San_Pham.Danh_muc_san_pham;
import Mapper.RowMapper;

public class Danh_muc_san_pham_Mapper implements RowMapper<Danh_muc_san_pham>{

	@Override
	public Danh_muc_san_pham mapRow(ResultSet rs) {
		try {
			Danh_muc_san_pham danh_muc = new Danh_muc_san_pham(	
													rs.getInt("id_danh_muc_san_pham"),
													rs.getString("ten_loai_san_pham"),
													rs.getString("ten_doi_tuong_khach_hang"),
													rs.getString("ten_danh_muc_san_pham")
													);
			
			return danh_muc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
