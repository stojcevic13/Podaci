package komponente.primer11kompletnatabela;

import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MyIntegerEditor extends DefaultCellEditor {

	private static final long serialVersionUID = -3626615119087636112L;

	private int minimum, maximum;
	
	public MyIntegerEditor(int min, int max) {
		// pozvacemo konstruktor nadklase sa JTextField komponentom kao editorom
		// celije
		super(new JTextField());
		minimum = min;
		maximum = max;
	}
	
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		JTextField tf = (JTextField) super.getTableCellEditorComponent(table, value, isSelected, row, column);
		tf.setText(value.toString());
		return tf;
	}
	
	public Object getCellEditorValue() {
		JTextField tf = (JTextField) getComponent();
		String s = tf.getText();
//		if ( ispravan(s) ) {
			return new Integer(s);
//		}
//		else {
//			// ovo ne bi trebalo nikada da se desi zato sto smo se obezbedili od
//			// ovoga
//			// metodom stopCellEditing()
//			System.err.println("getCellEditorValue: neispravna vrednost: " + s);
//			return null;
//		}
	}
	
	
	public boolean stopCellEditing() {
		JTextField tf = (JTextField) getComponent();
		if ( !ispravan(tf.getText()) ) {
			greska(tf);
			return false; // ne dozvoljavamo prihvat vrednosti i idemo nazad u
							// editor
		}
		return super.stopCellEditing();
	}
	
	
	private boolean ispravan(String s) {
		try {
			int i = Integer.parseInt(s);
			if ( i < minimum || i > maximum )
				throw new Exception("Nedozvoljena vrednost celije.");
		}
		catch (Exception ex) {
			return false;
		}
		return true;
	}

	private void greska(JTextField tf) {
		Toolkit.getDefaultToolkit().beep();
		tf.selectAll();
		JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(tf),
				"Vrednost ovog polja mo\u017ee da bude samo celobrojna vrednost izme\u0111u  " + minimum + " i " + maximum, "Greska",
				JOptionPane.ERROR_MESSAGE);
	}

	
	
}
