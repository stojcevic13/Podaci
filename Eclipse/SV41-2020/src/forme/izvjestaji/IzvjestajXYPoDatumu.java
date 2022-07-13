package forme.izvjestaji;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import org.knowm.xchart.SwingWrapper;
//import org.knowm.xchart.XYChart;
//import org.knowm.xchart.demo.charts.ExampleChart;

import entiteti.Uplacivanje;
import entiteti.osobe.Administrator;
import forme.izvjestaji.chartovi.XYChartDateDouble;
import main.Podaci;



public class IzvjestajXYPoDatumu {
	
	private List<Date> datumi;
	private List<Double> vrijednosti;
	
	private double stanje = 0;
	private Date datum;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	

	public IzvjestajXYPoDatumu() {
		datumi = new ArrayList<Date>();
		vrijednosti = new ArrayList<Double>();
		for (Uplacivanje u : Administrator.svaUplacivanja) {
			datum = parseDate(u.getDatumStr());
			stanje += u.getIznos();
			datumi.add(datum);
			vrijednosti.add(stanje);
		}
		XYChartDateDouble cart = new XYChartDateDouble(datumi, vrijednosti);
		
		prikaziChart(cart);
	}


	
	
	
	
	
	private void prikaziChart(XYChartDateDouble cart) {
		Thread t = new Thread(new Runnable() {
            @SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
            public void run() {
                new SwingWrapper(cart.getChart()).displayChart().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        });
        t.start();
	}


	private Date parseDate(String datumStr) {
		try {
			return sdf.parse(datumStr);
		} catch (ParseException e) {
			System.out.println("Greska prilikom konverzije datuma.");
			return null;
		}
	}







	public static void main(String[] args) {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//
//		List<Date> datumi = new ArrayList<Date>();
//		try {
//			datumi.add(sdf.parse("21.12.2021") );
//			datumi.add(sdf.parse("22.12.2021") );
//			datumi.add(sdf.parse("22.12.2021") );
//			datumi.add(sdf.parse("23.12.2021") );
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		List<Double> vrijednosti = new ArrayList<Double>();
//		vrijednosti.add(300.0);
//		vrijednosti.add(400.0);
//		vrijednosti.add(700.0);
//		vrijednosti.add(500.0);
//		
//		
//		ExampleChart<XYChart> exampleChart = new XYChartDateDouble(datumi, vrijednosti);
//		XYChart chart = exampleChart.getChart();
//		new SwingWrapper<XYChart>(chart).displayChart();
		
		new Podaci();
		new IzvjestajXYPoDatumu();
	}

}
