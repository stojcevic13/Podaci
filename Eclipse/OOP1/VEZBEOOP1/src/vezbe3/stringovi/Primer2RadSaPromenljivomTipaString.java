package vezbe3.stringovi;

public class Primer2RadSaPromenljivomTipaString {

	public static void main(String[] args) {
		
		//definisanje promenljive tipa string
		String a = " Ovo je tekst 6. zadatka ";
		System.out.println(a);
		
		//Odsecanje praznih mesta sa pocetka
		//i kraja stringa, whitespace karaktera
		a = a.trim();
		System.out.println(a);
		
		//kreiranje podstringa
		String podstring;
		//podstring obuhvata karaktere od 4 pozicije
		//indeksa pa do kraja stringa
		podstring = a.substring(4);
		System.out.println("Podstring 1: " + podstring);
		
		//podstring obuhvata karaktere od 4 pa do 9 pozicije
		//indeksa (ne ukljucuhe 9 karakter) "je te"
		podstring = a.substring(4, 9);
		System.out.println("Podstring 2: " + podstring);

	}

}
