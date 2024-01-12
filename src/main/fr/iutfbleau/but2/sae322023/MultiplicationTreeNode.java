package fr.iutfbleau.but2.sae322023;

import java.util.List;

/**
 * The <code>MultiplicationTreeNode</code> class represents a multiplication node in the tree.
 * 
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class MultiplicationTreeNode extends TreeNode {
    /**
     * The childs of the node.
     */
    private List<TreeNode> childs;

    /**
     * Constructor of the class.
     * @param childs the childs of the node, must contain 2 childs.
     */
    public MultiplicationTreeNode(List<TreeNode> childs) {
        if (childs.size() != 2) {
            throw new IllegalArgumentException("MultiplicationTreeNode must have 2 childs.");
        }
        this.childs = childs;
    }

    /**
     * Get the child(s) of the node.
     * @return a list of child(s).
     */
    @Override
    public List<TreeNode> getChilds() {
        return childs;
    }

    /**
     * Evaluate the node.
     * @return the result of the evaluation.
     * @throws IncalculableFormulaException if the formula is incalculable.
     */
    @Override
    public double evaluate() throws IncalculableFormulaException {
        return this.getChilds().get(0).evaluate() * this.getChilds().get(1).evaluate();
    }
}
