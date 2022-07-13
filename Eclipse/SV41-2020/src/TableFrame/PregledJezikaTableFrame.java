package TableFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entiteti.Jezik;
import main.Podaci;
import model.JezikModel;

public class PregledJezikaTableFrame extends JFrame {

	private static final long serialVersionUID = 2456933994042188318L;
	
	public JezikModel modelJezika;
	protected JTable tblJezici;
	
	protected JPanel content = (JPanel) getContentPane();
	protected JPanel dugmad;
	
	protected JButton btnObrisi = new JButton("Obriši");
	protected JButton btnKreiraj = new JButton("Kreiraj");


	public PregledJezikaTableFrame(List<Jezik> jezici) {

		modelJezika = new JezikModel(jezici);
		tblJezici = new JTable(modelJezika);
		
		tblJezici.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tblJezici.getSelectedRow() != -1) {
					btnObrisi.setEnabled(true);
				} else {
					btnObrisi.setEnabled(false);
				}
			}
		});
		JScrollPane scroll = new JScrollPane(tblJezici);
		tblJezici.setAutoCreateRowSorter(true);
		content.add(scroll, BorderLayout.CENTER);

		dugmad = new JPanel();
		
		dugmad.add(btnKreiraj);
		btnKreiraj.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String naziv = JOptionPane.showInputDialog("Unesite novi jezik: ");
				if (naziv != null) {
					Jezik jezik = new Jezik(naziv, true);
					Podaci.getPodaci().getJezikManager().getJezici().add(jezik);
					Podaci.getPodaci().getJezikManager().getMapJezici().put(naziv, jezik);
					JOptionPane.showMessageDialog(null, "Uspješno ste kreirali novi jezik", "Uspješno obavljen posao", JOptionPane.PLAIN_MESSAGE);
					modelJezika.fireTableDataChanged();
				}
			}
		});
		dugmad.add(btnObrisi);
		btnObrisi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Da li želite da obrišete jezik?", "Potvrda brisanja",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					
					int index = tblJezici.getSelectedRow();
					int sortIndex = tblJezici.convertRowIndexToModel(index);
					Jezik odabraniJezik = Podaci.getPodaci().getJezikManager().getJezici().get(sortIndex);
					odabraniJezik.setAktivan(false);
					jezici.remove(odabraniJezik);
					modelJezika.fireTableDataChanged();
				}

			}
		});



		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnZatvori);

		content.add(dugmad, BorderLayout.SOUTH);

		setTitle("Jezici");
		setSize(600, 400);
		setLocation(100, 100);
	}

}
