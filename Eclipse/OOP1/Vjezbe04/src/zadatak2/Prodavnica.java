package zadatak2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Prodavnica {

	private HashMap <String, Artikal> artikli = new HashMap<String, Artikal>();
	
	
	// KONSTRUKTORI
	
	public Prodavnica() {}
	
	public Prodavnica(HashMap<String, Artikal> artikli) {
		this();
		this.artikli = artikli;
	}

	
	
	// GETTERI I SETTERI

	public HashMap<String, Artikal> getArtikli() {
		return artikli;
	}

	public void setArtikli(HashMap<String, Artikal> artikli) {
		this.artikli = artikli;
	};
	
	
	
	// METODE
	
	public void dodajNoviArtikal(Artikal a) {
		this.artikli.put(a.getSifra(), a);
	}
	
	public void izmjenaPodatakaPostojeceg(String sifra, Artikal a) {
		this.artikli.replace(sifra, a);
	}
	
	public void ispisOdredjenogArtikla(String sifra) {
		System.out.println(this.artikli.get(sifra));
	}
	
	public void ispisSvihArtikala() {
		int i = 0;
		for (Artikal a : this.artikli.values()) {
			i++;
			System.out.printf("%d.  %s  %.2f  %d  %s", i, a.getNaziv(), a.getCijena(), a.getKolicina(), a.getSifra());
		}
	}
	
	public void ispisPoKategoriji(String kategorija) {
		for (Artikal a : this.artikli.values()) {
			if ( a.getKategorija().equals(kategorija) )
				System.out.println(a);
		}
	}
	
	public void sortirajPoNazivu(boolean asc) {
		List<Entry<String, Artikal>> lista = new LinkedList<Entry<String, Artikal>>(this.artikli.entrySet());

		Collections.sort(lista, new Comparator<Entry<String, Artikal>>() {

			@Override
			public int compare(Entry<String, Artikal> o1, Entry<String, Artikal> o2) {
				if (asc == true)
					return o1.getValue().getNaziv().compareTo(o2.getValue().getNaziv());
				return o2.getValue().getNaziv().compareTo(o1.getValue().getNaziv());
			}
		});
	
		int i = 0;
		for (Entry<String, Artikal> entry : lista) {
			i++;
			System.out.println(i + ". " + entry.getValue());
		}
	}
	
	
	public void sortirajPoCijeni(boolean asc) {
		List<Entry<String, Artikal>> lista = new LinkedList<Entry<String, Artikal>>(this.artikli.entrySet());
		Collections.sort(lista, new Comparator<Entry<String, Artikal>>(){

			@Override
			public int compare(Entry<String, Artikal> o1, Entry<String, Artikal> o2) {
				if (asc == true)
					return o1.getValue().getCijena().compareTo(o2.getValue().getCijena());
				return o2.getValue().getCijena().compareTo(o1.getValue().getCijena());
			}
		});
		
		int i = 0;
		for (Entry<String, Artikal> entry : lista) {
			i++;
			System.out.println(i + ". " + entry.getValue());
		}
	}
	
	
	public void sortirajPoKategoriji(boolean asc) {
		List<Entry<String, Artikal>> lista = new LinkedList<Entry<String, Artikal>>(this.artikli.entrySet());
		Collections.sort(lista, new Comparator<Entry<String, Artikal>>(){

			@Override
			public int compare(Entry<String, Artikal> o1, Entry<String, Artikal> o2) {
				if (asc == true)
					return o1.getValue().getKolicina().compareTo(o2.getValue().getKolicina());
				return o2.getValue().getKolicina().compareTo(o1.getValue().getKolicina());
			}
		});
		
		int i = 0;
		for (Entry<String, Artikal> entry : lista) {
			i++;
			System.out.println(i + ". " + entry.getValue());
		}
	}
	
	

	public static void main(String[] args) {
		
		Prodavnica p = new Prodavnica();
		p.dodajNoviArtikal(new Artikal("0000", "Smoki", 60, 30, "ovo je smoki", "grickalice"));
		p.dodajNoviArtikal(new Artikal("0001", "Cips", 50, 30, "Ovo je cips", "grickalice"));
		p.dodajNoviArtikal(new Artikal("0002", "Cekic", 200, 10, "Ovo je cekic", "alat"));
		p.dodajNoviArtikal(new Artikal("0003", "Cajna kobasica", 410, 50, "Ovo je kobasica", "meso"));
		
		p.sortirajPoNazivu(true);
		p.sortirajPoCijeni(false);
		p.sortirajPoKategoriji(true);
		
	}
	
	

	
	
	
	
	
}
