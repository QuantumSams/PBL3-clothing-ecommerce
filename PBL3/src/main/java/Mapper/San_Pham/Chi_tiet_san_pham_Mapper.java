package Mapper.San_Pham;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.San_Pham.Chi_tiet_san_pham;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Size;
import Mapper.RowMapper;

public class Chi_tiet_san_pham_Mapper implements RowMapper<Chi_tiet_san_pham>{

	@Override
	public Chi_tiet_san_pham mapRow(ResultSet rs) {
		try {
			Chi_tiet_san_pham chi_tiet = new Chi_tiet_san_pham(	
												rs.getInt("id_thong_tin_chi_tiet_san_pham"),
												rs.getInt("id_san_pham"),
												rs.getInt("so_luong_trong_kho"),
												new Mau_sac(),
												new Size(),
												rs.getFloat("id_san_pham"),
												new ArrayList<String>(), 
												rs.getString("thong_tin_chi_tiet"));
			
			return chi_tiet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
