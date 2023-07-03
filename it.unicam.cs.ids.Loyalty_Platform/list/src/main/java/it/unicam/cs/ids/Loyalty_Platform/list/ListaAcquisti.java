package it.unicam.cs.ids.Loyalty_Platform.list;

import java.sql.SQLException;

public class ListaAcquisti {
	
	private ArrayDati lista= null;
	
	
	public boolean getAcquistiDaDB() throws SQLException {
		
		QueryDatabase db= new QueryDatabase();
		lista=db.query("SELECT * FROM acquisti", null);
		boolean b=true;
		if(lista==null) {
			b= false;
		}
		return b;
	}
	
	public Acquisto getAcquistoByIndex(int i) {
		
		return new Acquisto(Integer.parseInt(lista.getRow(i)[0]),
				lista.getRow(i)[1],Integer.parseInt(lista.getRow(i)[2]),
				Boolean.parseBoolean(lista.getRow(i)[3]));
	}
}
