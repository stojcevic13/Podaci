package TableFrame.osobe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entiteti.osobe.Sekretar;
import model.osobe.SekretarModel;

public class SekretariTableFrame extends JFrame {

	private static final long serialVersionUID = 8388186705336784875L;
	
	public SekretarModel modelSekretara;
	protected JTable tblSekretari;
	
	protected JPanel content = (JPanel) getContentPane();
	protected JPanel dugmad;
	
	protected JButton btnObrisi = new JButton("Obriši");
	protected JButton btnRegistracija = new JButton("Registracija");
	protected JButton btnIzmjena = new JButton("Izmjena");
	protected JButton btnIzvjestaj = new JButton("Izvještaj");


	public SekretariTableFrame(List<Sekretar> sekretari) {

		modelSekretara = new SekretarModel(sekretari);
		tblSekretari = new JTable(modelSekretara);
		

		JScrollPane scroll = new JScrollPane(tblSekretari);
		tblSekretari.setAutoCreateRowSorter(true);
		content.add(scroll, BorderLayout.CENTER);

		dugmad = new JPanel();
		
		btnRegistracija.setVisible(false);
		btnIzmjena.setVisible(false);
		btnIzvjestaj.setVisible(false);
		btnObrisi.setVisible(false);
		
		dugmad.add(btnRegistracija);
		dugmad.add(btnIzmjena);
		dugmad.add(btnIzvjestaj);
		dugmad.add(btnObrisi);

		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnZatvori);

		content.add(dugmad, BorderLayout.SOUTH);

		setTitle("Sekretari");
		setSize(700, 400);
		setLocation(100, 100);
	}
}
