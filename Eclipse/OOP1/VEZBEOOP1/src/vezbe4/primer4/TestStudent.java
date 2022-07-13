package vezbe4.primer4;

import java.util.ArrayList;

public class TestStudent {

	public static void main(String[] args) {

		Student[] niz = new Student[3];
		niz[0] = new Student();
		niz[1] = new Student();
		niz[2] = new Student();

		// greska - atribut ime nije vidljiv (modifikator pristupa private)
		// System.out.println(niz[0].ime);

		// kontrolisan pristup atributima
		System.out.println(niz[0].getIme());

		for (Student s : niz) {
			s.prikaziPodatke();
		}
		
		// greska
		// niz[0].ime = "Milan"
		
		// izmena vrednosti atributa
		niz[0].setIme("Milan");
		niz[0].setIndeks("12345");
		niz[0].setGrad("Novi Sad");
		niz[0].prikaziPodatke();
			
		ArrayList<Student> dinamickiNiz = new ArrayList<Student>();
		dinamickiNiz.add(new Student());
		dinamickiNiz.add(new Student());
		dinamickiNiz.add(new Student());

		System.out.println(dinamickiNiz.get(0));

		for (Student s : dinamickiNiz) {
			s.prikaziPodatke();
		}

	}

}
