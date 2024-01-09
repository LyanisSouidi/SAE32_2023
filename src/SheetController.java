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
        for (JTextArea[] cell : cells) {
            for (JTextArea jTextArea : cell) {
                if (e.getSource() == jTextArea) {
                    calculTextField.setText(jTextArea.getText());
                    jTextArea.setBackground(Color.GREEN);
                } else {
                    jTextArea.setBackground(Color.WHITE);
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
            for (JTextArea[] cell : cells) {
                for (JTextArea jTextArea : cell) {
                    if (jTextArea.getBackground() == Color.GREEN) {
                        jTextArea.setText(calculTextField.getText());
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