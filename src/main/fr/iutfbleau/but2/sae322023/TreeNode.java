package fr.iutfbleau.but2.sae322023;

import java.util.List;

/**
 * The <code>TreeNode</code> abstract class represents a node in the tree.
 * 
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public abstract class TreeNode {
    /**
     * Check if the node has child(s).
     * @return true if the node has child(s).
     */
    public boolean hasChild() {
        return !this.getChilds().isEmpty();
    }

    /**
     * Get the child(s) of the node.
     * @return a list of child(s).
     */
    public abstract List<TreeNode> getChilds();

    /**
     * Evaluate the node.
     * @return the result of the evaluation.
     * @throws IncalculableFormulaException if the formula is incalculable.
     */
    public abstract double evaluate() throws IncalculableFormulaException;
}
