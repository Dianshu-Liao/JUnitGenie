package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.EvalContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ChildContext_setPosition_4_0_Test {

    @Mock
    private NodeTest mockNodeTest;

    @Mock
    private NodeIterator mockIterator;

    @Mock
    private NodePointer mockNodePointer;

    private ChildContext childContext;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        EvalContext mockParentContext = mock(EvalContext.class);
        childContext = new ChildContext(mockParentContext, mockNodeTest, false, false);
    }

    @Test
    void testSetPositionWhenOldPositionIsZeroAndIteratorIsNull() {
        when(childContext.getCurrentPosition()).thenReturn(0);
        childContext.setPosition(1);
        assertFalse(childContext.setPosition(1), "Expected setPosition to return false when iterator is null");
    }

    @Test
    void testSetPositionWhenOldPositionIsZeroAndIteratorIsNotNull() {
        when(childContext.getCurrentPosition()).thenReturn(0);
        when(mockIterator.setPosition(anyInt())).thenReturn(true);
        childContext.setPosition(1);
        assertTrue(childContext.setPosition(1), "Expected setPosition to return true when iterator is not null and setPosition is successful");
    }

    @Test
    void testSetPositionWhenOldPositionIsNotZero() {
        when(childContext.getCurrentPosition()).thenReturn(1);
        when(mockIterator.setPosition(anyInt())).thenReturn(true);
        childContext.setPosition(2);
        assertTrue(childContext.setPosition(2), "Expected setPosition to return true when old position is not zero");
    }

    @Test
    void testSetPositionWhenIteratorReturnsFalse() {
        when(childContext.getCurrentPosition()).thenReturn(1);
        when(mockIterator.setPosition(anyInt())).thenReturn(false);
        assertFalse(childContext.setPosition(2), "Expected setPosition to return false when iterator setPosition fails");
    }

    @Test
    void testSetPositionInvokesPrepareWhenOldPositionIsZero() {
        when(childContext.getCurrentPosition()).thenReturn(0);
        childContext.setPosition(1);
        verify(mockIterator, times(1)).setPosition(1);
        // We cannot verify the prepare() method directly as it is private,
        // but we can assert that the iterator is used correctly.
    }
}
