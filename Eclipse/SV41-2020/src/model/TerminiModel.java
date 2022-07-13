package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entiteti.TerminTesta;


public class TerminiModel extends AbstractTableModel {
	
	private static final long serialVersionUID = -4650957648017800536L;
	
	private String[] kolone = {"Id termina", "Datum", "Test", "Kurs"};
	private List<TerminTesta> termini;
	
	public TerminiModel(List<TerminTesta> termini) {
		this.termini = termini;
	}
	
	@Override
	public int getRowCount() {
		return this.termini.size();
	}

	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TerminTesta t = this.termini.get(rowIndex);
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
