package it.unicam.cs.ids.Loyalty_Platform.list;

public class TesseraLivello implements Tessera {
	
	private int cliente;
	private int livelloFedelta;
	private int esp;
	private int percClienti;
	private int nVisite;

	public TesseraLivello(int c, int l, int e, int per, int nV) {
		cliente=c;
		livelloFedelta=l;
		esp=e;
		percClienti=per;
		nVisite=nV;
	}
	
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	public int getLivelloFedelta() {
		return livelloFedelta;
	}
	public void setLivelloFedelta(int livelloFedelta) {
		this.livelloFedelta = livelloFedelta;
	}
	public int getEsp() {
		return esp;
	}
	public void setEsp(int esp) {
		this.esp = esp;
	}
	public int getPercClienti() {
		return percClienti;
	}
	public void setPercClienti(int percClienti) {
		this.percClienti = percClienti;
	}
	public int getnVisite() {
		return nVisite;
	}

	public void setnVisite(int nVisite) {
		this.nVisite = nVisite;
	}
	
	@Override
	public String toString() {
		
		return "Livello: "+livelloFedelta+"\n"
				+ "Esperienza fino al prossimo livello: "+esp+"\n"
				+ "Percentuale di clienti che hanno raggiunti il livello: "+percClienti+"\n"
				+ "Numero di visite effettuate dal cliente: "+nVisite+"\n";
		
	}
	
}
