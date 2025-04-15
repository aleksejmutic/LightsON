package model.command;

import java.util.ArrayList;
import java.util.List;

import model.AbstractUndoableCommad;
import model.ApplicationModel;
import model.Diagram;
import model.Element;
import model.GroupedElements;

public class UngroupElements extends AbstractUndoableCommad {

    public UngroupElements(ApplicationModel applicationModel) {
        super(applicationModel);
    }

    @Override
    public void execute() {
        Diagram diagram = this.applicationModel.getActiveDiagram();
        

        if (diagram != null) {
            // Create a list to keep track of GroupedElements to be removed
            List<GroupedElements> groupsToUngroup = new ArrayList<>();

            // Find selected GroupedElements in the diagram
            for (Element element : diagram.getElements()) {
                if (element instanceof GroupedElements && element.getIsSelected()) {
                    groupsToUngroup.add((GroupedElements) element);
                }
            }

            // Ungroup each selected GroupedElements instance
            for (GroupedElements group : groupsToUngroup) {
                // Add all elements inside the group back to the diagram
                for (Element innerElement : group.getElements()) {
                    diagram.addElement(innerElement);
                }

                // Remove the grouped element from the diagram
                diagram.getElements().remove(group);
            }

            // Notify observers about the change
            applicationModel.notifyObervers();
        }
    }
}
