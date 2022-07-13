
public class Zad1 {

	public static void main(String[] args) {
		System.out.println("A");
		System.out.println("B");
		System.out.println("\tB.1");
		System.out.println("\t\tB.1.1");
		System.out.println("\tB.2");
		System.out.println("C");
		
		int a = 1, b = 1, c = -6;
		
		int d = b*b - 4*a*c;
		
		if (d < 0) {
			System.out.println("Rjesenja su kompleksna.");
		} else {
			double x1 = (b*b + Math.sqrt(d))*1.0 / 2*a;
			if (d == 0)
				System.out.printf("Postoji jedno rjesenje: %.2f",x1);
			else {
				double x2 = (b*b - Math.sqrt(d))*1.0 / 2*a;
				System.out.printf("Prvo rjesenje: %.2f   Drugo rjesenje: %.2f.", x1, x2);
			}
		}
		

		
	}
}
