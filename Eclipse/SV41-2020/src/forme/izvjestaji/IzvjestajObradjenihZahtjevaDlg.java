package forme.izvjestaji;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entiteti.Jezik;
import entiteti.Zahtjev;
import main.Podaci;
import model.ZahtjeviModel;
import java.awt.GridBagLayout;

public class IzvjestajObradjenihZahtjevaDlg extends IzvjestajBazaDlg {

	private static final long serialVersionUID = -8234069825881934490L;
	
	private List<JCheckBox> jezici;
	private List<Jezik> odabraniJezici;
	
	private List<Zahtjev> odabraniZahtjevi;
	private ZahtjeviModel modelZahtjeva;
	private JTable tblZahtjevi;
	private JScrollPane scroll;
	

	public IzvjestajObradjenihZahtjevaDlg(JFrame parent) {
		super(parent);
		GridBagLayout gridBagLayout = (GridBagLayout) panel.getLayout();
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 54};
		
		setTitle("Izvještaj zahtjeva");
		setSize(800, 500);
		setLocation(100, 100);
		
		lblIzvjestaj.setText("Odaberite jezike:");
		
		JPanel panelJezici = new JPanel();
		panelJezici.setPreferredSize(new Dimension(300, 30));
		GridBagConstraints gbc_panelJezici = new GridBagConstraints();
		gbc_panelJezici.gridwidth = 2;
		gbc_panelJezici.insets = new Insets(0, 0, 0, 5);
		gbc_panelJezici.fill = GridBagConstraints.BOTH;
		gbc_panelJezici.gridx = 0;
		gbc_panelJezici.gridy = 3;
		panel.add(panelJezici, gbc_panelJezici);
		
		jezici = new ArrayList<JCheckBox>();
//		odabraniJezici = new ArrayList<Jezik>();
		for (Jezik jezik : Podaci.getPodaci().getJezikManager().getJezici()) {
			JCheckBox checkBoxJezik = new JCheckBox(jezik.getJezik());
			jezici.add(checkBoxJezik);
			panelJezici.add(checkBoxJezik);
		}
		

		
		btnPrikazi.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ispravniDatumi() && odabranKurs()) {
					
					odabraniZahtjevi = pronadjiOdabraneZahtjeve();
					
					modelZahtjeva = new ZahtjeviModel(odabraniZahtjevi);
					tblZahtjevi = new JTable(modelZahtjeva);
					
					if (scroll != null)
						getContentPane().remove(scroll);
					scroll = new JScrollPane(tblZahtjevi);
					tblZahtjevi.setAutoCreateRowSorter(true);
					GridBagConstraints gbc_scroll = new GridBagConstraints();
					gbc_scroll.gridwidth = 2;
					gbc_scroll.insets = new Insets(0, 0, 0, 5);
					gbc_scroll.fill = GridBagConstraints.BOTH;
					gbc_scroll.gridx = 0;
					gbc_scroll.gridy = 4;
					panel.add(scroll, gbc_scroll);
					modelZahtjeva.fireTableDataChanged();
					getContentPane().remove(panel);
					getContentPane().add(panel, BorderLayout.NORTH);
										
					getContentPane().add(scroll, BorderLayout.CENTER);

					
				}
			}
		});
	}




	protected boolean odabranKurs() {
		odabraniJezici = new ArrayList<Jezik>();
		for (JCheckBox checkBoxJezik : jezici)
			if (checkBoxJezik.isSelected())
				odabraniJezici.add(Podaci.getPodaci().getJezikManager().getMapJezici().get(checkBoxJezik.getText()));
		
		if (odabraniJezici.size() > 0)
			return true;
		JOptionPane.showMessageDialog(null, "Morate da odaberete najmanje jedan jezik", "Neispravan unos", JOptionPane.WARNING_MESSAGE);
		return false;
	}


	protected List<Zahtjev> pronadjiOdabraneZahtjeve() {
		odabraniZahtjevi = new ArrayList<Zahtjev>();
		for (Zahtjev zahtjev : Podaci.getPodaci().getZahtjevManager().getObradjeniZahtjevi()) 
			if (zahtjev.getDatumObrade().isAfter(odabraniDatumOd) && zahtjev.getDatumObrade().isBefore(odabraniDatumDo) && 
					odabraniJezici.contains(zahtjev.getKurs().getJezik())  )
				odabraniZahtjevi.add(zahtjev);
		
		return odabraniZahtjevi;
	}

	

	
	
}
