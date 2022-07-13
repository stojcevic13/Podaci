package kss.gui.igraci;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import kss.manager.ManagerIgrac;
import kss.manager.ManagerKlub;
import kss.model.Igrac;

public class FrmIgraci extends JFrame {

	private static final long serialVersionUID = 8886614103912999395L;

	private JPanel content = (JPanel) getContentPane();
	private ManagerIgrac mi;
	private JButton btnIzmjena;
	private JButton btnObrisi;
	private JButton btnDodaj;

	private EditIgracDlg editIgracDlg;

	public FrmIgraci(ManagerIgrac mi, ManagerKlub mk) {
		this.mi = mi;
		this.editIgracDlg = new EditIgracDlg(this, mk);

		IgraciModel modelIgraca = new IgraciModel(mi);
		JTable tblIgraci = new JTable(modelIgraca);
		tblIgraci.setAutoCreateRowSorter(true);
		tblIgraci.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tblIgraci.getSelectedRow() != -1) {
					btnIzmjena.setEnabled(true);
					btnObrisi.setEnabled(true);
				} else {
					btnIzmjena.setEnabled(false);
					btnObrisi.setEnabled(false);
				}

			}
		});
		JScrollPane scroll = new JScrollPane(tblIgraci);
		tblIgraci.setAutoCreateRowSorter(true);
		content.add(scroll, BorderLayout.CENTER);

		JPanel dugmad = new JPanel();

		btnDodaj = new JButton("Dodaj novog");
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Igrac i = new Igrac();
				editIgracDlg.setIgrac(i, true);
				editIgracDlg.setVisible(true);
				if (!editIgracDlg.isOdustao()) {
					mi.getIgraci().add(i);
					modelIgraca.fireTableDataChanged();
				}

			}
		});
		dugmad.add(btnDodaj);

		btnIzmjena = new JButton("Izmjena");
		btnIzmjena.setEnabled(false);
		btnIzmjena.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblIgraci.getSelectedRow();
				int indexSort = tblIgraci.convertRowIndexToModel(index);
				Igrac igrac = mi.getIgraci().get(indexSort);
				editIgracDlg.setIgrac(igrac, false);
				editIgracDlg.setVisible(true);
				modelIgraca.fireTableDataChanged();
				tblIgraci.setRowSelectionInterval(index, index);
			}
		});
		dugmad.add(btnIzmjena);

		btnObrisi = new JButton("Obriši");
		btnObrisi.setEnabled(false);
		btnObrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblIgraci.getSelectedRow();
				int indexSort = tblIgraci.convertRowIndexToModel(index);
				Igrac igrac = mi.getIgraci().get(indexSort);
				igrac.getKlub().getIgraci().remove(igrac);
				mi.getIgraci().remove(igrac);
				modelIgraca.fireTableDataChanged();
			}
		});
		dugmad.add(btnObrisi);

		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnZatvori);

		content.add(dugmad, BorderLayout.SOUTH);

		setTitle("Igraci");
		setSize(600, 400);
		setLocation(100, 100);
	}

}
