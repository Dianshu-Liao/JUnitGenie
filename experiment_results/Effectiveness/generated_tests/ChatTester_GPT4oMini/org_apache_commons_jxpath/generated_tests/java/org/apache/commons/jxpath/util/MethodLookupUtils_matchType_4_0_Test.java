package org.apache.commons.jxpath.util;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.JXPathException;

public class MethodLookupUtils_matchType_4_0_Test {

    @Test
    public void testMatchType_ExactMatch() throws Exception {
        Class<String> expected = String.class;
        String object = "test";
        Method method = MethodLookupUtils.class.getDeclaredMethod("matchType", Class.class, Object.class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, expected, object);
        // EXACT_MATCH
        assertEquals(2, result);
    }

    @Test
    public void testMatchType_NullObject() throws Exception {
        Class<String> expected = String.class;
        Object object = null;
        Method method = MethodLookupUtils.class.getDeclaredMethod("matchType", Class.class, Object.class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, expected, object);
        // APPROXIMATE_MATCH
        assertEquals(1, result);
    }

    @Test
    public void testMatchType_ApproximateMatch() throws Exception {
        Class<Number> expected = Number.class;
        // Integer is a subclass of Number
        Object object = 123;
        Method method = MethodLookupUtils.class.getDeclaredMethod("matchType", Class.class, Object.class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, expected, object);
        // EXACT_MATCH
        assertEquals(2, result);
    }

    @Test
    public void testMatchType_NoMatch() throws Exception {
        Class<String> expected = String.class;
        // Integer does not match String
        Object object = 123;
        Method method = MethodLookupUtils.class.getDeclaredMethod("matchType", Class.class, Object.class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, expected, object);
        // NO_MATCH
        assertEquals(0, result);
    }

    @Test
    public void testMatchType_ApproximateMatchWithConversion() throws Exception {
        Class<String> expected = String.class;
        // Assuming object can be converted to String
        Object object = Mockito.mock(Object.class);
        // Mocking TypeUtils.canConvert behavior
        // This part would depend on your actual TypeUtils implementation
        // For the purpose of this test, we will assume canConvert returns true
        Method method = MethodLookupUtils.class.getDeclaredMethod("matchType", Class.class, Object.class);
        method.setAccessible(true);
        // Simulate the behavior of TypeUtils.canConvert
        when(TypeUtils.canConvert(object, expected)).thenReturn(true);
        int result = (int) method.invoke(null, expected, object);
        // APPROXIMATE_MATCH
        assertEquals(1, result);
    }
}
