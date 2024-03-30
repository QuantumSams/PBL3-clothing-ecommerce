package DAO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.random.*;

import javax.imageio.ImageIO;

import org.apache.tomcat.jakartaee.commons.compress.archivers.ArchiveInputStream;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.jdbc.ClientPreparedStatement;

import Connect.JDBC_Unit;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Account;
import jakarta.servlet.http.Part;
public class DAO {
	public static int getIDDangNhap(String ten_dang_nhap, String mat_khau) throws Exception {
		
		int ID;
		// ket noi voi co so du lieu
		Connection connection = JDBC_Unit.getConnection();
		System.out.println(connection);
		ResultSet rs = null;
		java.sql.Statement stmt = null;
		
		// dung cach nay de truy van du lieu tranh bij hack bang doan lenh don gian
		String sql = 	"SELECT id FROM thong_tin_dang_nhap "+
						"WHERE ten_dang_nhap = '" + ten_dang_nhap + "' AND " +
						"mat_khau = '" + mat_khau + "' " ;
		try{
			stmt = connection.createStatement();
			// lay thong tin tu co so du lieu
			rs = stmt.executeQuery(sql);
			
			rs.next();
			ID = rs.getInt("id"); // lay thong tin cua cot
		}catch(Exception e)
		{
			System.out.println("khong tim thay ID nguoi dung");
			throw new Exception("khong tim thay ID nguoi dung");
		}
		try{
			rs.close();
			stmt.close();
			connection.close();
		}catch(Exception e)
		{
			System.out.println("khong the dong co so du lieu!!");
		}
		
		return ID;
		
	}
	public static Account login(String user, String pass) {
		int id;
		String phoneNumber;
		String email;
		// ket noi voi co so du lieu
		try {
			Connection connection = JDBC_Unit.getConnection();
			System.out.println(connection);
			ResultSet rs = null;
			java.sql.Statement stmt = null;
			
			// dung cach nay de truy van du lieu tranh bij hack bang doan lenh don gian
			String sql = 	"SELECT * FROM thong_tin_dang_nhap\n"
							+ "WHERE (so_dien_thoai = '"+user+"' OR "+
							"email = '"+user+"') AND mat_khau = '"+pass+"'";
			
			try{
				stmt = connection.createStatement();
				// lay thong tin tu co so du lieu
				rs = stmt.executeQuery(sql);
				rs.next();
				id = rs.getInt("id");
				phoneNumber = rs.getString("so_dien_thoai");
				email = rs.getString("email");
				String sql2 = "SELECT * FROM thong_tin_nguoi_dung\n"
						+ "WHERE id = '"+id+"'"; 
				rs = stmt.executeQuery(sql2);
				rs.next();
				
				return new Account(
						rs.getInt("id"),
						rs.getString("ho_ten"), 
						rs.getInt("gioi_tinh"), 
						rs.getString("ngay_sinh"),
						rs.getString("dia_chi"), 
						phoneNumber, 
						email, 
						null
						);
				
			}catch(Exception e)
			{
				System.out.println("khong lay duoc thong tin nguoi dung khi dang nhap: " + e);
			}
			try{
				rs.close();
				stmt.close();
				connection.close();
			}catch(Exception e)
			{
				System.out.println("khong the dong co so du lieu!!");
			}
			
		}catch(Exception e)
		{
			
		};
		return null;
	}
	public static boolean checkAccount(String email, String phone) {

		// ket noi voi co so du lieu
		try {
			Connection connection = JDBC_Unit.getConnection();
			System.out.println(connection);
			ResultSet rs = null;
			java.sql.Statement stmt = null;
			
			// dung cach nay de truy van du lieu tranh bij hack bang doan lenh don gian
			String sql = 	"SELECT thong_tin_dang_nhap.* FROM thong_tin_dang_nhap "+
							"WHERE so_dien_thoai = '" + phone + "' or email = '"+ email +"'";
			try{
				stmt = connection.createStatement();
				// lay thong tin tu co so du lieu
				rs = stmt.executeQuery(sql);
				rs.next();
				try {
					rs.getInt("id");
				}
				catch (SQLException e) {
					return false;
				}	
			}catch(Exception e)
			{
				System.out.println(e);
			}
			try{
				rs.close();
				stmt.close();
				connection.close();
			}catch(Exception e)
			{
				System.out.println("khong the dong co so du lieu!!");
			}
			
		}catch(Exception e)
		{
			
		};
		return true;
	}
	public static void signUP(String phone, String email,String pass, String fullname) {
		try {
			Connection connection = JDBC_Unit.getConnection();
			System.out.println(connection);
			java.sql.Statement stmt = null;
			Random a = new Random();
			int id = a.nextInt(2000)+1237;
			// dung cach nay de truy van du lieu tranh bij hack bang doan lenh don gian
			String sql = "insert into thong_tin_dang_nhap\n"
					+ "value("+id+",'"+phone +"','"+email+"','"+pass+"'"+",1)";
			String sql2 = "insert into thong_tin_nguoi_dung\n"
					+ "value("+id+ ", '" + fullname + "' ,NULL, NULL, NULL, NULL)";
			try{
				stmt = connection.createStatement();
				// lay thong tin tu co so du lieu
				stmt.executeUpdate(sql);
				stmt.executeUpdate(sql2);
			}catch(Exception e)
			{
				System.out.println(e);
			}
			try{
				stmt.close();
				connection.close();
			}catch(Exception e)
			{
				System.out.println("khong the dong co so du lieu!!" + e);
			}
		}catch(Exception e)
		{
			
		};
	}
	
	public static void updateInfor(int id, String fullName, int gender, String birth, String address, String image) {
		try {
			Connection connection = JDBC_Unit.getConnection();
			System.out.println(connection);
			java.sql.Statement stmt = null;
			// dung cach nay de truy van du lieu tranh bij hack bang doan lenh don gian
			String sql = "UPDATE thong_tin_nguoi_dung\n"
					+ "SET ho_ten = '" + fullName + "', gioi_tinh = " + gender + " "
					+ ", ngay_sinh = '"+birth+"', dia_chi = '"+address+"', anh_dai_dien = '" + image + "' "
					+ "WHERE id = "+id;
			
			try{
				stmt = connection.createStatement();
				// lay thong tin tu co so du lieu
				stmt.executeUpdate(sql);
			}catch(Exception e)
			{
				System.out.println(e);
			}
			try{
				stmt.close();
				connection.close();
			}catch(Exception e)
			{
				System.out.println("khong the dong co so du lieu!!" + e);
			}
		}catch(Exception e)
		{
			
		};
	}
	
	public static void UploadBLOB(Part filePart, String ID) throws ClassNotFoundException {
		Connection connection = JDBC_Unit.getConnection();
		System.out.println(connection);
		
		ClientPreparedStatement preparedStatement = null;
     
		String sql = "UPDATE thong_tin_khach_hang SET anh = ? WHERE id_khach_hang = ?";
		
		try{
			preparedStatement = (ClientPreparedStatement) connection.prepareStatement(sql);
			
            InputStream inputStream = filePart.getInputStream();
            
            preparedStatement.setBinaryStream(1, inputStream);
            
            preparedStatement.setString(2, ID);
            
            preparedStatement.executeUpdate();
            
		}catch(Exception e)
		{
			System.out.println("khong the rai anh xuong: " + e);
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("khong the dong co so du lieu");
			}
		}
	}
	
	public static byte[] getBLOB(String ID) {
		Connection connection = null;
		try {
			connection = JDBC_Unit.getConnection();
		} catch (ClassNotFoundException e) {
		
		}
		System.out.println(connection);
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
     
		String sql = "SELECT anh FROM thong_tin_khach_hang WHERE id_khach_hang = ?";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			// dùng tên ảnh lấy ảnh từ cơ sở dữ liệu chuyển qua byte[]
            preparedStatement.setString(1, ID);
				
            resultSet = preparedStatement.executeQuery();
            
            resultSet.next();
            Blob blob = (Blob) resultSet.getBlob("anh");
            byte[] imageBytes = blob.getBytes(1, (int) blob.length());
            return imageBytes;
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("khong the dong co so du lieu");
			}
		}
		return null;
	}
}
