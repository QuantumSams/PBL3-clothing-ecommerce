package Model.DAL.Mapper.San_Pham;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.DAL.DAO.implemet.Mau_sac_DAO;
import Model.DAL.DAO.implemet.Size_DAO;
import Model.DAL.Mapper.RowMapper;
import Model.DAL.Specification.Implements.Mau_sac.FindColorByID;
import Model.DAL.Specification.Implements.Size.FindSizeByID;
import Model.DTO.San_Pham.Muc_san_pham;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Model.DTO.San_Pham.Thuoc_Tinh_San_Pham.Size;



public class Muc_san_pham_Mapper implements RowMapper<Muc_san_pham>{

	@Override
	public Muc_san_pham mapRow(ResultSet rs) {
		try {
			Muc_san_pham muc_san_pham = new Muc_san_pham(	
												rs.getInt("id_muc_san_pham"),
												rs.getInt("id_san_pham"),
												rs.getInt("so_luong_trong_kho"),
												new Mau_sac_DAO().findBySpacification(new FindColorByID(rs.getInt("id_mau_sac"))).get(0),
												new Size_DAO().findBySpacification(new FindSizeByID(rs.getInt("id_size"))).get(0),
												rs.getInt("gia_tien"),
												rs.getString("anh_muc_san_pham"));
			
			return muc_san_pham;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
