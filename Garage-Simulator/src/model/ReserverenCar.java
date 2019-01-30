package model;

import java.util.Random;

import javafx.scene.paint.Color;

public class ReserverenCar extends Car{
	private static final Color COLOR=Color.YELLOW;

	public ReserverenCar() {
		Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
        this.setStayMinutes(stayMinutes);
	}
	public Color getColor(){
    	return COLOR;
    }
}
