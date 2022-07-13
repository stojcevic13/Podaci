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

import TableFrame.kurs.KurseviTableFrame;
import TableFrame.test.PojedinacniTestoviTableFrame;
import TableFrame.test.PregledTerminaTableFrame;
import TableFrame.test.PregledTestovaTableFrame;
//import TableFrame.PrijavaNaKursTableFrame;
//import TableFrame.PrijavaNaTerminTableFrame;
//import TableFrame.StampanjeRezultataTableFrame;
import entiteti.Kurs;
import entiteti.PojedinacanTest;
import entiteti.TerminTesta;
import entiteti.Test;
import entiteti.osobe.Predavac;
import forme.KreiranjeTestaDlg;
import forme.izvjestaji.InteresovanjeUcenikaDlg;
import main.MainFrame;
import main.Podaci;
import net.miginfocom.swing.MigLayout;


public class PredavacMainFrame extends JFrame {
	
	private static final long serialVersionUID = 3663282975494401976L;
	
	private Predavac predavac;
	private List<PojedinacanTest> neocijenjeniTestovi;
	private List<TerminTesta> termini;
	
	private JPanel content = (JPanel) getContentPane();
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	
	private KurseviTableFrame kurseviTable;
	private PregledTestovaTableFrame pregledTestovaTableFrame;
	private PojedinacniTestoviTableFrame pojedinacniTestoviTable;
	private KreiranjeTestaDlg kreiranjeTestaDlg;
	private PregledTerminaTableFrame pregledTerminaTableFrame;
	private InteresovanjeUcenikaDlg interesovanjeUcenikaDlg;

	
	
	
	public PredavacMainFrame(Predavac predavac) {
		this.predavac = predavac;
		
		kreiranjeTestaDlg = new KreiranjeTestaDlg(this, predavac);
		
		neocijenjeniTestovi = new ArrayList<PojedinacanTest>();
		termini = new ArrayList<TerminTesta>();
		for (Kurs k : predavac.getKursevi()) {
			for (PojedinacanTest pojedinacanTest : k.getNeocijenjeniTestovi())
				neocijenjeniTestovi .add(pojedinacanTest);
		}
	
		
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
		 menu.setMnemonic(KeyEvent.VK_M);  // aktivira se na alt + F
		 menuBar.add(menu);
		 
		 
		 menuItem = new JMenuItem("Moji kursevi");
		 menuItem.addActionListener(new PrikaziKurseve());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Moji testovi");
		 menuItem.addActionListener(new PrikaziTestove());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Moji termini");
		 menuItem.addActionListener(new PregledTermina());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Kreiraj novi test");
		 menuItem.addActionListener(new KreirajTest());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Ocjenjivanje testova");
		 menuItem.addActionListener(new PrikaziNeocijenjeneTestove());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Interesovanje učenika");
		 menuItem.addActionListener(new PrikazInteresovanjaUcenika());
		 menu.add(menuItem);
		 
		 menu.addSeparator();
		 
		 menuItem = new JMenuItem("Odjavi se");
		 menuItem.addActionListener(new Odjava());
		 menu.add(menuItem);
		 
		 
		 setJMenuBar(menuBar);

	}
	
	private void postaviDugmad() {
		JPanel dugmad = new JPanel();
		
		JButton btnNepolozeniKursevi = new JButton("Moji kursevi");
		btnNepolozeniKursevi.addActionListener(new PrikaziKurseve());
		
		JButton btnMojiTestovi = new JButton("Moji testovi");
		btnMojiTestovi.addActionListener(new PrikaziTestove());
		
		JButton btnKreirajTest = new JButton("Kreiraj novi test");
		btnKreirajTest.addActionListener(new KreirajTest());
		
		dugmad.add(btnNepolozeniKursevi);
		dugmad.add(btnMojiTestovi);
		dugmad.add(btnKreirajTest);

		content.setLayout(new MigLayout());
		content.add(dugmad, "push, align center");
	}





	class Izlaz extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			int odg = JOptionPane.showConfirmDialog(PredavacMainFrame.this, "Da li želite da izađete?", "Izlaz",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (odg == JOptionPane.YES_OPTION) {
				Podaci.getPodaci().saveDataPodaci();
				System.exit(0);
			}
		}
	}
	
	
	
	class PrikaziKurseve implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			kurseviTable = new KurseviTableFrame(predavac.getKursevi());
			kurseviTable.setVisible(true);
		}
	}
	
	
	class PrikaziTestove implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			pregledTestovaTableFrame = new PregledTestovaTableFrame(predavac, predavac.getTestovi());
			pregledTestovaTableFrame.setVisible(true);
		}
	}

	

	class KreirajTest implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Test test = new Test();
			kreiranjeTestaDlg.setTest(test, true);
			kreiranjeTestaDlg.setVisible(true);
		}
	}
	
	
	class PrikaziNeocijenjeneTestove implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			pojedinacniTestoviTable = new PojedinacniTestoviTableFrame(neocijenjeniTestovi);
			pojedinacniTestoviTable.setVisible(true);
		}
	}
	
	class PregledTermina implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			termini = new ArrayList<TerminTesta>();
			for (Kurs k : predavac.getKursevi())
				for (TerminTesta termin : k.getDostupniTermini())
					termini.add(termin);
			pregledTerminaTableFrame = new PregledTerminaTableFrame(predavac, termini);
			pregledTerminaTableFrame.setVisible(true);
		}
	}
	
	class PrikazInteresovanjaUcenika implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			interesovanjeUcenikaDlg = new InteresovanjeUcenikaDlg(PredavacMainFrame.this);
			interesovanjeUcenikaDlg.setVisible(true);
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

	
	
	
	
	public Predavac getPredavac() {
		return predavac;
	}

	public void setPredavac(Predavac predavac) {
		this.predavac = predavac;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new Podaci();
	}


}
