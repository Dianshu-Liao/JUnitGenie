package org.apache.commons.jxpath.ri.model.beans;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class // Additional edge cases can be added here as needed
NullElementPointer_asPath_15_0_Test {

    private NullElementPointer nullElementPointer;

    private NodePointer mockParent;

    @BeforeEach
    public void setUp() {
        mockParent = mock(NodePointer.class);
        nullElementPointer = new NullElementPointer(mockParent, 0);
    }

    @Test
    public void testAsPath_WithParentAndIndex() {
        when(mockParent.asPath()).thenReturn("parentPath");
        when(mockParent.getIndex()).thenReturn(1);
        when(mockParent.getImmediateParentPointer()).thenReturn(null);
        String result = nullElementPointer.asPath();
        assertEquals("parentPath[1]", result);
    }

    @Test
    public void testAsPath_WithParentAndWholeCollection() {
        when(mockParent.asPath()).thenReturn("parentPath");
        when(mockParent.getIndex()).thenReturn(NullElementPointer.WHOLE_COLLECTION);
        when(mockParent.getImmediateParentPointer()).thenReturn(null);
        String result = nullElementPointer.asPath();
        assertEquals("[1]", result);
    }

    @Test
    public void testAsPath_WithNullParent() {
        when(mockParent.asPath()).thenReturn(null);
        when(mockParent.getIndex()).thenReturn(0);
        when(mockParent.getImmediateParentPointer()).thenReturn(null);
        String result = nullElementPointer.asPath();
        assertEquals("[1]", result);
    }

    @Test
    public void testAsPath_WithParentAndImmediateParent() {
        NodePointer mockImmediateParent = mock(NodePointer.class);
        when(mockImmediateParent.getIndex()).thenReturn(0);
        when(mockParent.getImmediateParentPointer()).thenReturn(mockImmediateParent);
        when(mockParent.getIndex()).thenReturn(1);
        when(mockParent.asPath()).thenReturn("parentPath");
        String result = nullElementPointer.asPath();
        assertEquals("parentPath/. [1]", result);
    }

    @Test
    public void testAsPath_WithImmediateParentAndWholeCollection() {
        NodePointer mockImmediateParent = mock(NodePointer.class);
        when(mockImmediateParent.getIndex()).thenReturn(NullElementPointer.WHOLE_COLLECTION);
        when(mockParent.getImmediateParentPointer()).thenReturn(mockImmediateParent);
        when(mockParent.getIndex()).thenReturn(1);
        when(mockParent.asPath()).thenReturn("parentPath");
        String result = nullElementPointer.asPath();
        assertEquals("parentPath/. [1]", result);
    }

    @Test
    public void testAsPath_WithNullImmediateParent() {
        when(mockParent.getImmediateParentPointer()).thenReturn(null);
        when(mockParent.getIndex()).thenReturn(0);
        when(mockParent.asPath()).thenReturn("parentPath");
        String result = nullElementPointer.asPath();
        assertEquals("parentPath[1]", result);
    }
}
