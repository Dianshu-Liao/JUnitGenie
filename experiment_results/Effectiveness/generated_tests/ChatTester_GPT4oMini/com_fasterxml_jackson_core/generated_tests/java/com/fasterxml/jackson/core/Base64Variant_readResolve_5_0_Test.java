package com.fasterxml.jackson.core;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Base64Variant_readResolve_5_0_Test {

    private Base64Variant base64Variant;

    @BeforeEach
    public void setUp() {
        // Initialize with some test data
        base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    }

    @Test
    public void testReadResolve_EqualProperties() throws Exception {
        // Arrange
        Base64Variant expected = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        // Act
        Object result = invokeReadResolve(base64Variant);
        // Assert
        assertSame(expected, result);
    }

    @Test
    public void testReadResolve_DifferentProperties() throws Exception {
        // Arrange
        Base64Variant base64VariantDifferent = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", false, '-', 100);
        // Act
        Object result = invokeReadResolve(base64VariantDifferent);
        // Assert
        assertNotSame(base64VariantDifferent, result);
        assertTrue(result instanceof Base64Variant);
    }

    private Object invokeReadResolve(Base64Variant base64Variant) throws Exception {
        Method method = Base64Variant.class.getDeclaredMethod("readResolve");
        method.setAccessible(true);
        return method.invoke(base64Variant);
    }
}
