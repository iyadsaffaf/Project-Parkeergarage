package model;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Class CarQueue - Deze class implementeert de Queue
 * 
 * @version	5.3
 */

public class CarQueue {
	private Queue<Car> queue = new LinkedList<>();

	/*
	 * Deze methode voegt een nieuwe Car toe aan de wachtrij
	 * 
	 * @param Car Voegt een nieuwe Car toe aan de LinkedList queue
	 * @return LinkedList queue met de toegevoegde Car
	 */
	public boolean addCar(Car car) {
		return queue.add(car);
	}

	/*
	 * Deze methode verwijdert een Car die in de wachtrij staat
	 * 
	 * @return Car Nieuwe LinkedList queue met de verwijderde Car
	 */
	public Car removeCar() {
		return queue.poll();
	}
	

	/*
	 * Deze methode retourneert een integer die het aantal Cars in de wachtrij
	 * weergeeft
	 * 
	 * @return int De totale grootte van de LinkedList queue
	 */
	public int carsInQueue() {
		return queue.size();
	}

	/*
	 * Deze methode retourneert het een speciale Car die in de wachtrij staat
	 * 
	 * @return Car Car uit de LinkedList queue die bij het element hoort
	 */
	public Car getCar() {
		return queue.element();
	}
}