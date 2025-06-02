package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContext;

class NullElementPointer_asPath_15_0_Test {

    private NullElementPointer nullElementPointer;

    private NodePointer parentPointer;

    @BeforeEach
    void setUp() {
        parentPointer = mock(NodePointer.class);
        nullElementPointer = new NullElementPointer(parentPointer, 0);
    }

    @Test
    void testAsPath_WithParentAndIndex() throws Exception {
        when(parentPointer.asPath()).thenReturn("parentPath");
        when(parentPointer.getIndex()).thenReturn(1);
        String result = invokeAsPath(nullElementPointer);
        assertEquals("parentPath[1]", result);
    }

    @Test
    void testAsPath_WithParentAndWholeCollectionIndex() throws Exception {
        when(parentPointer.asPath()).thenReturn("parentPath");
        when(parentPointer.getIndex()).thenReturn(NodePointer.WHOLE_COLLECTION);
        String result = invokeAsPath(nullElementPointer);
        assertEquals("parentPath[1]", result);
    }

    @Test
    void testAsPath_WithNullParent() throws Exception {
        nullElementPointer = new NullElementPointer(null, 0);
        String result = invokeAsPath(nullElementPointer);
        assertEquals("[1]", result);
    }

    @Test
    void testAsPath_WithParentAndDifferentIndex() throws Exception {
        when(parentPointer.asPath()).thenReturn("parentPath");
        when(parentPointer.getIndex()).thenReturn(2);
        String result = invokeAsPath(nullElementPointer);
        assertEquals("parentPath[1]", result);
    }

    private String invokeAsPath(NullElementPointer pointer) throws Exception {
        Method method = NullElementPointer.class.getDeclaredMethod("asPath");
        method.setAccessible(true);
        return (String) method.invoke(pointer);
    }
}
