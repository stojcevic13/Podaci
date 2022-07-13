package prozor;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import automat.KontrolerParkinga;
import automat.SvetloNaSemaforu;
import automat.event.UpdateEvent;
import automat.event.Observer;

/**
 * Panel koji prikazuje svetla na semaforu
 */
public class SemaforPanel extends JPanel implements Observer {	
	private JPanel crvenoSvetlo;
	private JPanel zelenoSvetlo;	
	
	public SemaforPanel() {
		setLayout(new GridLayout(2, 0));		
		crvenoSvetlo = new JPanel();				
		zelenoSvetlo = new JPanel();				
		add(crvenoSvetlo);
		add(zelenoSvetlo);				
		ukljuciZeleno();
	}
	
	/**	
	 * Reakcija na dogadjaj o promeni podataka u kontroleru parkinga 
	 */
	public void updatePerformed(UpdateEvent e) {
		if (e.getAktivnoSvetlo() == SvetloNaSemaforu.CRVENO) 
			ukljuciCrveno();		
		else 
			ukljuciZeleno();		
	}
	
	private void ukljuciZeleno() {
		zelenoSvetlo.setBackground(Color.green);		
		crvenoSvetlo.setBackground(Color.gray);	
	}
	
	private void ukljuciCrveno() {
		crvenoSvetlo.setBackground(Color.red);
		zelenoSvetlo.setBackground(Color.gray);
	}	
}
