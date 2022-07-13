package komponente.primer09;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 8874080341118006135L;

	JTable tabela;
	JScrollPane scroll;
	JPanel content;
	
	
	public MainFrame() {
		setSize(500, 300);
		setTitle("Prava tabela");
		setLocation(300, 300);
		tabela = new JTable(new MyTableModelObj());
		
		prikaziTabelu();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void prikaziTabelu() {
		scroll = new JScrollPane(tabela);
		getContentPane().add(scroll);
		tabela.setAutoCreateRowSorter(true);
		
		JButton btnObrisi = new JButton("Obrisi studenta");
		btnObrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tabela.getSelectedRow() != -1) {
					MyTableModelObj model = (MyTableModelObj) tabela.getModel();
					model.obrisiStudenta(tabela.getSelectedRow());
				}
			}
		});
		getContentPane().add(btnObrisi, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
