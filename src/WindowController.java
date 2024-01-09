import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class WindowController implements KeyListener {

    private Window view;

    public WindowController(Window view) {
        this.view = view;
        this.view.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
