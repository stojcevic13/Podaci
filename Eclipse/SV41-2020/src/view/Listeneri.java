package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import main.Podaci;

public class Listeneri {

	public static class Izlaz extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			int odg = JOptionPane.showConfirmDialog(null, "Da li ste želite da izađete?", "Izlaz",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (odg == JOptionPane.YES_OPTION) {
				Podaci.getPodaci().saveDataPodaci();
				System.exit(0);
			}
		}
	}
	
	
	
	
	
}
