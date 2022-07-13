package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entiteti.PojedinacanTest;

public class PojedinacanTestModel extends AbstractTableModel {
	
	private static final long serialVersionUID = -7946622110028297650L;
	
	private String[] kolone = {"Id", "Test", "Ucenik", "Kurs", "Termin"};
	private List<PojedinacanTest> pojedinacniTestovi;
	
	public PojedinacanTestModel(List<PojedinacanTest> pojedinacniTestovi) {
		this.pojedinacniTestovi = pojedinacniTestovi;
	}
	
	@Override
	public int getRowCount() {
		return this.pojedinacniTestovi.size();
	}

	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		PojedinacanTest pojedinacanTest = this.pojedinacniTestovi.get(rowIndex);
		return pojedinacanTest.toCell(columnIndex);
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
