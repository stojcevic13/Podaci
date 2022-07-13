package TableFrame.kurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entiteti.Kurs;
import forme.KreiranjeKursaDlg;
import forme.PostavljanjePredavacaNaKursDlg;
import main.Podaci;

public class PregledKursevaTableFrame extends KurseviTableFrame {

	private static final long serialVersionUID = -8796320914525239631L;

	private KreiranjeKursaDlg kreiranjeKursaDlg;
	private PostavljanjePredavacaNaKursDlg postavljanjePredavacaNaKursDlg;


	public PregledKursevaTableFrame(List<Kurs> kursevi) {
		super(kursevi);
		kreiranjeKursaDlg = new KreiranjeKursaDlg(this);
		postavljanjePredavacaNaKursDlg = new PostavljanjePredavacaNaKursDlg(this);

		btnKreiraj.setVisible(true);
		btnPostaviPredavace.setVisible(true);
		btnObrisi.setVisible(true);

		btnObrisi.setEnabled(false);
		tblKursevi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tblKursevi.getSelectedRow() != -1) {
					btnObrisi.setEnabled(true);

				} else {
					btnObrisi.setEnabled(false);
				}
			}
		});

		btnKreiraj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				kreiranjeKursaDlg.setVisible(true);
				if (kreiranjeKursaDlg.getNoviKurs() != null)
					kursevi.add(kreiranjeKursaDlg.getNoviKurs());
				modelKursa.fireTableDataChanged();
			}
		});
		btnPostaviPredavace.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				postavljanjePredavacaNaKursDlg.setVisible(true);
				modelKursa.fireTableDataChanged();
			}
		});
		btnObrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Da li želite da obrišete kurs?", "Potvrda brisanja",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

					int index = tblKursevi.getSelectedRow();
					int sortIndex = tblKursevi.convertRowIndexToModel(index);
					Kurs odabraniKurs = Podaci.getPodaci().getKursManager().getKursevi().get(sortIndex);
					odabraniKurs.setAktivan(false);
					kursevi.remove(odabraniKurs);
					modelKursa.fireTableDataChanged();
				}

			}
		});

	}
}
