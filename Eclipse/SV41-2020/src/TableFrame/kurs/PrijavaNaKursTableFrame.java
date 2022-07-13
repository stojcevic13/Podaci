package TableFrame.kurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entiteti.Kurs;
import entiteti.Zahtjev;
import entiteti.Zahtjev.Stanje;
import entiteti.osobe.Sekretar;
import entiteti.osobe.Ucenik;
import main.Podaci;

public class PrijavaNaKursTableFrame extends KurseviTableFrame {

	private static final long serialVersionUID = -2520553658785427563L;
	
	private JButton btnPrijaviSe;

	public PrijavaNaKursTableFrame(Ucenik ucenik, List<Kurs> kursevi) {
		super(kursevi);
		
//		btnPrijaviSe.setVisible(true);
		tblKursevi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {	
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tblKursevi.getSelectedRow() != -1) {
					btnPrijaviSe.setEnabled(true);
				} else {
					btnPrijaviSe.setEnabled(false);
				}
				
			}
		});
		
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
		
		btnPrijaviSe = new JButton("Prijavi se");
		btnPrijaviSe.setEnabled(false);
		btnPrijaviSe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Da li želite da se prijavite na kurs?", "Potvrda prijave",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					
					int index = tblKursevi.getSelectedRow();
					int indexSort = tblKursevi.convertRowIndexToModel(index);
					Kurs odabraniKurs = kursevi.get(indexSort);
					
					Zahtjev zahtjev = new Zahtjev(ucenik, odabraniKurs, Stanje.KREIRAN, LocalDate.now());
					Sekretar.getNeobradjeniZahtjevi().add(zahtjev);
					Podaci.getPodaci().getZahtjevManager().getNeobradjeniZahtjevi().add(zahtjev);
					Podaci.getPodaci().getZahtjevManager().getMapZahtjevi().put(zahtjev.getId(), zahtjev);
					
//					ucenik.getNepolozeniKursevi().add(odabraniKurs);
//					ucenik.uplatiKurs(odabraniKurs);
//					odabraniKurs.getUcenici().add(ucenik);
					kursevi.remove(indexSort);
					
					modelKursa.fireTableDataChanged();
					JOptionPane.showMessageDialog(null, "Uspješno ste se prijavili na kurs", "Uspješna prijava", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		dugmad.add(btnPrijaviSe);
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
