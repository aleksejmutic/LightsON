package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Collection;
import java.util.Vector;
import javax.swing.JFrame;

import helper.GsonParser;
import model.ConfigWrapper;



/** 
 * Klasa za definisanje izgleda svih prozora.
 * Pojedinačni prozori je nasljeđuju.
 * 
 * @see JFrame
 * @author Grupa 1
 * @version 1.0
 */
public class WindowFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	protected Container contentPane = null;
	protected ViewComponent menuBar;
	private ConfigWrapper configWrapper=null;
	protected Collection<ViewComponent> viewComponents;
	String filePath = "appsettings.json";


	
	public WindowFrame() throws HeadlessException {
		super();
		viewComponents = new Vector<ViewComponent>();
		this.configWrapper=GsonParser.parseJson(filePath, ConfigWrapper.class);
		//podesavanje ikonice prozora
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image icon = toolkit.getImage("icons/LightsOnLogo.png").getScaledInstance(800, 800,Image.SCALE_SMOOTH);
		setIconImage(icon);
		
		// postavljanje osnovnih parametara
		setTitle("LightsOn");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//dimenzije prozora
		Dimension frameSize = new Dimension(this.configWrapper.getWindow().getSize().getWidth(),this.configWrapper.getWindow().getSize().getHeight() );
		setSize(frameSize);
		setLocationRelativeTo(null);
		setMinimumSize(frameSize);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		setVisible(true); 
	}



	public Collection<ViewComponent> getViewComponents() {
		return viewComponents;
	}



	public void setViewComponents(Collection<ViewComponent> viewComponents) {
		this.viewComponents = viewComponents;
	}
	
	public void addViewComponent(ViewComponent component)
	{
		this.viewComponents.add(component);
	}
	
}
