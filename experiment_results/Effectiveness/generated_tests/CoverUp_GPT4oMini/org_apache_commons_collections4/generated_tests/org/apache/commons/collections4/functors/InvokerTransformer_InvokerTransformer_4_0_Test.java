package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.functors.InvokerTransformer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

class InvokerTransformer_InvokerTransformer_4_0_Test {

    @Test
    void testConstructorWithValidParameters() {
        String methodName = "testMethod";
        Class<?>[] paramTypes = { String.class, Integer.class };
        Object[] args = { "test", 123 };
        InvokerTransformer transformer = new InvokerTransformer(methodName, paramTypes, args);
        assertNotNull(transformer);
        assertEquals("testMethod", getPrivateField(transformer, "iMethodName"));
        assertArrayEquals(paramTypes, getPrivateField(transformer, "iParamTypes"));
        assertArrayEquals(args, getPrivateField(transformer, "iArgs"));
    }

    @Test
    void testConstructorWithNullParamTypes() {
        String methodName = "testMethod";
        Object[] args = { "test", 123 };
        InvokerTransformer transformer = new InvokerTransformer(methodName, null, args);
        assertNotNull(transformer);
        assertEquals("testMethod", getPrivateField(transformer, "iMethodName"));
        assertNull(getPrivateField(transformer, "iParamTypes"));
        assertArrayEquals(args, getPrivateField(transformer, "iArgs"));
    }

    @Test
    void testConstructorWithNullArgs() {
        String methodName = "testMethod";
        Class<?>[] paramTypes = { String.class, Integer.class };
        InvokerTransformer transformer = new InvokerTransformer(methodName, paramTypes, null);
        assertNotNull(transformer);
        assertEquals("testMethod", getPrivateField(transformer, "iMethodName"));
        assertArrayEquals(paramTypes, getPrivateField(transformer, "iParamTypes"));
        assertNull(getPrivateField(transformer, "iArgs"));
    }

    @Test
    void testConstructorWithNullParameters() {
        InvokerTransformer transformer = new InvokerTransformer(null, null, null);
        assertNotNull(transformer);
        assertNull(getPrivateField(transformer, "iMethodName"));
        assertNull(getPrivateField(transformer, "iParamTypes"));
        assertNull(getPrivateField(transformer, "iArgs"));
    }

    @SuppressWarnings("unchecked")
    private <T> T getPrivateField(InvokerTransformer transformer, String fieldName) {
        try {
            Field field = InvokerTransformer.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(transformer);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
