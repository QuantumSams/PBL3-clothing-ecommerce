package Model.DAL.Mapper.San_Pham;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DAL.Mapper.RowMapper;
import Model.DTO.San_Pham.Danh_muc_san_pham;

public class Danh_muc_san_pham_Mapper implements RowMapper<Danh_muc_san_pham>{

	@Override
	public Danh_muc_san_pham mapRow(ResultSet rs) {
		try {
			Danh_muc_san_pham danh_muc = new Danh_muc_san_pham();
			
			danh_muc.setId(rs.getInt("id_danh_muc_san_pham"));
			danh_muc.setParent_id(rs.getInt("parent_id"));
			danh_muc.setCategory(rs.getString("ten_danh_muc_san_pham"));
			return danh_muc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
