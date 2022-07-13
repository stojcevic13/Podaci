package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entiteti.Jezik;

public class JezikModel extends AbstractTableModel {

	private static final long serialVersionUID = -6764791668584972413L;
	
	private String[] kolone = {"Jezik", "Broj kurseva", "Broj predavača", "Broj testova"};
	private List<Jezik> jezici;
	
	public JezikModel(List<Jezik> kursevi) {
		this.jezici = kursevi;
	}
	
	@Override
	public int getRowCount() {
		return this.jezici.size();
	}

	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Jezik k = this.jezici.get(rowIndex);
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
