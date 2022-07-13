package test02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ProdavnicaTehnike extends JFrame {

	private static final long serialVersionUID = -8691190936049319136L;

	private String naziv;
	private List<Uredjaj> uredjaji;

	private JPanel content = (JPanel) getContentPane();
	private JButton btnFunc1;
	private JButton btnFunc2;
	private JLabel lblIzvjestaj;

	public ProdavnicaTehnike() {
		this.uredjaji = new ArrayList<Uredjaj>();
	}

	public ProdavnicaTehnike(String naziv) {
		this();
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Uredjaj> getUredjaji() {
		return uredjaji;
	}

	public void setUredjaji(List<Uredjaj> uredjaji) {
		this.uredjaji = uredjaji;
	}

	public void ucitaj(String putanja) {
		// # ID; DIJAGONALA; PROIZVODJAC; CIJENA; TIP; hdmi/mp
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(putanja), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				if (linija.trim().startsWith("#") || linija.trim().equals(""))
					continue;
				Uredjaj u = parseUredjaj(linija);
				this.uredjaji.add(u);
			}

			in.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Uredjaj parseUredjaj(String linija) {
		// # ID; DIJAGONALA; PROIZVODJAC; CIJENA; TIP; hdmi/mp
		String[] tokens = linija.split(";");
		Uredjaj u;
		int id = Integer.parseInt(tokens[0].trim());
		double dijagonala = Double.parseDouble(tokens[1].trim());
		String proizvodjac = tokens[2].trim();
		double cijena = Double.parseDouble(tokens[3].trim());
		int hdmiMP = Integer.parseInt(tokens[5].trim());

		if (tokens[4].trim().equals("TV"))
			u = new Televizor(id, dijagonala, proizvodjac, cijena, hdmiMP);
		else
			u = new MobilniTelefon(id, dijagonala, proizvodjac, cijena, hdmiMP);

		return u;
	}

	public void akcija() {
		for (Uredjaj u : this.uredjaji)
			u.setCijena(u.preuzmiCijenu(true));
	}

	public double func1() {
		double ukupno = 0.0;
		for (Uredjaj u : this.uredjaji)
			ukupno += u.getCijena();
		return ukupno;
	}

	public Televizor func2() {
		Televizor ret = new Televizor();
		double dijagonala = 0.0;
		for (Uredjaj u : this.uredjaji) {
			if (u instanceof Televizor && u.getDijagonala() > dijagonala)
				ret = (Televizor) u;
		}
		return ret;
	}

	public void prikazGUI() {
		setTitle(naziv);
		setSize(500, 300);
		setLocation(200, 200);

		postaviKomponente();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void postaviKomponente() {
		btnFunc1 = new JButton("func 1");
		btnFunc1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblIzvjestaj.setText("Ukupna cijena svih uredjaja je: " + func1());
			}
		});
		btnFunc2 = new JButton("func 2");
		btnFunc2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblIzvjestaj.setText("TV sa najvecom dijagonalom je: " + func2());
			}
		});
		lblIzvjestaj = new JLabel("Izvjestaj");
		lblIzvjestaj.setHorizontalAlignment(SwingConstants.CENTER);

		content.add(btnFunc1, BorderLayout.WEST);
		content.add(btnFunc2, BorderLayout.EAST);
		content.add(lblIzvjestaj, BorderLayout.CENTER);
	}

	public void ispisiUredjaje() {
		for (Uredjaj u : this.uredjaji)
			System.out.println(u);
	}

	public void sacuvaj(String putanja) {

		PrintWriter out;
		try {
			out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(putanja), "utf-8"));
			for (Uredjaj u : this.uredjaji) {
				out.println(u);
			}
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ProdavnicaTehnike prodavnica = new ProdavnicaTehnike("FTN tehnika");

		prodavnica.ucitaj("uredjaji.txt");
		prodavnica.ispisiUredjaje();

		prodavnica.akcija();
		prodavnica.ispisiUredjaje();
		
		prodavnica.sacuvaj("uredjaji.txt");

		prodavnica.prikazGUI();
	}

}
