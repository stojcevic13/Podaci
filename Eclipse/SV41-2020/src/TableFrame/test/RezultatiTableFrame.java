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

import entiteti.RezultatTesta;
import model.RezultatiModel;


public class RezultatiTableFrame extends JFrame {

	private static final long serialVersionUID = -1416825714609308363L;
	
	private JPanel content = (JPanel) getContentPane();



	public RezultatiTableFrame(List<RezultatTesta> rezultati) {

		RezultatiModel modelRezultata = new RezultatiModel(rezultati);
		JTable tblRezultati = new JTable(modelRezultata);
		

		JScrollPane scroll = new JScrollPane(tblRezultati);
		tblRezultati.setAutoCreateRowSorter(true);
		content.add(scroll, BorderLayout.CENTER);

		JPanel dugmad = new JPanel();


		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnZatvori);

		content.add(dugmad, BorderLayout.SOUTH);

		setTitle("Rezultati");
		setSize(700, 400);
		setLocation(100, 100);
	}


}
