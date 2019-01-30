/**
 * 
 */
package view;

import javafx.scene.canvas.Canvas;

/**
 * @author eyads
 *
 */

import java.awt.Dimension;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.AdHocCar;
import model.Car;
import model.CarQueue;
import model.Location;
import model.ParkingPassCar;
import model.ReserverenCar;
import model.SimulatorModel;

public class SimulatorView extends Canvas {
	private GraphicsContext gc;
	private SimulatorModel model;
	private static final String AD_HOC = "1";
	private static final String PASS = "2";
	private static final String RES = "3";

	/**
	 * 
	 */
	public SimulatorView(SimulatorModel model) {
		this.model = model;
		setHeight(360.0);
		setWidth(841.0);

		gc = getGraphicsContext2D();
		AnimationTimer d = new AnimationTimer() {
			private long lastUpdate = 0;

			@Override
			public void handle(long now) {
//				if (now - lastUpdate >= model.getSpeedOfSumlator()) {
//				if (now - lastUpdate >= 5) {
					lastUpdate = now;
					if (model.isIsrunning()) {
						tickBig();

//					}

				}
			}
		};
		d.start();
	}

	public Location getFirstFreeLocation() {
		for (int floor = 0; floor < model.getNumberOfFloors(); floor++) {
			for (int row = 0; row < model.getNumberOfRows(); row++) {
				for (int place = 0; place < model.getNumberOfPlaces(); place++) {
					Location location = new Location(floor, row, place);
					if (model.getCarAt(location) == null) {
						return location;
					}
				}
			}
		}
		return null;
	}

	public Car getFirstLeavingCar() {
		for (int floor = 0; floor < model.getNumberOfFloors(); floor++) {
			for (int row = 0; row < model.getNumberOfRows(); row++) {
				for (int place = 0; place < model.getNumberOfPlaces(); place++) {
					Location location = new Location(floor, row, place);
					Car car = model.getCarAt(location);
					if (car != null && car.getMinutesLeft() <= 0 && !car.getIsPaying()) {
						return car;
					}
				}
			}
		}
		return null;
	}

	public void tick() {
		for (int floor = 0; floor < model.getNumberOfFloors(); floor++) {
			for (int row = 0; row < model.getNumberOfRows(); row++) {
				for (int place = 0; place < model.getNumberOfPlaces(); place++) {
					Location location = new Location(floor, row, place);
					Car car = model.getCarAt(location);
					if (car != null) {
						car.tick();
					}
				}
			}
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(800, 500);
	}

	public void updateView() {

		for (int floor = 0; floor < model.getNumberOfFloors(); floor++) {
			for (int row = 0; row < model.getNumberOfRows(); row++) {
				for (int place = 0; place < model.getNumberOfPlaces(); place++) {

					Location location = new Location(floor, row, place);
					Car car = model.getCarAt(location);
					Color color = car == null ? Color.WHITE : car.getColor();
					drawPlace(gc, location, color);
				}
			}
		}
	}

	/**
	 * Paint a place on this car park view in a given color.
	 */
	private void drawPlace(GraphicsContext graphics, Location location, Color color) {

		graphics.setFill(color);
		graphics.setStroke(color);
		graphics.fillRect(location.getFloor() * 260 + (1 + (int) Math.floor(location.getRow() * 0.5)) * 75
				+ (location.getRow() % 2) * 20, 60 + location.getPlace() * 10, 20 - 1, 10 - 1); // TODO use dynamic size
																								// or constants

	}

	private void tickBig() {
		model.advanceTime();
		handleExit();
		updateViews();

		handleEntrance();
	}

	private void handleEntrance() {
		carsArriving();
		carsEntering(model.getEntrancePassQueue());
		carsEntering(model.getEntranceCarQueue());
	}

	private void handleExit() {
		carsReadyToLeave();
		carsPaying();
		carsLeaving();
	}

	private void updateViews() {
		tick();
		updateView();
	}

	private void carsArriving() {
		int numberOfCars = getNumberOfCars(model.getWeekDayArrivals(), model.getWeekendArrivals());
		addArrivingCars(numberOfCars, AD_HOC);
		numberOfCars = getNumberOfCars(model.getWeekDayPassArrivals(), model.getWeekendPassArrivals());
		addArrivingCars(numberOfCars, PASS);
		numberOfCars = getNumberOfCars(model.getWeekDayReserverenArrivals(), model.getWeekendReserverenArrivals());
		addArrivingCars(numberOfCars, RES);
//		
	}

	private void carsEntering(CarQueue queue) {
		int i = 0;
		// Remove car from the front of the queue and assign to a parking space.
		while (queue.carsInQueue() > 0 && model.getNumberOfOpenSpots() > 0 && i < model.getEnterSpeed()) {

			Car car = queue.removeCar();

			Location freeLocation = getFirstFreeLocation();
			model.setCarAt(freeLocation, car);
			i++;
		}
	}

	private void carsReadyToLeave() {
		// Add leaving cars to the payment queue.
		Car car = getFirstLeavingCar();
		while (car != null) {
			if (car.getHasToPay()) {
				car.setIsPaying(true);
				model.getPaymentCarQueue().addCar(car);
			} else {
				carLeavesSpot(car);
			}
			car = getFirstLeavingCar();
		}
	}

	private void carsPaying() {
		// Let cars pay.
		int i = 0;
		while (model.getPaymentCarQueue().carsInQueue() > 0 && i < model.getPaymentSpeed()) {

			model.setTotalProfit(model.getTotalProfit() + model.getPaymentCarQueue().getCar().profitCar());

			Car car = model.getPaymentCarQueue().removeCar();
			// TODO Handle payment.
			carLeavesSpot(car);
			i++;
		}
	}

	private void carsLeaving() {
		// Let cars leave.
		int i = 0;
		while (model.getExitCarQueue().carsInQueue() > 0 && i < model.getExitSpeed()) {

			model.getExitCarQueue().removeCar();
			i++;
		}
	}

	private int getNumberOfCars(int weekDay, int weekend) {
		Random random = new Random();

		// Get the average number of cars that arrive per hour.
		int averageNumberOfCarsPerHour = model.getDay() < 5 ? weekDay : weekend;

		// Calculate the number of cars that arrive this minute.
		double standardDeviation = averageNumberOfCarsPerHour * 0.3;
		double numberOfCarsPerHour = averageNumberOfCarsPerHour + random.nextGaussian() * standardDeviation;
		return (int) Math.round(numberOfCarsPerHour / 60);
	}

	private void addArrivingCars(int numberOfCars, String type) {
		// Add the cars to the back of the queue.
		switch (type) {
		case AD_HOC:
			for (int i = 0; i < numberOfCars; i++) {
				model.getEntranceCarQueue().addCar(new AdHocCar());
//				

				model.setNumberOfAdHocCar(model.getNumberOfAdHocCar() + 1);
				model.setNumberOfAdHocCarNow(model.getNumberOfAdHocCarNow() + 1);
			}
			break;
		case PASS:
			for (int i = 0; i < numberOfCars; i++) {
				model.getEntrancePassQueue().addCar(new ParkingPassCar());
				model.setNumberOfParkingPassCar(model.getNumberOfParkingPassCar() + 1);
				model.setNumberOfParkingPassCarNow(model.getNumberOfParkingPassCarNow() + 1);

			}
			break;

		case RES:
			for (int i = 0; i < numberOfCars; i++) {
				model.getEntrancePassQueue().addCar(new ReserverenCar());
				model.setNumberOfReserverenCar(model.getNumberOfReserverenCar() + 1);
				model.setNumberOfReserverenCarNow(model.getNumberOfReserverenCarNow() + 1);
			}
			break;
		}
	}

	private void carLeavesSpot(Car car) {
		if (car.getType().contentEquals(AD_HOC)) {
			model.setNumberOfAdHocCarNow(model.getNumberOfAdHocCarNow() - 1);
		} else if (car.getType().contentEquals(PASS)) {
			model.setNumberOfParkingPassCarNow(model.getNumberOfParkingPassCarNow() - 1);
		} else if (car.getType().contentEquals(RES)) {
			model.setNumberOfReserverenCarNow(model.getNumberOfReserverenCarNow() - 1);

		}

		model.removeCarAt(car.getLocation());
		model.getExitCarQueue().addCar(car);

	}

}
