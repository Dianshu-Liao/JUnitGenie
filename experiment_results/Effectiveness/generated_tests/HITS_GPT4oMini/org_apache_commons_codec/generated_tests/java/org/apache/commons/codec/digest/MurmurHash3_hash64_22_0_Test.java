package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash64_22_0_Test {

    @Test
    public void testHash64_EmptyArray() {
        byte[] data = {};
        long expected = MurmurHash3.NULL_HASHCODE;
        long actual = MurmurHash3.hash64(data, 0, data.length);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_SingleByte() {
        byte[] data = { 1 };
        // Example expected value, replace with actual expected hash
        long expected = 0x9b1e3d0a8e74b3f6L;
        long actual = MurmurHash3.hash64(data, 0, data.length);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_TwoBytes() {
        byte[] data = { 1, 2 };
        // Example expected value, replace with actual expected hash
        long expected = 0x8c7e4d0f8e1d1a1bL;
        long actual = MurmurHash3.hash64(data, 0, data.length);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_FullBlock() {
        byte[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // Example expected value, replace with actual expected hash
        long expected = 0x5b9c8c6d1e4f9a1bL;
        long actual = MurmurHash3.hash64(data, 0, data.length);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_MultipleBlocks() {
        byte[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        // Example expected value, replace with actual expected hash
        long expected = 0x3f0e2d1c7b8a5f4eL;
        long actual = MurmurHash3.hash64(data, 0, data.length);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_OffsetAndLength() {
        byte[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // Example expected value, replace with actual expected hash
        long expected = 0x5b9c8c6d1e4f9a1bL;
        long actual = MurmurHash3.hash64(data, 0, 8);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_NegativeLength() {
        byte[] data = { 1, 2, 3, 4 };
        // Assuming negative length returns NULL_HASHCODE
        long expected = MurmurHash3.NULL_HASHCODE;
        long actual = MurmurHash3.hash64(data, 0, -1);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_OffsetGreaterThanLength() {
        byte[] data = { 1, 2, 3, 4 };
        // Assuming this case returns NULL_HASHCODE
        long expected = MurmurHash3.NULL_HASHCODE;
        long actual = MurmurHash3.hash64(data, 5, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_NullArray() {
        // Assuming null array returns NULL_HASHCODE
        long expected = MurmurHash3.NULL_HASHCODE;
        long actual = MurmurHash3.hash64(null, 0, 0);
        assertEquals(expected, actual);
    }
}
