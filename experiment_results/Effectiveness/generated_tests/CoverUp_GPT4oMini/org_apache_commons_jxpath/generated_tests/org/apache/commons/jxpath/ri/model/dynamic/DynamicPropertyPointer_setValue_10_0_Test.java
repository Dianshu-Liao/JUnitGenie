package org.apache.commons.jxpath.ri.model.dynamic;

import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.ri.model.dynamic.DynamicPropertyPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
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
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

class DynamicPropertyPointer_setValue_10_0_Test {

    private DynamicPropertyHandler handler;

    private NodePointer parent;

    private DynamicPropertyPointer dynamicPropertyPointer;

    @BeforeEach
    void setUp() {
        handler = mock(DynamicPropertyHandler.class);
        parent = mock(NodePointer.class);
        dynamicPropertyPointer = new DynamicPropertyPointer(parent, handler);
    }

    @Test
    void testSetValueWholeCollection() {
        Object value = new ArrayList<>();
        when(handler.getProperty(any(), any())).thenReturn(value);
        dynamicPropertyPointer.setPropertyIndex(DynamicPropertyPointer.WHOLE_COLLECTION);
        dynamicPropertyPointer.setValue(value);
        verify(handler).setProperty(any(), any(), eq(value));
    }

    @Test
    void testSetValueIndexed() {
        List<String> mockList = new ArrayList<>();
        mockList.add("initial");
        when(handler.getProperty(any(), any())).thenReturn(mockList);
        dynamicPropertyPointer.setPropertyIndex(0);
        dynamicPropertyPointer.setValue("new value");
        assertEquals("new value", mockList.get(0));
    }

    @Test
    void testSetValueWithIndexOutOfBounds() {
        List<String> mockList = new ArrayList<>();
        mockList.add("initial");
        when(handler.getProperty(any(), any())).thenReturn(mockList);
        // Out of bounds index
        dynamicPropertyPointer.setPropertyIndex(1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dynamicPropertyPointer.setValue("new value");
        });
    }

    @Test
    void testSetValueWithNull() {
        List<String> mockList = new ArrayList<>();
        mockList.add("initial");
        when(handler.getProperty(any(), any())).thenReturn(mockList);
        dynamicPropertyPointer.setPropertyIndex(0);
        dynamicPropertyPointer.setValue(null);
        assertNull(mockList.get(0));
    }

    @Test
    void testSetValueUnsupportedCollectionType() {
        // Not a List or array
        Object unsupportedCollection = new Object();
        when(handler.getProperty(any(), any())).thenReturn(unsupportedCollection);
        dynamicPropertyPointer.setPropertyIndex(0);
        assertThrows(UnsupportedOperationException.class, () -> {
            dynamicPropertyPointer.setValue("new value");
        });
    }

    // Reflection test for private method if necessary
    private Object invokePrivateMethod(String methodName, Object... args) throws Exception {
        Field field = DynamicPropertyPointer.class.getDeclaredField(methodName);
        field.setAccessible(true);
        return field.get(dynamicPropertyPointer);
    }
}
