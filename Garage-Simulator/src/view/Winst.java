package view;


import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

//Batul khatib

public class Winst extends LineChart <Number,Number>{
	final static NumberAxis xAxis = new NumberAxis();
	final static NumberAxis yAxis= new NumberAxis();
	public Winst() {
		super(xAxis,yAxis);
//	   xAxis = new NumberAxis();
//       yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
//        final LineChart<Number,Number> lineChart = 
//                new LineChart<Number,Number>(xAxis,yAxis);
                
      setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));
        
        getData().add(series);
        
        
        AnimationTimer d = new AnimationTimer() {
            private long lastUpdate = 0 ;

			@Override
			public void handle(long now) {
				if (now - lastUpdate >= 500_000_000) {
                   lastUpdate = now ;
				
				
				
				   Random d = new Random();
	         	    
	          
	            int x = d.nextInt(30);
	       
//	            series.getData().add(new XYChart.Data(1, x));
//	            series.getData().add(new XYChart.Data(2, x));
//	            series.getData().add(new XYChart.Data(3, 15));
//	            series.getData().add(new XYChart.Data(4, 24));
//	            series.getData().add(new XYChart.Data(5, 34));
//	            series.getData().add(new XYChart.Data(6, 36));
//	            series.getData().add(new XYChart.Data(7, 22));
//	            series.getData().add(new XYChart.Data(8, 45));
//	            series.getData().add(new XYChart.Data(9, 43));
//	            getData().add(series);
	            
	            
			}}
		};
   d.start();
   
	}
	

}
