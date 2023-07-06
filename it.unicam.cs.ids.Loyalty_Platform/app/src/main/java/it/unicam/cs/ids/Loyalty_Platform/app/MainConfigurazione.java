package it.unicam.cs.ids.Loyalty_Platform.app;

import java.sql.SQLException;
import java.util.Scanner;

import it.unicam.cs.ids.Loyalty_Platform.list.CatalogoPremi;

public class MainConfigurazione {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CatalogoPremi c=new CatalogoPremi();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Benevenuto nel menù ddella configurazione");
		System.out.println("Seleziona la funzionalità che vuoi eseguire:\n"
				+ "-1 Modifica Premi\n"
				+ "-2 Crea premio\n"
				+ "-3 Aggiungi programma fedeltà\n"
				+ "-4 Modifica programma fedeltà");
		
		switch (Integer.parseInt(sc.nextLine())) {
		
		case 1:
			try {
				if(c.modificaPremio()) {
					System.out.println("Premio modificato con successo!");
					break;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
				if(c.creaPremio()) {
					System.out.println("Premio creato con successo!");
				}
				break;
		case 3:
			break;
		case 4:
			break;
		}
		
	}

}
