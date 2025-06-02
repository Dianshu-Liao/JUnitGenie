package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.axes.DescendantContext;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Stack;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DescendantContext_isRecursive_5_0_Test {

    private DescendantContext descendantContext;

    private NodePointer mockNodePointer;

    private NodeIterator mockNodeIterator;

    private Stack<NodeIterator> mockStack;

    @BeforeEach
    void setUp() {
        NodeTest mockNodeTest = mock(NodeTest.class);
        EvalContext mockEvalContext = mock(EvalContext.class);
        descendantContext = new DescendantContext(mockEvalContext, true, mockNodeTest);
        mockNodePointer = mock(NodePointer.class);
        mockNodeIterator = mock(NodeIterator.class);
        mockStack = new Stack<>();
    }

    @Test
    void testIsRecursiveWhenNodeIsInStack() throws Exception {
        Object node = new Object();
        when(mockNodePointer.getNode()).thenReturn(node);
        when(mockNodeIterator.getNodePointer()).thenReturn(mockNodePointer);
        mockStack.push(mockNodeIterator);
        setStackAndCurrentNodePointer(descendantContext, mockStack, mockNodePointer);
        assertTrue(invokeIsRecursive(descendantContext));
    }

    @Test
    void testIsRecursiveWhenNodeIsNotInStack() throws Exception {
        Object node = new Object();
        when(mockNodePointer.getNode()).thenReturn(node);
        when(mockNodeIterator.getNodePointer()).thenReturn(mock(NodePointer.class));
        mockStack.push(mockNodeIterator);
        setStackAndCurrentNodePointer(descendantContext, mockStack, mockNodePointer);
        assertFalse(invokeIsRecursive(descendantContext));
    }

    @Test
    void testIsRecursiveWhenStackIsEmpty() throws Exception {
        setStackAndCurrentNodePointer(descendantContext, new Stack<>(), mockNodePointer);
        assertFalse(invokeIsRecursive(descendantContext));
    }

    private boolean invokeIsRecursive(DescendantContext context) throws Exception {
        Method method = DescendantContext.class.getDeclaredMethod("isRecursive");
        method.setAccessible(true);
        return (boolean) method.invoke(context);
    }

    private void setStackAndCurrentNodePointer(DescendantContext context, Stack<NodeIterator> stack, NodePointer currentNodePointer) throws Exception {
        Field stackField = DescendantContext.class.getDeclaredField("stack");
        stackField.setAccessible(true);
        stackField.set(context, stack);
        Field currentNodePointerField = DescendantContext.class.getDeclaredField("currentNodePointer");
        currentNodePointerField.setAccessible(true);
        currentNodePointerField.set(context, currentNodePointer);
    }
}
