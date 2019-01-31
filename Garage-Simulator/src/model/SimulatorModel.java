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
	private ArrayList<Double> profitPerDay;

	private int numberOfAdHocCarNow;
	private int numberOfParkingPassCarNow;
	private int numberOfReserverenCarNow;

	/*
	 * Constructor simulator model
	 * 
	 * @Version 5.3
	 */
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
		this.speedOfSumlator = 500000000;
		this.totalProfit = 0;
		this.profitPerDay = new ArrayList<>();

	}

	/*
	 * @return het aantal verdiepingen
	 */
	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	/*
	 * @para numberOffFloors zet de waarde van het aantal verdiepingen
	 */
	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	/*
	 * @return het aantal rijen.
	 */
	public int getNumberOfRows() {
		return numberOfRows;
	}

	/*
	 * @para numberOfRows zet de waarde naar het aantal rijen.
	 */
	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	/*
	 * @return het aantal parkeerplekken
	 */
	public int getNumberOfPlaces() {
		return numberOfPlaces;
	}

	/*
	 * @para NumberOfPlaces zet de waarde van het aantal parkeerplekken
	 */
	public void setNumberOfPlaces(int numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}

	/*
	 * @return het aantal open plekken.
	 */
	public int getNumberOfOpenSpots() {
		return numberOfOpenSpots;
	}

	/*
	 * parra numberOfOpenSpots zet het aantal van vrije parkeerplekken.
	 */
	public void setNumberOfOpenSpots(int numberOfOpenSpots) {
		this.numberOfOpenSpots = numberOfOpenSpots;
	}

	/*
	 * @ return de locatie van een auto.
	 */
	public Car[][][] getCars() {
		return cars;
	}

	/*
	 * @ para cars zet de locatie van een auto.
	 */
	public void setCars(Car[][][] cars) {
		this.cars = cars;
	}

	/*
	 * @return de grote van de parkeergarage
	 */
	public Dimension getSize() {
		return size;
	}

	/*
	 * @para size zet de groote van de parkeergarage.
	 */
	public void setSize(Dimension size) {
		this.size = size;
	}

	/*
	 * @return geeft de afbeelding voor 1 parkeerplek
	 */
	public Image getCarParkImage() {
		return carParkImage;
	}

	/*
	 * @para carParkImage voegd de image toe voor 1 parkeerplek
	 */
	public void setCarParkImage(Image carParkImage) {
		this.carParkImage = carParkImage;
	}

	/*
	 * @return de tool om te de parkeergarage te tekenen.
	 */
	public GraphicsContext getGc() {
		return gc;
	}

	/*
	 * @para gc zet de tool klaar om de parkeer garage te tekene.
	 */
	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}

	/*
	 * @return de wachtrij bij de ingang
	 */
	public CarQueue getEntranceCarQueue() {
		return entranceCarQueue;
	}

	/*
	 * @para zet de rij bij de ingang
	 */
	public void setEntranceCarQueue(CarQueue entranceCarQueue) {
		this.entranceCarQueue = entranceCarQueue;
	}

	/*
	 * @return de wachtrij bij de ingang voor pashouders
	 */
	public CarQueue getEntrancePassQueue() {
		return entrancePassQueue;
	}

	/*
	 * @para zet de rij bij de ingang voor pashouders
	 */
	public void setEntrancePassQueue(CarQueue entrancePassQueue) {
		this.entrancePassQueue = entrancePassQueue;
	}

	/*
	 * @return de wachtrij bij het betalen
	 */
	public CarQueue getPaymentCarQueue() {
		return paymentCarQueue;
	}

	/*
	 * @para zet de rij bij het betalen
	 */
	public void setPaymentCarQueue(CarQueue paymentCarQueue) {
		this.paymentCarQueue = paymentCarQueue;
	}

	/*
	 * @return de wachtrij bij de uitgang
	 */
	public CarQueue getExitCarQueue() {
		return exitCarQueue;
	}

	/*
	 * @para zet de rij bij het uitrijden
	 */
	public void setExitCarQueue(CarQueue exitCarQueue) {
		this.exitCarQueue = exitCarQueue;
	}
	/*
	 * @return haalt dag op.
	 */

	public int getDay() {
		return day;
	}

	/*
	 * @para zet de dag.
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/*
	 * @return haalt het uur op
	 */
	public int getHour() {
		return hour;
	}

	/*
	 * @para zet het uur
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/*
	 * @return haalt de minuten op.
	 */
	public int getMinute() {
		return minute;
	}

	/*
	 * @para zet het aantal minuten.
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	/*
	 * @return haal het aantal gearriveerde op voor de weekdagen.
	 */
	public int getWeekDayArrivals() {
		return weekDayArrivals;
	}

	/*
	 * @para weekDayArrivals zet de gearriveerde voor de weekdagen.
	 */
	public void setWeekDayArrivals(int weekDayArrivals) {
		this.weekDayArrivals = weekDayArrivals;
	}

	/*
	 * @return haal het aantal gearriveerde op voor de weekdagen.
	 */
	public int getWeekendArrivals() {
		return weekendArrivals;
	}

	/*
	 * @para weekDayArrivals zet de gearriveerde voor het weekend.
	 */
	public void setWeekendArrivals(int weekendArrivals) {
		this.weekendArrivals = weekendArrivals;
	}

	/*
	 * @return haal het aantal gearriveerde op voor de weekdagen
	 */
	public int getWeekDayPassArrivals() {
		return weekDayPassArrivals;
	}

	/*
	 * @para weekDayArrivals zet de gearriveerde met pas voor de weekdagen.
	 */
	public void setWeekDayPassArrivals(int weekDayPassArrivals) {
		this.weekDayPassArrivals = weekDayPassArrivals;
	}

	/*
	 * @return haal het aantal gearriveerde met pass op voor de weekdagen.
	 */
	public int getWeekendPassArrivals() {
		return weekendPassArrivals;
	}

	/*
	 * @para weekDayArrivals zet de gearriveerde met pass voor het weekend.
	 */
	public void setWeekendPassArrivals(int weekendPassArrivals) {
		this.weekendPassArrivals = weekendPassArrivals;
	}

	/*
	 * @return haald de enter snelheid op.
	 */
	public int getEnterSpeed() {
		return enterSpeed;
	}

	/*
	 * @para enterSpeed zet de snelheid van binnenkomen.
	 */
	public void setEnterSpeed(int enterSpeed) {
		this.enterSpeed = enterSpeed;
	}

	/*
	 * @return de betaal snelheid.
	 */
	public int getPaymentSpeed() {
		return paymentSpeed;
	}

	/*
	 * @para paymentSpeed zet de snelheid voor het betalen.
	 */
	public void setPaymentSpeed(int paymentSpeed) {
		this.paymentSpeed = paymentSpeed;
	}

	/*
	 * @return de uitrij snelheid.
	 */
	public int getExitSpeed() {
		return exitSpeed;
	}

	/*
	 * @para exitSpeed zet de uitrij snelheid.
	 */
	public void setExitSpeed(int exitSpeed) {
		this.exitSpeed = exitSpeed;
	}

	/*
	 * @return haald de adHocCar op.
	 */
	public static String getAdHoc() {
		return AD_HOC;
	}

	/*
	 * @return haald de gebruikers met pas op.
	 */
	public static String getPass() {
		return PASS;
	}

	/*
	 * @para location is de locatie waard e auto opgehaald moet worden.
	 * 
	 * @return haald een auto op
	 */
	public Car getCarAt(Location location) {
		if (!locationIsValid(location)) {
			return null;
		}
		return cars[location.getFloor()][location.getRow()][location.getPlace()];
	}

	/*
	 * @para location is de locatie waar gecheckd wordt op die leeg is
	 * 
	 * @return of de locatie leeg is of niet.
	 */
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

	/*
	 * @para location haalt de auto hier weg.
	 * 
	 * @return removed car.
	 */
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

	/*
	 * @para location is de locatie waar de auto moet komen
	 * 
	 * @para car is de auto die op @paralocatie moet komen
	 * 
	 * @return true or false
	 */
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

	/*
	 * Is de klok. zet de minuten/uren/dagen omhoog en omlaag.
	 */
	public void advanceTime() {
		// Advance the time by one minute.
		minute++;
		while (minute > 59) {

			minute -= 60;
			hour++;
		}
		while (hour > 23) {
			getProfitPerDay().add(getTotalProfit());
			setTotalProfit(0);
			hour -= 24;
			day++;
		}
		while (day > 6) {
			day -= 7;
		}

	}
	// Here I will start to intiliaze my variabels that i have made

	/*
	 * @return het aantal adHocCars
	 */
	public int getNumberOfAdHocCar() {
		return numberOfAdHocCar;
	}

	/*
	 * @para set het aantal adHocCars
	 */
	public void setNumberOfAdHocCar(int numberOfAdHocCar) {
		this.numberOfAdHocCar = numberOfAdHocCar;
	}

	/*
	 * @return het aantal pass houders
	 */
	public int getNumberOfParkingPassCar() {
		return numberOfParkingPassCar;
	}

	/*
	 * @para zet het aantal pass houders
	 */
	public void setNumberOfParkingPassCar(int numberOfParkingPassCar) {
		this.numberOfParkingPassCar = numberOfParkingPassCar;
	}

	/*
	 * @return haalt het aantal gereserveerde autos op.
	 */
	public int getNumberOfReserverenCar() {
		return numberOfReserverenCar;
	}

	/*
	 * @para zet het aantal gereserveerde autos
	 */
	public void setNumberOfReserverenCar(int numberOfReserverenCar) {
		this.numberOfReserverenCar = numberOfReserverenCar;
	}

	/*
	 * @return aantal gereserveerde plekken voor de weekdagen.
	 */
	public int getWeekDayReserverenArrivals() {
		return weekDayReserverenArrivals;
	}

	/*
	 * @para zet het aatal gereserveerde plekken voor de weekdagen.
	 */
	public void setWeekDayReserverenArrivals(int weekDayReserverenArrivals) {
		this.weekDayReserverenArrivals = weekDayReserverenArrivals;
	}

	/*
	 * @return aantal gereserveerde plekken voor het weekend.
	 */
	public int getWeekendReserverenArrivals() {
		return weekendReserverenArrivals;
	}

	/*
	 * @para zet het aatal gereserveerde plekken voor het weekend.
	 */
	public void setWeekendReserverenArrivals(int weekendReserverenArrivals) {
		this.weekendReserverenArrivals = weekendReserverenArrivals;
	}

	/*
	 * @return haalt reserveringen op.
	 */
	public static String getRes() {
		return RES;
	}

	/*
	 * @return haalt de snelheid van de simulator op.
	 */
	public int getSpeedOfSumlator() {
		return speedOfSumlator;
	}

	/*
	 * @para zet de snelheid van de simulator.
	 */
	public void setSpeedOfSumlator(int speedOfSumlator) {
		this.speedOfSumlator = speedOfSumlator;
	}

	/*
	 * @return geeft aan of de applicatie draait.
	 */
	public boolean isIsrunning() {
		return isrunning;
	}

	/*
	 * @para isRunning zet of de applicatie aan het draaien is.
	 */
	public void setIsrunning(boolean isrunning) {
		this.isrunning = isrunning;
	}

	/*
	 * @return het aantal profit per uur.
	 */
	public double getTotalProfit() {
		return totalProfit;
	}

	/*
	 * @para zet het aatal profit per uur.
	 */
	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}

	/*
	 * @return een arraylist van winst per uur.
	 */
	public ArrayList<Double> getProfitPerDay() {
		return profitPerDay;
	}

	/*
	 * @para profitPerHour voegt de winst van een uur toe aan de arrayList 
	 */
	public void setProfitPerDay(ArrayList<Double> profitPerHour) {
		this.profitPerDay = profitPerHour;
	}
	/*
	 * @return  het aantal adHocCar van totaal.
	 */
	public int getNumberOfAdHocCarNow() {
		return numberOfAdHocCarNow;
	}

	/*
	 * @para numberOfAdHocCarNow zet het aantal adHocCars in totaal.
	 */
	public void setNumberOfAdHocCarNow(int numberOfAdHocCarNow) {
		this.numberOfAdHocCarNow = numberOfAdHocCarNow;
	}
	/*
	 * @return  het aantal Pass houders van totaal.
	 */
	public int getNumberOfParkingPassCarNow() {
		return numberOfParkingPassCarNow;
	}
	/*
	 * @para numberOfAdHocCarNow zet het aantal pass houders in totaal.
	 */
	public void setNumberOfParkingPassCarNow(int numberOfParkingPassCarNow) {
		this.numberOfParkingPassCarNow = numberOfParkingPassCarNow;
	}

	/*
	 * @return  het aantal reserveringen in totaal.
	 */
	public int getNumberOfReserverenCarNow() {
		return numberOfReserverenCarNow;
	}
	/*
	 * @para numberOfAdHocCarNow zet het aantal reserveringen in totaal.
	 */
	public void setNumberOfReserverenCarNow(int numberOfReserverenCarNow) {
		this.numberOfReserverenCarNow = numberOfReserverenCarNow;
	}

}
