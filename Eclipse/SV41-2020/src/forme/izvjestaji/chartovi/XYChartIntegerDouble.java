package forme.izvjestaji.chartovi;

import java.util.List;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.demo.charts.ExampleChart;

public class XYChartIntegerDouble  implements ExampleChart<XYChart> {
	
	private List<Integer> xVrijednosti;
	private List<Double> yVrijednosti;
	

	public XYChartIntegerDouble(List<Integer> xVrijednosti, List<Double> yVrijednosti) {
		this.xVrijednosti = xVrijednosti;
		this.yVrijednosti = yVrijednosti;
	}

	@Override
	public XYChart getChart() {

		// Create Chart
		XYChart chart = new XYChartBuilder().width(800).height(600).title("Statistika").xAxisTitle("X").yAxisTitle("Y").build();
//		chart.getStyler().setDatePattern("dd.MM.yyyy");

		// Series
		chart.addSeries("Statistika", xVrijednosti, yVrijednosti);


		return chart;
	}

	@Override
	public String getExampleChartName() {
		// TODO Auto-generated method stub
		return null;
	}

}
