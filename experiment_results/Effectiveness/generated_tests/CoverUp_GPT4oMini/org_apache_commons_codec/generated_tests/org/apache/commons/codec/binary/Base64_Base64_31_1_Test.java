package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

class Base64_Base64_31_1_Test {

    private Base64 base64;

    @BeforeEach
    void setUp() {
        // Initialize Base64 with default parameters
        base64 = new Base64(76, new byte[] { '\r', '\n' }, false);
    }

    @Test
    void testBase64ConstructorWithLineLength() {
        assertNotNull(base64);
        assertArrayEquals(new byte[] { '\r', '\n' }, base64.getLineSeparator());
    }

    @Test
    void testBase64ConstructorWithUrlSafe() {
        Base64 urlSafeBase64 = new Base64(76, new byte[] { '\r', '\n' }, true);
        assertNotNull(urlSafeBase64);
    }

    @Test
    void testBase64ConstructorWithNullLineSeparator() {
        Base64 nullSeparatorBase64 = new Base64(76, null, false);
        assertNotNull(nullSeparatorBase64);
        assertNull(nullSeparatorBase64.getLineSeparator());
    }

    @Test
    void testBase64ConstructorInvalidLineSeparator() {
        byte[] invalidSeparator = new byte[] { 'A' };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Base64(76, invalidSeparator, false);
        });
        assertEquals("lineSeparator must not contain base64 characters: [A]", exception.getMessage());
    }

    @Test
    void testPrivateConstructorUsingReflection() throws Exception {
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(int.class, byte[].class, byte.class, byte[].class, CodecPolicy.class);
        constructor.setAccessible(true);
        Base64 customBase64 = constructor.newInstance(76, new byte[] { '\r', '\n' }, (byte) '=', new byte[] { 'A', 'B', 'C' }, null);
        assertNotNull(customBase64);
    }

    @Test
    void testPrivateMethodUsingReflection() throws Exception {
        Method method = Base64.class.getDeclaredMethod("toUrlSafeEncodeTable", boolean.class);
        method.setAccessible(true);
        byte[] result = (byte[]) method.invoke(null, true);
        assertArrayEquals(new byte[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_' }, result);
    }
}
