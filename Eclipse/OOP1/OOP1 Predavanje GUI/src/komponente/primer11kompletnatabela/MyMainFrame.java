package komponente.primer11kompletnatabela;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyMainFrame extends JFrame {

	private static final long serialVersionUID = 1296913526566731434L;

	private JTable tabela = new JTable(new MyOwnTableModel());
	private JScrollPane scroll;
	private JPanel content;
	
	public MyMainFrame() {
		setTitle("Baza studenata");
		setSize(400, 300);
		setLocation(300, 300);
		
		prikaziTabelu();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	private void prikaziTabelu() {
		content = (JPanel) getContentPane();
		scroll = new JScrollPane(tabela);
		content.add(scroll);
		tabela.setAutoCreateRowSorter(true);
		
		tabela.setDefaultEditor(Integer.class, new MyIntegerEditor(1998, 2021));
	}


	public static void main(String[] args) {
		new MyMainFrame();
	}

}
