package vezbe3.funkcije;

public class Primer7SortiranjeNiza {

	//sortiranje elemenata niza u rastucem
	static void selectionSort(int[] niz) {
		for (int i = 0; i < niz.length -1 ; i++) {
			for (int j = i; j < niz.length; j++) {
				if(niz[i] > niz[j]) {
					int t = niz[i];
					niz[i] = niz[j];
					niz[j] = t;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int [] niz= {1, 6, -5, 7, 12, 14, 3};
		selectionSort(niz);
		
		System.out.println("Sortiran niz:");
		for(int i = 0; i < niz.length; i++) {
			System.out.println((i+1) +  ". element niza niz je " + niz[i]);
		}
		

	}

}
