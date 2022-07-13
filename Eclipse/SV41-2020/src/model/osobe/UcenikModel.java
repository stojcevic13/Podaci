package model.osobe;

import java.util.List;

import javax.swing.table.AbstractTableModel;

//import entiteti.Kurs;
import entiteti.osobe.Ucenik;

public class UcenikModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 8131509882819298249L;
	
	private String[] kolone = {"Id učenika", "Ime", "Prezime", "Pol", "Datum rođenja", "Telefon", "Adresa", "Ukupno uplaćeno"};
	private List<Ucenik> ucenici;
	
	public UcenikModel(List<Ucenik> ucenici) {
		this.ucenici = ucenici;
	}
	
	@Override
	public int getRowCount() {
		return this.ucenici.size();
	}

	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Ucenik ucenik = this.ucenici.get(rowIndex);
		return ucenik.toCell(columnIndex);
	}
	
	@Override
	public String getColumnName(int col) {
		return this.kolone[col];
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		Ucenik ucenik = this.ucenici.get(row);
		ucenik.setCell(value, col);
	}

}
