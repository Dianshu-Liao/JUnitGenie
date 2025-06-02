package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Arrays;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Base64_Base64_27_0_Test {

    private Base64 base64;

    @BeforeEach
    void setUp() {
        base64 = new Base64();
    }

    @Test
    void testEncodeBase64() {
        byte[] input = "Hello".getBytes();
        byte[] encoded = Base64.encodeBase64(input);
        assertNotNull(encoded);
        assertEquals("SGVsbG8=", new String(encoded));
    }

    @Test
    void testDecodeBase64() {
        byte[] decoded = Base64.decodeBase64("SGVsbG8=");
        assertNotNull(decoded);
        assertEquals("Hello", new String(decoded));
    }

    @Test
    void testEncodeBase64UrlSafe() {
        byte[] input = "Hello/World".getBytes();
        byte[] encoded = Base64.encodeBase64URLSafe(input);
        assertNotNull(encoded);
        assertEquals("SGVsbG9sV29ybGQ=", new String(encoded));
    }

    @Test
    void testDecodeBase64UrlSafe() {
        byte[] decoded = Base64.decodeBase64("SGVsbG9sV29ybGQ=");
        assertNotNull(decoded);
        assertEquals("Hello/World", new String(decoded));
    }

    @Test
    void testEncodeInteger() {
        BigInteger bigInteger = BigInteger.valueOf(123456);
        byte[] encoded = Base64.encodeInteger(bigInteger);
        assertNotNull(encoded);
        assertEquals("MTIzNDU2", new String(encoded));
    }

    @Test
    void testDecodeInteger() {
        byte[] encoded = Base64.encodeInteger(BigInteger.valueOf(123456));
        BigInteger decoded = Base64.decodeInteger(encoded);
        assertEquals(BigInteger.valueOf(123456), decoded);
    }

    @Test
    void testIsBase64() {
        assertTrue(Base64.isBase64("SGVsbG8="));
        assertFalse(Base64.isBase64("InvalidBase64"));
    }

    @Test
    void testCalculateDecodeTable() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(int.class, byte[].class, byte.class, byte[].class, CodecPolicy.class);
        constructor.setAccessible(true);
        Base64 base64Instance = constructor.newInstance(0, null, (byte) 0, toStandardEncodeTable(), null);
        byte[] decodeTable = (byte[]) Base64.class.getDeclaredMethod("calculateDecodeTable", byte[].class).invoke(base64Instance, toStandardEncodeTable());
        assertNotNull(decodeTable);
        assertEquals(-1, decodeTable[0]);
        assertEquals(0, decodeTable['A']);
        assertEquals(62, decodeTable['+']);
        assertEquals(63, decodeTable['/']);
    }

    @Test
    void testGetLineSeparator() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        byte[] lineSeparator = (byte[]) Base64.class.getDeclaredMethod("getLineSeparator").invoke(base64);
        assertNotNull(lineSeparator);
        assertArrayEquals(new byte[] { '\r', '\n' }, lineSeparator);
    }

    private byte[] toStandardEncodeTable() {
        return new byte[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
    }
}
