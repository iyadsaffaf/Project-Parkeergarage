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

public class Controller implements Initializable  {
    
	@FXML
    private Button buttonSimulator;

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

    @FXML
    void handleButtonExit(MouseEvent event) {
    		Platform.exit();
    		System.exit(0);
    }
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	  @FXML
	    private void handleButtonAction(ActionEvent event) {
	         
	       
	    }

}
