package komponente.primer11kompletnatabela;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MyOwnTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -6835965891858692888L;

	private List<Student> studenti = new ArrayList<Student>();
	private String[] kolone = { "Broj indeksa", "Ime", "Prezime", "Godina upisa", "Budzet"};
	private Student dummy = new Student("skdj343", "dummy", "dummych", 432, true); 
	
	
	
	public MyOwnTableModel() {
		this.studenti.add(new Student("0000", "Mitar", "Mitrovic",  2020, true));
		this.studenti.add(new Student("0001", "Petar", "Petrovic",  2019, false));
		this.studenti.add(new Student("0002", "Laza", "Lazarevic",  2020, true));
		this.studenti.add(new Student("0003", "Zoran", "Zoranovic", 2020, true));
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
		return this.studenti.get(rowIndex).toCell(columnIndex);
	}
	
	@Override
	public String getColumnName(int col) {
		return this.kolone[col];
	}
	
	@Override
	public Class<?> getColumnClass(int col) {
		return this.dummy.toCell(col).getClass();
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		System.out.println("Postavio vrijednost " + value + " na " + row + ", " + col + " tipa: " + value.getClass());
		this.studenti.get(row).setCell(value, col);
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		if (col == 0)
			return false;
		return true;
	}
	
	
	
	
	
	public void obrisiStudenta(int row) {
		this.studenti.remove(row);
		fireTableDataChanged();
	}

}
