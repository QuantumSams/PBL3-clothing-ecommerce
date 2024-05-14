package Mapper.San_Pham;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.San_Pham.Muc_san_pham;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Size;
import Mapper.RowMapper;

public class Muc_san_pham_Mapper implements RowMapper<Muc_san_pham>{

	@Override
	public Muc_san_pham mapRow(ResultSet rs) {
		try {
			Muc_san_pham chi_tiet = new Muc_san_pham(	
												rs.getInt("id_muc_san_pham"),
												rs.getInt("id_san_pham"),
												rs.getInt("so_luong_trong_kho"),
												new Mau_sac(rs.getInt("id_mau_sac"), rs.getString("ten_mau"), rs.getString("duong_dan_anh")),
												new Size(rs.getInt("id_size"), rs.getString("ten_size")),
												rs.getInt("gia_tien"),
												rs.getString("anh_muc"));
			
			return chi_tiet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
