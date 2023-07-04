package it.unicam.cs.ids.Loyalty_Platform.list;

public class Utenti {
	
	private String nome;
	private String cognome;
	private String email;
	private String nomeutente;
	private String password;
	private int livello;
	
	public Utenti(String n, String c,String e, String nu, String p, int l) {
		nome=n;
		cognome=c;
		email=e;
		nomeutente=nu;
		livello=l;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeutente() {
		return nomeutente;
	}
	public void setNomeutente(String nomeutente) {
		this.nomeutente = nomeutente;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLivello() {
		return livello;
	}
	public void setLivello(int livello) {
		this.livello = livello;
	}
	
}
