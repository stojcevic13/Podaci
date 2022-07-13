package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import TableFrame.kurs.ZahtjeviTableFrame;
import TableFrame.osobe.PregledUcenikaTableFrame;
import entiteti.osobe.Sekretar;
import entiteti.osobe.Ucenik;
import forme.PostavljanjePredavacaNaKursDlg;
import forme.PrijavljivanjeUcenikaNaTerminDlg;
import main.MainFrame;
//import forme.registracija.RegistracijaUcenikaDlg;
import main.Podaci;
import net.miginfocom.swing.MigLayout;
//import view.PredavacMainFrame.Izlaz;
//import view.PredavacMainFrame.KreirajTest;
//import view.PredavacMainFrame.PrikaziKurseve;
//import view.PredavacMainFrame.PrikaziNeocijenjeneTestove;
//import view.PredavacMainFrame.PrikaziTestove;
//import view.AdministratorMainFrame.Odjava;

public class SekretarMainFrame extends JFrame {

	private static final long serialVersionUID = 8823550824523833515L;
	
	private Sekretar sekretar;
	private List<Ucenik> ucenici;

	private JPanel content = (JPanel) getContentPane();
	
	private JButton btnZahtjevi;
	private JButton btnUcenici;
	private JButton btnPostavljanjePredavaca;

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;

	private ZahtjeviTableFrame zahtjeviTable;
	private PostavljanjePredavacaNaKursDlg postavljanjePredavacaNaKursDlg;
	private PregledUcenikaTableFrame pregledUcenikaTableFrame;
	private PrijavljivanjeUcenikaNaTerminDlg prijavaUcenikaNaTerminDlg;
	
	public SekretarMainFrame(Sekretar sekretar) {
		this.sekretar = sekretar;	
		ucenici = new ArrayList<Ucenik>();
		for (Ucenik uc : Podaci.getPodaci().getUcenikManager().getUcenici())
			if (uc.isAktivan())
				ucenici.add(uc);
		
		
		setTitle("Početna stranica");
		setSize(600, 400);
		setLocationRelativeTo(null);
		
		
		napraviMeni();
		postaviDugmad();
		

		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new Izlaz());
	}
	
	
	private void napraviMeni() {
		 menuBar = new JMenuBar();
		 
		 menu = new JMenu("Meni");
		 menu.setMnemonic(KeyEvent.VK_M);  // aktivira se na alt + M
		 menuBar.add(menu);
		 
		 
		 menuItem = new JMenuItem("Zahtjevi");
		 menuItem.addActionListener(new PrikaziZahtjeve());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Učenici");
		 menuItem.addActionListener(new PregledUcenika());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Postavljanje predavaca");
		 menuItem.addActionListener(new PostaviPredavacaNaKurs());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Prijavi učenika na termin");
		 menuItem.addActionListener(new PrijaviUcenikaNaTermin());
		 menu.add(menuItem);
		 
		 menu.addSeparator();
		 
		 menuItem = new JMenuItem("Odjavi se");
		 menuItem.addActionListener(new Odjava());
		 menu.add(menuItem);
		 
		 
		 setJMenuBar(menuBar);
	}
	
	
	
	private void postaviDugmad() {
		JPanel dugmad = new JPanel();
		
		btnZahtjevi = new JButton("Zahtjevi");
		btnZahtjevi.addActionListener(new PrikaziZahtjeve());
		
		btnUcenici = new JButton("Učenici");
		btnUcenici.addActionListener(new PregledUcenika());
		
		btnPostavljanjePredavaca = new JButton("Postavljanje predavača");
		btnPostavljanjePredavaca.addActionListener(new PostaviPredavacaNaKurs());
		
		dugmad.add(btnZahtjevi);
		dugmad.add(btnUcenici);
		dugmad.add(btnPostavljanjePredavaca);
		
		content.setLayout(new MigLayout());
		content.add(dugmad, "push, align center");
	}
	
	
	
	
	
	class Izlaz extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			int odg = JOptionPane.showConfirmDialog(SekretarMainFrame.this, "Da li želite da izađete?", "Izlaz",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (odg == JOptionPane.YES_OPTION) {
				Podaci.getPodaci().saveDataPodaci();
				System.exit(0);
			}
		}
	}
	
	
	class PrikaziZahtjeve implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			zahtjeviTable = new ZahtjeviTableFrame(sekretar, Sekretar.getNeobradjeniZahtjevi());
			zahtjeviTable.setVisible(true);
		}
	}
	
	
	public class PostaviPredavacaNaKurs implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			postavljanjePredavacaNaKursDlg = new PostavljanjePredavacaNaKursDlg(SekretarMainFrame.this);
			postavljanjePredavacaNaKursDlg.setVisible(true);
		}
	}
	
	
	class PregledUcenika implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			pregledUcenikaTableFrame = new PregledUcenikaTableFrame(ucenici);
			pregledUcenikaTableFrame.setVisible(true);
		}
	}
	
	
	class PrijaviUcenikaNaTermin implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			prijavaUcenikaNaTerminDlg = new PrijavljivanjeUcenikaNaTerminDlg(SekretarMainFrame.this);
			prijavaUcenikaNaTerminDlg.setVisible(true);

		}
	}
	
	class Odjava implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Podaci.getPodaci().saveDataPodaci();
			setVisible(false);
			MainFrame.prijavaDlg.setVisible(true);
		}	
	}
	
	
	
	
	
	public Sekretar getSekretar() {
		return sekretar;
	}

	public static void main(String[] args) {
		new Podaci();
	}
	
	
	
	
}
