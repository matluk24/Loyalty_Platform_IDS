package it.unicam.cs.ids.Loyalty_Platform.app;

import java.util.Scanner;

import it.unicam.cs.ids.Loyalty_Platform.list.CatalogoPremi;
import it.unicam.cs.ids.Loyalty_Platform.list.GestoreTessera;
import it.unicam.cs.ids.Loyalty_Platform.list.Tessera;

public class MainCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		GestoreTessera gt=new GestoreTessera();
		CatalogoPremi c=new CatalogoPremi();
		
		System.out.println("Benvenuto nell'area clienti.\n"
				+ "Seleziona cosa visualizzare: \n"
				+ "-1 Visualizza propria Tessera\n"
				+ "-2 Visualizza Catalogo premi\n"
				+ "-3 Iscriviti a un programma fedelta");
		
		
		switch (Integer.parseInt(sc.nextLine())) {
		
		case 1:
			System.out.println("Ecco la tua tessera fedelta");
			Tessera t=gt.stampaTessera(Integer.parseInt(args[1]));
			System.out.println(t.toString());
			break;
		
		case 2:
			System.out.println("Ecco il catalogo dei premi: ");
			c.stampaCatalogo();
			System.out.println("\nPer selezionare uno dei premi, avendo abbastanza punti recati in un punto vendita");
			break;
			
		case 3:
			System.out.println("Per iscriverti ad un programma fedelta recati ad un punto vendita ed effettua l'operazione con un cassiere");
			break;
			
		
		}
		
		
	}

}
