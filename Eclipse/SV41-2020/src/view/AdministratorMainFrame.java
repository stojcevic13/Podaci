package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import TableFrame.PregledJezikaTableFrame;
import TableFrame.kurs.PregledKursevaTableFrame;
import TableFrame.kurs.ZahtjeviTableFrame;
import TableFrame.osobe.PregledPredavacaTableFrame;
import TableFrame.osobe.PregledSekretaraTableFrame;
import TableFrame.osobe.PregledUcenikaTableFrame;
import TableFrame.test.RezultatiTableFrame;
import TableFrame.test.TestoviTableFrame;
import entiteti.Jezik;
import entiteti.Kurs;
import entiteti.RezultatTesta;
import entiteti.Test;
import entiteti.Uplata;
import entiteti.osobe.Administrator;
import entiteti.osobe.Predavac;
import entiteti.osobe.Sekretar;
import entiteti.osobe.Ucenik;
import entiteti.osobe.Zaposleni;
import forme.PostavljanjePredavacaNaKursDlg;
import forme.PrijavljivanjeUcenikaNaTerminDlg;
import forme.izvjestaji.InteresovanjeUcenikaDlg;
import forme.izvjestaji.IzvjestajGodisnjiPrihodiRashodi;
import forme.izvjestaji.IzvjestajObradjenihZahtjevaDlg;
import forme.izvjestaji.IzvjestajPrihodiRashodiDlg;
import forme.izvjestaji.IzvjestajRezultataKursevaXY;
import forme.izvjestaji.IzvjestajXYPoDatumu;
import main.MainFrame;
import main.Podaci;
import net.miginfocom.swing.MigLayout;

public class AdministratorMainFrame extends JFrame {
	
	private static final long serialVersionUID = 6682769742097285162L;
	
	private Administrator administrator;
	private JPanel content = (JPanel) getContentPane();
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	
	private PregledKursevaTableFrame pregledKursevaTable;
	private PregledUcenikaTableFrame pregledUcenikaTable;
	private PregledPredavacaTableFrame pregledPredavacaTable;
	private PregledSekretaraTableFrame pregledSekretaraTable;
//	private PregledAdministratoraTableFrame pregledAdministratoraTable;
	private PrijavljivanjeUcenikaNaTerminDlg prijavaUcenikaNaTerminDlg;
	private PostavljanjePredavacaNaKursDlg postavljanjePredavacaNaKursDlg;
	
	private ZahtjeviTableFrame zahtjeviTableFrame;
	private PregledJezikaTableFrame pregledJezikaTableFrame;
	private TestoviTableFrame testoviTableFrame;
	private RezultatiTableFrame rezultatiTableFrame;
	
	private IzvjestajPrihodiRashodiDlg izvjestajPrihodiRashodiDlg;
	private IzvjestajObradjenihZahtjevaDlg izvjestajObradjenihZahtjevaDlg;
	private InteresovanjeUcenikaDlg interesovanjeUcenikaDlg;
	private IzvjestajRezultataKursevaXY izvjestajRezultataKursevaDlg;
	
	private List<Kurs> kursevi;
	private List<Ucenik> ucenici;
	private List<Predavac> predavaci;
	private List<Sekretar> sekretari;
	private List<Jezik> jezici;
	private List<Test> testovi;
	private List<RezultatTesta> rezultati;

	
	
	
	
	public AdministratorMainFrame(Administrator administrator) {
		this.administrator = administrator;
		
		kursevi = new ArrayList<Kurs>();
		ucenici = new ArrayList<Ucenik>();
		predavaci = new ArrayList<Predavac>();
		sekretari = new ArrayList<Sekretar>();
		jezici = new ArrayList<Jezik>();
		testovi = Podaci.getPodaci().getTestManager().getTestovi();
		rezultati = Podaci.getPodaci().getRezultatTestaManager().getRezultati();
		for (Kurs kurs : Podaci.getPodaci().getKursManager().getKursevi())
			if (kurs.isAktivan()) 
				kursevi.add(kurs);
		for (Ucenik ucenik : Podaci.getPodaci().getUcenikManager().getUcenici())
			if (ucenik.isAktivan())
				ucenici.add(ucenik);
		for (Predavac predavac : Podaci.getPodaci().getPredavacManager().getPredavaci())
			if (predavac.isAktivan())
				predavaci.add(predavac);
		for (Sekretar sekretar : Podaci.getPodaci().getSekretarManager().getSekretari())
			if (sekretar.isAktivan())
				sekretari.add(sekretar);

	
		
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
		 
		 
		 menuItem = new JMenuItem("Kursevi");
		 menuItem.addActionListener(new PregledKurseva());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Učenici");
		 menuItem.addActionListener(new PregledUcenika());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Predavači");
		 menuItem.addActionListener(new PregledPredavaca());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Sekretari");
		 menuItem.addActionListener(new PregledSekretara());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Zahtjevi");
		 menuItem.addActionListener(new PrikaziZahtjeve());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Jezici");
		 menuItem.addActionListener(new PregledJezika());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Testovi");
		 menuItem.addActionListener(new PrikaziTestove());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Rezultati");
		 menuItem.addActionListener(new PrikaziRezultate());
		 menu.add(menuItem);
		
		 
		 menu.addSeparator();
		 
		 menuItem = new JMenuItem("Prijava učenika na termin");
		 menuItem.addActionListener(new PrijaviUcenikaNaTermin());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Postavi Predavače na kurs");
		 menuItem.addActionListener(new PostaviPredavacaNaKurs());
		 menu.add(menuItem);
		 
		 menu.addSeparator();
		 
		 menuItem = new JMenuItem("Odjavi se");
		 menuItem.addActionListener(new Odjava());
		 menu.add(menuItem);
		 
		 
		 menu = new JMenu("Izvještaji");
		 menu.setMnemonic(KeyEvent.VK_I);  // aktivira se na alt + I
		 menuBar.add(menu);
		 
		 menuItem = new JMenuItem("Izvještaj prihoda i rashoda");
		 menuItem.addActionListener(new IzvjestajPrihodiRashodi());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Izvještaj obrađenih zahtjeva");
		 menuItem.addActionListener(new IzvjestajObradjenihZahtjeva());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Interesovanje učenika");
		 menuItem.addActionListener(new PrikazInteresovanjaUcenika());
		 menu.add(menuItem);
	 
		 menuItem = new JMenuItem("Godišnji izvještaj prihoda i rashoda");
		 menuItem.addActionListener(new GodisnjiPrikaz());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Kretanje prihoda i rashoda po datumu");
		 menuItem.addActionListener(new XYPrihodiRashodi());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Izvještaj rezultata kurseva");
		 menuItem.addActionListener(new XYRezultatiKurseva());
		 menu.add(menuItem);
		 
		 
		 setJMenuBar(menuBar);

	}
	
	
	private void postaviDugmad() {
		JPanel dugmad = new JPanel();
		dugmad.setLayout(new MigLayout("wrap 3", "[][]", "[]20[][]20[]"));
		
		JButton btnUcenici = new JButton("Učenici");
		btnUcenici.addActionListener(new PregledUcenika());
		
		JButton btnPredavaci = new JButton("Predavači");
		btnPredavaci.addActionListener(new PregledPredavaca());
		
		JButton btnSekretari = new JButton("Sekretari");
		btnSekretari.addActionListener(new PregledSekretara());
		
		JButton btnKursevi = new JButton("Kursevi");
		btnKursevi.addActionListener(new PregledKurseva());
		
		JButton btnZahtjevi = new JButton("Zahtjevi");
		btnZahtjevi.addActionListener(new PrikaziZahtjeve());
		
		JButton btnJezici = new JButton("Jezici");
		btnJezici.addActionListener(new PregledJezika());
		
		JButton btnTestovi = new JButton("Testovi");
		btnTestovi.addActionListener(new PrikaziTestove());
		
		JButton btnRezultati = new JButton("Rezultati");
		btnRezultati.addActionListener(new PrikaziRezultate());
		
		JButton btnPodijeliPlate = new JButton("Podijeli plate");
		btnPodijeliPlate.addActionListener(new PodijeliPlate());
		

		
		dugmad.add(btnUcenici, "push, align center");
		dugmad.add(btnPredavaci, "push, align center");
		dugmad.add(btnSekretari, "push, align center");
		dugmad.add(btnKursevi, "push, align center");
		dugmad.add(btnJezici, "push, align center");
		dugmad.add(btnZahtjevi, "push, align center");
		dugmad.add(btnTestovi, "push, align center");
		dugmad.add(btnRezultati, "push, align center");
		dugmad.add(btnPodijeliPlate, "push, align center");



		content.add(dugmad);
	}





	class Izlaz extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			int odg = JOptionPane.showConfirmDialog(AdministratorMainFrame.this, "Da li želite da izađete?", "Izlaz",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (odg == JOptionPane.YES_OPTION) {
				Podaci.getPodaci().saveDataPodaci();
				System.exit(0);
			}
		}
	}
	
	
	
	class PregledKurseva implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			pregledKursevaTable = new PregledKursevaTableFrame(kursevi);
			pregledKursevaTable.setVisible(true);
		}
	}
	
	class PregledUcenika implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			pregledUcenikaTable = new PregledUcenikaTableFrame(ucenici);
			pregledUcenikaTable.setVisible(true);
		}
	}
	
	class PregledPredavaca implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			pregledPredavacaTable = new PregledPredavacaTableFrame(predavaci);
			pregledPredavacaTable.setVisible(true);
		}
	}
	
	class PregledSekretara implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			pregledSekretaraTable = new PregledSekretaraTableFrame(sekretari);
			pregledSekretaraTable.setVisible(true);
		}
	}

	class PrikaziZahtjeve implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			zahtjeviTableFrame = new ZahtjeviTableFrame(administrator, Sekretar.getNeobradjeniZahtjevi());
			zahtjeviTableFrame.setVisible(true);
		}
	}
		
	class PregledJezika implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (Jezik jezik : Podaci.getPodaci().getJezikManager().getJezici())
				if (jezik.isAktivan())
					jezici.add(jezik);
			pregledJezikaTableFrame = new PregledJezikaTableFrame(jezici);
			pregledJezikaTableFrame.setVisible(true);
		}
	}

	class PrikaziTestove implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			testoviTableFrame = new TestoviTableFrame(testovi);
			testoviTableFrame.setVisible(true);
		}
	}
		
	class PrikaziRezultate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			rezultatiTableFrame = new RezultatiTableFrame(rezultati);
			rezultatiTableFrame.setVisible(true);
		}
	}
	
	class PrijaviUcenikaNaTermin implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			prijavaUcenikaNaTerminDlg = new PrijavljivanjeUcenikaNaTerminDlg(AdministratorMainFrame.this);
			prijavaUcenikaNaTerminDlg.setVisible(true);
		}
	}
	
	public class PostaviPredavacaNaKurs implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			postavljanjePredavacaNaKursDlg = new PostavljanjePredavacaNaKursDlg(AdministratorMainFrame.this);
			postavljanjePredavacaNaKursDlg.setVisible(true);
		}
	}
	
	class PodijeliPlate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(null, "Da li želite da podijelite plate zaposlenim?", "Podijeli plate",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ) {
				
				double ukupanIznos = 0.0;
				
				for (Predavac predavac : Podaci.getPodaci().getPredavacManager().getPredavaci())
					if (predavac.isAktivan()) {
						double iznosPlate = Zaposleni.koeficijentStrucneSpreme(predavac.getStrucnaSprema()) * predavac.getPlata() +
								10 * predavac.getGodinaStaza() + predavac.izraunajBonus();
						ukupanIznos += iznosPlate;
					}
				
				for (Sekretar sekretar : Podaci.getPodaci().getSekretarManager().getSekretari())
					if (sekretar.isAktivan()) {
						double iznosPlate = Zaposleni.koeficijentStrucneSpreme(sekretar.getStrucnaSprema()) * sekretar.getPlata() +
								10 * sekretar.getGodinaStaza() + sekretar.izraunajBonus();
						ukupanIznos += iznosPlate;
					}
				
				String idUplate = String.format("%04d", Podaci.getPodaci().getUplataManager().getUplate().size());
				Uplata u = new Uplata(idUplate, LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), ukupanIznos*(-1) );
				Podaci.getPodaci().getUplataManager().getUplate().add(u);
				Podaci.getPodaci().getUplataManager().getMapUplate().put(idUplate, u);
				Administrator.svaUplacivanja.add(u);
				
				JOptionPane.showMessageDialog(null, "Plate su uspješno dodijeljene", "Plate su dodijeljene", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	
	class IzvjestajPrihodiRashodi implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			izvjestajPrihodiRashodiDlg = new IzvjestajPrihodiRashodiDlg(AdministratorMainFrame.this);
			izvjestajPrihodiRashodiDlg.setVisible(true);
		}
	}
	
	class IzvjestajObradjenihZahtjeva implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			izvjestajObradjenihZahtjevaDlg = new IzvjestajObradjenihZahtjevaDlg(AdministratorMainFrame.this);
			izvjestajObradjenihZahtjevaDlg.setVisible(true);
		}
	}
	
	class PrikazInteresovanjaUcenika implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			interesovanjeUcenikaDlg = new InteresovanjeUcenikaDlg(AdministratorMainFrame.this);
			interesovanjeUcenikaDlg.setVisible(true);
		}
	}
	
	class GodisnjiPrikaz implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new IzvjestajGodisnjiPrihodiRashodi();
		}
	}
	
	class XYPrihodiRashodi implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new IzvjestajXYPoDatumu();
		}
	}
	
	class XYRezultatiKurseva implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			izvjestajRezultataKursevaDlg = new IzvjestajRezultataKursevaXY(AdministratorMainFrame.this);
			izvjestajRezultataKursevaDlg.setVisible(true);
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
	
	
	
	
	
	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new Podaci();
	}

}
