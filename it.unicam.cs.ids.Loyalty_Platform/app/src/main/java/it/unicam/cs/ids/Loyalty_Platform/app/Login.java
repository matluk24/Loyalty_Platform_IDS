package it.unicam.cs.ids.Loyalty_Platform.app;

import java.util.Scanner;

import it.unicam.cs.ids.Loyalty_Platform.list.QueryDatabase;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		QueryDatabase db= new QueryDatabase();
		String user="";
		String pw="";
		
		System.out.println("Benvenuto nella Loyalty Platform");
		System.out.print("Inserisci il tuo username: ");
		user=sc.nextLine();
		System.out.print("\n");
		System.out.print("Inserisci la tua password: ");
		pw=sc.nextLine();
		
		db.query("Select Password FROM utenti WHERE NomeUtente=?", user.);
		
	}

}
