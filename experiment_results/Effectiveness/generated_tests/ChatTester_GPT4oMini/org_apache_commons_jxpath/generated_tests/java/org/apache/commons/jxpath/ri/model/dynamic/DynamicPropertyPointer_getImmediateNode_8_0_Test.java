// Test method
package org.apache.commons.jxpath.ri.model.dynamic;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DynamicPropertyPointer_getImmediateNode_8_0_Test {

    private DynamicPropertyHandler handler;

    private DynamicPropertyPointer dynamicPropertyPointer;

    // Assuming WHOLE_COLLECTION is defined as such
    private static final int WHOLE_COLLECTION = -1;

    // Example specific index
    private static final int SPECIFIC_INDEX = 0;

    @BeforeEach
    void setUp() {
        handler = mock(DynamicPropertyHandler.class);
        dynamicPropertyPointer = new DynamicPropertyPointer(null, handler);
    }

    @Test
    void testGetImmediateNode_WhenIndexIsWholeCollection() throws Exception {
        // Arrange
        when(handler.getProperty(any(), any())).thenReturn("mockedValue");
        // Use reflection to set the index field to WHOLE_COLLECTION
        setPrivateField(dynamicPropertyPointer, "index", WHOLE_COLLECTION);
        // Act
        Object result = invokePrivateMethod(dynamicPropertyPointer, "getImmediateNode");
        // Assert
        assertEquals("mockedValue", result);
    }

    @Test
    void testGetImmediateNode_WhenIndexIsNotWholeCollection() throws Exception {
        // Arrange
        when(handler.getProperty(any(), any())).thenReturn("mockedValue");
        // Use reflection to set the index field to a specific value
        setPrivateField(dynamicPropertyPointer, "index", SPECIFIC_INDEX);
        // Act
        Object result = invokePrivateMethod(dynamicPropertyPointer, "getImmediateNode");
        // Assert
        assertEquals("mockedValue", result);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object invokePrivateMethod(Object obj, String methodName, Object... args) throws Exception {
        java.lang.reflect.Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(obj, args);
    }
}
