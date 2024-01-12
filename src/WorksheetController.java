import java.awt.BorderLayout;
import java.util.*;

/**
 * The <code>WorksheetController</code> class represents the controller of the worksheet.
 *
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class WorksheetController {
    /**
     * The view of the worksheet.
     */
    private WorksheetView view;

    /**
     * The model of the worksheet.
     */
    private Worksheet model;

    /**
     * The map of the cells controllers.
     */
    private Map<String,CellController> cellsControllersMap;

    /**
     * Constructor of the class.
     *
     * @param windowController the controller of the window
     * @param windowView the view of the window
     * @param model the model of the worksheet
     */
    public WorksheetController(WindowController windowController, WindowView windowView, Worksheet model) {
        this.model = model;

        Map<String,Cell> cellsMap = this.model.getCells();
        this.cellsControllersMap = new HashMap<String,CellController>();

        for (Map.Entry<String, Cell> entry : cellsMap.entrySet()) {
            CellController cellController = new CellController(entry.getValue());
            this.cellsControllersMap.put(entry.getKey(), cellController);
            cellController.addObserver(windowController);
        }

        this.view = new WorksheetView(this.cellsControllersMap);
        windowView.add(this.view, BorderLayout.CENTER);
    }

}