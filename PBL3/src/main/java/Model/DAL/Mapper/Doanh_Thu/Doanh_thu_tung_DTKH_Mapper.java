package Model.DAL.Mapper.Doanh_Thu;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DAL.Mapper.RowMapper;
import Model.DTO.Doanh_Thu.Doanh_thu_tung_DTKH;

public class Doanh_thu_tung_DTKH_Mapper implements RowMapper<Doanh_thu_tung_DTKH>{

	@Override
	public Doanh_thu_tung_DTKH mapRow(ResultSet rs) {
		Doanh_thu_tung_DTKH doanh_thu_tung_DTKH = null;
		try {
			doanh_thu_tung_DTKH = new Doanh_thu_tung_DTKH(rs.getString("ten_danh_muc_san_pham"), rs.getInt("so_san_pham_cuaDTKH"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doanh_thu_tung_DTKH;
	}

}