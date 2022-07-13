package zadatak5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Fakultet {
	
	private HashMap<String, Predmet> aktivniPredmeti;
	private HashMap<String, Predmet> obrisaniPredmeti;
	private HashMap<String, Student> studenti;
	
	
	
	// KONSTRUKTORI
	
	public Fakultet() {
		this.aktivniPredmeti = new HashMap<String, Predmet>();
		this.obrisaniPredmeti = new HashMap<String, Predmet>();
		this.studenti = new HashMap<String, Student>();
	}
	public Fakultet(HashMap<String, Predmet> predmeti, HashMap<String, Predmet> obrisaniPredmeti, HashMap<String, Student> studenti) {
		this();
		this.aktivniPredmeti = predmeti;
		this.obrisaniPredmeti = obrisaniPredmeti;
		this.studenti = studenti;
	}
	public Fakultet(Fakultet f) {
		this(f.aktivniPredmeti, f.obrisaniPredmeti ,f.studenti);
	}

	
	
	
	// GETTERI I SETTERI
	
	public HashMap<String, Predmet> getPredmeti() {
		return aktivniPredmeti;
	}
	public void setPredmeti(HashMap<String, Predmet> predmeti) {
		this.aktivniPredmeti = predmeti;
	}

	public HashMap<String, Student> getStudenti() {
		return studenti;
	}
	public void setStudenti(HashMap<String, Student> studenti) {
		this.studenti = studenti;
	}

	
	
	
	// METODE
	
	public void unesiNoviPredmet(Predmet p) {
		this.aktivniPredmeti.put(p.getSifra(), p);
	}
	
	public void izmijeniPodatkeOPredmetu(String sifra, Predmet p) {
		this.aktivniPredmeti.replace(sifra, p);
	}
	
	public void izbrisiPredmet(String sifra) {
		Predmet p = this.aktivniPredmeti.remove(sifra);
		this.obrisaniPredmeti.put(sifra, p);
	}
	
	private void ispisiPredmet(Predmet p) {
		System.out.printf("%s   %s   %s   %d", p.getNaziv(), p.getSifra(), p.getProfesor(), p.getSemestar());
	}
	
	public void ispisiPredmete(boolean aktivni, boolean obrisani) {
		if (aktivni == true)
			for (Predmet p : this.aktivniPredmeti.values())
				ispisiPredmet(p);
		if (obrisani == true)
			for (Predmet p : this.obrisaniPredmeti.values())
				ispisiPredmet(p);
	}
	
	public void ispisiPredmet(String sifra) {
		if (this.aktivniPredmeti.containsKey(sifra))
			ispisiPredmet(this.aktivniPredmeti.get(sifra));
		else
			System.out.println("Nema aktivnog predmeta sa tom sifrom.");
	}
	
	
	
	
	public void dodajNovogStudenta(Student s) {
		this.studenti.put(s.getIndeks(), s);
	}
	
	public void izmijeniPodatkeOStudentu(String sifra, Student s) {
		this.studenti.replace(sifra, s);
	}
	
	public void obrisiStudenta(String sifra) {
		Student s = this.studenti.get(sifra);
		this.studenti.remove(sifra);
		this.studenti.put("9" + sifra, s);
	}
	
	private void ispisiStudenta(Student s) {
		System.out.printf("%s   %s   %s   %d   %.2f\n", s.getIndeks(), s.getIme(), s.getPrezime(), s.getGodUpisa(), s.getProsek());
	}
	
	public void ispisiAktivneStudente() {
		for (String sifra : this.studenti.keySet()) {
			if (sifra.length() == 4)
				ispisiStudenta(this.studenti.get(sifra));
		}
	}
	
	public void ispisiObrisaneStudente() {
		for (String sifra : this.studenti.keySet()) {
			if (sifra.length() == 5)
				ispisiStudenta(this.studenti.get(sifra));
		}
	}
	
	public void ispisiSveStudente() {
		for (String sifra : this.studenti.keySet()) {
			ispisiStudenta(this.studenti.get(sifra));
		}
	}
	
	private void ispisiPolozenePredmete(Student s) {
		System.out.println("POLOZENI PREDMETI");
		for (Ocena ocena : s.getOcene()) {
			System.out.printf("%s   %d\n", ocena.getPredmet(), ocena.getOcena());
		}
	}
	
	public void ispisiStudenta(String indeks) {
		Student s = this.studenti.get(indeks);
		ispisiStudenta(s);
		ispisiPolozenePredmete(s);
	}

	public void ispisiProsjekPredmeta(String sifraPredmeta) {
		int total = 0, brOcena = 0;
		for (Student s : this.studenti.values()) {
			for (Ocena o : s.getOcene()) {
				if (o.getPredmet().getSifra().equals(sifraPredmeta)) {
					total += o.getOcena();
					brOcena++;
				}
			}
		}
		System.out.printf("Prosjek ocjena za predmet %s je %.2f\n", this.aktivniPredmeti.get(sifraPredmeta).getNaziv(), (total*1.0 / brOcena));
	}
	
	
	public void sortirajStudentePoGodini() {
		List<Entry<String, Student>> lista = new LinkedList<Entry<String, Student>>(this.studenti.entrySet());
		Collections.sort(lista, new Comparator<Entry<String, Student>>(){

			@Override
			public int compare(Entry<String, Student> o1, Entry<String, Student> o2) {
				return o1.getValue().getGodUpisa().compareTo(o2.getValue().getGodUpisa());
			}
		});
		
		for (Entry<String, Student> entry : lista) {
			System.out.println(entry.getValue());
		}
	}
	
	public void sortirajStudentePoImenuIPrezimenu() {
		List<Entry<String, Student>> lista = new LinkedList<Entry<String, Student>>(this.studenti.entrySet());
		Collections.sort(lista, new Comparator<Entry<String, Student>>(){

			@Override
			public int compare(Entry<String, Student> o1, Entry<String, Student> o2) {
				String p1 = o1.getValue().getIme() + " " + o1.getValue().getPrezime();
				String p2 = o2.getValue().getIme() + " " + o2.getValue().getPrezime();
				return p1.compareTo(p2);
			}

		});
	}
	
	public void sortirajStudentePoBrojuPolozenihIspita() {
		List<Entry<String, Student>> lista = new LinkedList<Entry<String, Student>>(this.studenti.entrySet());
		Collections.sort(lista, new Comparator<Entry<String, Student>>(){

			@Override
			public int compare(Entry<String, Student> o1, Entry<String, Student> o2) {
				Integer p1 = o1.getValue().getOcene().size();
				Integer p2 = o2.getValue().getOcene().size();
				return p2.compareTo(p1);
			}
		});
		
		for (Entry<String, Student> entry : lista) {
			System.out.println(entry.getValue());
		}
	}
	
	public void sortirajStudentePoProsjeku() {
		List<Entry<String, Student>> lista = new LinkedList<Entry<String, Student>>(this.studenti.entrySet());
		Collections.sort(lista, new Comparator<Entry<String, Student>>(){

			@Override
			public int compare(Entry<String, Student> o1, Entry<String, Student> o2) {
				return o2.getValue().getProsek().compareTo(o1.getValue().getProsek());
			}
		});
		
		for (Entry<String, Student> entry : lista) {
			System.out.println(entry.getValue());
		}
	}
	
	
	
	

	public static void main(String[] args) {
		Fakultet f = new Fakultet();
		f.unesiNoviPredmet(new Predmet("0000", "OOP", 2, "Vidak"));
		f.unesiNoviPredmet(new Predmet("0001", "OP", 1, "Branko"));
		f.izbrisiPredmet("0001");
		
		f.ispisiPredmet("0000");
		
		
		ArrayList<Ocena> ocene = new ArrayList<Ocena>();
		ocene.add(new Ocena(new Predmet("0000", "OOP", 2, "Vidak"), 6));
		ocene.add(new Ocena(new Predmet("0001", "OP", 1, "Branko"), 10));
		f.dodajNovogStudenta(new Student("SV41/2020", "Nemanja", "Stojcevic", 2020, ocene, 9.07));
		f.ispisiProsjekPredmeta("0000");
		f.ispisiStudenta("SV41/2020");
		f.ispisiSveStudente();
		System.out.println();
		
		f.sortirajStudentePoBrojuPolozenihIspita();
	}
	
	
	
	
	
}
