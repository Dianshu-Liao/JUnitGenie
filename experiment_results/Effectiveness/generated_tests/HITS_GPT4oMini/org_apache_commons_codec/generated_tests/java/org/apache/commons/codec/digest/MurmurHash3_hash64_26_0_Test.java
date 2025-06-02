package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash64_26_0_Test {

    @Test
    public void testHash64_withPositiveShort() {
        short input = 12345;
        // Replace with the actual expected value
        long expectedHash = 0x5c1a6efc8bf5e2c3L;
        long actualHash = MurmurHash3.hash64(input);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_withNegativeShort() {
        short input = -12345;
        // Replace with the actual expected value
        long expectedHash = 0x7b4e8e9c4b9e3c52L;
        long actualHash = MurmurHash3.hash64(input);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_withZero() {
        short input = 0;
        // Replace with the actual expected value
        long expectedHash = 0x31b6a9f2c6e4e4efL;
        long actualHash = MurmurHash3.hash64(input);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_withMaxShort() {
        short input = Short.MAX_VALUE;
        // Replace with the actual expected value
        long expectedHash = 0x9a3c5e9a2a4e2a3cL;
        long actualHash = MurmurHash3.hash64(input);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_withMinShort() {
        short input = Short.MIN_VALUE;
        // Replace with the actual expected value
        long expectedHash = 0x7f4e8e9c4b9e3c52L;
        long actualHash = MurmurHash3.hash64(input);
        assertEquals(expectedHash, actualHash);
    }
}
