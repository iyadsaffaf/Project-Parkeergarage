package model;

import java.util.Random;
import java.awt.*;
import javafx.scene.paint.Color;

public class ParkingPassCar extends Car {
	private static final Color COLOR=Color.BLUE;
	/**
     * Constructor for objects of class ParkingPassCar
     */
    /**
     * Constructor voor objecten van klasse ParkingPassCar.
     */
    public ParkingPassCar() {
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(false);
        this.setStayMinutes(stayMinutes);
        
    }
    /**
     * @return de Color van deze Car .
     */
    public Color getColor(){
    	return COLOR;
    }
    /**
     * @param color de Color van de Car waar je de verschil tussen de auto's in de garage kun zien 
     * "Abonnementhouder auto of gereseverede auto.." .
     */

	@Override
	/**
     * @return de Type van deze Car .
     */
	public String getType() {
		// TODO Auto-generated method stub
		return "2";
	}
	/**
     * @param String de type van de Car waar je de verschil tussen de auto's in de garage kun zien bijvoorbeeld
     * "AdHoc,..." .
     */
}
