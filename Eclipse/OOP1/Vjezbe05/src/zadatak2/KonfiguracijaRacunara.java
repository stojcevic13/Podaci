package zadatak2;

import java.util.ArrayList;

public class KonfiguracijaRacunara extends Artikal {
	
	ArrayList<KomponentaRacunara> komponente;
	
	
	
	public KonfiguracijaRacunara() {}
	public KonfiguracijaRacunara(String sifra, String naziv, double cijena, int kolicina, String opis, ArrayList<KomponentaRacunara> komponente) {
		super(sifra, naziv, cijena, kolicina, opis);
		this.komponente = komponente;
	}
	public KonfiguracijaRacunara(KonfiguracijaRacunara k) {
		this(k.getSifra(), k.getNaziv(), k.getCijena(), k.getKolicina(), k.getOpis(), k.komponente);
	}

	
	
	
	public ArrayList<KomponentaRacunara> getKomponente() {
		return komponente;
	}
	public void setKomponente(ArrayList<KomponentaRacunara> komponente) {
		this.komponente = komponente;
	}

	
	
	@Override
	public String toString() {
		return "Konfiguracija racunara: " + super.toString() + " komponente: " + komponente;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
