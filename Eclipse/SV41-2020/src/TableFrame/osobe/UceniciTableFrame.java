package TableFrame.osobe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entiteti.osobe.Ucenik;
import model.osobe.UcenikModel;

public class UceniciTableFrame extends JFrame {

	private static final long serialVersionUID = 8911135416865985872L;

	public UcenikModel modelUcenika;
	protected JTable tblUcenici;
	
	protected JPanel content = (JPanel) getContentPane();
	protected JPanel dugmad;
	
	protected JButton btnIzmjena = new JButton("Izmjena");
	protected JButton btnObrisi = new JButton("Obriši");
	protected JButton btnRegistracija = new JButton("Registracija");

//	private EditIgracDlg editIgracDlg;

	public UceniciTableFrame(List<Ucenik> ucenici) {
//		this.editIgracDlg = new EditIgracDlg(this, mk);

		modelUcenika = new UcenikModel(ucenici);
		tblUcenici = new JTable(modelUcenika);
		
//		tblKursevi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				if (tblKursevi.getSelectedRow() != -1) {
//					btnIzmjena.setEnabled(true);
//					btnObrisi.setEnabled(true);
//				} else {
//					btnIzmjena.setEnabled(false);
//					btnObrisi.setEnabled(false);
//				}
//
//			}
//		});
		JScrollPane scroll = new JScrollPane(tblUcenici);
		tblUcenici.setAutoCreateRowSorter(true);
		content.add(scroll, BorderLayout.CENTER);

		dugmad = new JPanel();
		
		btnRegistracija.setVisible(false);
		btnIzmjena.setVisible(false);
		btnObrisi.setVisible(false);
		
		dugmad.add(btnRegistracija);
		dugmad.add(btnIzmjena);
		dugmad.add(btnObrisi);

//		btnDodaj = new JButton("Dodaj novog");
//		btnDodaj.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Igrac i = new Igrac();
//				editIgracDlg.setIgrac(i, true);
//				editIgracDlg.setVisible(true);
//				if (!editIgracDlg.isOdustao()) {
//					mi.getIgraci().add(i);
//					modelIgraca.fireTableDataChanged();
//				}
//
//			}
//		});
//		dugmad.add(btnDodaj);

//		btnIzmjena = new JButton("Izmjena");
//		btnIzmjena.setEnabled(false);
//		btnIzmjena.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int index = tblKursevi.getSelectedRow();
//				int indexSort = tblKursevi.convertRowIndexToModel(index);
//				Igrac igrac = mi.getIgraci().get(indexSort);
//				editIgracDlg.setIgrac(igrac, false);
//				editIgracDlg.setVisible(true);
//				modelIgraca.fireTableDataChanged();
//				tblKursevi.setRowSelectionInterval(index, index);
//			}
//		});
//		dugmad.add(btnIzmjena);

//		btnObrisi = new JButton("Obriši");
//		btnObrisi.setEnabled(false);
//		btnObrisi.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int index = tblKursevi.getSelectedRow();
//				int indexSort = tblKursevi.convertRowIndexToModel(index);
//				Igrac igrac = mi.getIgraci().get(indexSort);
//				igrac.getKlub().getIgraci().remove(igrac);
//				mi.getIgraci().remove(igrac);
//				modelIgraca.fireTableDataChanged();
//			}
//		});
//		dugmad.add(btnObrisi);

		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnZatvori);

		content.add(dugmad, BorderLayout.SOUTH);

		setTitle("Učenici");
		setSize(700, 400);
		setLocation(100, 100);
	}
}
