package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base64;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

class Base64_Base64_28_0_Test {

    @Test
    void testBase64ConstructorWithUrlSafeTrue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base64 base64 = constructor.newInstance(true);
        assertNotNull(base64);
        assertTrue(base64.isUrlSafe());
    }

    @Test
    void testBase64ConstructorWithUrlSafeFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base64 base64 = constructor.newInstance(false);
        assertNotNull(base64);
        assertFalse(base64.isUrlSafe());
    }

    @Test
    void testBase64EncodeTable() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base64 base64 = constructor.newInstance(false);
        // Test encoding a simple string
        byte[] input = "Hello".getBytes();
        byte[] encoded = Base64.encodeBase64(input);
        String encodedString = new String(encoded);
        assertEquals("SGVsbG8=", encodedString);
    }

    @Test
    void testBase64DecodeTable() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base64 base64 = constructor.newInstance(false);
        // Test decoding a simple encoded string
        String encodedString = "SGVsbG8=";
        byte[] decoded = Base64.decodeBase64(encodedString);
        String decodedString = new String(decoded);
        assertEquals("Hello", decodedString);
    }

    @Test
    void testBase64UrlSafeEncoding() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base64 base64 = constructor.newInstance(true);
        // Test URL-safe encoding
        byte[] input = "Hello/World".getBytes();
        byte[] encoded = Base64.encodeBase64URLSafe(input);
        String encodedString = new String(encoded);
        assertEquals("SGVsbG9Xb3Js", encodedString);
    }

    @Test
    void testBase64UrlSafeDecoding() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base64 base64 = constructor.newInstance(true);
        // Test URL-safe decoding
        String encodedString = "SGVsbG9Xb3Js";
        byte[] decoded = Base64.decodeBase64(encodedString);
        String decodedString = new String(decoded);
        assertEquals("Hello/World", decodedString);
    }
}
