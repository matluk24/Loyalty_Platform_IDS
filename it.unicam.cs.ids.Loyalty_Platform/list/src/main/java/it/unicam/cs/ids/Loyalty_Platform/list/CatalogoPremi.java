package it.unicam.cs.ids.Loyalty_Platform.list;

import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CatalogoPremi {
	
	private QueryDatabase db= new QueryDatabase();
	private LinkedList<Premi> catalogo= new LinkedList<Premi>();
	private ResultSet s= null;
	
	
	public void getPremiDaDB() throws SQLException {
		
		
		db.conn();
		s=db.query("SELECT * FROM premi", null);
		
		while(s.next()) {
			catalogo.add(new Premi(s.getInt(1), s.getString(2), s.getString(3), s.getInt(4)));
		}
	}
	
	public void stampaCatalogo() {
		
		for(int i=0;i<catalogo.size();i++) {
			System.out.println(catalogo.get(i).toString());
		}
		
	}
	
	public Premi getPremioByIndex(int i) {
		
		return catalogo.get(i);
		
	}
	
}
