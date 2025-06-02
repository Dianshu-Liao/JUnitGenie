package org.apache.commons.jxpath.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.JXPathException;

@ExtendWith(MockitoExtension.class)
public class MethodLookupUtils_matchType_4_0_Test {

    @Test
    public void testMatchType_ExactMatch() {
        assertEquals(2, invokeMatchType(String.class, "test"));
    }

    @Test
    public void testMatchType_AssignableFrom() {
        assertEquals(2, invokeMatchType(Object.class, "test"));
    }

    @Test
    public void testMatchType_ApproximateMatch() {
        // Mocking TypeUtils.canConvert to return true
        mockCanConvert(true);
        assertEquals(1, invokeMatchType(Integer.class, "123"));
        // Reset mock
        mockCanConvert(false);
    }

    @Test
    public void testMatchType_NoMatch() {
        assertEquals(0, invokeMatchType(String.class, 123));
    }

    @Test
    public void testMatchType_NullObject() {
        assertEquals(1, invokeMatchType(String.class, null));
    }

    private int invokeMatchType(Class<?> expected, Object object) {
        try {
            Method method = MethodLookupUtils.class.getDeclaredMethod("matchType", Class.class, Object.class);
            method.setAccessible(true);
            return (int) method.invoke(null, expected, object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void mockCanConvert(boolean result) {
        try {
            Method method = TypeUtils.class.getDeclaredMethod("canConvert", Object.class, Class.class);
            method.setAccessible(true);
            Field field = TypeUtils.class.getDeclaredField("typeConverter");
            field.setAccessible(true);
            TypeConverter mockConverter = new TypeConverter() {

                @Override
                public boolean canConvert(Object object, Class toType) {
                    return result;
                }

                @Override
                public Object convert(Object object, Class toType) {
                    // Provide a stub implementation
                    return null;
                }
            };
            field.set(null, mockConverter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
