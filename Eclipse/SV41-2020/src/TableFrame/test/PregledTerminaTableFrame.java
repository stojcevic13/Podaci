package TableFrame.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import entiteti.TerminTesta;
import entiteti.osobe.Predavac;
import forme.KreiranjeTerminaDlg;

public class PregledTerminaTableFrame extends TerminiTableFrame {

	private static final long serialVersionUID = 5124800331106328830L;
	
	private KreiranjeTerminaDlg kreiranjeTerminaDlg;



	public PregledTerminaTableFrame(Predavac predavac, List<TerminTesta> termini) {
		super(termini);

		kreiranjeTerminaDlg = new KreiranjeTerminaDlg(this, predavac, termini);

		btnKreiraj.setVisible(true);
		btnKreiraj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				kreiranjeTerminaDlg.setVisible(true);
				modelTermina.fireTableDataChanged();
			}
		});



	}
}
