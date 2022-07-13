package vezbe1;

public class PrimerKombinovanjeAritmetickihIOperatoraDodele {

	public static void main(String[] args) {

		int a = 1;
		// deklaracija konstante b, rezervisana rec final
		final int B = 5;
		// greska prilikom dodele vrednosti konstanti
		// B = 4;

		// koriscenje kombinovanog operatora += i -=
		a += 2; // isto kao i a = a+2
		System.out.println("Vrednost uvecane promenljive a je: " + a);

		a -= B; // isto kao i a = a-B
		System.out.println("Vrednost umanjene promenljive a je: " + a);

		// eksplicitna konverzija operatorom kastovanja
		float c = 1.25F;

		// gubitak ostatka promenljive c
		a = a + (int) c;
		System.out.println("Uvecanje promenljive a za vrednost promenljive " + "c je : " + a);

		// implicitna konverzija
		c = c + a;
		System.out.println("Uvecanje promenljive c za vrednost promenljive " + "a je : " + c);

	}

}
