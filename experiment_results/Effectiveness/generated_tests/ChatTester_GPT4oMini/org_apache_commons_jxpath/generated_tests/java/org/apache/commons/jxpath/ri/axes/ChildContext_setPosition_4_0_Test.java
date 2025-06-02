package org.apache.commons.jxpath.ri.axes;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;

class ChildContext_setPosition_4_0_Test {

    private ChildContext childContext;

    private NodeTest mockNodeTest;

    private NodeIterator mockIterator;

    @BeforeEach
    void setUp() {
        mockNodeTest = mock(NodeTest.class);
        mockIterator = mock(NodeIterator.class);
        childContext = new ChildContext(mock(EvalContext.class), mockNodeTest, true, false);
        // Use reflection to set the private iterator field
        try {
            java.lang.reflect.Field iteratorField = ChildContext.class.getDeclaredField("iterator");
            iteratorField.setAccessible(true);
            iteratorField.set(childContext, mockIterator);
        } catch (Exception e) {
            fail("Failed to set up ChildContext: " + e.getMessage());
        }
    }

    @Test
    void testSetPositionWhenOldPositionIsZero() {
        // Arrange
        when(mockIterator.setPosition(anyInt())).thenReturn(true);
        // This should be a method to invoke the private setPosition
        invokeSetPosition(0);
        // Act
        boolean result = childContext.setPosition(1);
        // Assert
        assertTrue(result);
        verify(mockIterator).setPosition(1);
        // Additional verifications can be added based on the expected behavior of prepare()
    }

    @Test
    void testSetPositionWhenOldPositionIsNotZero() {
        // Arrange
        when(mockIterator.setPosition(anyInt())).thenReturn(true);
        // Assume current position is set to 1
        invokeSetPosition(1);
        // Act
        boolean result = childContext.setPosition(2);
        // Assert
        assertTrue(result);
        verify(mockIterator).setPosition(2);
    }

    @Test
    void testSetPositionWhenIteratorIsNull() {
        // Arrange
        try {
            java.lang.reflect.Field iteratorField = ChildContext.class.getDeclaredField("iterator");
            iteratorField.setAccessible(true);
            iteratorField.set(childContext, null);
        } catch (Exception e) {
            fail("Failed to set iterator to null: " + e.getMessage());
        }
        // Act
        boolean result = childContext.setPosition(1);
        // Assert
        assertFalse(result);
    }

    private void invokeSetPosition(int position) {
        try {
            java.lang.reflect.Method method = ChildContext.class.getDeclaredMethod("setPosition", int.class);
            method.setAccessible(true);
            method.invoke(childContext, position);
        } catch (Exception e) {
            fail("Failed to invoke setPosition: " + e.getMessage());
        }
    }
}
