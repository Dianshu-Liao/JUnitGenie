package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.Blake3;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Objects;

class Blake3_initKeyedHash_6_0_Test {

    @Test
    void testInitKeyedHash_ValidKey() {
        // Valid key of length 32 bytes
        byte[] key = new byte[32];
        Blake3 instance = Blake3.initKeyedHash(key);
        assertNotNull(instance);
    }

    @Test
    void testInitKeyedHash_NullKey() {
        assertThrows(NullPointerException.class, () -> Blake3.initKeyedHash(null));
    }

    @Test
    void testInitKeyedHash_InvalidKeyLength() {
        // Invalid key of length less than 32 bytes
        byte[] shortKey = new byte[31];
        assertThrows(IllegalArgumentException.class, () -> Blake3.initKeyedHash(shortKey));
        // Invalid key of length more than 32 bytes
        byte[] longKey = new byte[33];
        assertThrows(IllegalArgumentException.class, () -> Blake3.initKeyedHash(longKey));
    }

    @Test
    void testInitKeyedHash_CreatesNewInstance() {
        byte[] key = new byte[32];
        Blake3 instance1 = Blake3.initKeyedHash(key);
        Blake3 instance2 = Blake3.initKeyedHash(key);
        assertNotSame(instance1, instance2);
    }
}
