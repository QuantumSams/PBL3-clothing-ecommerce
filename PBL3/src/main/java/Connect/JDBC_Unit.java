package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Unit {
	public static Connection getConnection() throws SQLException {
		Connection c = null;
		
		try {
			
			String url = "jdbc:mySQL://localhost:3306/pbl";
			String username = "root";
			String password = "";
			
			c = DriverManager.getConnection(url, username, password);
			
			System.out.println("Ket noi thanh cong co so du lieu: " + c);
			
		}catch(SQLException e) {
			System.out.println("khong the ket noi co so du lieu!! : " + e);
			throw(e);
		}
		return c; 
	}
	
	public static Connection getConnection(String url, String username, String password) throws SQLException {
		Connection c = null;
		
		try {
			
			c = DriverManager.getConnection(url, username, password);
			
		}catch(SQLException e) {
			System.out.println("khong the ket noi co so du lieu!! : " + e);
			throw(e);
		}
		return c; 
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c != null) {
				c.close();
			}
		}catch(Exception e) {
		}
	}
}
