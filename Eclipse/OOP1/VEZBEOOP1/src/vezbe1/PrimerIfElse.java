package vezbe1;

public class PrimerIfElse {

	public static void main(String[] args) {
		/*
		 * if naredba if ( logicki izraz) { naredbe koje se izvrsavaju ako i samo ako
		 * logicki izraz rezultuje sa true }
		 */
		int godina = 2020;
		if (godina == 2021) {
			System.out.println("Godina je tekuca");
			System.out.println("Jos jedan ispis");
		}
		/*
		 * if-else naredba if ( logicki izraz) { naredbe koje se izvrsavaju ako i samo
		 * ako logicki izraz rezultuje sa true } else { naredbe koje se izvrsavaju u
		 * svim ostalim slucajevima tj. logicki izraz rezultuje sa false }
		 */
		// provera da li je a jednocifren ili dvocifren broj
		int a = 1;
		if (a > -10 && a < 10) {
			System.out.println("Broj je jednocifren");
		} else {
			System.out.println("Broj je dvocifren");
		}		
		/*
		 * if-elseif-else naredba if ( logicki izraz1) { naredbe koje se izvrsavaju ako
		 * i samo ako logicki izraz1 rezultuje sa true } else if ( logicki izraz2) {
		 * naredbe koje se izvrsavaju ako i samo ako logicki izraz2 rezultuje sa true N
		 * puta moze da se ponovi else if deo } else { naredbe koje se izvrsavaju u svim
		 * ostalim slucajevima tj. logicki izraz 1 i 2 su false }
		 */
		// provera kretanja kursa eura - pada, raste ili stagnira,
		// ako se pretpostavlja da ispod 115 pada,
		// izmedju 115 i 120 stagnira, i preko 120 raste
		double kurs = 117.8;
		if (kurs < 115) {
			System.out.println("Euro pada");
		} else if (kurs >= 115 && kurs <= 120) {
			System.out.println("Euro stagnira");
		} else {
			System.out.println("Euro raste");
		}

	}

}
