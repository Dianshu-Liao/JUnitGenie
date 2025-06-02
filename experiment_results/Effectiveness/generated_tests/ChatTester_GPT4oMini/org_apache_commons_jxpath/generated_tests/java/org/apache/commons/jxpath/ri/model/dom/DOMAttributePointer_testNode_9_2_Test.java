package org.apache.commons.jxpath.ri.model.dom;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.w3c.dom.Attr;

class DOMAttributePointer_testNode_9_2_Test {

    private DOMAttributePointer domAttributePointer;

    private NodePointer mockParent;

    private Attr mockAttr;

    @BeforeEach
    void setUp() {
        mockParent = Mockito.mock(NodePointer.class);
        mockAttr = Mockito.mock(Attr.class);
        domAttributePointer = new DOMAttributePointer(mockParent, mockAttr);
    }

    @Test
    void testNode_NullNodeTest_ReturnsTrue() {
        assertTrue(domAttributePointer.testNode(null));
    }

    @Test
    void testNode_NodeTypeTestWithCorrectNodeType_ReturnsTrue() {
        NodeTypeTest mockNodeTypeTest = Mockito.mock(NodeTypeTest.class);
        Mockito.when(mockNodeTypeTest.getNodeType()).thenReturn(Compiler.NODE_TYPE_NODE);
        assertTrue(domAttributePointer.testNode(mockNodeTypeTest));
    }

    @Test
    void testNode_NodeTypeTestWithIncorrectNodeType_ReturnsFalse() {
        NodeTypeTest mockNodeTypeTest = Mockito.mock(NodeTypeTest.class);
        // Some invalid node type
        Mockito.when(mockNodeTypeTest.getNodeType()).thenReturn(999);
        assertFalse(domAttributePointer.testNode(mockNodeTypeTest));
    }

    @Test
    void testNode_OtherNodeTestType_ReturnsFalse() {
        NodeTest mockOtherNodeTest = Mockito.mock(NodeTest.class);
        assertFalse(domAttributePointer.testNode(mockOtherNodeTest));
    }

    @Test
    void testNode_NodeTypeTestWithNullNodeType_ReturnsFalse() {
        NodeTypeTest mockNodeTypeTest = Mockito.mock(NodeTypeTest.class);
        // Simulate null node type
        Mockito.when(mockNodeTypeTest.getNodeType()).thenReturn(null);
        assertFalse(domAttributePointer.testNode(mockNodeTypeTest));
    }
}
