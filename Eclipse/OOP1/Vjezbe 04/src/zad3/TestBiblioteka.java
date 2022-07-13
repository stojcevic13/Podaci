package zad3;

public class TestBiblioteka {

	public static void main(String[] args) {

		Biblioteka biblioteka = new Biblioteka();
		
		Knjiga k1 = new Knjiga("0000", "Bijeli ocnjak", 2001, "Dzek London", 1000);
		Knjiga k2 = new Knjiga("0001", "Na Drini cuprija", 1963, "Ivo Andric", 1200);
		Knjiga k3 = new Knjiga("0002", "Serviraj za pobedu", 2012, "Novak Djokovic", 1500);
		
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		biblioteka.dodajKnjigu(k3);
		
		biblioteka.ispisiSveKnjige();
		
		biblioteka.obrisiKnjigu(k2);
		biblioteka.ispisiSveKnjige();
		
		biblioteka.izmjenaKnjige(k1, k2);
		biblioteka.ispisiSveKnjige();
		

	}

}
