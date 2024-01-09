import java.util.ArrayList;
import java.util.List;

/**
 * The <code>NumberTreeNode</code> class represents a Number node in the tree.
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class NumberTreeNode extends TreeNode {
    /**
     * The value of the node.
     */
    private double value;

    /**
     * Constructor of the class.
     * @param value the value of the node.
     */
    public NumberTreeNode(double value) {
        this.value = value;
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
     * Evaluate the node.
     * @return the result of the evaluation.
     * @throws IncalculableFormulaException if the formula is incalculable.
     */
    @Override
    public double evaluate() throws IncalculableFormulaException {
        return this.value;
    }
}
