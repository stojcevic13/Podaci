package forme;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entiteti.Jezik;
import entiteti.Kurs;
import entiteti.Test;
import entiteti.osobe.Predavac;
//import kss.model.Klub;
import main.Podaci;

public class KreiranjeTestaDlg extends JDialog {

	private static final long serialVersionUID = 8312624912062822148L;
	
	private JTextField txtOpis;
	private JTextField txtBodovi;
	private JComboBox<Jezik> comboBoxJezik;
	private JTextArea textArea;
	
	private JButton btnSnimi;
	private JButton btnOdustani;
	
	private JPanel podaci;
	private JPanel dugmad;
	
	private boolean nov;
	private Test test;
	private JLabel lblKurs;
	private JComboBox<Kurs> comboBoxKurs;

	public KreiranjeTestaDlg(JFrame parent, Predavac predavac) {
		super(parent, "Podaci o testu", true);
		
		podaci = new JPanel();
		dugmad = new JPanel();
		
		
		setSize(606, 500);
		setLocation(200, 200);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{131, 382, 0};
		gridBagLayout.rowHeights = new int[]{40, 40, 40, 40, 32, 20, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		podaci.setLayout(gridBagLayout);
		
		JLabel lblJezik = new JLabel("Jezik: ");
		GridBagConstraints gbc_lblJezik = new GridBagConstraints();
		gbc_lblJezik.insets = new Insets(0, 10, 5, 5);
		gbc_lblJezik.anchor = GridBagConstraints.WEST;
		gbc_lblJezik.gridx = 0;
		gbc_lblJezik.gridy = 0;
		podaci.add(lblJezik, gbc_lblJezik);
		
		comboBoxJezik = new JComboBox<Jezik>();
		for (Jezik jez : predavac.getObuceniJezici())
			comboBoxJezik.addItem(jez);
		comboBoxJezik.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Jezik jez = (Jezik) comboBoxJezik.getSelectedItem();
				
				comboBoxKurs.setEnabled(true);
				comboBoxKurs.removeAllItems();
				for (Kurs k : jez.getKursevi())
					comboBoxKurs.addItem(k);
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.weightx = 20.0;
		gbc_comboBox.insets = new Insets(0, 0, 5, 10);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		podaci.add(comboBoxJezik, gbc_comboBox);
		
		lblKurs = new JLabel("Kurs: ");
		GridBagConstraints gbc_lblKurs = new GridBagConstraints();
		gbc_lblKurs.anchor = GridBagConstraints.WEST;
		gbc_lblKurs.insets = new Insets(0, 10, 5, 5);
		gbc_lblKurs.gridx = 0;
		gbc_lblKurs.gridy = 1;
		podaci.add(lblKurs, gbc_lblKurs);
		
		comboBoxKurs = new JComboBox<Kurs>();
		comboBoxKurs.setEnabled(false);
		GridBagConstraints gbc_comboBoxKurs = new GridBagConstraints();
		gbc_comboBoxKurs.insets = new Insets(0, 0, 5, 10);
		gbc_comboBoxKurs.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxKurs.gridx = 1;
		gbc_comboBoxKurs.gridy = 1;
		podaci.add(comboBoxKurs, gbc_comboBoxKurs);
		
		JLabel lblOpis = new JLabel("Kratak opis: ");
		GridBagConstraints gbc_lblOpis = new GridBagConstraints();
		gbc_lblOpis.anchor = GridBagConstraints.WEST;
		gbc_lblOpis.insets = new Insets(0, 10, 5, 5);
		gbc_lblOpis.gridx = 0;
		gbc_lblOpis.gridy = 2;
		podaci.add(lblOpis, gbc_lblOpis);
		
		txtOpis = new JTextField();
		GridBagConstraints gbc_txtOpis = new GridBagConstraints();
		gbc_txtOpis.insets = new Insets(0, 0, 5, 10);
		gbc_txtOpis.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOpis.gridx = 1;
		gbc_txtOpis.gridy = 2;
		podaci.add(txtOpis, gbc_txtOpis);
		txtOpis.setColumns(10);
		
		JLabel lblMaksimalnoBodova = new JLabel("Maksimalno bodova: ");
		GridBagConstraints gbc_lblMaksimalnoBodova = new GridBagConstraints();
		gbc_lblMaksimalnoBodova.anchor = GridBagConstraints.WEST;
		gbc_lblMaksimalnoBodova.insets = new Insets(0, 10, 5, 5);
		gbc_lblMaksimalnoBodova.gridx = 0;
		gbc_lblMaksimalnoBodova.gridy = 3;
		podaci.add(lblMaksimalnoBodova, gbc_lblMaksimalnoBodova);
		
		txtBodovi = new JTextField();
		GridBagConstraints gbc_txtBodovi = new GridBagConstraints();
		gbc_txtBodovi.insets = new Insets(0, 0, 5, 10);
		gbc_txtBodovi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBodovi.gridx = 1;
		gbc_txtBodovi.gridy = 3;
		podaci.add(txtBodovi, gbc_txtBodovi);
		txtBodovi.setColumns(10);
		
		JLabel lblPitanja = new JLabel("Pitanja: ");
		GridBagConstraints gbc_lblPitanja = new GridBagConstraints();
		gbc_lblPitanja.insets = new Insets(0, 0, 5, 0);
		gbc_lblPitanja.gridwidth = 2;
		gbc_lblPitanja.gridx = 0;
		gbc_lblPitanja.gridy = 4;
		podaci.add(lblPitanja, gbc_lblPitanja);
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.weighty = 20.0;
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 10, 0, 10);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 5;
		podaci.add(textArea, gbc_textArea);
		
		btnSnimi = new JButton("Snimi");
//		GridBagConstraints gbc_btnKreiraj = new GridBagConstraints();
//		gbc_btnKreiraj.ipadx = 20;
//		gbc_btnKreiraj.ipady = 5;
//		gbc_btnKreiraj.insets = new Insets(0, 0, 5, 0);
//		gbc_btnKreiraj.gridwidth = 2;
//		gbc_btnKreiraj.gridx = 0;
//		gbc_btnKreiraj.gridy = 5;
		btnSnimi.setPreferredSize(new Dimension(80, 25));
		dugmad.add(btnSnimi);
		
		getContentPane().add(podaci, BorderLayout.CENTER);
		getContentPane().add(dugmad, BorderLayout.SOUTH);

		btnSnimi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ispravanUnos()) {
					
					Jezik jezik = (Jezik) comboBoxJezik.getSelectedItem();
					Kurs kurs = (Kurs) comboBoxKurs.getSelectedItem();
					test.setOpis(txtOpis.getText());
					test.setBrBodova(Integer.parseInt(txtBodovi.getText()));
					test.setJezik(jezik);
					test.setKurs(kurs);
					String[] s = textArea.getText().split("\n");
					List<String> pitanja = new ArrayList<String>();
					for (String pitanje : s) 
						if (!pitanje.trim().equals(""))
							pitanja.add(pitanje);
					test.setPitanja(pitanja);
					
					if (nov) {
						jezik.getTestovi().add(test);
						kurs.getTestovi().add(test);
						predavac.getTestovi().add(test);
						String id = String.format("%04d", Podaci.getPodaci().getTestManager().getTestovi().size());
						test.setId(id);
						test.setPredavacKreator(predavac);
						Podaci.getPodaci().getTestManager().getTestovi().add(test);
						Podaci.getPodaci().getTestManager().getMapTestovi().put(id, test);
						JOptionPane.showMessageDialog(null, "Uspješno ste kreirali test", "Uspješno kreiran test", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Uspješno ste izmijenili test", "Uspješno izmijenjen test", JOptionPane.PLAIN_MESSAGE);
					}
					setVisible(false);

				}
			}
		});
		
		
		btnOdustani = new JButton("Odustani");
		btnOdustani.setPreferredSize(new Dimension(80, 25));
		btnOdustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnOdustani);		
		
	}
	
	
	
	protected boolean ispravanUnos() {
		if (txtOpis.getText().equals("") || txtBodovi.getText().equals("") || textArea.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Morate popuniti sve podatke", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		try {
			Integer.parseInt(txtBodovi.getText());	
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Broj bodova mora da bude cijeli broj.", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	
	public void setTest(Test test, boolean nov) {
		this.nov = nov;
		
		this.test = test;
		this.txtOpis.setText(test.getOpis());
		this.txtBodovi.setText("" + test.getBrBodova());
		this.comboBoxJezik.setSelectedItem(test.getJezik());
		String pitanja = "";
		for (String pitanje : test.getPitanja())
			pitanja = pitanja.concat(pitanje + "\n");
		this.textArea.setText(pitanja);
	}




}
