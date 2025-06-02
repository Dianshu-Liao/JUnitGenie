package org.apache.commons.collections4.functors;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
// Fixed import
import java.lang.reflect.Field;
import java.util.Objects;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class InvokerTransformer_InvokerTransformer_4_0_Test {

    @Test
    void testConstructorWithValidParameters() {
        String methodName = "testMethod";
        Class<?>[] paramTypes = { String.class, int.class };
        Object[] args = { "test", 1 };
        InvokerTransformer transformer = new InvokerTransformer(methodName, paramTypes, args);
        assertNotNull(transformer);
        assertEquals(methodName, invokePrivateField(transformer, "iMethodName"));
        assertArrayEquals(paramTypes, invokePrivateField(transformer, "iParamTypes"));
        assertArrayEquals(args, invokePrivateField(transformer, "iArgs"));
    }

    @Test
    void testConstructorWithNullParamTypes() {
        String methodName = "testMethod";
        Object[] args = { "test" };
        InvokerTransformer transformer = new InvokerTransformer(methodName, null, args);
        assertNotNull(transformer);
        assertEquals(methodName, invokePrivateField(transformer, "iMethodName"));
        assertNull(invokePrivateField(transformer, "iParamTypes"));
        assertArrayEquals(args, invokePrivateField(transformer, "iArgs"));
    }

    @Test
    void testConstructorWithNullArgs() {
        String methodName = "testMethod";
        Class<?>[] paramTypes = { String.class };
        InvokerTransformer transformer = new InvokerTransformer(methodName, paramTypes, null);
        assertNotNull(transformer);
        assertEquals(methodName, invokePrivateField(transformer, "iMethodName"));
        assertArrayEquals(paramTypes, invokePrivateField(transformer, "iParamTypes"));
        assertNull(invokePrivateField(transformer, "iArgs"));
    }

    @Test
    void testConstructorWithNullParamTypesAndArgs() {
        String methodName = "testMethod";
        InvokerTransformer transformer = new InvokerTransformer(methodName, null, null);
        assertNotNull(transformer);
        assertEquals(methodName, invokePrivateField(transformer, "iMethodName"));
        assertNull(invokePrivateField(transformer, "iParamTypes"));
        assertNull(invokePrivateField(transformer, "iArgs"));
    }

    @Test
    void testConstructorWithEmptyParams() {
        String methodName = "emptyMethod";
        Class<?>[] paramTypes = {};
        Object[] args = {};
        InvokerTransformer transformer = new InvokerTransformer(methodName, paramTypes, args);
        assertNotNull(transformer);
        assertEquals(methodName, invokePrivateField(transformer, "iMethodName"));
        assertArrayEquals(paramTypes, invokePrivateField(transformer, "iParamTypes"));
        assertArrayEquals(args, invokePrivateField(transformer, "iArgs"));
    }

    @SuppressWarnings("unchecked")
    private <T> T invokePrivateField(InvokerTransformer transformer, String fieldName) {
        try {
            // Fixed to use Field
            Field field = InvokerTransformer.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(transformer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
