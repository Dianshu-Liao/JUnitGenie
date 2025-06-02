package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.w3c.dom.Attr;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.util.TypeUtils;

public class DOMAttributePointer_testNode_9_0_Test {

    @Test
    public void testNode_WithNullNodeTest_ShouldReturnTrue() {
        NodePointer mockNodePointer = Mockito.mock(NodePointer.class);
        Attr mockAttr = Mockito.mock(Attr.class);
        DOMAttributePointer domAttributePointer = new DOMAttributePointer(mockNodePointer, mockAttr);
        boolean result = domAttributePointer.testNode(null);
        assertTrue(result, "Expected testNode to return true when nodeTest is null");
    }

    @Test
    public void testNode_WithNodeTypeTestMatchingNodeType_ShouldReturnTrue() {
        NodePointer mockNodePointer = Mockito.mock(NodePointer.class);
        Attr mockAttr = Mockito.mock(Attr.class);
        DOMAttributePointer domAttributePointer = new DOMAttributePointer(mockNodePointer, mockAttr);
        NodeTypeTest nodeTypeTest = new NodeTypeTest(Compiler.NODE_TYPE_NODE);
        boolean result = domAttributePointer.testNode(nodeTypeTest);
        assertTrue(result, "Expected testNode to return true when nodeTest is NodeTypeTest with matching node type");
    }

    @Test
    public void testNode_WithNodeTypeTestNonMatchingNodeType_ShouldReturnFalse() {
        NodePointer mockNodePointer = Mockito.mock(NodePointer.class);
        Attr mockAttr = Mockito.mock(Attr.class);
        DOMAttributePointer domAttributePointer = new DOMAttributePointer(mockNodePointer, mockAttr);
        NodeTypeTest nodeTypeTest = new NodeTypeTest(Compiler.NODE_TYPE_NODE + 1);
        boolean result = domAttributePointer.testNode(nodeTypeTest);
        assertFalse(result, "Expected testNode to return false when nodeTest is NodeTypeTest with non-matching node type");
    }
}
