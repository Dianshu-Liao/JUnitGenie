package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash32x86_19_0_Test {

    @Test
    public void testHash32x86_EmptyArray() {
        byte[] data = new byte[0];
        int expectedHash = MurmurHash3.hash32x86(data);
        assertEquals(expectedHash, MurmurHash3.hash32x86(data));
    }

    @Test
    public void testHash32x86_SingleByte() {
        byte[] data = new byte[] { 0x1 };
        int expectedHash = MurmurHash3.hash32x86(data);
        assertEquals(expectedHash, MurmurHash3.hash32x86(data));
    }

    @Test
    public void testHash32x86_TwoBytes() {
        byte[] data = new byte[] { 0x1, 0x2 };
        int expectedHash = MurmurHash3.hash32x86(data);
        assertEquals(expectedHash, MurmurHash3.hash32x86(data));
    }

    @Test
    public void testHash32x86_ThreeBytes() {
        byte[] data = new byte[] { 0x1, 0x2, 0x3 };
        int expectedHash = MurmurHash3.hash32x86(data);
        assertEquals(expectedHash, MurmurHash3.hash32x86(data));
    }

    @Test
    public void testHash32x86_FourBytes() {
        byte[] data = new byte[] { 0x1, 0x2, 0x3, 0x4 };
        int expectedHash = MurmurHash3.hash32x86(data);
        assertEquals(expectedHash, MurmurHash3.hash32x86(data));
    }

    @Test
    public void testHash32x86_MultipleBytes() {
        byte[] data = new byte[] { 0x1, 0x2, 0x3, 0x4, 0x5, 0x6, 0x7, 0x8 };
        int expectedHash = MurmurHash3.hash32x86(data);
        assertEquals(expectedHash, MurmurHash3.hash32x86(data));
    }

    @Test
    public void testHash32x86_NegativeBytes() {
        byte[] data = new byte[] { -1, -2, -3, -4 };
        int expectedHash = MurmurHash3.hash32x86(data);
        assertEquals(expectedHash, MurmurHash3.hash32x86(data));
    }

    @Test
    public void testHash32x86_LargeArray() {
        byte[] data = new byte[1000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) i;
        }
        int expectedHash = MurmurHash3.hash32x86(data);
        assertEquals(expectedHash, MurmurHash3.hash32x86(data));
    }

    @Test
    public void testHash32x86_Seed() {
        byte[] data = new byte[] { 0x1, 0x2, 0x3, 0x4 };
        int seed = MurmurHash3.DEFAULT_SEED;
        int expectedHash = MurmurHash3.hash32x86(data, 0, data.length, seed);
        assertEquals(expectedHash, MurmurHash3.hash32x86(data));
    }
}
