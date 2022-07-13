package forme.izvjestaji;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import entiteti.Uplacivanje;
import entiteti.osobe.Administrator;

public class IzvjestajPrihodiRashodiDlg extends IzvjestajBazaDlg {

	private static final long serialVersionUID = 1705444573786500173L;

	public IzvjestajPrihodiRashodiDlg(JFrame parent) {
		super(parent);
		btnPrikazi.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ispravniDatumi()) {
					double prihodi = 0.0, rashodi = 0.0;
					
					for (Uplacivanje uplacivanje : Administrator.svaUplacivanja) 
						if (uplacivanje.getDatum().isAfter(odabraniDatumOd) && uplacivanje.getDatum().isBefore(odabraniDatumDo)) {
							if (uplacivanje.getIznos() > 0)
								prihodi += uplacivanje.getIznos();
							else
								rashodi += uplacivanje.getIznos() * (-1);
						}
					
//					lblIzvjestaj.setText("<html> Rezultat za period " + txtDatumOd.getText() + " - " + txtDatumDo.getText() + " <br><br>" +
//							"Ukupni prihodi: " + prihodi + "<br>" + "Ukupni rashodi: " + rashodi + "<br>" +
//							"Bilans: " + String.format("%+.2f", (prihodi - rashodi)) + "</html>");
					
					lblIzvjestaj.setText(String.format("<html> Rezultat za period %s - %s <br><br>Ukupni prihodi: %.2f <br>Ukuphi rashodi: %.2f"
							+ "<br>Bilans: %.2f </html>", txtDatumOd.getText(), txtDatumDo.getText(), prihodi, rashodi, (prihodi - rashodi) ));
					
				}

					
			}
		});
	}
}
