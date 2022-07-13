package chart;

import java.awt.Color;
import java.awt.Font;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.colors.ChartColor;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class LineChart03 implements ExampleChart<XYChart> {


	private List<Integer> xDatumi;
	private List<Double> yVrijednosti;
	

	public LineChart03(List<Integer> xDatumi, List<Double> yVrijednosti) {
		this.xDatumi = xDatumi;
		this.yVrijednosti = yVrijednosti;
	}

	@Override
	public XYChart getChart() {

		// Create Chart
		XYChart chart = new XYChartBuilder().width(800).height(600).title("LineChart03").xAxisTitle("X").yAxisTitle("Y").build();
		chart.getStyler().setDatePattern("dd.MM.yyyy");
		
		// generates linear data
		ArrayList<Integer> xData = new ArrayList<Integer>();
		ArrayList<Double> yData = new ArrayList<Double>();

//		DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//		Date date = null;
//		for (int i = 1; i <= 10; i++) {
//
//			try {
//				date = sdf.parse(i + ".10.2008");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			xData.add(date);
//			yData.add(Math.random() * i);
//		}

		// Series
		XYSeries series = chart.addSeries("Fake Data", xDatumi, yVrijednosti);


		return chart;
	}

	@Override
	public String getExampleChartName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		List<Integer> datumi = new ArrayList<Integer>();

			datumi.add(1 );
			datumi.add(2);
			datumi.add(3);
			datumi.add(4 );

		
		List<Double> vrijednosti = new ArrayList<Double>();
		vrijednosti.add(300.0);
		vrijednosti.add(400.0);
		vrijednosti.add(700.0);
		vrijednosti.add(500.0);
		
		
		ExampleChart<XYChart> exampleChart = new LineChart03(datumi, vrijednosti);
		XYChart chart = exampleChart.getChart();
		new SwingWrapper<XYChart>(chart).displayChart();
	}
}
