package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.axes.ChildContext;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.EvalContext;

class ChildContext_setPosition_4_1_Test {

    private ChildContext childContext;

    private EvalContext parentContext;

    private NodeTest nodeTest;

    private NodeIterator mockIterator;

    @BeforeEach
    void setUp() {
        parentContext = mock(EvalContext.class);
        nodeTest = mock(NodeTest.class);
        mockIterator = mock(NodeIterator.class);
        childContext = new ChildContext(parentContext, nodeTest, false, false);
    }

    @Test
    void testSetPositionWhenOldPositionIsZeroAndIteratorIsNotNull() {
        // Arrange
        when(childContext.getCurrentPosition()).thenReturn(0);
        when(mockIterator.setPosition(1)).thenReturn(true);
        invokeSetIterator(childContext, mockIterator);
        // Act
        boolean result = childContext.setPosition(1);
        // Assert
        assertTrue(result);
        verify(mockIterator).setPosition(1);
    }

    @Test
    void testSetPositionWhenOldPositionIsZeroAndIteratorIsNull() {
        // Arrange
        when(childContext.getCurrentPosition()).thenReturn(0);
        invokeSetIterator(childContext, null);
        // Act
        boolean result = childContext.setPosition(1);
        // Assert
        assertFalse(result);
    }

    @Test
    void testSetPositionWhenOldPositionIsNotZero() {
        // Arrange
        when(childContext.getCurrentPosition()).thenReturn(1);
        when(mockIterator.setPosition(2)).thenReturn(true);
        invokeSetIterator(childContext, mockIterator);
        // Act
        boolean result = childContext.setPosition(2);
        // Assert
        assertTrue(result);
        verify(mockIterator).setPosition(2);
    }

    @Test
    void testSetPositionWhenIteratorSetPositionFails() {
        // Arrange
        when(childContext.getCurrentPosition()).thenReturn(0);
        when(mockIterator.setPosition(1)).thenReturn(false);
        invokeSetIterator(childContext, mockIterator);
        // Act
        boolean result = childContext.setPosition(1);
        // Assert
        assertFalse(result);
        verify(mockIterator).setPosition(1);
    }

    private void invokeSetIterator(ChildContext context, NodeIterator iterator) {
        try {
            java.lang.reflect.Field field = ChildContext.class.getDeclaredField("iterator");
            field.setAccessible(true);
            field.set(context, iterator);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set iterator field: " + e.getMessage());
        }
    }
}
