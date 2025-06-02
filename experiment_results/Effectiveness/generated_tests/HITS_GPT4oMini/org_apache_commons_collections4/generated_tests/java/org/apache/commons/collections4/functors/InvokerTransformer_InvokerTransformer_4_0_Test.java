package org.apache.commons.collections4.functors;

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

public class InvokerTransformer_InvokerTransformer_4_0_Test {

    @Test
    public void testInvokerTransformer_WithValidParameters() {
        // Arrange
        String methodName = "substring";
        Class<?>[] paramTypes = new Class<?>[] { int.class, int.class };
        Object[] args = new Object[] { "Hello, World!", 7, 12 };
        // Act
        InvokerTransformer transformer = new InvokerTransformer(methodName, paramTypes, args);
        // Assert
        assertNotNull(transformer);
    }

    @Test
    public void testInvokerTransformer_WithNullMethodName() {
        // Arrange
        String methodName = null;
        Class<?>[] paramTypes = new Class<?>[] { int.class, int.class };
        Object[] args = new Object[] { "Hello, World!", 7, 12 };
        // Act
        InvokerTransformer transformer = new InvokerTransformer(methodName, paramTypes, args);
        // Assert
        assertNotNull(transformer);
    }

    @Test
    public void testInvokerTransformer_WithNullParamTypes() {
        // Arrange
        String methodName = "substring";
        Class<?>[] paramTypes = null;
        Object[] args = new Object[] { "Hello, World!", 7, 12 };
        // Act
        InvokerTransformer transformer = new InvokerTransformer(methodName, paramTypes, args);
        // Assert
        assertNotNull(transformer);
    }

    @Test
    public void testInvokerTransformer_WithNullArgs() {
        // Arrange
        String methodName = "substring";
        Class<?>[] paramTypes = new Class<?>[] { int.class, int.class };
        Object[] args = null;
        // Act
        InvokerTransformer transformer = new InvokerTransformer(methodName, paramTypes, args);
        // Assert
        assertNotNull(transformer);
    }

    @Test
    public void testInvokerTransformer_WithEmptyArgs() {
        // Arrange
        String methodName = "substring";
        Class<?>[] paramTypes = new Class<?>[] { int.class, int.class };
        Object[] args = new Object[] {};
        // Act
        InvokerTransformer transformer = new InvokerTransformer(methodName, paramTypes, args);
        // Assert
        assertNotNull(transformer);
    }
}
