package banana.dao;

import java.sql.DriverManager;
import java.sql.Connection;

public class MySqlConnection {

	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			// conexão                                                porta/nomebd    user   senha
			conn = DriverManager.getConnection("jdbc:mysql://187.108.201.193:3306/banana", "sistema", "sistema");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
