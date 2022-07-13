package forme;

//import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JPasswordField;

import entiteti.PojedinacanTest;
import entiteti.RezultatTesta;
import entiteti.TerminTesta;
import entiteti.Test;
import entiteti.osobe.Ucenik;
import main.Podaci;
import net.miginfocom.swing.MigLayout;

//import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import java.awt.GridBagConstraints;
//import java.awt.Insets;
import javax.swing.JTextField;

public class OcjenjivanjeTestaDlg extends JDialog {

	private static final long serialVersionUID = 3284961987041636458L;

	protected JPanel sadrzaj = new JPanel();
	protected JPanel dugmad = new JPanel();

	public OcjenjivanjeTestaDlg(JFrame parent, PojedinacanTest pojedinacanTest, List<PojedinacanTest> pojedinacniTestovi) {
		super(parent, "Ocjenjivanje testa", true);
		setSize(350, 230);
		setLocation(200, 200);

		MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[][]20[]");
		sadrzaj.setLayout(layout);

		JButton btnPotvrdi = new JButton("Potvrdi");
		JButton btnOdustani = new JButton("Odustani");
		JTextField txtBodovi = new JTextField(20);
		JTextField txtOcjena = new JTextField(20);


		sadrzaj.add(new JLabel("Osvojeno bodova: "));
		sadrzaj.add(txtBodovi);
		sadrzaj.add(new JLabel("Ocjena: "));
		sadrzaj.add(txtOcjena);
		sadrzaj.add(new JLabel());
		sadrzaj.add(btnPotvrdi, "split 2");
		sadrzaj.add(btnOdustani);

		btnPotvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bodoviStr = txtBodovi.getText();
				String ocjenaStr = txtOcjena.getText();
				if (bodoviStr.equals("") || ocjenaStr.equals(""))
					JOptionPane.showMessageDialog(null, "Niste popunili sve podatke.", "Neispravan unos",
							JOptionPane.WARNING_MESSAGE);
				else
					try {
						ocijeniTest();
					} catch (NumberFormatException ee) {
						JOptionPane.showMessageDialog(null, "Ocjena i bodovi moraju biti cijeli brojevi",
								"Neispravan unos", JOptionPane.WARNING_MESSAGE);
					}
			}

			
			
			
			private void ocijeniTest() throws NumberFormatException {
				int brBodova = Integer.parseInt(txtBodovi.getText());
				int ocjena = Integer.parseInt(txtOcjena.getText());
				if ( (ocjena < 5 || ocjena > 10) || (brBodova > pojedinacanTest.getTermin().getTest().getBrBodova() || brBodova < 0) ) {
					JOptionPane.showMessageDialog(null, "Ocjena moze biti od 5 do 10, a broj bodova od 0 do + " +
							pojedinacanTest.getTermin().getTest().getBrBodova(), "Neispravan unos", JOptionPane.WARNING_MESSAGE);
					return;
				}
				Test test = pojedinacanTest.getTermin().getTest();
				Ucenik ucenik = pojedinacanTest.getUcenik();
				TerminTesta termin = pojedinacanTest.getTermin();
				String id = String.format("%04d", Podaci.getPodaci().getRezultatTestaManager().getRezultati().size());
				RezultatTesta rezultat = new RezultatTesta(id, test, ucenik, termin, brBodova, ocjena);

				pojedinacanTest.getUcenik().getRezultati().add(rezultat);
				pojedinacanTest.setOcijenjen(true);
				pojedinacanTest.getTermin().getTest().getRezultati().add(rezultat);
				pojedinacanTest.getTermin().getKurs().getNeocijenjeniTestovi().remove(pojedinacanTest);
				pojedinacniTestovi.remove(pojedinacanTest);
				Podaci.getPodaci().getRezultatTestaManager().getRezultati().add(rezultat);
				Podaci.getPodaci().getRezultatTestaManager().getMapRezultati().put(id, rezultat);
				
				if (ocjena > 5) {
					pojedinacanTest.getUcenik().getPolozeniKursevi().add(pojedinacanTest.getTermin().getKurs());
					pojedinacanTest.getUcenik().getNepolozeniKursevi().remove(pojedinacanTest.getTermin().getKurs());
				}
				setVisible(false);
			}
		});

		btnOdustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		getContentPane().setLayout(new MigLayout());
		getContentPane().add(sadrzaj, "push, align center");

	}

}
