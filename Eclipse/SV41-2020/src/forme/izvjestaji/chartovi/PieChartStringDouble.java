package forme.izvjestaji.chartovi;

import java.awt.Color;
import java.util.Map;
import java.util.Map.Entry;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;

public class PieChartStringDouble implements ExampleChart<PieChart> {

	public static Color[] colors = { new Color(0, 0, 255), new Color(255, 0, 0), new Color(0, 255, 0),
			new Color(255, 255, 0), new Color(255, 128, 0), new Color(0, 255, 128), new Color(0, 255, 255),
			new Color(192, 192, 192), new Color(255, 255, 102), new Color(153, 255, 153), new Color(255, 204, 204),
			new Color(229, 204, 255) };

	private Map<String, Double> map;

	
	
	
	
	public PieChartStringDouble(Map<String, Double> map) {
		this.map = map;
	}

//	public InteresovanjeUcenikaChart() {
//	}

	
	
	
	
	public void prikazi() {
		PieChart chart = getChart();
		new SwingWrapper<PieChart>(chart);
	}



	@Override
	public PieChart getChart() {

		// Create Chart
		PieChart chart = new PieChartBuilder().width(600).height(400).title(getClass().getSimpleName()).build();

		// Customize Chart
		chart.getStyler().setSeriesColors(colors);

		// Series

		for (Entry<String, Double> entry : this.map.entrySet()) {
			chart.addSeries(entry.getKey(), entry.getValue());
		}

		return chart;
	}

	@Override
	public String getExampleChartName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	


}
