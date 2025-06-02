package org.apache.commons.jxpath.ri.model.dom;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NamespacePointer_testNode_8_0_Test {

    private NamespacePointer namespacePointer;

    private NodePointer parent;

    private NodeTest nodeTest;

    @BeforeEach
    public void setUp() {
        parent = Mockito.mock(NodePointer.class);
        namespacePointer = new NamespacePointer(parent, "prefix");
    }

    @Test
    public void testNode_NullNodeTest_ReturnsTrue() {
        // Arrange
        nodeTest = null;
        // Act
        boolean result = namespacePointer.testNode(nodeTest);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testNode_NodeTypeTestWithCorrectNodeType_ReturnsTrue() {
        // Arrange
        nodeTest = Mockito.mock(NodeTypeTest.class);
        Mockito.when(((NodeTypeTest) nodeTest).getNodeType()).thenReturn(Compiler.NODE_TYPE_NODE);
        // Act
        boolean result = namespacePointer.testNode(nodeTest);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testNode_NodeTypeTestWithIncorrectNodeType_ReturnsFalse() {
        // Arrange
        nodeTest = Mockito.mock(NodeTypeTest.class);
        // Fixed line
        Mockito.when(((NodeTypeTest) nodeTest).getNodeType()).thenReturn(Compiler.NODE_TYPE_TEXT);
        // Act
        boolean result = namespacePointer.testNode(nodeTest);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testNode_OtherNodeTest_ReturnsFalse() {
        // Arrange
        nodeTest = Mockito.mock(NodeTest.class);
        // Act
        boolean result = namespacePointer.testNode(nodeTest);
        // Assert
        assertFalse(result);
    }
}
