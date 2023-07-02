package it.unicam.cs.ids.Loyalty_Platform.list;

import java.sql.*;

public class QueryDatabase {
	
	Connection conn=null;
	
	public Connection conn() {
		String conUrl = "jdbc:mysql://localhost:3306/loyaltyplatform";
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			conn =(Connection) DriverManager.getConnection(conUrl,"root","");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;	
	}
	
	public ResultSet query(String query, String[] arguments) {
		int l;
		if(arguments==null) {
			l=0;
		}
		else {
			l=arguments.length;
		}
		ResultSet resultSet=null;
		try {
			PreparedStatement pStmt= conn.prepareStatement(query);
			for(int i = 0; i<l;i++ ) {
				pStmt.setString(i+1,arguments[i]);
			}
			resultSet = pStmt.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
		
	}
	public ResultSet insert(String insert, String[] attributes) {
		ResultSet resultSet=null;

		try {
			PreparedStatement pStmt= conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			for(int i = 0; i<attributes.length;i++ ) {
				pStmt.setString(i+1,attributes[i]);
			}
			pStmt.execute();
			resultSet = pStmt.getGeneratedKeys();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public void close() throws SQLException {
		
		conn.close();
		
	}
	
}
