package it.unicam.cs.ids.Loyalty_Platform.list;

import java.sql.SQLException;
import java.util.Scanner;

public class GestoreAmministratore {
	
	QueryDatabase db=new QueryDatabase();
	ArrayDati a=null;
	Utenti u=null;
	Scanner sc=new Scanner(System.in);
	
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
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public boolean modificaUtente(int i) throws SQLException {
		
		String[] dati=null;
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
			if(l==a.getAllLabels()[choice-1]) {
				System.out.println("Inserisci il nuovo valore: ");
				s=sc.nextLine();
				sql="UPDATE utenti SET "+l+"=?";
				b=db.update(sql, s);
			}
		}
		return b;
		
		
	}
	
	
}
