import java.util.List;

/**
 * The <code>DivisionTreeNode</code> class represents a division node in the tree.
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class DivisionTreeNode extends TreeNode {
    /**
     * The childs of the node.
     */
    private List<TreeNode> childs;

    /**
     * Constructor of the class.
     * @param childs the childs of the node, must contain 2 childs.
     */
    public DivisionTreeNode(List<TreeNode> childs) {
        if (childs.size() != 2) {
            throw new IllegalArgumentException("DivisionTreeNode must have 2 childs.");
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
        if (this.getChilds().get(1).evaluate() == 0) {
            throw new IncalculableFormulaException("Division by zero.");
        }
        return this.getChilds().get(0).evaluate() / this.getChilds().get(1).evaluate();
    }
}
