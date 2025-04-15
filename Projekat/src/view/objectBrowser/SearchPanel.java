package view.objectBrowser;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

public class SearchPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField searchField;
	private JButton clearButton;
	private JButton searchButton;
	private JButton resetButton;
	private String searchQuery = "";

	public SearchPanel(TreePanel treePanel) {

		// Use FlowLayout with center alignment
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		// Initialize the search field with a placeholder text "Search"
		searchField = new JTextField("Search");
		searchField.setColumns(10); // Reasonable width for input
		searchField.setPreferredSize(new Dimension(100, 25)); // Smaller dimensions

		// Add a focus listener to handle placeholder behavior
		searchField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (searchField.getText().equals("Search")) {
					searchField.setText("");
					searchField.setForeground(Color.BLACK); // Change text color to black when typing
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (searchField.getText().isEmpty()) {
					searchField.setText("Search");
					searchField.setForeground(Color.LIGHT_GRAY); // Reset to pale gray
				}
			}
		});

		// Kreiranje dugmadi
		clearButton = new JButton("X");
		clearButton.setPreferredSize(new Dimension(30, 25));
		clearButton.setFocusable(false);
		clearButton.addActionListener(e -> {
			searchField.setText(""); // Clear text
			searchField.requestFocus(); // Keep focus on input field
		});

		resetButton = new JButton("<-");
		resetButton.setPreferredSize(new Dimension(30, 25));
		resetButton.setFocusable(false);

		searchButton = new JButton("🔍");
		searchButton.setPreferredSize(new Dimension(30, 25));
		searchButton.setFocusable(false);

		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// When the search button is clicked, capture the input
				searchQuery = searchField.getText();
				treePanel.filterTree(searchQuery);
				System.out.println(searchQuery);
			}
		});

		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Check if the Enter key is pressed
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// When Enter is pressed, capture the input
					searchQuery = searchField.getText();
					treePanel.filterTree(searchQuery);
					SwingUtilities.invokeLater(() -> {
						clearButton.requestFocusInWindow(); // Transfer focus to the searchButton
					});
					System.out.println(searchQuery);
				}
			}
		});
		
		resetButton.addActionListener(e -> {
	        searchField.setText(""); // Clear field
	        treePanel.filterTree(""); // Reset tree
	    });

		// Add components to the panel (all will be center-aligned)
		add(searchField);
		add(clearButton);
		add(resetButton);
		add(searchButton);

		// Set the preferred size for the entire SearchPanel
		setPreferredSize(new Dimension(250, 40)); // Wider to allow centering
		setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // Ensure it doesn’t stretch too much

	}

}
