package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Objects;

public class Blake3_initKeyedHash_6_0_Test {

    @Test
    public void testInitKeyedHash_ValidKey() {
        // A valid 32-byte key
        byte[] validKey = new byte[32];
        Blake3 instance = Blake3.initKeyedHash(validKey);
        assertNotNull(instance, "The instance should not be null for a valid key.");
    }

    @Test
    public void testInitKeyedHash_NullKey() {
        assertThrows(NullPointerException.class, () -> {
            Blake3.initKeyedHash(null);
        }, "Expected to throw NullPointerException for null key.");
    }

    @Test
    public void testInitKeyedHash_InvalidKeyLength() {
        // An invalid key (31 bytes)
        byte[] shortKey = new byte[31];
        assertThrows(IllegalArgumentException.class, () -> {
            Blake3.initKeyedHash(shortKey);
        }, "Expected to throw IllegalArgumentException for key shorter than 32 bytes.");
        // An invalid key (33 bytes)
        byte[] longKey = new byte[33];
        assertThrows(IllegalArgumentException.class, () -> {
            Blake3.initKeyedHash(longKey);
        }, "Expected to throw IllegalArgumentException for key longer than 32 bytes.");
    }

    @Test
    public void testInitKeyedHash_EmptyKey() {
        // An invalid key (0 bytes)
        byte[] emptyKey = new byte[0];
        assertThrows(IllegalArgumentException.class, () -> {
            Blake3.initKeyedHash(emptyKey);
        }, "Expected to throw IllegalArgumentException for empty key.");
    }
}
