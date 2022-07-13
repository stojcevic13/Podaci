package TableFrame.kurs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entiteti.Kurs;
import model.KurseviModel;



public class KurseviTableFrame extends JFrame {

	private static final long serialVersionUID = -5304145253257485627L;
	
	public KurseviModel modelKursa;
	protected JTable tblKursevi;
	
	protected JPanel content = (JPanel) getContentPane();
	protected JPanel dugmad;
	
	protected JButton btnPostaviPredavace = new JButton("Postavi predavače");
	protected JButton btnObrisi = new JButton("Obriši");
	protected JButton btnKreiraj = new JButton("Kreiraj");
	

	public KurseviTableFrame(List<Kurs> kursevi) {

		modelKursa = new KurseviModel(kursevi);
		tblKursevi = new JTable(modelKursa);
		

		JScrollPane scroll = new JScrollPane(tblKursevi);
		tblKursevi.setAutoCreateRowSorter(true);
		content.add(scroll, BorderLayout.CENTER);

		dugmad = new JPanel();
		
		btnKreiraj.setVisible(false);
		btnPostaviPredavace.setVisible(false);
		btnObrisi.setVisible(false);
		
		dugmad.add(btnKreiraj);
		dugmad.add(btnPostaviPredavace);
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

		setTitle("Kursevi");
		setSize(600, 400);
		setLocation(100, 100);
	}
}
