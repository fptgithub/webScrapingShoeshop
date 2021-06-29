package webscrapingjava5.main.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AbstractDAO {
	
	private static String url = "jdbc:mysql://localhost:3306/java5?useSSL=false";
	private static String username = "root";
	private static String password = "songlong";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void setStatement(PreparedStatement statement,Object... args) {
		int i = 1;
		try {
			for(Object o:args) {
			statement.setObject(i, o);
			i++;
		}
		} catch (Exception e) {
		}
	}
}
