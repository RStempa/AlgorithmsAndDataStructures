
package inheritanceAndRecursion.chart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.line.LineChart02;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;


public class ScatterPlot {

	public static void main(String[] args) {
	    // Create and Customize Chart
	    XYChart chart = new XYChartBuilder().width(800).height(600).build();
	    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
	    chart.getStyler().setChartTitleVisible(false);
	    chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
	    chart.getStyler().setMarkerSize(5);

	    // Generate data
	    List xData = new ArrayList();
	    List yData = new ArrayList();
	    Random random = new Random();
	    int size = 1000;
	    for (int i = 0; i < size; i++) {
	        xData.add(random.nextGaussian() );
	        yData.add(random.nextGaussian());
	    }
			    
	    // Display scatter plot
	    chart.addSeries("Gaussian Blob", xData, yData);
	    new SwingWrapper(chart).displayChart();
	}
}