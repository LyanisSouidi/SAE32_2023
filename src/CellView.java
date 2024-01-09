import javax.swing.JTextArea;

/**
 * The <code>CellView</code> class represents the view of a cell in a worksheet.
 * 
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class CellView extends JTextArea {

    /**
     * The cell.
     */
    private Cell cell;

    private CellView[][] cellsTab;

    /**
     * Constructor of the class.
     * 
     * @param cell the cell.
     */
    public CellView(Cell cell) {
        super(cell.evaluate());
        this.cell = cell;
        this.cell.setView(this);
        this.cellsTab = new CellView[9][9];
    }

    /**
     * Update the view of the cell.
     */
    public void update() {
        this.setText(this.cell.evaluate());
    }
}
