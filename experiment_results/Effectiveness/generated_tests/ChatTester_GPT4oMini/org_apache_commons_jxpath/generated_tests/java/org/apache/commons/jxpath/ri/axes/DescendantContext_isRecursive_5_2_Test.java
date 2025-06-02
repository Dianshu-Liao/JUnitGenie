package org.apache.commons.jxpath.ri.axes;

import java.lang.reflect.Method;
import java.util.Stack;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DescendantContext_isRecursive_5_2_Test {

    private DescendantContext descendantContext;

    private NodePointer mockNodePointer;

    private Stack<NodeIterator> mockStack;

    @BeforeEach
    public void setUp() {
        NodeTest mockNodeTest = Mockito.mock(NodeTest.class);
        EvalContext mockEvalContext = Mockito.mock(EvalContext.class);
        descendantContext = new DescendantContext(mockEvalContext, true, mockNodeTest);
        mockNodePointer = Mockito.mock(NodePointer.class);
        mockStack = new Stack<>();
        // Set up the stack with mock NodeIterators
        NodeIterator mockIterator = Mockito.mock(NodeIterator.class);
        Mockito.when(mockIterator.getNodePointer()).thenReturn(mockNodePointer);
        mockStack.push(mockIterator);
    }

    @Test
    public void testIsRecursiveReturnsTrue() throws Exception {
        // Arrange
        Object node = new Object();
        Mockito.when(mockNodePointer.getNode()).thenReturn(node);
        NodeIterator mockIterator = Mockito.mock(NodeIterator.class);
        // Corrected line
        NodePointer mockPointer = Mockito.mock(NodePointer.class);
        Mockito.when(mockPointer.getNode()).thenReturn(node);
        Mockito.when(mockIterator.getNodePointer()).thenReturn(mockPointer);
        mockStack.push(mockIterator);
        setStack(mockStack);
        // Act
        boolean result = invokeIsRecursive();
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsRecursiveReturnsFalse() throws Exception {
        // Arrange
        Object node = new Object();
        Mockito.when(mockNodePointer.getNode()).thenReturn(node);
        NodeIterator mockIterator = Mockito.mock(NodeIterator.class);
        // Corrected line
        NodePointer mockPointer = Mockito.mock(NodePointer.class);
        Mockito.when(mockPointer.getNode()).thenReturn(new Object());
        Mockito.when(mockIterator.getNodePointer()).thenReturn(mockPointer);
        mockStack.push(mockIterator);
        setStack(mockStack);
        // Act
        boolean result = invokeIsRecursive();
        // Assert
        assertFalse(result);
    }

    private void setStack(Stack<NodeIterator> stack) {
        try {
            java.lang.reflect.Field stackField = DescendantContext.class.getDeclaredField("stack");
            stackField.setAccessible(true);
            stackField.set(descendantContext, stack);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean invokeIsRecursive() throws Exception {
        Method isRecursiveMethod = DescendantContext.class.getDeclaredMethod("isRecursive");
        isRecursiveMethod.setAccessible(true);
        return (boolean) isRecursiveMethod.invoke(descendantContext);
    }
}
