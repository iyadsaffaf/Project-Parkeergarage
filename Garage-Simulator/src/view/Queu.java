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
// 
public class Queu extends BarChart<Number, String> {
	final static NumberAxis xAxis = new NumberAxis();
    final static CategoryAxis yAxis = new CategoryAxis();
	public Queu() {
		super(xAxis, yAxis);
		
//       
        setTitle("Country Summary");
        xAxis.setLabel("Value");  
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Country");        
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");       
        series1.getData().add(new XYChart.Data(25601.34, "austria"));
        series1.getData().add(new XYChart.Data(20148.82, "brazil"));
        series1.getData().add(new XYChart.Data(10000, "france"));
        series1.getData().add(new XYChart.Data(35407.15, "italy"));
        series1.getData().add(new XYChart.Data(12000, "usa"));      
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(57401.85, ""));
        series2.getData().add(new XYChart.Data(41941.19, "brazil"));
        series2.getData().add(new XYChart.Data(45263.37, "france"));
        series2.getData().add(new XYChart.Data(117320.16, "italy"));
        series2.getData().add(new XYChart.Data(14845.27, "usa"));  
        
      
        
        getData().addAll(series1, series2);
    
    AnimationTimer d = new AnimationTimer() {
        private long lastUpdate = 0 ;

		@Override
		public void handle(long now) {
			if (now - lastUpdate >= 500_000_000) {
               lastUpdate = now ;
			
            
            
		}}
	};
	
d.start();
    
	}
}