package com.fasterxml.jackson.core;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Base64Variant_decodeBase64Byte_18_0_Test {

    private Base64Variant base64Variant;

    @BeforeEach
    void setUp() {
        // Initialize the Base64Variant with dummy parameters
        base64Variant = new Base64Variant("dummy", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        // Set up the _asciiToBase64 array for testing
        setPrivateField(base64Variant, "_asciiToBase64", new int[128]);
        try {
            for (int i = 0; i < 64; i++) {
                base64Variant.getClass().getDeclaredField("_asciiToBase64").setInt(base64Variant, i);
            }
            // Set values for the last two valid Base64 characters
            base64Variant.getClass().getDeclaredField("_asciiToBase64").setInt(base64Variant, 62);
            base64Variant.getClass().getDeclaredField("_asciiToBase64").setInt(base64Variant, 63);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testDecodeBase64Byte_ValidCharacters() {
        assertEquals(0, base64Variant.decodeBase64Byte((byte) 'A'));
        assertEquals(25, base64Variant.decodeBase64Byte((byte) 'Z'));
        assertEquals(26, base64Variant.decodeBase64Byte((byte) 'a'));
        assertEquals(51, base64Variant.decodeBase64Byte((byte) 'z'));
        assertEquals(62, base64Variant.decodeBase64Byte((byte) '+'));
        assertEquals(63, base64Variant.decodeBase64Byte((byte) '/'));
    }

    @Test
    void testDecodeBase64Byte_InvalidCharacter() {
        // Out of valid range
        assertEquals(Base64Variant.BASE64_VALUE_INVALID, base64Variant.decodeBase64Byte((byte) 127));
        // Negative value
        assertEquals(Base64Variant.BASE64_VALUE_INVALID, base64Variant.decodeBase64Byte((byte) -1));
        // Space character
        assertEquals(Base64Variant.BASE64_VALUE_INVALID, base64Variant.decodeBase64Byte((byte) ' '));
    }

    @Test
    void testDecodeBase64Byte_NonBase64Characters() {
        // Should return invalid
        assertEquals(Base64Variant.BASE64_VALUE_INVALID, base64Variant.decodeBase64Byte((byte) '0'));
        // Should return invalid
        assertEquals(Base64Variant.BASE64_VALUE_INVALID, base64Variant.decodeBase64Byte((byte) '9'));
        // Should return invalid
        assertEquals(Base64Variant.BASE64_VALUE_INVALID, base64Variant.decodeBase64Byte((byte) '#'));
        // Should return invalid
        assertEquals(Base64Variant.BASE64_VALUE_INVALID, base64Variant.decodeBase64Byte((byte) '@'));
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
