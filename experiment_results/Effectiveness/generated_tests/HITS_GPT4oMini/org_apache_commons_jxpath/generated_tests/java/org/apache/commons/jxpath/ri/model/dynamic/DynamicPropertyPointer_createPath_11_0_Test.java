package org.apache.commons.jxpath.ri.model.dynamic;

import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.ValueUtils;

class DynamicPropertyPointer_createPath_11_0_Test {

    private DynamicPropertyHandler handler;

    private JXPathContext context;

    private DynamicPropertyPointer dynamicPropertyPointer;

    @BeforeEach
    void setUp() {
        handler = mock(DynamicPropertyHandler.class);
        context = mock(JXPathContext.class);
        dynamicPropertyPointer = new DynamicPropertyPointer(null, handler);
    }

    @Test
    void testCreatePathWhenCollectionIsNull() {
        when(handler.getProperty(any(), any())).thenReturn(null);
        NodePointer result = dynamicPropertyPointer.createPath(context);
        assertNotNull(result);
        assertEquals(dynamicPropertyPointer, result);
    }

    @Test
    void testCreatePathWhenIndexIsOutOfBounds() {
        when(handler.getProperty(any(), any())).thenReturn(new Object[0]);
        dynamicPropertyPointer.setPropertyIndex(0);
        assertThrows(JXPathInvalidAccessException.class, () -> {
            dynamicPropertyPointer.createPath(context);
        });
    }

    @Test
    void testCreatePathWhenIndexIsValid() {
        Object[] collection = new Object[2];
        when(handler.getProperty(any(), any())).thenReturn(collection);
        dynamicPropertyPointer.setPropertyIndex(1);
        NodePointer result = dynamicPropertyPointer.createPath(context);
        assertNotNull(result);
        assertEquals(dynamicPropertyPointer, result);
    }

    @Test
    void testCreatePathWhenFactoryCannotCreateObject() {
        when(handler.getProperty(any(), any())).thenReturn(null);
        assertThrows(JXPathAbstractFactoryException.class, () -> {
            dynamicPropertyPointer.createPath(context);
        });
    }
}
