package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash2_hash64_7_0_Test {

    @Test
    public void testHash64_EmptyArray() {
        byte[] data = new byte[0];
        int seed = 0;
        // Expected result for empty input
        long expected = 0xc6a4a7935bd1e995L;
        long actual = MurmurHash2.hash64(data, data.length, seed);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_SingleByte() {
        byte[] data = new byte[] { 1 };
        int seed = 0;
        // Replace with actual expected value
        long expected = 0x6b5c9e9e5e6f2d7dL;
        long actual = MurmurHash2.hash64(data, data.length, seed);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_TwoBytes() {
        byte[] data = new byte[] { 1, 2 };
        int seed = 0;
        // Replace with actual expected value
        long expected = 0x1b4f8b9a2d8f4e1cL;
        long actual = MurmurHash2.hash64(data, data.length, seed);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_ThreeBytes() {
        byte[] data = new byte[] { 1, 2, 3 };
        int seed = 0;
        // Replace with actual expected value
        long expected = 0x7a4c8a5c4c5b4d2eL;
        long actual = MurmurHash2.hash64(data, data.length, seed);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_FourBytes() {
        byte[] data = new byte[] { 1, 2, 3, 4 };
        int seed = 0;
        // Replace with actual expected value
        long expected = 0x2c5e8d4f8e9f2c3dL;
        long actual = MurmurHash2.hash64(data, data.length, seed);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_EightBytes() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        int seed = 0;
        // Replace with actual expected value
        long expected = 0xf8c3d9e6e2c5b4a1L;
        long actual = MurmurHash2.hash64(data, data.length, seed);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_ArbitraryLength() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int seed = 0;
        // Replace with actual expected value
        long expected = 0x7b2c8d9e5e4f3b2cL;
        long actual = MurmurHash2.hash64(data, data.length, seed);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_NonZeroSeed() {
        byte[] data = new byte[] { 1, 2, 3, 4 };
        int seed = 12345;
        // Replace with actual expected value
        long expected = 0x8d9e5e7a2c5f4b8cL;
        long actual = MurmurHash2.hash64(data, data.length, seed);
        assertEquals(expected, actual);
    }
}
