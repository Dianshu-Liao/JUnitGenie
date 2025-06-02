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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AttributeContext_nextNode_3_0_Test {

    private AttributeContext attributeContext;

    private NodePointer mockNodePointer;

    private NodeIterator mockNodeIterator;

    private NodeNameTest mockNodeNameTest;

    private NodeTypeTest mockNodeTypeTest;

    private EvalContext mockEvalContext;

    @BeforeEach
    void setUp() {
        mockEvalContext = mock(EvalContext.class);
        mockNodePointer = mock(NodePointer.class);
        mockNodeNameTest = mock(NodeNameTest.class);
        mockNodeTypeTest = mock(NodeTypeTest.class);
        mockNodeIterator = mock(NodeIterator.class);
    }

    @Test
    void testNextNode_WithNodeNameTest_InitialCall() {
        QName qName = new QName("test");
        when(mockNodeNameTest.getNodeName()).thenReturn(qName);
        when(mockNodePointer.attributeIterator(qName)).thenReturn(mockNodeIterator);
        when(mockNodeIterator.setPosition(1)).thenReturn(true);
        when(mockNodeIterator.getNodePointer()).thenReturn(mockNodePointer);
        attributeContext = new AttributeContext(mockEvalContext, mockNodeNameTest);
        boolean result = attributeContext.nextNode();
        assertTrue(result);
        verify(mockNodeIterator).setPosition(1);
        // Instead of accessing currentNodePointer directly, we can validate behavior through other means
        // For example, we can check if the iterator is set correctly or if the expected nodePointer is returned.
    }

    @Test
    void testNextNode_WithNodeTypeTest_InitialCall() {
        when(mockNodeTypeTest.getNodeType()).thenReturn(Compiler.NODE_TYPE_NODE);
        attributeContext = new AttributeContext(mockEvalContext, mockNodeTypeTest);
        when(mockNodePointer.attributeIterator(any(QName.class))).thenReturn(mockNodeIterator);
        when(mockNodeIterator.setPosition(1)).thenReturn(true);
        when(mockNodeIterator.getNodePointer()).thenReturn(mockNodePointer);
        boolean result = attributeContext.nextNode();
        assertTrue(result);
        verify(mockNodeIterator).setPosition(1);
        // Again, we validate behavior without accessing currentNodePointer directly
    }
}
