package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Don_Hang.Don_hang;

public class Don_hang_Mapper implements RowMapper<Don_hang>{

	@Override
	public Don_hang mapRow(ResultSet rs) {
		
		try {
			Don_hang don_hang = new Don_hang();
			
			don_hang.setId_hoa_don(rs.getInt("id_don_hang"));
			don_hang.setId_thong_tin_chi_tiet_san_pham(rs.getInt("id_thong_tin_chi_tiet_san_pham"));
			don_hang.setSo_luong(rs.getInt("so_luong"));
			don_hang.setTong_tien(rs.getInt("tong_tien"));
			don_hang.setId_khach_hang(rs.getInt("id_khach_hang"));
			don_hang.setId_nhan_vien(rs.getInt("id_nhan_vien"));
			don_hang.setDia_chi_giao_dich(rs.getString("dia_chi_giao_dich"));
			don_hang.setNgay_gio_dat_don_hang(rs.getDate("ngay_gio_dat_don_hang"));
			don_hang.setNgay_gio_nhan_don_hang(rs.getDate("ngay_gio_nhan_don_hang"));
			don_hang.setTrang_thai_don_hang(rs.getString("trang_thai_don_hang"));
			 
			return don_hang;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
