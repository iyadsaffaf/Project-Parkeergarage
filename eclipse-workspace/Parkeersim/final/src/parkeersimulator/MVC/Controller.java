/**
 * 
 */
package parkeersimulator.MVC;


/**
 * @author Iyad Saffaf
 *
 */
public abstract class Controller {
	private static final long serialVersionUID = 4941730006940737729L;
	protected Model model;
	
	public Controller(Model model) {
		this.model=model;
	}
}
