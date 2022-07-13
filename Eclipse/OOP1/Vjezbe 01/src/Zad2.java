
public class Zad2 {

	public static void main(String[] args) {
		int povrsinaKvadrata = 16, a = 4, b = 6;
		
		long strKvadrata = Math.round(Math.sqrt(povrsinaKvadrata));
		int str = (int) strKvadrata;
		
		double izraz = b*b - (a*a/4);
		double ha = Math.sqrt(izraz);
		double povrsinaTrougla = a*ha/2;
		
		System.out.printf("Stranica kvadrata je: %d\n", str);
		System.out.printf("Povrsina jednakokrakog trougla je: %.2f", povrsinaTrougla);

	}

}
