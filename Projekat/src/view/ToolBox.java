package view;

import java.awt.BorderLayout;
import model.ApplicationModel;
import observer.Subject;

public class ToolBox extends ComponentDecorator {
    private static final long serialVersionUID = 1L;
    private CustomToolBox customToolBox;


    public ToolBox(Editor editor, ApplicationModel applicationModel) {
        super(editor);
        customToolBox = new CustomToolBox(editor, applicationModel);
        this.setLayout(new BorderLayout());
        this.add(customToolBox, BorderLayout.CENTER);
    }

    @Override
    public void update(Subject subject) {
        super.update(subject);
        ApplicationModel applicationModel = (ApplicationModel) subject;
        customToolBox.getCustomToolBoxPane().setApplicationModel(applicationModel);
    }
}
