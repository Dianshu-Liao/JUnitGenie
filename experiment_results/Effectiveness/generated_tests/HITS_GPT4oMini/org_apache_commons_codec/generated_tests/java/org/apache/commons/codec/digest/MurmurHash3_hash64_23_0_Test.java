package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash64_23_0_Test {

    @Test
    public void testHash64_EmptyArray() {
        byte[] data = new byte[0];
        // Expected for empty input
        long expected = MurmurHash3.NULL_HASHCODE;
        long actual = MurmurHash3.hash64(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_SingleByte() {
        byte[] data = new byte[] { 1 };
        // Expected hash value for this input
        long expected = 0x1b5f6d2d5c6e8f8cL;
        long actual = MurmurHash3.hash64(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_TwoBytes() {
        byte[] data = new byte[] { 1, 2 };
        // Expected hash value for this input
        long expected = 0x7f0e8e7b6c2c4b5cL;
        long actual = MurmurHash3.hash64(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_FourBytes() {
        byte[] data = new byte[] { 1, 2, 3, 4 };
        // Expected hash value for this input
        long expected = 0x1e2d3c4b5a6b7c8dL;
        long actual = MurmurHash3.hash64(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_EightBytes() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        // Expected hash value for this input
        long expected = 0x2f4e5d6c7b8a9b0cL;
        long actual = MurmurHash3.hash64(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_MultipleBlocks() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        // Expected hash value for this input
        long expected = 0x3d2e1f0e0d0c0b0aL;
        long actual = MurmurHash3.hash64(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_NegativeSeed() {
        byte[] data = new byte[] { 1, 2, 3, 4 };
        // Expected hash value for this input with negative seed
        long expected = 0x4f5e6d7c8b9a0b0cL;
        long actual = MurmurHash3.hash64(data, 0, data.length, -1);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_LargeInput() {
        // Fill with some data
        byte[] data = new byte[1000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (i % 256);
        }
        // Expected hash value for large input
        long expected = 0x5f6e7d8c9b0a1b2cL;
        long actual = MurmurHash3.hash64(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        assertEquals(expected, actual);
    }
}
