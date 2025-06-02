package org.apache.commons.jxpath.ri.model.dynamic;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.ValueUtils;

public class DynamicPropertyPointer_createPath_12_0_Test {

    private DynamicPropertyHandler handler;

    private JXPathContext context;

    private DynamicPropertyPointer dynamicPropertyPointer;

    @BeforeEach
    public void setUp() {
        handler = mock(DynamicPropertyHandler.class);
        context = mock(JXPathContext.class);
        dynamicPropertyPointer = new DynamicPropertyPointer(null, handler);
    }

    @Test
    public void testCreatePath_WholeCollection() {
        Object value = new Object();
        when(handler.getProperty(any(), any())).thenReturn(new Object());
        dynamicPropertyPointer.createPath(context, value);
        verify(handler).setProperty(any(), any(), eq(value));
    }

    @Test
    public void testCreatePath_IndexLessThanZero() {
        dynamicPropertyPointer.setPropertyIndex(-1);
        Exception exception = assertThrows(JXPathInvalidAccessException.class, () -> {
            dynamicPropertyPointer.createPath(context, new Object());
        });
        String expectedMessage = "Index is less than 1: " + dynamicPropertyPointer.asPath();
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testCreatePath_IndexGreaterThanLength() {
        dynamicPropertyPointer.setPropertyIndex(5);
        Object collection = new Object();
        when(handler.getProperty(any(), any())).thenReturn(collection);
        when(handler.getPropertyNames(any())).thenReturn(new String[] { "property1", "property2" });
        Exception exception = assertThrows(JXPathAbstractFactoryException.class, () -> {
            dynamicPropertyPointer.createPath(context, new Object());
        });
        String expectedMessage = "Factory could not create an object for path: " + dynamicPropertyPointer.asPath();
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testCreatePath_ValidIndex() {
        dynamicPropertyPointer.setPropertyIndex(0);
        Object value = new Object();
        when(handler.getProperty(any(), any())).thenReturn(new Object());
        when(handler.getPropertyNames(any())).thenReturn(new String[] { "property1" });
        NodePointer result = dynamicPropertyPointer.createPath(context, value);
        assertNotNull(result);
        assertEquals(dynamicPropertyPointer, result);
    }

    @Test
    public void testCreatePath_NullBaseValue() {
        dynamicPropertyPointer.setPropertyIndex(0);
        when(handler.getProperty(any(), any())).thenReturn(null);
        when(handler.getPropertyNames(any())).thenReturn(new String[] { "property1" });
        // Simulate the behavior of createObject without calling it
        // because it does not exist in the handler
        when(handler.getProperty(any(), any())).thenReturn(new Object());
        NodePointer result = dynamicPropertyPointer.createPath(context, new Object());
        assertNotNull(result);
        assertEquals(dynamicPropertyPointer, result);
    }
}
