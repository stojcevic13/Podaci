package vezbe5.primer3;

public class Test {

	public static void main(String[] args) {
		
		// greska - ne mozemo instancirati objekat apstraktne klase
		// Figura f = new Figura();
		
		Krug k = new Krug(4);
		System.out.println(k.obim);
		k.izracunajObim();
		System.out.println(k.obim);
		Figura f = (Figura)k;
		System.out.println(f.obim);
		System.out.println(f instanceof Krug);
		Krug k2 = (Krug)f;
		System.out.println(k2.obim);
	}

}
