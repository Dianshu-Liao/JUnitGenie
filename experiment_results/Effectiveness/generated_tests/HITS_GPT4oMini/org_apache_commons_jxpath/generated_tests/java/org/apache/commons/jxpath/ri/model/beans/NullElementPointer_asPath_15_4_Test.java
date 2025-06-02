package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NullElementPointer_asPath_15_4_Test {

    private NullElementPointer nullElementPointer;

    private NodePointer parentPointer;

    @BeforeEach
    public void setUp() {
        parentPointer = mock(NodePointer.class);
        // Provide the required parameters
        nullElementPointer = new NullElementPointer(parentPointer, 0);
    }

    @Test
    public void testAsPath_NoParent() {
        when(nullElementPointer.getImmediateParentPointer()).thenReturn(null);
        assertEquals("", nullElementPointer.asPath());
    }

    @Test
    public void testAsPath_WithParent() {
        when(nullElementPointer.getImmediateParentPointer()).thenReturn(parentPointer);
        when(parentPointer.asPath()).thenReturn("parentPath");
        assertEquals("parentPath", nullElementPointer.asPath());
    }

    @Test
    public void testAsPath_WithIndex() {
        when(nullElementPointer.getImmediateParentPointer()).thenReturn(parentPointer);
        when(parentPointer.asPath()).thenReturn("parentPath");
        when(nullElementPointer.getIndex()).thenReturn(0);
        when(parentPointer.getIndex()).thenReturn(-1);
        assertEquals("parentPath[1]", nullElementPointer.asPath());
    }

    @Test
    public void testAsPath_WithWholeCollectionIndex() {
        when(nullElementPointer.getImmediateParentPointer()).thenReturn(parentPointer);
        when(parentPointer.asPath()).thenReturn("parentPath");
        when(nullElementPointer.getIndex()).thenReturn(0);
        when(parentPointer.getIndex()).thenReturn(NullElementPointer.WHOLE_COLLECTION);
        assertEquals("parentPath[1]", nullElementPointer.asPath());
    }

    @Test
    public void testAsPath_WithNestedParent() {
        NodePointer nestedParentPointer = mock(NodePointer.class);
        when(nullElementPointer.getImmediateParentPointer()).thenReturn(parentPointer);
        when(parentPointer.getImmediateParentPointer()).thenReturn(nestedParentPointer);
        when(parentPointer.asPath()).thenReturn("parentPath");
        when(nestedParentPointer.asPath()).thenReturn("nestedParentPath");
        when(nestedParentPointer.getIndex()).thenReturn(0);
        when(nullElementPointer.getIndex()).thenReturn(0);
        assertEquals("nestedParentPath/.[1]", nullElementPointer.asPath());
    }
}
