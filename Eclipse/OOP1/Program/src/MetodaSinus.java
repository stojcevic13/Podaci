
public class MetodaSinus {
	
	static long fakt(int n) {
		long rez = 1;
		
		for (; n > 1; n--)
			rez *= n;
		
		return rez;
	}
	

	public static void main(String[] args) {
		
		double x = Math.PI, sabirak = x, rez = 0, znak = 1.0;
		int i = 1;
		
		while (Math.abs(sabirak) > 1E-6) {
			sabirak = (Math.pow(x, i) / fakt(i)) * znak;
			rez += sabirak;
			znak *= -1;
			i += 2;
		}
		
		System.out.printf("Sinus: %.9f", rez);
		
	}

}
