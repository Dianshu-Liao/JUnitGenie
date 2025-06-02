package org.apache.commons.jxpath.ri.model.dynamic;

import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.ri.model.dynamic.DynamicPropertyPointer;
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
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

class DynamicPropertyPointer_getImmediateNode_8_0_Test {

    private DynamicPropertyPointer dynamicPropertyPointer;

    private DynamicPropertyHandler handler;

    private Object bean;

    @BeforeEach
    void setUp() {
        handler = Mockito.mock(DynamicPropertyHandler.class);
        // Mock or create a real bean according to your use case
        bean = new Object();
        dynamicPropertyPointer = new DynamicPropertyPointer(null, handler);
        dynamicPropertyPointer.setPropertyName("testProperty");
    }

    @Test
    void testGetImmediateNodeWhenWholeCollection() throws Exception {
        // Setup mock behavior
        Mockito.when(handler.getProperty(bean, "testProperty")).thenReturn(new Object[] { "value1", "value2", "value3" });
        setIndex(dynamicPropertyPointer, DynamicPropertyPointer.WHOLE_COLLECTION);
        Object result = dynamicPropertyPointer.getImmediateNode();
        // Assuming the first value is returned
        assertEquals("value1", result);
    }

    @Test
    void testGetImmediateNodeWhenSingleIndex() throws Exception {
        // Setup mock behavior
        Mockito.when(handler.getProperty(bean, "testProperty")).thenReturn(new Object[] { "value1", "value2", "value3" });
        // Set index to 1
        setIndex(dynamicPropertyPointer, 1);
        Object result = dynamicPropertyPointer.getImmediateNode();
        // Expecting the second value
        assertEquals("value2", result);
    }

    @Test
    void testGetImmediateNodeWhenIndexOutOfBounds() throws Exception {
        // Setup mock behavior
        Mockito.when(handler.getProperty(bean, "testProperty")).thenReturn(new Object[] { "value1", "value2" });
        // Set index out of bounds
        setIndex(dynamicPropertyPointer, 5);
        Object result = dynamicPropertyPointer.getImmediateNode();
        // Expecting null as the index is out of bounds
        assertNull(result);
    }

    private void setIndex(DynamicPropertyPointer pointer, int index) throws Exception {
        Method method = DynamicPropertyPointer.class.getDeclaredMethod("setPropertyIndex", int.class);
        method.setAccessible(true);
        method.invoke(pointer, index);
    }
}
