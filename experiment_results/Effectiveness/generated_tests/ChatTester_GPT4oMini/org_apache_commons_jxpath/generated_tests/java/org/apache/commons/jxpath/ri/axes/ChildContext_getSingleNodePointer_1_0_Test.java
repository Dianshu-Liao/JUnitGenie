package org.apache.commons.jxpath.ri.axes;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ChildContext_getSingleNodePointer_1_0_Test {

    private ChildContext childContext;

    private NodeTest nodeTestMock;

    private NodeIterator nodeIteratorMock;

    private EvalContext parentContextMock;

    @BeforeEach
    void setUp() {
        parentContextMock = mock(EvalContext.class);
        nodeTestMock = mock(NodeTest.class);
        nodeIteratorMock = mock(NodeIterator.class);
        childContext = new ChildContext(parentContextMock, nodeTestMock, true, false);
    }

    @Test
    void testGetSingleNodePointerWhenPositionIsZeroAndIteratorIsNull() {
        // Simulate position being 0 and iterator being null
        setPrivateField(childContext, "position", 0);
        setPrivateField(childContext, "iterator", null);
        Pointer result = childContext.getSingleNodePointer();
        assertNull(result, "Expected null when iterator is null");
    }

    @Test
    void testGetSingleNodePointerWhenPositionIsZeroAndIteratorHasNoNodePointer() {
        // Simulate position being 0 and iterator returning no NodePointer
        setPrivateField(childContext, "position", 0);
        when(nodeIteratorMock.getNodePointer()).thenReturn(null);
        setPrivateField(childContext, "iterator", nodeIteratorMock);
        // Simulate nextSet behavior
        when(childContext.nextSet()).thenReturn(true).thenReturn(false);
        Pointer result = childContext.getSingleNodePointer();
        assertNull(result, "Expected null when NodePointer is not found");
    }

    @Test
    void testGetSingleNodePointerWhenPositionIsZeroAndIteratorHasNodePointer() {
        // Simulate position being 0 and iterator returning a NodePointer
        setPrivateField(childContext, "position", 0);
        NodePointer nodePointerMock = mock(NodePointer.class);
        when(nodeIteratorMock.getNodePointer()).thenReturn(nodePointerMock);
        setPrivateField(childContext, "iterator", nodeIteratorMock);
        // Simulate nextSet behavior
        when(childContext.nextSet()).thenReturn(true).thenReturn(false);
        Pointer result = childContext.getSingleNodePointer();
        assertNotNull(result, "Expected non-null NodePointer");
    }

    @Test
    void testGetSingleNodePointerWhenPositionIsNonZero() {
        // Simulate position being non-zero
        setPrivateField(childContext, "position", 1);
        // Assuming getCurrentNodePointer() returns a specific value, adjust accordingly
        NodePointer expectedPointer = mock(NodePointer.class);
        when(childContext.getCurrentNodePointer()).thenReturn(expectedPointer);
        Pointer result = childContext.getSingleNodePointer();
        assertEquals(expectedPointer, result, "Expected to return the current NodePointer");
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            // Fixed line: Replace 'var' with 'Field'
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
