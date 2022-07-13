package komponente.primer08;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TestJTableJednostavan extends JFrame {

	private static final long serialVersionUID = -6934013380851402717L;
	
	JTable tabela;
	JScrollPane scroll;

	public TestJTableJednostavan() {
		setTitle("Jedostavan JTable");
		setSize(500, 300);
		setLocation(300, 300);
		
		prikaziTabelu();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void prikaziTabelu() {
		String[] kolone = { "BrIndeksa", "Ime", "Prezime", "Godina upisa", "Budžet"};
		Object[][] podaci = {
				{ "SV41/2020", "Nemanja", "Stojcevic",  2020, true},
				{ "ME25/2017", "Nikola", "Stojcevic",	2017, false},
				{ "ME16/2017", "Aleksandar", "Nikolic", 2020, false},
				{ "SV25/2017", "Marko", "Markovic",  	2017, false},
				{ "RA25/2017", "Nikola", "Stojcevic",  	2017, false},
		};
		tabela = new JTable(podaci, kolone);
		scroll = new JScrollPane(tabela);
		getContentPane().add(scroll);
		tabela.setAutoCreateRowSorter(true);
	}

	public static void main(String[] args) {
		new TestJTableJednostavan();
	}

}
