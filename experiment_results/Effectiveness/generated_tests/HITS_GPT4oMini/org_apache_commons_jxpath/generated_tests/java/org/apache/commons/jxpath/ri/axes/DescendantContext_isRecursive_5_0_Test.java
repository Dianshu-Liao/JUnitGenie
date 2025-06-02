package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.EvalContext;
import java.util.Stack;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;

@ExtendWith(MockitoExtension.class)
class DescendantContext_isRecursive_5_0_Test {

    private DescendantContext descendantContext;

    private NodePointer mockNodePointer;

    private NodeIterator mockNodeIterator;

    private Stack<NodeIterator> mockStack;

    @BeforeEach
    void setUp() {
        mockNodePointer = mock(NodePointer.class);
        mockNodeIterator = mock(NodeIterator.class);
        mockStack = new Stack<>();
        EvalContext mockEvalContext = mock(EvalContext.class);
        descendantContext = new DescendantContext(mockEvalContext, true, mock(NodeTest.class));
        setField(descendantContext, "currentNodePointer", mockNodePointer);
        setField(descendantContext, "stack", mockStack);
    }

    private void setField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean invokeIsRecursive() {
        try {
            Method method = DescendantContext.class.getDeclaredMethod("isRecursive");
            method.setAccessible(true);
            return (boolean) method.invoke(descendantContext);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testIsRecursive_WhenNodeIsInStack_ReturnsTrue() {
        // Arrange
        Object node = new Object();
        when(mockNodePointer.getNode()).thenReturn(node);
        when(mockNodeIterator.getNodePointer()).thenReturn(mockNodePointer);
        mockStack.push(mockNodeIterator);
        // Act
        boolean result = invokeIsRecursive();
        // Assert
        assertTrue(result);
    }

    @Test
    void testIsRecursive_WhenNodeIsNotInStack_ReturnsFalse() {
        // Arrange
        Object node = new Object();
        when(mockNodePointer.getNode()).thenReturn(node);
        when(mockNodeIterator.getNodePointer()).thenReturn(mock(NodePointer.class));
        mockStack.push(mockNodeIterator);
        // Act
        boolean result = invokeIsRecursive();
        // Assert
        assertFalse(result);
    }
}
