package Model.DAL.Mapper.Thuoc_tinh_san_pham;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DAL.Mapper.RowMapper;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Anh_san_pham;

public class Anh_san_pham_Mapper implements RowMapper<Anh_san_pham>{

	@Override
	public Anh_san_pham mapRow(ResultSet rs) {
		Anh_san_pham anh = new Anh_san_pham();
		try {
			anh.setId_anh(rs.getInt("id_anh"));
			anh.setId_san_pham(rs.getInt("id_san_pham"));
			anh.setDuong_dan_anh(rs.getString("duong_dan_anh"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return anh;
	}

}
