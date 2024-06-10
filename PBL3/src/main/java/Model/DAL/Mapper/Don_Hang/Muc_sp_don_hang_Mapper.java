package Model.DAL.Mapper.Don_Hang;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DAL.Mapper.RowMapper;
import Model.DTO.Don_Hang.Muc_sp_don_hang;

public class Muc_sp_don_hang_Mapper implements RowMapper<Muc_sp_don_hang>{

	@Override
	public Muc_sp_don_hang mapRow(ResultSet rs) {
		Muc_sp_don_hang muc_sp_don_hang = null;
		try {
			muc_sp_don_hang = new Muc_sp_don_hang(
					rs.getInt("id_muc_san_pham"), 
					rs.getString("ten_san_pham"), 
					rs.getString("ten_size"), 
					rs.getString("ten_mau"), 
					rs.getInt("so_luong"), 
					rs.getInt("gia_tien"), 
					rs.getString("anh_muc_san_pham"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return muc_sp_don_hang;
	}

}
