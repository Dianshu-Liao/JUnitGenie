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
        assertEquals(2, invokeMatchType(String.class, "test"));
    }

    @Test
    public void testMatchType_AssignableFrom() throws Exception {
        assertEquals(2, invokeMatchType(Object.class, "test"));
    }

    @Test
    public void testMatchType_NullObject() throws Exception {
        assertEquals(1, invokeMatchType(String.class, null));
    }

    @Test
    public void testMatchType_NoMatch() throws Exception {
        assertEquals(0, invokeMatchType(String.class, 123));
    }

    @Test
    public void testMatchType_ApproximateMatch() throws Exception {
        assertEquals(1, invokeMatchType(Integer.class, "123"));
    }

    @Test
    public void testMatchType_PrimitiveToWrapperExactMatch() throws Exception {
        assertEquals(2, invokeMatchType(int.class, 1));
    }

    @Test
    public void testMatchType_WrapperToPrimitiveExactMatch() throws Exception {
        assertEquals(2, invokeMatchType(Integer.class, 1));
    }

    @Test
    public void testMatchType_IncompatibleTypes() throws Exception {
        assertEquals(0, invokeMatchType(Double.class, "test"));
    }

    private int invokeMatchType(Class<?> expected, Object object) throws Exception {
        Method method = MethodLookupUtils.class.getDeclaredMethod("matchType", Class.class, Object.class);
        method.setAccessible(true);
        return (int) method.invoke(null, expected, object);
    }
}
