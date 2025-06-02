package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.Base64Variant;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class Base64Variant_encode_27_0_Test {

    private Base64Variant base64Variant;

    @BeforeEach
    public void setUp() {
        base64Variant = new Base64Variant("TestVariant", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    }

    @Test
    public void testEncode_EmptyArray() throws Exception {
        byte[] input = {};
        String result = invokeEncode(input);
        assertEquals("", result);
    }

    @Test
    public void testEncode_SingleByte() throws Exception {
        // 'A'
        byte[] input = { 0b01000001 };
        String result = invokeEncode(input);
        assertEquals("QQ==", result);
    }

    @Test
    public void testEncode_TwoBytes() throws Exception {
        // 'AB'
        byte[] input = { 0b01000001, 0b01000010 };
        String result = invokeEncode(input);
        assertEquals("QUI=", result);
    }

    @Test
    public void testEncode_ThreeBytes() throws Exception {
        // 'ABC'
        byte[] input = { 0b01000001, 0b01000010, 0b01000011 };
        String result = invokeEncode(input);
        assertEquals("QUJD", result);
    }

    @Test
    public void testEncode_MultipleBytes() throws Exception {
        // 'ABCD'
        byte[] input = { 0b01000001, 0b01000010, 0b01000011, 0b01000100 };
        String result = invokeEncode(input);
        assertEquals("QUJDRA==", result);
    }

    private String invokeEncode(byte[] input) throws Exception {
        Method method = Base64Variant.class.getDeclaredMethod("encode", byte[].class);
        method.setAccessible(true);
        return (String) method.invoke(base64Variant, (Object) input);
    }
}
