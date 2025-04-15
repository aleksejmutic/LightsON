package model.command;

import java.awt.Dimension;
import java.awt.Point;

import model.AbstractUndoableCommad;
import model.ApplicationModel;
import model.CompositeWire;
import model.Diagram;
import model.Element;
import model.GroupedElements;

public class GroupElements extends AbstractUndoableCommad {

	public GroupElements(ApplicationModel applicationModel) {
		super(applicationModel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		Diagram diagram = this.applicationModel.getActiveDiagram();
		

		if (diagram != null) {
			Element topLeftElement = null;
			Element bottomRightElement = null;

			Point topLeft = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
			Point bottomRight = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);

			GroupedElements elementGroup = new GroupedElements();

			for (Element element : diagram.getElements()) {
				if (element.getIsSelected() == true) {
					elementGroup.addElement(element);
				}
			}

			for (Element element : elementGroup.getElements()) {
				Point point = element.getPoint();
				if (!(element instanceof CompositeWire)) {
					// Check for the most top-left element
					if (point.getX() <= topLeft.getX() && point.getY() <= topLeft.getY()) {
						topLeft = point;
						topLeftElement = element;
					}

					// Check for the most bottom-right element
					if (point.getX() >= bottomRight.getX() && point.getY() >= bottomRight.getY()) {
						bottomRight = point;
						bottomRightElement = element;
					}
					diagram.getElements().remove(element);
				}
			}
			if (!elementGroup.getElements().isEmpty()) {
				Dimension groupedElementDimension = new Dimension();
				groupedElementDimension = calculateElementsDimension(topLeftElement, bottomRightElement);
				elementGroup.setPoint(topLeft);
				elementGroup.setEndPoint(bottomRight);
				elementGroup.setWidth(groupedElementDimension.width);
				elementGroup.setHeight(groupedElementDimension.height);
				diagram.addElement(elementGroup);
				applicationModel.notifyObervers();
			}
		}
	}

	private Dimension calculateElementsDimension(Element upperLeftElement, Element bottomRightElement) {
		int x1 = (int) upperLeftElement.getPoint().getX();
		int y1 = (int) upperLeftElement.getPoint().getY();

		int x2 = (int) bottomRightElement.getPoint().getX() + bottomRightElement.getWidth();
		int y2 = (int) bottomRightElement.getPoint().getY() + bottomRightElement.getHeight();

		int width = x2 - x1;
		int height = y2 - y1;

		return new Dimension(width, height);
	}
}
