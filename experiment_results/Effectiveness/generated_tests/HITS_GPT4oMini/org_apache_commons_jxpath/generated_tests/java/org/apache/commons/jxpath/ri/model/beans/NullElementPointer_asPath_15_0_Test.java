package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;

@ExtendWith(MockitoExtension.class)
public class NullElementPointer_asPath_15_0_Test {

    private NullElementPointer nullElementPointer;

    @BeforeEach
    public void setUp() {
        // Assuming we create a constructor that takes NodePointer and int
        nullElementPointer = new NullElementPointer(mock(NodePointer.class), 0);
    }

    @Test
    public void testAsPath_WithoutParent() throws Exception {
        setIndex(nullElementPointer, 0);
        String path = nullElementPointer.asPath();
        assertEquals("[1]", path);
    }

    @Test
    public void testAsPath_WithParentIndexNotWholeCollection() throws Exception {
        NodePointer parentPointer = mock(NodePointer.class);
        when(parentPointer.asPath()).thenReturn("parentNode");
        when(parentPointer.getIndex()).thenReturn(0);
        setParentPointer(nullElementPointer, parentPointer);
        setIndex(nullElementPointer, 0);
        String path = nullElementPointer.asPath();
        assertEquals("parentNode/[1]", path);
    }

    @Test
    public void testAsPath_WithParentIndexWholeCollection() throws Exception {
        NodePointer parentPointer = mock(NodePointer.class);
        when(parentPointer.asPath()).thenReturn("parentNode");
        when(parentPointer.getIndex()).thenReturn(NodePointer.WHOLE_COLLECTION);
        setParentPointer(nullElementPointer, parentPointer);
        setIndex(nullElementPointer, 1);
        String path = nullElementPointer.asPath();
        assertEquals("parentNode/[2]", path);
    }

    @Test
    public void testAsPath_WithMultipleLevelsOfParent() throws Exception {
        NodePointer grandParentPointer = mock(NodePointer.class);
        when(grandParentPointer.asPath()).thenReturn("grandParentNode");
        when(grandParentPointer.getIndex()).thenReturn(0);
        NodePointer parentPointer = mock(NodePointer.class);
        when(parentPointer.asPath()).thenReturn("parentNode");
        when(parentPointer.getIndex()).thenReturn(1);
        when(parentPointer.getImmediateParentPointer()).thenReturn(grandParentPointer);
        setParentPointer(nullElementPointer, parentPointer);
        setIndex(nullElementPointer, 0);
        String path = nullElementPointer.asPath();
        assertEquals("grandParentNode/.[2]/[1]", path);
    }

    private void setIndex(NullElementPointer pointer, int index) throws Exception {
        java.lang.reflect.Field field = NullElementPointer.class.getDeclaredField("index");
        field.setAccessible(true);
        field.set(pointer, index);
    }

    private void setParentPointer(NullElementPointer pointer, NodePointer parent) throws Exception {
        java.lang.reflect.Field field = NullElementPointer.class.getDeclaredField("parent");
        field.setAccessible(true);
        field.set(pointer, parent);
    }
}
