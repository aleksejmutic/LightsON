package view.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import model.AddingState;
import model.ApplicationModel;
import model.SelectionState;
import view.Canvas;
import view.Editor;

public class CustomToolboxListener implements ActionListener {
	private ApplicationModel applicationModel;
	private Editor editor;
	public CustomToolboxListener(ApplicationModel applicationModel, Editor editor) {
		this.applicationModel = applicationModel;
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (applicationModel != null) {
			// TODO Auto-generated method stub
			switch (e.getActionCommand()) {
			case "select": {
					this.applicationModel.getActiveDiagram().setState(new SelectionState());

				for (MouseListener listener : editor.getCanvas().getLast().getMouseListeners()) {
					editor.getCanvas().getLast().removeMouseListener(listener);
				}
				for (Canvas canvas : editor.getCanvas()) {
					canvas.addMouseListener(new SelectionListener(editor));
					canvas.addMouseMotionListener(new SelectionListener(editor));
				}

				break;
			}
			case "wire": {
				this.applicationModel.getActiveDiagram().setState(new AddingState());
				
				for (MouseListener listener : editor.getCanvas().getLast().getMouseListeners()) {
					editor.getCanvas().getLast().removeMouseListener(listener);
				}
				for (Canvas canvas : editor.getCanvas()) {
					canvas.addMouseListener(new CompositeWireMouseListener(editor));
				}
				break;
			}
			case "junctionBox": {
				this.applicationModel.getActiveDiagram().setState(new AddingState());
				
				for (MouseListener listener : editor.getCanvas().getLast().getMouseListeners()) {
					editor.getCanvas().getLast().removeMouseListener(listener);
				}
				for (Canvas canvas : editor.getCanvas()) {
					canvas.addMouseListener(new JunctionBoxMouseListener(editor));
				}
				break;
			}
			case "fuse": {
				this.applicationModel.getActiveDiagram().setState(new AddingState());
				
				for (MouseListener listener : editor.getCanvas().getLast().getMouseListeners()) {
					editor.getCanvas().getLast().removeMouseListener(listener);
				}
				for (Canvas canvas : editor.getCanvas()) {
					canvas.addMouseListener(new FusesMouseListener(editor));
				}
				break;
			}
			case "socket": {
				this.applicationModel.getActiveDiagram().setState(new AddingState());
				
				for (MouseListener listener : editor.getCanvas().getLast().getMouseListeners()) {
					editor.getCanvas().getLast().removeMouseListener(listener);
				}
				for (Canvas canvas : editor.getCanvas()) {
					canvas.addMouseListener(new SocketMouseListener(editor));
				}
				break;
			}
			case "consumer": {
				this.applicationModel.getActiveDiagram().setState(new AddingState());
				
				for (MouseListener listener : editor.getCanvas().getLast().getMouseListeners()) {
					editor.getCanvas().getLast().removeMouseListener(listener);
				}
				for (Canvas canvas : editor.getCanvas()) {
					canvas.addMouseListener(new ConsumerMouseListener(editor));
				}
				break;
			}
			case "switch": {
				this.applicationModel.getActiveDiagram().setState(new AddingState());
				
				for (MouseListener listener : editor.getCanvas().getLast().getMouseListeners()) {
					editor.getCanvas().getLast().removeMouseListener(listener);
				}
				for (Canvas canvas : editor.getCanvas()) {
					canvas.addMouseListener(new SwitchMouseListener(editor));
				}
				break;
			}
			}
		}
	}
}
