package Model.DAL.Mapper.Don_Hang;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DAL.Mapper.RowMapper;
import Model.DTO.Don_Hang.Chi_tiet_don_hang;
import Model.DTO.Don_Hang.Xem_don_hang;

public class Xem_don_hang_Mapper implements RowMapper<Xem_don_hang>{

	@Override
	public Xem_don_hang mapRow(ResultSet rs) {
		try {
			Xem_don_hang xem_don_hang = new Xem_don_hang(rs.getInt("id_don_hang"),
														rs.getString("ho_ten"),
														rs.getInt("gia_tri"),
														rs.getDate("ngay_gio_dat"),
														rs.getDate("ngay_gio_nhan"),
														rs.getString("trang_thai_don_hang"));
			
			return xem_don_hang;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
