package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class Base64Variant_usesPaddingChar_10_0_Test {

    private Base64Variant base64VariantWithPadding;

    private Base64Variant base64VariantWithoutPadding;

    @BeforeEach
    public void setUp() {
        base64VariantWithPadding = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        base64VariantWithoutPadding = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", false, '\0', 76);
    }

    @Test
    public void testUsesPaddingChar_WithPaddingChar_ReturnsTrue() {
        assertTrue(base64VariantWithPadding.usesPaddingChar('='));
    }

    @Test
    public void testUsesPaddingChar_WithoutPaddingChar_ReturnsFalse() {
        assertFalse(base64VariantWithoutPadding.usesPaddingChar('='));
    }

    @Test
    public void testUsesPaddingChar_WithDifferentChar_ReturnsFalse() {
        assertFalse(base64VariantWithPadding.usesPaddingChar('A'));
        assertFalse(base64VariantWithoutPadding.usesPaddingChar('A'));
    }

    @Test
    public void testUsesPaddingChar_WithNullChar_ReturnsFalse() {
        assertFalse(base64VariantWithPadding.usesPaddingChar('\0'));
    }

    @Test
    public void testUsesPaddingChar_WithSpaceChar_ReturnsFalse() {
        assertFalse(base64VariantWithPadding.usesPaddingChar(' '));
        assertFalse(base64VariantWithoutPadding.usesPaddingChar(' '));
    }
}
