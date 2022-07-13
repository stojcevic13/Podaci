package TableFrame.kurs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entiteti.Zahtjev;
import entiteti.Zahtjev.Stanje;
import entiteti.interfejsi.ImaZahtjeve;
import entiteti.osobe.Sekretar;
import forme.KreiranjeZahtjevaDlg;
import main.Podaci;
import model.ZahtjeviModel;

public class ZahtjeviTableFrame extends JFrame {

	private static final long serialVersionUID = 4881695313924808357L;
	
	private ImaZahtjeve obradjivac;
	private List<Zahtjev> zahtjevi;

	public ZahtjeviModel modelZahtjeva;
	
	protected JTable tblZahtjevi;
	protected JPanel dugmad;
	protected JPanel content = (JPanel) getContentPane();
	
	private JButton btnPrihvati;
	private JButton btnOdbij;
	private JButton btnKreiraj;

	private KreiranjeZahtjevaDlg kreiranjeZahtjevaDlg;

	public ZahtjeviTableFrame(ImaZahtjeve obradjivac, List<Zahtjev> zahtjevi) {
		this.obradjivac = obradjivac;
		this.zahtjevi = zahtjevi;
		this.kreiranjeZahtjevaDlg = new KreiranjeZahtjevaDlg(ZahtjeviTableFrame.this);

		modelZahtjeva = new ZahtjeviModel(zahtjevi);
		tblZahtjevi = new JTable(modelZahtjeva);
		
		btnPrihvati = new JButton("Prihvati");
		btnOdbij = new JButton("Odbij");
		btnKreiraj = new JButton("Kreiraj zahtjev");
		
		btnPrihvati.setEnabled(false);
		btnOdbij.setEnabled(false);
		tblZahtjevi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tblZahtjevi.getSelectedRow() != -1) {
					btnPrihvati.setEnabled(true);
					btnOdbij.setEnabled(true);
				} else {
					btnPrihvati.setEnabled(false);
					btnOdbij.setEnabled(false);
				}
			}
		});
		
		
		JScrollPane scroll = new JScrollPane(tblZahtjevi);
		tblZahtjevi.setAutoCreateRowSorter(true);
		content.add(scroll, BorderLayout.CENTER);

		dugmad = new JPanel();


		btnKreiraj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				kreiranjeZahtjevaDlg.setVisible(true);
				modelZahtjeva.fireTableDataChanged();
			}
		});
		dugmad.add(btnKreiraj);


		btnPrihvati.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Da li želite da prihvatite zahtjev?", "Potvrda prihvatanja",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION)
				obradiZahtjev(Stanje.PRIHVACEN);
			}
		});
		dugmad.add(btnPrihvati);


		btnOdbij.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Da li želite da odbijete zahtjev?", "Potvrda odbijanja",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION);
				obradiZahtjev(Stanje.ODBIJEN);
			}
		});
		dugmad.add(btnOdbij);

		
		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnZatvori);
		
		

		content.add(dugmad, BorderLayout.SOUTH);

		setTitle("Testovi");
		setSize(600, 400);
		setLocation(100, 100);
	}

	protected void obradiZahtjev(Stanje stanje) {
		int index = tblZahtjevi.getSelectedRow();
		int indexSort = tblZahtjevi.convertRowIndexToModel(index);
		Zahtjev zahtjev = zahtjevi.get(indexSort);
		
		zahtjev.setStanje(stanje);
		zahtjev.setDatumObrade(LocalDate.now());
		zahtjev.setObradjivac(obradjivac);
		
		if (stanje.equals(Stanje.PRIHVACEN)) {
			zahtjev.getKurs().getUcenici().add(zahtjev.getUcenik());
			zahtjev.getUcenik().getNepolozeniKursevi().add(zahtjev.getKurs());
			zahtjev.getUcenik().uplatiKurs(zahtjev.getKurs());
		}
		
		obradjivac.getObradjeniZahtjevi().add(zahtjev);
		Sekretar.getNeobradjeniZahtjevi().remove(zahtjev);
		Podaci.getPodaci().getZahtjevManager().getNeobradjeniZahtjevi().remove(zahtjev);
		Podaci.getPodaci().getZahtjevManager().getObradjeniZahtjevi().add(zahtjev);
		
		
		modelZahtjeva.fireTableDataChanged();
	}
}
