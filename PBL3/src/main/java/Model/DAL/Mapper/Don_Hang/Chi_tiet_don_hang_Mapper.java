package Model.DAL.Mapper.Don_Hang;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DAL.Mapper.RowMapper;
import Model.DTO.Don_Hang.Chi_tiet_don_hang;

public class Chi_tiet_don_hang_Mapper implements RowMapper<Chi_tiet_don_hang>{

	@Override
	public Chi_tiet_don_hang mapRow(ResultSet rs) {
		try {
			Chi_tiet_don_hang chi_tiet_don_hang = new Chi_tiet_don_hang(rs.getInt("id_don_hang"),
																		rs.getInt("id_muc_san_pham"),
																		rs.getInt("so_luong"),
																		rs.getInt("gia_tien"));
			
			return chi_tiet_don_hang;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
