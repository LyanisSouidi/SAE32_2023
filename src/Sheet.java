import java.awt.*;
import javax.swing.*;

public class Sheet extends Window {
    private JTextArea[][] cells;
    private JTextField calculTextField;

    public Sheet() {
        super();

        JTextField calcul = new JTextField();

        this.calculTextField = calcul;
        this.cells = new JTextArea[9][9];

        SheetController sheetController = new SheetController(this.cells, this.calculTextField);

        calcul.setPreferredSize(new Dimension(1000, 40));
        calcul.setFont(new Font("Arial", Font.BOLD, 15));
        calcul.addKeyListener(sheetController);

        JLabel calculLabel = new JLabel("Calcul : ");
        calculLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel calculPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        calculPanel.add(calculLabel);
        calculPanel.add(calcul);
        this.add(calculPanel, BorderLayout.NORTH);

        JPanel gridPanel = new JPanel(new GridLayout(9, 9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new JTextArea();
                cells[i][j].setEditable(false);
                cells[i][j].setFont(new Font("Arial", Font.BOLD, 15));
                cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cells[i][j].addMouseListener(sheetController);
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

        JPanel gridNumbersPanel = new JPanel(new BorderLayout());
        gridNumbersPanel.add(numbersPanel, BorderLayout.WEST);
        gridNumbersPanel.add(gridLettersPanel, BorderLayout.CENTER);

        this.add(gridNumbersPanel, BorderLayout.CENTER);

    }

    public JTextArea[][] getCells() {
        return this.cells;
    }

    public JTextField getCalculTextField() {
        return this.calculTextField;
    }

}
