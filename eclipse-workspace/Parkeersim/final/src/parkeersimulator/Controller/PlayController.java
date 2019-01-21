package parkeersimulator.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import parkeersimulator.MVC.Controller;
import parkeersimulator.Model.SimulatorModel;
import parkeersimulator.View.ControllerPanelView;

public class PlayController extends Controller implements ActionListener,ChangeListener{
	
    private SimulatorModel model;
    private ControllerPanelView controllerPanelView;
    private boolean pressed;
    
    
	public PlayController(SimulatorModel model ,ControllerPanelView controllerPanelView)  {
		super(model);
		this.model=model;
		this.controllerPanelView=controllerPanelView;
		pressed=true;
		
		controllerPanelView.getPlay().addActionListener(this);
		controllerPanelView.getjSlider1().addChangeListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(controllerPanelView.getPlay())) {
			if(pressed) {
			System.out.print("HOi");
			model.setIsrunning(false);
			pressed=false;
			
			}
			else {
				pressed=true;
				model.setTickPause(100);
	
			}
			
			
		}
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		model.setTickPause(controllerPanelView.getjSlider1().getValue());
		
	}
	
	

}
