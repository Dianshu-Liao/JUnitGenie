package org.apache.commons.jxpath.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;

public class ValueUtils_convert_11_0_Test {

    // Test for successful conversion
    @Test
    public void testConvert_Success() throws Exception {
        // Arrange
        // String to be converted
        Object value = "123";
        // Target type
        Class<?> type = Integer.class;
        // Act
        Object result = invokeConvert(value, type);
        // Assert
        assertEquals(123, result);
        assertTrue(result instanceof Integer);
    }

    // Test for null value
    @Test
    public void testConvert_NullValue() throws Exception {
        // Arrange
        Object value = null;
        Class<?> type = String.class;
        // Act
        Object result = invokeConvert(value, type);
        // Assert
        assertNull(result);
    }

    // Test for conversion failure
    @Test
    public void testConvert_Failure() {
        // Arrange
        // Non-convertible string
        Object value = "abc";
        // Target type
        Class<?> type = Integer.class;
        // Act & Assert
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            invokeConvert(value, type);
        });
        // Verify exception message
        assertTrue(exception.getMessage().contains("Cannot convert value of class java.lang.String to type class java.lang.Integer"));
    }

    // Reflection method to invoke the private convert method
    private Object invokeConvert(Object value, Class<?> type) throws Exception {
        java.lang.reflect.Method method = ValueUtils.class.getDeclaredMethod("convert", Object.class, Class.class);
        method.setAccessible(true);
        return method.invoke(null, value, type);
    }
}
