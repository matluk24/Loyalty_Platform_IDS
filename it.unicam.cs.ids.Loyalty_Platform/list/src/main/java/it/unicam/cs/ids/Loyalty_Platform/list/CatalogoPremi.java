package it.unicam.cs.ids.Loyalty_Platform.list;

import java.util.LinkedList;

public class CatalogoPremi {
	
	private LinkedList<Premi> catalogo= new LinkedList<Premi>();
	
	
	public void getPremiDaDB() {
		
		for(int i=0;i<20;i++) {
			catalogo.add(new Premi());
		}
		
	}
	
	public Premi getPremioByIndex(int i) {
		
		return catalogo.get(i);
		
	}
	
}
