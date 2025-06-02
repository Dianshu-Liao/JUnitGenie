package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.dom.NamespacePointer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ri_model_dom_NamespacePointer_testNode_NodeTest_cfg_path_3_Test {

    private static class MockNodeTypeTest extends NodeTypeTest {
        private int nodeType;

        public MockNodeTypeTest(int nodeType) {
            super(nodeType); // Call the constructor of NodeTypeTest with nodeType
            this.nodeType = nodeType;
        }

        @Override
        public int getNodeType() {
            return nodeType;
        }
    }

    @Test(timeout = 4000)
    public void testNode_WithNullNodeTest_ReturnsTrue() {
        NamespacePointer namespacePointer = new NamespacePointer(null, "namespaceUri");
        boolean result = namespacePointer.testNode(null);
        assertTrue("Expected true when NodeTest is null", result);
    }

    @Test(timeout = 4000)
    public void testNode_WithNonMatchingNodeType_ReturnsFalse() {
        NamespacePointer namespacePointer = new NamespacePointer(null, "namespaceUri");
        NodeTest nodeTest = new MockNodeTypeTest(2); // Non-matching nodeType
        boolean result = namespacePointer.testNode(nodeTest);
        assertFalse("Expected false when NodeTypeTest's nodeType is not 1", result);
    }

    @Test(timeout = 4000)
    public void testNode_WithMatchingNodeType_ReturnsTrue() {
        NamespacePointer namespacePointer = new NamespacePointer(null, "namespaceUri");
        NodeTest nodeTest = new MockNodeTypeTest(1); // Matching nodeType
        boolean result = namespacePointer.testNode(nodeTest);
        assertTrue("Expected true when NodeTypeTest's nodeType is 1", result);
    }

    @Test(timeout = 4000)
    public void testNode_WithInstanceOfNodeTypeTestAndNullNodeType_ReturnsFalse() {
        NamespacePointer namespacePointer = new NamespacePointer(null, "namespaceUri");
        NodeTest nodeTest = new MockNodeTypeTest(0); // Non-matching nodeType
        boolean result = namespacePointer.testNode(nodeTest);
        assertFalse("Expected false when NodeTypeTest's nodeType is 0", result);
    }


}