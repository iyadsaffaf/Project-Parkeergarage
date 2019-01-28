/**
 * 
 */
package view;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 * @author eyads
 *
 */
public class AantalAutosView extends PieChart {
		 ObservableList<PieChart.Data> pieChartData;

		public AantalAutosView() {
			super();
			 pieChartData =
		             FXCollections.observableArrayList(
		             new PieChart.Data("Grapefruit", 13),
		             new PieChart.Data("Oranges", 25),
		             new PieChart.Data("Plums", 10),
		             new PieChart.Data("Pears", 22),
		             new PieChart.Data("Apples", 30));
			 
		      setTitle("Imported Fruits");
		      setData(pieChartData);

		      AnimationTimer d = new AnimationTimer() {
		             private long lastUpdate = 0 ;

					@Override
					public void handle(long now) {
						if (now - lastUpdate >= 500_000_000) {
		                    lastUpdate = now ;
		                  System.out.println("sexond");
						
						
						
						   Random d = new Random();
			         	    
			          
			            int x = d.nextInt(30);
			       
			        
			            pieChartData =
			   	             FXCollections.observableArrayList(
			   	             new PieChart.Data("Grapefruit", x),
			   	             new PieChart.Data("Oranges", 25),
			   	             new PieChart.Data("Plums", 10),
			   	             new PieChart.Data("Pears", 22),
			   	             new PieChart.Data("Apples", 30));
			            setAnimated(false);
			  	      setData(pieChartData);

					}}
				};
		    d.start();
		}
}
