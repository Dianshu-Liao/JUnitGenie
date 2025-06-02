package com.fasterxml.jackson.core;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class Base64Variant_usesPaddingChar_10_0_Test {

    private Base64Variant base64Variant;

    @BeforeEach
    public void setUp() {
        // Initialize with a padding character, for example '='
        base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    }

    @Test
    public void testUsesPaddingChar_withPaddingChar() {
        assertTrue(base64Variant.usesPaddingChar('='));
    }

    @Test
    public void testUsesPaddingChar_withDifferentChar() {
        assertFalse(base64Variant.usesPaddingChar('A'));
    }

    @Test
    public void testUsesPaddingChar_withNullChar() {
        assertFalse(base64Variant.usesPaddingChar('\0'));
    }

    @Test
    public void testUsesPaddingChar_withAnotherChar() {
        assertFalse(base64Variant.usesPaddingChar('B'));
    }

    @Test
    public void testUsesPaddingChar_withWhitespace() {
        assertFalse(base64Variant.usesPaddingChar(' '));
    }

    @Test
    public void testUsesPaddingChar_withInvalidChar() {
        assertFalse(base64Variant.usesPaddingChar('!'));
    }

    @Test
    public void testUsesPaddingChar_withUpperCase() {
        assertFalse(base64Variant.usesPaddingChar('Z'));
    }

    @Test
    public void testUsesPaddingChar_withLowerCase() {
        assertFalse(base64Variant.usesPaddingChar('z'));
    }

    @Test
    public void testUsesPaddingChar_withDigit() {
        assertFalse(base64Variant.usesPaddingChar('0'));
    }

    @Test
    public void testUsesPaddingChar_withSpecialChar() {
        assertFalse(base64Variant.usesPaddingChar('@'));
    }

    @Test
    public void testUsesPaddingChar_withEqualChar() {
        Base64Variant variantWithDifferentPadding = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        assertTrue(variantWithDifferentPadding.usesPaddingChar('='));
    }

    @Test
    public void testUsesPaddingChar_withOtherPaddingChar() {
        Base64Variant variantWithDifferentPadding = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '*', 76);
        assertFalse(variantWithDifferentPadding.usesPaddingChar('='));
    }

    @Test
    public void testUsesPaddingChar_withDifferentPaddingChar() {
        Base64Variant variantWithDifferentPadding = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '-', 76);
        assertFalse(variantWithDifferentPadding.usesPaddingChar('='));
    }

    @Test
    public void testUsesPaddingChar_withNullPaddingChar() {
        Base64Variant variantWithNullPadding = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '\0', 76);
        assertFalse(variantWithNullPadding.usesPaddingChar('='));
    }

    @Test
    public void testUsesPaddingChar_withPaddingCharNone() {
        Base64Variant variantWithNonePadding = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", false, '\0', 76);
        assertFalse(variantWithNonePadding.usesPaddingChar('='));
    }
}
