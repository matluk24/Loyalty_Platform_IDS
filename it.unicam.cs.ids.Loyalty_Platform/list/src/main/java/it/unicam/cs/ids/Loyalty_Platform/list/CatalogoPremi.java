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
		
		String[] s=null;
		
		s=catalogo.getAllLabels();
		for(int i=0;i<s.length;i++) {
			if(i==s.length-2) {
				i++;
			}
			System.out.printf("%-15s", s[i]);
		}
		System.out.print("\n");
		for(int i=0;i<catalogo.rowSize();i++) {
			s=catalogo.getRow(i);
			for(int j=1;j<s.length;j++) {
				if(j==s.length-2) {
					j++;
				}
				System.out.printf("%-15s", s[j]);
			}
		}
		
	}
	
	public Premi getPremioByIndex(int i) {
		
		return new Premi(Integer.parseInt(catalogo.getRow(i)[0]),
				catalogo.getRow(i)[1],catalogo.getRow(i)[2],
				Integer.parseInt(catalogo.getRow(i)[3]));
		
	}
	
}
