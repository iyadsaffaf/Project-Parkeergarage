package view;

import javafx.animation.AnimationTimer;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import model.SimulatorModel;

/*
 * @author Batul Khatib
 * */

public class Reserveren extends AreaChart<Number, Number> {

	private SimulatorModel model;
	final static NumberAxis xAxis = new NumberAxis(1, 31, 1);
	final static NumberAxis yAxis = new NumberAxis();
	private XYChart.Series seriesApril;
	private int day=0;
	private int lastTotal=0;

	public Reserveren(SimulatorModel model) {
		super(xAxis, yAxis);
		this.model = model;

		seriesApril = new XYChart.Series();

		setTitle("Temperature Monitoring (in Degrees C)");
		seriesApril.getData().add(new XYChart.Data(0,0));


		seriesApril.setName("April");


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


	
	private synchronized void update() {
		if (model.getDay() > day) {
			try {
				
				seriesApril.getData().add(new XYChart.Data(model.getDay(), model.getNumberOfReserverenCar()-lastTotal));
				
				getData().addAll(seriesApril);
			day++;
			lastTotal= model.getNumberOfReserverenCar();
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
