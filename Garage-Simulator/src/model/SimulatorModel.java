package model;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

public class SimulatorModel {
	private int numberOfFloors;
	private int numberOfRows;
	private int numberOfPlaces;
	private int numberOfOpenSpots;
	private Car[][][] cars;
	private Dimension size;
	private Image carParkImage;
	private GraphicsContext gc;
	private static final String AD_HOC = "1";
	private static final String PASS = "2";
	private static final String RES = "3";

	private CarQueue entranceCarQueue;
	private CarQueue entrancePassQueue;
	private CarQueue paymentCarQueue;
	private CarQueue exitCarQueue;
	private int day;
	private int hour;
	private int minute;
	private int weekDayArrivals; // average number of arriving cars per hour
	private int weekendArrivals; // average number of arriving cars per hour
	private int weekDayPassArrivals; // average number of arriving cars per hour
	private int weekendPassArrivals; // average number of arriving cars per hour
	private int enterSpeed; // number of cars that can enter per minute
	private int paymentSpeed; // number of cars that can pay per minute
	private int exitSpeed; // number of cars that can leave per minute

	// Variabels That I have made
	private int numberOfAdHocCar;
	private int numberOfParkingPassCar;
	private int numberOfReserverenCar;
	private int weekDayReserverenArrivals;
	private int weekendReserverenArrivals;
	private int speedOfSumlator;
	private boolean isrunning;

	private double totalProfit;
    private ArrayList<Double> profitPerDay ;
	public SimulatorModel() {
		super();
		this.numberOfFloors = 3;
		this.numberOfRows = 6;
		this.numberOfPlaces = 30;
		this.numberOfOpenSpots = numberOfFloors * numberOfRows * numberOfPlaces;
		this.cars = new Car[numberOfFloors][numberOfRows][numberOfPlaces];
		this.size = new Dimension(0, 0);
		this.carParkImage = carParkImage;
		this.gc = gc;
		this.entranceCarQueue = new CarQueue();
		this.entrancePassQueue = new CarQueue();
		this.paymentCarQueue = new CarQueue();
		this.exitCarQueue = new CarQueue();
		this.day = 0;
		this.hour = 0;
		this.minute = 0;
		this.weekDayArrivals = 100;
		this.weekendArrivals = 200;
		this.weekDayPassArrivals = 50;
		this.weekendPassArrivals = 5;
		this.enterSpeed = 3;
		this.paymentSpeed = 7;
		this.exitSpeed = 5;
		
		//
		this.numberOfAdHocCar = 0;
		this.numberOfParkingPassCar = 0;
		this.numberOfParkingPassCar = 0;
		this.weekDayReserverenArrivals = 100;
		this.weekendReserverenArrivals = 0;
		this.speedOfSumlator=500000000;
		this.totalProfit=0;
	    this.profitPerDay = new ArrayList<>();
	    
	    
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public int getNumberOfPlaces() {
		return numberOfPlaces;
	}

	public void setNumberOfPlaces(int numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}

	public int getNumberOfOpenSpots() {
		return numberOfOpenSpots;
	}

	public void setNumberOfOpenSpots(int numberOfOpenSpots) {
		this.numberOfOpenSpots = numberOfOpenSpots;
	}

	public Car[][][] getCars() {
		return cars;
	}

	public void setCars(Car[][][] cars) {
		this.cars = cars;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public Image getCarParkImage() {
		return carParkImage;
	}

	public void setCarParkImage(Image carParkImage) {
		this.carParkImage = carParkImage;
	}

	public GraphicsContext getGc() {
		return gc;
	}

	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}

	public CarQueue getEntranceCarQueue() {
		return entranceCarQueue;
	}

	public void setEntranceCarQueue(CarQueue entranceCarQueue) {
		this.entranceCarQueue = entranceCarQueue;
	}

	public CarQueue getEntrancePassQueue() {
		return entrancePassQueue;
	}

	public void setEntrancePassQueue(CarQueue entrancePassQueue) {
		this.entrancePassQueue = entrancePassQueue;
	}

	public CarQueue getPaymentCarQueue() {
		return paymentCarQueue;
	}

	public void setPaymentCarQueue(CarQueue paymentCarQueue) {
		this.paymentCarQueue = paymentCarQueue;
	}

	public CarQueue getExitCarQueue() {
		return exitCarQueue;
	}

	public void setExitCarQueue(CarQueue exitCarQueue) {
		this.exitCarQueue = exitCarQueue;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getWeekDayArrivals() {
		return weekDayArrivals;
	}

	public void setWeekDayArrivals(int weekDayArrivals) {
		this.weekDayArrivals = weekDayArrivals;
	}

	public int getWeekendArrivals() {
		return weekendArrivals;
	}

	public void setWeekendArrivals(int weekendArrivals) {
		this.weekendArrivals = weekendArrivals;
	}

	public int getWeekDayPassArrivals() {
		return weekDayPassArrivals;
	}

	public void setWeekDayPassArrivals(int weekDayPassArrivals) {
		this.weekDayPassArrivals = weekDayPassArrivals;
	}

	public int getWeekendPassArrivals() {
		return weekendPassArrivals;
	}

	public void setWeekendPassArrivals(int weekendPassArrivals) {
		this.weekendPassArrivals = weekendPassArrivals;
	}

	public int getEnterSpeed() {
		return enterSpeed;
	}

	public void setEnterSpeed(int enterSpeed) {
		this.enterSpeed = enterSpeed;
	}

	public int getPaymentSpeed() {
		return paymentSpeed;
	}

	public void setPaymentSpeed(int paymentSpeed) {
		this.paymentSpeed = paymentSpeed;
	}

	public int getExitSpeed() {
		return exitSpeed;
	}

	public void setExitSpeed(int exitSpeed) {
		this.exitSpeed = exitSpeed;
	}

	public static String getAdHoc() {
		return AD_HOC;
	}

	public static String getPass() {
		return PASS;
	}

	public Car getCarAt(Location location) {
		if (!locationIsValid(location)) {
			return null;
		}
		return cars[location.getFloor()][location.getRow()][location.getPlace()];
	}

	private boolean locationIsValid(Location location) {
		int floor = location.getFloor();
		int row = location.getRow();
		int place = location.getPlace();
		if (floor < 0 || floor >= numberOfFloors || row < 0 || row > numberOfRows || place < 0
				|| place > numberOfPlaces) {
			return false;
		}
		return true;
	}

	public Car removeCarAt(Location location) {
		if (!locationIsValid(location)) {
			return null;
		}
		Car car = getCarAt(location);
		if (car == null) {
			return null;
		}
		cars[location.getFloor()][location.getRow()][location.getPlace()] = null;
		car.setLocation(null);
		numberOfOpenSpots++;
		return car;
	}

	public boolean setCarAt(Location location, Car car) {
		if (!locationIsValid(location)) {
			return false;
		}
		Car oldCar = getCarAt(location);
		if (oldCar == null) {
			cars[location.getFloor()][location.getRow()][location.getPlace()] = car;
			car.setLocation(location);
			numberOfOpenSpots--;
			return true;
		}
		return false;
	}

	public void advanceTime() {
		// Advance the time by one minute.
		minute++;
		while (minute > 59) {
			
			minute -= 60;
			hour++;
		}
		while (hour > 23) {
			getProfitPerDay().add(getTotalProfit());
			System.out.println(getProfitPerDay());
			setTotalProfit(0);
			hour -= 24;
			day++;
		}
		while (day > 6) {
			day -= 7;
		}

	}
	// Here I will start to intiliaze my variabels that i have made

	public int getNumberOfAdHocCar() {
		return numberOfAdHocCar;
	}

	public void setNumberOfAdHocCar(int numberOfAdHocCar) {
		this.numberOfAdHocCar = numberOfAdHocCar;
	}

	public int getNumberOfParkingPassCar() {
		return numberOfParkingPassCar;
	}

	public void setNumberOfParkingPassCar(int numberOfParkingPassCar) {
		this.numberOfParkingPassCar = numberOfParkingPassCar;
	}

	public int getNumberOfReserverenCar() {
		return numberOfReserverenCar;
	}

	public void setNumberOfReserverenCar(int numberOfReserverenCar) {
		this.numberOfReserverenCar = numberOfReserverenCar;
	}

	public int getWeekDayReserverenArrivals() {
		return weekDayReserverenArrivals;
	}

	public void setWeekDayReserverenArrivals(int weekDayReserverenArrivals) {
		this.weekDayReserverenArrivals = weekDayReserverenArrivals;
	}

	public int getWeekendReserverenArrivals() {
		return weekendReserverenArrivals;
	}

	public void setWeekendReserverenArrivals(int weekendReserverenArrivals) {
		this.weekendReserverenArrivals = weekendReserverenArrivals;
	}

	public static String getRes() {
		return RES;
	}

	public int getSpeedOfSumlator() {
		return speedOfSumlator;
	}

	public void setSpeedOfSumlator(int speedOfSumlator) {
		this.speedOfSumlator = speedOfSumlator;
	}

	public boolean isIsrunning() {
		return isrunning;
	}

	public void setIsrunning(boolean isrunning) {
		this.isrunning = isrunning;
	}
	public double getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}

	public ArrayList<Double> getProfitPerDay() {
		return profitPerDay;
	}

	public void setProfitPerDay(ArrayList<Double> profitPerHour) {
		this.profitPerDay = profitPerHour;
	}

}
