package vezbe9.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import vezbe4.primer5.Student;

public class StudentModel extends AbstractTableModel{


	private static final long serialVersionUID = -4125561086495154899L;

	private String [] columnNames = { "Ime", "Indeks", "Grad"};
	
	private List<Student> data = new ArrayList<Student>();
	
	public StudentModel(Map<Integer, Student> studenti) {
		for(Student s : studenti.values()) 
			data.add(s);
	}
	
	
	
	@Override
	public int getRowCount() {
		return this.data.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return this.columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student i = data.get(rowIndex);
		switch (columnIndex) {
		
		case 0:
			return i.getIme();
		case 1:
			return i.getIndeks();
		case 2:
			return i.getGrad();
		default:
			return null;
		}
	}
	
	

}
