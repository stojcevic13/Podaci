package forme;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entiteti.Kurs;
import entiteti.Zahtjev;
import entiteti.Zahtjev.Stanje;
import entiteti.osobe.Sekretar;
import entiteti.osobe.Ucenik;
import forme.registracija.RegistracijaUcenikaDlg;
import main.Podaci;


public class KreiranjeZahtjevaDlg extends JDialog {

	private static final long serialVersionUID = 506180504086335695L;
	
	private RegistracijaUcenikaDlg registracijaUcenikaDlg;
	
	private List<Ucenik> ucenici = Podaci.getPodaci().getUcenikManager().getUcenici();
	private List<Kurs> kursevi = Podaci.getPodaci().getKursManager().getKursevi();
	
	private Ucenik odabraniUcenik;
	private Kurs odabraniKurs;
	
	private JButton btnRegistracija;
	private JComboBox<Kurs> comboBoxKurs;
	private JComboBox<Ucenik> comboBoxUcenik;
	private JButton btnPotvrdi;
	private JButton btnIzlaz;
	
	
	public KreiranjeZahtjevaDlg(JFrame parent) {
		super(parent, "Kreiranje Zahtjeva", true);
		
		registracijaUcenikaDlg = new RegistracijaUcenikaDlg(KreiranjeZahtjevaDlg.this);
		setSize(400, 250);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblOdaberiteUcenika = new JLabel("Odaberite učenika:");
		GridBagConstraints gbc_lblOdaberiteUcenika = new GridBagConstraints();
		gbc_lblOdaberiteUcenika.weightx = 0.5;
		gbc_lblOdaberiteUcenika.insets = new Insets(10, 0, 5, 0);
		gbc_lblOdaberiteUcenika.gridx = 0;
		gbc_lblOdaberiteUcenika.gridy = 0;
		panel.add(lblOdaberiteUcenika, gbc_lblOdaberiteUcenika);
		
		comboBoxUcenik = new JComboBox<Ucenik>();
		for (Ucenik uc : ucenici)
			comboBoxUcenik.addItem(uc);
		GridBagConstraints gbc_comboBoxUcenik = new GridBagConstraints();
		gbc_comboBoxUcenik.insets = new Insets(0, 10, 5, 10);
		gbc_comboBoxUcenik.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxUcenik.gridx = 0;
		gbc_comboBoxUcenik.gridy = 1;
		panel.add(comboBoxUcenik, gbc_comboBoxUcenik);
		comboBoxUcenik.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				odabraniUcenik = (Ucenik) comboBoxUcenik.getSelectedItem();
				
				comboBoxKurs.setEnabled(true);
				comboBoxKurs.removeAllItems();
				for (Kurs kurs : kursevi)
					if ( (!odabraniUcenik.getPolozeniKursevi().contains(kurs))  &&  (!odabraniUcenik.getNepolozeniKursevi().contains(kurs)) 
							&&  (!kreiranZahtjev(kurs)) )
						comboBoxKurs.addItem(kurs);
			}

			private boolean kreiranZahtjev(Kurs kurs) {
				for (Zahtjev zahtjev : Sekretar.getNeobradjeniZahtjevi())
					if (zahtjev.getKurs() == kurs  &&  zahtjev.getUcenik() == odabraniUcenik)
						return true;
				return false;
			}
		});
		
		btnRegistracija = new JButton("Registracija");
		GridBagConstraints gbc_btnRegistracija = new GridBagConstraints();
		gbc_btnRegistracija.insets = new Insets(5, 0, 5, 0);
		gbc_btnRegistracija.gridx = 0;
		gbc_btnRegistracija.gridy = 2;
		panel.add(btnRegistracija, gbc_btnRegistracija);
		btnRegistracija.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				registracijaUcenikaDlg.setVisible(true);
				if (registracijaUcenikaDlg.getUcenik() != null)
					comboBoxUcenik.setSelectedItem(registracijaUcenikaDlg.getUcenik());
			}
		});
		
		JLabel lblOdaberiKurs = new JLabel("Odaberite kurs: ");
		GridBagConstraints gbc_lblOdaberiKurs = new GridBagConstraints();
		gbc_lblOdaberiKurs.weightx = 0.5;
		gbc_lblOdaberiKurs.insets = new Insets(30, 0, 5, 0);
		gbc_lblOdaberiKurs.gridx = 0;
		gbc_lblOdaberiKurs.gridy = 3;
		panel.add(lblOdaberiKurs, gbc_lblOdaberiKurs);
		
		comboBoxKurs = new JComboBox<Kurs>();
		comboBoxKurs.setEnabled(false);
		GridBagConstraints gbc_comboBoxKurs = new GridBagConstraints();
		gbc_comboBoxKurs.insets = new Insets(0, 10, 0, 10);
		gbc_comboBoxKurs.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxKurs.gridx = 0;
		gbc_comboBoxKurs.gridy = 4;
		panel.add(comboBoxKurs, gbc_comboBoxKurs);
		comboBoxKurs.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				odabraniKurs = (Kurs) comboBoxKurs.getSelectedItem();
			}
		});
		
		
		JPanel dugmad = new JPanel();
		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if ( (odabraniUcenik != null) && (odabraniKurs != null) ) {
					Zahtjev zahtjev = new Zahtjev(odabraniUcenik, odabraniKurs, Stanje.U_OBRADI, LocalDate.now());
					Sekretar.getNeobradjeniZahtjevi().add(zahtjev);
					Podaci.getPodaci().getZahtjevManager().getZahtjevi().add(zahtjev);
					Podaci.getPodaci().getZahtjevManager().getMapZahtjevi().put(zahtjev.getId(), zahtjev);
					Podaci.getPodaci().getZahtjevManager().getNeobradjeniZahtjevi().add(zahtjev);
					
					JOptionPane.showMessageDialog(null, "Zahtjev je uspješno kreiran", "Uspješno kreiran zahtjev", JOptionPane.PLAIN_MESSAGE);
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
