package forme;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entiteti.Kurs;
import entiteti.TerminTesta;
import entiteti.Test;
import entiteti.osobe.Predavac;
import main.Podaci;

public class KreiranjeTerminaDlg extends JDialog {

	private static final long serialVersionUID = 2767670046497621634L;
	
	private JTextField txtDatumVrijeme;
	private JComboBox<Kurs> comboBoxKursevi;
	private JComboBox<Test> comboBoxTestovi;
	
	private Kurs odabraniKurs;
	private Test odabraniTest;
	private LocalDateTime datumVrijeme;
	
	public KreiranjeTerminaDlg(JFrame parent, Predavac kreator, List<TerminTesta> termini) {
		
		super(parent, "Podaci o terminu", true);
		
		setSize(400, 300);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblOdaberiKurs = new JLabel("Odaberite Kurs: ");
		GridBagConstraints gbc_lblOdaberiKurs = new GridBagConstraints();
		gbc_lblOdaberiKurs.gridwidth = 2;
		gbc_lblOdaberiKurs.insets = new Insets(10, 0, 5, 0);
		gbc_lblOdaberiKurs.gridx = 0;
		gbc_lblOdaberiKurs.gridy = 0;
		panel.add(lblOdaberiKurs, gbc_lblOdaberiKurs);
		
		comboBoxKursevi = new JComboBox<Kurs>();
		for (Kurs kurs : kreator.getKursevi())
			comboBoxKursevi.addItem(kurs);
		comboBoxKursevi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				odabraniKurs = (Kurs) comboBoxKursevi.getSelectedItem();
				comboBoxTestovi.setEnabled(true);
				
				comboBoxTestovi.removeAllItems();
				for (Test test : odabraniKurs.getTestovi())
					comboBoxTestovi.addItem(test);
			}
		});
		GridBagConstraints gbc_comboBoxKursevi = new GridBagConstraints();
		gbc_comboBoxKursevi.gridwidth = 2;
		gbc_comboBoxKursevi.insets = new Insets(0, 10, 5, 10);
		gbc_comboBoxKursevi.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxKursevi.gridx = 0;
		gbc_comboBoxKursevi.gridy = 1;
		panel.add(comboBoxKursevi, gbc_comboBoxKursevi);
		
		JLabel lblOdaberiTest = new JLabel("Odaberite test:");
		GridBagConstraints gbc_lblOdaberiTest = new GridBagConstraints();
		gbc_lblOdaberiTest.gridwidth = 2;
		gbc_lblOdaberiTest.insets = new Insets(15, 0, 5, 0);
		gbc_lblOdaberiTest.gridx = 0;
		gbc_lblOdaberiTest.gridy = 2;
		panel.add(lblOdaberiTest, gbc_lblOdaberiTest);
		
		comboBoxTestovi = new JComboBox<Test>();
		comboBoxTestovi.setEnabled(false);
		comboBoxTestovi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				odabraniTest = (Test) comboBoxTestovi.getSelectedItem();	
			}
		});
		GridBagConstraints gbc_comboBoxTestovi = new GridBagConstraints();
		gbc_comboBoxTestovi.gridwidth = 2;
		gbc_comboBoxTestovi.insets = new Insets(0, 10, 25, 10);
		gbc_comboBoxTestovi.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTestovi.gridx = 0;
		gbc_comboBoxTestovi.gridy = 3;
		panel.add(comboBoxTestovi, gbc_comboBoxTestovi);
		
		JLabel lblDatum = new JLabel("Datum i vrijeme: ");
		GridBagConstraints gbc_lblDatum = new GridBagConstraints();
		gbc_lblDatum.anchor = GridBagConstraints.WEST;
		gbc_lblDatum.insets = new Insets(0, 10, 0, 5);
		gbc_lblDatum.gridx = 0;
		gbc_lblDatum.gridy = 4;
		panel.add(lblDatum, gbc_lblDatum);
		
		txtDatumVrijeme = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 10);
		gbc_textField.weightx = 10.0;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 4;
		panel.add(txtDatumVrijeme, gbc_textField);
		txtDatumVrijeme.setColumns(10);
		
		
		JPanel dugmad = new JPanel();
		JButton btnSnimi = new JButton("Snimi");
		btnSnimi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!ispravanDatumVrijeme())
					JOptionPane.showMessageDialog(null, "Unesite datum i vrijeme u formatu: dd.MM.yyyy - HH:mm", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
				else if (JOptionPane.showConfirmDialog(null, "Da li želite da zakažete termin?", "Potvrda zakazivanja",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
					TerminTesta noviTermin = new TerminTesta(odabraniKurs, odabraniTest, datumVrijeme);
					noviTermin.setId(String.format("%04d", Podaci.getPodaci().getTerminTestaManager().getTermini().size() ));
					
					kreator.getTermini().add(noviTermin);
					noviTermin.setPredavac(kreator);
					
					odabraniTest.getTermini().add(noviTermin);
					odabraniKurs.getDostupniTermini().add(noviTermin);
					termini.add(noviTermin);
					
					Podaci.getPodaci().getTerminTestaManager().getTermini().add(noviTermin);
					Podaci.getPodaci().getTerminTestaManager().getMapTermini().put(noviTermin.getId(), noviTermin);
				}
			}
		});
		dugmad.add(btnSnimi);
		
		JButton btnOdustani = new JButton("Izlaz");
		btnOdustani.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnOdustani);
		
		getContentPane().add(dugmad, BorderLayout.SOUTH);
	}

	protected boolean ispravanDatumVrijeme() {
		try {
			datumVrijeme = LocalDateTime.parse(txtDatumVrijeme.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm"));
			if (datumVrijeme.toLocalDate().isBefore(LocalDate.now()))
				return false;
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

}
