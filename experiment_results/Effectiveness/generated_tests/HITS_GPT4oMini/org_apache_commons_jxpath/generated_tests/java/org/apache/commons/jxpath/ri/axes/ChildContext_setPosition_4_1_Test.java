package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.EvalContext;

@ExtendWith(MockitoExtension.class)
public class ChildContext_setPosition_4_1_Test {

    private ChildContext childContext;

    private EvalContext parentContext;

    private NodeTest nodeTest;

    private NodeIterator mockIterator;

    private NodePointer mockNodePointer;

    @BeforeEach
    public void setUp() {
        parentContext = mock(EvalContext.class);
        nodeTest = mock(NodeTest.class);
        mockIterator = mock(NodeIterator.class);
        mockNodePointer = mock(NodePointer.class);
        childContext = new ChildContext(parentContext, nodeTest, false, false);
        // Mocking the behavior of parent context's current node pointer
        when(parentContext.getCurrentNodePointer()).thenReturn(mockNodePointer);
        when(mockNodePointer.childIterator(any(), anyBoolean(), any())).thenReturn(mockIterator);
    }

    @Test
    public void testSetPosition_WhenOldPositionIsZero_AndIteratorIsNull() {
        // Arrange
        when(childContext.getCurrentPosition()).thenReturn(0);
        when(mockIterator.setPosition(anyInt())).thenReturn(false);
        // Act
        boolean result = childContext.setPosition(1);
        // Assert
        assertFalse(result);
        verify(mockIterator, never()).setPosition(anyInt());
    }

    @Test
    public void testSetPosition_WhenOldPositionIsZero_AndIteratorIsNotNull() {
        // Arrange
        when(childContext.getCurrentPosition()).thenReturn(0);
        when(mockIterator.setPosition(1)).thenReturn(true);
        // Act
        boolean result = childContext.setPosition(1);
        // Assert
        assertTrue(result);
        verify(mockIterator).setPosition(1);
    }

    @Test
    public void testSetPosition_WhenOldPositionIsNotZero() {
        // Arrange
        when(childContext.getCurrentPosition()).thenReturn(1);
        when(mockIterator.setPosition(2)).thenReturn(true);
        // Act
        boolean result = childContext.setPosition(2);
        // Assert
        assertTrue(result);
        verify(mockIterator).setPosition(2);
    }

    @Test
    public void testSetPosition_WhenIteratorIsNull() {
        // Arrange
        when(childContext.getCurrentPosition()).thenReturn(0);
        when(mockNodePointer.childIterator(any(), anyBoolean(), any())).thenReturn(null);
        // Act
        boolean result = childContext.setPosition(1);
        // Assert
        assertFalse(result);
        verify(mockIterator, never()).setPosition(anyInt());
    }

    @Test
    public void testSetPosition_WhenIteratorSetPositionFails() {
        // Arrange
        when(childContext.getCurrentPosition()).thenReturn(0);
        when(mockIterator.setPosition(1)).thenReturn(false);
        // Act
        boolean result = childContext.setPosition(1);
        // Assert
        assertFalse(result);
        verify(mockIterator).setPosition(1);
    }
}
