package predavanje06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;

public class BazaStudenata {

	Scanner sc = new Scanner(System.in);
	HashMap <String, Student> studenti = new HashMap<String, Student>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	
	public BazaStudenata(String fajl) {
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fajl), "utf-8"));

			String linija;
			while ((linija = in.readLine()) != null) {
				Student std = parseStudent(linija);
				studenti.put(std.getJmbg(), std);
			}
			
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private Student parseStudent(String linija) throws NumberFormatException, ParseException {
		String[] podaci = linija.split(";");
		// jmbg, ime, prezime
		Student std = new Student(podaci[0].trim(), podaci[1].trim(), podaci[2].trim(), Integer.parseInt(podaci[3].trim()),
		// budzet, datum rodjenja
				podaci[4].trim().equalsIgnoreCase("b"), sdf.parse(podaci[5].trim()));
		
		return std;
	}
	
	
	private void ispisiSveStudente() {
		for (Student std : studenti.values()) {
			System.out.println(std);
		}
	}
	
	
	private void pronadjiPoJMBG() {
		System.out.print("Unesite JMBG: ");
		String jmbg = sc.nextLine();
		if (studenti.containsKey(jmbg))
			System.out.println(studenti.get(jmbg));
		else
			System.out.println("Nema studenta sa tim JMBG.");
	}


	private void pronadjiPoImenu() {
		System.out.print("Unesite ime: ");
		String ime = sc.nextLine();
		for (Student std : studenti.values())
			if (std.getIme().equalsIgnoreCase(ime)) 
				System.out.println(std);
		System.out.println("KRAJ PRETRAGE");
	}


	public static void main(String[] args) {
		BazaStudenata baza = new BazaStudenata("studenti.txt");
		baza.ispisiSveStudente();
		baza.pronadjiPoJMBG();
		baza.pronadjiPoImenu();
		baza.sc.close();
	}







}
