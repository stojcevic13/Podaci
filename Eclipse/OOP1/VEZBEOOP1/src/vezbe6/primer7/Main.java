package vezbe6.primer7;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		ArrayList<Knjiga> list = new ArrayList<Knjiga>();	
		list.add(new Knjiga("001", "Harry Potter and the Goblet of Fire", 1400.0, 2000));
		list.add(new Knjiga("002", "Harry Potter and the Deathly Hallows", 2000.0, 2007));
		list.add(new Knjiga("003", "A Game of Thrones", 1200.0, 1998));
		
		System.out.println("Sortiranje knjiga rastuce");
		OsnovniSorter os = new OsnovniSorter();
		os.direction = -1; // za sortiranje u opadajucem redosledu
		
		// prvi parametar - lista koja se sortira
		// drugi parametar - objekat klase koja implementira interfejs Comparator
		Collections.sort(list, os);  
		for (Knjiga knjiga:list) {
			System.out.println(knjiga);
		}
	}

}
