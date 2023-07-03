package it.unicam.cs.ids.Loyalty_Platform.list;

public class Acquisto {

	private int id;
	private String fattura;
	private int totale;
	private boolean convalidato;
	
	public Acquisto(int id, String f, int t, boolean c) {
		this.id=id;
		this.fattura=f;
		this.totale=t;
		this.convalidato=c;
	}
	
	public String getFattura() {
		return fattura;
	}
	public void setFattura(String fattura) {
		this.fattura = fattura;
	}
	public int getTotale() {
		return totale;
	}
	public void setTotale(int totale) {
		this.totale = totale;
	}
	public boolean isConvalidato() {
		return convalidato;
	}
	public void setConvalidato(boolean convalidato) {
		this.convalidato = convalidato;
	}
	
	
	
}
