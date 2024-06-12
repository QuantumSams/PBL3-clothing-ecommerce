package Model.DAL.Mapper.San_Pham;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.DAL.Mapper.RowMapper;
import Model.DTO.San_Pham.Muc_san_pham;
import Model.DTO.San_Pham.San_pham;

public class San_pham_Mapper implements RowMapper<San_pham>{

	@Override
	public San_pham mapRow(ResultSet rs) {
		try {
			San_pham san_pham = new San_pham(
										rs.getInt("id_san_pham"),
										rs.getString("ten_danh_muc_san_pham"),
										rs.getString("ten_san_pham"),  
										rs.getString("ten_nhan_hang"),
										rs.getString("ten_chat_lieu"),
										rs.getString("thong_tin_chung"),
										rs.getString("thong_tin_chi_tiet"),
										new ArrayList<String>(), 
										new ArrayList<Muc_san_pham>());
			
			return san_pham;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
