package view;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/*
 * @author 	Irena Nowak
 */

public class Queu extends BarChart<Number, Number> {
	final static CategoryAxis xAxis = new CategoryAxis();
	final static NumberAxis yAxis = new NumberAxis();S

	public Queu() {
		// TODO Auto-generated constructor stub
		super(xAxis, yAxis);

        setTitle("Data wachtrij voor de parkeergarage");
        xAxis.setLabel("Rij");       
        yAxis.setLabel("Aantal");
	
	XYChart.Series series = new XYChart.Series();
    series.setName("Eerste reeks");
    series.getData().add(new XYChart.Data(0, 10));
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
            
            
		}}
	};
	
d.start();
    
	}
}