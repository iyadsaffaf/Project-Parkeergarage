package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import view.AantalAutosView;
import view.Reserveren;
import view.Winst;

public class Controller implements Initializable  {
    
    @FXML
    private Button buttonAutos;

    @FXML
    private Button buttonQueu;

    @FXML
    private Button buttonWinst;

    @FXML
    private Button buttonReserveren;

    @FXML
    private Button buttonReset;

    @FXML
    private Pane paneSimulator;

    @FXML
    private Pane paneAutos;

    @FXML
    private Pane paneQueu;

    @FXML
    private Pane paneWinst;

    @FXML
    private Pane paneReserveren;

    @FXML
    private Pane paneReset;

    @FXML
    private Slider sildeSpeed;

    @FXML
    private ImageView buttonPlay;

    @FXML
    private Label labelDays;

    @FXML
    private Label labelSeconds;

    @FXML
    private Label labelMinuts;

    @FXML
    private Label labelHours;

    @FXML
    private ImageView bttonExit;
    
    private AantalAutosView Autos;
    private Winst winst;
    private Reserveren reseveren;
    @FXML
    void handleButtonExit(MouseEvent event) {
    		Platform.exit();
    		System.exit(0);
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		Autos = new AantalAutosView();
		paneAutos.getChildren().add(Autos);
		
		winst = new Winst();
		paneWinst.getChildren().add(winst);
		
		
		reseveren = new Reserveren();
		paneReserveren.getChildren().add(reseveren);
		
		buttonAutos.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			paneAutos.setVisible(true);
			paneQueu.setVisible(false);
			paneWinst.setVisible(false);
			paneReserveren.setVisible(false);
			paneReset.setVisible(false);
			
			
		});
		
		buttonWinst.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			paneAutos.setVisible(false);
			paneQueu.setVisible(false);
			paneWinst.setVisible(true);
			paneReserveren.setVisible(false);
			paneReset.setVisible(false);
			
			
		});
		
		buttonQueu.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			paneAutos.setVisible(false);
			paneQueu.setVisible(true);
			paneWinst.setVisible(false);
			paneReserveren.setVisible(false);
			paneReset.setVisible(false);
			
			
		});
		
		buttonReserveren.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			paneAutos.setVisible(false);
			paneQueu.setVisible(false);
			paneWinst.setVisible(false);
			paneReserveren.setVisible(true);
			paneReset.setVisible(false);
			
			
		});
		
		buttonReset.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			paneAutos.setVisible(false);
			paneQueu.setVisible(false);
			paneWinst.setVisible(false);
			paneReserveren.setVisible(false);
			
			paneReset.setVisible(true);
			
			
		});
		
	}
	  @FXML
	private void handleButtonAction(ActionEvent event) {
	         
	       
	}

}
