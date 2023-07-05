package it.unicam.cs.ids.Loyalty_Platform.app;

import java.sql.SQLException;
import java.util.Scanner;

import it.unicam.cs.ids.Loyalty_Platform.list.ArrayDati;
import it.unicam.cs.ids.Loyalty_Platform.list.QueryDatabase;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		QueryDatabase db= new QueryDatabase();
		String user="";
		String pw="";
		ArrayDati a = null;
		boolean b=true;
		
		System.out.println("Benvenuto nella Loyalty Platform");
		while(b) {
			System.out.print("Inserisci il tuo username: ");
			user=sc.nextLine();
			System.out.print("Inserisci la tua password: ");
			pw=sc.nextLine();
		
			try {
				a=db.queryOneParam("Select Password FROM utenti WHERE NomeUtente=?", user);
				if(a.getRow(0)[0].equals(pw)) {
					a=db.queryOneParam("Select Livello FROM utenti WHERE NomeUtente=?", user);
					switch (Integer.parseInt(a.getRow(0)[0])) {
				
						case 0:
							b=false;
							MainConfigurazione.main(args);
						break;
				
					}
				}
				else {
					System.out.println("La password inserita è errata");
					b=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}

}
