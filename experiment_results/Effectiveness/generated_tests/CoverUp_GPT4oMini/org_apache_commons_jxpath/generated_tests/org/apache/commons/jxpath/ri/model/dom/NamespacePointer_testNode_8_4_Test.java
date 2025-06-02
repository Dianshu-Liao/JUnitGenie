package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class NamespacePointer_testNode_8_4_Test {

    private NamespacePointer namespacePointer;

    private NodePointer parent;

    @BeforeEach
    public void setUp() {
        parent = mock(NodePointer.class);
        namespacePointer = new NamespacePointer(parent, "prefix");
    }

    @Test
    public void testNode_NullNodeTest_ReturnsTrue() {
        // Arrange
        NodeTest nodeTest = null;
        // Act
        boolean result = invokeTestNode(namespacePointer, nodeTest);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testNode_NodeTypeTestWithNodeTypeNode_ReturnsTrue() {
        // Arrange
        NodeTest nodeTest = new NodeTypeTest(Compiler.NODE_TYPE_NODE);
        // Act
        boolean result = invokeTestNode(namespacePointer, nodeTest);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testNode_NodeTypeTestWithDifferentNodeType_ReturnsFalse() {
        // Arrange
        // Use a node type that is not NODE_TYPE_NODE
        NodeTest nodeTest = new NodeTypeTest(999);
        // Act
        boolean result = invokeTestNode(namespacePointer, nodeTest);
        // Assert
        assertFalse(result);
    }

    private boolean invokeTestNode(NamespacePointer namespacePointer, NodeTest nodeTest) {
        try {
            Method method = NamespacePointer.class.getDeclaredMethod("testNode", NodeTest.class);
            method.setAccessible(true);
            return (boolean) method.invoke(namespacePointer, nodeTest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
