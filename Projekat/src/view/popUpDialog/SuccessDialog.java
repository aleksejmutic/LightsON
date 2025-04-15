package view.popUpDialog;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import localization.Localization;

public class SuccessDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    
    private Localization localization=null;

    public SuccessDialog(JFrame parent, String message, String title) {
        super(parent, title, true);
        
        localization = Localization.getInstance();
        
        //parent.setTitle(localization.getString("menu.window.dialog.popUp.title.error"));
        //localization.registerComponent("menu.window.dialog.popUp.title.error", parent);
        
        setLayout(new FlowLayout());
        setSize(300, 150);
        setLocationRelativeTo(parent);

        JLabel messageLabel = new JLabel(message);
        localization.registerComponent(message, messageLabel);
        add(messageLabel);

        JButton okButton = new JButton(localization.getString("menu.window.dialog.popUp.ok"));
        okButton.addActionListener(e -> dispose());
        localization.registerComponent("menu.window.dialog.popUp.ok", okButton);
        add(okButton);

        setVisible(true);
    }
}