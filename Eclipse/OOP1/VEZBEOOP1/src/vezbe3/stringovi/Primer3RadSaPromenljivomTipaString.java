package vezbe3.stringovi;

public class Primer3RadSaPromenljivomTipaString {

	public static void main(String[] args) {
		// definisanje promenljive tipa string
		String a = "Ovo je Tekst";
		String a1 = "Ovo je tekst";
		
		//Provera da li stringovi zadrze isti niz karaktera
		if (a.equals(a1))
			System.out.println("1. Nizovi a i a1 su slicni");
		else
			System.out.println("1. Nizovi a i a1 nisu slicni");
		
		if(a.equalsIgnoreCase(a1))
			System.out.println("2. Nizovi a i a1 su slicni");
		else
			System.out.println("2. Nizovi a i a1 nisu slicni");
		
		//prebacivanje velikih u mala slova
		a = a.toLowerCase();
		System.out.println(a);
		a1 = a1.substring(0,5);
		//Provera da li string a zapocinje sa karakterima iz stringa a1
		if(a.startsWith(a1))
			System.out.println("Zapocinje");
		else
			System.out.println("Ne zapocinje");
		
		//provera da li string sadrzi rec
		if(a.contains("tekst"))
			System.out.println("Sadrzi rec");
		else
			System.out.println("Ne sadrzi rec");
		
		//leksikografsko poredjenje stringova
		if("B".compareTo("A")>0)    //razlika pozicija B i A
			System.out.println("posle");
		else if ("B".compareTo("A")<0) 
			System.out.println("pre");
		else
			System.out.println("isti");

	}

}
