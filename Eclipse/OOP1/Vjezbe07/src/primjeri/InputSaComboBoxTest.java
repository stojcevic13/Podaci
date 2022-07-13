package primjeri;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InputSaComboBoxTest extends JFrame {

	private static final long serialVersionUID = 4844201023198456170L;

	public InputSaComboBoxTest() {
		String s = (String) JOptionPane.showInputDialog(null, "Odaberite omiljenu marku automobila:", "Naslov", JOptionPane.PLAIN_MESSAGE, null,
				new Object[] { "Audi", "Mercedes", "BMW"}, "Audi");
		JOptionPane.showMessageDialog(null, "Odabrali ste: " + s, "Naslov", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void main(String[] args) {
		new InputSaComboBoxTest();
	}

}
