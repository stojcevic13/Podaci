package vezbe4.primer2;

import java.util.ArrayList;

public class TestStudent {

	public static void main(String[] args) {

		/** staticki niz */
		Student[] niz = new Student[3]; // alokacija 3 memorijska polja
		niz[0] = new Student();
		niz[1] = new Student();
		niz[2] = new Student();
		
		// greska - staticki niz ima fiksnu duzinu (u ovom primeru 3)
		// niz[3] = new Student();

		System.out.println(niz[0].ime); // pristup elementu statickog niza, niz[indeks]

		for (Student s : niz) {
			s.prikaziPodatke();
		}

		// Broj elemenata moze biti zadat inicijalno
		// ArrayList<Integer> arrL = new ArrayList<Integer>(2);
		ArrayList<Student> dinamickiNiz = new ArrayList<Student>();
		dinamickiNiz.add(new Student());
		dinamickiNiz.add(new Student());
		
		// moze imati vise elemenata nego sto se inicijalno zada
		// ima promenljivu duzinu
		dinamickiNiz.add(new Student()); // dodavanje elementa na kraj niza pomocu metode add
		dinamickiNiz.add(2, new Student()); // dodavanje elementa na poziciju koja se prosledjuje kao prvi parametar

		dinamickiNiz.remove(1); // uklanjanje elementa na poziciji 1
		
		System.out.println(dinamickiNiz.get(0)); // pristup elementu dinamickog niza, dinamickiNiz.get(indeks)

		for (Student s : dinamickiNiz) {
			s.prikaziPodatke();
		}
		
		int[] niz2 = new int[3]; // staticki niz celih brojeva
		// greska - dinamicki niz ne moze imati elemente primitivnog tipa (int, float, double, ...)
		// ArrayList<int> dinamickiNiz2 = new ArrayList<int>();
		ArrayList<Integer> dinamickiNiz2 = new ArrayList<Integer>();

		int arrayLength = niz.length ; // duzina statickog niza
		int arraySize = dinamickiNiz.size(); // duzina dinamickog niza
	}

}
