import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * The <code>FormulaParser</code> class is used to parse the content of a cell.
 * @version 1.0
 * @author Tom Moguljak
 * @author Hugo Dimitrijevic
 * @author Lyanis Souidi
 */
public class FormulaParser {
    public static TreeNode parse(Cell currentCell, String formula) throws IncorrectFormulaException {
        if (formula.isBlank()) return new NumberTreeNode(0);

        String[] splitedFormula = formula.split("\\s+");
        Stack<String> stackSplitedFormula = new Stack<String>();
        for (String s : splitedFormula) {
            stackSplitedFormula.push(s);
        }

        Stack<TreeNode> stackTreeNodes = new Stack<TreeNode>();

        while (!stackSplitedFormula.isEmpty()) {
            String s = stackSplitedFormula.pop();
            if (s.equals("+")) {
                List<TreeNode> childs = new ArrayList<TreeNode>();
                try {
                    childs.add(stackTreeNodes.pop());
                    childs.add(stackTreeNodes.pop());
                } catch (EmptyStackException e) {
                    throw new IncorrectFormulaException("Incorrect formula");
                }

                stackTreeNodes.push(new AdditionTreeNode(childs));
            } else if (s.equals("-")) {
                List<TreeNode> childs = new ArrayList<TreeNode>();
                try {
                    childs.add(stackTreeNodes.pop());
                    childs.add(stackTreeNodes.pop());
                } catch (EmptyStackException e) {
                    throw new IncorrectFormulaException("Incorrect formula");
                }

                stackTreeNodes.push(new SubtractionTreeNode(childs));
            } else if (s.equals("*")) {
                List<TreeNode> childs = new ArrayList<TreeNode>();
                try {
                    childs.add(stackTreeNodes.pop());
                    childs.add(stackTreeNodes.pop());
                } catch (EmptyStackException e) {
                    throw new IncorrectFormulaException("Incorrect formula");
                }

                stackTreeNodes.push(new MultiplicationTreeNode(childs));
            } else if (s.equals("/")) {
                List<TreeNode> childs = new ArrayList<TreeNode>();
                try {
                    childs.add(stackTreeNodes.pop());
                    childs.add(stackTreeNodes.pop());
                } catch (EmptyStackException e) {
                    throw new IncorrectFormulaException("Incorrect formula");
                }

                stackTreeNodes.push(new DivisionTreeNode(childs));
            } else if (s.matches("^[A-I][1-9]$")) {
                try {
                    stackTreeNodes.push(new ReferenceTreeNode(currentCell.getWorksheet().get(s)));
                } catch (IllegalArgumentException e) {
                    throw new IncorrectFormulaException("Incorrect formula: " + e.toString());
                }
            } else {
                try {
                    stackTreeNodes.push(new NumberTreeNode(Double.parseDouble(s)));
                } catch (NumberFormatException e) {
                    throw new IncorrectFormulaException("Incorrect formula: " + e.toString());
                }
            }
        }

        if (stackTreeNodes.size() != 1) throw new IncorrectFormulaException("Incorrect formula");

        return stackTreeNodes.pop();
    }
}
