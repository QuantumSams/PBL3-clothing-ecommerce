package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connect.JDBC_Unit;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Chat_lieu;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Size;

public class DAO_Thuoc_tinh_san_pham {
	public static void them_chat_lieu(Chat_lieu chat_lieu) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			
			String sql1 = "INSERT INTO chat_lieu VALUES (?, ?);";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, chat_lieu.getId_chat_lieu());
			preparedStatement.setString(2, chat_lieu.getTen_chat_lieu());
			preparedStatement.execute();
			
			System.out.println("them chat lieu san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void cap_nhat_chat_lieu(Chat_lieu chat_lieu) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			
			String sql1 = "UPDATE chat_lieu SET ten_chat_lieu = ? WHERE id_chat_lieu = ?;";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, chat_lieu.getTen_chat_lieu());
			preparedStatement.setInt(2, chat_lieu.getId_chat_lieu());
			preparedStatement.execute();
			
			System.out.println(" cap nhat chat lieu san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void xoa_chat_lieu(int id_chat_lieu) throws Exception {
		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
					
					
				String sql1 = "DELETE FROM chat_lieu WHERE id_chat_lieu = ?";
				preparedStatement = connection.prepareStatement(sql1);
				preparedStatement.setInt(1, id_chat_lieu);
				preparedStatement.execute();
					
				System.out.println("xoa chat lieu san pham thanh cong!!");
					
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
	
	public static Chat_lieu lay_chat_lieu(int id_chat_lieu) throws Exception {
		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
				ResultSet rs = null;
					
				String sql1 = "SELECT * FROM chat_lieu WHERE id_chat_lieu = ?";
				preparedStatement = connection.prepareStatement(sql1);
				preparedStatement.setInt(1, id_chat_lieu);
				rs = preparedStatement.executeQuery();
				rs.next();
					
				System.out.println("lay chat lieu san pham thanh cong!!");
				
				return new Chat_lieu(rs.getInt("id_chat_lieu"), rs.getString("ten_chat_lieu"));
				
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
	
	
	
	
	
	
	public static void them_mau_sac(Mau_sac mau_sac) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			String sql1 = "INSERT INTO mau_sac VALUES (?, ?, ?);";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, mau_sac.getId_mau_sac());
			preparedStatement.setString(2, mau_sac.getTen_mau());
			preparedStatement.setString(3, mau_sac.getAnh_mau_sac());
			preparedStatement.execute();
			
			System.out.println("them mau sac san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void cap_nhat_mau_sac(Mau_sac mau_sac) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			
			String sql1 = "UPDATE mau_sac SET ten_mau = ?, duong_dan_anh = ? WHERE id_mau_sac = ?;";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, mau_sac.getTen_mau());
			preparedStatement.setString(2, mau_sac.getAnh_mau_sac());
			preparedStatement.setInt(3, mau_sac.getId_mau_sac());
			preparedStatement.execute();
			
			System.out.println(" cap nhat mau sac san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void xoa_mau_sac(int id_mau_sac) throws Exception {
		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
				
				String sql2 = "DELETE FROM mau_sac WHERE id_mau_sac = ?;";
				preparedStatement = connection.prepareStatement(sql2);
				preparedStatement.setInt(1, id_mau_sac);
				preparedStatement.execute();
					
				System.out.println("xoa mau sac san pham thanh cong!!");
					
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
	
	public static Mau_sac lay_mau_sac(int id_mau_sac) throws Exception {

		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
				ResultSet rs = null;
					
				String sql1 = 	"SELECT * FROM mau_sac WHERE id_mau_sac = ?";
				preparedStatement = connection.prepareStatement(sql1);
				preparedStatement.setInt(1, id_mau_sac);
				rs = preparedStatement.executeQuery();
				rs.next();
					
				System.out.println("lay mau sac san pham thanh cong!!");
				
				return new Mau_sac(rs.getInt("id_mau_sac"), rs.getString("ten_mau"),  rs.getString("ten_anh"));
				
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}


	
	
	public static void them_size(Size size) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			
			String sql1 = "INSERT INTO size VALUES (?, ?);";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, size.getId_size());
			preparedStatement.setString(2, size.getTen_size());
			preparedStatement.execute();
			
			System.out.println("them kich thuoc san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	public static void cap_nhat_size(Size size) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			
			String sql1 = "UPDATE size SET ten_size = ? WHERE id_size = ?;";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, size.getTen_size());
			preparedStatement.setInt(2, size.getId_size());
			preparedStatement.execute();
			
			System.out.println(" cap nhat size san pham thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void xoa_size(int id_size) throws Exception {
		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
					
					
				String sql1 = "DELETE FROM size WHERE id_size = ?";
				preparedStatement = connection.prepareStatement(sql1);
				preparedStatement.setInt(1, id_size);
				preparedStatement.execute();
					
				System.out.println("xoa kich thuoc san pham thanh cong!!");
					
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
	
	public static Size lay_size(int id_size) throws Exception {
		Connection connection = null;
				
			try {
				
				connection = JDBC_Unit.getConnection();
				PreparedStatement preparedStatement = null;
				ResultSet rs = null;
					
				String sql1 = "SELECT * FROM size WHERE id_size = ?";
				preparedStatement = connection.prepareStatement(sql1);
				preparedStatement.setInt(1, id_size);
				rs = preparedStatement.executeQuery();
				rs.next();
					
				System.out.println("lay kich thuoc san pham thanh cong!!");
				
				return new Size(rs.getInt("id_size"), rs.getString("ten_size"));
				
			}catch(Exception e){
				System.out.println(e);
				throw(e);
			}finally {
				JDBC_Unit.closeConnection(connection);
			}
	}
}


