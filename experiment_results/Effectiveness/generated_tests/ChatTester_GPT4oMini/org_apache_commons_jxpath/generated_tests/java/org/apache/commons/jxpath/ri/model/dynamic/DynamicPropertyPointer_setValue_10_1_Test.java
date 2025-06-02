package org.apache.commons.jxpath.ri.model.dynamic;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class DynamicPropertyPointer_setValue_10_1_Test {

    private DynamicPropertyHandler handler;

    private DynamicPropertyPointer dynamicPropertyPointer;

    @BeforeEach
    public void setUp() {
        handler = mock(DynamicPropertyHandler.class);
        dynamicPropertyPointer = new DynamicPropertyPointer(null, handler);
    }

    @Test
    public void testSetValue_WholeCollection() throws Exception {
        // Arrange
        Object value = new Object();
        // Assuming WHOLE_COLLECTION is a static field
        int index = DynamicPropertyPointer.WHOLE_COLLECTION;
        setPrivateField(dynamicPropertyPointer, "index", index);
        when(handler.getProperty(any(), any())).thenReturn(value);
        // Act
        dynamicPropertyPointer.setValue(value);
        // Assert
        verify(handler).setProperty(any(), any(), eq(value));
    }

    @Test
    public void testSetValue_SingleValue() throws Exception {
        // Arrange
        Object existingValue = new Object();
        Object newValue = new Object();
        int index = 0;
        setPrivateField(dynamicPropertyPointer, "index", index);
        when(handler.getProperty(any(), any())).thenReturn(existingValue);
        // Act
        dynamicPropertyPointer.setValue(newValue);
        // Assert
        verify(handler).setProperty(any(), any(), eq(existingValue));
        verify(handler).setProperty(any(), any(), eq(newValue));
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
