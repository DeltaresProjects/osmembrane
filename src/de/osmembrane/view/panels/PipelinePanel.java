package de.osmembrane.view.panels;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import de.osmembrane.Application;
import de.osmembrane.controller.ActionRegistry;
import de.osmembrane.controller.actions.AddFunctionAction;
import de.osmembrane.controller.events.ContainingLocationEvent;
import de.osmembrane.exceptions.ControlledException;
import de.osmembrane.exceptions.ExceptionSeverity;
import de.osmembrane.model.ModelProxy;
import de.osmembrane.model.pipeline.AbstractFunction;
import de.osmembrane.model.pipeline.PipelineObserverObject;
import de.osmembrane.view.ViewRegistry;

/**
 * This is the pipeline view, i.e. the panel that shows the entire pipeline with
 * all functions and connectors.
 * 
 * @author tobias_kuhn
 * 
 */
public class PipelinePanel extends JPanel implements Observer {

	private static final long serialVersionUID = 2544369818627179591L;

	/**
	 * list of functions currently being present on the panel
	 */
	private List<PipelineFunction> functions;

	/**
	 * The transformation which transforms the object coordinates to window
	 * coordinates, depending on the view port and the zooming level
	 */
	private AffineTransform objectToWindow;

	/**
	 * A temporary transformation to be used after objectToWindow to represent
	 * the current changes of the display (move dragging, zoom animation)
	 */
	private AffineTransform currentDisplay;

	/**
	 * Saves the point in object coordinates when a drag and drop action occurs
	 * *inside* the pipeline panel (i.e. not from the library)
	 */
	private Point2D draggingFrom;

	/**
	 * The links to the library and to the inspector used for communication
	 * between these components.
	 */
	private LibraryPanel functionLibrary;
	private InspectorPanel functionInspector;

	/**
	 * The currently selected tool. Must be one of the _TOOL constants.
	 */
	private Tool activeTool;

	/**
	 * The currently selected object (either a PipelineFunction or a
	 * PipelineConnector)
	 */
	private Object selected;

	/**
	 * Initializes a new pipeline view
	 * 
	 * @param functionLibrary
	 * @param functionInspector
	 */
	public PipelinePanel(final LibraryPanel functionLibrary,
			InspectorPanel functionInspector) {

		// best decision ever <- do not touch
		setLayout(null);

		// internal values
		this.functions = new ArrayList<PipelineFunction>();
		this.functionLibrary = functionLibrary;
		this.functionInspector = functionInspector;

		this.activeTool = Tool.DEFAULT_MAGIC_TOOL;
		this.selected = null;

		this.objectToWindow = new AffineTransform();
		this.currentDisplay = new AffineTransform();

		// register as observer
		ViewRegistry.getInstance().addObserver(this);

		// all listeners for all kind of events

		addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// zoom with mouse wheel
				if (e.getWheelRotation() < 0) {
					zoomIn(e.getPoint());
				} else {
					zoomOut(e.getPoint());
				}
			}
		});

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				switch (activeTool) {
				case DEFAULT_MAGIC_TOOL:
				case VIEW_TOOL:
					objectToWindow.preConcatenate(currentDisplay);				
					currentDisplay.setToIdentity();
					draggingFrom = null;
					arrange();
					break;
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				switch (activeTool) {
				case DEFAULT_MAGIC_TOOL:
				case VIEW_TOOL:
					// start dragging
					draggingFrom = windowToObj(e.getPoint());
					currentDisplay.setToIdentity();
					break;
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				switch (activeTool) {
				case DEFAULT_MAGIC_TOOL:
				case VIEW_TOOL:
					// find the dragging target
					if (draggingFrom != null) {
						Point2D draggingTo = windowToObjFixed(e.getPoint());
						currentDisplay.setToTranslation(
								objectToWindow.getScaleX()
										* (draggingTo.getX() - draggingFrom
												.getX()),
								objectToWindow.getScaleY()
										* (draggingTo.getY() - draggingFrom
												.getY()));
						arrange();
					}
					break;
				}
			}
		});
	}

	/**
	 * Translates window coordinates to object coordinates
	 * 
	 * @param window
	 *            window coordinates
	 * @return window in object coordinates, null if there is an error with the
	 *         transformations which should theoretically never be the case
	 */
	private Point2D windowToObj(Point window) {
		Point2D result = new Point2D.Double();

		try {
			currentDisplay.inverseTransform(window, result);
			objectToWindow.inverseTransform(result, result);
		} catch (NoninvertibleTransformException e) {
			Application.handleException(e);
		}

		return result;
	}

	/**
	 * Translates window coordinates to object coordinates based on only the
	 * object to window transformation, not the display transformation. This is
	 * necessary for dragging operations to transform only by the part of the
	 * transformation which is currently determined.
	 * 
	 * @param window
	 *            window coordinates
	 * @return window in object coordinates, only of basic transformation, null
	 *         if there is an error with the transformations which should
	 *         theoretically never be the case
	 */
	private Point2D windowToObjFixed(Point window) {
		Point2D result = new Point2D.Double();

		try {
			objectToWindow.inverseTransform(window, result);
		} catch (NoninvertibleTransformException e) {
			Application.handleException(e);
		}

		return result;
	}

	/**
	 * Translates object coordinates to window coordinates
	 * 
	 * @param object
	 *            object coordinates
	 * @return object in window coordinates
	 */
	private Point objToWindow(Point2D object) {
		Point2D result = new Point2D.Double();

		objectToWindow.transform(object, result);
		currentDisplay.transform(result, result);

		return new Point((int) result.getX(), (int) result.getY());
	}

	/**
	 * Translates object delta coordinates to window delta coordinates. Typical
	 * delta coordinates are object sizes.
	 * 
	 * @param objectDelta
	 *            object delta coordinates
	 * @return object in window delta coordinates
	 */
	private Point objToWindowDelta(Point2D objectDelta) {
		Point2D result = new Point2D.Double();

		objectToWindow.deltaTransform(objectDelta, result);
		currentDisplay.deltaTransform(result, result);

		return new Point((int) result.getX(), (int) result.getY());
	}

	/**
	 * Zooms in
	 */
	public void zoomIn() {
		zoomIn(new Point(getWidth() / 2, getHeight() / 2));
	}

	/**
	 * Zooms in
	 * 
	 * @param center
	 *            center of the zooming operation
	 */
	public void zoomIn(Point center) {
		Point2D objCenter = windowToObj(center);
		objectToWindow.translate(+objCenter.getX(), +objCenter.getY());
		objectToWindow.scale(1.25, 1.25);
		objectToWindow.translate(-objCenter.getX(), -objCenter.getY());
		arrange();
	}

	/**
	 * Zooms in
	 */
	public void zoomOut() {
		zoomOut(new Point(getWidth() / 2, getHeight() / 2));
	}

	/**
	 * Zooms out
	 * 
	 * @param center
	 *            center of the zooming operation
	 */
	public void zoomOut(Point center) {
		// translate the center
		Point2D objCenter = windowToObj(center);
		objectToWindow.translate(+objCenter.getX(), +objCenter.getY());
		objectToWindow.scale(0.80, 0.80);
		objectToWindow.translate(-objCenter.getX(), -objCenter.getY());
		arrange();
	}

	/**
	 * Resets the view to standard
	 */
	public void resetView() {
		objectToWindow.setToIdentity();
		arrange();

	}

	/**
	 * Shows the entire pipeline
	 */
	public void showEntireView() {
		// TODO Auto-generated method stub
		arrange();
	}

	@Override
	public void update(Observable o, Object arg) {
		// check for notice from the pipeline model
		if (arg instanceof PipelineObserverObject) {
			PipelineObserverObject poo = (PipelineObserverObject) arg;

			switch (poo.getType()) {

			// new function was added
			case ADD:
				PipelineFunction pfAdd = new PipelineFunction(
						poo.getChangedFunction());
				functions.add(pfAdd);
				add(pfAdd);
				arrange(pfAdd);
				break;

			// properties of a function changed
			case CHANGE:
				for (PipelineFunction pfChange : functions) {
					if (pfChange.getModelFunction().equals(
							poo.getChangedFunction())) {
						arrange(pfChange);
						repaint();
					}
				}
				break;

			// a function got removed
			case DELETE:
				for (int i = 0; i < functions.size(); i++) {
					PipelineFunction pfDelete = functions.get(i);

					if (pfDelete.getModelFunction().equals(
							poo.getChangedFunction())) {
						remove(pfDelete);
						functions.remove(i);
						break;
					}
				}
				break;

			// the whole pipeline was exchanged
			case FULLCHANGE:
				functions.clear();
				removeAll();

				for (AbstractFunction af : ModelProxy.getInstance()
						.accessPipeline().getFunctions()) {
					PipelineFunction pfFullChange = new PipelineFunction(af);
					functions.add(pfFullChange);
					add(pfFullChange);
				}
				arrange();
				break;
			}
		}
	}

	/**
	 * Arranges all the functions after a move/zoom change
	 */
	private void arrange() {
		// left top point coordinates
		double minX = Double.MAX_VALUE;
		double minY = Double.MAX_VALUE;
		// bottom right point coordinates
		double maxX = Double.MIN_VALUE;
		double maxY = Double.MIN_VALUE;

		for (PipelineFunction pf : functions) {
			arrange(pf);
		}
	}

	/**
	 * Arrange a specific function after any change
	 * 
	 * @param pf
	 *            the function to arrange
	 */
	private void arrange(PipelineFunction pf) {
		Point location = objToWindow(pf.getModelLocation());
		pf.setLocation(location);

		Point size = new Point(pf.getPreferredSize().width,
				pf.getPreferredSize().height);
		size = objToWindowDelta(size);
		pf.setSize(size.x, size.y);
	}

	/**
	 * Forwards hint display from functions and library under the cursor to the
	 * inspector.
	 * 
	 * @param hintText
	 *            the hint to display
	 */
	public void setHint(String hintText) {
		functionInspector.setHintText(hintText);
	}

	/**
	 * Is called when a ViewFunction that canDragAndDrop was dragged onto the
	 * Pipeline panel
	 * 
	 * @param libraryFunction
	 *            The new function to add
	 */
	public void draggedOnto(LibraryFunction libraryFunction, Point at) {

		// drag & drop functionality : add function
		Action a = ActionRegistry.getInstance().get(AddFunctionAction.class);
		Point2D newPosition = windowToObj(at);

		ContainingLocationEvent cle = new ContainingLocationEvent(this,
				libraryFunction.getModelFunctionPrototype(), newPosition);
		a.actionPerformed(cle);
	}

	/**
	 * @return the currently selected object
	 */
	public Object getSelected() {
		return selected;
	}

	/**
	 * Called when a child object thinks it got selected
	 * 
	 * @param pipelineFunction
	 */
	public void selected(PipelineFunction pipelineFunction) {
		selected = pipelineFunction;
		for (PipelineFunction pf : functions) {
			pf.repaint();
		}

	}

	/**
	 * @param activeTool
	 *            the activeTool to set
	 * @param newCursor
	 *            the cursor associated with the new tool, or null if no change
	 */
	public void setActiveTool(Tool activeTool, Cursor newCursor) {
		this.activeTool = activeTool;
		if (newCursor != null) {
			this.setCursor(newCursor);
		}
	}

	/**
	 * @return the activeTool
	 */
	public Tool getActiveTool() {
		return activeTool;
	}

}