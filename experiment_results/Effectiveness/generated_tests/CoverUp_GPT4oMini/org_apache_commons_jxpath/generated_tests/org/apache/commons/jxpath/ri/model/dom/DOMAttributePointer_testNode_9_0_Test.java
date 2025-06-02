package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.w3c.dom.Attr;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.util.TypeUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DOMAttributePointer_testNode_9_0_Test {

    private DOMAttributePointer domAttributePointer;

    private Attr mockAttr;

    private NodePointer mockParent;

    @BeforeEach
    void setUp() {
        mockAttr = Mockito.mock(Attr.class);
        mockParent = Mockito.mock(NodePointer.class);
        domAttributePointer = new DOMAttributePointer(mockParent, mockAttr);
    }

    @Test
    void testNode_NullNodeTest_ReturnsTrue() {
        assertTrue(domAttributePointer.testNode(null));
    }

    @Test
    void testNode_NodeTypeTestWithNodeTypeNode_ReturnsTrue() {
        NodeTest nodeTest = new NodeTypeTest(Compiler.NODE_TYPE_NODE);
        assertTrue(domAttributePointer.testNode(nodeTest));
    }

    @Test
    void testNode_NodeTypeTestWithDifferentNodeType_ReturnsFalse() {
        // Using an arbitrary node type
        NodeTest nodeTest = new NodeTypeTest(999);
        assertFalse(domAttributePointer.testNode(nodeTest));
    }

    @Test
    void testNode_AnotherTypeOfNodeTest_ReturnsFalse() {
        // Mocking another NodeTest
        NodeTest nodeTest = Mockito.mock(NodeTest.class);
        assertFalse(domAttributePointer.testNode(nodeTest));
    }

    @Test
    void testNode_ValidNodeTypeTest_ReturnsTrue() {
        NodeTest nodeTest = new NodeTypeTest(Compiler.NODE_TYPE_NODE);
        assertTrue(domAttributePointer.testNode(nodeTest));
    }

    @Test
    void testNode_InvalidNodeTypeTest_ReturnsFalse() {
        // Assuming this is a different type
        // Use a number other than NODE_TYPE_NODE
        NodeTest nodeTest = new NodeTypeTest(Compiler.NODE_TYPE_NODE + 1);
        assertFalse(domAttributePointer.testNode(nodeTest));
    }

    // Reflection test for private methods if needed (not applicable in this case)
    private Object invokePrivateMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = DOMAttributePointer.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(domAttributePointer, args);
    }
}
