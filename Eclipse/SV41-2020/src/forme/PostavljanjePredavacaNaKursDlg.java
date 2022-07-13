package forme;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entiteti.Kurs;
//import entiteti.Zahtjev;
//import entiteti.Zahtjev.Stanje;
import entiteti.osobe.Predavac;
//import entiteti.osobe.Sekretar;
//import entiteti.osobe.Ucenik;
import main.Podaci;

public class PostavljanjePredavacaNaKursDlg extends JDialog {

	private static final long serialVersionUID = 3783084500212719392L;
	
	private List<Predavac> predavaci = Podaci.getPodaci().getPredavacManager().getPredavaci();
	private List<Kurs> kursevi = Podaci.getPodaci().getKursManager().getKursevi();
	
	private Kurs odabraniKurs;
	private Predavac odabraniPredavac;

	private JComboBox<Kurs> comboBoxKursevi;
	private JComboBox<Predavac> comboBoxPredavaci;
	
	private JButton btnPotvrdi;
	private JButton btnIzlaz;
	
	
	public PostavljanjePredavacaNaKursDlg(JFrame parent) {
		super(parent, "Postavljanje predavača na kurs", true);
		setSize(450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblOdaberiKurs = new JLabel("Odaberite kurs: ");
		GridBagConstraints gbc_lblOdaberiKurs = new GridBagConstraints();
		gbc_lblOdaberiKurs.insets = new Insets(10, 0, 5, 0);
		gbc_lblOdaberiKurs.gridx = 0;
		gbc_lblOdaberiKurs.gridy = 0;
		panel.add(lblOdaberiKurs, gbc_lblOdaberiKurs);
		
		comboBoxKursevi = new JComboBox<Kurs>();
		for (Kurs kurs : kursevi)
			if (kurs.isAktivan())
				comboBoxKursevi.addItem(kurs);
		GridBagConstraints gbc_comboBoxKursevi = new GridBagConstraints();
		gbc_comboBoxKursevi.insets = new Insets(0, 10, 15, 10);
		gbc_comboBoxKursevi.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxKursevi.gridx = 0;
		gbc_comboBoxKursevi.gridy = 1;
		panel.add(comboBoxKursevi, gbc_comboBoxKursevi);
		comboBoxKursevi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				odabraniKurs = (Kurs) comboBoxKursevi.getSelectedItem();
				
				comboBoxPredavaci.setEnabled(true);
				comboBoxPredavaci.removeAllItems();
				for (Predavac predavac : predavaci)
					if ( predavac.getObuceniJezici().contains(odabraniKurs.getJezik()) )
						comboBoxPredavaci.addItem(predavac);
				comboBoxPredavaci.setSelectedItem(odabraniKurs.getPredavac());
			}
		});
		
		JLabel lblOdaberiPredavaca = new JLabel("Odaberite Predavača: ");
		GridBagConstraints gbc_lblOdaberiPredavaca = new GridBagConstraints();
		gbc_lblOdaberiPredavaca.insets = new Insets(0, 0, 5, 0);
		gbc_lblOdaberiPredavaca.gridx = 0;
		gbc_lblOdaberiPredavaca.gridy = 2;
		panel.add(lblOdaberiPredavaca, gbc_lblOdaberiPredavaca);
		
		comboBoxPredavaci = new JComboBox<Predavac>();
		comboBoxPredavaci.setEnabled(false);
		GridBagConstraints gbc_comboBoxPredavaci = new GridBagConstraints();
		gbc_comboBoxPredavaci.insets = new Insets(0, 10, 0, 10);
		gbc_comboBoxPredavaci.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPredavaci.gridx = 0;
		gbc_comboBoxPredavaci.gridy = 3;
		panel.add(comboBoxPredavaci, gbc_comboBoxPredavaci);
		comboBoxPredavaci.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				odabraniPredavac = (Predavac) comboBoxPredavaci.getSelectedItem();
			}
		});
		
		
		
		
		
		JPanel dugmad = new JPanel();
		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if ( (odabraniKurs != null) && (odabraniPredavac != null)) {
					odabraniKurs.getPredavac().getKursevi().remove(odabraniKurs);
					odabraniPredavac.getKursevi().add(odabraniKurs);
					odabraniKurs.setPredavac(odabraniPredavac);
					
					JOptionPane.showMessageDialog(null, "Uspješno ste postavili predavača", "Uspješno odrađen posao", JOptionPane.PLAIN_MESSAGE);
				} else
					JOptionPane.showMessageDialog(null, "Niste unijeli sve podatke", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
			}
		});
		dugmad.add(btnPotvrdi);
		
		btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnIzlaz);
		
		getContentPane().add(dugmad, BorderLayout.SOUTH);
	}
	
	
	

}
