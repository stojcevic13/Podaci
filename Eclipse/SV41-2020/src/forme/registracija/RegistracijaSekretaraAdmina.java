package forme.registracija;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
//import java.util.ArrayList;
//import java.util.List;

import javax.swing.JButton;
//import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entiteti.osobe.Korisnik.Uloge;
import entiteti.osobe.Osoba.Pol;
import entiteti.osobe.Sekretar;
import entiteti.osobe.Zaposleni.StrucnaSprema;
import main.Podaci;
import manager.osobe.KorisnikManager;

public class RegistracijaSekretaraAdmina extends JDialog {

	private static final long serialVersionUID = 3293388019788398386L;
	
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
	
	
	private JLabel lblStrucnaSprema;
	private JComboBox<StrucnaSprema> comboBoxStrucnaSprema;
	private JLabel lblGodineStaza;
	private JTextField txtGodineStaza;
	private JLabel lblPlata;
	private JTextField txtPlata;

	private Sekretar sekretar;
	private boolean nov;
	
//	private String id;
	private String ime;
	private String prezime;
	private String datumRodjenjaStr;
	private String telefon;
	private String adresa;
	private String korisnickoIme;
	private String lozinka;
	private int godineStaza;
	private double plata;

	

	/**
	 * @wbp.parser.constructor
	 */
	public RegistracijaSekretaraAdmina(JFrame parent) {
		super(parent, "Podaci o sekretaru", true);
		registracija();
	}
	
	public RegistracijaSekretaraAdmina(JDialog parent, Uloge uloga) {
		super(parent, "Podaci o sekretaru", true);
		registracija();
	}
	
	public RegistracijaSekretaraAdmina() {
		registracija();
	}
	
	protected void registracija() {
		setSize(450, 400);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 62, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		gbc_lblLozinka.insets = new Insets(0, 10, 5, 5);
		gbc_lblLozinka.gridx = 0;
		gbc_lblLozinka.gridy = 7;
		panel.add(lblLozinka, gbc_lblLozinka);
		
		txtLozinka = new JTextField();
		GridBagConstraints gbc_txtLozinka = new GridBagConstraints();
		gbc_txtLozinka.insets = new Insets(0, 0, 5, 10);
		gbc_txtLozinka.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLozinka.gridx = 1;
		gbc_txtLozinka.gridy = 7;
		panel.add(txtLozinka, gbc_txtLozinka);
		txtLozinka.setColumns(10);
		
		lblStrucnaSprema = new JLabel("Stručna sprema: ");
		GridBagConstraints gbc_lblStrucnaSprema = new GridBagConstraints();
		gbc_lblStrucnaSprema.anchor = GridBagConstraints.WEST;
		gbc_lblStrucnaSprema.insets = new Insets(0, 10, 5, 5);
		gbc_lblStrucnaSprema.gridx = 0;
		gbc_lblStrucnaSprema.gridy = 8;
		panel.add(lblStrucnaSprema, gbc_lblStrucnaSprema);
		
		comboBoxStrucnaSprema = new JComboBox<StrucnaSprema>();
		comboBoxStrucnaSprema.addItem(StrucnaSprema.osnovna);
		comboBoxStrucnaSprema.addItem(StrucnaSprema.srednja);
		comboBoxStrucnaSprema.addItem(StrucnaSprema.viša);
		comboBoxStrucnaSprema.addItem(StrucnaSprema.visoka);
		GridBagConstraints gbc_comboBoxStrucnaSprema = new GridBagConstraints();
		gbc_comboBoxStrucnaSprema.insets = new Insets(0, 0, 5, 10);
		gbc_comboBoxStrucnaSprema.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxStrucnaSprema.gridx = 1;
		gbc_comboBoxStrucnaSprema.gridy = 8;
		panel.add(comboBoxStrucnaSprema, gbc_comboBoxStrucnaSprema);
		
		lblGodineStaza = new JLabel("Godine staža: ");
		GridBagConstraints gbc_lblGodineStaza = new GridBagConstraints();
		gbc_lblGodineStaza.anchor = GridBagConstraints.WEST;
		gbc_lblGodineStaza.insets = new Insets(0, 10, 5, 5);
		gbc_lblGodineStaza.gridx = 0;
		gbc_lblGodineStaza.gridy = 9;
		panel.add(lblGodineStaza, gbc_lblGodineStaza);
		
		txtGodineStaza = new JTextField();
		GridBagConstraints gbc_txtGodineStaza = new GridBagConstraints();
		gbc_txtGodineStaza.insets = new Insets(0, 0, 5, 10);
		gbc_txtGodineStaza.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGodineStaza.gridx = 1;
		gbc_txtGodineStaza.gridy = 9;
		panel.add(txtGodineStaza, gbc_txtGodineStaza);
		txtGodineStaza.setColumns(10);
		
		lblPlata = new JLabel("Plata: ");
		GridBagConstraints gbc_lblPlata = new GridBagConstraints();
		gbc_lblPlata.anchor = GridBagConstraints.WEST;
		gbc_lblPlata.insets = new Insets(0, 10, 5, 5);
		gbc_lblPlata.gridx = 0;
		gbc_lblPlata.gridy = 10;
		panel.add(lblPlata, gbc_lblPlata);
		
		txtPlata = new JTextField();
		GridBagConstraints gbc_txtPlata = new GridBagConstraints();
		gbc_txtPlata.insets = new Insets(0, 0, 5, 10);
		gbc_txtPlata.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPlata.gridx = 1;
		gbc_txtPlata.gridy = 10;
		panel.add(txtPlata, gbc_txtPlata);
		txtPlata.setColumns(10);

			

		JPanel dugmad = new JPanel();
		getContentPane().add(dugmad, BorderLayout.SOUTH);
		btnSnimi = new JButton("Snimi");
		btnSnimi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				registrujSekretara();
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
	

	
	protected void registrujSekretara() {
		if (!ispravanUnos())
			JOptionPane.showMessageDialog(null, "Niste unijeli sve neophodne podatke", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
		else if (!ispravanDatum())
			JOptionPane.showMessageDialog(null, "Unesite datum u formatu: dd.MM.yyyy", "Neispravan datum", JOptionPane.WARNING_MESSAGE);
		else if (!ispravanUnosBrojeva())
			JOptionPane.showMessageDialog(null, "Plata i godine staža moraju biti brojevi", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
		else if ( (nov) && (KorisnikManager.getMapKorisnici().get(txtKorisnickoIme.getText()) != null) )
			JOptionPane.showMessageDialog(null, "Greška prilikom unosa korisničkog imena i lozinke", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
		else {
			
			
			sekretar.setIme(ime);
			sekretar.setPrezime(prezime);
			sekretar.setPol((Pol) comboBoxPol.getSelectedItem());
			sekretar.setDatumRodjenjaStr(datumRodjenjaStr);
			sekretar.setTelefon(telefon);
			sekretar.setAdresa(adresa);
			sekretar.setKorisnickoIme(korisnickoIme);
			sekretar.setLozinka(lozinka);
			sekretar.setStrucnaSprema((StrucnaSprema) comboBoxStrucnaSprema.getSelectedItem());
			sekretar.setGodinaStaza(godineStaza);
			sekretar.setPlata(plata);
			
			KorisnikManager.getMapKorisnici().put(sekretar.getKorisnickoIme(), sekretar);
			
			if (nov) {
				String id = String.format("%04d", Podaci.getPodaci().getSekretarManager().getSekretari().size());
				sekretar.setId(id);
				sekretar.setAktivan(true);
				Podaci.getPodaci().getSekretarManager().getSekretari().add(sekretar);
				Podaci.getPodaci().getSekretarManager().getMapSekretari().put(id, sekretar);
				
				JOptionPane.showMessageDialog(null, "Uspješna registracija", "Uspješna registracija", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Uspješno ste izmijenili sekretara", "Uspješna izmjena", JOptionPane.PLAIN_MESSAGE);
			}
			setVisible(false);
			

		}
	}
	
	


	private boolean ispravanUnos() {
		if ( (ime = txtIme.getText()).equals("") )
			return false;
		if ( (prezime = txtPrezime.getText()).equals("") )
			return false;
		if ( (telefon = txtTelefon.getText()).equals("") )
			return false;
		if ( (adresa = txtAdresa.getText()).equals("") )
			return false;
		if ( (datumRodjenjaStr = txtDatum.getText()).equals("") )
			return false;
		if ( (korisnickoIme = txtKorisnickoIme.getText()).equals("") )
			return false;
		if ( (lozinka = txtLozinka.getText()).equals("") )
			return false;

		return true;		
	}
	
	
	private boolean ispravanDatum() {
		try {
			LocalDate.parse(datumRodjenjaStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
	
	private boolean ispravanUnosBrojeva() {
		try {
			plata = Double.parseDouble(txtPlata.getText());
			godineStaza = Integer.parseInt(txtGodineStaza.getText());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}





	
	public Sekretar getSekretar() {
		return (Sekretar) sekretar;
	}

	public void setSekretar(Sekretar sekretar, boolean nov) {
		this.sekretar = sekretar;
		this.nov = nov;
		
		if (!nov) {
			this.txtIme.setText(sekretar.getIme());
			this.txtPrezime.setText(sekretar.getPrezime());
			this.comboBoxPol.setSelectedItem(sekretar.getPol());
			this.txtDatum.setText(sekretar.getDatumRodjenjaStr());
			this.txtTelefon.setText(sekretar.getTelefon());
			this.txtAdresa.setText(sekretar.getAdresa());
			this.txtKorisnickoIme.setText(sekretar.getKorisnickoIme());
			this.txtLozinka.setText(sekretar.getLozinka());
			this.comboBoxStrucnaSprema.setSelectedItem(sekretar.getStrucnaSprema());
			this.txtGodineStaza.setText(""+sekretar.getGodinaStaza());
			this.txtPlata.setText(""+sekretar.getPlata());
		}
	}
	
	
	

}
