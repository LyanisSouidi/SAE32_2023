import java.awt.BorderLayout;
import java.util.*;

public class WorksheetController {
    private WorksheetView view;
    private Worksheet model;
    private Map<String,CellController> cellsControllersMap;

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