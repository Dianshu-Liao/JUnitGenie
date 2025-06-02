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

public class ChildContext_getCurrentNodePointer_0_0_Test {

    private ChildContext childContext;

    private NodeIterator mockIterator;

    private NodePointer mockNodePointer;

    private NodeTest mockNodeTest;

    @BeforeEach
    public void setUp() {
        mockNodeTest = Mockito.mock(NodeTest.class);
        mockIterator = Mockito.mock(NodeIterator.class);
        mockNodePointer = Mockito.mock(NodePointer.class);
        childContext = new ChildContext(null, mockNodeTest, false, false);
    }

    private void setPosition(int position) throws Exception {
        Field positionField = EvalContext.class.getDeclaredField("position");
        positionField.setAccessible(true);
        positionField.set(childContext, position);
    }

    private void setIterator(NodeIterator iterator) throws Exception {
        Field iteratorField = ChildContext.class.getDeclaredField("iterator");
        iteratorField.setAccessible(true);
        iteratorField.set(childContext, iterator);
    }

    @Test
    public void testGetCurrentNodePointer_WhenPositionIsZeroAndSetPositionFails() throws Exception {
        setPosition(0);
        when(childContext.setPosition(1)).thenReturn(false);
        NodePointer result = childContext.getCurrentNodePointer();
        assertNull(result, "Expected null when position is 0 and setPosition fails.");
    }

    @Test
    public void testGetCurrentNodePointer_WhenIteratorIsNull() throws Exception {
        setPosition(1);
        setIterator(null);
        NodePointer result = childContext.getCurrentNodePointer();
        assertNull(result, "Expected null when iterator is null.");
    }

    @Test
    public void testGetCurrentNodePointer_WhenIteratorIsNotNull() throws Exception {
        setPosition(1);
        setIterator(mockIterator);
        when(mockIterator.getNodePointer()).thenReturn(mockNodePointer);
        NodePointer result = childContext.getCurrentNodePointer();
        assertNotNull(result, "Expected non-null NodePointer when iterator is not null.");
    }

    @Test
    public void testGetCurrentNodePointer_WhenPositionIsNonZeroAndSetPositionSucceeds() throws Exception {
        setPosition(1);
        setIterator(mockIterator);
        when(mockIterator.getNodePointer()).thenReturn(mockNodePointer);
        NodePointer result = childContext.getCurrentNodePointer();
        assertNotNull(result, "Expected non-null NodePointer when position is non-zero and iterator is valid.");
    }
}
