package kss.gui.igraci;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import kss.manager.ManagerIgrac;
import kss.model.Igrac;

public class IgraciModel extends AbstractTableModel {

	private static final long serialVersionUID = 6579243965615046676L;
	
	private ManagerIgrac mi;
	private String[] kolone = {"Id igraca", "Ime", "Prezime", "Klub"};
	private List<Igrac> igraci;
	
	public IgraciModel(ManagerIgrac mi) {
		this.mi = mi;
		this.igraci = mi.getIgraci();
	}
	
	@Override
	public int getRowCount() {
		return this.igraci.size();
	}

	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Igrac ig = this.igraci.get(rowIndex);
		return ig.toCell(columnIndex);
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
		Igrac ig = this.igraci.get(row);
		ig.setCell(value, col);
	}

	
}
