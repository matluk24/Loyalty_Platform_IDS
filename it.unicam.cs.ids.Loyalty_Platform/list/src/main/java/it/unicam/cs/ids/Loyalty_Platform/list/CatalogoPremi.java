package it.unicam.cs.ids.Loyalty_Platform.list;


import java.sql.SQLException;

public class CatalogoPremi {
	
	private ArrayDati catalogo=null;
	
	
	public boolean getPremiDaDB() throws SQLException {
		QueryDatabase db= new QueryDatabase();
		catalogo=db.query("SELECT * FROM premi", null);
		boolean b=true;
		if(catalogo==null) {
			b= false;
		}
		return b;
	}
	
	public void stampaCatalogo() {
		
		for(int i=0; i<catalogo.rowSize();i++) {
		System.out.println(catalogo.getRow(i).toString());
		}
		
	}
	
	public Premi getPremioByIndex(int i) {
		
		return new Premi(Integer.parseInt(catalogo.getRow(i)[0]),
				catalogo.getRow(i)[1],catalogo.getRow(i)[2],
				Integer.parseInt(catalogo.getRow(i)[3]));
		
	}
	
}
