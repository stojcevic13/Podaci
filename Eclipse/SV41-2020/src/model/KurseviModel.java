package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entiteti.Kurs;




public class KurseviModel extends AbstractTableModel {
	
	private static final long serialVersionUID = -6431378074866895097L;
	
	private String[] kolone = {"Id kursa", "Jezik", "Nivo", "Cijena", "Cijena dodatnog polaganja", "Predavač", "Broj učenika"};
	private List<Kurs> kursevi;
	
	public KurseviModel(List<Kurs> kursevi) {
		this.kursevi = kursevi;
	}
	
	@Override
	public int getRowCount() {
		return this.kursevi.size();
	}

	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Kurs k = this.kursevi.get(rowIndex);
		return k.toCell(columnIndex);
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
