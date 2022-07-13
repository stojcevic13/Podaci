package forme;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entiteti.Kurs;
import entiteti.TerminTesta;
import entiteti.osobe.Ucenik;
import main.Podaci;

public class PrijavljivanjeUcenikaNaTerminDlg extends JDialog{

	private static final long serialVersionUID = -1545671698569329722L;
	
	private JComboBox<Ucenik> comboBoxUcenici;
	private JComboBox<TerminTesta> comboBoxTermini;
	
	private Ucenik odabraniUcenik;
	private TerminTesta odabraniTermin;

	private JButton btnSnimi;

	private JButton btnIzlaz;
	
	public PrijavljivanjeUcenikaNaTerminDlg(JFrame parent) {
		super(parent, "Kreiranje Termina", true);
		setSize(450, 300);
		setLocation(100, 100);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblOdaberiUcenika = new JLabel("Odaberite učenika:");
		GridBagConstraints gbc_lblOdaberiUcenika = new GridBagConstraints();
		gbc_lblOdaberiUcenika.insets = new Insets(10, 0, 5, 0);
		gbc_lblOdaberiUcenika.gridx = 0;
		gbc_lblOdaberiUcenika.gridy = 0;
		panel.add(lblOdaberiUcenika, gbc_lblOdaberiUcenika);
		
		comboBoxUcenici = new JComboBox<Ucenik>();
		for (Ucenik uc : Podaci.getPodaci().getUcenikManager().getUcenici())
			if (uc.isAktivan())
				comboBoxUcenici.addItem(uc);
		comboBoxUcenici.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				odabraniUcenik = (Ucenik) comboBoxUcenici.getSelectedItem();
				comboBoxTermini.setEnabled(true);
				comboBoxTermini.removeAllItems();
				for (Kurs k : odabraniUcenik.getNepolozeniKursevi())
					for (TerminTesta tt : k.getDostupniTermini())
						if (!odabraniUcenik.getTermini().contains(tt))
							comboBoxTermini.addItem(tt);
			}
		});
		GridBagConstraints gbc_comboBoxUcenici = new GridBagConstraints();
		gbc_comboBoxUcenici.insets = new Insets(0, 10, 5, 10);
		gbc_comboBoxUcenici.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxUcenici.gridx = 0;
		gbc_comboBoxUcenici.gridy = 1;
		panel.add(comboBoxUcenici, gbc_comboBoxUcenici);
		
		JLabel lblOdaberiTermin = new JLabel("Odaberite termin:");
		GridBagConstraints gbc_lblOdaberiTermin = new GridBagConstraints();
		gbc_lblOdaberiTermin.insets = new Insets(10, 10, 5, 10);
		gbc_lblOdaberiTermin.gridx = 0;
		gbc_lblOdaberiTermin.gridy = 2;
		panel.add(lblOdaberiTermin, gbc_lblOdaberiTermin);
		
		comboBoxTermini = new JComboBox<TerminTesta>();
		comboBoxTermini.setEnabled(false);
		GridBagConstraints gbc_comboBoxTermini = new GridBagConstraints();
		gbc_comboBoxTermini.insets = new Insets(0, 10, 0, 10);
		gbc_comboBoxTermini.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTermini.gridx = 0;
		gbc_comboBoxTermini.gridy = 3;
		panel.add(comboBoxTermini, gbc_comboBoxTermini);
		
		
		JPanel dugmad = new JPanel();
		btnSnimi = new JButton("Snimi");
		btnSnimi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Da li želite da potvrdite prijavu?", "Potvrda prijave",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					
					odabraniTermin = (TerminTesta) comboBoxTermini.getSelectedItem();
					
					odabraniUcenik.getTermini().add(odabraniTermin);
					for (TerminTesta t : odabraniUcenik.getTermini())
						if (t.getKurs().getId() == odabraniTermin.getId()) {  // AKO JE VEC POLAGAO TAJ KURS
							odabraniUcenik.platiPolaganjeKursa(odabraniTermin.getKurs());
							break;
						}
					odabraniTermin.getUcenici().add(odabraniUcenik);
					
					JOptionPane.showMessageDialog(null, "Prijavili ste učenika na termin", "Uspješna prijava", JOptionPane.PLAIN_MESSAGE);

				}
			}
		});
		
		btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnSnimi);
		dugmad.add(btnIzlaz);
		
		getContentPane().add(dugmad, BorderLayout.SOUTH);
	}
	
	

}
