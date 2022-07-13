package TableFrame.osobe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import entiteti.Kurs;
//import entiteti.Test;
import entiteti.osobe.Ucenik;
import forme.registracija.RegistracijaUcenikaDlg;
import main.Podaci;
//import view.SekretarMainFrame.PostaviPredavacaNaKurs;
//import view.SekretarMainFrame.RegistrujUcenika;

public class PregledUcenikaTableFrame extends UceniciTableFrame {
	
	private static final long serialVersionUID = 4558380752847655873L;
	
	private RegistracijaUcenikaDlg registracijaDlg;
	

	public PregledUcenikaTableFrame(List<Ucenik> ucenici) {
		super(ucenici);
		registracijaDlg = new RegistracijaUcenikaDlg(this);

		btnRegistracija.setVisible(true);
		btnIzmjena.setVisible(true);
		btnObrisi.setVisible(true);

		btnObrisi.setEnabled(false);
		btnIzmjena.setEnabled(false);
		tblUcenici.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tblUcenici.getSelectedRow() != -1) {
					btnObrisi.setEnabled(true);
					btnIzmjena.setEnabled(true);
				} else {
					btnObrisi.setEnabled(false);
					btnIzmjena.setEnabled(false);
				}
			}
		});
		
		btnRegistracija.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ucenik uc = new Ucenik();
				registracijaDlg.setUcenik(uc, true);
				registracijaDlg.setVisible(true);
				if (uc.getId() != null)
					ucenici.add(uc);
				modelUcenika.fireTableDataChanged();
			}
		});
		btnIzmjena.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblUcenici.getSelectedRow();
				int indexSort = tblUcenici.convertRowIndexToModel(index);
				Ucenik uc = ucenici.get(indexSort);
				registracijaDlg.setUcenik(uc, false);
				registracijaDlg.setVisible(true);
				modelUcenika.fireTableDataChanged();
				tblUcenici.setRowSelectionInterval(index, index);
			}
		});
		btnObrisi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Da li želite da obrišete učenika?", "Potvrda brisanja",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

					int index = tblUcenici.getSelectedRow();
					int sortIndex = tblUcenici.convertRowIndexToModel(index);
					Ucenik odabraniUcenik = Podaci.getPodaci().getUcenikManager().getUcenici().get(sortIndex);
					odabraniUcenik.setAktivan(false);
					ucenici.remove(odabraniUcenik);
					System.out.println(ucenici);
					System.out.println(Podaci.getPodaci().getKursManager().getKursevi());
					modelUcenika.fireTableDataChanged();
				}
			}
		});

		
//		btnPostaviPredavace.addActionListener(new PostaviPredavacaNaKurs(postavljanjePredavacaNaKursDlg));
//		btnObrisi.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (JOptionPane.showConfirmDialog(null, "Da li želite da obrišete kurs?", "Potvrda brisanja",
//						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
//
//					int index = tblKursevi.getSelectedRow();
//					int sortIndex = tblKursevi.convertRowIndexToModel(index);
//					Kurs odabraniKurs = Podaci.getPodaci().getKursManager().getKursevi().get(sortIndex);
//					odabraniKurs.setAktivan(false);
//					kursevi.remove(odabraniKurs);
//					System.out.println(kursevi);
//					System.out.println(Podaci.getPodaci().getKursManager().getKursevi());
//					modelKursa.fireTableDataChanged();
//				}
//			}
//		});
//		btnIzmjena.addActionListener(new ActionListener() {	
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int index = tblKursevi.getSelectedRow();
//				int indexSort = tblKursevi.convertRowIndexToModel(index);
//				Kurs kurs = kursevi.get(indexSort);
//				kreiranjeTestaDlg.setTest(kurs, false);
//				kreiranjeTestaDlg.setVisible(true);
//				modelKursa.fireTableDataChanged();
//				tblKursevi.setRowSelectionInterval(index, index);
//			}
//		});
//		dugmad.add(btnIzmjena);

//		btnStampanjeRezultata.addActionListener(new ActionListener() {	
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int index = tblKursevi.getSelectedRow();
//				int sortIndex = tblKursevi.convertRowIndexToModel(index);
//				Test test = testovi.get(sortIndex);
//				System.out.println(test);
//				stampanjeRezultataTableFrame = new StampanjeRezultataTableFrame(test);
//				stampanjeRezultataTableFrame.setVisible(true);
//			}
//		});
//		dugmad.add(btnStampanjeRezultata);

//		tblKursevi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//		@Override
//		public void valueChanged(ListSelectionEvent e) {
//			if (tblKursevi.getSelectedRow() != -1) {
//				btnIzmjena.setEnabled(true);
//				btnObrisi.setEnabled(true);
//			} else {
//				btnIzmjena.setEnabled(false);
//				btnObrisi.setEnabled(false);
//			}
//
//		}
//	});

//		btnPrijaviSe = new JButton("Prijavi se");
//		btnPrijaviSe.setEnabled(false);
//		btnPrijaviSe.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (JOptionPane.showConfirmDialog(null, "Da li želite da se prijavite na kurs?", "Potvrda prijave",
//						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
//					
//					int index = tblTestovi.getSelectedRow();
//					int indexSort = tblTestovi.convertRowIndexToModel(index);
//					Test odabraniKurs = testovi.get(indexSort);
//					
//					ucenik.getNepolozeniKursevi().add(odabraniKurs);
//					ucenik.uplatiKurs(odabraniKurs);
//					odabraniKurs.getUcenici().add(ucenik);
//					testovi.remove(indexSort);
//				
//					modelTesta.fireTableDataChanged();
//					JOptionPane.showMessageDialog(null, "Uspješno ste se prijavili na kurs", "Uspješna prijava", JOptionPane.PLAIN_MESSAGE);
//				}	
//			}
//		});
//		dugmad.add(btnPrijaviSe);

//		btnPrijaviSe.addActionListener(new ActionListener() {
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
//		dugmad.add(btnPrijaviSe);

	}

}
