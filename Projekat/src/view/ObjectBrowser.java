package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.javadocking.dock.Position;
import com.javadocking.dockable.DefaultDockable;
import com.javadocking.dockable.Dockable;
import com.javadocking.dockable.DockingMode;

import model.ApplicationModel;
import observer.Subject;

public class ObjectBrowser extends ComponentDecorator {
	private static final long serialVersionUID = 1L;
	private CustomObjectBrowser customObjectBrowser;
	private Dockable dock;

	public ObjectBrowser(Editor editor) {
		super(editor);
		customObjectBrowser = new CustomObjectBrowser();
		setCustomObjectBrowser(customObjectBrowser);
		dock = new DefaultDockable("dock1", customObjectBrowser, "ObjectBrowser", null, DockingMode.HORIZONTAL_LINE);
		showComponent();
		customObjectBrowser.getCloseButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hideComponent();
			}
		});
	}

	public CustomObjectBrowser getCustomObjectBrowser() {
		return customObjectBrowser;
	}

	public void setCustomObjectBrowser(CustomObjectBrowser customObjectBrowser) {
		this.customObjectBrowser = customObjectBrowser;
	}

	@Override
	public void update(Subject subject) {
		ApplicationModel applicationModel = (ApplicationModel) subject;
		super.update(subject);
		customObjectBrowser.getObjectBrowserPane().refreshTree(applicationModel);

	}

	@Override
	public void showComponent() {
		getContentPane().addDockable(dock, new Position(0));
		getContentPane().updateUI();
	}

	@Override
	public void hideComponent() {
		getContentPane().removeDockable(dock);
		getContentPane().updateUI();
	}
}
