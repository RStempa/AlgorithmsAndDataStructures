package inheritanceAndRecursion.chart;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.line.LineChart02;
import org.knowm.xchart.style.Styler.LegendPosition;

public class SinMain {

	public static void main(String[] args) {

		LineChart02 aChart = new LineChart02();
		XYChart chart = aChart.getChart();

		// Create Chart
		chart = new XYChartBuilder().width(800).height(600).build();

		//List<Integer> xData = new ArrayList<Integer>();
		//List<Double> yData = new ArrayList<Double>();

		 // number of line segments to plot
        int n = 20;

        // the function y = sin(4x) + sin(20x), sampled at n+1 points
        // between x = 0 and x = pi
        double[] xData = new double[n+1];
        double[] yData = new double[n+1];
        for (int i = 0; i <= n; i++) {
            xData[i] = Math.PI * i / n;
            yData[i] = Math.sin(4*xData[i]) + Math.sin(20*xData[i]);
        }
		
		
		/**
		int size = 30;
		for (int i = 0; i <= size; i++) {
			double radians = (Math.PI / (size / 2) * i);
			xData.add(i - size / 2);
			yData.add(-.000001 * Math.sin(radians));
		}
		*/
		//double x = 2;
		//double y = (1+x/Math.PI)*Math.cos(x)*Math.cos(40*x);
		//System.out.println(x + "/" + y);

		XYSeries series = chart.addSeries(" y = (1 + x/pi)*cos(x)*cos(40*x)", xData, yData);
		series.setLineColor(Color.PINK);

		new SwingWrapper<XYChart>(chart).displayChart();

	}

}
