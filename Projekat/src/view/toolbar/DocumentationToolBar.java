package view.toolbar;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import localization.Localization;
import model.ApplicationModel;
import model.command.GenerateDocumentation;
import view.listeners.PrintActionListener;

/** 
 * Klasa koja definiše ToolBar za skup opcija dokumentacije. 
 * @see JToolBar
 * @author Grupa 1
 * @version 1.0
 */
public class DocumentationToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	JButton createNewDocumentationButton;
	JButton deleteDocumentationButton;
	JButton printDocumentationButton;
	JButton generateDocumentationFromDiagramButton;
	private Localization localization = null;

	public DocumentationToolBar(ApplicationModel applicationModel) {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		localization = Localization.getInstance();

		createNewDocumentationButton = new JButton();
		Image createNewDocumentationIcon = toolkit.getImage("icons/new-document.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		createNewDocumentationButton.setIcon(new ImageIcon(createNewDocumentationIcon));
		createNewDocumentationButton.setToolTipText(localization.getString("menu.documentation.createNew"));
		localization.registerComponent("menu.documentation.createNew", createNewDocumentationButton);
		add(createNewDocumentationButton);

		deleteDocumentationButton = new JButton();
		Image deleteDocumentationIcon = toolkit.getImage("icons/bin.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		deleteDocumentationButton.setIcon(new ImageIcon(deleteDocumentationIcon));
		deleteDocumentationButton.setToolTipText(localization.getString("menu.documentation.delete"));
		localization.registerComponent("menu.documentation.delete", deleteDocumentationButton);
		add(deleteDocumentationButton);

		printDocumentationButton = new JButton();
		Image printDocumentationIcon = toolkit.getImage("icons/Print.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		printDocumentationButton.setIcon(new ImageIcon(printDocumentationIcon));
		printDocumentationButton.setToolTipText(localization.getString("menu.documentation.print"));
		localization.registerComponent("menu.documentation.print", printDocumentationButton);
		add(printDocumentationButton);
		printDocumentationButton.addActionListener(new PrintActionListener("Hello, this is a test print!"));

		generateDocumentationFromDiagramButton = new JButton();
		Image generateDocumentationIcon = toolkit.getImage("icons/gears.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		generateDocumentationFromDiagramButton.setIcon(new ImageIcon(generateDocumentationIcon));
		generateDocumentationFromDiagramButton.setToolTipText(localization.getString("menu.documentation.generate"));
		localization.registerComponent("menu.documentation.generate", generateDocumentationFromDiagramButton);
		add(generateDocumentationFromDiagramButton);
		
		generateDocumentationFromDiagramButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				GenerateDocumentation generator = new GenerateDocumentation();
				generator.saveTextAsPDF(applicationModel.getActiveDiagram());
			}
		});
	}
	
	
	public void idleState() {
		createNewDocumentationButton.setEnabled(true);
		deleteDocumentationButton.setEnabled(false);
		printDocumentationButton.setEnabled(false);
		generateDocumentationFromDiagramButton.setEnabled(false);
	}

	public void activeState() {
		createNewDocumentationButton.setEnabled(true);
		deleteDocumentationButton.setEnabled(false);
		printDocumentationButton.setEnabled(false);
		generateDocumentationFromDiagramButton.setEnabled(false);
	}

	public void editState() {
		createNewDocumentationButton.setEnabled(true);
		deleteDocumentationButton.setEnabled(true);
		printDocumentationButton.setEnabled(true);
		generateDocumentationFromDiagramButton.setEnabled(true);
	}

	public void selectionState() {
		createNewDocumentationButton.setEnabled(true);
		deleteDocumentationButton.setEnabled(true);
		printDocumentationButton.setEnabled(true);
		generateDocumentationFromDiagramButton.setEnabled(true);
	}

	public void addingState() {
		createNewDocumentationButton.setEnabled(true);
		deleteDocumentationButton.setEnabled(true);
		printDocumentationButton.setEnabled(true);
		generateDocumentationFromDiagramButton.setEnabled(true);
	}
}
