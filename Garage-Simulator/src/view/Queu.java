package view;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import model.*;

public class Queu extends BarChart<Number, String> {
	
	/*
	 * Class Queu - Laat een BarChart zien met daarin de data van alle wachtende auto's voor de parkeergarage
	 * 
	 * @author 		Irena Nowak
	 * @version		29 januari 2019
	 */
	
	private CarQueue queue;
	private Car car;
	private SimulatorModel model;
	final static NumberAxis xAxis = new NumberAxis();
    final static CategoryAxis yAxis = new CategoryAxis();
    
    /*
     * Constructor Queu voor het aanmaken van een nieuwe BarChart
     * 
     * @param SimulatorModel	Het model van de simulator wordt hierbij overgenomen om de data van de wachtrijen te kunnen gebruiken
     */
    
	public Queu(SimulatorModel model) {
		super(xAxis, yAxis);
		this.model = model;

		// Maakt de algemene gegevens van BarChart aan		
        setTitle("Aantal wachtenden auto's");
        xAxis.setLabel("Wachtrij");  
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Garage");   
        
        // Auto's in de wachtrij
     	CarQueue carQueue = model.getEntranceCarQueue();
     	CarQueue passQueue = model.getEntrancePassQueue();
        
        // Het toevoegen van data aan de BarChart              
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("CarQueue");       
        series1.getData().add(new XYChart.Data(carQueue.carsInQueue(), "maandag"));
        series1.getData().add(new XYChart.Data(carQueue.carsInQueue(), "dinsdag"));
        series1.getData().add(new XYChart.Data(carQueue.carsInQueue(), "woensdag"));
        series1.getData().add(new XYChart.Data(carQueue.carsInQueue(), "donderdag"));
        series1.getData().add(new XYChart.Data(carQueue.carsInQueue(), "vrijdag")); 
        series1.getData().add(new XYChart.Data(carQueue.carsInQueue(), "zaterdag"));      
        series1.getData().add(new XYChart.Data(carQueue.carsInQueue(), "zondag"));      
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("PassQueue");
        series2.getData().add(new XYChart.Data(passQueue.carsInQueue(), "maandag"));
        series2.getData().add(new XYChart.Data(passQueue.carsInQueue(), "dinsdag"));
        series2.getData().add(new XYChart.Data(passQueue.carsInQueue(), "woesndag"));
        series2.getData().add(new XYChart.Data(passQueue.carsInQueue(), "donderdag"));
        series2.getData().add(new XYChart.Data(passQueue.carsInQueue(), "vrijdag"));
        series2.getData().add(new XYChart.Data(passQueue.carsInQueue(), "zaterdag"));
        series2.getData().add(new XYChart.Data(passQueue.carsInQueue(), "zondag"));
       
        getData().addAll(series1, series2);
    
        
    // AnimationTimer om de BarChart up-to-date te houden
    AnimationTimer queueTimer = new AnimationTimer() {
        private long lastUpdate = 0 ;

        /*
         * 
         */
        
		@Override
		public void handle(long now) {
			if (now - lastUpdate >= 500_000_000) {
               lastUpdate = now ;
			          
            
		}}
	};
	
queueTimer.start();
    
	}
}