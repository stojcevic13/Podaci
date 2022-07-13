package TableFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entiteti.osobe.Ucenik;
import model.UplataModel;

public class UplateTableFrame extends JFrame {

	private static final long serialVersionUID = 7006463186649187818L;
	
	public UplataModel modelUplate;

	private JPanel content = (JPanel) getContentPane();


	public UplateTableFrame(Ucenik ucenik) {
		
		modelUplate = new UplataModel(ucenik);
		JTable tblUplate = new JTable(modelUplate);
		

		JScrollPane scroll = new JScrollPane(tblUplate);
		tblUplate.setAutoCreateRowSorter(true);
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

		setTitle("Istorija uplata");
		setSize(600, 400);
		setLocation(100, 100);
	}

}
