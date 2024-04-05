package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connect.JDBC_Unit;
import Entity.San_Pham.Danh_muc_san_pham;
import Entity.San_Pham.San_pham;
import Entity.San_Pham.Thong_tin_chi_tiet_san_pham;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;

public class DAO_San_pham {
	public static void them_danh_muc_san_pham(Danh_muc_san_pham danh_muc_san_pham) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			
			String sql1 = "INSERT INTO thong_tin_danh_muc_san_pham VALUES (?, ?, ?, ?);";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, danh_muc_san_pham.getId_danh_muc_san_pham());
			preparedStatement.setString(2, danh_muc_san_pham.getTen_loai_san_pham());
			preparedStatement.setString(3, danh_muc_san_pham.getTen_doi_tuong_khach_hang());
			preparedStatement.setString(4, danh_muc_san_pham.getTen_danh_muc_san_pham());
			preparedStatement.execute();
			
			System.out.println("them danh muc san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void cap_nhat_danh_muc_san_pham(Danh_muc_san_pham danh_muc_san_pham) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			
			String sql1 = "UPDATE thong_tin_danh_muc_san_pham SET ten_loai_san_pham = ?, ten_doi_tuong_khach_hang = ?, ten_danh_muc_san_pham WHERE id_danh_muc_san_pham = ?;";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, danh_muc_san_pham.getTen_loai_san_pham());
			preparedStatement.setString(2, danh_muc_san_pham.getTen_doi_tuong_khach_hang());
			preparedStatement.setString(3, danh_muc_san_pham.getTen_danh_muc_san_pham());
			preparedStatement.setInt(4, danh_muc_san_pham.getId_danh_muc_san_pham());
			preparedStatement.execute();
			
			System.out.println("them danh muc san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void xoa_danh_muc_san_pham(int id_danh_muc_san_pham) throws Exception {
		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
					
					
				String sql1 = "DELETE FROM thong_tin_danh_muc_san_pham WHERE id_danh_muc_san_pham = ?";
				preparedStatement = connection.prepareStatement(sql1);
				preparedStatement.setInt(1, id_danh_muc_san_pham);
				preparedStatement.execute();
					
				System.out.println("xoa danh muc san pham thanh cong!!");
					
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
	
	public static Danh_muc_san_pham lay_danh_muc_san_pham(int id_chat_lieu) throws Exception {
		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
				ResultSet rs = null;
					
				String sql1 = "SELECT * FROM thong_tin_danh_muc_san_pham WHERE id_danh_muc_san_pham = ?";
				preparedStatement = connection.prepareStatement(sql1);
				preparedStatement.setInt(1, id_chat_lieu);
				rs = preparedStatement.executeQuery();
				rs.next();
					
				System.out.println("lay danh muc san pham thanh cong!!");
				
				return new Danh_muc_san_pham(	rs.getInt("id_danh_muc_san_pham"),
												rs.getString("ten_loai_san_pham"),
												rs.getString("ten_doi_tuong_khach_hang"),
												rs.getString("ten_danh_muc_san_pham"));
				
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
	
	
	public static void them_san_pham(San_pham san_pham) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			String sql1 = "INSERT INTO thong_tin_chung_cua_san_pham VALUES (?, ?, ?, ?, ?);";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, san_pham.getId_san_pham());
			preparedStatement.setString(2, san_pham.getTen_san_pham());
			preparedStatement.setString(3, san_pham.getTen_nhan_hang());
			preparedStatement.setString(4, san_pham.getThong_tin_chung());
			preparedStatement.setInt(5, san_pham.getId_danh_muc_san_pham());
			preparedStatement.execute();
			
			for(String duong_dan : san_pham.getAnh_san_pham()){
				String sql2 = "INSERT INTO anh_san_pham VALUES (?, ?);";
				preparedStatement = connection.prepareStatement(sql2);
				preparedStatement.setInt(1, san_pham.getId_san_pham());
				preparedStatement.setString(2, duong_dan);
				preparedStatement.execute();
			}
			
			
			System.out.println("them san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void cap_nhat_san_pham(San_pham san_pham) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			String sql1 = "UPDATE thong_tin_chung_cua_san_pham SET ten_san_pham = ?, ten_nhan_hang = ?, thong_tin_chung = ?, id_danh_muc_san_pham = ? WHERE id_san_pham = ?";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, san_pham.getTen_san_pham());
			preparedStatement.setString(2, san_pham.getTen_nhan_hang());
			preparedStatement.setString(3, san_pham.getThong_tin_chung());
			preparedStatement.setInt(4, san_pham.getId_danh_muc_san_pham());
			preparedStatement.setInt(5, san_pham.getId_san_pham());
			preparedStatement.execute();
			
			System.out.println("them san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void cap_nhat_anh_san_pham(San_pham san_pham) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			String sql2 = "DELETE FROM anh_san_pham WHERE id_anh = ?;";
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setInt(1, san_pham.getId_san_pham());
			preparedStatement.execute();
			
			for(String duong_dan : san_pham.getAnh_san_pham()){
				String sql3 = "INSERT INTO anh_san_pham VALUES (?, ?);";
				preparedStatement = connection.prepareStatement(sql3);
				preparedStatement.setInt(1, san_pham.getId_san_pham());
				preparedStatement.setString(2, duong_dan);
				preparedStatement.execute();
			}
			
			System.out.println("them san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void xoa_san_pham(int id_san_pham) throws Exception {
		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
					
				String sql1 = "DELETE FROM anh_san_pham WHERE id_anh = ?;";
				preparedStatement = connection.prepareStatement(sql1);
				preparedStatement.setInt(1, id_san_pham);
				preparedStatement.execute();
				
				String sql2 = "DELETE FROM thong_tin_chung_cua_san_pham WHERE id_san_pham = ?;";
				preparedStatement = connection.prepareStatement(sql2);
				preparedStatement.setInt(1, id_san_pham);
				preparedStatement.execute();
					
				System.out.println("xoa san pham thanh cong!!");
					
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
	
	public static San_pham lay_san_pham(int id_san_pham) throws Exception {

		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
				ResultSet rs = null;
					
				
				String sql1 = 	"SELECT * FROM anh_san_pham WHERE id_anh = ?";
				
				preparedStatement = connection.prepareStatement(sql1);
				preparedStatement.setInt(1, id_san_pham);
				rs = preparedStatement.executeQuery();
				
				List<String> ls_duong_dan = new ArrayList<String>();
				while(rs.next()) {
					ls_duong_dan.add(rs.getString("duong_dan"));
				}
				
				String sql2 = 	"SELECT * FROM thong_tin_chung_cua_san_pham WHERE id_san_pham = ?";
				
				preparedStatement = connection.prepareStatement(sql2);
				preparedStatement.setInt(1, id_san_pham);
				rs = preparedStatement.executeQuery();
				rs.next();
					
				System.out.println("lay san pham thanh cong!!");
				
				return new San_pham(rs.getInt("id_san_pham"),
									rs.getInt("id_danh_muc_san_pham"),
									rs.getString("ten_san_pham"),  
									rs.getString("ten_nhan_hang"),
									rs.getString("thong_tin_chung"),
									ls_duong_dan, 
									null);
				
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
	
	
	
	public static void them_chi_tiet_san_pham(Thong_tin_chi_tiet_san_pham chi_tiet_san_pham) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			
			String sql1 = "INSERT INTO thong_tin_chi_tiet_san_pham VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, chi_tiet_san_pham.getId_thong_tin_chi_tiet_san_pham());
			preparedStatement.setInt(2, chi_tiet_san_pham.getId_san_pham());
			preparedStatement.setInt(3, chi_tiet_san_pham.getSo_luong_trong_kho());
			preparedStatement.setInt(4, chi_tiet_san_pham.getMau_sac_san_pham().getId_mau_sac());
			preparedStatement.setInt(5, chi_tiet_san_pham.getKich_thuoc_san_pham().getId_size());
			preparedStatement.setInt(6, chi_tiet_san_pham.getChat_lieu_san_pham().getId_chat_lieu());
			preparedStatement.setFloat(7, chi_tiet_san_pham.getGia_tien());
			preparedStatement.setString(8, chi_tiet_san_pham.getThong_tin_chi_tiet());
			preparedStatement.execute();
			
			System.out.println("them chi tiet san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void cap_nhat_chi_tiet_san_pham(Thong_tin_chi_tiet_san_pham chi_tiet_san_pham) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			
			String sql1 = "UPDATE thong_tin_chi_tiet_san_pham SET "
					+ "so_luong_trong_kho = ?, "
					+ "id_mau_sac = ?, "
					+ "id_size = ?, "
					+ "id_chat_lieu = ?, "
					+ "gia_tien = ?, "
					+ "thong_tin_chi_tiet = ?"
					+ " WHERE id_thong_tin_chi_tiet_san_pham = ?;";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, chi_tiet_san_pham.getSo_luong_trong_kho());
			preparedStatement.setInt(2, chi_tiet_san_pham.getMau_sac_san_pham().getId_mau_sac());
			preparedStatement.setInt(3, chi_tiet_san_pham.getKich_thuoc_san_pham().getId_size());
			preparedStatement.setInt(4, chi_tiet_san_pham.getChat_lieu_san_pham().getId_chat_lieu());
			preparedStatement.setFloat(5, chi_tiet_san_pham.getGia_tien());
			preparedStatement.setString(6, chi_tiet_san_pham.getThong_tin_chi_tiet());
			preparedStatement.setInt(7, chi_tiet_san_pham.getId_thong_tin_chi_tiet_san_pham());
			preparedStatement.execute();
			
			System.out.println("them chi tiet san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void cap_nhat_anh_chi_tiet_san_pham(Thong_tin_chi_tiet_san_pham chi_tiet_san_pham) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			String sql2 = "DELETE FROM anh_chi_tiet_san_pham WHERE id_anh = ?;";
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setInt(1, chi_tiet_san_pham.getId_thong_tin_chi_tiet_san_pham());
			preparedStatement.execute();
			
			for(String duong_dan : chi_tiet_san_pham.getAnh_chi_tiet()){
				String sql3 = "INSERT INTO anh_chi_tiet_san_pham VALUES (?, ?);";
				preparedStatement = connection.prepareStatement(sql3);
				preparedStatement.setInt(1, chi_tiet_san_pham.getId_thong_tin_chi_tiet_san_pham());
				preparedStatement.setString(2, duong_dan);
				preparedStatement.execute();
			}
			
			System.out.println("them chi tiet san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void xoa_chi_tiet_san_pham(int id_chi_tiet_san_pham) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			
			String sql1 = "DELETE FROM anh_chi_tiet_san_pham WHERE id_anh = ?;";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, id_chi_tiet_san_pham);
			preparedStatement.execute();
			
			String sql2 = "DELETE FROM thong_tin_chi_tiet_san_pham WHERE id_thong_tin_chi_tiet_san_pham = ?;";
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setInt(1, id_chi_tiet_san_pham);
			preparedStatement.execute();
			
			System.out.println("them chi tiet san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static Thong_tin_chi_tiet_san_pham lay_chi_tiet_san_pham(int id_chi_tiet_san_pham) throws Exception {

		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
				ResultSet rs = null;
					
				
				String sql1 = 	"SELECT * FROM anh_chi_tiet_san_pham WHERE id_anh = ?";
				
				preparedStatement = connection.prepareStatement(sql1);
				preparedStatement.setInt(1, id_chi_tiet_san_pham);
				rs = preparedStatement.executeQuery();
				
				List<String> ls_duong_dan_anh = new ArrayList<String>();
				while(rs.next()) {
					ls_duong_dan_anh.add(rs.getString("duong_dan"));
				}
				
				String sql2 = 	"SELECT * FROM thong_tin_chi_tiet_san_pham WHERE id_thong_tin_chi_tiet_san_pham = ?";
				
				preparedStatement = connection.prepareStatement(sql2);
				preparedStatement.setInt(1, id_chi_tiet_san_pham);
				rs = preparedStatement.executeQuery();
				rs.next();
					
				System.out.println("lay san pham thanh cong!!");
				
				return new Thong_tin_chi_tiet_san_pham(	rs.getInt("id_thong_tin_chi_tiet_san_pham"),
														rs.getInt("id_san_pham"),
														rs.getInt("so_luong_trong_kho"),
														DAO_Thuoc_tinh_san_pham.lay_mau_sac(rs.getInt("id_san_pham")),
														DAO_Thuoc_tinh_san_pham.lay_size(rs.getInt("id_san_pham")),
														DAO_Thuoc_tinh_san_pham.lay_chat_lieu(rs.getInt("id_san_pham")),
														rs.getFloat("id_san_pham"),
														ls_duong_dan_anh, 
														rs.getString("thong_tin_chi_tiet"));
				
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
}
