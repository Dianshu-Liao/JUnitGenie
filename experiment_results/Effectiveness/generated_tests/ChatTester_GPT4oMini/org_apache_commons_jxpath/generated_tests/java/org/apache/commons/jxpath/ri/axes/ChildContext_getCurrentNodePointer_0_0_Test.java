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

public class ChildContext_getCurrentNodePointer_0_0_Test {

    private ChildContext childContext;

    private NodeTest nodeTest;

    private EvalContext parentContext;

    private NodeIterator mockIterator;

    @BeforeEach
    public void setUp() {
        // Mock the dependencies
        parentContext = mock(EvalContext.class);
        nodeTest = mock(NodeTest.class);
        mockIterator = mock(NodeIterator.class);
        // Initialize ChildContext with the mocked dependencies
        childContext = new ChildContext(parentContext, nodeTest, true, false);
        // Use reflection to set the private iterator field
        try {
            java.lang.reflect.Field iteratorField = ChildContext.class.getDeclaredField("iterator");
            iteratorField.setAccessible(true);
            iteratorField.set(childContext, mockIterator);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set up ChildContext: " + e.getMessage());
        }
    }

    @Test
    public void testGetCurrentNodePointer_WhenPositionIsZeroAndSetPositionFails() {
        // Mock the behavior of the setPosition method to return false
        try {
            java.lang.reflect.Method setPositionMethod = ChildContext.class.getDeclaredMethod("setPosition", int.class);
            setPositionMethod.setAccessible(true);
            when(setPositionMethod.invoke(childContext, 1)).thenReturn(false);
        } catch (Exception e) {
            fail("Failed to mock setPosition: " + e.getMessage());
        }
        // Call the method under test
        NodePointer result = childContext.getCurrentNodePointer();
        // Verify the result
        assertNull(result);
    }

    @Test
    public void testGetCurrentNodePointer_WhenIteratorIsNull() {
        // Set iterator to null using reflection
        try {
            java.lang.reflect.Field iteratorField = ChildContext.class.getDeclaredField("iterator");
            iteratorField.setAccessible(true);
            iteratorField.set(childContext, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set iterator to null: " + e.getMessage());
        }
        // Call the method under test
        NodePointer result = childContext.getCurrentNodePointer();
        // Verify the result
        assertNull(result);
    }

    @Test
    public void testGetCurrentNodePointer_WhenIteratorIsNotNull() {
        // Mock the behavior of the iterator
        NodePointer mockNodePointer = mock(NodePointer.class);
        when(mockIterator.getNodePointer()).thenReturn(mockNodePointer);
        // Call the method under test
        NodePointer result = childContext.getCurrentNodePointer();
        // Verify the result
        assertNotNull(result);
        assertEquals(mockNodePointer, result);
    }

    @Test
    public void testGetCurrentNodePointer_WhenPositionIsNonZero() {
        // Set position to a non-zero value using reflection
        try {
            java.lang.reflect.Field positionField = ChildContext.class.getDeclaredField("position");
            positionField.setAccessible(true);
            positionField.setInt(childContext, 1);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set position: " + e.getMessage());
        }
        // Mock the behavior of the iterator
        NodePointer mockNodePointer = mock(NodePointer.class);
        when(mockIterator.getNodePointer()).thenReturn(mockNodePointer);
        // Call the method under test
        NodePointer result = childContext.getCurrentNodePointer();
        // Verify the result
        assertNotNull(result);
        assertEquals(mockNodePointer, result);
    }
}
