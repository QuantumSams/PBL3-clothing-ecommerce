package Mapper.San_Pham;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.San_Pham.San_pham;
import Entity.San_Pham.Chi_tiet_san_pham;
import Mapper.RowMapper;

public class San_pham_Mapper implements RowMapper<San_pham>{

	@Override
	public San_pham mapRow(ResultSet rs) {
		try {
			San_pham san_pham = new San_pham(rs.getInt("id_san_pham"),
										rs.getInt("id_danh_muc_san_pham"),
										rs.getString("ten_san_pham"),  
										rs.getString("ten_nhan_hang"),
										rs.getString("thong_tin_chung"),
										rs.getString("thong_tin_chi_tiet"),
										new ArrayList<String>(), 
										new ArrayList<Chi_tiet_san_pham>());
			
			return san_pham;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
