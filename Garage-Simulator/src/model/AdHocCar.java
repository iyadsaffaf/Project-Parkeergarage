package model;

import java.util.Random;
import java.awt.*;
import javafx.scene.paint.Color;

public class AdHocCar extends Car {
	private static final Color COLOR = Color.RED;

	/*
	 * Constructor voor AdHocCar
	 * 
	 * @Version 5.3
	 */
	public AdHocCar() {
		Random random = new Random();
		int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
		this.setMinutesLeft(stayMinutes);
		this.setHasToPay(true);
		this.setStayMinutes(stayMinutes);
	}

	/*
	 * @return Color car;
	 * @see model.Car#getColor()
	 */
	public Color getColor() {
		return COLOR;
	}
	/*
	 * @return String TypeCar
	 * @see model.Car#getType()
	 */
	@Override
	public String getType() {
		return "1";
	}
}
