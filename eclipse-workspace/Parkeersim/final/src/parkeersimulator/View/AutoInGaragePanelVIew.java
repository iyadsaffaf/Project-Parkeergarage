/**
 * 
 */
package parkeersimulator.View;

import interfaces.ViewInterface;

import parkeersimulator.MVC.View;
import parkeersimulator.Model.CarViewModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Iyad Saffaf
 *
 */


public class AutoInGaragePanelVIew extends View implements ViewInterface{

	/**
	 * 
	 * 
	 */
	private int adhoc;
	private int pass;
	private int resv; // nieuw
	

	public AutoInGaragePanelVIew() {
		
		features();
		init();
	}

	@Override
	public void init() {
		setBackground(new Color(255,255,255));
		System.out.print("Gf");
//		  
//		XYSeries series = new XYSeries("XYGraph");
//		   series.add(1, 1);
//		   series.add(1, 2);
//		   series.add(2, 1);
//		   series.add(3, 9);
//		   series.add(4, 10);
//
//		 Add the series to your data set
//		   XYSeriesCollection dataset = new XYSeriesCollection();
//		   dataset.addSeries(series);
//		
//		
//		 JFreeChart chart = ChartFactory.createXYLineChart(
//				   "XY Chart", // Title
//				   "x-axis", // x-axis Label
//				   "y-axis", // y-axis Label
//				   dataset, // Dataset
//				   PlotOrientation.VERTICAL, // Plot Orientation
//				   true, // Show Legend
//				   true, // Use tooltips
//				   false // Configure chart to generate URLs?
//				);
//
//
//		
//		 setLayout(new java.awt.BorderLayout());
//		  
//		 ChartPanel CP = new ChartPanel(chart);
//		 
//		add(CP);
//		validate();
		repaint();
	}

	@Override
	public void features() {
		setBackground(new java.awt.Color(0, 204, 102));

		 javax.swing.GroupLayout autoInGaragaPanelLayout = new javax.swing.GroupLayout(this);
	        setLayout(autoInGaragaPanelLayout);
	        autoInGaragaPanelLayout.setHorizontalGroup(
	            autoInGaragaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 513, Short.MAX_VALUE)
	        );
	        autoInGaragaPanelLayout.setVerticalGroup(
	            autoInGaragaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 823, Short.MAX_VALUE)
	        );

		
	}
	
	public  void update(int adhoc,int pass,int resv) {
		this.adhoc=adhoc;
		this.pass=pass;
		this.resv=resv;//nieuw
		this.repaint();
	}
	  
	 public void paintComponent(Graphics g) {
	        g.setColor(Color.WHITE);
	        g.fillRect(0, 0, 200, 200);
	        

	        int amountOfAd_Hoc = adhoc;
	        int amountOfPassCars = pass;
	        int amountOfReservedCars = resv; //4;

	        System.out.println("Check amountOfAd_Hoc = " + amountOfAd_Hoc);
	        System.out.println("Check amountOfPassCars = " + amountOfPassCars);
	        System.out.println("Check amountOfReservedCars = " + amountOfReservedCars);

	        //360 degree circle / 540 parking spots
	        float equalizer = 360f / 540f;
	        int angleAd_Hoc = Math.round(amountOfAd_Hoc * equalizer);
	        int anglePassCars = Math.round(amountOfPassCars * equalizer);
	        int angleReservedCars = Math.round(amountOfReservedCars);

	        /*System.out.println("Equalizer = " +equalizer);
	        System.out.println("Number of ad_hoc = " + amountOfAd_Hoc);
	        System.out.println("Angle = " + angleAd_Hoc);*/

	        //Ad_Hoc slice
	        g.setColor(Color.RED);
	        g.fillArc(10, 10, 180, 180, 0, angleAd_Hoc);
	        //PassCars slice
	        g.setColor(Color.BLUE);
	        g.fillArc(10, 10, 180, 180, angleAd_Hoc, anglePassCars);
	        
	        //ReservedCars slice
	        g.setColor(Color.GREEN);
	        g.fillArc(10, 10, 180, 180, anglePassCars + angleAd_Hoc, angleReservedCars);
	        g.setColor(Color.LIGHT_GRAY);
	        g.fillArc(10, 10, 180, 180, anglePassCars + angleAd_Hoc + angleReservedCars, 360-(angleAd_Hoc + anglePassCars + angleReservedCars));
	    }
}
