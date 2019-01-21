/**
 * This class is responsible to make the frame and panels in the whole program
 */
package parkeersimulator.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import parkeersimulator.Controller.PlayController;
import parkeersimulator.Controller.SlideController;
import parkeersimulator.Logic.SimulatorLogic;
import parkeersimulator.Model.CarViewModel;
import parkeersimulator.Model.SimulatorModel;
import parkeersimulator.View.AutoInGaragePanelVIew;
import parkeersimulator.View.ControllerPanelView;
import parkeersimulator.View.ParkPanelView;
import parkeersimulator.View.QueuesPanelView;
import parkeersimulator.View.SlidePanelView;

/**
 * @author Iyad saffaf
 *
 */
public class Simulator {
	private JFrame screen;
	private SlidePanelView   slidePanel;   //Het paneel wat de initiele instellingen beheert
	private JLayeredPane jLayeredPane1;
	private ParkPanelView parkViewPanel;
	private ControllerPanelView controllerPanel;
	private AutoInGaragePanelVIew autoInGaragaPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
	private QueuesPanelView queuPanel;
	private SimulatorLogic simulatorLogic	;
	
	private SimulatorModel simulatorModel ;
	private CarViewModel carViewModel;
	private SlideController slideController ;
	private PlayController playControlller ;
	

	public Simulator() {
		screen = new JFrame();
		jLayeredPane1=new JLayeredPane();
		controllerPanel=new ControllerPanelView();
		carViewModel=new CarViewModel(3,6,30);
		parkViewPanel= new ParkPanelView(carViewModel);
		slidePanel=new SlidePanelView();
		jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        queuPanel=new QueuesPanelView();
        autoInGaragaPanel =new AutoInGaragePanelVIew();
        simulatorModel = new SimulatorModel();
        slideController = new SlideController(slidePanel,simulatorModel,jLayeredPane1,autoInGaragaPanel,queuPanel);
        playControlller = new PlayController(simulatorModel,controllerPanel);
        
        simulatorLogic =new SimulatorLogic(simulatorModel, carViewModel, parkViewPanel,autoInGaragaPanel);
		makeFrame();
		simulatorLogic.run();
	}
	
	
    private void makeFrame(){
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        screen.setResizable(false);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(screen.getContentPane());
        screen.getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(slidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(parkViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(controllerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(slidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(parkViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(controllerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
             jLayeredFeature();
            jMenu1.setText("File");
            jMenuBar1.add(jMenu1);

            jMenu2.setText("About");
            jMenuBar1.add(jMenu2);

            screen.setJMenuBar(jMenuBar1);
            
        screen.pack();

        
        screen.setVisible(true);
    }
	private void jLayeredFeature() 
	{
        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

      //  autoInGaragaPanel.setBackground(new java.awt.Color(0, 204, 102));

        javax.swing.GroupLayout autoInGaragaPanelLayout = new javax.swing.GroupLayout(autoInGaragaPanel);
        autoInGaragaPanel.setLayout(autoInGaragaPanelLayout);
        autoInGaragaPanelLayout.setHorizontalGroup(
            autoInGaragaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        autoInGaragaPanelLayout.setVerticalGroup(
            autoInGaragaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 823, Short.MAX_VALUE)
        );

        jLayeredPane1.add(autoInGaragaPanel);

        queuPanel.setBackground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout queuPanelLayout = new javax.swing.GroupLayout(queuPanel);
        queuPanel.setLayout(queuPanelLayout);
        queuPanelLayout.setHorizontalGroup(
            queuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        queuPanelLayout.setVerticalGroup(
            queuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 823, Short.MAX_VALUE)
        );

        jLayeredPane1.add(queuPanel);
//
//        winstPanel.setBackground(new java.awt.Color(255, 51, 153));
//
//        javax.swing.GroupLayout winstPanelLayout = new javax.swing.GroupLayout(winstPanel);
//        winstPanel.setLayout(winstPanelLayout);
//        winstPanelLayout.setHorizontalGroup(
//            winstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 513, Short.MAX_VALUE)
//        );
//        winstPanelLayout.setVerticalGroup(
//            winstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 823, Short.MAX_VALUE)
//        );
//
//        jLayeredPane1.add(winstPanel);
//
//        reserverenPanel.setBackground(new java.awt.Color(204, 204, 0));
//
//        javax.swing.GroupLayout reserverenPanelLayout = new javax.swing.GroupLayout(reserverenPanel);
//        reserverenPanel.setLayout(reserverenPanelLayout);
//        reserverenPanelLayout.setHorizontalGroup(
//            reserverenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 513, Short.MAX_VALUE)
//        );
//        reserverenPanelLayout.setVerticalGroup(
//            reserverenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 823, Short.MAX_VALUE)
//        );
//
//        jLayeredPane1.add(reserverenPanel);
//
//        ResetPanel.setBackground(new java.awt.Color(153, 153, 255));
//
//        javax.swing.GroupLayout ResetPanelLayout = new javax.swing.GroupLayout(ResetPanel);
//        ResetPanel.setLayout(ResetPanelLayout);
//        ResetPanelLayout.setHorizontalGroup(
//            ResetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 513, Short.MAX_VALUE)
//        );
//        ResetPanelLayout.setVerticalGroup(
//            ResetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 823, Short.MAX_VALUE)
//        );
//
//        jLayeredPane1.add(ResetPanel);

		
	}
}
