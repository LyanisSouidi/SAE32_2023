import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

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

    /**
     * Constructor of the class.
     * 
     * @param cell the cell.
     */
    public CellView(Cell cell) {
        super(cell.evaluate());
        this.cell = cell;
        this.cell.setView(this);

        this.setEditable(false);
        this.setFont(new Font("Arial", Font.BOLD, 15));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /**
     * Update the view of the cell.
     */
    public void update() {
        String text = this.cell.evaluate();
        this.setText(text);

        if (text.startsWith("#") && text.endsWith("!")) {
            this.setForeground(Color.WHITE);
            this.setBackground(Color.RED);
        } else {
            this.setForeground(Color.BLACK);
            this.setBackground(Color.WHITE);
        }
    }
}
