package it.unicam.cs.ids.Loyalty_Platform.app;

import java.util.Scanner;

public class MainCassiere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Benvenuto nel menu del cassiere: ");
		System.out.println("Scegli l'operazione da eseguire: ");
		System.out.println("-1 Crea Tessera\n"
				+ "-2 Identifica cliente\n"
				+ "-3 Convalida acquisto");
		
		switch (Integer.parseInt(sc.nextLine())) {
		
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}
		
	}

}
