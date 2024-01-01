import java.util.*;

public class Worksheet {
    private Map<String, Cell> cellsMap;

    public Worksheet() {
        this.cellsMap = new HashMap<>();
    }

    public Cell get(String cellName) {
        if (!cellsMap.containsKey(cellName)) {
            throw new IllegalArgumentException("Cell " + cellName + " does not exist");
        } else {
            return cellsMap.get(cellName);
        }
    }
}