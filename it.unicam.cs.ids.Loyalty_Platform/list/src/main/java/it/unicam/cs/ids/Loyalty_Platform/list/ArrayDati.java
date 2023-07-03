package it.unicam.cs.ids.Loyalty_Platform.list;

import java.util.*;

import com.mysql.jdbc.ResultSet;

public class ArrayDati {
	private ArrayList<String> labels= new ArrayList<String>();
	private ArrayList <String[]> rows;

	public ArrayDati(ArrayList<String> labels, ArrayList<String[]> rows) {
		//To do controlli eccezione e classe
		this.labels=labels;
		this.rows=rows;
	}
	public String getLabel(int i){
		return labels.get(i);
	}
	public String getLabel(String s) {
		for(String label: this.labels) {
			if(s.equals(label)) {
				return s;
			}
		}
		return null;
	}
	public String[] getRow(int i) {
		return rows.get(i);
	}
	public String[] getRow(String s) {
		for(int i=0;i<rows.size();i++) {
			for(String column: rows.get(i)) {
				if(s.equals(column)) {
					return rows.get(i);
				}
			}
		}
		return null;
	}
	
	public int rowSize() {
		return rows.size();
	}
	
	@Override
	public String toString() {//Da sistemare, forse meglio usare printf su ogni classe per gesitre meglio
							// ma implica dover fare 2 to string diversi per label e righe
		
		String s="";
		
		for(int i=0;i<labels.size();i++) {
			s+=labels.get(i)+"	 ";
		}
		s+="\n";
		for(int i=0;i<rows.size();i++) {
			for(int j=1;j<rows.get(i).length;j++) {
				s+=rows.get(i)[j]+"		";
			}
		}
		return s;
		
	}
}