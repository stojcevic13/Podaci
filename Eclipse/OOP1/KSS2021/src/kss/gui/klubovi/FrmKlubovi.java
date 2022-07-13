package kss.gui.klubovi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import kss.manager.ManagerKlub;

public class FrmKlubovi extends JFrame {

	private static final long serialVersionUID = 8918081107182634910L;
	
	private ManagerKlub mk;
	private JPanel content = (JPanel) getContentPane();

	public FrmKlubovi(ManagerKlub mk) {
		this.mk = mk;
		setTitle("Klubovi");
		setSize(600, 400);
		setLocation(100, 100);
		
		JTable tblKlubovi = new JTable(new KluboviModel(mk));
		tblKlubovi.setAutoCreateRowSorter(true);
		JScrollPane scroll = new JScrollPane(tblKlubovi);
		content.add(scroll, BorderLayout.CENTER);
		
		JPanel dugmad = new JPanel();

		
		
		JButton btnIzmjena = new JButton("Izmjena");
		btnIzmjena.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		dugmad.add(btnIzmjena);
		
		
		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnZatvori);
		content.add(dugmad, BorderLayout.SOUTH);
		
		
	}
}
