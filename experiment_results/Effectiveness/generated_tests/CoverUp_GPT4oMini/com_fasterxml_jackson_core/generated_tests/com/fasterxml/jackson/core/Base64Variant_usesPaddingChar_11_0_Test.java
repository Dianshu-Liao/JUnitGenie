package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class Base64Variant_usesPaddingChar_11_0_Test {

    private Base64Variant base64Variant;

    @BeforeEach
    public void setUp() {
        // Initialize Base64Variant with a padding character (for example, '=')
        base64Variant = new Base64Variant("TestVariant", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    }

    @Test
    public void testUsesPaddingChar_WithPaddingChar() {
        assertTrue(base64Variant.usesPaddingChar('='));
    }

    @Test
    public void testUsesPaddingChar_WithDifferentChar() {
        assertFalse(base64Variant.usesPaddingChar('A'));
    }

    @Test
    public void testUsesPaddingChar_WithNullChar() {
        Base64Variant variantWithoutPadding = new Base64Variant("TestVariant", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", false, '\0', 76);
        assertFalse(variantWithoutPadding.usesPaddingChar('\0'));
    }

    @Test
    public void testUsesPaddingChar_WithAnotherChar() {
        // Testing with null character
        assertFalse(base64Variant.usesPaddingChar('\u0000'));
    }

    @Test
    public void testUsesPaddingChar_WithEdgeCase() {
        // Testing with space
        assertFalse(base64Variant.usesPaddingChar(' '));
    }

    @Test
    public void testUsesPaddingChar_WithSpecialChar() {
        // Testing with a special character
        assertFalse(base64Variant.usesPaddingChar('@'));
    }
}
