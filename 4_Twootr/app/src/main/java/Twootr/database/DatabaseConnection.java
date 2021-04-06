package Twootr.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DatabaseConnection {
	
	static {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			
		} catch (ClassNotFoundException e) {
			
			throw new Error(e);
		}
	}
	
	static Connection get() throws SQLException {
		
		return DriverManager.getConnection("jdbc:hsqldb:db/mydatabase", "SA", "");
	}

}
