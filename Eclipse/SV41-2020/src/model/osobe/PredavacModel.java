package model.osobe;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entiteti.osobe.Predavac;

public class PredavacModel extends AbstractTableModel {
	
	private static final long serialVersionUID = -4553510742678556770L;
	
	private String[] kolone = {"Id predavača", "Ime", "Prezime", "Pol", "Datum rođenja", "Telefon", "Adresa", "Stručna sprema",
			"Godina staža", "Plata", "Obučeni jezici", "Kursevi"};
	private List<Predavac> predavaci;
	
	public PredavacModel(List<Predavac> predavaci) {
		this.predavaci = predavaci;
	}
	
	@Override
	public int getRowCount() {
		return this.predavaci.size();
	}
	
	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Predavac predavac = this.predavaci.get(rowIndex);
		return predavac.toCell(columnIndex);
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
		Predavac predavac = this.predavaci.get(row);
		predavac.setCell(value, col);
	}

}
