package chart;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;

public class PieChart02 extends JFrame implements ExampleChart<PieChart> {

	private static final long serialVersionUID = -3088636670542472786L;



	public PieChart02() {

		PieChart chart = getChart();
		SwingWrapper<PieChart> p = new SwingWrapper<PieChart>(chart);
		p.displayChart();
		new SwingWrapper<PieChart>(chart).displayChart();
	}

	@Override
	public PieChart getChart() {

		// Create Chart
		PieChart chart = new PieChartBuilder().width(800).height(600).title("Naslov").build();

		// Customize Chart
		Color[] sliceColors = new Color[] { new Color(224, 68, 14), new Color(230, 105, 62), new Color(236, 143, 110),
				new Color(243, 180, 159), new Color(246, 199, 182) };
		chart.getStyler().setSeriesColors(sliceColors);

		// Series
		chart.addSeries("Gold", 24);
		chart.addSeries("Silver", 21);
		chart.addSeries("Platinum", 39);
		chart.addSeries("Copper", 17);
		chart.addSeries("Zinc", 40);

		return chart;
	}

	@Override
	public String getExampleChartName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	public static void main(String[] args) {

		ExampleChart<PieChart> exampleChart = new PieChart02();
		PieChart chart = exampleChart.getChart();
		new SwingWrapper<PieChart>(chart).displayChart();
	}

}
