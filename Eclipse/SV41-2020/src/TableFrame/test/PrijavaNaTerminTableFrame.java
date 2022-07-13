package TableFrame.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import entiteti.Kurs;
import entiteti.TerminTesta;
import entiteti.osobe.Ucenik;

public class PrijavaNaTerminTableFrame extends TerminiTableFrame {
	
	private static final long serialVersionUID = -7111005574204081281L;
	
	private JButton btnPrijaviSe;

	public PrijavaNaTerminTableFrame(Ucenik ucenik, List<TerminTesta> termini) {
		super(termini);
		
		tblTermini.getSelectionModel().addListSelectionListener(new ListSelectionListener() {	
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tblTermini.getSelectedRow() != -1) {
					btnPrijaviSe.setEnabled(true);
				} else {
					btnPrijaviSe.setEnabled(false);
				}
				
			}
		});
		
		
		btnPrijaviSe = new JButton("Prijavi se");
		btnPrijaviSe.setEnabled(false);
		btnPrijaviSe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Da li želite da se prijavite na termin?", "Potvrda prijave",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					
					int index = tblTermini.getSelectedRow();
					int indexSort = tblTermini.convertRowIndexToModel(index);
					TerminTesta odabraniTermin = termini.get(indexSort);
					
					ucenik.getTermini().add(odabraniTermin);
					for (TerminTesta t : ucenik.getTermini())
						if (t.getKurs().getId() == odabraniTermin.getId()) {  // AKO JE VEC POLAGAO TAJ KURS
							ucenik.platiPolaganjeKursa(odabraniTermin.getKurs());
							break;
						}
					odabraniTermin.getUcenici().add(ucenik);
					termini.remove(indexSort);
					
					modelTermina.fireTableDataChanged();
					JOptionPane.showMessageDialog(null, "Uspješno ste se prijavili na termin", "Uspješna prijava", JOptionPane.PLAIN_MESSAGE);

				}	
			}
		});
		dugmad.add(btnPrijaviSe);
		
		
		
	}

}
