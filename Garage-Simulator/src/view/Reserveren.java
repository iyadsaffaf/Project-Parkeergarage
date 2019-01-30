package view;


import javafx.animation.AnimationTimer;
import javafx.scene.chart.AreaChart;
//import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import model.SimulatorModel;

/*
 * @author Batul Khatib
 * */

public class Reserveren  extends AreaChart <Number,Number> {
	 final static NumberAxis xAxis = new NumberAxis();
     final static NumberAxis yAxis = new NumberAxis();
     private SimulatorModel model;

	public Reserveren(SimulatorModel model) {
		super(xAxis,yAxis);
		this.model = model;
	
        
       setTitle("Reseveren");
        xAxis.setLabel("Reseveren");  
        yAxis.setLabel("Uren");  
       
        setAnimated(false);
        AnimationTimer d = new AnimationTimer() {
            private long lastUpdate = 0 ;

			@Override
			public void handle(long now) {
				if (now - lastUpdate >= 500_000_000) {
                   lastUpdate = now ;
				
				
                   updateGrafiek();
                   
				}}
			};
			
		d.start();
		    
			}
	         	    
	          
	           
             
	private void updateGrafiek() {
		
                   getData().clear();
              XYChart.Series series = new XYChart.Series();
   		        series.setName("Car Reseveren met abonnement");       
   		        series.getData().add(new XYChart.Data(model.getNumberOfReserverenCar(), model.getHour()));
   		        
   		    
   		   XYChart.Series series1 = new XYChart.Series();
		        series1.setName("Car Reseveren met een parking pass");    
		        series1.getData().add(new XYChart.Data(model.getNumberOfParkingPassCar(),model.getHour()));
		        
		       /* XYChart.Series series2 = new XYChart.Series();  
		        series2.setName("Car Reseveren");   
		        series2.getData().add(new XYChart.Data(model.getNumberOfReserverenCar(),model.getHour()));*/
		        
   		    getData().addAll(series, series1 );
   		  //getData().add(series);
   		
		//getData().add(series2);
   		
      
        
		
   			   
					
	}	
	}
			
