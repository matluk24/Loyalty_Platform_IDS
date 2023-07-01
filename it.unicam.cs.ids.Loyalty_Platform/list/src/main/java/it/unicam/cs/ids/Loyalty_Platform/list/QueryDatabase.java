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
	
	public void query(String query, String[] arguments) {
		Connection conn = this.conn();
		ResultSet resultSet=null;
		try {
			PreparedStatement pStmt= conn.prepareStatement(query);
			for(int i = 0; i<arguments.length;i++ ) {
				pStmt.setString(i+1,arguments[i]);
			}
			resultSet = pStmt.executeQuery();
			while(resultSet.next()) {
				for(int i=1;i<=resultSet.getMetaData().getColumnCount();i++) {
					System.out.print(resultSet.getString(resultSet.getMetaData().getColumnName(i))+" ");
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void insert(String insert, String[] attributes) {
		Connection conn = this.conn();
		ResultSet resultSet=null;

		try {
			PreparedStatement pStmt= conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			for(int i = 0; i<attributes.length;i++ ) {
				pStmt.setString(i+1,attributes[i]);
			}
			pStmt.execute();
			resultSet = pStmt.getGeneratedKeys();
			while(resultSet.next()) {
				System.out.println("Generate: "+resultSet.getString(1)); 
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
