package vezbe9.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import vezbe4.primer5.Student;

public class MeniILayouti extends JFrame {

	// sva inicijalizacija se vrsi u konstruktoru
	public MeniILayouti() {
		// naslov prozora
		setTitle("Meni i layouti");
	
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/2, screenHeight/2);
		
		/*
		 * Centrira prozor u odnosu na prosledjenu komponentu. Ako se prosledi null,
		 * prozor se centrira na sredini ekrana. Ako se ne pozove ova funkcija, prozor
		 * se prikazuje u gornjem levom uglu ekrana.
		 */
		setLocationRelativeTo(null);
		/*
		 * Specificira kako ce se prozor ponasati kada se zatvori (klik na dugme X).
		 * Opcije: 
		 * 		- DISPOSE_ON_CLOSE: Zatvara prozor i oslobadja zauzete memorijske
		 * 				resurse. Ako je ovo bio jedini otvoreni prozor u programu, program se
		 * 				prekida.
		 * 		- EXIT_ON_CLOSE: Zatvara prozor i prekida program.
		 * 		- HIDE_ON_CLOSE: Samo vizuelno sakriva prozor.
		 * 		- DO_NOTHING_ON_CLOSE: Dugme za zatvaranje prozora ne radi nista, ocekuje se od
		 * 				korisnika da napise reakciju na klik na ovo dugme.
		 */

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//setResizable(false);
		
		//Kreiranje glavnog menija aplikacije
		JMenuBar mainMenu = new JMenuBar();
		
		//File meni
		JMenu fileMenu = new JMenu("File");
		
		//"Open" stavka menija
		JMenuItem openMenuItem = new JMenuItem("Open...");
		//CTRL + O precica za stavku "Open"
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));
		//Dodavanje stavke u meni
		fileMenu.add(openMenuItem);
		
		//Podmeni insert
		JMenu insertMenu = new JMenu("Insert");
		
		//Stavke podmenija
		JMenuItem fileItem = new JMenuItem("From file...");
		insertMenu.add(fileItem);
		JMenuItem urlItem = new JMenuItem("From URL...");
		insertMenu.add(urlItem);
		
		//Dodavanje separatora
		fileMenu.addSeparator();
		//Dodavanje podmenija u meni
		fileMenu.add(insertMenu);
		
		//Dodavanje menija "File" u glavni meni
		mainMenu.add(fileMenu);
		//Postavljanje glavnog menija aplikacije
		setJMenuBar(mainMenu);
		
	
		//Postavljanje layouta
//		setLayout(new BorderLayout());
//		add(new JButton("Novo dugme"), BorderLayout.NORTH);
		
		
//		setLayout(new FlowLayout(FlowLayout.LEFT));
//		add(new JButton("Button1"));
//		add(new JButton("Button2"));
//		add(new JButton("Button3"));
//		add(new JButton("Button4"));

//		setLayout(new GridLayout(4,3));
//		add(new JButton("Button1"));
//		add(new JButton("Button2"));
//		add(new JButton("Button3"));
//		add(new JButton("Button4"));
//		add(new JButton("Button5"));
//		add(new JButton("Button6"));
//		add(new JButton("Button7"));

//		setLayout(new GridBagLayout());
//		GridBagConstraints con = new GridBagConstraints();
//		JLabel lblId = new JLabel("Id");
//		con.gridx = 0;
//		con.gridy = 0;
//		con.insets = new Insets(10,10,10,10);
//		add(lblId, con);
//		JLabel lblName = new JLabel("Name");
//		con.gridy = 1;
//		//con.gridx = 1;
//		add(lblName, con);
		
		
		
		
//		//Inicijalizacija podataka:
//		//Sadrzaj zaglavlja tabele se definise putem niza(ili Vector-a)
//		String [] zaglavlja = new String[] {"Ime", "Prezime", "Broj indeksa"};
//		//Sadrzaj same tabele je matrica
//		Object [][] sadrzaj = new Object[10][zaglavlja.length];
//		
//		for(int i=0; i<sadrzaj.length; i++) {
//			sadrzaj[i][0] = "Ime";
//			sadrzaj[i][1] = "Prezime";
//			sadrzaj[i][2] = "Indeks";
//		}
//		
//		//Instanciranje TableModel objekta sa definisanim podacima
//		DefaultTableModel model = new DefaultTableModel(sadrzaj, zaglavlja);
//		//Instanciranje tabele
//		JTable tabela = new JTable(model);
//		
//		//Neka standardna podesavanja JTable komponente:
//		//	Dozvoljeno selektovanje redova:
//		tabela.setRowSelectionAllowed(true);
//		//	Ali ne i selektovanje kolona:
//		tabela.setColumnSelectionAllowed(false);
//		//	Dozvoljeno selektovanje samo jednog reda odjednom
//		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		//	Onemoguceno je direktno editovanje sadrzaja u celijama
//		tabela.setDefaultEditor(Object.class, null);
//		
//		//Dodavanje JScrollPane panela sa tabelom u kontejner
//		JScrollPane scrollPane = new JScrollPane(tabela);
//		add(scrollPane);
//		
//		//Dodavanje novog reda u tabelu
//		model = (DefaultTableModel)tabela.getModel();
//		model.addRow(new String[] {"Ime", "Prezime", "Broj indeksa"});
//		
//		//Uklanjanje reda se vrsi putem indeksa
//		model.removeRow(5);
//		
//		//Trenutno selektovani red se moze dobiti metodom getSelectedRow()
//		//Metoda vraca -1 ako nista nije selektovano
//		int selektovaniRed = tabela.getSelectedRow();
//		
//		String jednoIme = (String) tabela.getValueAt(1, 0);
//		tabela.setValueAt("Novo ime", 1, 0);
		
//		Map<Integer, Student> studenti = new HashMap<>();
//		studenti.put(1, new Student("Student1", "123", "Grad1"));
//		studenti.put(2, new Student("Student2", "456", "Grad2"));
//		studenti.put(3, new Student("Student3", "789", "Grad3"));
//
//		StudentModel model = new StudentModel(studenti);
//		//Instanciranje tabele
//		JTable tabela = new JTable(model);
//		
//		//Neka standardna podesavanja JTable komponente:
//		//	Dozvoljeno selektovanje redova:
//		tabela.setRowSelectionAllowed(true);
//		//	Ali ne i selektovanje kolona:
//		tabela.setColumnSelectionAllowed(false);
//		//	Dozvoljeno selektovanje samo jednog reda odjednom
//		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		//	Onemoguceno je direktno editovanje sadrzaja u celijama
//		tabela.setDefaultEditor(Object.class, null);
//		
//		//Dodavanje JScrollPane panela sa tabelom u kontejner
//		JScrollPane scrollPane = new JScrollPane(tabela);
//		add(scrollPane);
	
		
	}
}
