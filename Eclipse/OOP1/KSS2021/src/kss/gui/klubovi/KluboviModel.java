package kss.gui.klubovi;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import kss.manager.ManagerKlub;
import kss.model.Klub;

public class KluboviModel extends AbstractTableModel {

	private static final long serialVersionUID = -6154378038678806475L;
	
	private ManagerKlub mk;
	private String[] kolone = {"Id kluba", "Naziv"};
	private List<Klub> klubovi;
	
	
	public KluboviModel(ManagerKlub mk) {
		this.mk = mk;
		this.klubovi = mk.getKlubovi();
	}
	
	@Override
	public int getRowCount() {
		return this.klubovi.size();
	}

	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Klub k = this.klubovi.get(rowIndex);
		return k.toCell(columnIndex);
	}
	
	@Override
	public String getColumnName(int col) {
		return this.kolone[col];
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		if (col == 0)
			return false;
		return true;
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		Klub k = this.klubovi.get(row);
		k.setCell(value, col);
	}

	
}
