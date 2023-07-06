package it.unicam.cs.ids.Loyalty_Platform.list;


import java.sql.SQLException;
import java.util.Scanner;

public class CatalogoPremi {
	
	private ArrayDati catalogo=null;
	private Scanner sc = new Scanner(System.in);
	private String[] premio;
	QueryDatabase db= new QueryDatabase();
	String[] dati;
	 
	
	public boolean getPremiDaDB() throws SQLException {
		catalogo=db.queryNoParam("SELECT * FROM premi");
		boolean b=true;
		if(catalogo==null) {
			b= false;
		}
		return b;
	}
	
	public void stampaCatalogo() { 
		
		String[] s=null;
		
		try {
			getPremiDaDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		s=catalogo.getAllLabels();
		for(int i=0;i<s.length;i++) {
			if(i==s.length-2) {
				i++;
			}
			System.out.printf("%-15s", s[i]);
		}
		System.out.print("\n");
		for(int i=0;i<catalogo.rowSize();i++) {
			s=catalogo.getRow(i);
			for(int j=0;j<s.length;j++) {
				if(j==s.length-2) {
					j++;
				}
				System.out.printf("%-15s", s[j]);
			}
		}
		
	}
	
	public Premi getPremioByIndex(int i) {
		
		return new Premi(Integer.parseInt(catalogo.getRow(i)[0]),
				catalogo.getRow(i)[1],catalogo.getRow(i)[2],
				Integer.parseInt(catalogo.getRow(i)[3]));
		
	}
	
	public boolean modificaPremio() throws SQLException {
		
		System.out.print("Scegli il premio da modificare inserendo il numero della lista: \n");
		
		stampaCatalogo();
		
		premio=catalogo.getRow(Integer.parseInt(sc.nextLine())-1);
		
		System.out.println("Scegli cosa modificare: ");
		System.out.println("-1 Nome\n"
				+ "-3 Quantità di punti");
		
		int choice=Integer.parseInt(sc.nextLine());
		
		System.out.println("Inserisci il nuovo valore: ");
		
		String s =sc.nextLine();
		String l= catalogo.getLabel(choice);
		
		String[] values= {s, premio[choice]};
		
		return db.update("UPDATE premi SET "+l+"=? WHERE "+l+"=?", values);
		
	}
	
	public boolean creaPremio() {
		

		try {
			getPremiDaDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dati= new String[catalogo.getAllLabels().length-1];
		System.out.println("Inserisci i dati per la creazione dell'premio");
		
		System.out.println("Inserisci il Nome: ");
		dati[0]=sc.nextLine();
		System.out.println("Inserisci la Descrizione: ");
		dati[1]=sc.nextLine();
		System.out.println("Inserisci la quantita di punti: ");
		dati[2]=sc.nextLine();
		
		try {
			return db.insert("INSERT INTO `premi`(`Nome`, `Descrizione`, `Punti`) VALUES (?,?,?)", dati);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
