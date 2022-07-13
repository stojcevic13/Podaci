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

import entiteti.Test;
//import entiteti.osobe.Ucenik;
//import model.KurseviModel;
import model.TestoviModel;

public class TestoviTableFrame extends JFrame {
	
	private static final long serialVersionUID = -4930205386743877385L;
	
	public TestoviModel modelTesta;
	
	protected JTable tblTestovi;
	protected JPanel dugmad;
	protected JPanel content = (JPanel) getContentPane();
	


	public TestoviTableFrame(List<Test> testovi) {

		modelTesta = new TestoviModel(testovi);
		tblTestovi = new JTable(modelTesta);
		
		JScrollPane scroll = new JScrollPane(tblTestovi);
		tblTestovi.setAutoCreateRowSorter(true);
		content.add(scroll, BorderLayout.CENTER);

		dugmad = new JPanel();


		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnZatvori);

		content.add(dugmad, BorderLayout.SOUTH);

		setTitle("Testovi");
		setSize(600, 400);
		setLocation(100, 100);
	}

}
