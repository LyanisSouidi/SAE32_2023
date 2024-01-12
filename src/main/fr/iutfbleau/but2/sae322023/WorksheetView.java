package fr.iutfbleau.but2.sae322023;

import java.awt.*;
import java.util.Map;
import javax.swing.*;

/**
 * The <code>WorksheetView</code> class represents the view of the worksheet.
 *
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class WorksheetView extends JPanel {
    /**
     * The map of the cells controllers.
     */
    private Map<String, CellController> cellsControllersMap;

    /**
     * Constructor of the class.
     *
     * @param cellsControllersMap the map of the cells controllers
     */
    public WorksheetView(Map<String, CellController> cellsControllersMap) {
        super(new BorderLayout());
        this.cellsControllersMap = cellsControllersMap;

        JPanel gridPanel = new JPanel(new GridLayout(9, 9));

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                String location = String.valueOf((char) (j + 64)) + i;
                CellView cellView = this.cellsControllersMap.get(location).getView();
                gridPanel.add(cellView);
            }
        }

        JPanel lettersPanel = new JPanel(new GridLayout(1, 9));
        for (int i = 0; i < 9; i++) {
            JLabel letter = new JLabel(String.valueOf((char) (i + 65)));
            letter.setFont(new Font("Arial", Font.BOLD, 20));
            letter.setHorizontalAlignment(JLabel.CENTER);
            lettersPanel.add(letter);
        }

        JPanel numbersPanel = new JPanel(new GridLayout(9, 1));
        for (int i = 0; i < 9; i++) {
            JLabel number = new JLabel(String.valueOf(i + 1));
            number.setFont(new Font("Arial", Font.BOLD, 20));
            number.setHorizontalAlignment(JLabel.CENTER);
            numbersPanel.add(number);
        }

        JPanel gridLettersPanel = new JPanel(new BorderLayout());
        gridLettersPanel.add(lettersPanel, BorderLayout.NORTH);
        gridLettersPanel.add(gridPanel, BorderLayout.CENTER);

        this.add(numbersPanel, BorderLayout.WEST);
        this.add(gridLettersPanel, BorderLayout.CENTER);

    }

}
