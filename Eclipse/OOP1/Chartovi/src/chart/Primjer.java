package chart;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class Primjer {

	  public static void main(String[] args) throws Exception {

		    double[] xData = new double[] {1,2,3,4,5,6,7,8,9,10,11};
		    double[] yData = new double[] {5,5,3,4,5,4,5,6,5,7,8};
//		    int i = 0;
//		    for (double x = 0; x <= 10; x += 0.1) {
//		    	yData[i] = Math.round(x-1);
//		    	i++;
//		    }
		    
		    // Create Chart
		    XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

		    
//		    XYChart = QuickChart.
		    // Show it
		    new SwingWrapper(chart).displayChart();

		  }
	  
	  
	  
}
