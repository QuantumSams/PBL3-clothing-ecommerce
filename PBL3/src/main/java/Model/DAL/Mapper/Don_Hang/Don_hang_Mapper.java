package Model.DAL.Mapper.Don_Hang;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DAL.Mapper.RowMapper;
import Model.DTO.Don_Hang.Don_hang;

public class Don_hang_Mapper implements RowMapper<Don_hang>{

	@Override
	public Don_hang mapRow(ResultSet rs) {
		
		try {
			Don_hang don_hang = new Don_hang(
					rs.getInt("id_don_hang"),
					rs.getInt("gia_tri"),
					rs.getString("ten_nhan_vien"),
					rs.getString("ten_khach_hang"),
					rs.getDate("thoi_gian_dat"),
					rs.getDate("thoi_gian_nhan"),
					rs.getString("trang_thai_don_hang"),
					rs.getInt("so_luong"),
					rs.getInt("so_sao_danh_gia")
					);
			
			
			 
			return don_hang;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
