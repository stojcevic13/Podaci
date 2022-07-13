package TableFrame.osobe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entiteti.osobe.Sekretar;
import forme.IzvjestajRadaDlg;
import forme.registracija.RegistracijaSekretaraAdmina;
import main.Podaci;

public class PregledSekretaraTableFrame extends SekretariTableFrame {

	private static final long serialVersionUID = 5025117254848627969L;
	
	private RegistracijaSekretaraAdmina registracijaSekretaraDlg;
	private IzvjestajRadaDlg izvjestajRadaDlg;
	
	
	public PregledSekretaraTableFrame(List<Sekretar> sekretari) {
		super(sekretari);
		registracijaSekretaraDlg = new RegistracijaSekretaraAdmina(this);

		btnRegistracija.setVisible(true);
		btnIzmjena.setVisible(true);
		btnIzvjestaj.setVisible(true);
		btnObrisi.setVisible(true);

		btnObrisi.setEnabled(false);
		btnIzmjena.setEnabled(false);
		btnIzvjestaj.setEnabled(false);
		tblSekretari.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tblSekretari.getSelectedRow() != -1) {
					btnObrisi.setEnabled(true);
					btnIzvjestaj.setEnabled(true);
					btnIzmjena.setEnabled(true);
				} else {
					btnIzmjena.setEnabled(false);
					btnObrisi.setEnabled(false);
					btnIzvjestaj.setEnabled(false);
				}
			}
		});
		
		btnRegistracija.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sekretar sek = new Sekretar();
				registracijaSekretaraDlg.setSekretar(sek, true);
				registracijaSekretaraDlg.setVisible(true);
				if (sek.getId() != null)
					sekretari.add(sek);
				modelSekretara.fireTableDataChanged();
			}
		});
		btnIzmjena.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblSekretari.getSelectedRow();
				int indexSort = tblSekretari.convertRowIndexToModel(index);
				Sekretar sek = sekretari.get(indexSort);
				registracijaSekretaraDlg.setSekretar(sek, false);
				registracijaSekretaraDlg.setVisible(true);
				modelSekretara.fireTableDataChanged();
				tblSekretari.setRowSelectionInterval(index, index);
			}
		});
		btnIzvjestaj.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblSekretari.getSelectedRow();
				int sortIndex = tblSekretari.convertRowIndexToModel(index);
				Sekretar odabraniSekretar = Podaci.getPodaci().getSekretarManager().getSekretari().get(sortIndex);
				izvjestajRadaDlg = new IzvjestajRadaDlg(PregledSekretaraTableFrame.this, odabraniSekretar);
				izvjestajRadaDlg.setVisible(true);
			}
		});
		btnObrisi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Da li želite da obrišete sekretara?", "Potvrda brisanja",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

					int index = tblSekretari.getSelectedRow();
					int sortIndex = tblSekretari.convertRowIndexToModel(index);
					Sekretar odabraniSekretar = Podaci.getPodaci().getSekretarManager().getSekretari().get(sortIndex);
					odabraniSekretar.setAktivan(false);
					sekretari.remove(odabraniSekretar);
					modelSekretara.fireTableDataChanged();
				}
			}
		});
	}
}
