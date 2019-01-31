package view;

import javafx.animation.AnimationTimer;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import model.SimulatorModel;

public class Winst extends LineChart<Number, Number> {
	// defining the axes
	final static NumberAxis xAxis = new NumberAxis();
	final static NumberAxis yAxis = new NumberAxis();
	private int day = 0;
	private SimulatorModel model;
	private Series series;
	private Series oldseries;
	private int count=0;

	public Winst(SimulatorModel model) {
		super(xAxis, yAxis);
		this.model = model;

		xAxis.setLabel("Uur");
		yAxis.setLabel("Euro's");

		// defining a series
		series = new XYChart.Series();
		series.setName("Omzet");

		series.getData().add(new XYChart.Data(0, 0));

		setTitle("Omzet per uur");
		setLegendVisible(false);
		setMaxHeight(380);
		setAnimated(false);

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

	private synchronized void update() {
		if (model.getHour() > day) {
			try {
                
				series.getData().add(new XYChart.Data(count, model.getProfitPerDay().get(count)));
				count++;
				if (oldseries != series) {

					getData().add(series);
					oldseries = series;

				}
			} catch (Exception d) {
				System.out.print("double");

			}
			
			if (model.getHour() == 23) {
				day = 0;

			}else {
				day++;
			}
		}
		

	}
}