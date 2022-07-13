package vezbe3.funkcije;

public class Primer6MenjanjeVrednostiNiza {

	static void promeniVrednostElNiza(int [] a) {
		a[0] = 100;
	}
	
	
	public static void main(String[] args) {
		int [] niz = { 1, 2, 3, 5};
		promeniVrednostElNiza(niz);
		
		//primer foreach petlje
		for(int el : niz) {
			System.out.println("Element niza a je " + el);
		}

	}

}
