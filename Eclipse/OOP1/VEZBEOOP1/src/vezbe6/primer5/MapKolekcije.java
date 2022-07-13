package vezbe6.primer5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapKolekcije {

	public static void main(String[] args) {

		HashMap<String, String> studenti = new HashMap<String, String>();
		//LinkedHashMap<String, String> studenti = new LinkedHashMap<String, String>();
		//TreeMap<String, String> studenti = new TreeMap<String, String>();

		studenti.put("SW12345/2015", "Marko Markovic");
		studenti.put("SW12345/2015", "Marko Markovicc");
		studenti.put("SW12346/2015", "Petar Petrovic");
		studenti.put("SW12347/2015", "Jovan Jovanovic");
		String indeks = "SW12345/2015";
		System.out.println("Student sa indeksom " + indeks + " je " + studenti.get(indeks));
		studenti.remove(indeks);

		for (String s : studenti.values()) {
			System.out.println(s);
		}

		for (Map.Entry<String, String> m : studenti.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}

}
