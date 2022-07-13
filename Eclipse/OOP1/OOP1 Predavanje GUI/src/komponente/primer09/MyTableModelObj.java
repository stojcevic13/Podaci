package komponente.primer09;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MyTableModelObj extends AbstractTableModel {
	
	private static final long serialVersionUID = -7620993815045700465L;
	
	private String[] kolone = { "Broj indeksa", "Ime", "Prezime", "Godina upisa", "Budžet"};
	private List<Student> studenti = new ArrayList<Student>(); 
	
	private Student dummy = new Student("23dsf", "dummy", "dummych", 2000, true);

	public MyTableModelObj() {
		this.studenti.add(new Student("SV41/2020", "Nemanja", "Stojcevic",  2020, true));
		this.studenti.add(new Student("ME25/2017", "Nikola", "Stojcevic",	2017, false));
		this.studenti.add(new Student("ME16/2017", "Aleksandar", "Nikolic", 2020, false));
		this.studenti.add(new Student("SV25/2017", "Marko", "Markovic",  	2017, false));
		this.studenti.add(new Student("RA25/2017", "Nikola", "Stojcevic",  	2017, false));
		this.studenti.add(new Student("SV25/2017", "Marko", "Markovic",  	2017, false));
		this.studenti.add(new Student("ME16/2017", "Aleksandar", "Nikolic", 2020, false));
		this.studenti.add(new Student("ME25/2017", "Nikola", "Stojcevic",	2017, false));
		this.studenti.add(new Student("SV41/2020", "Nemanja", "Stojcevic",  2020, true));
	}
	
	
	
	
	
	
	@Override
	public Class<?> getColumnClass(int col){
		//return this.studenti.get(0).toCell(col).getClass();
		//return getValueAt(0, col).getClass();
		return this.dummy.toCell(col).getClass();
	}
	
	@Override
	public int getRowCount() {
		return this.studenti.size();
	}

	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//return null;
		return this.studenti.get(rowIndex).toCell(columnIndex);
	}
	
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		System.out.println("Postavio vrijednost " + value + " na " + rowIndex + ", " + columnIndex + " tipa "  + value.getClass());
		this.studenti.get(rowIndex).set(value, columnIndex);
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		if (col == 0)
			return false;
		return true;
	}
	
	@Override
	public String getColumnName(int col) {
		return this.kolone[col];
	}
	
	
	
	
	public void obrisiStudenta(int row) {
		this.studenti.remove(row);
		fireTableDataChanged();
	}
	
	
	

}
