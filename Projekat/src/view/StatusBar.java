package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import observer.Subject;

public class StatusBar extends JPanel implements ViewComponent {
	private static final long serialVersionUID = 1L;
	protected JLabel leftLabel;
    protected JLabel centerLabel;
    protected JLabel rightLabel;

    public StatusBar() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(0, 25)); 
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        
        leftLabel = new JLabel(" State ");
        centerLabel = new JLabel(" Licenced as ", SwingConstants.CENTER);
        rightLabel = new JLabel(" Right Text ", SwingConstants.RIGHT);

        
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        leftPanel.add(leftLabel);
        centerPanel.add(centerLabel);
        rightPanel.add(rightLabel);

        
        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        
        loadUserFromFile();

        
        updateDateTime();
    }

    
    private void loadUserFromFile() {
        String filePath = "user.txt"; 
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder userData = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                userData.append(line).append(" ");
            }
            centerLabel.setText(userData.toString().trim()); 
        } catch (IOException e) {
            centerLabel.setText("Guest mode");
        }
    }

    
    private void updateDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        rightLabel.setText(formatter.format(new Date()));
    }

    protected void setLeftComponent(String text) {
        leftLabel.setText(" " + text + " ");
    }

    protected void setCenterComponent(String text) {
        centerLabel.setText(" " + text + " ");
    }

    protected void setRightComponent(String text) {
        rightLabel.setText(" " + text + " ");
    }

    public void createPartControl() {
        // TODO: implement
    }

    public void paintComponent() {
        // TODO: implement
    }

    public void update() {
        // TODO: implement
    }

    @Override
    public void update(Subject subject) {
        // TODO Auto-generated method stub
    }
}
