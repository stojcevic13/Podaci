package vezbe3.funkcije;

public class Primer5Rekurzija {

	public static void main(String[] args) {
		
		int faktorijelOd3 = fact(3);
		System.out.println("Faktorijel od 3 je: " + faktorijelOd3);

	}
	
	//racunanje faktorijela od n
	static int fact(int n) {
		if (n <= 1) {
			//osnovni slucaj: n = 1
			return 1;
		}
		else {
			//rekurzivni slucaj: n > 1 then n! = n * (n - 1)!
			return n * fact(n-1);
		}
	}
}
