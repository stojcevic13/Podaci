package TableFrame.test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entiteti.RezultatTesta;
import entiteti.Test;
import model.RezultatiModel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StampanjeRezultataTableFrame extends JFrame {

	private static final long serialVersionUID = -7231310676867232884L;
	
	private JPanel content = (JPanel) getContentPane();
	private JPanel dugmad;
	
	private RezultatiModel rezultatiModel;
	private JTable tblRezultati;
	
	public StampanjeRezultataTableFrame(Test test) {
		setTitle("Izvjestaj Rezultata");
		setSize(600, 400);
		setLocation(200, 200);
		
		rezultatiModel = new RezultatiModel(test.getRezultati());
		tblRezultati = new JTable(rezultatiModel);
		
		String pitanja = "";
		for (String pitanje : test.getPitanja())
			pitanja = pitanja.concat(pitanje + "<br>");
		pitanja = pitanja.concat("</html>");
		
		double sumaBodova = 0, sumaOcjena = 0;
		for (RezultatTesta rezultat : test.getRezultati()) {
			sumaBodova += rezultat.getOsvojenoBodova();
			sumaOcjena += rezultat.getOcjena();
		}
		double prosjekBodova = sumaBodova*1.0 / test.getRezultati().size();
		double prosjekOcjena = sumaOcjena*1.0 / test.getRezultati().size();
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{30, 15, 15, 15, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblPodaciOTestu = new JLabel("Podaci o testu");
		GridBagConstraints gbc_lblPodaciOTestu = new GridBagConstraints();
		gbc_lblPodaciOTestu.gridwidth = 2;
		gbc_lblPodaciOTestu.insets = new Insets(0, 0, 5, 0);
		gbc_lblPodaciOTestu.gridx = 0;
		gbc_lblPodaciOTestu.gridy = 0;
		panel.add(lblPodaciOTestu, gbc_lblPodaciOTestu);
		
		JLabel lblPitanja = new JLabel("Pitanja:");
		GridBagConstraints gbc_lblPitanja = new GridBagConstraints();
		gbc_lblPitanja.ipady = 15;
		gbc_lblPitanja.weightx = 0.5;
		gbc_lblPitanja.insets = new Insets(0, 0, 5, 5);
		gbc_lblPitanja.gridx = 0;
		gbc_lblPitanja.gridy = 1;
		panel.add(lblPitanja, gbc_lblPitanja);
		
		JLabel lblOpis = new JLabel("Opis: " + test.getOpis());
		GridBagConstraints gbc_lblOpis = new GridBagConstraints();
		gbc_lblOpis.ipady = 15;
		gbc_lblOpis.weightx = 0.5;
		gbc_lblOpis.insets = new Insets(0, 0, 5, 0);
		gbc_lblOpis.gridx = 1;
		gbc_lblOpis.gridy = 1;
		panel.add(lblOpis, gbc_lblOpis);
		
		JLabel lblListaPitanja = new JLabel("<html>Lista pitanja: <br>" + pitanja);
		GridBagConstraints gbc_lblListaPitanja = new GridBagConstraints();
		gbc_lblListaPitanja.gridheight = 3;
		gbc_lblListaPitanja.insets = new Insets(0, 0, 5, 5);
		gbc_lblListaPitanja.gridx = 0;
		gbc_lblListaPitanja.gridy = 2;
		panel.add(lblListaPitanja, gbc_lblListaPitanja);
		
		JLabel lblJezik = new JLabel("Jezik: " + test.getJezik().getJezik());
		GridBagConstraints gbc_lblJezik = new GridBagConstraints();
		gbc_lblJezik.ipady = 15;
		gbc_lblJezik.insets = new Insets(0, 0, 5, 0);
		gbc_lblJezik.gridx = 1;
		gbc_lblJezik.gridy = 2;
		panel.add(lblJezik, gbc_lblJezik);
		
		JLabel lblMaksBodova = new JLabel("Maksimalno bodova: " + test.getBrBodova());
		GridBagConstraints gbc_lblMaksBodova = new GridBagConstraints();
		gbc_lblMaksBodova.ipady = 15;
		gbc_lblMaksBodova.insets = new Insets(0, 0, 5, 0);
		gbc_lblMaksBodova.gridx = 1;
		gbc_lblMaksBodova.gridy = 3;
		panel.add(lblMaksBodova, gbc_lblMaksBodova);
		
		JLabel lblProsjekOcjena = new JLabel("Prosječna ocjena: " + prosjekOcjena);
		GridBagConstraints gbc_lblProsjekOcjena = new GridBagConstraints();
		gbc_lblProsjekOcjena.insets = new Insets(0, 0, 5, 0);
		gbc_lblProsjekOcjena.ipady = 15;
		gbc_lblProsjekOcjena.gridx = 1;
		gbc_lblProsjekOcjena.gridy = 4;
		panel.add(lblProsjekOcjena, gbc_lblProsjekOcjena);
		
		JLabel lblProsjekBodova = new JLabel("Prosjek bodova: " + prosjekBodova);
		GridBagConstraints gbc_lblProsjekBodova = new GridBagConstraints();
		gbc_lblProsjekBodova.ipady = 15;
		gbc_lblProsjekBodova.insets = new Insets(0, 0, 0, 5);
		gbc_lblProsjekBodova.gridx = 1;
		gbc_lblProsjekBodova.gridy = 5;
		panel.add(lblProsjekBodova, gbc_lblProsjekBodova);
		
		JScrollPane scroll = new JScrollPane(tblRezultati);
		tblRezultati.setAutoCreateRowSorter(true);
		content.add(scroll, BorderLayout.CENTER);
		
		dugmad = new JPanel();
		
		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnZatvori);

		content.add(dugmad, BorderLayout.SOUTH);
		
	}
	

}
