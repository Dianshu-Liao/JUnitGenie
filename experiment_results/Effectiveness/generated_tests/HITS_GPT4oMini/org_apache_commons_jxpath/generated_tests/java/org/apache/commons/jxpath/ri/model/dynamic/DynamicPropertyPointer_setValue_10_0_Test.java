package org.apache.commons.jxpath.ri.model.dynamic;

import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class DynamicPropertyPointer_setValue_10_0_Test {

    private DynamicPropertyHandler handler;

    private DynamicPropertyPointer dynamicPropertyPointer;

    @BeforeEach
    public void setUp() {
        handler = mock(DynamicPropertyHandler.class);
        dynamicPropertyPointer = new DynamicPropertyPointer(null, handler);
    }

    @Test
    public void testSetValueWholeCollection() {
        Object valueToSet = new Object();
        when(handler.getProperty(any(), any())).thenReturn(new Object());
        dynamicPropertyPointer.setValue(valueToSet);
        verify(handler).setProperty(any(), any(), eq(valueToSet));
    }

    @Test
    public void testSetValueIndexed() {
        Object collection = new Object[] { new Object(), new Object() };
        int index = 1;
        Object valueToSet = new Object();
        when(handler.getProperty(any(), any())).thenReturn(collection);
        dynamicPropertyPointer.setValue(valueToSet);
        verify(handler).setProperty(any(), any(), eq(valueToSet));
        assertEquals(valueToSet, ((Object[]) collection)[index]);
    }

    @Test
    public void testSetValueThrowsExceptionWhenPropertyIsNull() {
        when(handler.getProperty(any(), any())).thenReturn(null);
        Exception exception = assertThrows(JXPathException.class, () -> {
            dynamicPropertyPointer.setValue(new Object());
        });
        assertTrue(exception.getMessage().contains("Cannot modify property:"));
    }

    @Test
    public void testSetValueThrowsExceptionWhenCollectionIsNotSet() {
        Object valueToSet = new Object();
        when(handler.getProperty(any(), any())).thenReturn(new Object());
        dynamicPropertyPointer.setValue(valueToSet);
        verify(handler).setProperty(any(), any(), eq(valueToSet));
    }

    @Test
    public void testSetValueWithInvalidIndex() {
        Object collection = new Object[] { new Object() };
        // Out of bounds
        int invalidIndex = 5;
        Object valueToSet = new Object();
        when(handler.getProperty(any(), any())).thenReturn(collection);
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            dynamicPropertyPointer.setValue(valueToSet);
        });
        assertNotNull(exception);
    }
}
