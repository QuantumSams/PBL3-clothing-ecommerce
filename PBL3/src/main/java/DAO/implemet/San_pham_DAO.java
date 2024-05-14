package DAO.implemet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Connect.JDBC_Unit;
import DAO.AbstractDao;
import Entity.San_Pham.Muc_san_pham;
import Entity.San_Pham.San_pham;
import Mapper.San_Pham.Muc_san_pham_Mapper;
import Mapper.San_Pham.San_pham_Mapper;

public class San_pham_DAO extends AbstractDao {
	
	public void add_san_pham(San_pham san_pham) {
		String query = "INSERT INTO san_pham VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		insert(query, 	san_pham.getId_san_pham(), 
						san_pham.getTen_san_pham(),
						san_pham.getTen_nhan_hang(),
						san_pham.getChat_lieu(),
						san_pham.getThong_tin_chung(),
						san_pham.getThong_tin_chi_tiet(),
						san_pham.getId_danh_muc_san_pham());
		
		if(san_pham.getAnh_san_pham().size() != 0) {
			for(int i = 0; i < san_pham.getAnh_san_pham().size(); ++i) {
				int id = new Random().nextInt(100000);
				query = "INSERT INTO anh_san_pham VALUES (?, ?, ?)";
				
				insert(query, id, san_pham.getId_san_pham(), san_pham.getAnh_san_pham().get(i));
			}
		}
		
		if(san_pham.getMuc_san_pham().size() != 0) {
			for(Muc_san_pham muc_san_pham : san_pham.getMuc_san_pham()) {
				add_muc_san_pham(muc_san_pham);
			}
		}
	}
	
	public void add_muc_san_pham(Muc_san_pham muc_san_pham) {
		String query = "INSERT INTO muc_san_pham VALUES (?, ?, ?, ?, ?, ?, ?)";
		int id = new Random().nextInt();
		
		insert(query, 	id, 
						muc_san_pham.getId_san_pham(),
						muc_san_pham.getSo_luong_trong_kho(),
						muc_san_pham.getMau_sac_san_pham().getId_mau_sac(),
						muc_san_pham.getKich_thuoc_san_pham().getId_size(),
						muc_san_pham.getGia_tien(),
						muc_san_pham.getAnh_chi_tiet()
						);
		
	}
	
	public List<String> get_anh_san_pham(String query, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<String> list = new ArrayList<String>();
		try {
			connection = JDBC_Unit.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(query);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			connection.commit();
			
			while(resultSet.next()) {
				String t = resultSet.getString("duong_dan_anh");
				list.add(t);
			}
			
			return list;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	
	public List<San_pham> getList_San_Pham(){
		
		String query = "SELECT id_san_pham, danh_muc_san_pham.ten_danh_muc_san_pham, ten_san_pham, ten_nhan_hang, ten_chat_lieu, thong_tin_chung, thong_tin_chi_tiet "
							+ "FROM san_pham INNER JOIN  danh_muc_san_pham ON san_pham.id_danh_muc_san_pham = danh_muc_san_pham.id_danh_muc_san_pham";
		
		List<San_pham> list_san_pham = new AbstractDao().query(query, new San_pham_Mapper());
		
		query = "select duong_dan_anh from anh_san_pham where id_san_pham = ?";
		List<String> list = null;
		
		for(int i = 0; i < list_san_pham.size(); ++i) {
			list = get_anh_san_pham(query, list_san_pham.get(i).getId_san_pham());
			list_san_pham.get(i).setAnh_san_pham(list);
		}
		return list_san_pham;
	}
	
	public List<San_pham> getList_San_Pham(String Search){
		
		String query = "SELECT id_san_pham, danh_muc_san_pham.ten_danh_muc_san_pham, ten_san_pham, ten_nhan_hang, ten_chat_lieu, thong_tin_chung, thong_tin_chi_tiet "
							+ "FROM san_pham INNER JOIN  danh_muc_san_pham ON san_pham.id_danh_muc_san_pham = danh_muc_san_pham.id_danh_muc_san_pham WHERE ten_san_pham LIKE ? ";
		
		List<San_pham> list_san_pham = new AbstractDao().query(query, new San_pham_Mapper(), "'%"+Search+"%'");
		
		query = "select duong_dan_anh from anh_san_pham where id_san_pham = ?";
		List<String> list = null;
		
		for(int i = 0; i < list_san_pham.size(); ++i) {
			list = get_anh_san_pham(query, list_san_pham.get(i).getId_san_pham());
			list_san_pham.get(i).setAnh_san_pham(list);
		}
		return list_san_pham;
	}
	
	public List<Muc_san_pham> getList_muc_san_pham(int id){
		String query = 	"SELECT muc_san_pham.id_muc_san_pham, id_san_pham, so_luong_trong_kho, muc_san_pham.id_mau_sac, ten_mau, mau_sac.duong_dan_anh, muc_san_pham.id_size, ten_size,  anh_muc_san_pham AS anh_muc, gia_tien\r\n"
						+ "FROM muc_san_pham \r\n"
						+ "INNER JOIN mau_sac ON muc_san_pham.id_mau_sac = mau_sac.id_mau_sac\r\n"
						+ "INNER JOIN size ON muc_san_pham.id_size = size.id_size  WHERE id_san_pham = ?";
		
		return query(query, new Muc_san_pham_Mapper(), id);
	}
	
	public Muc_san_pham getMuc_san_pham(int id) {
		String query = 	"SELECT muc_san_pham.id_muc_san_pham, id_san_pham, so_luong_trong_kho, muc_san_pham.id_mau_sac, ten_mau, mau_sac.duong_dan_anh, muc_san_pham.id_size, ten_size,  anh_muc_san_pham AS anh_muc, gia_tien\r\n"
						+ "FROM muc_san_pham \r\n"
						+ "INNER JOIN mau_sac ON muc_san_pham.id_mau_sac = mau_sac.id_mau_sac\r\n"
						+ "INNER JOIN size ON muc_san_pham.id_size = size.id_size  WHERE muc_san_pham.id_muc_san_pham = ?";

		return query(query, new Muc_san_pham_Mapper(), id).get(0);
	}
	
	public San_pham getProduct_by_ID(String id) {
		String query = "SELECT id_san_pham, danh_muc_san_pham.ten_danh_muc_san_pham, ten_san_pham, ten_nhan_hang, ten_chat_lieu, thong_tin_chung, thong_tin_chi_tiet "
				+ "FROM san_pham INNER JOIN  danh_muc_san_pham ON san_pham.id_danh_muc_san_pham = danh_muc_san_pham.id_danh_muc_san_pham WHERE id_san_pham = ?";
		
		List<San_pham> list_san_pham = new AbstractDao().query(query, new San_pham_Mapper(), id);
		
		query = "select duong_dan_anh from anh_san_pham where id_san_pham = ?";
		List<String> list = null;
		
		for(int i = 0; i < list_san_pham.size(); ++i) {
			list = get_anh_san_pham(query, list_san_pham.get(i).getId_san_pham());
			list_san_pham.get(i).setAnh_san_pham(list);
			List<Muc_san_pham> muc_san_pham = getList_muc_san_pham(list_san_pham.get(i).getId_san_pham());
			list_san_pham.get(i).setMuc_san_pham(muc_san_pham);
		}
		
		
		return list_san_pham.get(0);
	}
}
