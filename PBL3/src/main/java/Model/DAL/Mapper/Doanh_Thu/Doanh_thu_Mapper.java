package Model.DAL.Mapper.Doanh_Thu;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DAL.Mapper.RowMapper;
import Model.DTO.Doanh_Thu.Doanh_thu;

public class Doanh_thu_Mapper implements RowMapper<Doanh_thu>{

	@Override
	public Doanh_thu mapRow(ResultSet rs) {
		
		Doanh_thu doanh_thu = null;
		try {
			doanh_thu = new Doanh_thu(rs.getInt("doanh_thu"),
												rs.getInt("tong_so_don"),
												rs.getInt("tong_san_pham"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return doanh_thu;
	}

}
