package forme.izvjestaji;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.knowm.xchart.SwingWrapper;

import entiteti.Jezik;
import entiteti.Kurs;
import entiteti.osobe.Ucenik;
import forme.izvjestaji.chartovi.PieChartStringDouble;
import main.Podaci;

public class InteresovanjeUcenikaDlg extends JDialog {

	private static final long serialVersionUID = -3753852548630487552L;
	
	private JTextField txtDonjaGranica;
	private JTextField txtGornjaGranica;
	
	private JButton btnPrikazi;
	private JButton btnIzlaz;
	
	private int donjaGranica;
	private int gornjaGranica;
	private Map<String, Double> mapJeziciUcenici;
	

	
	public InteresovanjeUcenikaDlg(JFrame parent) {
		
		super(parent, "Interesovanje učenika");
		setSize(330, 230);
		setLocation(100, 100);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{136, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblDonjaGranica = new JLabel("Donja granica goidna: ");
		GridBagConstraints gbc_lblDonjaGranica = new GridBagConstraints();
		gbc_lblDonjaGranica.weightx = 0.3;
		gbc_lblDonjaGranica.anchor = GridBagConstraints.WEST;
		gbc_lblDonjaGranica.insets = new Insets(10, 10, 5, 5);
		gbc_lblDonjaGranica.gridx = 0;
		gbc_lblDonjaGranica.gridy = 0;
		panel.add(lblDonjaGranica, gbc_lblDonjaGranica);
		
		txtDonjaGranica = new JTextField();
		GridBagConstraints gbc_txtDonjaGranica = new GridBagConstraints();
		gbc_txtDonjaGranica.anchor = GridBagConstraints.EAST;
		gbc_txtDonjaGranica.weightx = 0.5;
		gbc_txtDonjaGranica.insets = new Insets(10, 0, 5, 10);
		gbc_txtDonjaGranica.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDonjaGranica.gridx = 1;
		gbc_txtDonjaGranica.gridy = 0;
		panel.add(txtDonjaGranica, gbc_txtDonjaGranica);
		txtDonjaGranica.setColumns(10);
		
		JLabel lblGornjaGranica = new JLabel("Gornja granica godina: ");
		GridBagConstraints gbc_lblGornjaGranica = new GridBagConstraints();
		gbc_lblGornjaGranica.anchor = GridBagConstraints.WEST;
		gbc_lblGornjaGranica.insets = new Insets(0, 10, 0, 5);
		gbc_lblGornjaGranica.gridx = 0;
		gbc_lblGornjaGranica.gridy = 1;
		panel.add(lblGornjaGranica, gbc_lblGornjaGranica);
		
		txtGornjaGranica = new JTextField();
		GridBagConstraints gbc_txtGornjaGranica = new GridBagConstraints();
		gbc_txtGornjaGranica.anchor = GridBagConstraints.EAST;
		gbc_txtGornjaGranica.insets = new Insets(0, 0, 0, 10);
		gbc_txtGornjaGranica.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGornjaGranica.gridx = 1;
		gbc_txtGornjaGranica.gridy = 1;
		panel.add(txtGornjaGranica, gbc_txtGornjaGranica);
		txtGornjaGranica.setColumns(10);
		
		
		JPanel dugmad = new JPanel();
		btnPrikazi = new JButton("Prikaži izvještaj");
		btnPrikazi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ispravanUnos()) {
					mapJeziciUcenici = new HashMap<String, Double>();
					for (Jezik jezik : Podaci.getPodaci().getJezikManager().getJezici())
							for (Kurs kurs : jezik.getKursevi())
								for (Ucenik ucenik : kurs.getUcenici())
									if (uklapaSeUGodine(ucenik.getDatumRodjenja())) {
										String key = jezik.getJezik();
										mapJeziciUcenici.put(key, (mapJeziciUcenici.containsKey(key) ? (mapJeziciUcenici.get(key) + 1) : 1 ));
									}
		
					PieChartStringDouble cart = new PieChartStringDouble(mapJeziciUcenici);
					Thread t = new Thread(new Runnable() {
	                    @SuppressWarnings({ "unchecked", "rawtypes" })
						@Override
	                    public void run() {
	                        new SwingWrapper(cart.getChart()).displayChart().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	                    }
	                });
	                t.start();
				}
			}
		});
		dugmad.add(btnPrikazi);
		
		btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnIzlaz);
		
		getContentPane().add(dugmad, BorderLayout.SOUTH);
		
	}
	
	
	
	
	protected boolean uklapaSeUGodine(LocalDate datumRodjenja) {
		int godine = LocalDate.now().compareTo(datumRodjenja);
		if (godine < gornjaGranica && godine > donjaGranica)
			return true;
		return false;
	}




	protected boolean ispravanUnos() {
		try {
			donjaGranica = Integer.parseInt(txtDonjaGranica.getText());
			gornjaGranica = Integer.parseInt(txtGornjaGranica.getText());
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Godine moraju biti cijeli brojevi", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}



	public static void main(String[] args) {
		new Podaci();
		new InteresovanjeUcenikaDlg(null).setVisible(true);
		
	}
	
	

	
	


	
}
