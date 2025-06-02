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

public class Base64_isInAlphabet_23_0_Test {

    private Base64 base64;

    @BeforeEach
    public void setUp() {
        base64 = new Base64();
    }

    @Test
    public void testIsInAlphabet_ValidStandardAlphabetCharacters() {
        // Test for valid characters in the standard Base64 alphabet
        byte[] validStandardAlphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
        for (byte b : validStandardAlphabet) {
            assertTrue(base64.isInAlphabet(b), "Failed for valid character: " + (char) b);
        }
    }

    @Test
    public void testIsInAlphabet_ValidUrlSafeAlphabetCharacters() {
        // Test for valid characters in the URL-safe Base64 alphabet
        byte[] validUrlSafeAlphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_' };
        for (byte b : validUrlSafeAlphabet) {
            assertTrue(base64.isInAlphabet(b), "Failed for valid URL-safe character: " + (char) b);
        }
    }

//    @Test
//    public void testIsInAlphabet_InvalidCharacters() {
//        // Test for invalid characters (outside the Base64 alphabet)
//        for (byte i = 0; i < 256; i++) {
//            if (i < 0 || (i > 127 && i < 256)) {
//                // Out of range for valid Base64
//                assertFalse(base64.isInAlphabet(i), "Failed for invalid character: " + (char) i);
//            }
//        }
//        // Additional invalid characters outside the range
//        assertFalse(base64.isInAlphabet((byte) -1), "Failed for invalid character: -1");
//        assertFalse(base64.isInAlphabet((byte) 128), "Failed for invalid character: 128");
//    }
}
