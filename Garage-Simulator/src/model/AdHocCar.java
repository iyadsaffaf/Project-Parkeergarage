package model;

import java.util.Random;
import java.awt.*;
import javafx.scene.paint.Color;

public class AdHocCar extends Car {
	private static final Color COLOR=Color.RED;
	
    public AdHocCar() {
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
        this.setStayMinutes(stayMinutes);
    }
    
    public Color getColor(){
    	return COLOR;
    }

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "1";
	}
}
