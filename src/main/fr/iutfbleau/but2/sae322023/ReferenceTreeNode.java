package fr.iutfbleau.but2.sae322023;

import java.util.ArrayList;
import java.util.List;

/**
 * The <code>ReferenceTreeNode</code> class represents a Number node in the tree.
 * 
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class ReferenceTreeNode extends TreeNode {
    /**
     * The value of the node.
     */
    private Cell cell;

    /**
     * Constructor of the class.
     * @param cell the value of the node.
     */
    public ReferenceTreeNode(Cell cell) {
        this.cell = cell;
    }

    /**
     * Get the child(s) of the node.
     * @return a list of child(s).
     */
    @Override
    public List<TreeNode> getChilds() {
        return new ArrayList<TreeNode>();
    }

    /**
     * Get the cell of the node.
     * @return the cell of the node.
     */
    public Cell getCell() {
        return this.cell;
    }

    /**
     * Evaluate the node.
     * @return the result of the evaluation.
     * @throws IncalculableFormulaException if the formula is incalculable.
     */
    @Override
    public double evaluate() throws IncalculableFormulaException {
        double result;
        try {
            result = this.cell.toDouble();
        } catch (IncorrectFormulaException e) {
            throw new IncalculableFormulaException(e.toString());
        }

        return result;
    }
}
