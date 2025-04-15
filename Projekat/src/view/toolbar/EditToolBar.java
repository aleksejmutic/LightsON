package view.toolbar;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import localization.Localization;
import model.ApplicationModel;
import model.Project;
import view.listeners.EditListener;

/** 
 * Klasa koja definiše ToolBar za skup opcija uređivanja.  
 * @see JToolBar
 * @author Grupa 1
 * @version 1.0
 */
public class EditToolBar extends JToolBar {

    private static final long serialVersionUID = 1L;

    JButton undoButton;
    JButton redoButton;
    JButton cutButton;
    JButton copyButton;
    JButton pasteButton;
    JButton selectAllButton;
    JButton deleteObjectButton;
    JButton editObjectButton;
    private Localization localization = null;
    private Project currentProject;
    ApplicationModel applicationModel;
    private ActionListener actionListener;

    public EditToolBar(Project project,ApplicationModel applicationModel) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        localization = Localization.getInstance();
        this.currentProject=project;
        this.applicationModel=applicationModel;
        this.actionListener = new EditListener(applicationModel);

        // UNDO dugme
        undoButton = new JButton();
        Image undoIcon = toolkit.getImage("icons/Undo.png");
        undoIcon = undoIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        undoButton.setIcon(new ImageIcon(undoIcon));
        undoButton.setToolTipText(localization.getString("menu.edit.undo"));
        undoButton.setActionCommand("undo");
        undoButton.addActionListener(actionListener);
        undoButton.setMnemonic(KeyEvent.VK_Z);
        localization.registerComponent("menu.edit.undo", undoButton);

        // REDO dugme
        redoButton = new JButton();
        Image redoIcon = toolkit.getImage("icons/Redo.png");
        redoIcon = redoIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        redoButton.setIcon(new ImageIcon(redoIcon));
        redoButton.setActionCommand("redo");
        redoButton.addActionListener(actionListener);
        redoButton.setToolTipText(localization.getString("menu.edit.redo"));
        redoButton.setMnemonic(KeyEvent.VK_Y);
        localization.registerComponent("menu.edit.redo", redoButton);

        // CUT dugme
        cutButton = new JButton();
        Image cutIcon = toolkit.getImage("icons/Scissors.png");
        cutIcon = cutIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        cutButton.setIcon(new ImageIcon(cutIcon));
        cutButton.setToolTipText(localization.getString("menu.edit.cut"));
        cutButton.setActionCommand("cut");
        cutButton.addActionListener(actionListener);
        cutButton.setMnemonic(KeyEvent.VK_X);
        localization.registerComponent("menu.edit.cut", cutButton);

        // COPY dugme
        copyButton = new JButton();
        Image copyIcon = toolkit.getImage("icons/copy.png");
        copyIcon = copyIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        copyButton.setIcon(new ImageIcon(copyIcon));
        copyButton.setToolTipText(localization.getString("menu.edit.copy"));
        copyButton.setActionCommand("copy");
        copyButton.addActionListener(actionListener);
        copyButton.setMnemonic(KeyEvent.VK_C);
        localization.registerComponent("menu.edit.copy", copyButton);

        // PASTE dugme
        pasteButton = new JButton();
        Image pasteIcon = toolkit.getImage("icons/paste.png");
        pasteIcon = pasteIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        pasteButton.setIcon(new ImageIcon(pasteIcon));
        pasteButton.setToolTipText(localization.getString("menu.edit.paste"));
        pasteButton.setActionCommand("paste");
        pasteButton.addActionListener(actionListener);
        pasteButton.setMnemonic(KeyEvent.VK_V);
        localization.registerComponent("menu.edit.paste", pasteButton);


        // SELECT ALL dugme
        selectAllButton = new JButton();
        Image selectAllIcon = toolkit.getImage("icons/selectAll.png");
        selectAllIcon = selectAllIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        selectAllButton.setIcon(new ImageIcon(selectAllIcon));
        selectAllButton.setToolTipText(localization.getString("menu.edit.selectAll"));
        selectAllButton.setActionCommand("selectAll");
        selectAllButton.addActionListener(actionListener);
        selectAllButton.setMnemonic(KeyEvent.VK_A);
        localization.registerComponent("menu.edit.selectAll", selectAllButton);

        selectAllButton.addActionListener(e -> System.out.println("Kliknuto dugme Select All!"));

        addSeparator();

        // DELETE dugme
        deleteObjectButton = new JButton();
        Image deleteObjectIcon = toolkit.getImage("icons/bin.png");
        deleteObjectIcon = deleteObjectIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        deleteObjectButton.setIcon(new ImageIcon(deleteObjectIcon));
        deleteObjectButton.setToolTipText(localization.getString("menu.edit.deleteObject"));
        deleteObjectButton.setActionCommand("delete");
        deleteObjectButton.addActionListener(actionListener);
        undoButton.setMnemonic(KeyEvent.VK_DELETE);
        localization.registerComponent("menu.edit.deleteObject", deleteObjectButton);

        // EDIT dugme
        editObjectButton = new JButton();
        Image editObjectIcon = toolkit.getImage("icons/edit.png");
        editObjectIcon = editObjectIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        editObjectButton.setIcon(new ImageIcon(editObjectIcon));
        editObjectButton.setToolTipText(localization.getString("menu.edit.editObject"));
        undoButton.setMnemonic(KeyEvent.VK_E);
        localization.registerComponent("menu.edit.editObject", editObjectButton);

        editObjectButton.addActionListener(e -> System.out.println("Kliknuto dugme Edit Object!"));

        // Dodavanje svih dugmadi u toolbar
        add(undoButton);
        add(redoButton);
        add(cutButton);
        add(copyButton);
        add(pasteButton);
        add(selectAllButton);
        add(deleteObjectButton);
        add(editObjectButton);
    }

	public Project getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(Project currentProject) {
		this.currentProject = currentProject;
	}
	
	
	public void idleState() {
		undoButton.setEnabled(false);
		redoButton.setEnabled(false);
		cutButton.setEnabled(false);
		copyButton.setEnabled(false);
		pasteButton.setEnabled(false);
		selectAllButton.setEnabled(false);
		deleteObjectButton.setEnabled(false);
		editObjectButton.setEnabled(false);
	}

	public void activeState() {
		undoButton.setEnabled(false);
		redoButton.setEnabled(false);
		cutButton.setEnabled(false);
		copyButton.setEnabled(false);
		pasteButton.setEnabled(false);
		selectAllButton.setEnabled(false);
		deleteObjectButton.setEnabled(false);
		editObjectButton.setEnabled(false);
	}

	public void editState() {
		undoButton.setEnabled(true);
		redoButton.setEnabled(true);
		cutButton.setEnabled(true);
		copyButton.setEnabled(true);
		pasteButton.setEnabled(true);
		selectAllButton.setEnabled(true);
		deleteObjectButton.setEnabled(true);
		editObjectButton.setEnabled(true);
	}

	public void selectionState() {
		undoButton.setEnabled(true);
		redoButton.setEnabled(true);
		cutButton.setEnabled(true);
		copyButton.setEnabled(true);
		pasteButton.setEnabled(true);
		selectAllButton.setEnabled(true);
		deleteObjectButton.setEnabled(true);
		editObjectButton.setEnabled(true);
	}

	public void addingState() {
		undoButton.setEnabled(true);
		redoButton.setEnabled(true);
		cutButton.setEnabled(true);
		copyButton.setEnabled(true);
		pasteButton.setEnabled(true);
		selectAllButton.setEnabled(true);
		deleteObjectButton.setEnabled(true);
		editObjectButton.setEnabled(true);
	}
}
