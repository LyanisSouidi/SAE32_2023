import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class WindowController implements KeyListener, Observer {

    private WindowView view;
    private JTextField calcul;
    private Worksheet worksheetModel;
    private WorksheetController worksheetController;
    private CellController lastCellController;

    public WindowController() {
        this.calcul = new JTextField();
        this.calcul.addKeyListener(this);
        this.view = new WindowView(this.calcul);
        this.worksheetModel = new Worksheet();
        this.worksheetController = new WorksheetController(this, this.view, this.worksheetModel);
        this.view.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '\n') {
            this.lastCellController.getModel().setRawContent(this.calcul.getText());
            this.lastCellController.getView().update();
        }
    }

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
