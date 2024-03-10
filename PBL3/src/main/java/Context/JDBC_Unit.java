package Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Unit {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			// thay doi localhost o day
			String url = "jdbc:mySQL://localhost:3306/pbl3";
			String username = "root";
			String password = "";
			
			c = DriverManager.getConnection(url, username, password);
			
		}catch(SQLException e) {
			System.out.println("khong the ket noi server!!" + e);
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
