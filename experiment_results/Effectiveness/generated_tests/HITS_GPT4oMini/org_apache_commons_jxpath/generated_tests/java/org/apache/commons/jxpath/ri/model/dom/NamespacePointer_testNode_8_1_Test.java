package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;

class NamespacePointer_testNode_8_1_Test {

    @Test
    void testNode_withNullNodeTest() {
        NamespacePointer namespacePointer = new NamespacePointer(null, "prefix");
        assertTrue(namespacePointer.testNode(null), "Expected testNode to return true for null NodeTest");
    }

    @Test
    void testNode_withNodeTypeTestMatching() {
        NamespacePointer namespacePointer = new NamespacePointer(null, "prefix");
        NodeTypeTest nodeTypeTest = new NodeTypeTest(Compiler.NODE_TYPE_NODE);
        assertTrue(namespacePointer.testNode(nodeTypeTest), "Expected testNode to return true for matching NodeTypeTest");
    }

    @Test
    void testNode_withNodeTypeTestNotMatching() {
        NamespacePointer namespacePointer = new NamespacePointer(null, "prefix");
        // Assuming 999 is not a matching node type
        NodeTypeTest nodeTypeTest = new NodeTypeTest(999);
        assertFalse(namespacePointer.testNode(nodeTypeTest), "Expected testNode to return false for non-matching NodeTypeTest");
    }
}
