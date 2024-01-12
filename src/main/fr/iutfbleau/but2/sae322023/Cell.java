package fr.iutfbleau.but2.sae322023;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * The <code>Cell</code> class represents a cell in a worksheet.
 * 
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
@SuppressWarnings("deprecation")
public class Cell extends Observable implements Observer {
    /**
     * The worksheet of the cell.
     */
    private Worksheet worksheet;

    /**
     * The location of the cell in the worksheet.
     */
    private String location;

    /**
     * The raw content of the cell.
     */
    private String rawContent;

    /**
     * The root node of the tree.
     */
    private TreeNode rootNode;

    /**
     * Boolean to determine whether the formula is correct.
     */
    private boolean formulaIsCorrect;

    /**
     * The dependencies of the cell.
     */
    private List<Cell> dependencies;

    /**
     * The view of the cell.
     */
    private CellView view;

    /**
     * Constructor of the class.
     * 
     * @param location the location of the cell in the worksheet.
     */
    public Cell(Worksheet worksheet, String location) {
        this.rawContent = "";
        this.location = location;
        this.worksheet = worksheet;
        this.rootNode = null;
        this.formulaIsCorrect = true;
        this.dependencies = new ArrayList<Cell>();
        this.view = null;
    }

    /**
     * Set the content of the cell.
     * 
     * @param rawContent the content of the cell.
     */
    public void setRawContent(String rawContent) {
        if (rawContent.equals(this.rawContent)) return;
        this.rawContent = rawContent;


        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if (this.rootNode != null) {
            nodes.add(this.rootNode);
            nodes.addAll(this.rootNode.getChilds());
            for (TreeNode node : nodes) {
                if (node instanceof ReferenceTreeNode) this.deleteObserver(((ReferenceTreeNode) node).getCell());
            }
        }

        try {
            this.rootNode = FormulaParser.parse(this.getWorksheet(), rawContent);
            this.formulaIsCorrect = true;

            this.setChanged();
            this.notifyObservers();

            this.dependencies.clear();

            nodes.clear();
            nodes.add(this.rootNode);
            nodes.addAll(this.rootNode.getChilds());

            for (TreeNode node : nodes) {
                if (node instanceof ReferenceTreeNode) {
                    Cell refCell = ((ReferenceTreeNode) node).getCell();
                    this.dependencies.add(refCell);
                    refCell.addObserver(this);
                }
            }
        } catch (IncorrectFormulaException e) {
            this.rootNode = null;
            this.formulaIsCorrect = false;
        }
    }

    /**
     * Check if the cell depends on another cell.
     * 
     * @param cell the cell to check.
     * @return true if the cell depends on the other cell, false otherwise.
     */
    public boolean dependsOn(Cell cell) {
        if (this.dependencies.contains(cell))
            return true;
        if (this != cell) {
            if (this.dependsOn(this))
                return true;
        }

        for (Cell dependency : this.dependencies) {
            if (dependency.dependsOn(cell))
                return true;
        }

        return false;
    }

    /**
     * Get the worksheet of the cell.
     * 
     * @return the worksheet of the cell.
     */
    public Worksheet getWorksheet() {
        return this.worksheet;
    }

    /**
     * Get the cell displayed value.
     * 
     * @return the cell displayed value.
     */
    public String evaluate() {
        if (this.rawContent.isBlank())
            return "";
        if (this.dependsOn(this))
            return "#CREF!";
        try {
            return String.valueOf(this.toDouble());
        } catch (IncalculableFormulaException e) {
            return "#CALC!";
        } catch (IncorrectFormulaException e) {
            return "#FORM!";
        }
    }

    /**
     * Get the content of the cell as a String.
     * 
     * @return the content of the cell.
     */
    @Override
    public String toString() {
        return this.rawContent;
    }

    /**
     * Get the content of the cell as a double.
     * 
     * @return the content of the cell.
     * @throws IncalculableFormulaException if the formula is incalculable.
     * @throws IncorrectFormulaException    if the formula is incorrect.
     */
    public double toDouble() throws IncalculableFormulaException, IncorrectFormulaException {
        if (!this.formulaIsCorrect) {
            throw new IncorrectFormulaException("The formula of the " + this.location + " is incorrect.");
        }

        if (this.dependsOn(this))
            throw new IncalculableFormulaException("Circular reference detected");

        if (this.rootNode == null)
            return 0.0;

        return rootNode.evaluate();
    }

    /**
     * Set the view of the cell.
     * 
     * @param view the view of the cell.
     */
    public void setView(CellView view) {
        this.view = view;
    }

    /**
     * Method called whenever a dependency's formula is changed.
     *
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers} method.
     */
    @Override
    public void update(Observable o, Object arg) {
        this.view.update();
    }
}