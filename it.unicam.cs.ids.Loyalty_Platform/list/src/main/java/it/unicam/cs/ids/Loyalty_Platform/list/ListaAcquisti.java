package it.unicam.cs.ids.Loyalty_Platform.list;

import java.util.LinkedList;

public class ListaAcquisti {
	
	private LinkedList<Acquisto> lista= new LinkedList<Acquisto>();
	
	
	public void getAcquistiDaDB() {
		
	}
	
	public Acquisto getAcquistoByIndex(int i) {
		
		return lista.get(i);
	}
}
