package it.unicam.cs.ids.Loyalty_Platform.app;

import java.sql.SQLException;
import java.util.Scanner;

import it.unicam.cs.ids.Loyalty_Platform.list.GestoreAmministratore;

public class MainAmministratore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		GestoreAmministratore ga= new GestoreAmministratore();
		boolean b=true;
		String s;
		
		System.out.println("Benevenuto nel menù del amministratore");
		while (b) {
		System.out.println("Seleziona la funzionalità che vuoi eseguire:\n"
				+ "-1 Crea utente\n"
				+ "-2 Modifica utente");
		
		s=sc.nextLine();
		switch(Integer.parseInt(s)) {
		
		case 1:
			break;
		case 2:
			ga.stampaUtenti();
			System.out.println("\nScegli quale utente modificare: ");
			try {
				s=sc.nextLine();
				if(ga.modificaUtente(Integer.parseInt(s))) {
					System.out.println("La modifica dell'utente è andata a buon fine.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		}
		System.out.println("Vuoi eseguire altre operazioni? y per confermare");
		s=sc.nextLine();
		if(s.equals("y")) {
			b=true;
		}
		else {
			b=false;
			
		}
		}
		
	}

}
