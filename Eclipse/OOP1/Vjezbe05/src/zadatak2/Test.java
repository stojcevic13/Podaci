package zadatak2;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		KomponentaRacunara m = new Memorija("0000", "RAM", 1000, 10, "Ovo je RAM", "kategorija1", 8.0);
		KomponentaRacunara p = new Procesor("0001", "Procesor", 2000, 5, "Ovo je procesor", "kategorija1", 3.4, 8);
		ArrayList<KomponentaRacunara> komponente = new ArrayList<KomponentaRacunara>();
		komponente.add(m); komponente.add(p);
		KonfiguracijaRacunara konf = new KonfiguracijaRacunara("0002", "racunar1", 5000, 3, "Konf rac", komponente);
	
		StavkaRacuna stavka1 = new StavkaRacuna("000", konf, 5000, 1);
		System.out.println("Prodaje se: " + stavka1);
		
	}

}
