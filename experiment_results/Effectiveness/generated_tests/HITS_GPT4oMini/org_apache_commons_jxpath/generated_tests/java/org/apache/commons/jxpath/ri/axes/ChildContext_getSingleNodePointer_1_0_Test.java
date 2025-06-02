package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChildContext_getSingleNodePointer_1_0_Test {

    private ChildContext childContext;

    @Mock
    private NodeTest nodeTest;

    @Mock
    private EvalContext parentContext;

    @Mock
    private NodeIterator mockIterator;

    @Mock
    private NodePointer mockPointer;

    @BeforeEach
    void setUp() {
        // Create a ChildContext instance with mocked dependencies
        childContext = new ChildContext(parentContext, nodeTest, false, false);
    }

    @Test
    void testGetSingleNodePointerReturnsNullWhenIteratorIsNull() {
        // Simulate the case where the iterator is null
        when(mockIterator.getNodePointer()).thenReturn(null);
        when(mockIterator.setPosition(anyInt())).thenReturn(false);
        // Use reflection to set the private iterator field
        setPrivateField(childContext, "iterator", null);
        // Ensure we are at position 0
        childContext.setPosition(0);
        // Call the method under test
        Pointer result = childContext.getSingleNodePointer();
        // Verify that the result is null
        assertNull(result);
    }

    @Test
    void testGetSingleNodePointerReturnsPointerWhenNodePointerIsNotNull() {
        // Simulate the case where the iterator returns a valid NodePointer
        when(mockIterator.getNodePointer()).thenReturn(mockPointer);
        when(mockIterator.setPosition(anyInt())).thenReturn(true);
        // Use reflection to set the private iterator field
        setPrivateField(childContext, "iterator", mockIterator);
        // Ensure we are at position 0
        childContext.setPosition(0);
        // Call the method under test
        Pointer result = childContext.getSingleNodePointer();
        // Verify that the result is the expected pointer
        assertSame(mockPointer, result);
    }

    @Test
    void testGetSingleNodePointerReturnsNullWhenNoValidPointerFound() {
        // Simulate the case where the iterator returns null on multiple calls
        when(mockIterator.getNodePointer()).thenReturn(null).thenReturn(null);
        when(mockIterator.setPosition(anyInt())).thenReturn(true);
        // Use reflection to set the private iterator field
        setPrivateField(childContext, "iterator", mockIterator);
        // Ensure we are at position 0
        childContext.setPosition(0);
        // Call the method under test
        Pointer result = childContext.getSingleNodePointer();
        // Verify that the result is null
        assertNull(result);
    }

    // Helper method to set private fields using reflection
    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
