package forme.izvjestaji;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class IzvjestajBazaDlg extends JDialog {

	private static final long serialVersionUID = 61252179013601396L;
	
	protected JPanel panel;
	
	protected JTextField txtDatumOd;
	protected JTextField txtDatumDo;
	protected JLabel lblIzvjestaj;
	protected JButton btnPrikazi;
	protected JButton btnIzlaz;
	
	protected LocalDate odabraniDatumOd;
	protected LocalDate odabraniDatumDo;
	
	public IzvjestajBazaDlg(JFrame parent) {
		
		super(parent, "Izvještaj rada", true);
		setSize(400, 250);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{111, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblDatumOd = new JLabel("Od kog datuma: ");
		GridBagConstraints gbc_lblDatumOd = new GridBagConstraints();
		gbc_lblDatumOd.insets = new Insets(10, 0, 5, 5);
		gbc_lblDatumOd.anchor = GridBagConstraints.EAST;
		gbc_lblDatumOd.gridx = 0;
		gbc_lblDatumOd.gridy = 0;
		panel.add(lblDatumOd, gbc_lblDatumOd);
		
		txtDatumOd = new JTextField();
		GridBagConstraints gbc_txtDatumOd = new GridBagConstraints();
		gbc_txtDatumOd.insets = new Insets(10, 0, 5, 10);
		gbc_txtDatumOd.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDatumOd.gridx = 1;
		gbc_txtDatumOd.gridy = 0;
		panel.add(txtDatumOd, gbc_txtDatumOd);
		txtDatumOd.setColumns(10);
		
		JLabel lblDatumDo = new JLabel("Do kog datuma: ");
		GridBagConstraints gbc_lblDatumDo = new GridBagConstraints();
		gbc_lblDatumDo.anchor = GridBagConstraints.EAST;
		gbc_lblDatumDo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatumDo.gridx = 0;
		gbc_lblDatumDo.gridy = 1;
		panel.add(lblDatumDo, gbc_lblDatumDo);
		
		txtDatumDo = new JTextField();
		GridBagConstraints gbc_txtDatumDo = new GridBagConstraints();
		gbc_txtDatumDo.insets = new Insets(0, 0, 5, 10);
		gbc_txtDatumDo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDatumDo.gridx = 1;
		gbc_txtDatumDo.gridy = 1;
		panel.add(txtDatumDo, gbc_txtDatumDo);
		txtDatumDo.setColumns(10);
		
		lblIzvjestaj = new JLabel("Izvještaj");
		GridBagConstraints gbc_lblIzvjestaj = new GridBagConstraints();
		gbc_lblIzvjestaj.gridwidth = 2;
		gbc_lblIzvjestaj.insets = new Insets(10, 0, 0, 5);
		gbc_lblIzvjestaj.gridx = 0;
		gbc_lblIzvjestaj.gridy = 2;
		panel.add(lblIzvjestaj, gbc_lblIzvjestaj);
		
		JPanel dugmad = new JPanel();
		btnPrikazi = new JButton("Prikaži izvještaj");
		btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		dugmad.add(btnPrikazi);
		dugmad.add(btnIzlaz);
		getContentPane().add(dugmad, BorderLayout.SOUTH);
		
		

	}
	

	protected boolean ispravniDatumi() {
		try {
			odabraniDatumOd = LocalDate.parse(txtDatumOd.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
			odabraniDatumDo = LocalDate.parse(txtDatumDo.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
			return true;
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, "Unesite datume u formatu: dd.MM.yyyy", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
}
