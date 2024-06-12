package Model.DAL.Mapper.Don_Hang;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DAL.Mapper.RowMapper;
import Model.DTO.Don_Hang.Don_hang_chi_tiet;

public class Don_hang_chi_tiet_Mapper implements RowMapper<Don_hang_chi_tiet>{

	@Override
	public Don_hang_chi_tiet mapRow(ResultSet rs) {
		Don_hang_chi_tiet don_hang_chi_tiet = null;
		try {
			don_hang_chi_tiet = new Don_hang_chi_tiet(
					rs.getInt("id_don_hang"),
					rs.getInt("gia_tri"),
					rs.getString("ten_nhan_vien"),
					rs.getString("ten_khach_hang"),
					rs.getTimestamp("thoi_gian_dat"),
					rs.getTimestamp("thoi_gian_nhan"),
					rs.getString("trang_thai_don_hang"),
					rs.getInt("so_luong"),
					rs.getInt("so_sao_danh_gia"),
					rs.getString("so_dien_thoai"),
					rs.getString("dia_chi_giao_dich"),
					rs.getString("ghi_chu"),
					rs.getString("binh_luan"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return don_hang_chi_tiet;
	}
	
}
