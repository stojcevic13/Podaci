package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entiteti.RezultatTesta;
//import entiteti.TerminTesta;
//import entiteti.osobe.Ucenik;

public class RezultatiModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 3630756770919075390L;
	
	private String[] kolone = {"Id rezultata", "Kurs", "Test", "Učenik", "Osvojeno bodova", "Maksimalno bodova", "Ocjena"};
	private List<RezultatTesta> rezultati;
	
	public RezultatiModel(List<RezultatTesta> rezultati) {
		this.rezultati = rezultati;
	}
	
	@Override
	public int getRowCount() {
		return this.rezultati.size();
	}

	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		RezultatTesta t = this.rezultati.get(rowIndex);
		return t.toCell(columnIndex);
	}
	
	@Override
	public String getColumnName(int col) {
		return this.kolone[col];
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	


}
