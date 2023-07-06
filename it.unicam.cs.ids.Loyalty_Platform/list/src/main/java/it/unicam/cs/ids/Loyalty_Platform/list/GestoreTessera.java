package it.unicam.cs.ids.Loyalty_Platform.list;

import java.sql.SQLException;
import java.util.Scanner;

public class GestoreTessera {

	
	QueryDatabase db = new QueryDatabase();
	ArrayDati a=null;
	String[] dati;
	Scanner sc = new Scanner(System.in);
	
	public Tessera stampaTessera(int cliente) {
		
		int punti,livello,esp,perc, n;
		
		try {
			a=db.queryOneParam("SELECT Punti FROM programmapunti WHERE Id_cliente=?", String.valueOf(cliente));
			if(a.getRow(0)!=null) {
				punti=Integer.parseInt(a.getRow(0)[0]);
				return new TesseraPunti(cliente,punti);
			}
			a=db.queryOneParam("SELECT Livello, Esperienza, N_visite FROM programmalivelli WHERE Id_cliente=?", String.valueOf(cliente));
			livello=Integer.parseInt(a.getRow(0)[0]);
			esp=Integer.parseInt(a.getRow(0)[1]);
			n=Integer.parseInt(a.getRow(0)[2]);
			a=db.queryOneParam("SELECT Percentuale_clienti FROM livelliprogramma WHERE Id_livello=?", String.valueOf(livello));
			perc=Integer.parseInt(a.getRow(0)[0]);
			
			return new TesseraLivello(cliente,livello,esp,perc,n);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void creaTessera(String n) {
		
		try {
			int i=0;
			a=db.queryOneParam("SELECT Id_cliente FROM clienti WHERE Nome=? AND TesseraPunti=0", n);
			if(a.getRow(i)==null) {
				System.out.println("L'utente scelto ha già una tessera");
				return;
			}
			String id= a.getRow(i)[i];
			a=db.queryNoParam("SELECT * FROM formulario");
			dati=new String[a.getAllLabels().length];
			dati[i]=id;
			
			for(String l:a.getAllLabels()) {
				if(l.equals("Id_cliente" )) {
					continue;
				}
				i++;
				System.out.println("Inserisci il "+l+" del cliente: ");
				dati[i]=sc.nextLine();
				
			}
			
			if(db.insert("INSERT INTO formulario(Id_cliente,CF,DataDiNascita,LuogoDiNascita,Residenza,Documento,CodiceDocumento) VALUES (?,?,?,?,?,?,?)", dati)) {
				dati=new String[2];
				dati[0]=id;
				dati[1]="0";
				System.out.println("Formulario compilato con successo!");
				System.out.println("Scegli il programma fedelta a cui aderire: \n"
						+ "-1 Programma a livelli\n"
						+ "-2 Programma a punti");
				db.update("UPDATE clienti SET tessera=1 WHERE Id_cliente=?", id);
				switch (Integer.parseInt(sc.nextLine())) {
				
				case 1:
					db.insert("INSERT INTO programmalivelli(Id_cliente,Livello,Esperienza,N_visite) VALUES (?,?,0,0)", dati);
					break;
				
				case 2:
					db.insert("INSERT INTO programmapunti(Id_cliente,Punti) VALUES (?,?)", dati);
					break;
				}
				System.out.println("TesseraPunti creata con successo!");
			}
			else {
				System.out.println("Problemi nel compilamento del formulario");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
