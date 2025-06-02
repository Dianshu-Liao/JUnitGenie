package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash2_hash64_6_0_Test {

    @Test
    public void testHash64_EmptyArray() {
        byte[] data = new byte[0];
        long expected = 0xe17a1465L ^ 0 * 0xc6a4a7935bd1e995L;
        long actual = MurmurHash2.hash64(data, data.length);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_SingleByte() {
        byte[] data = new byte[] { 1 };
        long expected = 0xe17a1465L ^ 1 * 0xc6a4a7935bd1e995L;
        long actual = MurmurHash2.hash64(data, data.length);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_TwoBytes() {
        byte[] data = new byte[] { 1, 2 };
        long expected = 0xe17a1465L ^ 2 * 0xc6a4a7935bd1e995L;
        long actual = MurmurHash2.hash64(data, data.length);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_FourBytes() {
        byte[] data = new byte[] { 1, 2, 3, 4 };
        long expected = 0xe17a1465L ^ 4 * 0xc6a4a7935bd1e995L;
        long actual = MurmurHash2.hash64(data, data.length);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_EightBytes() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        long expected = 0xe17a1465L ^ 8 * 0xc6a4a7935bd1e995L;
        long actual = MurmurHash2.hash64(data, data.length);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_NineBytes() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        long expected = 0xe17a1465L ^ 9 * 0xc6a4a7935bd1e995L;
        long actual = MurmurHash2.hash64(data, data.length);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_MultipleBytes() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        long expected = 0xe17a1465L ^ 16 * 0xc6a4a7935bd1e995L;
        long actual = MurmurHash2.hash64(data, data.length);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_LargeArray() {
        byte[] data = new byte[100];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) i;
        }
        long expected = 0xe17a1465L ^ data.length * 0xc6a4a7935bd1e995L;
        long actual = MurmurHash2.hash64(data, data.length);
        assertEquals(expected, actual);
    }
}
