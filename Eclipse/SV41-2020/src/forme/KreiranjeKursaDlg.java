package forme;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entiteti.CijenaKursa;
import entiteti.Cjenovnik;
import entiteti.Jezik;
import entiteti.Kurs;
import entiteti.Kurs.Nivo;
import entiteti.osobe.Predavac;
//import view.SekretarMainFrame.PostaviPredavacaNaKurs;
import main.Podaci;

public class KreiranjeKursaDlg extends JDialog {

	private static final long serialVersionUID = -1347759958541228106L;
	private JTextField txtOsnovnaCijena;
	private JTextField txtCijenaPolaganja;
	private JComboBox<Jezik> comboBoxJezik;
	private JComboBox<Nivo> comboBoxNivo;
	private JComboBox<Predavac> comboBoxPredavac;
	
	private JButton btnSnimi;
	private JButton btnIzlaz;
	
	private JPanel dugmad;

	private Kurs noviKurs;
	
	private Jezik odabraniJezik;
	private Nivo odabraniNivo;
	private Predavac odabraniPredavac;
	private double osnovnaCijena;
	private double cijenaPolaganja;
	
	public KreiranjeKursaDlg(JFrame parent) {
		super(parent, "Podaci o kursu", true);
		setSize(450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{103, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblJezik = new JLabel("Jezik: ");
		GridBagConstraints gbc_lblJezik = new GridBagConstraints();
		gbc_lblJezik.insets = new Insets(10, 10, 5, 5);
		gbc_lblJezik.anchor = GridBagConstraints.WEST;
		gbc_lblJezik.gridx = 0;
		gbc_lblJezik.gridy = 0;
		panel.add(lblJezik, gbc_lblJezik);
		
		comboBoxJezik = new JComboBox<Jezik>();
		for (Jezik jezik : Podaci.getPodaci().getJezikManager().getJezici())
			comboBoxJezik.addItem(jezik);
		GridBagConstraints gbc_comboBoxJezik = new GridBagConstraints();
		gbc_comboBoxJezik.insets = new Insets(10, 0, 5, 10);
		gbc_comboBoxJezik.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxJezik.gridx = 1;
		gbc_comboBoxJezik.gridy = 0;
		panel.add(comboBoxJezik, gbc_comboBoxJezik);
		comboBoxJezik.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				odabraniJezik = (Jezik) comboBoxJezik.getSelectedItem();
				comboBoxPredavac.setEnabled(true);
				comboBoxPredavac.removeAllItems();
				for (Predavac predavac : Podaci.getPodaci().getPredavacManager().getPredavaci())
					if (predavac.getObuceniJezici().contains(odabraniJezik))
						comboBoxPredavac.addItem(predavac);
			}
		});
		
		JLabel lblNivo = new JLabel("Nivo: ");
		GridBagConstraints gbc_lblNivo = new GridBagConstraints();
		gbc_lblNivo.anchor = GridBagConstraints.WEST;
		gbc_lblNivo.insets = new Insets(0, 10, 5, 5);
		gbc_lblNivo.gridx = 0;
		gbc_lblNivo.gridy = 1;
		panel.add(lblNivo, gbc_lblNivo);
		
		comboBoxNivo = new JComboBox<Nivo>();
		comboBoxNivo.addItem(Nivo.a1);
		comboBoxNivo.addItem(Nivo.a2);
		comboBoxNivo.addItem(Nivo.a3);
		GridBagConstraints gbc_comboBoxNivo = new GridBagConstraints();
		gbc_comboBoxNivo.insets = new Insets(0, 0, 5, 10);
		gbc_comboBoxNivo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxNivo.gridx = 1;
		gbc_comboBoxNivo.gridy = 1;
		panel.add(comboBoxNivo, gbc_comboBoxNivo);
		
		JLabel lblPredavac = new JLabel("Predavač: ");
		GridBagConstraints gbc_lblPredavac = new GridBagConstraints();
		gbc_lblPredavac.anchor = GridBagConstraints.WEST;
		gbc_lblPredavac.insets = new Insets(0, 10, 5, 5);
		gbc_lblPredavac.gridx = 0;
		gbc_lblPredavac.gridy = 2;
		panel.add(lblPredavac, gbc_lblPredavac);
		
		comboBoxPredavac = new JComboBox<Predavac>();
		comboBoxPredavac.setEnabled(false);
		GridBagConstraints gbc_comboBoxPredavac = new GridBagConstraints();
		gbc_comboBoxPredavac.insets = new Insets(0, 0, 5, 10);
		gbc_comboBoxPredavac.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPredavac.gridx = 1;
		gbc_comboBoxPredavac.gridy = 2;
		panel.add(comboBoxPredavac, gbc_comboBoxPredavac);
		
		JLabel lblOsnovnaCijena = new JLabel("Osnovna cijena: ");
		GridBagConstraints gbc_lblOsnovnaCijena = new GridBagConstraints();
		gbc_lblOsnovnaCijena.anchor = GridBagConstraints.WEST;
		gbc_lblOsnovnaCijena.insets = new Insets(0, 10, 5, 5);
		gbc_lblOsnovnaCijena.gridx = 0;
		gbc_lblOsnovnaCijena.gridy = 3;
		panel.add(lblOsnovnaCijena, gbc_lblOsnovnaCijena);
		
		txtOsnovnaCijena = new JTextField();
		GridBagConstraints gbc_txtOsnovnaCijena = new GridBagConstraints();
		gbc_txtOsnovnaCijena.insets = new Insets(0, 0, 5, 10);
		gbc_txtOsnovnaCijena.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOsnovnaCijena.gridx = 1;
		gbc_txtOsnovnaCijena.gridy = 3;
		panel.add(txtOsnovnaCijena, gbc_txtOsnovnaCijena);
		txtOsnovnaCijena.setColumns(10);
		
		JLabel lblCijenaPolaganja = new JLabel("Cijena Polaganja: ");
		GridBagConstraints gbc_lblCijenaPolaganja = new GridBagConstraints();
		gbc_lblCijenaPolaganja.anchor = GridBagConstraints.WEST;
		gbc_lblCijenaPolaganja.insets = new Insets(0, 10, 0, 5);
		gbc_lblCijenaPolaganja.gridx = 0;
		gbc_lblCijenaPolaganja.gridy = 4;
		panel.add(lblCijenaPolaganja, gbc_lblCijenaPolaganja);
		
		txtCijenaPolaganja = new JTextField();
		GridBagConstraints gbc_txtCijenaPolaganja = new GridBagConstraints();
		gbc_txtCijenaPolaganja.insets = new Insets(0, 0, 0, 10);
		gbc_txtCijenaPolaganja.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCijenaPolaganja.gridx = 1;
		gbc_txtCijenaPolaganja.gridy = 4;
		panel.add(txtCijenaPolaganja, gbc_txtCijenaPolaganja);
		txtCijenaPolaganja.setColumns(10);
		
		
		
		dugmad = new JPanel();
		btnSnimi = new JButton("Snimi");
		btnSnimi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ispravanUnos()) {
					noviKurs = new Kurs(odabraniJezik, odabraniNivo, odabraniPredavac);
					odabraniPredavac.getKursevi().add(noviKurs);
					odabraniJezik.getKursevi().add(noviKurs);
					Podaci.getPodaci().getKursManager().getKursevi().add(noviKurs);
					Podaci.getPodaci().getKursManager().getMapKursevi().put(noviKurs.getId(), noviKurs);
					
					Cjenovnik.setVaziOd(LocalDate.now());
					CijenaKursa cijenaKursa = new CijenaKursa(osnovnaCijena, cijenaPolaganja);
					cijenaKursa.setKurs(noviKurs);
					Podaci.getPodaci().getCijenaKursaManager().getCijeneKurseva().add(cijenaKursa);
					Podaci.getPodaci().getCijenaKursaManager().getMapCijeneKurseva().put(cijenaKursa.getKurs().getId(), cijenaKursa);
					Cjenovnik.getCijene().put(noviKurs, cijenaKursa);
						
					JOptionPane.showMessageDialog(null, "Kurs je uspješno napravljen", "Uspješno obavljen posao", JOptionPane.PLAIN_MESSAGE);
				}
			}

			private boolean ispravanUnos() {
				odabraniJezik = (Jezik) comboBoxJezik.getSelectedItem();
				odabraniNivo = (Nivo) comboBoxNivo.getSelectedItem();
				odabraniPredavac = (Predavac) comboBoxPredavac.getSelectedItem();
				if ( (odabraniJezik == null) || (odabraniNivo == null) || (odabraniPredavac == null) || 
						(txtOsnovnaCijena.getText().equals("")) || (txtCijenaPolaganja.getText().equals("")) ) {
					JOptionPane.showMessageDialog(null, "Niste unijeli sve podatke", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
					return false;
				}
				try {
					osnovnaCijena = Double.parseDouble(txtOsnovnaCijena.getText());
					cijenaPolaganja = Double.parseDouble(txtCijenaPolaganja.getText());
				} catch (NumberFormatException ee) {
					JOptionPane.showMessageDialog(null, "Cijena mora biti realan broj", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
					return false;
				}
					
				return true;
			}
		});
		dugmad.add(btnSnimi);
		
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
	
	
	
	
	
	
	
	public Kurs getNoviKurs() {
		return noviKurs;
	}

	public void setNoviKurs(Kurs noviKurs) {
		this.noviKurs = noviKurs;
	}




}
