package fr.iutfbleau.but2.sae322023;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class TestMultiplicationTreeNode {
    @Test(expected = IllegalArgumentException.class)
    public void singleChild() {
        List<TreeNode> childs = new ArrayList<>();
        childs.add(new NumberTreeNode(0));
        new MultiplicationTreeNode(childs);
    }

    @Test
    public void simpleMultiplication() throws IncalculableFormulaException {
        List<TreeNode> childs = new ArrayList<>();
        childs.add(new NumberTreeNode(2));
        childs.add(new NumberTreeNode(2));
        TreeNode node = new MultiplicationTreeNode(childs);
        assertEquals(node.evaluate(), 4, 0);
    }
}
