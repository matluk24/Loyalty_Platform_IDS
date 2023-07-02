package it.unicam.cs.ids.Loyalty_Platform.list;

import java.sql.*;

public class QueryDatabase {
	
	public Connection conn() {
		Connection connection=null;
		String conUrl = "jdbc:mysql://localhost:3306/loyaltyplatform";
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			connection =(Connection) DriverManager.getConnection(conUrl,"root","");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;	
	}
	
	public ResultSet query(String query, String[] arguments) {
		Connection conn = this.conn();
		ResultSet resultSet=null;
		try {
			PreparedStatement pStmt= conn.prepareStatement(query);
			for(int i = 0; i<arguments.length;i++ ) {
				pStmt.setString(i+1,arguments[i]);
			}
			resultSet = pStmt.executeQuery();
			
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
		
	}
	public ResultSet insert(String insert, String[] attributes) {
		Connection conn = this.conn();
		ResultSet resultSet=null;

		try {
			PreparedStatement pStmt= conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			for(int i = 0; i<attributes.length;i++ ) {
				pStmt.setString(i+1,attributes[i]);
			}
			pStmt.execute();
			resultSet = pStmt.getGeneratedKeys();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
}
