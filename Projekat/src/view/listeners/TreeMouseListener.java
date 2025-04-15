package view.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import model.ApplicationModel;
import model.Diagram;
import model.Project;

public class TreeMouseListener extends MouseAdapter {
	private ApplicationModel applicationModel;
	int i = 0;

	public TreeMouseListener(ApplicationModel applicationModel) {
		this.applicationModel = applicationModel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			JTree tree = (JTree) e.getSource();
			int x = e.getX();
			int y = e.getY();
			int row = tree.getRowForLocation(x, y);

			if (row != -1) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getPathForRow(row).getLastPathComponent();
				Object userObject = node.getUserObject();
				if (userObject instanceof Project) {
					for (Project project : applicationModel.getProjects()) {
						if (project == (Project) userObject) {
							project.setActive(true);
						} else {
							project.setActive(false);
						}
					}
				}

				else if (userObject instanceof Diagram) {
					if (!applicationModel.getOpenedDiagrams().contains((Diagram) userObject)) {
						if (applicationModel.getActiveProject() != null) {
							for (Diagram diagram : applicationModel.getActiveProject().getDiagrams()) {
								if (diagram == (Diagram) userObject) {
									diagram.setActive(true);
									diagram.setFocused(true);
								}
							}
							for (Diagram diagram : applicationModel.getActiveProject().getDiagrams()) {
								if (diagram != (Diagram) userObject) {
									diagram.setActive(false);
									diagram.setFocused(false);
								}
							}
						}

						for (Diagram diagram : applicationModel.getDiagrams()) {
							if (diagram == (Diagram) userObject) {
								diagram.setActive(true);
								for (Project project : applicationModel.getProjects()) {
									project.setActive(false);
								}
							}
						}
						for (Diagram diagram : applicationModel.getDiagrams()) {
							if (diagram != (Diagram) userObject) {
								diagram.setActive(false);
								diagram.setFocused(false);
							}
						}

						applicationModel.getOpenedDiagrams().add((Diagram) userObject);
						applicationModel.notifyObervers();
					}
				}
			}
		}
	}
}