package model;

import java.util.Random;
import java.awt.*;
import javafx.scene.paint.Color;

public class ParkingPassCar extends Car {
	private static final Color COLOR=Color.BLUE;
	
    public ParkingPassCar() {
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(false);
        this.setStayMinutes(stayMinutes);
    }
    
    public Color getColor(){
    	return COLOR;
    }

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "2";
	}
}
