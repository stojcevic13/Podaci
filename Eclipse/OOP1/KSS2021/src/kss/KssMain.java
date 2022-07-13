package kss;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kss.gui.igraci.FrmIgraci;
import kss.gui.klubovi.FrmKlubovi;
import kss.manager.ManagerIgrac;
import kss.manager.ManagerKlub;

public class KssMain extends JFrame {

	private static final long serialVersionUID = -7296402190921762782L;
	
	private JPanel content = (JPanel) getContentPane();
	private FrmIgraci frmIgraci;
	private FrmKlubovi frmKlubovi;

	public KssMain() {
		ManagerKlub mk = new ManagerKlub("klubovi.txt");
		ManagerIgrac mi = new ManagerIgrac("igraci.txt", mk);
		frmKlubovi = new FrmKlubovi(mk);
		frmIgraci = new FrmIgraci(mi, mk);
//		System.out.println(mk.getKlubovi());
//		System.out.println(mi.getIgraci());
		
		setSize(600, 400);
		setTitle("Kosarkaski Savez Srbije");
		setLocation(200, 200);
		
		JPanel dugmad = new JPanel();
		JButton btnIgraci = new JButton("Igraci");
		btnIgraci.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmIgraci.setVisible(true);
			}
		});
		dugmad.add(btnIgraci);
		
		JButton btnKlubovi = new JButton("Klubovi");
		btnKlubovi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmKlubovi.setVisible(true);
			}
		});
		dugmad.add(btnKlubovi);
		
		JButton btnZatvori = new JButton("Zatvori");
		btnZatvori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		dugmad.add(btnZatvori);
		
		content.add(dugmad, BorderLayout.NORTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {

		new KssMain();
	}
}
