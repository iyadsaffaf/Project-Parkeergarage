package view;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import model.*;

public class Queu extends BarChart<String,Number > {
	
	/*
	 * Class Queu - Laat een BarChart zien met daarin de data van alle wachtende auto's voor de parkeergarage
	 * 
	 * @author  	Irena Nowak 
	 * @version		29 januari 2019
	 */
	
	private CarQueue queue;
	private Car car;
	private SimulatorModel model;
    final static CategoryAxis xAxis = new CategoryAxis();
    final static NumberAxis yAxis = new NumberAxis(0, 14, 2);
    /*
     * Constructor Queu voor het aanmaken van een nieuwe BarChart
     * 
     * @param SimulatorModel	Het model van de simulator wordt hierbij overgenomen om de data van de wachtrijen te kunnen gebruiken
     */
    
	public Queu(SimulatorModel model) {
		super(xAxis, yAxis);
		this.model = model;

		// Maakt de algemene gegevens van BarChart aan		
        xAxis.setLabel("Locatie");  
        yAxis.setLabel("Auto('s)");   
        
        updateGrafiek();
    
        
    // AnimationTimer maakt een nieuwe timer aan zodat we actuele data kunnen weergeven
    AnimationTimer queueTimer = new AnimationTimer() {
        private long lastUpdate = 0 ;
        
		@Override
		public void handle(long now) {
			if (now - lastUpdate >= 500_000_000) {
               lastUpdate = now ;
			          
                      updateGrafiek();
            
		}}
	};
	
queueTimer.start();
    
	}
	
	/*
	 * Deze methode wordt gebruikt om de BarChart up te daten met actuele data
	 */
	
	private void updateGrafiek() {
		getData().clear();
		        
		        // Auto's in de wachtrij
		     	CarQueue carQueue = model.getEntranceCarQueue();
		     	CarQueue passQueue = model.getEntrancePassQueue();
		     	CarQueue exitQueue = model.getExitCarQueue();
		     	CarQueue paymentQueue = model.getPaymentCarQueue();
		        setAnimated(false);
		        
		        // Het toevoegen van data aan de BarChart              
		        XYChart.Series series = new XYChart.Series();
		        series.setName("Wachtrij(en)");       
		        series.getData().add(new XYChart.Data("Ingang",carQueue.carsInQueue()));
		        series.getData().add(new XYChart.Data( "Abonnement",passQueue.carsInQueue()));
		        series.getData().add(new XYChart.Data("Uitgang",exitQueue.carsInQueue()));
		        series.getData().add(new XYChart.Data("Betalend" ,paymentQueue.carsInQueue()));
		       
		        getData().add(series);
		        setTitle("Hoeveelheid wachtende auto's");
		        setLegendSide(Side.LEFT);
		        setMaxHeight(380);
    }
}