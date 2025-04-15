package view.menubar.menu;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import localization.Localization;
import view.listeners.PrintActionListener;

/** 
 * Klasa za definisanje Documentation menija. 
 * 
 * @see Menu
 * @author Grupa 1
 * @version 1.0
 */
public class DocumentationMenu extends Menu{

	private static final long serialVersionUID = 1L;
	
	private MenuItem createNewDocumentationMenuItem = null;
	private MenuItem deleteDocumentationMenuItem = null;
	private MenuItem printDocumentationMenuItem = null;
	private MenuItem generateDocumentationFromDiagramMenuItem = null;
	private Localization localization=null;
	
	public DocumentationMenu() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		localization = Localization.getInstance();
		
		setText(localization.getString("menu.documentation"));
		localization.registerComponent("menu.documentation", this);
		setMnemonic(KeyEvent.VK_D);
		
		createNewDocumentationMenuItem = new MenuItem(localization.getString("menu.documentation.createNew"));
		Image createNewDocumentationIcon = toolkit.getImage("icons/new-document.png");
		createNewDocumentationIcon = createNewDocumentationIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		createNewDocumentationMenuItem.setIcon(new ImageIcon(createNewDocumentationIcon));
		localization.registerComponent("menu.documentation.createNew", createNewDocumentationMenuItem);
		add(createNewDocumentationMenuItem);
		
		deleteDocumentationMenuItem = new MenuItem(localization.getString("menu.documentation.delete"));
		Image deleteDocumentationIcon = toolkit.getImage("icons/bin.png");
		deleteDocumentationIcon = deleteDocumentationIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		deleteDocumentationMenuItem.setIcon(new ImageIcon(deleteDocumentationIcon));
		localization.registerComponent("menu.documentation.delete", deleteDocumentationMenuItem);
		add(deleteDocumentationMenuItem);
		
		printDocumentationMenuItem = new MenuItem(localization.getString("menu.documentation.print"));
		Image printDocumentationIcon = toolkit.getImage("icons/Print.png");
		printDocumentationIcon = printDocumentationIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		printDocumentationMenuItem.setIcon(new ImageIcon(printDocumentationIcon));
		localization.registerComponent("menu.documentation.print", printDocumentationMenuItem);
		printDocumentationMenuItem.addActionListener(new PrintActionListener("Hello, this is a test print!"));
		add(printDocumentationMenuItem);
		
		generateDocumentationFromDiagramMenuItem = new MenuItem(localization.getString("menu.documentation.generate"));
		Image generateDocumentationIcon = toolkit.getImage("icons/gears.png");
		generateDocumentationIcon = generateDocumentationIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		generateDocumentationFromDiagramMenuItem.setIcon(new ImageIcon(generateDocumentationIcon));
		localization.registerComponent("menu.documentation.generate", generateDocumentationFromDiagramMenuItem);
		add(generateDocumentationFromDiagramMenuItem);
		
	}

	@Override
	public void idleState() {
		// TODO Auto-generated method stub
	}

	@Override
	public void activeState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectionState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addingState() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
