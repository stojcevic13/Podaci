package zadatak3;

public class Test {

	public static void main(String[] args) {
		
		Profesor profesor = new Profesor("Milan", "Vidak", "4233402", "DFS89049", "21.12.2012", "profa");
		Predmet predmet = new Predmet("0000", "Objektno", "2");
		predmet.profesor = profesor;
		profesor.predmeti.add(predmet);
	
		System.out.println(profesor);
		System.out.println(predmet);
	}

}
