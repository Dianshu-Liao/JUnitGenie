package com.fasterxml.jackson.core;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
// Added import for Method
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class Base64Variant_usesPaddingChar_11_0_Test {

    private Base64Variant base64Variant;

    @BeforeEach
    public void setUp() {
        base64Variant = new Base64Variant("Test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    }

    @Test
    public void testUsesPaddingChar_WithPaddingChar_ReturnsTrue() throws Exception {
        Method method = Base64Variant.class.getDeclaredMethod("usesPaddingChar", int.class);
        method.setAccessible(true);
        // Test with the padding character
        boolean result = (boolean) method.invoke(base64Variant, '=');
        assertTrue(result, "Expected true when input is the padding character.");
    }

    @Test
    public void testUsesPaddingChar_WithNonPaddingChar_ReturnsFalse() throws Exception {
        Method method = Base64Variant.class.getDeclaredMethod("usesPaddingChar", int.class);
        method.setAccessible(true);
        // Test with a non-padding character
        boolean result = (boolean) method.invoke(base64Variant, 'A');
        assertFalse(result, "Expected false when input is not the padding character.");
    }

    @Test
    public void testUsesPaddingChar_WithDifferentNonPaddingChar_ReturnsFalse() throws Exception {
        Method method = Base64Variant.class.getDeclaredMethod("usesPaddingChar", int.class);
        method.setAccessible(true);
        // Test with another non-padding character
        boolean result = (boolean) method.invoke(base64Variant, ' ');
        assertFalse(result, "Expected false when input is not the padding character.");
    }
}
