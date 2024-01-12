package fr.iutfbleau.but2.sae322023;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class TestAdditionTreeNode {
    @Test(expected = IllegalArgumentException.class)
    public void singleChild() {
        List<TreeNode> childs = new ArrayList<>();
        childs.add(new NumberTreeNode(0));
        new AdditionTreeNode(childs);
    }

    @Test
    public void simpleAddition() throws IncalculableFormulaException {
        List<TreeNode> childs = new ArrayList<>();
        childs.add(new NumberTreeNode(1));
        childs.add(new NumberTreeNode(1));
        TreeNode node = new AdditionTreeNode(childs);
        assertEquals(node.evaluate(), 2, 0);
    }
}
