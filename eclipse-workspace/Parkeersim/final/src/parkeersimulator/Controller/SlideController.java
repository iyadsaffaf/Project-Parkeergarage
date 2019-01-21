package parkeersimulator.Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLayeredPane;

import parkeersimulator.MVC.Controller;
import parkeersimulator.MVC.Model;
import parkeersimulator.Model.SimulatorModel;
import parkeersimulator.View.AutoInGaragePanelVIew;
import parkeersimulator.View.QueuesPanelView;
import parkeersimulator.View.SlidePanelView;

public class SlideController extends Controller implements MouseListener{
	
    private SlidePanelView slidePanelView;
    private SimulatorModel model;
    private JLayeredPane layeredPane;
    private AutoInGaragePanelVIew autoInGaragePanelVIew;
    private QueuesPanelView queuesPanelView;
    
	/**
	 * @param model
	 * @param slidePanelView
	 * @param model2
	 * @param layeredPane
	 */
	public SlideController( SlidePanelView slidePanelView, SimulatorModel model2,
			JLayeredPane layeredPane,AutoInGaragePanelVIew autoInGaragePanelVIew ,QueuesPanelView queuesPanelView) {
		super(model2);
		this.slidePanelView = slidePanelView;
		model = model2;
		this.layeredPane = layeredPane;
		this.queuesPanelView=queuesPanelView;
		this.autoInGaragePanelVIew=autoInGaragePanelVIew;
		
		slidePanelView.getAutoInGarageSlide().addMouseListener(this);
		slidePanelView.getQueuSlide().addMouseListener(this);
		slidePanelView.getWinstSlide().addMouseListener(this);
		slidePanelView.getReserverenSlide().addMouseListener(this);
		slidePanelView.getResetSlide().addMouseListener(this);
		
		slidePanelView.getjPanel7().setVisible(true);
		slidePanelView.getjPanel10().setVisible(false);
		slidePanelView.getjPanel16().setVisible(false);
		slidePanelView.getjPanel12().setVisible(false);
		slidePanelView.getjPanel14().setVisible(false);
		
		slidePanelView.getAutoInGarageSlide().setBackground(new Color(47,67,129));
		slidePanelView.getQueuSlide().setBackground(new Color(0,51,102));
		slidePanelView.getWinstSlide().setBackground(new Color(0,51,102));
		slidePanelView.getReserverenSlide().setBackground(new Color(0,51,102));
		slidePanelView.getResetSlide().setBackground(new Color(0,51,102));
		
		layeredPane.moveToFront(autoInGaragePanelVIew);
		

		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getSource()==slidePanelView.getAutoInGarageSlide()) {
			slidePanelView.getjPanel7().setVisible(true);
			slidePanelView.getjPanel10().setVisible(false);
			slidePanelView.getjPanel16().setVisible(false);
			slidePanelView.getjPanel12().setVisible(false);
			slidePanelView.getjPanel14().setVisible(false);
			
			slidePanelView.getAutoInGarageSlide().setBackground(new Color(47,67,129));
			slidePanelView.getQueuSlide().setBackground(new Color(0,51,102));
			slidePanelView.getWinstSlide().setBackground(new Color(0,51,102));
			slidePanelView.getReserverenSlide().setBackground(new Color(0,51,102));
			slidePanelView.getResetSlide().setBackground(new Color(0,51,102));
			
			layeredPane.moveToFront(autoInGaragePanelVIew);
			
		}else if (arg0.getSource()==slidePanelView.getQueuSlide()) {
			
			slidePanelView.getjPanel7().setVisible(false);
			slidePanelView.getjPanel10().setVisible(true);
			slidePanelView.getjPanel16().setVisible(false);
			slidePanelView.getjPanel12().setVisible(false);
			slidePanelView.getjPanel14().setVisible(false);
			
			slidePanelView.getAutoInGarageSlide().setBackground(new Color(0,51,102));
			slidePanelView.getQueuSlide().setBackground(new Color(47,67,129));
			slidePanelView.getWinstSlide().setBackground(new Color(0,51,102));
			slidePanelView.getReserverenSlide().setBackground(new Color(0,51,102));
			slidePanelView.getResetSlide().setBackground(new Color(0,51,102));
			
			
			layeredPane.moveToFront(queuesPanelView);
			
		}else if (arg0.getSource()==slidePanelView.getWinstSlide()) {
			
			slidePanelView.getjPanel7().setVisible(false);
			slidePanelView.getjPanel10().setVisible(false);
			slidePanelView.getjPanel16().setVisible(true);
			slidePanelView.getjPanel12().setVisible(false);
			slidePanelView.getjPanel14().setVisible(false);
			
			slidePanelView.getAutoInGarageSlide().setBackground(new Color(0,51,102));
			slidePanelView.getQueuSlide().setBackground(new Color(0,51,102));
			slidePanelView.getWinstSlide().setBackground(new Color(47,67,129));
			slidePanelView.getReserverenSlide().setBackground(new Color(0,51,102));
			slidePanelView.getResetSlide().setBackground(new Color(0,51,102));
			
		}else if (arg0.getSource()==slidePanelView.getReserverenSlide()) {
			
			slidePanelView.getjPanel7().setVisible(false);
			slidePanelView.getjPanel10().setVisible(false);
			slidePanelView.getjPanel16().setVisible(false);
			slidePanelView.getjPanel12().setVisible(true);
			slidePanelView.getjPanel14().setVisible(false);
			
			
			slidePanelView.getAutoInGarageSlide().setBackground(new Color(0,51,102));
			slidePanelView.getQueuSlide().setBackground(new Color(0,51,102));
			slidePanelView.getWinstSlide().setBackground(new Color(0,51,102));
			slidePanelView.getReserverenSlide().setBackground(new Color(47,67,129));
			slidePanelView.getResetSlide().setBackground(new Color(0,51,102));
			
		}else if (arg0.getSource()==slidePanelView.getResetSlide()) {
			
			slidePanelView.getjPanel7().setVisible(false);
			slidePanelView.getjPanel10().setVisible(false);
			slidePanelView.getjPanel16().setVisible(false);
			slidePanelView.getjPanel12().setVisible(false);
			slidePanelView.getjPanel14().setVisible(true);
			
			slidePanelView.getAutoInGarageSlide().setBackground(new Color(0,51,102));
			slidePanelView.getQueuSlide().setBackground(new Color(0,51,102));
			slidePanelView.getWinstSlide().setBackground(new Color(0,51,102));
			slidePanelView.getReserverenSlide().setBackground(new Color(0,51,102));
			slidePanelView.getResetSlide().setBackground(new Color(47,67,129));
			
		}
		
		
		
		
	// Statements
		}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
    
	
}
