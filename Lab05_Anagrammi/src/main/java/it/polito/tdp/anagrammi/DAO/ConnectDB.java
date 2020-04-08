package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=Jaqa7951ma";
	
	public static Connection getConnection() {
		
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl);
			return conn;
		
		}catch(SQLException sque) {
			
			sque.printStackTrace();
			throw new RuntimeException("Cannot get the connection" + jdbcUrl, sque);
		}
		
	}
	
	

}
