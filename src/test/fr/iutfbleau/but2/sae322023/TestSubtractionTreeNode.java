package fr.iutfbleau.but2.sae322023;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class TestSubtractionTreeNode {
    @Test(expected = IllegalArgumentException.class)
    public void singleChild() {
        List<TreeNode> childs = new ArrayList<>();
        childs.add(new NumberTreeNode(0));
        new SubtractionTreeNode(childs);
    }

    @Test
    public void simpleSubtraction() throws IncalculableFormulaException {
        List<TreeNode> childs = new ArrayList<>();
        childs.add(new NumberTreeNode(1));
        childs.add(new NumberTreeNode(1));
        TreeNode node = new SubtractionTreeNode(childs);
        assertEquals(node.evaluate(), 0, 0);
    }
}
