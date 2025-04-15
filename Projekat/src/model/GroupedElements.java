package model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GroupedElements extends Element {
    private List<Element> elementGroup = new ArrayList<>();

    @SuppressWarnings("exports")
	public GroupedElements(Point point, Point endPoint, int width, int height, String name) {
        super(point, endPoint, width, height);
    }

    public GroupedElements() {
        super();
        this.elementType = "GroupedElements";
    }

    /** @param element */
    public void addElement(Element element) {
        this.elementGroup.add(element);
    }

    /** @param element */
    public void removeElement(Element element) {
        if (element != null) {
            this.elementGroup.remove(element);
        }
    }

    public List<Element> getElements() {
        return this.elementGroup;
    }

    @SuppressWarnings("exports")
	@Override
    public void drawElement(Graphics g) {
        for (Element element : this.elementGroup) {
            element.drawElement(g);
        }
    }

    @Override
    protected void initializeJunctionPoints() {
        // TODO: implement as needed
    }
}
