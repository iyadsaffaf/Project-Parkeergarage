package parkeersimulator.View;

import javax.swing.JButton;
import javax.swing.JSlider;

import interfaces.ViewInterface;
import parkeersimulator.MVC.View;

/**
 * @author Iyad saffaf
 *
 */
public class ControllerPanelView extends View implements ViewInterface{

	/**
	 * 
	 */
	private JButton play;
	private JSlider jSlider1;
	public ControllerPanelView() {
		super();
		init();
		features();
	}

	@Override
	public void init() {
		play=new JButton();
		jSlider1 = new javax.swing.JSlider();
		
		
	}

	@Override
	public void features() {
		setBackground(new java.awt.Color(255, 255, 255));

        play.setText("Play");
        jSlider1.setMajorTickSpacing(100);
        jSlider1.setPaintTicks(true);

        javax.swing.GroupLayout controllerPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(controllerPanelLayout);
        controllerPanelLayout.setHorizontalGroup(
            controllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controllerPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(play)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controllerPanelLayout.setVerticalGroup(
            controllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controllerPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(controllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(play)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

}

	public JButton getPlay() {
		return play;
	}

	public void setPlay(JButton play) {
		this.play = play;
	}

	public JSlider getjSlider1() {
		return jSlider1;
	}

	public void setjSlider1(JSlider jSlider1) {
		this.jSlider1 = jSlider1;
	}
	
	
}