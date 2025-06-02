package org.apache.commons.collections4.functors;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class InvokerTransformer_InvokerTransformer_3_0_Test {

    private InvokerTransformer invokerTransformer;

    @BeforeEach
    public void setUp() {
        // Initialize the InvokerTransformer with a method name
        invokerTransformer = invokePrivateConstructor("testMethod");
    }

    @Test
    public void testInvokerTransformerInitialization() {
        // Verify that the InvokerTransformer is not null
        assertNotNull(invokerTransformer);
        // Use reflection to access the private fields
        String methodName = getPrivateField(invokerTransformer, "iMethodName");
        Class<?>[] paramTypes = getPrivateField(invokerTransformer, "iParamTypes");
        Object[] args = getPrivateField(invokerTransformer, "iArgs");
        // Verify the method name is set correctly
        assertEquals("testMethod", methodName);
        // Verify that paramTypes and args are null
        assertNull(paramTypes);
        assertNull(args);
    }

    // Reflection method to invoke the private constructor
    private InvokerTransformer invokePrivateConstructor(String methodName) {
        try {
            return (InvokerTransformer) InvokerTransformer.class.getDeclaredConstructor(String.class).newInstance(methodName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Reflection method to get private field values
    @SuppressWarnings("unchecked")
    private <T> T getPrivateField(Object obj, String fieldName) {
        try {
            // Fixed the buggy line
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
