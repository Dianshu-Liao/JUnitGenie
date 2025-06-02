package org.apache.commons.codec.binary;

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

public class Base64_Base64_29_1_Test {

    private Base64 base64Standard;

    private Base64 base64UrlSafe;

    @BeforeEach
    public void setUp() {
        base64Standard = new Base64();
        base64UrlSafe = new Base64(true);
    }

    @Test
    public void testBase64StandardEncoding() {
        String input = "Hello";
        byte[] encoded = base64Standard.encode(input.getBytes());
        // Base64 encoding of "Hello"
        String expected = "SGVsbG8=";
        assertArrayEquals(expected.getBytes(), encoded);
    }

    @Test
    public void testBase64UrlSafeEncoding() {
        String input = "Hello/World";
        byte[] encoded = base64UrlSafe.encode(input.getBytes());
        // URL-safe Base64 encoding of "Hello/World"
        String expected = "SGVsbG9Xb3Js";
        assertArrayEquals(expected.getBytes(), encoded);
    }

    @Test
    public void testBase64StandardDecoding() {
        // Base64 encoding of "Hello"
        String input = "SGVsbG8=";
        byte[] decoded = base64Standard.decode(input);
        String expected = "Hello";
        assertEquals(expected, new String(decoded));
    }

    @Test
    public void testBase64UrlSafeDecoding() {
        // URL-safe Base64 encoding of "Hello/World"
        String input = "SGVsbG9Xb3Js";
        byte[] decoded = base64UrlSafe.decode(input);
        String expected = "Hello/World";
        assertEquals(expected, new String(decoded));
    }

    @Test
    public void testBase64EmptyStringEncoding() {
        String input = "";
        byte[] encoded = base64Standard.encode(input.getBytes());
        // Base64 encoding of an empty string
        String expected = "";
        assertArrayEquals(expected.getBytes(), encoded);
    }

    @Test
    public void testBase64EmptyStringDecoding() {
        // Base64 encoding of an empty string
        String input = "";
        byte[] decoded = base64Standard.decode(input);
        String expected = "";
        assertEquals(expected, new String(decoded));
    }

    @Test
    public void testBase64InvalidInputDecoding() {
        String input = "InvalidBase64@#";
        assertThrows(IllegalArgumentException.class, () -> {
            base64Standard.decode(input);
        });
    }
}
