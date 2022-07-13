package forme.izvjestaji;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.SwingWrapper;

import entiteti.Jezik;
import entiteti.Kurs;
import forme.izvjestaji.chartovi.PieChartStringDouble;
import main.Podaci;

public class InteresovanjeSvihUcenika {

	private Map<String, Double> mapJezUc;

	public InteresovanjeSvihUcenika() {

		mapJezUc = new HashMap<String, Double>();
		for (Jezik jezik : Podaci.getPodaci().getJezikManager().getJezici())
			for (Kurs kurs : jezik.getKursevi()) {
				String key = jezik.getJezik();
				mapJezUc.put(key, (mapJezUc.containsKey(key)) ? (mapJezUc.get(key) + kurs.getUcenici().size())
						: kurs.getUcenici().size());
			}

		PieChartStringDouble cart = new PieChartStringDouble(mapJezUc);
		PieChart chart = cart.getChart();
		chart.setTitle("Interesovanje");
		
		Thread t = new Thread(new Runnable() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void run() {
				new SwingWrapper(chart).displayChart().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		t.start();

	}

	public static void main(String[] args) {
		new Podaci();
		new InteresovanjeSvihUcenika();
	}
}
