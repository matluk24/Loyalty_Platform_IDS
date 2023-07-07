package it.unicam.cs.ids.Loyalty_Platform.list;

import java.sql.SQLException;

public class GestoreProgrammi {
	
	ArrayDati programmi;
	
	public GestoreProgrammi() throws SQLException {
		QueryDatabase db = new QueryDatabase();
		String sql ="SELECT * FROM programmi";
		programmi = db.queryNoParam(sql);
	}
	
	public void stampaProgrammi() {	
		System.out.print("\nProgrammi :");
		System.out.print("\n");
		System.out.printf("%-15s", programmi.getLabel(0));
		System.out.printf("%-20s", programmi.getLabel(3));
		System.out.printf("%-20s", programmi.getLabel(2));
		for(String[]row : programmi.getRows()) {
			System.out.print("\n");
			System.out.printf("%-15s", row[0]);
			System.out.printf("%-20s", row[3]);
			System.out.printf("%-20s", row[2]);
			System.out.print("\n");
		}
	}
	public boolean modificaProgramma() throws SQLException{

		this.stampaProgrammi();

		return true;
	}

}
