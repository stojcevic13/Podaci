package test03;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TuristickaAgencija extends JFrame {

	private static final long serialVersionUID = -6603546355639110027L;
	
	private String naziv;
	private List<Putovanje> putovanja;
	
	
	
	public TuristickaAgencija() {
		this.putovanja = new ArrayList<Putovanje>();
	}
	
	public TuristickaAgencija(String naziv) {
		this();
		this.naziv = naziv;
	}

	
	
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Putovanje> getPutovanja() {
		return putovanja;
	}

	public void setPutovanja(List<Putovanje> putovanja) {
		this.putovanja = putovanja;
	}
	
	
	
	public void ucitaj(String putanja) {
		
	}
	
	public Izlet func1(boolean najranije) {
		Izlet ret = null;
		
		for (Putovanje p : this.putovanja) {
			if ( (p instanceof Izlet) && (najranije)) 
				if (p.getDatumOd().isBefore(ret.getDatumOd()))
					ret = (Izlet) p;
			if ( (p instanceof Izlet) && (!najranije))
				if (p.getDatumOd().isAfter(ret.getDatumOd()))
					ret = (Izlet) p;
		}
		return ret;
	}
	
	public void prikaziGUI() {
		setTitle("Naslov");
		setSize(400, 300);
		getContentPane().setLayout(new FlowLayout());
		
		ButtonGroup grupa = new ButtonGroup();
		JRadioButton rb1 = new JRadioButton("RADIO 1");
		JRadioButton rb2 = new JRadioButton("RADIO 2");
		
		grupa.add(rb1);
		grupa.add(rb2);
		
		
		rb1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pritisnuo na rb1");
			}
		});
				
		rb2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pritisnuo na rb2");
			}
		});
		
		getContentPane().add(rb1);
		getContentPane().add(rb2);
		setLocation(100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		TuristickaAgencija ta = new TuristickaAgencija("naslov");
		ta.prikaziGUI();
	}
	
	
}
