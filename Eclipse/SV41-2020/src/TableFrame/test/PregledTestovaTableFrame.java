package TableFrame.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entiteti.Test;
import entiteti.osobe.Predavac;
import forme.KreiranjeTestaDlg;


public class PregledTestovaTableFrame extends TestoviTableFrame {

	private static final long serialVersionUID = -5252753024528277106L;

	private JButton btnIzmjena;
	private JButton btnStampanjeRezultata;
	private KreiranjeTestaDlg kreiranjeTestaDlg;
	
	private StampanjeRezultataTableFrame stampanjeRezultataTableFrame;

	public PregledTestovaTableFrame(Predavac predavac, List<Test> testovi) {
		super(testovi);
		kreiranjeTestaDlg = new KreiranjeTestaDlg(this, predavac);

		
		btnIzmjena = new JButton("Izmjena");
		btnStampanjeRezultata = new JButton("Odštampaj rezultate");
		
		btnStampanjeRezultata.setEnabled(false);
		btnIzmjena.setEnabled(false);
		tblTestovi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {	
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tblTestovi.getSelectedRow() != -1) {
					btnIzmjena.setEnabled((testovi.get(tblTestovi.convertRowIndexToModel(tblTestovi.getSelectedRow())).getUcenici().size() != 0) ? false : true);
					btnStampanjeRezultata.setEnabled(true);
					
				} else {
					btnIzmjena.setEnabled(false);
					btnStampanjeRezultata.setEnabled(false);
				}
				
			}
		});
		
		
		btnIzmjena.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblTestovi.getSelectedRow();
				int indexSort = tblTestovi.convertRowIndexToModel(index);
				Test test = testovi.get(indexSort);
				kreiranjeTestaDlg.setTest(test, false);
				kreiranjeTestaDlg.setVisible(true);
				modelTesta.fireTableDataChanged();
				tblTestovi.setRowSelectionInterval(index, index);
			}
		});
		dugmad.add(btnIzmjena);
		
		

		btnStampanjeRezultata.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblTestovi.getSelectedRow();
				int sortIndex = tblTestovi.convertRowIndexToModel(index);
				Test test = testovi.get(sortIndex);
				stampanjeRezultataTableFrame = new StampanjeRezultataTableFrame(test);
				stampanjeRezultataTableFrame.setVisible(true);
			}
		});
		dugmad.add(btnStampanjeRezultata);
		
		

		
	}

}
