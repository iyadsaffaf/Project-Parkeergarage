package parkeersimulator.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

import interfaces.ViewInterface;
import parkeersimulator.MVC.View;
import parkeersimulator.Model.Car;
import parkeersimulator.Model.CarViewModel;
import parkeersimulator.Model.Location;

/**
 * @author Iyad saffaf
 *
 */
public class ParkPanelView extends View implements ViewInterface {

	  private Dimension size;
      private Image carParkImage;    
      private CarViewModel c ;
      


	
	
	public ParkPanelView(CarViewModel c) {
		super();
		init();
		features();
		//updateView();
		this.c= c;
	}
	@Override
	public void init() {
		 size = new Dimension(0, 0);
		 
	}

	@Override
	public void features() {
		setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout parkViewPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(parkViewPanelLayout);
        parkViewPanelLayout.setHorizontalGroup(
            parkViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 823, Short.MAX_VALUE)
        );
        parkViewPanelLayout.setVerticalGroup(
            parkViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );

		
	}
    
     
      /**
       * Overridden. Tell the GUI manager how big we would like to be.
       */
      public Dimension getPreferredSize() {
          return new Dimension(800, 500);
      }
  
      /**
       * Overriden. The car park view component needs to be redisplayed. Copy the
       * internal image to screen.
       */
      public void paintComponent(Graphics g) {
          if (carParkImage == null) {
              return;
          }
  
          Dimension currentSize = getSize();
          if (size.equals(currentSize)) {
              g.drawImage(carParkImage, 0, 0, null);
          }
          else {
              // Rescale the previous image.
              g.drawImage(carParkImage, 0, 0, currentSize.width, currentSize.height, null);
          }
      }
  
      public void updateView() {
          //Create a new car park image if the size has changed.
          if (!size.equals(getSize())) {
              size = getSize();
              carParkImage = createImage(size.width, size.height);
          }
          Graphics graphics = carParkImage.getGraphics();
          for(int floor = 0; floor < c.getNumberOfFloors(); floor++) {
              for(int row = 0; row < c.getNumberOfRows(); row++) {
                  for(int place = 0; place < c.getNumberOfPlaces(); place++) {
                      Location location = new Location(floor, row, place);
                      Car car = c.getCarAt(location);
                      Color color = car == null ? Color.white : car.getColor();
                     
                    
                      drawPlace(graphics, location, color);
                  }
              }
          }
          repaint();
      }
  
      /**
       * Paint a place on this car park view in a given color.
       */
      private void drawPlace(Graphics graphics, Location location, Color color) {
          graphics.setColor(color);
          graphics.fillRect(
                  location.getFloor() * 260 + (1 + (int)Math.floor(location.getRow() * 0.5)) * 75 + (location.getRow() % 2) * 20,
                  60 + location.getPlace() * 10,
                  20 - 1,
                  10 - 1); // TODO use dynamic size or constants
      }
  }


