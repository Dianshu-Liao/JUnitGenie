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

public class Base64_isInAlphabet_23_1_Test {

    private Base64 base64;

    @BeforeEach
    public void setUp() {
        base64 = new Base64();
    }

    @Test
    public void testIsInAlphabet_ValidCharacter() throws Exception {
        Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
        method.setAccessible(true);
        // Test with valid Base64 characters
        // 0
        assertTrue((Boolean) method.invoke(base64, (byte) 'A'));
        // 26
        assertTrue((Boolean) method.invoke(base64, (byte) 'a'));
        // 52
        assertTrue((Boolean) method.invoke(base64, (byte) '0'));
        // 62
        assertTrue((Boolean) method.invoke(base64, (byte) '+'));
        // 63
        assertTrue((Boolean) method.invoke(base64, (byte) '/'));
    }

    @Test
    public void testIsInAlphabet_InvalidCharacter() throws Exception {
        Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
        method.setAccessible(true);
        // Test with invalid Base64 characters
        // 32
        assertFalse((Boolean) method.invoke(base64, (byte) ' '));
        // 91
        assertFalse((Boolean) method.invoke(base64, (byte) 'Z' + 1));
        // -1
        assertFalse((Boolean) method.invoke(base64, (byte) -1));
        // 128
        assertFalse((Boolean) method.invoke(base64, (byte) 128));
    }

    @Test
    public void testIsInAlphabet_BoundaryValues() throws Exception {
        Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
        method.setAccessible(true);
        // Test boundary values
        // Out of range
        assertFalse((Boolean) method.invoke(base64, (byte) 64));
        // Out of range
        assertFalse((Boolean) method.invoke(base64, (byte) -1));
    }
}
