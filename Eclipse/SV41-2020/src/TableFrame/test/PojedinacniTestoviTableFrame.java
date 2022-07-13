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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entiteti.PojedinacanTest;
import forme.OcjenjivanjeTestaDlg;
import model.PojedinacanTestModel;

public class PojedinacniTestoviTableFrame extends JFrame {
	
	private static final long serialVersionUID = -8807258546144247229L;
	
	public PojedinacanTestModel modelPojedinacniTestovi;
	protected JTable tblPojedinacniTestovi;
	
	protected JPanel content = (JPanel) getContentPane();
	protected JPanel dugmad;
	private JButton btnOcijeni;


	private OcjenjivanjeTestaDlg ocjenjivanjeTestaDlg;

	public PojedinacniTestoviTableFrame(List<PojedinacanTest> pojedinacniTestovi) {


		modelPojedinacniTestovi = new PojedinacanTestModel(pojedinacniTestovi);
		tblPojedinacniTestovi = new JTable(modelPojedinacniTestovi);
		
		tblPojedinacniTestovi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tblPojedinacniTestovi.getSelectedRow() != -1) {
					btnOcijeni.setEnabled(true);
				} else {
					btnOcijeni.setEnabled(false);
				}

			}
		});
		JScrollPane scroll = new JScrollPane(tblPojedinacniTestovi);
		tblPojedinacniTestovi.setAutoCreateRowSorter(true);
		content.add(scroll, BorderLayout.CENTER);

		dugmad = new JPanel();


		btnOcijeni = new JButton("Ocijeni");
		btnOcijeni.setEnabled(false);
		btnOcijeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblPojedinacniTestovi.getSelectedRow();
				int indexSort = tblPojedinacniTestovi.convertRowIndexToModel(index);
				PojedinacanTest odabraniTest = pojedinacniTestovi.get(indexSort);
				ocjenjivanjeTestaDlg = new OcjenjivanjeTestaDlg(PojedinacniTestoviTableFrame.this, odabraniTest, pojedinacniTestovi);
				ocjenjivanjeTestaDlg.setVisible(true);
				modelPojedinacniTestovi.fireTableDataChanged();
				
			}
		});
		dugmad.add(btnOcijeni);


		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnZatvori);

		content.add(dugmad, BorderLayout.SOUTH);

		setTitle("Kursevi");
		setSize(700, 400);
		setLocation(100, 100);
	}

}
