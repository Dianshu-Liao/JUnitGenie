package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AttributeContext_nextNode_3_2_Test {

    private AttributeContext attributeContext;

    private NodeTest nodeNameTest;

    private NodeTest nodeTypeTest;

    private NodeIterator mockIterator;

    private NodePointer mockNodePointer;

    private EvalContext mockEvalContext;

    @BeforeEach
    void setUp() {
        mockEvalContext = mock(EvalContext.class);
        nodeNameTest = mock(NodeTest.class);
        attributeContext = new AttributeContext(mockEvalContext, nodeNameTest);
        mockIterator = mock(NodeIterator.class);
        mockNodePointer = mock(NodePointer.class);
    }

    private void setPrivateField(String fieldName, Object value) throws Exception {
        Field field = AttributeContext.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(attributeContext, value);
    }

    @Test
    void testNextNodeWithNodeNameTest() throws Exception {
        QName qname = new QName(null, "testNode");
        nodeNameTest = new NodeNameTest(qname);
        setPrivateField("nodeTest", nodeNameTest);
        when(mockIterator.setPosition(1)).thenReturn(true);
        when(mockIterator.getNodePointer()).thenReturn(mockNodePointer);
        setPrivateField("iterator", mockIterator);
        assertTrue(attributeContext.nextNode());
        assertEquals(mockNodePointer, attributeContext.getCurrentNodePointer());
    }

    @Test
    void testNextNodeWithNodeTypeTest() throws Exception {
        nodeTypeTest = new NodeTypeTest(Compiler.NODE_TYPE_NODE);
        setPrivateField("nodeTest", nodeTypeTest);
        when(mockIterator.setPosition(1)).thenReturn(true);
        when(mockIterator.getNodePointer()).thenReturn(mockNodePointer);
        setPrivateField("iterator", mockIterator);
        assertTrue(attributeContext.nextNode());
        assertEquals(mockNodePointer, attributeContext.getCurrentNodePointer());
    }
}
