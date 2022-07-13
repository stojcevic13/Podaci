package komponente.primer14do17;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class TestJOptionPane {

	public TestJOptionPane() {
		//JOptionPane.showMessageDialog(null, "Pokrenuli ste program.");
		//JOptionPane.showMessageDialog(null, "Pokrenuli ste program2", "Iskacuca poruka", 1);
		
//		int odg = JOptionPane.showConfirmDialog(null, "Odaberite jednu od opcija", "Naslov", JOptionPane.YES_NO_CANCEL_OPTION);
//		String s = (odg == JOptionPane.YES_OPTION) ? "Yes" : "No";
//		JOptionPane.showMessageDialog(null, "Odabrali ste " + s + " opciju.", "Obavjestenje", 1);

		//String s = JOptionPane.showInputDialog("Unesite nesto:");
//		String s = JOptionPane.showInputDialog(null, "Unesite neki tekst:", "Proba input dijaloga", JOptionPane.QUESTION_MESSAGE); 
//		JOptionPane.showMessageDialog(null, "Unijeli ste: " + s, "Obavjestenje", 1);
		
//		UIManager.put("OptionPane.yesButtonText", "Да");
//		UIManager.put("OptionPane.noButtonText", "Не");
//		UIManager.put("OptionPane.cancelButtonText", "Откажи");
//		UIManager.put("OptionPane.okButtonText", "У реду");
//		JOptionPane.showConfirmDialog(null, "Да ли сте сигурни да мислите?", "Питање", JOptionPane.YES_NO_CANCEL_OPTION);
		
	}
	
	
	public static void main(String[] args) {
		new TestJOptionPane();
	}

}
