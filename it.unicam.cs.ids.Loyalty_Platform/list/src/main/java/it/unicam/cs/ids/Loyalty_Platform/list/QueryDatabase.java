package it.unicam.cs.ids.Loyalty_Platform.list;

import java.sql.*;
import java.util.*;

import javax.crypto.spec.PSource.PSpecified;

public class QueryDatabase {
	
	Connection conn=null;
	
	public QueryDatabase() {
		
	}
	
	public void conn() {
		String conUrl = "jdbc:mysql://localhost:3306/loyaltyplatform";
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			conn =(Connection) DriverManager.getConnection(conUrl,"root","");
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public ArrayDati query(String query, String[] arguments) throws SQLException {
		int l;
		ArrayDati dati=null;
		if(arguments==null) {
			l=0;
		}
		else {
			l=arguments.length;
		}
		ResultSet resultSet=null;
		try {
			conn();
			PreparedStatement pStmt= conn.prepareStatement(query);
			for(int i = 0; i<l;i++ ) {
				pStmt.setString(i+1,arguments[i]);
			}
			resultSet = pStmt.executeQuery();
			resultSet.next();
			dati=strutturaDati(resultSet);
			pStmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return dati;
		
	}
	
	
	public ArrayDati queryOneParam(String query, String a) throws SQLException {
		String[] s=new String[1];
		s[0]=a;
		return query(query, s);
	}
	
	public ArrayDati queryNoParam(String query) throws SQLException {
		return query(query, null);
	}
	
	
	
	public ArrayDati insert(String insert, String[] attributes) throws SQLException {
		ResultSet resultSet=null;
		ArrayDati dati=null;
		try {
			conn();
			PreparedStatement pStmt= conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			for(int i = 0; i<attributes.length;i++ ) {
				pStmt.setString(i+1,attributes[i]);
			}
			pStmt.execute();
			resultSet = pStmt.getGeneratedKeys();
			dati=strutturaDati(resultSet);
			pStmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dati;
	}
	public Boolean updateProgrammi(String sql, int id) throws SQLException {
		conn();
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setInt(1, id);
		int b=pStmt.executeUpdate();
		pStmt.close();
		conn.close();
		return (b==1) ? true : false;
	}
	
	public void close(String sql, String data) throws SQLException {
		
		conn.close();
		
	}
	
	public ArrayDati strutturaDati(ResultSet rs) throws SQLException {
		ArrayList<String> label= new ArrayList<String>();
		ResultSetMetaData rsmd = rs.getMetaData();
		int i=1;
		for( ;i<=rsmd.getColumnCount();i++) {
			label.add(rsmd.getColumnName(i));
		}
		i--;
		ArrayList<String[]> rows = new ArrayList<String[]>();
		while(rs.getRow()!=0) {
			String[] s = new String[i];
			for(int j=0;j<i;j++) {
				s[j]=rs.getString(j+1);
			}
			rows.add(s);
			rs.next();
		}
		
		ArrayDati dati = new ArrayDati(label, rows);
		return dati;
	}
	
}
