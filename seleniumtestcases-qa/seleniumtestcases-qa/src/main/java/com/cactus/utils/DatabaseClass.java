package com.cactus.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseClass {
	private static DatabaseClass instance;

	private String user = "dragons";
	private String password = "ITe#t^ssw16&";

	private String connectClass = "org.postgresql.Driver";

	private String dataURL1 = "jdbc:postgresql://sg.db.crm.test1.rw.cactusops.com:5432/crm";
	private String dataURL4 = "jdbc:postgresql://sg.db.crm.test4.rw.cactusops.com:5432/crm";
	private String dataURL9 = "jdbc:postgresql://sg.db.crm.test9.rw.cactusops.com:5432/crm";
	private String dataURL18 = "jdbc:postgresql://sg.db.crm.test18.rw.cactusops.com:5432/crm";
	private String dataURL25 = "jdbc:postgresql://sg.db.crm.test25.rw.cactusops.com:5432/crm";

	private String dataURLLive = "jdbc:postgresql://sg.db.crm.prod.rw.cactusops.com:5432/crm";
	private String dataURLDefault = "jdbc:postgresql://sg.db.crm.test1.rw.cactusops.com:5432/crm";

	private DatabaseClass() {
	}

	public static DatabaseClass getInstance() {
		if (instance == null) {
			instance = new DatabaseClass();
		}
		return instance;
	}

	public Connection connectWithDatabase(String dataURL) {
		Connection conn = null;
		try {
			Class.forName(connectClass);
			conn = DriverManager.getConnection(dataURL, user, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("Not connected to database");
		} catch (ClassNotFoundException e) {
			System.out.println("No class found");
		}
		return conn;
	}

	public Connection getConnection(String testEnvironment) {
		String dataURL = getDataURL(testEnvironment);
		return connectWithDatabase(dataURL);
	}
	
	public Statement getStatement(Connection conn ){
		try {
			return conn.createStatement();
		} catch (SQLException e) {
			return null;
		}
	
	}

	public String getDataURL(String testEnvironment) {
		String dataURL = "";
		switch (testEnvironment) {
		case "test1":
			dataURL = dataURL1;
			break;
		case "test4":
			dataURL = dataURL4;
			break;
		case "test9":
			dataURL = dataURL9;
			break;
		case "test18":
			dataURL = dataURL18;
			break;
		case "test25":
			dataURL = dataURL25;
			break;
		case "Live":
			dataURL = dataURLLive;
			break;
		case "live":
			dataURL = dataURLLive;
			break;
		default:
			dataURL = dataURLDefault;
			break;
		}
		return dataURL;
	}

	public ResultSet getResultSet(String testEnvironment, String query) {
		try {
			Connection conn = getConnection(testEnvironment);
			Statement stmt = getStatement(conn);
			ResultSet rs = stmt.executeQuery(query);
			//closeDBInstance(stmt, rs, conn);
			return rs;
		} catch (SQLException e) {

			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;
	}

	public void closeDBInstance(Statement stmt, ResultSet rs, Connection conn) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}

}
