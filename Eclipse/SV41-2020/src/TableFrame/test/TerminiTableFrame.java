package TableFrame.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entiteti.TerminTesta;
import model.TerminiModel;

public class TerminiTableFrame extends JFrame {
	
	private static final long serialVersionUID = 4068129580003922025L;
	
	public TerminiModel modelTermina; 
	protected JTable tblTermini;
	protected JPanel dugmad;
	
	private JPanel content = (JPanel) getContentPane();
	protected JButton btnKreiraj;


	public TerminiTableFrame(List<TerminTesta> termini) {

		modelTermina = new TerminiModel(termini);
		tblTermini = new JTable(modelTermina);
		
		
		JScrollPane scroll = new JScrollPane(tblTermini);
		tblTermini.setAutoCreateRowSorter(true);
		content.add(scroll, BorderLayout.CENTER);
		
		dugmad = new JPanel();
		btnKreiraj = new JButton("Kreiraj");
		btnKreiraj.setVisible(false);
		
		dugmad.add(btnKreiraj);

		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnZatvori);

		content.add(dugmad, BorderLayout.SOUTH);

		setTitle("Termini");
		setSize(600, 400);
		setLocation(100, 100);
	}


}
