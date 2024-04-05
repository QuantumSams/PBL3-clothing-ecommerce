package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connect.JDBC_Unit;
import Entity.Nguoi_Dung.Chu_cua_hang;
import Entity.Nguoi_Dung.Khach_hang;
import Entity.Nguoi_Dung.Nguoi_dung;
import Entity.Nguoi_Dung.Nhan_vien;
import Entity.Nguoi_Dung.Phan_quyen_nguoi_dung;

public class DAO_Nguoi_dung {
	
	public static int dang_nhap(String email_or_so_dien_thoai, String mat_khau) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
		    ResultSet rs = null;
			
			String sql = "SELECT * FROM thong_tin_dang_nhap WHERE (so_dien_thoai = ? OR email = ?) AND mat_khau = ? ";
		
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email_or_so_dien_thoai);
			preparedStatement.setString(2, email_or_so_dien_thoai);
			preparedStatement.setString(3, mat_khau);
			rs = preparedStatement.executeQuery();
			
			rs.next();
			
			return rs.getInt("id");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static int lay_id_phan_quyen_nguoi_dung(String ten_phan_quyen) throws Exception {
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
		    ResultSet rs = null;
			
			String sql = "SELECT id FROM phan_quyen_nguoi_dung WHERE ten_phan_quyen =  ? ";
		
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ten_phan_quyen);
			rs = preparedStatement.executeQuery();
			
			rs.next();
			
			return rs.getInt("id");
			
		}catch(Exception e){
			System.out.println("Khong tim thay phan quyen nuoi dung hop le: " + e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static void tao_tai_khoan(Nguoi_dung nguoi_dung, String mat_khau) throws Exception
	{
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			
			String sql1 = "INSERT INTO thong_tin_dang_nhap VALUES (?, ?, ?, ?, ?);";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, nguoi_dung.getId_nguoi_dung());
			preparedStatement.setString(2, nguoi_dung.getSo_dien_thoai());
			preparedStatement.setString(3, nguoi_dung.getEmail());
			preparedStatement.setString(4, mat_khau); 
			preparedStatement.setInt(5, lay_id_phan_quyen_nguoi_dung(nguoi_dung.getPhan_quyen_nguoi_dung())); 
			preparedStatement.execute();
			 
			String sql2 = "INSERT INTO thong_tin_nguoi_dung VALUES (?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setInt(1, nguoi_dung.getId_nguoi_dung());
			preparedStatement.setString(2, nguoi_dung.getHo_ten());
			preparedStatement.setBoolean(3, nguoi_dung.isGioi_tinh());
			preparedStatement.setDate(4, nguoi_dung.getNgay_sinh());
			preparedStatement.setString(5, nguoi_dung.getDia_chi());
			preparedStatement.setString(6, nguoi_dung.getAnh_dai_dien()); 
			preparedStatement.execute();
			System.out.println("Tao tai khoan thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
		
	}

	public static void xoa_tai_khoa(int id_nguoi_dung) throws Exception {
Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
			
			String sql1 = "DELETE  FROM thong_tin_nguoi_dung WHERE ID = ?;";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, id_nguoi_dung);
			preparedStatement.execute();
			 
			String sql2 = "DELETE  FROM thong_tin_dang_nhap WHERE ID = ?;";
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setInt(1, id_nguoi_dung);
			preparedStatement.execute();
			System.out.println("Xoa tai khoan thanh cong!!");
			
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
	}
	
	public static Nguoi_dung lay_tai_khoan_nguoi_dung(int ID) throws Exception {
		
		Nguoi_dung nguoi_dung = null;
		Connection connection = null;
		
		try {
		
			connection = JDBC_Unit.getConnection();
			PreparedStatement preparedStatement = null;
		    ResultSet rs = null;
			
			String sql = 	" SELECT thong_tin_dang_nhap.id, ho_ten, gioi_tinh, ngay_sinh, dia_chi, anh_dai_dien, thong_tin_dang_nhap.so_dien_thoai, thong_tin_dang_nhap.email, phan_quyen_nguoi_dung.ten_phan_quyen"
							+ " FROM thong_tin_nguoi_dung" 
							+ " INNER JOIN thong_tin_dang_nhap ON thong_tin_nguoi_dung.id = thong_tin_dang_nhap.id"
							+ " INNER JOIN phan_quyen_nguoi_dung ON phan_quyen_nguoi_dung.id = thong_tin_dang_nhap.id_phan_quyen_nguoi_dung"
							+ " WHERE thong_tin_dang_nhap.id = ? ";
		
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, ID);
			rs = preparedStatement.executeQuery();
			
			rs.next();
			
			String phan_quyen_nguoi_dung = rs.getString("ten_phan_quyen");
			
			if(phan_quyen_nguoi_dung.equals(Phan_quyen_nguoi_dung.CHU_CUA_HANG.toString())) {
				nguoi_dung = new Chu_cua_hang(	rs.getInt("id"),
												rs.getString("ho_ten"), 
												rs.getBoolean("gioi_tinh"), 
												rs.getDate("ngay_sinh"), 
												rs.getString("dia_chi"), 
												rs.getString("anh_dai_dien"), 
												rs.getString("so_dien_thoai"), 
												rs.getString("email"), 
												phan_quyen_nguoi_dung
												);
			}else if(phan_quyen_nguoi_dung.equals(Phan_quyen_nguoi_dung.NHAN_VIEN.toString())) {
				nguoi_dung = new Nhan_vien(		rs.getInt("id"),
												rs.getString("ho_ten"), 
												rs.getBoolean("gioi_tinh"), 
												rs.getDate("ngay_sinh"), 
												rs.getString("dia_chi"), 
												rs.getString("anh_dai_dien"), 
												rs.getString("so_dien_thoai"), 
												rs.getString("email"), 
												phan_quyen_nguoi_dung
												);
			}else if(phan_quyen_nguoi_dung.equals(Phan_quyen_nguoi_dung.KHACH_HANG.toString())) {
				nguoi_dung = new Khach_hang(	rs.getInt("id"),
												rs.getString("ho_ten"), 
												rs.getBoolean("gioi_tinh"), 
												rs.getDate("ngay_sinh"), 
												rs.getString("dia_chi"), 
												rs.getString("anh_dai_dien"), 
												rs.getString("so_dien_thoai"), 
												rs.getString("email"), 
												phan_quyen_nguoi_dung
												);
			}
		}catch(Exception e){
			System.out.println(e);
			throw(e);
		}finally {
			JDBC_Unit.closeConnection(connection);
		}
		
		return nguoi_dung;
	}
	
	
}
