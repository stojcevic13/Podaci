package vezbe6.primer4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListKolekcije {

	public static void main(String[] args) {

		// ArrayList<String> imena = new ArrayList<String>();
		LinkedList<String> imena = new LinkedList<String>();
		
		imena.add("Marko");
		imena.addFirst("Janko");
		imena.addLast("Marko");
		imena.add("Branko");
		imena.removeFirst();
		
		Iterator<String> itr = imena.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
