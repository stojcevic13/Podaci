package vezbe1;

public class PrimerLogickiIRelacioniOperatori {

	public static void main(String[] args) {

		//definicija promenljivih
		boolean a = true, b = false, c = true;
		int d = 2, e = 5;
		
		//koriscenje logickih operatora && i ||
		System.out.println("Vrednost konjukcije a i b je: " + (a && b));
		System.out.println("Vrednost konjukcije a i c je: " + (a && c));
		System.out.println("Vrednost disjunkcije a ili b je: " + (a || b));
		System.out.println("Vrednost slozenog izraza (a i b) ili c je: " + ((a && b) || c));

		
		//koriscenje relacionig operatora >, <=, ==, !=
		System.out.println("Vredonst relacije d vece od e je: " + (d > e));
		System.out.println("Vredonst relacije d manje i jednako od e je: " + (d <= e));
		System.out.println("Vredonst relacije d jednako e je: " + (d == e));
		System.out.println("Vredonst relacije d razlicito od e je: " + (d != e));

		
		//kombinacija relacionih i logickih operatora u izrazu
		boolean rezultat;
		rezultat =  (d > e) && a; //false konjukcija true
		System.out.println("Vrednost rezultata konjukcije relacije " +
				"(d vece od e) i promenljive a je: " + rezultat);
		
		int izraz;
		int i = 2, j = 5, k = 4, l = 1;
		izraz = i += j += k += l;
		System.out.println("Vrijednost izraza je: " + izraz);
		System.out.println("Vrijednost l je: " + l);
		System.out.println("Vrijednost k je: " + k);
		System.out.println("Vrijednost j je: " + j);
		System.out.println("Vrijednost i je: " + i);


	}

}
