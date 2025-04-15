package view.listeners;

import java.awt.Component;
import java.awt.event.MouseListener;


import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import model.SelectionState;

import view.Editor;
import view.diagramCanvas.CustomTabbedPane;
import view.diagramCanvas.DiagramCanvas;
import view.diagramCanvas.DiagramTabPane;

public class TabChangeListener implements ChangeListener {
	private Editor editor;
	public TabChangeListener(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		CustomTabbedPane customTabPane = (CustomTabbedPane) e.getSource();
		int selectedIndex = customTabPane.getSelectedIndex();

		for (int i = 0; i < customTabPane.getTabCount(); i++) {
			Component component = customTabPane.getComponentAt(i);

			if (component instanceof DiagramTabPane) {
				DiagramTabPane diagramTabPane = (DiagramTabPane) component;
				DiagramCanvas diagramCanvas = (DiagramCanvas) diagramTabPane.getCanvas();

				if (i != selectedIndex) {
					diagramCanvas.setFocused(false);
					diagramCanvas.getDiagram().setFocused(false);
					diagramCanvas.getDiagram().setActive(false);
					for (MouseListener listener : diagramCanvas.getMouseListeners()) {
						diagramCanvas.removeMouseListener(listener);
					}

				} else {
					diagramCanvas.setFocused(true);
					diagramCanvas.getDiagram().setFocused(true);
					diagramCanvas.getDiagram().setActive(true);
					diagramCanvas.getDiagram().setState(new SelectionState());
					for (MouseListener listener : diagramCanvas.getMouseListeners()) {
						diagramCanvas.removeMouseListener(listener);
					}
					diagramCanvas.addMouseListener(new SelectionListener(editor));
					diagramCanvas.addMouseMotionListener(new SelectionListener(editor));
				}
			}

		}
	}
}
