package TableFrame.osobe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entiteti.osobe.Predavac;
import forme.IzvjestajRadaDlg;
import forme.registracija.RegistracijaPredavacaDlg;
import main.Podaci;

public class PregledPredavacaTableFrame extends PredavaciTableFrame {
	
	private static final long serialVersionUID = 2412802149224229857L;
	
	private RegistracijaPredavacaDlg registracijaPredavacaDlg;
	private IzvjestajRadaDlg izvjestajRadaDlg;
	
	
	public PregledPredavacaTableFrame(List<Predavac> predavaci) {
		super(predavaci);
		registracijaPredavacaDlg = new RegistracijaPredavacaDlg(this);

		btnRegistracija.setVisible(true);
		btnIzmjena.setVisible(true);
		btnIzvjestaj.setVisible(true);
		btnObrisi.setVisible(true);

		btnObrisi.setEnabled(false);
		btnIzmjena.setEnabled(false);
		btnIzvjestaj.setEnabled(false);
		tblPredavaci.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tblPredavaci.getSelectedRow() != -1) {
					btnObrisi.setEnabled(true);
					btnIzmjena.setEnabled(true);
					btnIzvjestaj.setEnabled(true);
				} else {
					btnObrisi.setEnabled(false);
					btnIzmjena.setEnabled(false);
					btnIzvjestaj.setEnabled(false);
				}
			}
		});
		
		btnRegistracija.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Predavac pred = new Predavac();
				registracijaPredavacaDlg.setPredavac(pred, true);
				registracijaPredavacaDlg.setVisible(true);
				if (pred.getId() != null)
					predavaci.add(pred);
				modelPredavaca.fireTableDataChanged();
			}
		});
		btnIzmjena.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblPredavaci.getSelectedRow();
				int indexSort = tblPredavaci.convertRowIndexToModel(index);
				Predavac pred = predavaci.get(indexSort);
				registracijaPredavacaDlg.setPredavac(pred, false);
				registracijaPredavacaDlg.setVisible(true);
				modelPredavaca.fireTableDataChanged();
				tblPredavaci.setRowSelectionInterval(index, index);
			}
		});
		btnIzvjestaj.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblPredavaci.getSelectedRow();
				int sortIndex = tblPredavaci.convertRowIndexToModel(index);
				Predavac odabraniPredavac = Podaci.getPodaci().getPredavacManager().getPredavaci().get(sortIndex);
				izvjestajRadaDlg = new IzvjestajRadaDlg(PregledPredavacaTableFrame.this, odabraniPredavac);
				izvjestajRadaDlg.setVisible(true);
			}
		});
		btnObrisi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Da li želite da obrišete predavača?", "Potvrda brisanja",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

					int index = tblPredavaci.getSelectedRow();
					int sortIndex = tblPredavaci.convertRowIndexToModel(index);
					Predavac odabraniPredavac = Podaci.getPodaci().getPredavacManager().getPredavaci().get(sortIndex);
					odabraniPredavac.setAktivan(false);
					predavaci.remove(odabraniPredavac);
					System.out.println(predavaci);
					System.out.println(Podaci.getPodaci().getKursManager().getKursevi());
					modelPredavaca.fireTableDataChanged();
				}
			}
		});
	}
	
	
}
