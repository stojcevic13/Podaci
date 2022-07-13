package manager.osobe;

import java.util.HashMap;
import java.util.Map;

import entiteti.osobe.Korisnik;

public class KorisnikManager {

	private static Map<String, Korisnik> mapKorisnici = new HashMap<String, Korisnik>();

	
	public static Map<String, Korisnik> getMapKorisnici() {
		return mapKorisnici;
	}


	
	
	
}
