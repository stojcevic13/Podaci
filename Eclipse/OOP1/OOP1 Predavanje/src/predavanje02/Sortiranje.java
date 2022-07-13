package predavanje02;

public class Sortiranje {
	
	static void selectionSort(int[] niz) {
		int n = niz.length, tmp;

		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if (niz[j] < niz[i]) {
					tmp = niz[i];
					niz[i] = niz[j];
					niz[j] = tmp;
				}
			}
		}
	}
	
	
	static void bubbleSort(int[] niz) {
		int n = niz.length, tmp;

		for (int i = n-1; i >= 1; i--) {
			for (int j = 0; j < i; j++) {
				if (niz[j] > niz[j+1]) {
					tmp = niz[j];
					niz[j] = niz[j+1];
					niz[j+1] = tmp;
				}
			}
		}
	}

	
	static int binarySearch(int[] niz, int el) {
		int d = 0, g = niz.length-1;
		int i;
		
		while (d <= g) {
			i = (d + g) / 2;
			if (niz[i] > el) {
				g = i-1;
				continue;
			} else if (niz[i] < el) {
				d = i+1;
				continue;
			}
			return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		
		int[] niz = {57, 2, 15, 32, 26, 51, 43, 18, 9};
		
		System.out.print("Nesortiran niz: ");
		for (int el : niz) {
			System.out.print(el + " ");
		}
		
		bubbleSort(niz);
		
		System.out.print("\nSortiran niz: ");
		for (int el : niz) {
			System.out.print(el + " ");
		}
		
		int index = binarySearch(niz, 57);
		System.out.printf("\nTrazeni element je na %d. mjestu u nizu.", index);
		
	}

}
