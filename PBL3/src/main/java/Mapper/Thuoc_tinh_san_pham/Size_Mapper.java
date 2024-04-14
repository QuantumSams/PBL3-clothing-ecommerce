package Mapper.Thuoc_tinh_san_pham;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.San_Pham.Thuoc_Tinh_San_Pham.Size;
import Mapper.RowMapper;

public class Size_Mapper implements RowMapper<Size>{

	@Override
	public Size mapRow(ResultSet rs) {
		try {
			Size size = new Size();
			
			size.setId_size(rs.getInt("id_size"));
			size.setTen_size(rs.getString("ten_size"));
			
			return size;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
