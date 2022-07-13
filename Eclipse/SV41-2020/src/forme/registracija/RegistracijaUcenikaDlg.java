package forme.registracija;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import entiteti.osobe.Osoba.Pol;
import main.Podaci;
import manager.osobe.KorisnikManager;
//import entiteti.Jezik;
import entiteti.osobe.Ucenik;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
//import java.util.ArrayList;
//import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
//import javax.swing.JCheckBox;

public class RegistracijaUcenikaDlg extends JDialog {

	private static final long serialVersionUID = -809964420943040865L;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JComboBox<Pol> comboBoxPol;
	private JTextField txtDatum;
	private JTextField txtTelefon;
	private JTextField txtAdresa;
	private JTextField txtKorisnickoIme;
	private JTextField txtLozinka;
	private JButton btnSnimi;
	private JButton btnIzlaz;
	
	private Ucenik ucenik;
	private boolean nov;

	/**
	 * @wbp.parser.constructor
	 */
	public RegistracijaUcenikaDlg(JFrame parent) {
		super(parent, "Podaci o učeniku", true);
		registracija();
	}
	
	public RegistracijaUcenikaDlg(JDialog parent) {
		super(parent, "Podaci o učeniku", true);
		registracija();
	}
	
	
	protected void registracija() {
		setSize(450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblIme = new JLabel("Ime: ");
		GridBagConstraints gbc_lblIme = new GridBagConstraints();
		gbc_lblIme.insets = new Insets(10, 10, 5, 5);
		gbc_lblIme.anchor = GridBagConstraints.WEST;
		gbc_lblIme.gridx = 0;
		gbc_lblIme.gridy = 0;
		panel.add(lblIme, gbc_lblIme);
		
		txtIme = new JTextField();
		GridBagConstraints gbc_txtIme = new GridBagConstraints();
		gbc_txtIme.weightx = 10.0;
		gbc_txtIme.insets = new Insets(10, 0, 5, 10);
		gbc_txtIme.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIme.gridx = 1;
		gbc_txtIme.gridy = 0;
		panel.add(txtIme, gbc_txtIme);
		txtIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime: ");
		GridBagConstraints gbc_lblPrezime = new GridBagConstraints();
		gbc_lblPrezime.anchor = GridBagConstraints.WEST;
		gbc_lblPrezime.insets = new Insets(0, 10, 5, 5);
		gbc_lblPrezime.gridx = 0;
		gbc_lblPrezime.gridy = 1;
		panel.add(lblPrezime, gbc_lblPrezime);
		
		txtPrezime = new JTextField();
		GridBagConstraints gbc_txtPrezime = new GridBagConstraints();
		gbc_txtPrezime.insets = new Insets(0, 0, 5, 10);
		gbc_txtPrezime.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrezime.gridx = 1;
		gbc_txtPrezime.gridy = 1;
		panel.add(txtPrezime, gbc_txtPrezime);
		txtPrezime.setColumns(10);
		
		JLabel lblPol = new JLabel("Pol: ");
		GridBagConstraints gbc_lblPol = new GridBagConstraints();
		gbc_lblPol.anchor = GridBagConstraints.WEST;
		gbc_lblPol.insets = new Insets(0, 10, 5, 5);
		gbc_lblPol.gridx = 0;
		gbc_lblPol.gridy = 2;
		panel.add(lblPol, gbc_lblPol);
		
		comboBoxPol = new JComboBox<Pol>();
		comboBoxPol.addItem(Pol.muško);
		comboBoxPol.addItem(Pol.žensko);
		GridBagConstraints gbc_comboBoxPol = new GridBagConstraints();
		gbc_comboBoxPol.insets = new Insets(0, 0, 5, 10);
		gbc_comboBoxPol.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPol.gridx = 1;
		gbc_comboBoxPol.gridy = 2;
		panel.add(comboBoxPol, gbc_comboBoxPol);
		
		JLabel lblDatum = new JLabel("Datum rođenja: ");
		GridBagConstraints gbc_lblDatum = new GridBagConstraints();
		gbc_lblDatum.anchor = GridBagConstraints.WEST;
		gbc_lblDatum.insets = new Insets(0, 10, 5, 5);
		gbc_lblDatum.gridx = 0;
		gbc_lblDatum.gridy = 3;
		panel.add(lblDatum, gbc_lblDatum);
		
		txtDatum = new JTextField();
		GridBagConstraints gbc_txtDatum = new GridBagConstraints();
		gbc_txtDatum.insets = new Insets(0, 0, 5, 10);
		gbc_txtDatum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDatum.gridx = 1;
		gbc_txtDatum.gridy = 3;
		panel.add(txtDatum, gbc_txtDatum);
		txtDatum.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Broj telefona: ");
		GridBagConstraints gbc_lblTelefon = new GridBagConstraints();
		gbc_lblTelefon.anchor = GridBagConstraints.WEST;
		gbc_lblTelefon.insets = new Insets(0, 10, 5, 5);
		gbc_lblTelefon.gridx = 0;
		gbc_lblTelefon.gridy = 4;
		panel.add(lblTelefon, gbc_lblTelefon);
		
		txtTelefon = new JTextField();
		GridBagConstraints gbc_txtTelefon = new GridBagConstraints();
		gbc_txtTelefon.insets = new Insets(0, 0, 5, 10);
		gbc_txtTelefon.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefon.gridx = 1;
		gbc_txtTelefon.gridy = 4;
		panel.add(txtTelefon, gbc_txtTelefon);
		txtTelefon.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa: ");
		GridBagConstraints gbc_lblAdresa = new GridBagConstraints();
		gbc_lblAdresa.anchor = GridBagConstraints.WEST;
		gbc_lblAdresa.insets = new Insets(0, 10, 5, 5);
		gbc_lblAdresa.gridx = 0;
		gbc_lblAdresa.gridy = 5;
		panel.add(lblAdresa, gbc_lblAdresa);
		
		txtAdresa = new JTextField();
		GridBagConstraints gbc_txtAdresa = new GridBagConstraints();
		gbc_txtAdresa.insets = new Insets(0, 0, 5, 10);
		gbc_txtAdresa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdresa.gridx = 1;
		gbc_txtAdresa.gridy = 5;
		panel.add(txtAdresa, gbc_txtAdresa);
		txtAdresa.setColumns(10);
		
		JLabel lblKorisnickoIme = new JLabel("Korisničko ime: ");
		GridBagConstraints gbc_lblKorisnickoIme = new GridBagConstraints();
		gbc_lblKorisnickoIme.anchor = GridBagConstraints.WEST;
		gbc_lblKorisnickoIme.insets = new Insets(0, 10, 5, 5);
		gbc_lblKorisnickoIme.gridx = 0;
		gbc_lblKorisnickoIme.gridy = 6;
		panel.add(lblKorisnickoIme, gbc_lblKorisnickoIme);
		
		txtKorisnickoIme = new JTextField();
		GridBagConstraints gbc_txtKorisnickoIme = new GridBagConstraints();
		gbc_txtKorisnickoIme.insets = new Insets(0, 0, 5, 10);
		gbc_txtKorisnickoIme.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKorisnickoIme.gridx = 1;
		gbc_txtKorisnickoIme.gridy = 6;
		panel.add(txtKorisnickoIme, gbc_txtKorisnickoIme);
		txtKorisnickoIme.setColumns(10);
		
		JLabel lblLozinka = new JLabel("Lozinka: ");
		GridBagConstraints gbc_lblLozinka = new GridBagConstraints();
		gbc_lblLozinka.anchor = GridBagConstraints.WEST;
		gbc_lblLozinka.insets = new Insets(0, 10, 0, 5);
		gbc_lblLozinka.gridx = 0;
		gbc_lblLozinka.gridy = 7;
		panel.add(lblLozinka, gbc_lblLozinka);
		
		txtLozinka = new JTextField();
		GridBagConstraints gbc_txtLozinka = new GridBagConstraints();
		gbc_txtLozinka.insets = new Insets(0, 0, 0, 10);
		gbc_txtLozinka.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLozinka.gridx = 1;
		gbc_txtLozinka.gridy = 7;
		panel.add(txtLozinka, gbc_txtLozinka);
		txtLozinka.setColumns(10);
			

		JPanel dugmad = new JPanel();
		getContentPane().add(dugmad, BorderLayout.SOUTH);
		btnSnimi = new JButton("Snimi");
		btnSnimi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				registrujUcenika();
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
	}
	

	
	protected void registrujUcenika() {
		if (!ispravanUnos())
			JOptionPane.showMessageDialog(null, "Niste unijeli sve neophodne podatke", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
		else if (!ispravanDatum())
			JOptionPane.showMessageDialog(null, "Unesite datum u formatu: dd.MM.yyyy", "Neispravan datum", JOptionPane.WARNING_MESSAGE);
		else if (!ispravnoKorImeLozinka())
			JOptionPane.showMessageDialog(null, "Greška prilikom unosa korisničkog imena i lozinke", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
		else {
			
			ucenik.setIme(txtIme.getText());
			ucenik.setPrezime(txtPrezime.getText());
			ucenik.setPol((Pol) comboBoxPol.getSelectedItem());
			ucenik.setDatumRodjenjaStr(txtDatum.getText());
			ucenik.setTelefon(txtTelefon.getText());
			ucenik.setAdresa(txtAdresa.getText());
			ucenik.setKorisnickoIme(txtKorisnickoIme.getText());
			ucenik.setLozinka(txtLozinka.getText());
			KorisnikManager.getMapKorisnici().put(ucenik.getKorisnickoIme(), ucenik);
			
			if (nov) {
				String id = String.format("%04d", Podaci.getPodaci().getUcenikManager().getUcenici().size());
				ucenik.setId(id);
				ucenik.setAktivan(true);
				Podaci.getPodaci().getUcenikManager().getUcenici().add(ucenik);
				Podaci.getPodaci().getUcenikManager().getMapUcenici().put(id, ucenik);
				
				JOptionPane.showMessageDialog(null, "Uspješna registracija", "Uspješna registracija", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Uspješno ste izmijenili učenika", "Uspješno izmijenjen učenik", JOptionPane.PLAIN_MESSAGE);
			}
			setVisible(false);
			
		}	
	}
	
	
	private boolean ispravanUnos() {
		if (txtIme.getText().equals(""))
			return false;
		if (txtPrezime.getText().equals(""))
			return false;
		if (txtTelefon.getText().equals(""))
			return false;
		if (txtAdresa.getText().equals(""))
			return false;
		if (txtDatum.getText().equals(""))
			return false;
		return true;		
	}
	
	
	private boolean ispravanDatum() {
		try {
			LocalDate.parse(txtDatum.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
	
	
	private boolean ispravnoKorImeLozinka() {
		String korisnickoIme = txtKorisnickoIme.getText();
		String lozinka = txtKorisnickoIme.getText();
		if (korisnickoIme.equals("") && lozinka.equals(""))
			return true;
		if ((nov) && (KorisnikManager.getMapKorisnici().get(txtKorisnickoIme.getText()) != null))   // ako je potrefio korisnicko ime nekog drugog
			return false;
		else
			return (lozinka.equals("")) ? false : true;   // ako je korisnicko ime originalno, a lozinka prazna
	}




	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik, boolean nov) {
		this.ucenik = ucenik;
		this.nov = nov;
		
		this.txtIme.setText(ucenik.getIme());
		this.txtPrezime.setText(ucenik.getPrezime());
		this.comboBoxPol.setSelectedItem(ucenik.getPol());
		this.txtDatum.setText(ucenik.getDatumRodjenjaStr());
		this.txtTelefon.setText(ucenik.getTelefon());
		this.txtAdresa.setText(ucenik.getAdresa());
		this.txtKorisnickoIme.setText(ucenik.getKorisnickoIme());
		this.txtLozinka.setText(ucenik.getLozinka());
		
	}

	

	
	
}
