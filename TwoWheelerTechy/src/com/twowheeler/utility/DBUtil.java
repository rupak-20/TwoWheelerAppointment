package com.twowheeler.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	
	private static Connection connNursery;
	
	public static Connection createConnection() throws SQLException{
		//ResourceBundle resOracle = ResourceBundle.getBundle("oracle");
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
//		String username = resOracle.getString("root");
//		String password = resOracle.getString("root");
//		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
		connNursery = DriverManager.getConnection(url, "root", "root");
		return connNursery;
	}
	
	public static void closeConnection()throws SQLException{
		if(connNursery != null){
			connNursery.close();
		}
	}
}