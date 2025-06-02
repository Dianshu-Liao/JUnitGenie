package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.binary.Base64;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Base64_Base64_32_0_Test {

    private Base64 base64;

    @BeforeEach
    void setUp() {
        byte[] lineSeparator = new byte[] { '\n' };
        // Pass null for CodecPolicy
        base64 = new Base64(76, lineSeparator, false, null);
    }

    @Test
    void testBase64Constructor() {
        assertNotNull(base64);
    }

    @Test
    void testBase64PrivateConstructor() throws Exception {
        Constructor<Base64> constructor = Base64.class.getDeclaredConstructor(int.class, byte[].class, byte.class, byte[].class, CodecPolicy.class);
        constructor.setAccessible(true);
        // Pass null for CodecPolicy
        Base64 base64Instance = constructor.newInstance(76, new byte[] { '\n' }, (byte) '=', new byte[64], null);
        assertNotNull(base64Instance);
    }

    @Test
    void testBase64LineSeparator() {
        byte[] expectedSeparator = new byte[] { '\n' };
        assertArrayEquals(expectedSeparator, base64.getLineSeparator());
    }

    @Test
    void testBase64EncodeTable() throws Exception {
        Method method = Base64.class.getDeclaredMethod("toUrlSafeEncodeTable", boolean.class);
        method.setAccessible(true);
        byte[] encodeTable = (byte[]) method.invoke(null, false);
        assertEquals(64, encodeTable.length);
    }

    @Test
    void testBase64DecodeTable() throws Exception {
        Method method = Base64.class.getDeclaredMethod("calculateDecodeTable", byte[].class);
        method.setAccessible(true);
        byte[] decodeTable = (byte[]) method.invoke(base64, new byte[64]);
        assertNotNull(decodeTable);
        assertEquals(256, decodeTable.length);
    }

    @Test
    void testBase64ConstructorWithInvalidLineSeparator() {
        assertThrows(IllegalArgumentException.class, () -> {
            // Pass null for CodecPolicy
            new Base64(76, new byte[] { 'A' }, false, null);
        });
    }
}
