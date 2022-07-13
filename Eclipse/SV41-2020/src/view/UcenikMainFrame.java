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

import TableFrame.UplateTableFrame;
import TableFrame.kurs.KurseviTableFrame;
import TableFrame.kurs.PrijavaNaKursTableFrame;
import TableFrame.test.PrijavaNaTerminTableFrame;
import TableFrame.test.RezultatiTableFrame;
import TableFrame.test.TerminiTableFrame;
import TableFrame.test.TestoviTableFrame;
import entiteti.Kurs;
import entiteti.TerminTesta;
import entiteti.osobe.Ucenik;
import main.MainFrame;
import main.Podaci;
import net.miginfocom.swing.MigLayout;


public class UcenikMainFrame extends JFrame {

	private static final long serialVersionUID = -236387797140482197L;
	
	private Ucenik ucenik;
	private JPanel content = (JPanel) getContentPane();
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	
	private KurseviTableFrame polozeniKurseviTable;
	private KurseviTableFrame nepolozeniKurseviTable;
	private TestoviTableFrame testoviTable;
	private TerminiTableFrame terminiTable;
	private RezultatiTableFrame rezultatiTable;
	private UplateTableFrame uplateTable;
	
	private PrijavaNaKursTableFrame prijavaNaKursTable;
	private PrijavaNaTerminTableFrame prijavaNaTerminTable;

	
	public UcenikMainFrame(Ucenik ucenik) {
		this.ucenik = ucenik;
		polozeniKurseviTable = new KurseviTableFrame(ucenik.getPolozeniKursevi());
		nepolozeniKurseviTable = new KurseviTableFrame(ucenik.getNepolozeniKursevi());
		testoviTable = new TestoviTableFrame(ucenik.getTestovi());
		terminiTable = new TerminiTableFrame(ucenik.getTermini());
		rezultatiTable = new RezultatiTableFrame(ucenik.getRezultati());
		uplateTable = new UplateTableFrame(ucenik);
		
		
		
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
		 
		 menuItem = new JMenuItem("Položeni kursevi");
		 menuItem.addActionListener(new PrikaziPolozeneKurseve());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Nepoloženi kursevi");
		 menuItem.addActionListener(new PrikaziNepolozeneKurseve());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Moji testovi");
		 menuItem.addActionListener(new PrikaziTestove());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Moji termini");
		 menuItem.addActionListener(new PrikaziTermine());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Moji rezultati");
		 menuItem.addActionListener(new PrikaziRezultate());
		 menu.add(menuItem);
		 
		 menu.addSeparator();
		 
		 menuItem = new JMenuItem("Vidi finansijsku karticu");
		 menuItem.addActionListener(new VidiFinansijskuKarticu());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Prijavi se na novi kurs");
		 menuItem.addActionListener(new PrijavaNaKurs());
		 menu.add(menuItem);
		 
		 menuItem = new JMenuItem("Prijavi se na termin testa");
		 menuItem.addActionListener(new PrijavaNaTermin());
		 menu.add(menuItem);
		 
		 menu.addSeparator();
		 
		 menuItem = new JMenuItem("Odjavi se");
		 menuItem.addActionListener(new Odjava());
		 menu.add(menuItem);
		 
		 
		 setJMenuBar(menuBar);

	}
	
	private void postaviDugmad() {
		JPanel dugmad = new JPanel();
		dugmad.setLayout(new MigLayout("wrap 2", "[][]", "[]20[][]20[]"));
		
		JButton btnPolozeniKursevi = new JButton("Položeni kursevi");
		btnPolozeniKursevi.addActionListener(new PrikaziPolozeneKurseve());
		
		JButton btnNepolozeniKursevi = new JButton("Nepoloženi kursevi");
		btnNepolozeniKursevi.addActionListener(new PrikaziNepolozeneKurseve());
		
		JButton btnMojiTestovi = new JButton("Moji testovi");
		btnMojiTestovi.addActionListener(new PrikaziTestove());
		
		JButton btnMojiTermini = new JButton("Moji termini");
		btnMojiTermini.addActionListener(new PrikaziTermine());
		
		JButton btnMojiRezultati = new JButton("Moji rezultati");
		btnMojiRezultati.addActionListener(new PrikaziRezultate());
		
		
		dugmad.add(btnPolozeniKursevi, "push, align center");
		dugmad.add(btnNepolozeniKursevi, "push, align center");
		dugmad.add(btnMojiTestovi, "push, align center");
		dugmad.add(btnMojiTermini, "push, align center");
		dugmad.add(btnMojiRezultati, "push, align center");
		
		content.add(dugmad);
	}





	class Izlaz extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			int odg = JOptionPane.showConfirmDialog(UcenikMainFrame.this, "Da li želite da izađete?", "Izlaz",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (odg == JOptionPane.YES_OPTION) {
				Podaci.getPodaci().saveDataPodaci();
				System.exit(0);
			}
		}
	}
	
	
	class PrikaziPolozeneKurseve implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			polozeniKurseviTable.setVisible(true);
//			polozeniKurseviTable.modelKursa.fireTableDataChanged();
		}
	}
	
	
	class PrikaziNepolozeneKurseve implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			nepolozeniKurseviTable.setVisible(true);
//			nepolozeniKurseviTable.modelKursa.fireTableDataChanged();
		}
	}
	
	
	class PrikaziTestove implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			testoviTable.setVisible(true);
		}
	}
	
	
	class PrikaziTermine implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			terminiTable.setVisible(true);
			terminiTable.modelTermina.fireTableDataChanged();
		}
	}
	
	
	class PrikaziRezultate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			rezultatiTable.setVisible(true);
		}
	}
	
	
	class VidiFinansijskuKarticu implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			uplateTable.setVisible(true);
			uplateTable.modelUplate.fireTableDataChanged();
		}
	}
	
	
	class PrijavaNaKurs implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
//			List<OdrzavanjeKursa> mogucaOdrzavanja = new ArrayList<OdrzavanjeKursa>();
			List<Kurs> moguciKursevi = new ArrayList<Kurs>();
			for (Kurs k : Podaci.getPodaci().getKursManager().getKursevi())
				if (!ucenik.getPolozeniKursevi().contains(k) && !ucenik.getNepolozeniKursevi().contains(k))
					moguciKursevi.add(k);
			
			prijavaNaKursTable = new PrijavaNaKursTableFrame(ucenik, moguciKursevi);
			prijavaNaKursTable.setVisible(true);
//			prijavaNaOdrzavanjeKursaTable = new PrijavaNaOdrzavanjeKursaTableFrame(ucenik, mogucaOdrzavanja);
//			prijavaNaOdrzavanjeKursaTable.setVisible(true);
		}
	}
	
	
	class PrijavaNaTermin implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			List<TerminTesta> moguciTermini = new ArrayList<TerminTesta>();
			
			for (Kurs k : ucenik.getNepolozeniKursevi()) 
//				if (ucenik.isOdslusaoPredavanja(k))
				for (TerminTesta t : k.getDostupniTermini()) 
					if (!ucenik.getTermini().contains(t))
						moguciTermini.add(t);
			
			prijavaNaTerminTable = new PrijavaNaTerminTableFrame(ucenik, moguciTermini);
			prijavaNaTerminTable.setVisible(true);
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
	
	
	
	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new Podaci();
		new UcenikMainFrame(new Ucenik()).setVisible(true);
	}

}
