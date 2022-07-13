package main;

import javax.swing.JDialog;
//import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entiteti.osobe.Administrator;
import entiteti.osobe.Korisnik;
import entiteti.osobe.Korisnik.Uloge;
import entiteti.osobe.Predavac;
import entiteti.osobe.Sekretar;
import entiteti.osobe.Ucenik;
import manager.osobe.KorisnikManager;
import view.AdministratorMainFrame;
import view.PredavacMainFrame;
import view.SekretarMainFrame;
import view.UcenikMainFrame;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;

public class PrijavaDlg extends JDialog {

	private static final long serialVersionUID = 4622760504468324182L;
	private JTextField txtKorisnickoIme;
	Korisnik k;
	
	private UcenikMainFrame ucenikMainFrame;
	private PredavacMainFrame predavacMainFrame;
	private SekretarMainFrame sekretarMainFrame;
	private AdministratorMainFrame administratorMainFrame;
	private JPasswordField txtLozinka;


	public PrijavaDlg() {
		
		setTitle("Prijava");
		setSize(371, 244);
		getContentPane().setLayout(null);

		JLabel lblDobrodoslica = new JLabel("Dobrodošli! Molimo da se prijavite.");
		lblDobrodoslica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDobrodoslica.setBounds(23, 23, 242, 30);
		getContentPane().add(lblDobrodoslica);

		JLabel lblKorisnickoIme = new JLabel("Korisničko ime: ");
		lblKorisnickoIme.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKorisnickoIme.setBounds(23, 76, 105, 23);
		getContentPane().add(lblKorisnickoIme);

		txtKorisnickoIme = new JTextField();
		txtKorisnickoIme.setBounds(129, 79, 178, 19);
		getContentPane().add(txtKorisnickoIme);
		txtKorisnickoIme.setColumns(10);

		JLabel lblLozinka = new JLabel("Lozinka: ");
		lblLozinka.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLozinka.setBounds(23, 109, 61, 16);
		getContentPane().add(lblLozinka);

		JButton btnPrijava = new JButton("Prijavi se");
		btnPrijava.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPrijava.setBounds(59, 164, 85, 21);
		getContentPane().add(btnPrijava);
		
		btnPrijava.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnickoIme = txtKorisnickoIme.getText();
				@SuppressWarnings("deprecation")
				String lozinka = txtLozinka.getText();

				if (korisnickoIme.equals("") || lozinka.equals(""))
					JOptionPane.showMessageDialog(null, "Niste unijeli sve podatke.", "Pogrešan unos", JOptionPane.PLAIN_MESSAGE);
				else if ((k = KorisnikManager.getMapKorisnici().get(korisnickoIme)) != null && k.getLozinka().equals(lozinka) && k.isAktivan()) {
					prikaziPocetnuStranicu(k);
				} else 
					JOptionPane.showMessageDialog(null, "Ne postoji takav korisnik.");
			}
		});

		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOdustani.setBounds(222, 164, 85, 21);
		getContentPane().add(btnOdustani);
		
		txtLozinka = new JPasswordField();
		txtLozinka.setBounds(129, 109, 178, 19);
		getContentPane().add(txtLozinka);
		btnOdustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
	}

	protected void prikaziPocetnuStranicu(Korisnik k2) {
			this.setVisible(false);
		if (k2.getUloga().equals(Uloge.UCENIK)) {
			ucenikMainFrame = new UcenikMainFrame((Ucenik) k2);
			ucenikMainFrame.setVisible(true);
		} else if (k2.getUloga().equals(Uloge.PREDAVAC)) {
			predavacMainFrame = new PredavacMainFrame((Predavac) k2);
			predavacMainFrame.setVisible(true);
		} else if (k2.getUloga().equals(Uloge.SEKRETAR)) {
			sekretarMainFrame = new SekretarMainFrame((Sekretar) k2);
			sekretarMainFrame.setVisible(true);
		} else if (k2.getUloga().equals(Uloge.ADMINISTRATOR)) {
			administratorMainFrame = new AdministratorMainFrame((Administrator) k2);
			administratorMainFrame.setVisible(true);
		}
	}


}
