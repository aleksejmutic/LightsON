package view.dialog;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;


import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import localization.Localization;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class FontDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    
    private Localization localization = null;

    public FontDialog(JFrame parent) {
        super(parent, "Font", true);
        
        localization = Localization.getInstance();
        
        setTitle(localization.getString("menu.window.dialog.title"));
        localization.registerComponent("menu.window.dialog.title", this);
        
        setLayout(new GridLayout(5, 1, 10, 10));  
        setSize(400, 400);
        setLocationRelativeTo(parent);

        // Konzistentna lijeva margina za sve panele
        int leftMargin = 20;

        // Red 1: Bold, Italic, i Underline Button-i 
        JPanel stylePanel = new JPanel();
        stylePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10)); 

        JToggleButton boldButton = new JToggleButton("B");
        boldButton.setFont(new Font("Serif", Font.BOLD, 20));
        boldButton.setPreferredSize(new Dimension(100, 50));
        boldButton.setToolTipText(localization.getString("menu.window.dialog.bold"));
        boldButton.setFocusable(false);
        localization.registerComponent("menu.window.dialog.bold", boldButton);

        JToggleButton italicButton = new JToggleButton("I");
        italicButton.setFont(new Font("Serif", Font.ITALIC, 20));
        italicButton.setPreferredSize(new Dimension(100, 50));
        italicButton.setToolTipText(localization.getString("menu.window.dialog.italic"));
        italicButton.setFocusable(false);
        localization.registerComponent("menu.window.dialog.italic", italicButton);

        JToggleButton underlineButton = new JToggleButton("U");
        underlineButton.setFont(new Font("Serif", Font.PLAIN, 20));
        underlineButton.setPreferredSize(new Dimension(100, 50));
        underlineButton.setText("<html><u>U</u></html>"); 
        underlineButton.setToolTipText(localization.getString("menu.window.dialog.underline"));
        underlineButton.setFocusable(false);
        localization.registerComponent("menu.window.dialog.underline", underlineButton);

        stylePanel.add(boldButton);
        stylePanel.add(italicButton);
        stylePanel.add(underlineButton);

        // Red 2: Dropdown za font
        JPanel fontPanel = new JPanel();
        fontPanel.setLayout(new FlowLayout(FlowLayout.LEFT, leftMargin, 10)); 

        JLabel fontLabel = new JLabel(localization.getString("menu.window.dialog.font"));
        fontLabel.setPreferredSize(new Dimension(80, 30));  
        fontPanel.add(fontLabel);
        localization.registerComponent("menu.window.dialog.font", fontPanel);

        String[] fonts = {"Times New Roman", "Arial", "Verdana", "Tahoma", "Courier New", "Georgia", "Comic Sans MS"};
        JComboBox<String> fontComboBox = new JComboBox<>(fonts);
        fontComboBox.setSelectedIndex(0);
        fontComboBox.setPreferredSize(new Dimension(240, 30));  
        fontPanel.add(fontComboBox);

        // Red 3: Dropdown za veličinu
        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new FlowLayout(FlowLayout.LEFT, leftMargin, 10)); 

        JLabel sizeLabel = new JLabel(localization.getString("menu.window.dialog.size"));
        sizeLabel.setPreferredSize(new Dimension(80, 30));  
        sizePanel.add(sizeLabel);
        localization.registerComponent("menu.window.dialog.size", sizePanel);

        Integer[] sizes = {5, 10, 15, 20, 25};
        JComboBox<Integer> sizeComboBox = new JComboBox<>(sizes);
        sizeComboBox.setSelectedItem(10);
        sizeComboBox.setPreferredSize(new Dimension(240, 30));  
        sizePanel.add(sizeComboBox);

        // Red 4: Unos prilagođene veličine
        JPanel customPanel = new JPanel();
        customPanel.setLayout(new FlowLayout(FlowLayout.LEFT, leftMargin, 10)); 
        
        JLabel customLabel = new JLabel(localization.getString("menu.window.dialog.customSize"));
        customLabel.setPreferredSize(new Dimension(80, 30));  
        customPanel.add(customLabel);
        localization.registerComponent("menu.window.dialog.customSize", customPanel);

        JTextField customSizeField = new JTextField(5);
        customSizeField.setPreferredSize(new Dimension(150, 30));  
        customPanel.add(customSizeField);

        // Red 5: Dugmadi za Submit i Cancel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));  

        JButton submitButton = new JButton(localization.getString("menu.window.dialog.submit"));
        submitButton.setPreferredSize(new Dimension(120, 50));
        localization.registerComponent("menu.window.dialog.customSize", submitButton);

        JButton cancelButton = new JButton(localization.getString("menu.window.dialog.cancel"));
        cancelButton.setPreferredSize(new Dimension(120, 50));
        localization.registerComponent("menu.window.dialog.customSize", cancelButton);

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  // Zatvara dijalog
            }
        });

        // Dodavanje KeyListener-a za upravljanje Enter tipkom za slanje obrasca
        customSizeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submitButton.doClick();  // Simulira klik na Submit dugme
                }
            }
        });

        // Postavljanje fokusa na polje za prilagođenu veličinu kada se dijalog otvori 
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                customSizeField.requestFocusInWindow(); // Fokus na input polje
            }
        });

        // Dodavanje svih redova u dijalog
        add(stylePanel);
        add(fontPanel);
        add(sizePanel);
        add(customPanel);
        add(buttonPanel);

        setVisible(true);
    }
}















