package Model.DAL.Mapper.San_Pham;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DAL.Mapper.RowMapper;
import Model.DTO.Don_Hang.Gio_hang;

public class Gio_hang_Mapper implements RowMapper<Gio_hang>{

	@Override
	public Gio_hang mapRow(ResultSet rs) {
		
		try {
			return new Gio_hang(rs.getInt("id_gio_hang"),
								rs.getInt("id_khach_hang"),
								rs.getInt("id_muc_san_pham"),
								rs.getInt("so_luong"));
		} catch (SQLException e) {
			return null;
		}
	}

}
