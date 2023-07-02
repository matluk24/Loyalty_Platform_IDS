package it.unicam.cs.ids.Loyalty_Platform.list;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	/*	QueryDatabase db= new QueryDatabase();
		
		System.out.println(db.conn());
		
		db.query("SELECT * FROM Utenti", null);*/
		
		CatalogoPremi c= new CatalogoPremi();
		
		try {
			c.getPremiDaDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.stampaCatalogo();
		
		
	}

}
