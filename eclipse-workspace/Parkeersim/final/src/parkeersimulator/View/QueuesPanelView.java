/**
 * 
 */
package parkeersimulator.View;

import interfaces.ViewInterface;
import parkeersimulator.MVC.View;

/**
 * @author Iyad saffaf
 *
 */
public class QueuesPanelView extends View implements ViewInterface {

	/**
	 * 
	 */
	
	
	
	private static final long serialVersionUID = 1L;

	public QueuesPanelView() {
		super();
		init();
		features();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see interfaces.ViewInterface#features()
	 */
	@Override
	public void features() {
		setBackground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout queuPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(queuPanelLayout);
        queuPanelLayout.setHorizontalGroup(
            queuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        queuPanelLayout.setVerticalGroup(
            queuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 823, Short.MAX_VALUE)
        );

	}

}
