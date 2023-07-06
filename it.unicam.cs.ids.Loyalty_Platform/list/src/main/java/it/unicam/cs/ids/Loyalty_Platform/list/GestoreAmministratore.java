package it.unicam.cs.ids.Loyalty_Platform.list;

import java.sql.SQLException;
import java.util.Scanner;

public class GestoreAmministratore {
	
	QueryDatabase db=new QueryDatabase();
	ArrayDati a=null;
	Utenti u=null;
	Scanner sc=new Scanner(System.in);
	String[] dati= null;
	
	public void stampaUtenti() {
		
		try {
			a=db.queryNoParam("SELECT * FROM utenti");
			
			String[] s=null;
			
			s=a.getAllLabels();
			System.out.print("   ");
			for(int i=0;i<s.length;i++) {
				System.out.printf("%-20s", s[i]);
			}
			System.out.print("\n");
			for(int i=0;i<a.rowSize();i++) {
				s=a.getRow(i);
				System.out.print("-"+i+" ");
				for(int j=0;j<s.length;j++) {
					System.out.printf("%-20s", s[j]);
				}
				System.out.printf("\n"
						+ "");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public boolean creaUtente() {
		
		try {
			a=db.queryNoParam("SELECT * FROM utenti");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dati= new String[a.getAllLabels().length];
		System.out.println("Inserisci i dati per la creazione dell'utente");
		
		System.out.println("Inserisci il nome utente: ");
		dati[0]=sc.nextLine();
		System.out.println("Inserisci il nome: ");
		dati[1]=sc.nextLine();
		System.out.println("Inserisci il cognome: ");
		dati[2]=sc.nextLine();
		System.out.println("Inserisci l'email: ");
		dati[3]=sc.nextLine();
		System.out.println("Inserisci la password: ");
		dati[4]=sc.nextLine();
		System.out.println("Inserisci il livello di permesso: ");
		dati[5]=sc.nextLine();
		
		try {
			return db.insert("INSERT INTO `utenti`(`NomeUtente`, `Nome`, `Cognome`, `email`, `Password`, `Livello`) VALUES (?,?,?,?,?,?)", dati);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean modificaUtente(int i) throws SQLException {
	
		boolean b=true;
		int choice;
		String s;
		String sql;
		
		dati=a.getRow(i);
		u=new Utenti(dati[0], dati[1], dati[2], dati[3], dati[4], Integer.parseInt(dati[5]));
		
		System.out.println("Hai scelto: "+u.toString());
		System.out.println("Scegli quale parametro dell'utente scelto vuoi modificare: ");
		System.out.println("-1 Nome Utente\n"
				+ "-2 Nome\n"
				+ "-3 Cognome\n"
				+ "-4 Email\n"
				+ "-5 Password\n"
				+ "-6 Livello di permesso");
		
		choice=Integer.parseInt(sc.nextLine());	
		
		for(String l:a.getAllLabels()) {
			if(l==a.getLabel(choice-1)) {
				System.out.println("Inserisci il nuovo valore: ");
				s=sc.nextLine();
				sql="UPDATE utenti SET ?=? WHERE ?=?";
				String[] values= {l,s,l,dati[choice-1]};
				b=db.update(sql, values);
			}
		}
		return b;
		
		
	}
	
	
}
