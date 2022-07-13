package vezbe3.funkcije;

public class Primer4IzracunavanjeHipotenuzeProsireno {

	public static void main(String[] args) {
	
		double c = vrednostHipotenuzePravouglogTrougla(3, 4);
		System.out.println("Hipotenuza gde su katete 3 i 4 je: " + c);
		
		c = vrednostHipotenuzePravouglogTrougla(3);
		System.out.println("Hipotenuza gde su katete 3 i 3 je: " + c);
	}

	
	//ulazni parametri su duzine kateta a i b
	static double vrednostHipotenuzePravouglogTrougla(double a, double b) {
		double c = 0;
		c = Math.sqrt(a*a + b*b);
		return c;
	}
		
	//ulazni parametri su duzine kateta a i b
	static double vrednostHipotenuzePravouglogTrougla(double ab) {
		return vrednostHipotenuzePravouglogTrougla(ab, ab);
	}
	
}


