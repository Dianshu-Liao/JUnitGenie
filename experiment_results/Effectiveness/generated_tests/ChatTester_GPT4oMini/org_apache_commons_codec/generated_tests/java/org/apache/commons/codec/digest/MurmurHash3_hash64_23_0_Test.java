package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash64_23_0_Test {

    @Test
    public void testHash64_withFullBlocks() throws Exception {
        byte[] data = "abcdefgh".getBytes();
        int offset = 0;
        int length = 8;
        int seed = MurmurHash3.DEFAULT_SEED;
        // Replace with the expected hash value
        long expectedHash = 0x5c2c0b7dc7f2d9c1L;
        long actualHash = invokeHash64(data, offset, length, seed);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_withPartialBlock() throws Exception {
        byte[] data = "abcde".getBytes();
        int offset = 0;
        int length = 5;
        int seed = MurmurHash3.DEFAULT_SEED;
        // Replace with the expected hash value
        long expectedHash = 0x7c3a6ea5b5e3a0f9L;
        long actualHash = invokeHash64(data, offset, length, seed);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_withEmptyData() throws Exception {
        byte[] data = new byte[0];
        int offset = 0;
        int length = 0;
        int seed = MurmurHash3.DEFAULT_SEED;
        // Replace with the expected hash value for empty input
        long expectedHash = 0x5c2c0b7dc7f2d9c1L;
        long actualHash = invokeHash64(data, offset, length, seed);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_withNullData() throws Exception {
        byte[] data = null;
        int offset = 0;
        int length = 0;
        int seed = MurmurHash3.DEFAULT_SEED;
        // Expected behavior for null input
        long expectedHash = MurmurHash3.NULL_HASHCODE;
        long actualHash = invokeHash64(data, offset, length, seed);
        assertEquals(expectedHash, actualHash);
    }

    private long invokeHash64(byte[] data, int offset, int length, int seed) throws Exception {
        Method method = MurmurHash3.class.getDeclaredMethod("hash64", byte[].class, int.class, int.class, int.class);
        method.setAccessible(true);
        return (long) method.invoke(null, data, offset, length, seed);
    }
}
