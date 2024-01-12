package fr.iutfbleau.but2.sae322023;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestAdditionTreeNode.class,
    TestDivisionTreeNode.class,
    TestMultiplicationTreeNode.class,
    TestSubtractionTreeNode.class,
    TestWorksheet.class
})
public class AllTests {}
