package controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.SimulatorModel;
import view.AantalAutosView;
import view.Queu;
import view.Reserveren;
import view.SimulatorView;
import view.Winst;

public class Controller implements Initializable {

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
	private Label labelMinuts;

	@FXML
	private Label labelHours;

	@FXML
	private ImageView bttonExit;

	@FXML
	private TextField exitSpeedField;

	@FXML
	private Text exitSpeedText;

	@FXML
	private TextField paymentSpeedField;

	@FXML
	private Text paymentSpeedText;

	@FXML
	private TextField enterSpeedField;

	@FXML
	private Text enterSpeedText;

	@FXML
	private TextField weekendResvField;

	@FXML
	private Text weekendResvText;

	@FXML
	private TextField weekdayResvField;

	@FXML
	private Text weekdayResvText;

	@FXML
	private TextField weekendMemberField;

	@FXML
	private Text weekendMemeberText;

	@FXML
	private TextField weekdayMemberField;

	@FXML
	private Text weekdayMemberText;

	@FXML
	private TextField weekendArrivalField;

	@FXML
	private Text weekendArrivalText;

	@FXML
	private TextField weekdayArrivalField;

	@FXML
	private Button resetSubmit;

	@FXML
	private Text weekdayArrivalText;
	private AantalAutosView Autos;
	private Winst winst;
	private Reserveren reseveren;
	private SimulatorModel model;
	private SimulatorView simulatorView;
	private Queu queu;
	private boolean pressed;

	@FXML
	void handleButtonExit(MouseEvent event) {
		Platform.exit();
		System.exit(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		model = new SimulatorModel();
		Autos = new AantalAutosView(model);
		paneAutos.getChildren().add(Autos);

		winst = new Winst(model);
		paneWinst.getChildren().add(winst);

		reseveren = new Reserveren(model);
		paneReserveren.getChildren().add(reseveren);

		simulatorView = new SimulatorView(model);
		paneSimulator.getChildren().add(simulatorView);

	queu = new Queu(model);
    paneQueu.getChildren().add(queu);
		// slider aanpassen

		sildeSpeed.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {

				model.setSpeedOfSumlator(new_val.intValue() * 1000000);

			}
		});

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
		// play and pause button
		pressed = true;
		buttonPlay.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			if (pressed) {
				model.setIsrunning(true);
				pressed = false;
				Image image = new Image("/images/pause.png");

				buttonPlay.setImage(image);

			} else {
				pressed = true;
				model.setIsrunning(false);
				Image image = new Image("/images/play.png");
				buttonPlay.setImage(image);

			}

		});

		buttonReserveren.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			paneAutos.setVisible(false);
			paneQueu.setVisible(false);
			paneWinst.setVisible(false);
			paneReserveren.setVisible(true);
			paneReset.setVisible(false);

		});
		paneReset.setVisible(false);
		buttonReset.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			paneAutos.setVisible(false);
			paneQueu.setVisible(false);
			paneWinst.setVisible(false);
			paneReserveren.setVisible(false);

			paneReset.setVisible(true);
			weekdayArrivalField.setText(String.valueOf(model.getWeekDayArrivals()));
			weekendArrivalField.setText(String.valueOf(model.getWeekendArrivals()));
			weekdayMemberField.setText(String.valueOf(model.getWeekDayPassArrivals()));
			weekendMemberField.setText(String.valueOf(model.getWeekendPassArrivals()));
			weekdayResvField.setText(String.valueOf(model.getWeekDayReserverenArrivals()));
			weekendResvField.setText(String.valueOf(model.getWeekendReserverenArrivals()));
			enterSpeedField.setText(String.valueOf(model.getEnterSpeed()));
			paymentSpeedField.setText(String.valueOf(model.getPaymentSpeed()));
			exitSpeedField.setText(String.valueOf(model.getExitSpeed()));
		});

		// play button

		// resetView = new Reset();
		resetSubmit.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			int a1 = Integer.parseInt(weekdayArrivalField.getText());
			int a2 = Integer.parseInt(weekendArrivalField.getText());
			int r1 = Integer.parseInt(weekdayResvField.getText());
			int r2 = Integer.parseInt(weekendResvField.getText());
			int m1 = Integer.parseInt(weekdayMemberField.getText());
			int m2 = Integer.parseInt(weekendMemberField.getText());
			int enter = Integer.parseInt(enterSpeedField.getText());
			int payment = Integer.parseInt(paymentSpeedField.getText());
			int exit = Integer.parseInt(exitSpeedField.getText());

			model.setWeekDayArrivals(a1);
			model.setWeekendArrivals(a2);
			model.setWeekDayPassArrivals(r1);
			model.setWeekendPassArrivals(r2);
			model.setWeekDayReserverenArrivals(m1);
			model.setWeekendReserverenArrivals(m2);
			model.setEnterSpeed(enter);
			model.setPaymentSpeed(payment);
			model.setExitSpeed(exit);

			// System.out.println("A1="+ a1 + "A2= " + a2 +"R1= "+ r1 +" R2="+ r2 +"M1="+ m1
			// +"M2="+ m2 + "Enter=" + enter + "Payment=" + payment + "Exit=" + exit);
		});

		// ------------------------- Settings conrtolle op numberric
		// --------------------------------------//
		// weekend arrival
		weekendArrivalField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					weekendArrivalField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		// weekday Arrival
		weekdayArrivalField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					weekdayArrivalField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		// weekend Member
		weekendMemberField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					weekendMemberField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		// weekday Member
		weekdayMemberField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					weekdayMemberField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		// weekend Resv
		weekendResvField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					weekendResvField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		// weekday Resv
		weekdayResvField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					weekdayResvField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		// enter Speed
		enterSpeedField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					enterSpeedField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		// payment Speed

		paymentSpeedField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					paymentSpeedField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		// exit Speed
		exitSpeedField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					exitSpeedField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		// clock timer
		AnimationTimer d = new AnimationTimer() {
			private long lastUpdate = 0;

			@Override
			public void handle(long now) {
				if (now - lastUpdate >= 1000_000_000) {
					lastUpdate = now;
					labelDays.setText(String.valueOf("2"));
					if (!model.equals(null)) {
						String s = String.valueOf(model.getDay());
						String s1 = String.valueOf(model.getHour());
						String s2 = String.valueOf(model.getMinute());

						labelDays.setText("  " + String.valueOf(s));
						labelHours.setText("  " + String.valueOf(s1));
						labelMinuts.setText("  " + String.valueOf(s2));

					}
				}
			}
		};
		d.start();

		// here ends the colck timer

	}

	@FXML
	private void handleButtonAction(ActionEvent event) {

	}

}
