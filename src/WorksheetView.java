import java.awt.*;
import javax.swing.*;

public class WorksheetView extends JPanel {
    private CellView[][] cells;

    public WorksheetView() {
        super(new BorderLayout());

    
        JPanel gridPanel = new JPanel(new GridLayout(9, 9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new CellView();
                cells[i][j].setEditable(false);
                cells[i][j].setFont(new Font("Arial", Font.BOLD, 15));
                cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridPanel.add(cells[i][j]);
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
