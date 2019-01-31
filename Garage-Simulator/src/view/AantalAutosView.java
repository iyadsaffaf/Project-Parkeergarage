/**
 * 
 */
package view;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import model.SimulatorModel;

/**
 * @author eyads
 *
 */
public class AantalAutosView extends PieChart {
	private ObservableList<PieChart.Data> pieChartData;
	private SimulatorModel model;

	/**
	 * Constructor voor objecten van klasse AantalAutosView.
	 */
	public AantalAutosView(SimulatorModel model) {
		super();
		this.model = model;
//            setEffect();
		AnimationTimer d = new AnimationTimer() {
			private long lastUpdate = 0;

			@Override

			/*
			 * Deze methode wordt gebruikt om de PieChart up te daten met actuele data
			 */
			public void handle(long now) {
				if (now - lastUpdate >= 1000_000) {
					lastUpdate = now;

					if (model.isIsrunning()) {

						pieChartData = FXCollections.observableArrayList(
								new PieChart.Data("Standaard  (" + model.getNumberOfAdHocCarNow() + ")",
										model.getNumberOfAdHocCarNow()),
								new PieChart.Data("Abonnement  (" + model.getNumberOfParkingPassCarNow() + ")",
										model.getNumberOfParkingPassCarNow()),
								new PieChart.Data("Reservatie  (" + model.getNumberOfReserverenCarNow() + ")",
										model.getNumberOfReserverenCarNow()));
						setTitle("Aantal gereserveerde plaatsen per dag");
						setAnimated(false);
						setData(pieChartData);
						setLabelsVisible(false);
						setLegendSide(Side.LEFT);
						setMaxHeight(380);
						setStartAngle(90);
						setLabelLineLength(10);
					}
				}
			}
		};
		d.start();

		
	}

}
