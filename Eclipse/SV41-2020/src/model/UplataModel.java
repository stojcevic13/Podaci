package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

//import entiteti.Test;
import entiteti.Uplata;
import entiteti.osobe.Ucenik;

public class UplataModel extends AbstractTableModel {
	
	private static final long serialVersionUID = -300819115482676767L;
	
	private String[] kolone = {"Id uplate", "Kurs", "Datum uplate", "Iznos"};
	private List<Uplata> uplate;
	
	public UplataModel(Ucenik uc) {
		this.uplate = uc.getUplate();
	}
	
	@Override
	public int getRowCount() {
		return this.uplate.size();
	}

	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Uplata u = this.uplate.get(rowIndex);
		return u.toCell(columnIndex);
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
