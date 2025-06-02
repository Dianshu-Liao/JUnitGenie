package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

public class Blake3_initKeyedHash_6_0_Test {

    @Test
    public void testInitKeyedHash_ValidKey() {
        // A valid key of 32 bytes
        byte[] validKey = new byte[32];
        Blake3 instance = Blake3.initKeyedHash(validKey);
        assertNotNull(instance);
    }

    @Test
    public void testInitKeyedHash_NullKey() {
        assertThrows(NullPointerException.class, () -> {
            Blake3.initKeyedHash(null);
        });
    }

    @Test
    public void testInitKeyedHash_InvalidKeyLength() {
        // Invalid key of 31 bytes
        byte[] invalidKey31 = new byte[31];
        assertThrows(IllegalArgumentException.class, () -> {
            Blake3.initKeyedHash(invalidKey31);
        });
        // Invalid key of 33 bytes
        byte[] invalidKey33 = new byte[33];
        assertThrows(IllegalArgumentException.class, () -> {
            Blake3.initKeyedHash(invalidKey33);
        });
    }

    @Test
    public void testInitKeyedHash_EmptyKey() {
        // Invalid key of 0 bytes
        byte[] emptyKey = new byte[0];
        assertThrows(IllegalArgumentException.class, () -> {
            Blake3.initKeyedHash(emptyKey);
        });
    }

    // Reflection-based test for private method unpackInts
    @Test
    public void testUnpackInts() throws Exception {
        Method method = Blake3.class.getDeclaredMethod("unpackInts", byte[].class, int.class);
        method.setAccessible(true);
        byte[] key = new byte[32];
        for (int i = 0; i < key.length; i++) {
            key[i] = (byte) i;
        }
        int[] result = (int[]) method.invoke(null, key, 8);
        assertEquals(8, result.length);
        assertEquals(0x01020304, result[0]);
        assertEquals(0x05060708, result[1]);
        assertEquals(0x090A0B0C, result[2]);
        assertEquals(0x0D0E0F10, result[3]);
        assertEquals(0x11121314, result[4]);
        assertEquals(0x15161718, result[5]);
        assertEquals(0x191A1B1C, result[6]);
        assertEquals(0x1D1E1F20, result[7]);
    }
}
