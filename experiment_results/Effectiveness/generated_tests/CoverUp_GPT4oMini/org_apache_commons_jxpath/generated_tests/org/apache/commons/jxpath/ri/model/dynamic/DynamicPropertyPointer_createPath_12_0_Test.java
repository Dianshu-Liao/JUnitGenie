package org.apache.commons.jxpath.ri.model.dynamic;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.dynamic.DynamicPropertyPointer;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.lang.reflect.Method;
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
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

class DynamicPropertyPointer_createPath_12_0_Test {

    private DynamicPropertyPointer dynamicPropertyPointer;

    private DynamicPropertyHandler handler;

    private NodePointer parent;

    @BeforeEach
    void setUp() {
        handler = mock(DynamicPropertyHandler.class);
        parent = mock(NodePointer.class);
        dynamicPropertyPointer = new DynamicPropertyPointer(parent, handler);
    }

    @Test
    void testCreatePathWholeCollection() {
        JXPathContext context = mock(JXPathContext.class);
        Object value = new Object();
        // Mocking getBaseValue
        when(handler.getProperty(any(), any())).thenReturn(new Object());
        dynamicPropertyPointer.setPropertyIndex(DynamicPropertyPointer.WHOLE_COLLECTION);
        dynamicPropertyPointer.createPath(context, value);
        verify(handler, times(1)).setProperty(any(), any(), eq(value));
    }

    @Test
    void testCreatePathWithIndex() {
        JXPathContext context = mock(JXPathContext.class);
        Object value = new Object();
        dynamicPropertyPointer.setPropertyIndex(0);
        // Mocking getBaseValue
        when(handler.getProperty(any(), any())).thenReturn(new Object());
        when(handler.getProperty(dynamicPropertyPointer.getBean(), dynamicPropertyPointer.getPropertyName())).thenReturn(new Object());
        dynamicPropertyPointer.createPath(context, value);
        verify(handler, times(0)).setProperty(any(), any(), any());
        // Verify that ValueUtils.setValue is called
        assertDoesNotThrow(() -> {
            Method method = ValueUtils.class.getDeclaredMethod("setValue", Object.class, int.class, Object.class);
            method.setAccessible(true);
            method.invoke(null, dynamicPropertyPointer.getBaseValue(), 0, value);
        });
    }

    @Test
    void testCreatePathWithNullBaseValue() {
        JXPathContext context = mock(JXPathContext.class);
        Object value = new Object();
        dynamicPropertyPointer.setPropertyIndex(0);
        // Mocking getBaseValue to return null
        when(handler.getProperty(any(), any())).thenReturn(null);
        assertThrows(JXPathAbstractFactoryException.class, () -> {
            dynamicPropertyPointer.createPath(context, value);
        });
    }

    @Test
    void testCreatePathWithInvalidIndex() {
        JXPathContext context = mock(JXPathContext.class);
        Object value = new Object();
        // Setting an invalid index
        dynamicPropertyPointer.setPropertyIndex(-1);
        assertThrows(JXPathInvalidAccessException.class, () -> {
            dynamicPropertyPointer.createPath(context, value);
        });
    }

    @Test
    void testCreatePathWithIndexGreaterThanCollection() {
        JXPathContext context = mock(JXPathContext.class);
        Object value = new Object();
        // Assume index greater than the collection size
        dynamicPropertyPointer.setPropertyIndex(10);
        when(handler.getProperty(any(), any())).thenReturn(new Object());
        when(handler.getProperty(dynamicPropertyPointer.getBean(), dynamicPropertyPointer.getPropertyName())).thenReturn(new Object());
        dynamicPropertyPointer.createPath(context, value);
        verify(handler, times(1)).setProperty(any(), any(), any());
    }
}
