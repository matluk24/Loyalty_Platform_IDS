package it.unicam.cs.ids.Loyalty_Platform.list;

public class TesseraPunti implements Tessera {

	
	private int cliente;
	private int totPunti;

	public TesseraPunti(int c, int p) {
		cliente=c;
		totPunti=p;
	}
	
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	public int getTotPunti() {
		return totPunti;
	}
	public void setTotPunti(int totPunti) {
		this.totPunti = totPunti;
	}
	
	@Override
	public String toString() {
		
		return "Totale punti del cliente: "+totPunti+"\n";
		
	}
	
}
