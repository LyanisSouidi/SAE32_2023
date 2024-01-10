import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class CellController extends Observable implements MouseListener {
    private CellView view;
    private Cell model;

    public CellController(Cell model) {
        this.model = model;
        this.view = new CellView(this.model);
        this.view.addMouseListener(this);
    }

    public Cell getModel() {
        return this.model;
    }

    public CellView getView() {
        return this.view;
    }

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