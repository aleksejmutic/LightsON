package view;

import java.awt.event.ActionListener;
import javax.swing.JToolBar;

import model.ApplicationModel;
import observer.Subject;
import view.toolbar.AccountToolBar;
import view.toolbar.DocumentationToolBar;
import view.toolbar.EditToolBar;
import view.toolbar.FileToolBar;
import view.toolbar.HelpToolBar;
import view.toolbar.LicenceToolBar;
import view.toolbar.ViewToolBar;
import view.toolbar.WindowToolBar;

/**
 * Klasa koja definiše ToolBar aplikacije. Klasa sadrži grupe ToolBar-a.
 * 
 * @see JToolBar
 * @see ActionListener
 */
public class ToolBar extends JToolBar implements ViewComponent {

	private static final long serialVersionUID = 1L;

	public ContextMenu contextMenu;
	private FileToolBar fileToolBar;
	private EditToolBar editToolBar;
	private ViewToolBar viewToolBar;
	private WindowToolBar windowToolBar;
	private LicenceToolBar licenceToolBar;
	private AccountToolBar accountToolBar;
	private DocumentationToolBar documentationToolBar;
	private HelpToolBar helpToolBar;

	public ToolBar(ApplicationModel applicationModel) {
		fileToolBar = new FileToolBar(applicationModel);
		add(fileToolBar);

		editToolBar = new EditToolBar(applicationModel.getActiveProject(),applicationModel);
		add(editToolBar);

		viewToolBar = new ViewToolBar();
		add(viewToolBar);

		windowToolBar = new WindowToolBar();
		add(windowToolBar);

		licenceToolBar = new LicenceToolBar();
		add(licenceToolBar);

		accountToolBar = new AccountToolBar();
		add(accountToolBar);

		documentationToolBar = new DocumentationToolBar(applicationModel);
		add(documentationToolBar);

		helpToolBar = new HelpToolBar();
		add(helpToolBar);
	}

	@Override
	public void update(Subject subject) {
		ApplicationModel applicationModel = (ApplicationModel) subject;
		editToolBar.setCurrentProject(applicationModel.getActiveProject());
		this.revalidate();
		this.repaint();
	}
	
	
	public void idleState() {
		fileToolBar.idleState();
		editToolBar.idleState();
		viewToolBar.idleState();
		windowToolBar.idleState();
		licenceToolBar.idleState();
		accountToolBar.idleState();
		documentationToolBar.idleState();
		helpToolBar.idleState();

	}

	public void activeState() {
		fileToolBar.activeState();
		editToolBar.activeState();
		viewToolBar.activeState();
		windowToolBar.activeState();
		licenceToolBar.activeState();
		accountToolBar.activeState();
		documentationToolBar.activeState();
		helpToolBar.activeState();
	}


	public void editState() {
		fileToolBar.editState();
		editToolBar.editState();
		viewToolBar.editState();
		windowToolBar.editState();
		licenceToolBar.editState();
		accountToolBar.editState();
		documentationToolBar.editState();
		helpToolBar.editState();

	}

	public void selectionState() {
		fileToolBar.selectionState();
		editToolBar.selectionState();
		viewToolBar.selectionState();
		windowToolBar.selectionState();
		licenceToolBar.selectionState();
		accountToolBar.selectionState();
		documentationToolBar.selectionState();
		helpToolBar.selectionState();

	}

	public void addingState() {
		fileToolBar.addingState();
		editToolBar.addingState();
		viewToolBar.addingState();
		windowToolBar.addingState();
		licenceToolBar.addingState();
		accountToolBar.addingState();
		documentationToolBar.addingState();
		helpToolBar.addingState();
	}
}
