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

public class InvokerTransformer_InvokerTransformer_3_1_Test {

    @Test
    public void testInvokerTransformerWithValidMethodName() {
        // Arrange
        String methodName = "toString";
        InvokerTransformer transformer = new InvokerTransformer(methodName, null, null);
        // Act
        assertNotNull(transformer);
    }

    @Test
    public void testInvokerTransformerWithNullMethodName() {
        // Arrange
        String methodName = null;
        InvokerTransformer transformer = new InvokerTransformer(methodName, null, null);
        // Act
        assertNotNull(transformer);
    }

    @Test
    public void testInvokerTransformerWithEmptyMethodName() {
        // Arrange
        String methodName = "";
        InvokerTransformer transformer = new InvokerTransformer(methodName, null, null);
        // Act
        assertNotNull(transformer);
    }

    @Test
    public void testInvokerTransformerWithSpecialCharacterMethodName() {
        // Arrange
        String methodName = "someMethod$@#";
        InvokerTransformer transformer = new InvokerTransformer(methodName, null, null);
        // Act
        assertNotNull(transformer);
    }
}
