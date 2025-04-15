package view.objectBrowser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.ApplicationModel;
import model.Diagram;
import model.Project;

import view.listeners.TreeMouseListener;

import java.awt.*;


public class TreePanel extends JPanel {
 static final long serialVersionUID = 1L;
	private JTree objectTree;
	private JScrollPane scrollPane;
	private ApplicationModel applicationModel;
	private DefaultTreeModel treeModel;

	public TreePanel(ApplicationModel applicationModel) {
		this.applicationModel = applicationModel;
		setLayout(new BorderLayout());
		// Create root node
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("hide");
		if (!applicationModel.getProjects().isEmpty()) {
			for (Project activeProject : applicationModel.getProjects()) {
				DefaultMutableTreeNode activeProjectNode = new DefaultMutableTreeNode(activeProject.getProjectName());
				activeProjectNode.setUserObject(activeProject);
				rootNode.add(activeProjectNode);

				for (Diagram diagram : activeProject.getDiagrams()) {
					DefaultMutableTreeNode diagramNode = new DefaultMutableTreeNode(diagram.getDiagramName());
					diagramNode.setUserObject(diagram);
					activeProjectNode.add(diagramNode);
				}

				if (activeProject.getDiagrams().isEmpty()) {
					DefaultMutableTreeNode invisibleNode = new DefaultMutableTreeNode("hide");
					activeProjectNode.add(invisibleNode);
				}
			}

		}

		for (Diagram diagram : applicationModel.getDiagrams()) {
			DefaultMutableTreeNode diagramNode = new DefaultMutableTreeNode(diagram.getDiagramName());
			diagramNode.setUserObject(diagram);
			rootNode.add(diagramNode);
		}

		// Tree model
		treeModel = new DefaultTreeModel(rootNode);
		objectTree = new JTree(treeModel);
		objectTree.setRootVisible(false);
		objectTree.setCellRenderer(new TreeRenderer());
		objectTree.setBorder(new EmptyBorder(10, 20, 5, 5));
		objectTree.addMouseListener(new TreeMouseListener(applicationModel));
		// Scroll pane for the tree
		scrollPane = new JScrollPane(objectTree);
		scrollPane.setPreferredSize(new Dimension(200, 300));

		// Add components
		add(scrollPane, BorderLayout.CENTER);
	}

	public void filterTree(String query) {
		System.out.println("\n==== FILTER TREE CALLED ====");
		System.out.println("Query: '" + query + "'");

		// Reset case - show original tree
		if (query == null || query.trim().isEmpty()) {
			System.out.println("Empty query - resetting to original tree");
			objectTree.setModel(treeModel);
			expandAllRows();
			return;
		}

		try {
			// Normalize query
			query = query.toLowerCase().trim();
			System.out.println("Normalized query: '" + query + "'");

			// Get nodes that match
			DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
			System.out.println("Original root: " + root + ", children: " + root.getChildCount());

			// Create new root for filtered tree
			DefaultMutableTreeNode newRoot = new DefaultMutableTreeNode("Root");
			boolean matchFound = false;

			// Process each top-level node
			for (int i = 0; i < root.getChildCount(); i++) {
				DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(i);
				System.out.println("Processing top-level node: " + child.getUserObject());

				// Check if this node or any child matches
				if (containsQuery(child, query)) {
					System.out.println("MATCH FOUND in branch: " + child.getUserObject());
					newRoot.add(cloneNode(child));
					matchFound = true;
				} else {
					System.out.println("No match in branch: " + child.getUserObject());
				}
			}

			System.out.println("New root has " + newRoot.getChildCount() + " children");

			// Apply the new model
			if (matchFound) {
				System.out.println("Setting new filtered model");
				DefaultTreeModel newModel = new DefaultTreeModel(newRoot);
				objectTree.setModel(newModel);
			} else {
				System.out.println("No matches found - showing empty tree");
				DefaultMutableTreeNode emptyRoot = new DefaultMutableTreeNode("No matches found");
				DefaultTreeModel emptyModel = new DefaultTreeModel(emptyRoot);
				objectTree.setModel(emptyModel);
			}

			// Make sure tree is expanded and visible
			expandAllRows();

			// Force UI update
			SwingUtilities.invokeLater(() -> {
				objectTree.updateUI();
				scrollPane.updateUI();
				scrollPane.revalidate();
				scrollPane.repaint();
			});

		} catch (Exception e) {
			System.err.println("ERROR IN FILTER TREE: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Check if a node or any of its descendants contain the query
	 */
	private boolean containsQuery(DefaultMutableTreeNode node, String query) {
		// Check this node
		Object userObj = node.getUserObject();

		// Skip "hide" nodes
		if (userObj.toString().equals("hide")) {
			return false;
		}

		// Check if this node matches
		String nodeText = userObj.toString().toLowerCase();
		if (nodeText.contains(query)) {
			System.out.println("  - Direct match on: " + userObj);
			return true;
		}

		// Check children recursively
		for (int i = 0; i < node.getChildCount(); i++) {
			DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
			if (containsQuery(child, query)) {
				System.out.println("  - Child match in: " + userObj);
				return true;
			}
		}

		return false;
	}

	/**
	 * Create a deep copy of a node and its children
	 */
	private DefaultMutableTreeNode cloneNode(DefaultMutableTreeNode original) {
		DefaultMutableTreeNode clone = new DefaultMutableTreeNode(original.getUserObject());

		for (int i = 0; i < original.getChildCount(); i++) {
			DefaultMutableTreeNode child = (DefaultMutableTreeNode) original.getChildAt(i);

			// Skip "hide" nodes
			if (child.getUserObject().toString().equals("hide")) {
				continue;
			}

			clone.add(cloneNode(child));
		}

		return clone;
	}

	/**
	 * Expand all rows in the tree
	 */
	private void expandAllRows() {
		System.out.println("Expanding all rows");
		for (int i = 0; i < objectTree.getRowCount(); i++) {
			objectTree.expandRow(i);
		}
		System.out.println("Tree now has " + objectTree.getRowCount() + " visible rows");
	}

	public JTree getObjectTree() {
		return objectTree;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public ApplicationModel getApplicationModel() {
		return applicationModel;
	}

	public void setApplicationModel(ApplicationModel applicationModel) {
		this.applicationModel = applicationModel;
	}

	public void setObjectTree(JTree objectTree) {
		this.objectTree = objectTree;
	}

	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}

}