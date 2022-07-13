package zad2;

public class TestProdavnica {

	public static void main(String[] args) {
		Prodavnica prodavnica = new Prodavnica();
		
		Artikal a1 = new Artikal("0000", "Smoki", 4.5, 4, "fdsfjsd", "grickalice");
		Artikal a2 = new Artikal("0001", "Cips", 3.5, 2, "fdsfjsd", "grickalice");
		Artikal a3 = new Artikal("0002", "Cekic", 3.5, 4, "fdsfjsd", "alat");
		
		prodavnica.dodajArtikal(a1);
		prodavnica.dodajArtikal(a2);
		prodavnica.dodajArtikal(a3);
		
		prodavnica.ispisiSveArtikle();

		prodavnica.ispisiArtiklePoKategoriji("grickalice");

		prodavnica.sortirajPoNazivu();
		prodavnica.ispisiSveArtikle();
		
		prodavnica.sortirajPoCijeni();
		prodavnica.ispisiSveArtikle();
		
		prodavnica.sortirajPoKategoriji();
		prodavnica.ispisiSveArtikle();
		
		prodavnica.izmjenaCijeneArtikla(a3, 67);
		prodavnica.ispisiSveArtikle();



	}

}
