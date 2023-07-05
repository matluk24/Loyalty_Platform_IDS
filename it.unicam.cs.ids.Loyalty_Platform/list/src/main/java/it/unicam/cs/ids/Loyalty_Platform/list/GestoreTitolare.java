package it.unicam.cs.ids.Loyalty_Platform.list;

import java.sql.SQLException;
import java.util.Scanner;

public class GestoreTitolare {
	
	QueryDatabase db=new QueryDatabase();
	ArrayDati a=null;
	Utenti u=null;
	Scanner sc=new Scanner(System.in);
	
	public void stampaUtenti() {
		
		try {
			a=db.queryNoParam("SELECT * FROM utenti");
			
			String[] s=null;
			
			s=a.getAllLabels();
			for(int i=0;i<s.length;i++) {
				System.out.printf("%-15s", s[i]);
			}
			System.out.print("\n");
			for(int i=0;i<a.rowSize();i++) {
				s=a.getRow(i);
				for(int j=1;j<s.length;j++) {
					if(j==s.length-2) {
						j++;
					}
					System.out.print("-"+i+" ");
					System.out.printf("%-15s", s[j]);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public boolean modificaUtente(int i) {
		
		String[] dati=null;
		
		dati=a.getRow(i);
		u=new Utenti(dati[0], dati[1], dati[2], dati[3], dati[4], Integer.parseInt(dati[5]));
		
		System.out.println("Scegli quale parametro dell'utente scelto vuoi modificare: ");
		System.out.println("-1 Nome Utente\n"
				+ "-2 Nome\n"
				+ "-3 Cognome\n"
				+ "-4 Email\n"
				+ "-5 Password\n"
				+ "-6 Livello di permesso\n");
		
		switch (sc.nextInt()) {
			
		case 1:
			System.out.println("Inserisci il nuovo nome utente");
			u.setNomeutente(sc.nextLine());
			break;
		case 2:
			System.out.println("Inserisci il nuovo nome");
			u.setNome(sc.nextLine());
			break;
		case 3:
			System.out.println("Inserisci il nuovo cognome");
			u.setCognome(sc.nextLine());
			break;
		case 4:
			System.out.println("Inserisci la nuova email");
			u.setEmail(sc.nextLine());
			break;
		case 5:
			System.out.println("Inserisci la nuova password");
			u.setPassword(sc.nextLine());
			break;
		case 6:
			System.out.println("Inserisci il nuovo livello di permesso");
			u.setLivello(sc.nextInt());
			break;
		
		}
		
		
	}
	
	
}
