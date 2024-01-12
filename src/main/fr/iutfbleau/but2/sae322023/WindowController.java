package fr.iutfbleau.but2.sae322023;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * The <code>WindowController</code> class represents the controller of the main window.
 *
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class WindowController implements KeyListener, Observer {
    /**
     * The main window view.
     */
    private WindowView view;

    /**
     * The text field where the user can enter a formula.
     */
    private JTextField calcul;

    /**
     * The active worksheet model.
     */
    private Worksheet worksheetModel;

    /**
     * The active worksheet controller.
     */
    private WorksheetController worksheetController;

    /**
     * The last cell controller that was selected.
     */
    private CellController lastCellController;

    /**
     * Constructor of the class.
     */
    public WindowController() {
        this.calcul = new JTextField();
        this.calcul.addKeyListener(this);
        this.view = new WindowView(this.calcul);
        this.worksheetModel = new Worksheet();
        this.worksheetController = new WorksheetController(this, this.view, this.worksheetModel);
        this.view.setVisible(true);
    }

    /**
     * Saves the content of the text field when the user presses the enter key.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '\n') {
            if (this.lastCellController == null) return;
            this.lastCellController.getModel().setRawContent(this.calcul.getText());
            this.lastCellController.getView().update();
        }
    }

    /**
     * Method called by the cells when they are selected.
     *
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers} method.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (this.lastCellController != null) this.lastCellController.getView().setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.lastCellController = (CellController) o;
        this.lastCellController.getView().setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5), Color.GREEN));
        this.calcul.setText(this.lastCellController.getModel().toString());
        this.calcul.requestFocus();
    }

    @Override
    public void keyPressed(KeyEvent ignored) {
    }

    @Override
    public void keyReleased(KeyEvent ignored) {
    }
}
