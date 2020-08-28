package dao.sql.mvc;

import java.sql.*;
import java.util.Properties;

import jdbcProperties.JdbcProperties;

public class DatabaseConnection {				

	private static	Connection connection ;



	static {			// creating a connection with the Singleton pattern 
		
		
		 	Properties props = JdbcProperties.getConnectionData();

	        String url = props.getProperty("db.url");
	        String username= props.getProperty("db.user");
	        String password = props.getProperty("db.passwd");
	        
		
		
		try 

		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
			}catch (ClassNotFoundException e){e.printStackTrace();}

			connection = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database

		} catch (Exception e) {	}

	}

	public static Connection getConnection() {
		return connection;
	}

	
	
	
	
}