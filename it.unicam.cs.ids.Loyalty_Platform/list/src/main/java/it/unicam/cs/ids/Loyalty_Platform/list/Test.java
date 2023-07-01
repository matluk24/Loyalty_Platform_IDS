package it.unicam.cs.ids.Loyalty_Platform.list;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		QueryDatabase db= new QueryDatabase();
		
		System.out.println(db.conn());
		
		db.query("SELECT * FROM Utenti", args);
	}

}
