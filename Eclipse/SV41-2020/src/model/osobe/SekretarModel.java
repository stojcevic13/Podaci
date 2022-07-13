package model.osobe;

import java.util.List;

import javax.swing.table.AbstractTableModel;

//import entiteti.osobe.Predavac;
import entiteti.osobe.Sekretar;

public class SekretarModel extends AbstractTableModel {
	
	private static final long serialVersionUID = -1726723567446301585L;
	
	private String[] kolone = {"Id sekretara", "Ime", "Prezime", "Pol", "Datum rođenja", "Telefon", "Adresa", "Stručna sprema",
			"Godina staža", "Plata", "Obrađeni zahtjevi"};
	private List<Sekretar> sekretari;
	
	public SekretarModel(List<Sekretar> sekretari) {
		this.sekretari = sekretari;
	}
	
	@Override
	public int getRowCount() {
		return this.sekretari.size();
	}
	
	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Sekretar sekretar = this.sekretari.get(rowIndex);
		return sekretar.toCell(columnIndex);
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
		Sekretar sekretar = this.sekretari.get(row);
		sekretar.setCell(value, col);
	}
}
