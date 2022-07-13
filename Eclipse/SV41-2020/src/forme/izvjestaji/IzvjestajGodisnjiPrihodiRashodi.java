package forme.izvjestaji;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import org.knowm.xchart.SwingWrapper;

//import org.graalvm.compiler.core.common.util.ReversedList;

import entiteti.Uplacivanje;
import entiteti.osobe.Administrator;
import forme.izvjestaji.chartovi.PieChartGodisnjiIzvjestaj;
import main.Podaci;

public class IzvjestajGodisnjiPrihodiRashodi {
	
	public static Map<Integer, String> mjeseciStr;
	
	private Map<Integer, Double> mapPrihodi;
	private Map<Integer, Double> mapRashodi;

	
	private LocalDate danas = LocalDate.now();
	private LocalDate pocetakGodine;
	
	
	public IzvjestajGodisnjiPrihodiRashodi() {
		inicijalizujMape();
		ArrayList<Uplacivanje> uplacivanja = (ArrayList<Uplacivanje>) Administrator.svaUplacivanja;
		Uplacivanje u;
		int key;
		for (int i = uplacivanja.size() - 1; i >= 0; i--) {
			u = uplacivanja.get(i);
			if ( u.getDatum().isBefore(pocetakGodine) )
				break;
			if ( u.getDatum().getMonthValue() == danas.getMonthValue() )
				continue;
			
			key = u.getDatum().getMonthValue();
			if (u.getIznos() > 0)
				mapPrihodi.put(key, mapPrihodi.get(key) + u.getIznos() );
			else
				mapRashodi.put(key, mapRashodi.get(key) + u.getIznos() * (-1) );			
		}
		
		prikaziChartove();
	}
	
	
	private void prikaziChartove() {
		PieChartGodisnjiIzvjestaj cartPrihodi = new PieChartGodisnjiIzvjestaj(mapPrihodi);
		PieChartGodisnjiIzvjestaj cartRashodi = new PieChartGodisnjiIzvjestaj(mapRashodi);

		Thread t = new Thread(new Runnable() {
            @SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
            public void run() {
                new SwingWrapper(cartPrihodi.getChart()).displayChart().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                new SwingWrapper(cartRashodi.getChart()).displayChart().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        });
        t.start();
		System.out.println(mapPrihodi);
		System.out.println(mapRashodi);
	}


	private void inicijalizujMape() {
		mjeseciStr = new HashMap<Integer, String>();
		mjeseciStr.put(1, "januar");
		mjeseciStr.put(2, "februar");
		mjeseciStr.put(3, "mart");
		mjeseciStr.put(4, "april");
		mjeseciStr.put(5, "maj");
		mjeseciStr.put(6, "jun");
		mjeseciStr.put(7, "jul");
		mjeseciStr.put(8, "avgust");
		mjeseciStr.put(9, "septembar");
		mjeseciStr.put(10, "oktobar");
		mjeseciStr.put(11, "novembar");
		mjeseciStr.put(12, "decembar");
		mapPrihodi = new HashMap<Integer, Double>();
		mapRashodi = new HashMap<Integer, Double>();
		
		int mjesec = danas.getMonthValue();
		pocetakGodine = LocalDate.parse("01.01." + danas.getYear(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		for (int i = 1; i < mjesec; i++) {
			mapPrihodi.put(i, 0.0);
			mapRashodi.put(i, 0.0);
		}
	}







//	private String getMjesecStr(int mjesec) {
//		switch (mjesec) {
//			case 1:
//				return "januar";
//			case 2:
//				return "februar";
//			case 3:
//				return "mart";
//			case 4:
//				return "april";
//			case 5:
//				return "maj";
//			case 6:
//				return "jun";
//			case 7:
//				return "jul";
//			case 8:
//				return "avgust";
//			case 9:
//				return "septembar";
//			default:
//				return null;	
//		}
//	}







	public static void main(String[] args) {
		new Podaci();
		new IzvjestajGodisnjiPrihodiRashodi();
	}
}
