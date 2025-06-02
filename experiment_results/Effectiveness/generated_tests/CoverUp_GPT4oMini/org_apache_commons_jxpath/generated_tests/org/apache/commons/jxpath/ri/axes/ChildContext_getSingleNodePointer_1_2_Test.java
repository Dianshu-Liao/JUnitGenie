package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.EvalContext;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChildContext_getSingleNodePointer_1_2_Test {

    private ChildContext childContext;

    private NodeTest nodeTestMock;

    private NodeIterator iteratorMock;

    private NodePointer nodePointerMock;

    @BeforeEach
    void setUp() {
        nodeTestMock = Mockito.mock(NodeTest.class);
        iteratorMock = Mockito.mock(NodeIterator.class);
        nodePointerMock = Mockito.mock(NodePointer.class);
        EvalContext parentContextMock = Mockito.mock(EvalContext.class);
        childContext = new ChildContext(parentContextMock, nodeTestMock, false, false);
    }

    @Test
    void testGetSingleNodePointerWhenPositionIsZeroAndIteratorIsNull() throws Exception {
        // Arrange
        setIteratorField(null);
        childContext.setPosition(0);
        // Simulate that nextSet() returns false
        when(childContext.nextSet()).thenReturn(false);
        // Act
        Pointer result = childContext.getSingleNodePointer();
        // Assert
        assertNull(result);
    }

    @Test
    void testGetSingleNodePointerWhenPositionIsZeroAndIteratorReturnsPointer() throws Exception {
        // Arrange
        setIteratorField(iteratorMock);
        childContext.setPosition(0);
        when(childContext.nextSet()).thenReturn(true);
        when(iteratorMock.getNodePointer()).thenReturn(nodePointerMock);
        // Act
        Pointer result = childContext.getSingleNodePointer();
        // Assert
        assertNotNull(result);
        verify(iteratorMock).getNodePointer();
    }

    @Test
    void testGetSingleNodePointerWhenPositionIsNonZero() throws Exception {
        // Arrange
        setIteratorField(iteratorMock);
        childContext.setPosition(1);
        when(childContext.getCurrentNodePointer()).thenReturn(nodePointerMock);
        // Act
        Pointer result = childContext.getSingleNodePointer();
        // Assert
        assertNotNull(result);
        verify(childContext).getCurrentNodePointer();
    }

    @Test
    void testGetSingleNodePointerWhenPositionIsZeroAndIteratorIsNotNullButReturnsNullPointer() throws Exception {
        // Arrange
        setIteratorField(iteratorMock);
        childContext.setPosition(0);
        when(childContext.nextSet()).thenReturn(true);
        when(iteratorMock.getNodePointer()).thenReturn(null);
        // Act
        Pointer result = childContext.getSingleNodePointer();
        // Assert
        assertNull(result);
    }

    private void setIteratorField(NodeIterator iterator) throws Exception {
        Field iteratorField = ChildContext.class.getDeclaredField("iterator");
        iteratorField.setAccessible(true);
        iteratorField.set(childContext, iterator);
    }
}
