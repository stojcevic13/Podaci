package forme.izvjestaji;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.knowm.xchart.SwingWrapper;

import entiteti.Kurs;
import entiteti.RezultatTesta;
import entiteti.Test;
import forme.izvjestaji.chartovi.XYChartIntegerDouble;
import main.Podaci;

public class IzvjestajRezultataKursevaXY extends JDialog {
	
	private static final long serialVersionUID = 2824928211434599450L;
	
	private List<Integer> redBr;
	private List<Double> rezultati;
	
	private JComboBox<Kurs> cmbKurs;

	public IzvjestajRezultataKursevaXY(JFrame parent) {
		super(parent, "Rezultati kurseva", true);
		setSize(300, 200);
		setLocation(100, 100);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{248, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblOdaberiKurs = new JLabel("Odaberite kurs: ");
		GridBagConstraints gbc_lblOdaberiKurs = new GridBagConstraints();
		gbc_lblOdaberiKurs.weightx = 1.0;
		gbc_lblOdaberiKurs.insets = new Insets(10, 0, 5, 0);
		gbc_lblOdaberiKurs.gridx = 0;
		gbc_lblOdaberiKurs.gridy = 0;
		panel.add(lblOdaberiKurs, gbc_lblOdaberiKurs);
		
		cmbKurs = new JComboBox<Kurs>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.weightx = 1.0;
		gbc_comboBox.insets = new Insets(0, 10, 0, 10);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		panel.add(cmbKurs, gbc_comboBox);
		for (Kurs k : Podaci.getPodaci().getKursManager().getKursevi())
			if (k.isAktivan())
				cmbKurs.addItem(k);
		
		
		JPanel dugmad = new JPanel();
		JButton btnPrikaziIzvjestaj = new JButton("Prikaži izvještaj");
		btnPrikaziIzvjestaj.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				redBr = new ArrayList<Integer>();
				rezultati = new ArrayList<Double>();
				Kurs odabraniKurs = (Kurs) cmbKurs.getSelectedItem();
				napraviListe(odabraniKurs);
				if (redBr.size() > 0) {
					XYChartIntegerDouble cart = new XYChartIntegerDouble(redBr, rezultati);
					prikaziChart(cart);
				} else
					JOptionPane.showMessageDialog(null, "Nema ucenika koji su polagali ovaj kurs", "Obavjestenje", JOptionPane.PLAIN_MESSAGE);

				setVisible(false);
			}
		});
		dugmad.add(btnPrikaziIzvjestaj);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});	
		dugmad.add(btnIzlaz);
		getContentPane().add(dugmad, BorderLayout.SOUTH);

	}

	
	
	protected void prikaziChart(XYChartIntegerDouble cart) {
		Thread t = new Thread(new Runnable() {
            @SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
            public void run() {
                new SwingWrapper(cart.getChart()).displayChart().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        });
        t.start();
	}



	protected void napraviListe(Kurs odabraniKurs) {
		int i = 0;
		for (Test t : odabraniKurs.getTestovi())
			for (RezultatTesta rez : t.getRezultati()) {
				i += 1;
				redBr.add(i);
				rezultati.add(rez.getOcjena() * 1.0 );
			}
	}





}
