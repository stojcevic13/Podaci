package vezbe6.primer3;

import java.util.Iterator;
import java.util.TreeSet;

public class SetKolekcije {

	public static void main(String[] args) {

		//HashSet<String> imena = new HashSet<String>();
		//LinkedHashSet<String> imena = new LinkedHashSet<String>();
		TreeSet<String> imena = new TreeSet<String>();
		
		imena.add("Marko");
		imena.add("Janko");
		imena.add("Marko");
		imena.add("Branko");
		
		Iterator<String> itr = imena.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
