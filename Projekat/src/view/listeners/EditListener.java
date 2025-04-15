package view.listeners;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import model.ApplicationModel;

import model.Copy;
import model.Cut;
import model.Diagram;
import model.Element;
import model.PasteElement;
import model.RemoveElement;

public class EditListener implements ActionListener {

	ApplicationModel applicationModel;

	public EditListener(ApplicationModel applicationModel) {
		this.applicationModel = applicationModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "undo": {
			Diagram diagram = this.applicationModel.getActiveDiagram();
			if (!diagram.getCommandHistory().getUndoStack().isEmpty()) {
				Diagram undoDiagram = diagram.getCommandHistory().popUndoCommand();
				this.applicationModel.updateActiveDiagram(undoDiagram);
				this.applicationModel.notifyObervers();
			} else {
				Toolkit.getDefaultToolkit().beep();
			}
			break;
		}
		case "redo": {
			Diagram diagram = this.applicationModel.getActiveDiagram();
			

			if (!diagram.getCommandHistory().getRedoStack().isEmpty()) {
				Diagram undoDiagram = diagram.getCommandHistory().popRedoCommand();
				this.applicationModel.updateActiveDiagram(undoDiagram);
				this.applicationModel.notifyObervers();
			} else {
				Toolkit.getDefaultToolkit().beep();
			}
			break;
		}
		case "delete": {
			Diagram diagram = this.applicationModel.getActiveDiagram();
			

			if (diagram != null) {

				List<Element> elementsToRemove = new Vector<Element>(diagram.getElements());

				for (Element selectedElement : elementsToRemove) {
					if (selectedElement.getIsSelected() == true) {
						RemoveElement removeElement = new RemoveElement(this.applicationModel, selectedElement);
						removeElement.execute();
					}
				}
			} else {
				System.out.println("No active diagram found to delete elements from.");
			}
			break;
		}

		case "cut": {
			Cut cutCommand = new Cut(applicationModel);
			cutCommand.execute();
			break;
		}
		case "copy": {
			Copy copyCommand = new Copy(applicationModel);
			copyCommand.execute();
			break;
		}
		case "paste": {
			PasteElement pasteCommand = new PasteElement(applicationModel);
			pasteCommand.execute();
			break;
		}
		case "selectAll": {
			Diagram diagram = this.applicationModel.getActiveDiagram();
		

			if (diagram != null) {
				for (Element element : diagram.getElements()) {
					element.setIsSelected(true);
				}
				applicationModel.notifyObervers();
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + e.getActionCommand());
		}

	}

}
