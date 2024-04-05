package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connect.JDBC_Unit;
import Entity.Don_Hang.Danh_gia_don_hang;
import Entity.Don_Hang.Don_hang;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;

public class DAO_Don_hang {
	
	public static void them_don_hang(Don_hang don_hang) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			String sql1 = "INSERT INTO quan_ly_ban_hang VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, don_hang.getId_hoa_don());
			preparedStatement.setInt(2, don_hang.getId_thong_tin_chi_tiet_san_pham());
			preparedStatement.setInt(3, don_hang.getSo_luong());
			preparedStatement.setInt(4, don_hang.getTong_tien());
			preparedStatement.setInt(5, don_hang.getId_nhan_vien());
			preparedStatement.setInt(6, don_hang.getId_khach_hang());
			preparedStatement.setString(7, don_hang.getDia_chi_giao_dich());
			preparedStatement.setDate(8, don_hang.getNgay_gio_dat_don_hang());
			preparedStatement.setDate(9, don_hang.getNgay_gio_nhan_don_hang());
			preparedStatement.setString(10, don_hang.getTrang_thai_don_hang());
			preparedStatement.execute();
		
			System.out.println("them don hang thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void cap_nhat_don_hang(Don_hang don_hang) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			String sql1 = "UPDATE quan_ly_ban_hang SET "
					+ "id_nhan_vien = ?,"
					+ "ngay_gio_nhan_don_hang = ?, "
					+ "trang_thai_don_hang = ?, "
					+ " WHERE id_don_hang = ?";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, don_hang.getId_nhan_vien());
			preparedStatement.setDate(2, don_hang.getNgay_gio_nhan_don_hang());
			preparedStatement.setString(3, don_hang.getTrang_thai_don_hang());
			preparedStatement.setInt(4, don_hang.getId_hoa_don());
			preparedStatement.execute();
		
			System.out.println("sua don hang thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void xoa_don_hang(int id_don_hang) throws Exception {
		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
				
				String sql2 = "DELETE FROM quan_ly_ban_hang WHERE id_hoa_don = ?;";
				preparedStatement = connection.prepareStatement(sql2);
				preparedStatement.setInt(1, id_don_hang);
				preparedStatement.execute();
					
				System.out.println("xoa don hang san pham thanh cong!!");
					
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
	
	public static Don_hang lay_don_hang(int id_don_hang) throws Exception {

		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
				ResultSet rs = null;
					
				String sql1 = 	"SELECT * FROM quan_ly_don_hang WHERE id_don_hang = ?";
				preparedStatement = connection.prepareStatement(sql1);
				preparedStatement.setInt(1, id_don_hang);
				rs = preparedStatement.executeQuery();
				rs.next();
					
				System.out.println("lay mau sac san pham thanh cong!!");
				
				return new Don_hang(	rs.getInt("id_don_hang"), 
										rs.getInt("id_thong_tin_chi_tiet_san_pham"),
										rs.getInt("so_luong"), 
										rs.getInt("tong_tien"), 
										rs.getInt("id_nhan_vien"), 
										rs.getInt("id_khach_hang"), 
										rs.getString("dia_chi_giao_dich"),
										rs.getDate("ngay_gio_dat_don_hang"),
										rs.getDate("ngay_gio_nhan_don_hang"),
										rs.getString("trang_thai_don_hang"));
				
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
	
	
	public static void them_danh_gia_don_hang(Danh_gia_don_hang danh_gia_don_hang) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			String sql1 = "INSERT INTO danh_gia_don_hang VALUES (?, ?, ?);";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, danh_gia_don_hang.getId_hoa_don());
			preparedStatement.setInt(2, danh_gia_don_hang.getSo_sao());
			preparedStatement.setString(3, danh_gia_don_hang.getBinh_luan());
			preparedStatement.execute();
		
			System.out.println("them danh gia san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void cap_nhat_danh_gia_don_hang(Danh_gia_don_hang danh_gia_don_hang) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			String sql1 = "UPDATE danh_gia_don_hang SET "
					+ "so_sao = ?,"
					+ "binh_luan = ?, "
					+ " WHERE id_don_hang = ?";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, danh_gia_don_hang.getSo_sao());
			preparedStatement.setString(2, danh_gia_don_hang.getBinh_luan());
			preparedStatement.setInt(3, danh_gia_don_hang.getId_hoa_don());
			preparedStatement.execute();
		
			System.out.println("sua danh gia san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void xoa_danh_gia_don_hang(int id_danh_gia_don_hang) throws Exception {
		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
				
				String sql2 = "DELETE FROM danh_gia_don_hang WHERE id_hoa_don = ?;";
				preparedStatement = connection.prepareStatement(sql2);
				preparedStatement.setInt(1, id_danh_gia_don_hang);
				preparedStatement.execute();
					
				System.out.println("xoa danh gia san pham thanh cong!!");
					
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
	
	public static Danh_gia_don_hang lay_danh_gia_don_hang(int id_danh_gia_don_hang) throws Exception {

		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
				ResultSet rs = null;
					
				String sql1 = 	"SELECT * FROM danh_gia_don_hang WHERE id_don_hang = ?";
				preparedStatement = connection.prepareStatement(sql1);
				preparedStatement.setInt(1, id_danh_gia_don_hang);
				rs = preparedStatement.executeQuery();
				rs.next();
					
				System.out.println("lay mau sac san pham thanh cong!!");
				
				return new Danh_gia_don_hang(	rs.getInt("id_don_hang"), 
												rs.getInt("so_sao"),
												rs.getString("binh_luan"));
				
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
}
