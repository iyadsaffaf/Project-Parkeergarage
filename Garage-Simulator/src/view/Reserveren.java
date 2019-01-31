package view;

import javafx.animation.AnimationTimer;
import javafx.geometry.Side;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import model.SimulatorModel;

/*
 *Class Reserveren - Laat een Area Chart zien met daarin de data van alle geparkeerde auto's in de parkeergarage
 * @author Batul Khatib
 * @version  5.3
 * * */

public class Reserveren extends AreaChart<Number, Number> {

	private SimulatorModel model;
	final static NumberAxis xAxis = new NumberAxis(1, 31, 1);
	final static NumberAxis yAxis = new NumberAxis();
	private XYChart.Series seriesDag;
	private XYChart.Series oldseriesDag;

	private int day = 0;
	private int lastTotal = 0;

	/**
	 * Constructor for objects of class Reseveren view
	 */
	/**
	 * Constructor voor objecten van klasse Reseveren view.
	 */
	public Reserveren(SimulatorModel model) {
		super(xAxis, yAxis);
		this.model = model;

		seriesDag = new XYChart.Series();
		// Het algemene gegevens van de grafiek.

		setTitle("Aantal gereserveerde plaatsen per dag");
		yAxis.setLabel("Plaats(en)");
		xAxis.setLabel("Dag");
		seriesDag.getData().add(new XYChart.Data(0, 0));

		seriesDag.setName("Dag");
		setLegendVisible(false);
		setMaxHeight(380);

		// AnimationTimer maakt een nieuwe timer aan zodat we actuele data kunnen
		// weergeven

		AnimationTimer d = new AnimationTimer() {
			private long lastUpdate = 0;

			@Override
			public void handle(long now) {
				if (now - lastUpdate >= 500_000_000) {
					lastUpdate = now;

					update();

				}
			}
		};

		d.start();

	}
	/*
	 * Deze methode wordt gebruikt om de AreaChart up te daten met actuele data
	 */

	private synchronized void update() {
		if (model.getDay() > day) {
			try {
				// Het toevoegen van data aan de AreaChart
				seriesDag.getData().add(new XYChart.Data(model.getDay(), model.getNumberOfReserverenCar() - lastTotal));

				day++;
				lastTotal = model.getNumberOfReserverenCar();
				if (oldseriesDag != seriesDag) {

					getData().add(seriesDag);
					oldseriesDag = seriesDag;

				}

			} catch (Exception d) {
				System.out.print("double");

			}
		}
		if (model.getDay() > 6) {
			day = 0;

		}

	}

}
