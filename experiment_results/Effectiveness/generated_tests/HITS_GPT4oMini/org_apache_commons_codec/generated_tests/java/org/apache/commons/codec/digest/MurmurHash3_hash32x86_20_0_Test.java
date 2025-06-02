package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash32x86_20_0_Test {

    @Test
    public void testHash32x86_EmptyArray() {
        byte[] data = {};
        int result = MurmurHash3.hash32x86(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        // Expected result for empty array
        assertEquals(-1, result);
    }

    @Test
    public void testHash32x86_SingleByte() {
        byte[] data = { 1 };
        int result = MurmurHash3.hash32x86(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        // Expected result for single byte
        assertEquals(104729, result);
    }

    @Test
    public void testHash32x86_TwoBytes() {
        byte[] data = { 1, 2 };
        int result = MurmurHash3.hash32x86(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        // Expected result for two bytes
        assertEquals(104729, result);
    }

    @Test
    public void testHash32x86_ThreeBytes() {
        byte[] data = { 1, 2, 3 };
        int result = MurmurHash3.hash32x86(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        // Expected result for three bytes
        assertEquals(104729, result);
    }

    @Test
    public void testHash32x86_FourBytes() {
        byte[] data = { 1, 2, 3, 4 };
        int result = MurmurHash3.hash32x86(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        // Expected result for four bytes
        assertEquals(104729, result);
    }

    @Test
    public void testHash32x86_FiveBytes() {
        byte[] data = { 1, 2, 3, 4, 5 };
        int result = MurmurHash3.hash32x86(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        // Expected result for five bytes
        assertEquals(104729, result);
    }

    @Test
    public void testHash32x86_NegativeSeed() {
        byte[] data = { 1, 2, 3, 4, 5 };
        int result = MurmurHash3.hash32x86(data, 0, data.length, -1);
        // Expected result for negative seed
        assertEquals(104729, result);
    }

    @Test
    public void testHash32x86_LargeArray() {
        byte[] data = new byte[1024];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) i;
        }
        int result = MurmurHash3.hash32x86(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        // Expected result for large array
        assertEquals(104729, result);
    }

    @Test
    public void testHash32x86_OffsetAndLength() {
        byte[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int result = MurmurHash3.hash32x86(data, 2, 4, MurmurHash3.DEFAULT_SEED);
        // Expected result for offset and length
        assertEquals(104729, result);
    }
}
