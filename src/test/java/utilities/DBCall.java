package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCall {

	private static final String dbUrl = PropertiesReader.readProperty("dbURL");
	private static final String dbUsername = PropertiesReader.readProperty("dbUsername");
	private static final String dbPassword = PropertiesReader.readProperty("dbPassword");
	private static final String driverClass = PropertiesReader.readProperty("driverClass");
	private static Connection connection;

	public static void setUpDB() {
		try {
			Class.forName(driverClass);
		} catch (final Exception e) {
			throw new RuntimeException("Driver failure");
		}
		try {
			connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			if(connection!=null) {
				System.out.println("Connected to the database...");
			}
		} catch (final Exception e) {
			throw new RuntimeException("Database connection failed");
		}
	}

	public static void executeSQLQuery(String sqlQuery){
		Statement stmt = null;
		try {
			setUpDB();
			stmt = connection.createStatement();
			int affectedRows = stmt.executeUpdate(sqlQuery);
			System.out.printf("%d row(s) updated!", affectedRows);
			tearDownDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void tearDownDB() {
		if (connection != null) {
			try {
				System.out.println(" Closing Database Connection...");
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}