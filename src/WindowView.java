import javax.swing.*;
import java.awt.*;

/**
 * The <code>WindowView</code> class represents the main window view.
 *
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class WindowView extends JFrame {
    /**
     * Constructor of the class
     * @param calcul The text field where the user will enter the formula
     */
    public WindowView(JTextField calcul) {
        super();
        this.setTitle("SAE 32_2023");
        this.setSize(1500, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        calcul.setPreferredSize(new Dimension(1000, 40));
        calcul.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel calculLabel = new JLabel("Calcul : ");
        calculLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel calculPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        calculPanel.add(calculLabel);
        calculPanel.add(calcul);
        this.add(calculPanel, BorderLayout.NORTH);
    }

}
