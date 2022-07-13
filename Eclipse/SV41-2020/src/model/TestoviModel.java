package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entiteti.Test;


public class TestoviModel extends AbstractTableModel {
	
	private static final long serialVersionUID = -7673511159928982032L;
	
	private String[] kolone = {"Id testa", "Opis", "Jezik", "Broj pitanja", "Maksimalno bodova", "Kreator"};
	private List<Test> testovi;
	
	public TestoviModel(List<Test> testovi) {
		this.testovi = testovi;
	}
	
	@Override
	public int getRowCount() {
		return this.testovi.size();
	}

	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Test t = this.testovi.get(rowIndex);
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
