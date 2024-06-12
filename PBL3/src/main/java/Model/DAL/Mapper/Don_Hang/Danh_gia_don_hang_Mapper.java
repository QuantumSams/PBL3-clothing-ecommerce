package Model.DAL.Mapper.Don_Hang;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DAL.Mapper.RowMapper;
import Model.DTO.Don_Hang.Danh_gia_don_hang;

public class Danh_gia_don_hang_Mapper  implements RowMapper<Danh_gia_don_hang>{

	@Override
	public Danh_gia_don_hang mapRow(ResultSet rs) {
		Danh_gia_don_hang danh_gia_don_hang = null;
		try {
			danh_gia_don_hang= new Danh_gia_don_hang(rs.getInt(0),
														rs.getInt(0) , 	
														rs.getInt(0), 
														rs.getString(0));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danh_gia_don_hang;
	}
	
}
