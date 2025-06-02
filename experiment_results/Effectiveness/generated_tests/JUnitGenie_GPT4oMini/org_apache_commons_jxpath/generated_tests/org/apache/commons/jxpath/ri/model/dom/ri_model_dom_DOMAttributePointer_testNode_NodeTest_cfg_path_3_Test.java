package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.dom.DOMAttributePointer;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_dom_DOMAttributePointer_testNode_NodeTest_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testNode_withNullNodeTest() {
        DOMAttributePointer pointer = new DOMAttributePointer(null, null);
        boolean result = pointer.testNode(null);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testNode_withNodeTypeTest_nodeTypeEqualsOne() {
        NodeTypeTest nodeTypeTest = new NodeTypeTestImpl(1); // Custom implementation where nodeType is 1
        DOMAttributePointer pointer = new DOMAttributePointer(null, null);
        boolean result = pointer.testNode(nodeTypeTest);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testNode_withNodeTypeTest_nodeTypeNotEqualsOne() {
        NodeTypeTest nodeTypeTest = new NodeTypeTestImpl(2); // Custom implementation where nodeType is 2
        DOMAttributePointer pointer = new DOMAttributePointer(null, null);
        boolean result = pointer.testNode(nodeTypeTest);
        assertFalse(result);
    }

    // Custom implementation of NodeTypeTest to satisfy the abstract class requirement
    private static class NodeTypeTestImpl extends NodeTypeTest {
        private final int nodeType;

        public NodeTypeTestImpl(int nodeType) {
            super(nodeType); // Call to the superclass constructor with nodeType
            this.nodeType = nodeType;
        }

        @Override
        public int getNodeType() {
            return nodeType;
        }
    }

}