package com.fasterxml.jackson.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class Base64Variant_decodeBase64Byte_18_0_Test {

    private Base64Variant base64Variant;

    @BeforeEach
    public void setUp() {
        // Initialize the Base64Variant with a valid configuration
        String name = "TestVariant";
        // Example base64 alphabet
        String base64Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        boolean writePadding = true;
        char paddingChar = '=';
        int maxLineLength = 76;
        base64Variant = new Base64Variant(name, base64Alphabet, writePadding, paddingChar, maxLineLength);
        // Populate _asciiToBase64 for testing, assuming valid base64 chars
        setAsciiToBase64(base64Variant);
        // Set padding character
        setPaddingCharacter(base64Variant, paddingChar);
    }

    private void setAsciiToBase64(Base64Variant variant) {
        try {
            Field field = Base64Variant.class.getDeclaredField("_asciiToBase64");
            field.setAccessible(true);
            int[] asciiToBase64 = (int[]) field.get(variant);
            for (int i = 0; i < 64; i++) {
                asciiToBase64[i] = i;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setPaddingCharacter(Base64Variant variant, char paddingChar) {
        try {
            Field field = Base64Variant.class.getDeclaredField("_asciiToBase64");
            field.setAccessible(true);
            int[] asciiToBase64 = (int[]) field.get(variant);
            asciiToBase64[paddingChar] = Base64Variant.BASE64_VALUE_PADDING;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDecodeBase64Byte_ValidCharacter() {
        // Test valid base64 character
        byte input = 'A';
        int expected = 0;
        int result = invokeDecodeBase64Byte(input);
        assertEquals(expected, result);
    }

    @Test
    public void testDecodeBase64Byte_ValidCharacter_B() {
        // Test another valid base64 character
        byte input = 'B';
        int expected = 1;
        int result = invokeDecodeBase64Byte(input);
        assertEquals(expected, result);
    }

    @Test
    public void testDecodeBase64Byte_InvalidCharacter() {
        // Test invalid character
        byte input = ' ';
        int expected = Base64Variant.BASE64_VALUE_INVALID;
        int result = invokeDecodeBase64Byte(input);
        assertEquals(expected, result);
    }

    @Test
    public void testDecodeBase64Byte_NegativeValue() {
        // Test negative byte value
        byte input = -1;
        int expected = Base64Variant.BASE64_VALUE_INVALID;
        int result = invokeDecodeBase64Byte(input);
        assertEquals(expected, result);
    }

    private int invokeDecodeBase64Byte(byte input) {
        try {
            Method method = Base64Variant.class.getDeclaredMethod("decodeBase64Byte", byte.class);
            method.setAccessible(true);
            return (int) method.invoke(base64Variant, input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
