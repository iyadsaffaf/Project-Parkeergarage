package view;


import javafx.animation.AnimationTimer;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import model.SimulatorModel;

/*
 *Class Winst - Laat een LineChart zien met daarin de data van alle de omzet van geparkeerde auto's in de garage per uur
 * @author Batul Khatib
 * @version  5.3
 * * */

public class Winst extends LineChart<Number, Number> {

	final static NumberAxis xAxis = new NumberAxis();
	final static NumberAxis yAxis = new NumberAxis();
	private int day = 0;
	private SimulatorModel model;
	private Series series;
	private Series oldseries;

	/*
	 * * Constructor voor objecten van klasse Winst"omzet" view.
	 */
	public Winst(SimulatorModel model) {
		super(xAxis, yAxis);
		this.model = model;
		// Het algemene gegevens van de grafiek.
		xAxis.setLabel("Dag");
		yAxis.setLabel("Euro's");

		series = new XYChart.Series();
		series.setName("Omzet");

		series.getData().add(new XYChart.Data(0, 0));

		setTitle("Omzet per dag");
		setLegendVisible(false);
		setMaxHeight(380);
		setAnimated(false);
		// AnimationTimer maakt een nieuwe timer aan zodat we actuele data kunnen
		// weergeven
		AnimationTimer d = new AnimationTimer() {
			private long lastUpdate = 0;

			@Override
			public void handle(long now) {
				if (now - lastUpdate >= 1000_000_000) {
					lastUpdate = now;
					update();
				}
			}
		};
		d.start();

	}

	/*
	 * Deze methode wordt gebruikt om de LineChart up te daten met actuele data
	 */
	private synchronized void update() {
		if (model.getDay() > day) {
			try {

				series.getData().add(new XYChart.Data(model.getDay(), model.getProfitPerDay().get(day)));
				day++;
				if (oldseries != series) {

					getData().add(series);
					oldseries = series;

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
