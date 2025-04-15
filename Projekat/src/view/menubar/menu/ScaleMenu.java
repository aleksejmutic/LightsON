package view.menubar.menu;

import java.awt.event.KeyEvent;

import localization.Localization;

/** 
 * Klasa za definisanje Scale menija. 
 * 
 * @see Menu
 * @author Grupa 1
 * @version 1.0
 */
public class ScaleMenu extends Menu{

	private static final long serialVersionUID = 1L;
	private MenuItem percent25MenuItem = null;
	private MenuItem percent33MenuItem = null;
	private MenuItem percent50MenuItem = null;
	private MenuItem percent60MenuItem = null;
	private MenuItem percent75MenuItem = null;
	private MenuItem percent100MenuItem = null;
	private MenuItem percent125MenuItem = null;
	private MenuItem percent150MenuItem = null;
	private MenuItem percent175MenuItem = null;
	private MenuItem percent200MenuItem = null;
	private MenuItem percent400MenuItem = null;
	private Localization localization=null;

	public ScaleMenu() {
		
		localization = Localization.getInstance();
		
		setText(localization.getString("menu.view.scale"));
		localization.registerComponent("menu.view.scale", this);
		setMnemonic(KeyEvent.VK_S);

		percent25MenuItem = new MenuItem("25%");
		add(percent25MenuItem);

		percent33MenuItem = new MenuItem("33%");
		add(percent33MenuItem);

		percent50MenuItem = new MenuItem("50%");
		add(percent50MenuItem);

		percent60MenuItem = new MenuItem("60%");
		add(percent60MenuItem);

		percent75MenuItem = new MenuItem("75%");
		add(percent75MenuItem);

		addSeparator();

		percent100MenuItem = new MenuItem("100%");
		add(percent100MenuItem);

		addSeparator();

		percent125MenuItem = new MenuItem("125%");
		add(percent125MenuItem);

		percent150MenuItem = new MenuItem("150%");
		add(percent150MenuItem);

		percent175MenuItem = new MenuItem("175%");
		add(percent175MenuItem);

		percent200MenuItem = new MenuItem("200%");
		add(percent200MenuItem);

		percent400MenuItem = new MenuItem("400%");
		add(percent400MenuItem);
	}

	@Override
	public void idleState() {
		percent25MenuItem.setEnabled(false);
		percent33MenuItem.setEnabled(false);
		percent50MenuItem.setEnabled(false);
		percent25MenuItem.setEnabled(false);
		percent60MenuItem.setEnabled(false);
		percent75MenuItem.setEnabled(false);
		percent25MenuItem.setEnabled(false);
		percent100MenuItem.setEnabled(false);
		percent125MenuItem.setEnabled(false);
		percent25MenuItem.setEnabled(false);
		percent150MenuItem.setEnabled(false);
		percent175MenuItem.setEnabled(false);
		percent200MenuItem.setEnabled(false);
		percent400MenuItem.setEnabled(false);
		
	}

	@Override
	public void activeState() {
		percent25MenuItem.setEnabled(false);
		percent33MenuItem.setEnabled(false);
		percent50MenuItem.setEnabled(false);
		percent25MenuItem.setEnabled(false);
		percent60MenuItem.setEnabled(false);
		percent75MenuItem.setEnabled(false);
		percent25MenuItem.setEnabled(false);
		percent100MenuItem.setEnabled(false);
		percent125MenuItem.setEnabled(false);
		percent25MenuItem.setEnabled(false);
		percent150MenuItem.setEnabled(false);
		percent175MenuItem.setEnabled(false);
		percent200MenuItem.setEnabled(false);
		percent400MenuItem.setEnabled(false);
		
	}

	@Override
	public void editState() {
		percent25MenuItem.setEnabled(true);
		percent33MenuItem.setEnabled(true);
		percent50MenuItem.setEnabled(true);
		percent25MenuItem.setEnabled(true);
		percent60MenuItem.setEnabled(true);
		percent75MenuItem.setEnabled(true);
		percent25MenuItem.setEnabled(true);
		percent100MenuItem.setEnabled(true);
		percent125MenuItem.setEnabled(true);
		percent25MenuItem.setEnabled(true);
		percent150MenuItem.setEnabled(true);
		percent175MenuItem.setEnabled(true);
		percent200MenuItem.setEnabled(true);
		percent400MenuItem.setEnabled(true);
		
	}

	@Override
	public void selectionState() {
		percent25MenuItem.setEnabled(true);
		percent33MenuItem.setEnabled(true);
		percent50MenuItem.setEnabled(true);
		percent25MenuItem.setEnabled(true);
		percent60MenuItem.setEnabled(true);
		percent75MenuItem.setEnabled(true);
		percent25MenuItem.setEnabled(true);
		percent100MenuItem.setEnabled(true);
		percent125MenuItem.setEnabled(true);
		percent25MenuItem.setEnabled(true);
		percent150MenuItem.setEnabled(true);
		percent175MenuItem.setEnabled(true);
		percent200MenuItem.setEnabled(true);
		percent400MenuItem.setEnabled(true);
		
	}

	@Override
	public void addingState() {
		percent25MenuItem.setEnabled(true);
		percent33MenuItem.setEnabled(true);
		percent50MenuItem.setEnabled(true);
		percent25MenuItem.setEnabled(true);
		percent60MenuItem.setEnabled(true);
		percent75MenuItem.setEnabled(true);
		percent25MenuItem.setEnabled(true);
		percent100MenuItem.setEnabled(true);
		percent125MenuItem.setEnabled(true);
		percent25MenuItem.setEnabled(true);
		percent150MenuItem.setEnabled(true);
		percent175MenuItem.setEnabled(true);
		percent200MenuItem.setEnabled(true);
		percent400MenuItem.setEnabled(true);
		
	}
	
	
	
}
