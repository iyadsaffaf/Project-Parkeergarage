package view;

import javafx.animation.AnimationTimer;
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

	public Winst(SimulatorModel model) {
		super(xAxis, yAxis);
		this.model = model;

		xAxis.setLabel("Number of Month");

		// defining a series
		series = new XYChart.Series();
		series.setName("Omzet");

		series.getData().add(new XYChart.Data(0, 0));

		getData().add(series);

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
		if (model.getDay() > day) {
			try {
			series.getData().add(new XYChart.Data(model.getDay(), model.getProfitPerDay().get(0)));
			day++;
			getData().add(series);
			
			}
			catch(Exception d) {
				System.out.print("double");
				
				
			}
		}
		if (day == 7) {
			day = 0;

		}

	}
}
