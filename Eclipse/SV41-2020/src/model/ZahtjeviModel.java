package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entiteti.Zahtjev;

public class ZahtjeviModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 9044275057705470156L;
	
	private String[] kolone = {"Id zahtjeva", "Ucenik", "Kurs", "Datum slanja"};
	private List<Zahtjev> zahtjevi;
	
	public ZahtjeviModel(List<Zahtjev> zahtjevi) {
		this.zahtjevi = zahtjevi;
	}
	
	@Override
	public int getRowCount() {
		return this.zahtjevi.size();
	}

	@Override
	public int getColumnCount() {
		return this.kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Zahtjev zahtjev = this.zahtjevi.get(rowIndex);
		return zahtjev.toCell(columnIndex);
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
