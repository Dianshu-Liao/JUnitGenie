package org.apache.commons.codec.binary;

import java.lang.reflect.Method;
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

    private final Base64 base64 = new Base64();

    @Test
    public void testIsInAlphabet_ValidCharacter() throws Exception {
        Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
        method.setAccessible(true);
        // Test with characters that are in the alphabet
        assertTrue((Boolean) method.invoke(base64, (byte) 'A'));
        assertTrue((Boolean) method.invoke(base64, (byte) 'a'));
        assertTrue((Boolean) method.invoke(base64, (byte) '0'));
        assertTrue((Boolean) method.invoke(base64, (byte) '+'));
        assertTrue((Boolean) method.invoke(base64, (byte) '/'));
    }

    @Test
    public void testIsInAlphabet_InvalidCharacter() throws Exception {
        Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
        method.setAccessible(true);
        // Test with characters that are not in the alphabet
        // Out of range
        assertFalse((Boolean) method.invoke(base64, (byte) -1));
        // 'B' not in decodeTable
        assertFalse((Boolean) method.invoke(base64, (byte) 65));
        // Out of range
        assertFalse((Boolean) method.invoke(base64, (byte) 128));
        // Out of range
        assertFalse((Boolean) method.invoke(base64, (byte) 255));
    }

    @Test
    public void testIsInAlphabet_BoundaryValues() throws Exception {
        Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
        method.setAccessible(true);
        // Test boundary values
        // Just above the alphabet range
        assertFalse((Boolean) method.invoke(base64, (byte) 64));
        // Valid character '+'
        assertTrue((Boolean) method.invoke(base64, (byte) 62));
        // Valid character '/'
        assertTrue((Boolean) method.invoke(base64, (byte) 63));
    }
}
