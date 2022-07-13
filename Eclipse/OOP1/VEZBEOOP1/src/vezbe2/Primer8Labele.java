package vezbe2;

public class Primer8Labele {

	public static void main(String[] args) {

		int[][] array = { { 1, 2, 3 }, { 4, 88, 5 } };
		boolean foundIt = false;
		int searchFor = 88;

		search: for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == searchFor) {
					foundIt = true;
					break search;
				}
			}
		}
		// nastavak izvrsavanja nakon break search;
		if (foundIt) {
			System.out.println("Found " + searchFor);
		}
	}

}
