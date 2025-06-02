package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.compiler.NodeTest;

class AttributeContext_nextNode_3_0_Test {

    private EvalContext parentContext;

    private NodeTest nodeNameTest;

    private NodeTest nodeTypeTest;

    private NodeIterator mockIterator;

    private NodePointer mockNodePointer;

    private AttributeContext attributeContext;

    @BeforeEach
    void setUp() {
        parentContext = mock(EvalContext.class);
        mockNodePointer = mock(NodePointer.class);
        mockIterator = mock(NodeIterator.class);
        when(parentContext.getCurrentNodePointer()).thenReturn(mockNodePointer);
        attributeContext = new AttributeContext(parentContext, nodeNameTest);
    }

    @Test
    void testNextNodeWithNodeNameTest() throws Exception {
        QName qName = new QName("test");
        nodeNameTest = new NodeNameTest(qName);
        setNodeTest(attributeContext, nodeNameTest);
        when(mockNodePointer.attributeIterator(qName)).thenReturn(mockIterator);
        when(mockIterator.setPosition(1)).thenReturn(true);
        when(mockIterator.getNodePointer()).thenReturn(mockNodePointer);
        assertTrue(invokeNextNode(attributeContext));
        assertEquals(mockNodePointer, attributeContext.getCurrentNodePointer());
    }

    @Test
    void testNextNodeWithNodeTypeTest() throws Exception {
        nodeTypeTest = new NodeTypeTest(Compiler.NODE_TYPE_NODE);
        setNodeTest(attributeContext, nodeTypeTest);
        when(mockNodePointer.attributeIterator(any(QName.class))).thenReturn(mockIterator);
        when(mockIterator.setPosition(1)).thenReturn(true);
        when(mockIterator.getNodePointer()).thenReturn(mockNodePointer);
        assertTrue(invokeNextNode(attributeContext));
        assertEquals(mockNodePointer, attributeContext.getCurrentNodePointer());
    }

    @Test
    void testNextNodeWithNoAttributes() throws Exception {
        QName qName = new QName("test");
        nodeNameTest = new NodeNameTest(qName);
        setNodeTest(attributeContext, nodeNameTest);
        when(mockNodePointer.attributeIterator(qName)).thenReturn(mockIterator);
        when(mockIterator.setPosition(1)).thenReturn(false);
        assertFalse(invokeNextNode(attributeContext));
        assertNull(attributeContext.getCurrentNodePointer());
    }

    @Test
    void testNextNodeWithInvalidNodeTest() throws Exception {
        NodeTest invalidNodeTest = mock(NodeTest.class);
        setNodeTest(attributeContext, invalidNodeTest);
        assertFalse(invokeNextNode(attributeContext));
        assertNull(attributeContext.getCurrentNodePointer());
    }

    private void setNodeTest(AttributeContext context, NodeTest nodeTest) throws Exception {
        Field field = AttributeContext.class.getDeclaredField("nodeTest");
        field.setAccessible(true);
        field.set(context, nodeTest);
    }

    private boolean invokeNextNode(AttributeContext context) throws Exception {
        Method method = AttributeContext.class.getDeclaredMethod("nextNode");
        method.setAccessible(true);
        return (boolean) method.invoke(context);
    }
}
