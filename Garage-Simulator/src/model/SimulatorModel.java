package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Iyad saffaf
 *
 */
public class SimulatorModel {

	public static final String AD_HOC = "1";
	public static final String PASS = "2";
	public static final String RESV = "5";
	
	
	private CarQueue entranceCarQueue;
    private CarQueue entrancePassQueue;
    private CarQueue paymentCarQueue;
    private CarQueue exitCarQueue;
   // private SimulatorView simulatorView;
    private int AdHocCarnumber=0;
    private int passCarnumber=0;
    
    public int day = 0;
    public int hour = 0;
  
	public int minute = 0;

    private int tickPause = 100;

    private int weekDayArrivals= 100; // average number of arriving cars per hour
    private int weekendArrivals = 200; // average number of arriving cars per hour
    private int weekDayPassArrivals= 50; // average number of arriving cars per hour
    private int weekendPassArrivals = 5; // average number of arriving cars per hour
    private int weekDayResvArrivals = 30;
    private int weekendResvArrivals = 10;

    private int enterSpeed = 3; // number of cars that can enter per minute
    private int paymentSpeed = 7; // number of cars that can pay per minute
    private int exitSpeed = 5; // number of cars that can leave per minute
    private boolean isrunning;
    
    private double totalProfit;
    private ArrayList<Double> profitPerHour = new ArrayList<>();
    
  
	public SimulatorModel() {
		entranceCarQueue = new CarQueue();
        entrancePassQueue = new CarQueue();
        paymentCarQueue = new CarQueue();
        exitCarQueue = new CarQueue();
        isrunning=true;
       // simulatorView = new SimulatorView(3, 6, 30);
	}
	
//	public void advanceTime(){
//        // Advance the time by one minute.
//        minute++;
//        while (minute > 59) {
//            minute -= 60;
//            hour++;
//        }
//        while (hour > 23) {
//            hour -= 24;
//            day++;
//        }
//        while (day > 6) {
//            day -= 7;
//        }
//
//    }
	
	public int getNumberOfCars(int weekDay, int weekend){
        Random random = new Random();

        // Get the average number of cars that arrive per hour.
        int averageNumberOfCarsPerHour = day < 5
                ? weekDay
                : weekend;

        // Calculate the number of cars that arrive this minute.
        double standardDeviation = averageNumberOfCarsPerHour * 0.3;
        double numberOfCarsPerHour = averageNumberOfCarsPerHour + random.nextGaussian() * standardDeviation;
        return (int)Math.round(numberOfCarsPerHour / 60);	
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

		public int getTickPause() {
			return tickPause;
		}

		public void setTickPause(int tickPause) {
			this.tickPause = tickPause;
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
		
		public int getWeekDayResvArrivals() {
			return weekDayResvArrivals;
		}
		
		public void setWeekDayResvArrivals(int weekDayResvArrivals) {
			this.weekDayResvArrivals = weekDayResvArrivals;
		}

		public int getWeekendResvArrivals() {
			return weekendResvArrivals;
		}
		
		public void setWeekendResvArrivals(int weekDayResvArrivals) {
			this.weekendResvArrivals = weekDayResvArrivals;
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
		
		public static String getResv() {
			return RESV;
		}

		public boolean isIsrunning() {
			return isrunning;
		}

		public void setIsrunning(boolean isrunning) {
			this.isrunning = isrunning;
		}

		public int getAdHocCarnumber() {
			return AdHocCarnumber;
		}

		public void setAdHocCarnumber(int adHocCarnumber) {
			AdHocCarnumber = adHocCarnumber;
		}

		public int getPassCarnumber() {
			return passCarnumber;
		}

		public void setPassCarnumber(int passCarnumber) {
			this.passCarnumber = passCarnumber;
		}

		public double getTotalProfit() {
			return totalProfit;
		}

		public void setTotalProfit(double totalProfit) {
			this.totalProfit = totalProfit;
		}

		public ArrayList<Double> getProfitPerHour() {
			return profitPerHour;
		}

		public void setProfitPerHour(ArrayList<Double> profitPerHour) {
			this.profitPerHour = profitPerHour;
		}

}