package view.diagramCanvas;

import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import view.Canvas;

public class DiagramScrollPane extends JScrollPane {
	private static final long serialVersionUID = 1L;

	public DiagramScrollPane(Canvas canvas) {

        setViewportView(canvas);
        setPreferredSize(new Dimension(800, 500));


        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        customizeScrollBars();
    }

	private void customizeScrollBars() {
        JScrollBar horizontalBar = getHorizontalScrollBar();
        horizontalBar.setPreferredSize(new Dimension(20, 20));

        JScrollBar verticalBar = getVerticalScrollBar();
        verticalBar.setPreferredSize(new Dimension(20, 20)); 
    }
}
