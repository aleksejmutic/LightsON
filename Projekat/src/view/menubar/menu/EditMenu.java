package view.menubar.menu;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import localization.Localization;
import model.ApplicationModel;
import view.listeners.EditListener;


/** 
 * Klasa za definisanje Edit menija. 
 * 
 * @see Menu
 * @author Grupa 1
 * @version 1.0
 */
public class EditMenu extends Menu{

	private static final long serialVersionUID = 1L;
	
	private MenuItem undoMenuItem = null;
	private MenuItem redoMenuItem = null;
	private MenuItem cutMenuItem = null;
	private MenuItem copyMenuItem = null;
	private MenuItem pasteMenuItem = null;
	private MenuItem selectAllMenuItem = null;
	private MenuItem deleteObjectMenuItem = null;
	private MenuItem editObjectMenuItem = null;
	private Localization localization=null;
	private ActionListener actionListener;
	private ApplicationModel applicationModel;
	
	public EditMenu(ApplicationModel applicationModel) {
		this.applicationModel = applicationModel;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		this.actionListener = new EditListener(applicationModel);
		
		localization = Localization.getInstance();
		
		setText(localization.getString("menu.edit"));
		localization.registerComponent("menu.edit", this);
		setMnemonic(KeyEvent.VK_E);
		
		undoMenuItem = new MenuItem(localization.getString("menu.edit.undo"));
		Image undoIcon = toolkit.getImage("icons/Undo.png");
		undoIcon = undoIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		undoMenuItem.setIcon(new ImageIcon(undoIcon));
		undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
		undoMenuItem.setMnemonic(KeyEvent.VK_U);
		undoMenuItem.setActionCommand("undo");
		undoMenuItem.addActionListener(actionListener);
		localization.registerComponent("menu.edit.undo", undoMenuItem);
		add(undoMenuItem);
		
		redoMenuItem = new MenuItem(localization.getString("menu.edit.redo"));
		Image redoIcon = toolkit.getImage("icons/Redo.png");
		redoIcon = redoIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		redoMenuItem.setIcon(new ImageIcon(redoIcon));
		redoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));
		redoMenuItem.setMnemonic(KeyEvent.VK_R);
		redoMenuItem.setActionCommand("redo");
		redoMenuItem.addActionListener(actionListener);
		localization.registerComponent("menu.edit.redo", redoMenuItem);
		add(redoMenuItem);
		
		addSeparator();
		
		cutMenuItem = new MenuItem(localization.getString("menu.edit.cut"));
		Image cutIcon = toolkit.getImage("icons/Scissors.png");
		cutIcon = cutIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		cutMenuItem.setIcon(new ImageIcon(cutIcon));
		cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
		cutMenuItem.setMnemonic(KeyEvent.VK_X);
		localization.registerComponent("menu.edit.cut", cutMenuItem);
		add(cutMenuItem);
		
		
		copyMenuItem = new MenuItem(localization.getString("menu.edit.copy"));
		Image copyIcon = toolkit.getImage("icons/copy.png");
		copyIcon = copyIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		copyMenuItem.setIcon(new ImageIcon(copyIcon));
		copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
		copyMenuItem.setMnemonic(KeyEvent.VK_C);
		localization.registerComponent("menu.edit.copy", copyMenuItem);
		add(copyMenuItem);
		
		
		pasteMenuItem = new MenuItem(localization.getString("menu.edit.paste"));
		Image pasteIcon = toolkit.getImage("icons/paste.png");
		pasteIcon = pasteIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		pasteMenuItem.setIcon(new ImageIcon(pasteIcon));
		pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
		pasteMenuItem.setMnemonic(KeyEvent.VK_P);
		localization.registerComponent("menu.edit.paste", pasteMenuItem);
		add(pasteMenuItem);
		
		
		selectAllMenuItem = new MenuItem(localization.getString("menu.edit.selectAll"));
		Image selectAllIcon = toolkit.getImage("icons/selectAll.png");
		selectAllIcon = selectAllIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		selectAllMenuItem.setIcon(new ImageIcon(selectAllIcon));
		selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
		selectAllMenuItem.setMnemonic(KeyEvent.VK_S);
		localization.registerComponent("menu.edit.selectAll", selectAllMenuItem);
		add(selectAllMenuItem);
		
		addSeparator();
		
		deleteObjectMenuItem = new MenuItem(localization.getString("menu.edit.deleteObject"));
		Image deleteObjectIcon = toolkit.getImage("icons/bin.png");
		deleteObjectIcon = deleteObjectIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		deleteObjectMenuItem.setIcon(new ImageIcon(deleteObjectIcon));
		deleteObjectMenuItem.setMnemonic(KeyEvent.VK_D);
		localization.registerComponent("menu.edit.deleteObject", deleteObjectMenuItem);
		add(deleteObjectMenuItem);
		
		
		editObjectMenuItem = new MenuItem(localization.getString("menu.edit.editObject"));
		Image editObjectIcon = toolkit.getImage("icons/edit.png");
		editObjectIcon = editObjectIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		editObjectMenuItem.setIcon(new ImageIcon(editObjectIcon));
		localization.registerComponent("menu.edit.editObject", editObjectMenuItem);
		add(editObjectMenuItem);
		
	}

	@Override
	public void idleState() {
		undoMenuItem.setEnabled(false);
		redoMenuItem.setEnabled(false);
		cutMenuItem.setEnabled(false);
		copyMenuItem.setEnabled(false);
		pasteMenuItem.setEnabled(false);
		selectAllMenuItem.setEnabled(false);
		deleteObjectMenuItem.setEnabled(false);
		editObjectMenuItem.setEnabled(false);
		
	}

	@Override
	public void activeState() {
		undoMenuItem.setEnabled(false);
		redoMenuItem.setEnabled(false);
		cutMenuItem.setEnabled(false);
		copyMenuItem.setEnabled(false);
		pasteMenuItem.setEnabled(false);
		selectAllMenuItem.setEnabled(false);
		deleteObjectMenuItem.setEnabled(false);
		editObjectMenuItem.setEnabled(false);
		
	}

	@Override
	public void editState() {
		undoMenuItem.setEnabled(false);
		redoMenuItem.setEnabled(false);
		cutMenuItem.setEnabled(false);
		copyMenuItem.setEnabled(false);
		pasteMenuItem.setEnabled(false);
		selectAllMenuItem.setEnabled(false);
		deleteObjectMenuItem.setEnabled(false);
		editObjectMenuItem.setEnabled(false);
		
	}

	@Override
	public void selectionState() {
		undoMenuItem.setEnabled(true);
		redoMenuItem.setEnabled(true);
		cutMenuItem.setEnabled(true);
		copyMenuItem.setEnabled(true);
		pasteMenuItem.setEnabled(true);
		selectAllMenuItem.setEnabled(true);
		deleteObjectMenuItem.setEnabled(true);
		editObjectMenuItem.setEnabled(true);
		
	}

	@Override
	public void addingState() {
		undoMenuItem.setEnabled(true);
		redoMenuItem.setEnabled(true);
		cutMenuItem.setEnabled(true);
		copyMenuItem.setEnabled(true);
		pasteMenuItem.setEnabled(true);
		selectAllMenuItem.setEnabled(true);
		deleteObjectMenuItem.setEnabled(true);
		editObjectMenuItem.setEnabled(true);
		
	}

	public ApplicationModel getApplicationModel() {
		return applicationModel;
	}

	public void setApplicationModel(ApplicationModel applicationModel) {
		this.applicationModel = applicationModel;
	}
	
	

}
