package vezbe3.funkcije;

public class Primer3MenjanjeUlaznihParametara {

	static void promenaVrednostiUlaznogParametraFunkcije(int a) {
		a = 5;
		System.out.println("Promenjena vrednost a unutar funkcije je: " + a);
	}
	
	public static void main(String[] args) {

		int a = 3;
		System.out.println("Inicijalna vrednost a je: " + a);
		promenaVrednostiUlaznogParametraFunkcije(a);
		System.out.println("Vrednost a po povratku iz funkcije je: " + a);
	}

}
