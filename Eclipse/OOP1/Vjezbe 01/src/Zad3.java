
public class Zad3 {

	public static void main(String[] args) {
		int year = 1900;
		
		if ((year % 400 == 0) || ((year % 4 == 0)  &&  (year % 100 != 0)))
			System.out.println("Godina je prestupna.");
		else
			System.out.println("Godina nije prestupna.");

	}

}
