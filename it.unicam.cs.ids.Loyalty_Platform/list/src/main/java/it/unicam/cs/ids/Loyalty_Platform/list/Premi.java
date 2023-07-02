package it.unicam.cs.ids.Loyalty_Platform.list;


public class Premi {

	private int id;
	private String nome;
	private String descrizione;
	private int punti;
	
	public Premi(int id, String n, String des, int p) {
		this.id=id;
		nome=n;
		descrizione=des;
		punti=p;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String des) {
		this.descrizione = des;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	
	@Override
	public String toString() {
		
		return id + " "+nome+" "+descrizione+" "+punti;
		
	}
	
}
