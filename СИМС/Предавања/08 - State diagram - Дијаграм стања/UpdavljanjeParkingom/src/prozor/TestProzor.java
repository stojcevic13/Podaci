package prozor;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import automat.KontrolerParkinga;


/**
 * Testni prozor koji omogucava isprobavanje rada kontrolera parkinga 
 */
public class TestProzor extends JDialog {	
	private JButton btnUsaoAutomobil;
	private JButton btnIzasaoAutomobil;
	private KontrolerParkinga kontrolerParkinga;	
	
	public TestProzor(KontrolerParkinga kontrolerParkinga) {
		this.kontrolerParkinga = kontrolerParkinga;		
		
		setTitle("Test prozor za kontroler parkinga");		
		setSize(300, 400);		
		setLayout(new GridLayout(2, 2));		
		kreirajPanele();
		kreirajDugmad();
	}
	
	/**	
	 * Kreiranje panela za prikaz semafora i raspolozivih mesta  
	 */
	private void kreirajPanele() {
		SemaforPanel pnlSemafor = new SemaforPanel();
		add(pnlSemafor);
		
		BrojMestaPanel pnlBrojMesta = new BrojMestaPanel();
		add(pnlBrojMesta);
		
		//paneli se registruju za pracenje dogadjaja o promeni podataka u kontroleru parkinga 
		kontrolerParkinga.addObserver(pnlBrojMesta);
		kontrolerParkinga.addObserver(pnlSemafor);
	}
	
	/**	
	 * Kreiranje dugmadi koja simuliraju ulaske i izlaske automobila  
	 */
	private void kreirajDugmad() {		
		JPanel btnPanel = new JPanel();
		btnUsaoAutomobil = new JButton();
		btnUsaoAutomobil.setText("Ulaz automobila");
		btnUsaoAutomobil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kontrolerParkinga.usaoAutomobil();
			}
		});		
		btnPanel.add(btnUsaoAutomobil);
		
		btnIzasaoAutomobil = new JButton();
		btnIzasaoAutomobil.setText("Izlaz automobila");		
		btnIzasaoAutomobil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kontrolerParkinga.izasaoAutomobil();
			}
		});				
		btnPanel.add(btnIzasaoAutomobil);
		add(btnPanel);
	}	
}
