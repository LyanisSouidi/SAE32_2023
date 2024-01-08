import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SheetController implements MouseListener, KeyListener {

    private JTextArea[][] cells;
    private JTextField calculTextField;

    public SheetController(JTextArea[][] cells, JTextField calculTextField) {
        this.cells = cells;
        this.calculTextField = calculTextField;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (e.getSource() == cells[i][j]) {
                    calculTextField.setText(cells[i][j].getText());
                    cells[i][j].setBackground(Color.GREEN);
                } else {
                    cells[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '\n') {
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    if (cells[i][j].getBackground() == Color.GREEN) {
                        cells[i][j].setText(calculTextField.getText());
                    }
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}