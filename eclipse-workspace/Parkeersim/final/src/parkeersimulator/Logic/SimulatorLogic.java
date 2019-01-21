package parkeersimulator.Logic;

import java.util.Random;
import java.util.concurrent.Delayed;

import parkeersimulator.Model.AdHocCar;
import parkeersimulator.Model.Car;
import parkeersimulator.Model.CarQueue;
import parkeersimulator.Model.CarViewModel;
import parkeersimulator.Model.Location;
import parkeersimulator.Model.ParkingPassCar;
import parkeersimulator.Model.SimulatorModel;
import parkeersimulator.View.AutoInGaragePanelVIew;
import parkeersimulator.View.ParkPanelView;

public class SimulatorLogic implements Runnable {
	private SimulatorModel d ;
	private CarViewModel c;
	private ParkPanelView p;
	private static final String AD_HOC = SimulatorModel.AD_HOC;
	private static final String PASS =SimulatorModel.PASS;
	private Thread t = new Thread(this);
	private AutoInGaragePanelVIew autoInGaragePanelVIew;
   
	public SimulatorLogic(SimulatorModel d,CarViewModel c,ParkPanelView p,AutoInGaragePanelVIew autoInGaragePanelVIew) {
		super();
		this.d = d;
		this.c=c;
		this.p=p;
		this.autoInGaragePanelVIew= autoInGaragePanelVIew;
	}

	public void run() {
        for (int i = 0; i < 10000; i++) {
            tick();
        }
    }

    private void tick() {
    	advanceTime();
    	handleExit();
    	updateViews();
    	// Pause.
    	if(d.isIsrunning()) {
        try {
            Thread.sleep(d.getTickPause());
        } catch (InterruptedException e) {
            e.printStackTrace();        }
    	
        }
    	
    
    	handleEntrance();
    }

    private void advanceTime(){
        // Advance the time by one minute.
        d.setMinute(d.getMinute()+1);
        while (d.getMinute() > 59) {

            d.setMinute(d.getMinute()-60);
            d.setHour(d.getHour()+1);
        }
        while (d.getHour() > 23) {
            
            d.setHour(d.getHour()-24);
            d.setDay(d.getDay()+1);
        }
        while (d.getDay() > 6) {
        	d.setDay(d.getDay()-7);
        }

    }

    private void handleEntrance(){
    	carsArriving();
    	carsEntering(d.getEntrancePassQueue());
    	carsEntering(d.getEntranceCarQueue());  	
    }
    
    private void handleExit(){
        carsReadyToLeave();
        carsPaying();
        carsLeaving();
    }
    
    private void updateViews(){
    	c.tick();
        // Update the car park view.
        p.updateView();	
        //autoInGaragePanelVIew.update(d.getAdHocCarnumber(), d.getPassCarnumber());
    }
    
    private void carsArriving(){
    	int numberOfCars=getNumberOfCars(d.getWeekDayArrivals(), d.getWeekendArrivals());
        addArrivingCars(numberOfCars, SimulatorModel.getAdHoc());    	
    	numberOfCars=getNumberOfCars(d.getWeekDayPassArrivals(), d.getWeekendPassArrivals());
        addArrivingCars(numberOfCars, SimulatorModel.getPass());    	
    }

    private void carsEntering(CarQueue queue){
        int i=0;
        // Remove car from the front of the queue and assign to a parking space.
    	while (queue.carsInQueue()>0 && 
    			c.getNumberOfOpenSpots()>0 && 
    			i<d.getEnterSpeed()) {
            Car car = queue.removeCar();
            Location freeLocation = c.getFirstFreeLocation();
            c.setCarAt(freeLocation, car);
            i++;
        }
    }
    
    private void carsReadyToLeave(){
        // Add leaving cars to the payment queue.
        Car car = c.getFirstLeavingCar();
        while (car!=null) {
        	if (car.getHasToPay()){
	            car.setIsPaying(true);
	            d.getPaymentCarQueue().addCar(car);
        	}
        	else {
        		carLeavesSpot(car);
        	}
            car = c.getFirstLeavingCar();
        }
    }

    private void carsPaying(){
        // Let cars pay.
    	int i=0;
    	while (d.getPaymentCarQueue().carsInQueue()>0 && i < d.getPaymentSpeed()){
            Car car = d.getPaymentCarQueue().removeCar();
            // TODO Handle payment.
            carLeavesSpot(car);
            i++;
    	}
    }
    
    private void carsLeaving(){
        // Let cars leave.
    	int i=0;
    	while (d.getExitCarQueue().carsInQueue()>0 && i < d.getExitSpeed()){
    		d.getExitCarQueue().removeCar();
            i++;
    	}	
    }
    
    private int getNumberOfCars(int weekDay, int weekend){
        Random random = new Random();

        // Get the average number of cars that arrive per hour.
        int averageNumberOfCarsPerHour = d.getDay() < 5
                ? weekDay
                : weekend;

        // Calculate the number of cars that arrive this minute.
        double standardDeviation = averageNumberOfCarsPerHour * 0.3;
        double numberOfCarsPerHour = averageNumberOfCarsPerHour + random.nextGaussian() * standardDeviation;
        return (int)Math.round(numberOfCarsPerHour / 60);	
    }
    
    private void addArrivingCars(int numberOfCars, String type){
        // Add the cars to the back of the queue.
    	switch(type) {
    	case AD_HOC: 
            for (int i = 0; i < numberOfCars; i++) {
            	d.getEntranceCarQueue().addCar(new AdHocCar());
            	d.setAdHocCarnumber(d.getAdHocCarnumber()+1);
            }
            break;
    	case PASS:
            for (int i = 0; i < numberOfCars; i++) {
            	d.getEntrancePassQueue().addCar(new ParkingPassCar());
            	d.setPassCarnumber(d.getPassCarnumber()+1);
            }
            break;	            
    	}
    }
    
    private void carLeavesSpot(Car car){
    	c.removeCarAt(car.getLocation());
        d.getExitCarQueue().addCar(car);
    }
    
  
	
	
}
