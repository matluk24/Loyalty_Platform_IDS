package it.unicam.cs.ids.Loyalty_Platform.list;

import java.sql.SQLException;

public class Programmi {
	
	private ArrayDati programmi;
	
	public Programmi() throws SQLException {
		QueryDatabase db = new QueryDatabase();
		String sql="SELECT * From programmi";
		this.programmi=db.queryNoParam(sql);
	}
	
	public Boolean setProgramma(int i, String label, String data) throws SQLException {
		for(String l : programmi.getAllLabels()) {
			if(l==label) {
				QueryDatabase db = new QueryDatabase();
				String sql="UPDATE programmi SET "+label+"="+data+" WHERE id_programma=?";
				this.programmi = new Programmi().getProgrammi();
				return db.updateProgrammi(sql, i);
			}
		}
		return false;
	}

	public String getProgramma() {
		
		return null;
	}
	public ArrayDati getProgrammi() {
		return programmi;
	}

}
