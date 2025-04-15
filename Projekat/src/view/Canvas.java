/***********************************************************************
 * Module:  Canvas.java
 * Author:  goran
 * Purpose: Defines the Class Canvas
 ***********************************************************************/

package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;
	protected ContextMenu contextMenu;
	boolean isFocused;

	public Canvas() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setFocused(false);
	}

	public boolean isFocused() {
		return isFocused;
	}

	public void setFocused(boolean isFocused) {
		this.isFocused = isFocused;
	}
}