package org.apache.commons.collections4.functors;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

public class InvokerTransformer_InvokerTransformer_3_0_Test {

    @Test
    public void testInvokerTransformerStringConstructor() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        String methodName = "testMethod";
        // Act
        InvokerTransformer invokerTransformer = new InvokerTransformer(methodName, null, null);
        // Assert
        assertNotNull(invokerTransformer);
        // Using reflection to access private fields
        Field methodNameField = InvokerTransformer.class.getDeclaredField("iMethodName");
        Field paramTypesField = InvokerTransformer.class.getDeclaredField("iParamTypes");
        Field argsField = InvokerTransformer.class.getDeclaredField("iArgs");
        methodNameField.setAccessible(true);
        paramTypesField.setAccessible(true);
        argsField.setAccessible(true);
        String actualMethodName = (String) methodNameField.get(invokerTransformer);
        Class<?>[] actualParamTypes = (Class<?>[]) paramTypesField.get(invokerTransformer);
        Object[] actualArgs = (Object[]) argsField.get(invokerTransformer);
        assertEquals(methodName, actualMethodName);
        assertNull(actualParamTypes);
        assertNull(actualArgs);
    }
}
