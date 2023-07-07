package it.unicam.cs.ids.Loyalty_Platform.app;

import java.util.Scanner;

import it.unicam.cs.ids.Loyalty_Platform.list.CatalogoPremi;
import it.unicam.cs.ids.Loyalty_Platform.list.GestoreCliente;
import it.unicam.cs.ids.Loyalty_Platform.list.GestoreTessera;
import it.unicam.cs.ids.Loyalty_Platform.list.Tessera;
import it.unicam.cs.ids.Loyalty_Platform.list.TesseraPunti;

public class MainCassiere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		GestoreTessera gt= new GestoreTessera();
		GestoreCliente gc= new GestoreCliente();
		CatalogoPremi c=new CatalogoPremi();
		
		System.out.println("Benvenuto nel menu del cassiere: ");
		System.out.println("Scegli l'operazione da eseguire: ");
		System.out.println("-1 Crea Tessera \n"
				+ "-2 Identifica cliente");
		
		switch (Integer.parseInt(sc.nextLine())) {
		
		case 1:
			
			System.out.println("Inserisci il nome del cliente di cui creare la tessera: ");
			gt.creaTessera(sc.nextLine());
			break;
		case 2:
			
			System.out.println("Inserisci l\'id del cliente che ha una tessera: ");
			String s= sc.nextLine();
			System.out.println("Il cliente è: \n");
			gc.stampaCliente(s);
			Tessera t= gt.stampaTessera(Integer.parseInt(s));
			System.out.println("\nLa tessera del cliente è: ");
			System.out.println(t.toString());
			
			System.out.println("Il cliente vuole ritirare un premio? y per confermare");
			if(sc.nextLine().equals("y")) {
				System.out.println("Inserisci l'id del premio che il cliente vuole ricevere: ");
				c.stampaCatalogo();
				String p=sc.nextLine();
				c.ritiraPremio(s, p);
			}
			
			System.out.println("Vuoi convalidare un acquisto? y per confermare");
			if(sc.nextLine().equals("y")) {
				
			}
			
			break;
			
		}
		
	}

}
