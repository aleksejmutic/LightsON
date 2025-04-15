/***********************************************************************
 * Module:  OutputTerminal.java
 * Author:  goran
 * Purpose: Defines the Class OutputTerminal
 ***********************************************************************/

package view.decoratorPanels;

import javax.swing.*;
import javax.swing.text.*;

import localization.Localization;
import view.contextMenu.TerminalContextMenu;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OutputTerminalPane extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextPane textPane;
    private StyledDocument doc;
    private SimpleAttributeSet defaultStyle;
    private JButton showTerminalButton;
    private boolean isTerminalVisible;
    private TerminalContextMenu contextMenu;
    Localization localization = null;
    
    public OutputTerminalPane() {
    	
    	localization = Localization.getInstance();
    	
        setLayout(new BorderLayout());
        
        setPreferredSize(new Dimension(0, 200)); // ⬅ Increases the height

        textPane = new JTextPane();
        textPane.setEditable(false);
        //textPane.setBackground(Color.GRAY); // Background color for terminal look
        
        doc = textPane.getStyledDocument();

        // Default text style
        defaultStyle = new SimpleAttributeSet();
        StyleConstants.setFontFamily(defaultStyle, "Arial");
        StyleConstants.setFontSize(defaultStyle, 14);
        StyleConstants.setForeground(defaultStyle, Color.BLACK);

        // Add title at the top
        SimpleAttributeSet titleStyle = new SimpleAttributeSet();
        StyleConstants.setFontFamily(titleStyle, "Arial");
        StyleConstants.setFontSize(titleStyle, 16);
        StyleConstants.setBold(titleStyle, true);
        StyleConstants.setForeground(titleStyle, Color.BLACK);
        
        contextMenu = new TerminalContextMenu(this);
        textPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showContextMenu(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showContextMenu(e);
                }
            }

            private void showContextMenu(MouseEvent e) {
                contextMenu.showMenu(e.getComponent(), e.getX(), e.getY());
            }
        });

        // Show Terminal Button
        showTerminalButton = new JButton(localization.getString("terminal.show"));
        localization.registerComponent("terminal.show", showTerminalButton);
        showTerminalButton.setVisible(false);
        showTerminalButton.addActionListener(e -> showTerminal());

        isTerminalVisible = true;

        try {
            doc.insertString(doc.getLength(), "Terminal\n\n", titleStyle);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(textPane);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void appendStyledText(String text) {
        try {
            doc.insertString(doc.getLength(), ">" + text + "\n", defaultStyle);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    
    public void hideTerminal() {
        removeAll();

        JPanel buttonPanel = new JPanel(new GridBagLayout()); // Center button
        buttonPanel.setOpaque(false); // Transparent background

        showTerminalButton.setPreferredSize(new Dimension(150, 30)); // Smaller button
        buttonPanel.add(showTerminalButton);

        add(buttonPanel, BorderLayout.CENTER); // Add the smaller button panel
        isTerminalVisible = false;
        showTerminalButton.setVisible(true);
        
        revalidate();
        repaint();
    }

    public void showTerminal() {
        removeAll();
        add(new JLabel("Terminal", SwingConstants.CENTER), BorderLayout.NORTH);
        add(new JScrollPane(textPane), BorderLayout.CENTER);
        isTerminalVisible = true;
        showTerminalButton.setVisible(false);
        revalidate();
        repaint();
    }

    public boolean isTerminalVisible() {
        return isTerminalVisible;
    }

}