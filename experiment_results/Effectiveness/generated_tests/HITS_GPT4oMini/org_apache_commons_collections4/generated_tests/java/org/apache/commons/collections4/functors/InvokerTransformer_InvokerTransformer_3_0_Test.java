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

public class InvokerTransformer_InvokerTransformer_3_0_Test {

    @Test
    public void testInvokerTransformerInitialization() {
        // Arrange
        String methodName = "testMethod";
        // No parameters
        Class<?>[] paramTypes = new Class<?>[0];
        // No arguments
        Object[] args = new Object[0];
        // Act
        InvokerTransformer invokerTransformer = new InvokerTransformer(methodName, paramTypes, args);
        // Assert
        assertNotNull(invokerTransformer, "InvokerTransformer should be initialized.");
    }
}
