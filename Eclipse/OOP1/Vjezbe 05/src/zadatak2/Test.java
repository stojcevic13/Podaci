package zadatak2;

public class Test {

	public static void main(String[] args) {
		Kategorija kategorija = new Kategorija("ime_kategorije", "ime_nadkategorije", "ime_podkategorije");
		Memorija RAM = new Memorija("0000", "RAM memorija", 60, 10, "Ovo je memeorija", kategorija, "8GB");
		Procesor procesor = new Procesor("0001", "Intel i5", 50, 11, "Ovo je procesor", kategorija, "3.40 Ghz", 4);
		// sifra, naziv, cijena, kolicina, opis, komponente
		KomponentaRacunara[] komponente = {RAM, procesor};
		GotovaKonfiguracijaRacunara racunar1 = new GotovaKonfiguracijaRacunara("0002", "Racunar1", 500.0, 5, "Ovo je racunar", komponente);
		
		System.out.println(racunar1);

	}

}
