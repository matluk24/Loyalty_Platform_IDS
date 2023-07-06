package it.unicam.cs.ids.Loyalty_Platform.list;

import java.sql.SQLException;

public class GestoreCliente {

	ArrayDati a=null;
	QueryDatabase db= new QueryDatabase();
	
	public void stampaCliente(String c) {
		
		String[] s=null;
		
		try {
			a=db.queryOneParam("SELECT * FROM clienti WHERE Id_cliente=?", c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		s=a.getAllLabels();
		for(int i=0;i<s.length;i++) {
			System.out.printf("%-15s", s[i]);
		}
		System.out.print("\n");
		for(int i=0;i<a.rowSize();i++) {
			s=a.getRow(i);
			for(int j=0;j<s.length;j++) {
				if(j==s.length-1) {
					if(s[j].equals("1")) {
						s[j]="Si";
					}
					else {
						s[j]="No";
					}
				}
				System.out.printf("%-15s", s[j]);
			}
		}
	}
	
}
