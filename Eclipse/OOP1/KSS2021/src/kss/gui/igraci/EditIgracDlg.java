package kss.gui.igraci;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kss.manager.ManagerKlub;
import kss.model.Igrac;
import kss.model.Klub;

public class EditIgracDlg extends JDialog {

	private static final long serialVersionUID = 7728457178687575633L;
	
	private JPanel content = (JPanel) getContentPane();
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JComboBox<Klub> comboBox;

	private ManagerKlub mk;

	private Igrac igrac;

	private boolean nov;

	private boolean odustao;

	public EditIgracDlg(FrmIgraci parent, ManagerKlub mk) {
		super(parent, "Podaci o igracu", true);
		this.mk = mk;
		setTitle("Izmjena igraca");
		setSize(503, 354);
		setLocation(200, 200);
		
		
		
		
	
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblIme = new JLabel("Ime: ");
		GridBagConstraints gbc_lblIme = new GridBagConstraints();
		gbc_lblIme.anchor = GridBagConstraints.EAST;
		gbc_lblIme.insets = new Insets(0, 0, 5, 5);
		gbc_lblIme.gridx = 0;
		gbc_lblIme.gridy = 0;
		panel.add(lblIme, gbc_lblIme);
		
		txtIme = new JTextField();
		GridBagConstraints gbc_txtIme = new GridBagConstraints();
		gbc_txtIme.insets = new Insets(0, 0, 5, 0);
		gbc_txtIme.weightx = 2.0;
		gbc_txtIme.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIme.gridx = 1;
		gbc_txtIme.gridy = 0;
		panel.add(txtIme, gbc_txtIme);
		txtIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime: ");
		GridBagConstraints gbc_lblPrezime = new GridBagConstraints();
		gbc_lblPrezime.anchor = GridBagConstraints.EAST;
		gbc_lblPrezime.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezime.gridx = 0;
		gbc_lblPrezime.gridy = 1;
		panel.add(lblPrezime, gbc_lblPrezime);
		
		txtPrezime = new JTextField();
		GridBagConstraints gbc_txtPrezime = new GridBagConstraints();
		gbc_txtPrezime.insets = new Insets(0, 0, 5, 0);
		gbc_txtPrezime.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrezime.gridx = 1;
		gbc_txtPrezime.gridy = 1;
		panel.add(txtPrezime, gbc_txtPrezime);
		txtPrezime.setColumns(10);
		
		JLabel lblKlub = new JLabel("Klub: ");
		GridBagConstraints gbc_lblKlub = new GridBagConstraints();
		gbc_lblKlub.anchor = GridBagConstraints.EAST;
		gbc_lblKlub.insets = new Insets(0, 0, 0, 5);
		gbc_lblKlub.gridx = 0;
		gbc_lblKlub.gridy = 2;
		panel.add(lblKlub, gbc_lblKlub);
		
		comboBox = new JComboBox<Klub>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		panel.add(comboBox, gbc_comboBox);
		
		for (Klub k : this.mk.getKlubovi()) {
			comboBox.addItem(k);
		}
		
		
		
		
		JPanel dugmad = new JPanel();
		
		JButton btnSnimi = new JButton("Snimi");
		btnSnimi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (nov) {
					igrac.setIme(txtIme.getText());
					igrac.setPrezime(txtPrezime.getText());
					Klub k = (Klub) comboBox.getSelectedItem();
					igrac.setKlub(k);
					k.getIgraci().add(igrac);
					odustao = false;
					setVisible(false);
				} else {
					igrac.setIme(txtIme.getText());
					igrac.setPrezime(txtPrezime.getText());
					Klub k = (Klub) comboBox.getSelectedItem();
					igrac.getKlub().getIgraci().remove(igrac);
					igrac.setKlub(k);
					k.getIgraci().add(igrac);
					setVisible(false);
				}

				
			}
		});
		dugmad.add(btnSnimi);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnOdustani);
		content.add(dugmad, BorderLayout.SOUTH);


	}

	public void setIgrac(Igrac i, boolean nov) {
		this.nov = nov;
		this.odustao = true;
		
		this.igrac = i;
		this.txtIme.setText(i.getIme());
		this.txtPrezime.setText(i.getPrezime());
		this.comboBox.setSelectedItem(i.getKlub());
	}
	
	public boolean isOdustao() {
		return this.odustao;
	}
	
}
