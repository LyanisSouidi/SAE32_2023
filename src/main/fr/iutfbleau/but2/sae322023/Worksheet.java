package fr.iutfbleau.but2.sae322023;
import java.util.*;

/**
 * The <code>Worksheet</code> class represents a worksheet.
 * 
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class Worksheet {
    /**
     * The cells of the worksheet.
     */
    private Map<String, Cell> cellsMap;

    /**
     * Constructor of the class.
     */
    public Worksheet() {
        this.cellsMap = new HashMap<String, Cell>();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                String location = String.valueOf((char)(j + 64)) + i;
                this.cellsMap.put(location, new Cell(this, location));
            }
        }
    }

    /**
     * Get the cells of the worksheet.
     * 
     * @return the cells of the worksheet.
     */
    public Map<String, Cell> getCells() {
        return this.cellsMap;
    }

    /**
     * Get the cells of the worksheet.
     * 
     * @return the cells of the worksheet.
     */
    public Cell get(String cellName) {
        if (!cellsMap.containsKey(cellName)) {
            throw new IllegalArgumentException("Cell " + cellName + " does not exist");
        } else {
            return cellsMap.get(cellName);
        }
    }
}