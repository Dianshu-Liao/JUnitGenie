package org.apache.commons.jxpath.util;

import java.util.Arrays;
import org.apache.commons.jxpath.JXPathException;
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

public class ValueUtils_convert_11_0_Test {

    private Method convertMethod;

    @BeforeEach
    public void setUp() throws NoSuchMethodException {
        convertMethod = ValueUtils.class.getDeclaredMethod("convert", Object.class, Class.class);
        // Make the private method accessible
        convertMethod.setAccessible(true);
    }

    private Object invokeConvert(Object input, Class<?> targetType) throws Exception {
        return convertMethod.invoke(null, input, targetType);
    }

    @Test
    public void testConvertIntegerToString() throws Exception {
        Object input = 123;
        Class<String> targetType = String.class;
        String result = (String) invokeConvert(input, targetType);
        assertEquals("123", result);
    }

    @Test
    public void testConvertStringToInteger() throws Exception {
        Object input = "456";
        Class<Integer> targetType = Integer.class;
        Integer result = (Integer) invokeConvert(input, targetType);
        assertEquals(456, result);
    }

    @Test
    public void testConvertNullValue() throws Exception {
        Object input = null;
        Class<String> targetType = String.class;
        String result = (String) invokeConvert(input, targetType);
        assertNull(result);
    }

    @Test
    public void testConvertBooleanToString() throws Exception {
        Object input = true;
        Class<String> targetType = String.class;
        String result = (String) invokeConvert(input, targetType);
        assertEquals("true", result);
    }

    @Test
    public void testConvertStringToBoolean() throws Exception {
        Object input = "false";
        Class<Boolean> targetType = Boolean.class;
        Boolean result = (Boolean) invokeConvert(input, targetType);
        assertFalse(result);
    }

    @Test
    public void testConvertInvalidType() {
        Object input = "invalid";
        Class<Integer> targetType = Integer.class;
        Exception exception = assertThrows(JXPathException.class, () -> {
            invokeConvert(input, targetType);
        });
        assertTrue(exception.getMessage().contains("Cannot convert value of class java.lang.String to type class java.lang.Integer"));
    }

    @Test
    public void testConvertDoubleToInteger() throws Exception {
        Object input = 10.5;
        Class<Integer> targetType = Integer.class;
        Integer result = (Integer) invokeConvert(input, targetType);
        assertEquals(10, result);
    }

    @Test
    public void testConvertIntegerToLong() throws Exception {
        Object input = 100;
        Class<Long> targetType = Long.class;
        Long result = (Long) invokeConvert(input, targetType);
        assertEquals(100L, result);
    }

    @Test
    public void testConvertStringToDouble() throws Exception {
        Object input = "3.14";
        Class<Double> targetType = Double.class;
        Double result = (Double) invokeConvert(input, targetType);
        assertEquals(3.14, result);
    }

    @Test
    public void testConvertListToArray() throws Exception {
        Object input = Arrays.asList("A", "B", "C");
        Class<String[]> targetType = String[].class;
        String[] result = (String[]) invokeConvert(input, targetType);
        assertArrayEquals(new String[] { "A", "B", "C" }, result);
    }
}
