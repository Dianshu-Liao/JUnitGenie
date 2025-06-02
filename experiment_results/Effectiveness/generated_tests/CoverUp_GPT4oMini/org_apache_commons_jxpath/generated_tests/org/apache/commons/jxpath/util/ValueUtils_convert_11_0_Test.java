package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.TypeUtils;
import java.lang.reflect.Method;
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

class ValueUtils_convert_11_0_Test {

    @Test
    void testConvert_NullValue() {
        Object result = invokeConvertMethod(null, String.class);
        assertNull(result);
    }

    @Test
    void testConvert_StringToInteger() {
        Object result = invokeConvertMethod("123", Integer.class);
        assertEquals(123, result);
    }

    @Test
    void testConvert_IntegerToString() {
        Object result = invokeConvertMethod(456, String.class);
        assertEquals("456", result);
    }

    @Test
    void testConvert_InvalidType() {
        Exception exception = assertThrows(JXPathException.class, () -> {
            invokeConvertMethod("invalid", Integer.class);
        });
        assertTrue(exception.getMessage().contains("Cannot convert value of class java.lang.String to type class java.lang.Integer"));
    }

    @Test
    void testConvert_UnsupportedType() {
        Exception exception = assertThrows(JXPathException.class, () -> {
            invokeConvertMethod(new Object(), String.class);
        });
        assertTrue(exception.getMessage().contains("Cannot convert value of class java.lang.Object to type class java.lang.String"));
    }

    private Object invokeConvertMethod(Object value, Class<?> type) {
        try {
            Method method = ValueUtils.class.getDeclaredMethod("convert", Object.class, Class.class);
            method.setAccessible(true);
            return method.invoke(null, value, type);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
