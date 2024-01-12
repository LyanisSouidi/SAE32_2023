import java.awt.event.*;
import java.util.*;

/**
 * The <code>CellController</code> class represents the controller of a cell.
 *
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class CellController extends Observable implements MouseListener {
    /**
     * The view of the cell.
     */
    private CellView view;

    /**
     * The model of the cell.
     */
    private Cell model;

    /**
     * Constructor of the class.
     *
     * @param model the model of the cell.
     */
    public CellController(Cell model) {
        this.model = model;
        this.view = new CellView(this.model);
        this.view.addMouseListener(this);
    }

    /**
     * Get the model of the cell.
     *
     * @return the model of the cell.
     */
    public Cell getModel() {
        return this.model;
    }

    /**
     * Get the view of the cell.
     *
     * @return the view of the cell.
     */
    public CellView getView() {
        return this.view;
    }

    /**
     * Notify the observers that the user clicked on the cell.
     * This is used to display the formula of the cell in the formula bar.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view) {
            this.setChanged();
            this.notifyObservers();
        }

    }

    @Override
    public void mousePressed(MouseEvent ignored) {
    }

    @Override
    public void mouseReleased(MouseEvent ignored) {
    }

    @Override
    public void mouseEntered(MouseEvent ignored) {
    }

    @Override
    public void mouseExited(MouseEvent ignored) {
    }

}