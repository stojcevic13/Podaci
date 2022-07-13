package vezbe3.funkcije;

public class Primer2IzracunavanjeHipotenuze {

	public static void main(String[] args) {
		double c = vrednostHipotenuzePravouglogTrougla(3, 4);
		System.out.println("Hipotenuza je: " + c);
	}
	
	//izracunavanje kvadrata hipotenuze pravouglog trougla
	//ulazni parametri su duzine kateta a i b
	static double vrednostHipotenuzePravouglogTrougla(double a, double b) {
		double c = 0;
		c = Math.sqrt(a*a + b*b);
		return c;
	}

}
