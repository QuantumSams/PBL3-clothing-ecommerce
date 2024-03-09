package DAO;

import java.sql.Connection;
import java.sql.ResultSet;

import Context.JDBC_Unit;

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
	
}
