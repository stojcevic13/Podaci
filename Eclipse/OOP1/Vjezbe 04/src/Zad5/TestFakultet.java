package Zad5;

import java.util.ArrayList;
import java.util.Scanner;

public class TestFakultet {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Predmet p1 = new Predmet("0000", "Osnove programiranja", 1, "Branko Milosavljevic");
		Predmet p2 = new Predmet("0001", "Arhitektura", 1, "Dusan Gajic");
		Ocjena o1 = new Ocjena(p1, 10);
		Ocjena o2 = new Ocjena(p2, 10);
		
		Student s1 = new Student("SV41", "Nemanja", "Stojcevic", 2020);
		s1.dodajOcjenu(o1);
		s1.dodajOcjenu(o2);
		s1.ispisiOcjene();
		
		Fakultet fakultet = new Fakultet();

//		fakultet.unesiNoviPredmet();

	}

}
