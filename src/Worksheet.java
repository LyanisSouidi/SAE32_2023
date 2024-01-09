import java.util.*;

public class Worksheet {
    private Map<String, Cell> cellsMap;

    public Worksheet() {
        this.cellsMap = new HashMap<String, Cell>();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                String location = String.valueOf((char)(i + 64)) + j;
                this.cellsMap.put(location, new Cell(this, location));
            }
        }
    }

    public Cell get(String cellName) {
        if (!cellsMap.containsKey(cellName)) {
            throw new IllegalArgumentException("Cell " + cellName + " does not exist");
        } else {
            return cellsMap.get(cellName);
        }
    }
}