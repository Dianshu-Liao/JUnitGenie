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
    public void testHash64WithFullLength() throws Exception {
        byte[] data = "example".getBytes();
        int offset = 0;
        int length = data.length;
        int seed = MurmurHash3.DEFAULT_SEED;
        // Expected hash value for the input
        long expectedHash = 1668312034848906290L;
        long actualHash = invokeHash64(data, offset, length, seed);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64WithPartialTail() throws Exception {
        byte[] data = "example".getBytes();
        int offset = 0;
        // Partial length
        int length = 7;
        int seed = MurmurHash3.DEFAULT_SEED;
        // Expected hash value for partial input
        long expectedHash = 1668312034848906290L;
        long actualHash = invokeHash64(data, offset, length, seed);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64WithZeroLength() throws Exception {
        byte[] data = new byte[0];
        int offset = 0;
        int length = 0;
        int seed = MurmurHash3.DEFAULT_SEED;
        // Expected hash value for zero-length input
        long expectedHash = invokeFmix64(seed ^ 0);
        long actualHash = invokeHash64(data, offset, length, seed);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64WithNegativeOffset() throws Exception {
        byte[] data = "example".getBytes();
        // Invalid offset
        int offset = -1;
        int length = data.length;
        int seed = MurmurHash3.DEFAULT_SEED;
        // Expecting an exception
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            invokeHash64(data, offset, length, seed);
        });
    }

    @Test
    public void testHash64WithExceedingLength() throws Exception {
        byte[] data = "example".getBytes();
        int offset = 0;
        // Exceeding length
        int length = data.length + 10;
        int seed = MurmurHash3.DEFAULT_SEED;
        // Expecting an exception
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            invokeHash64(data, offset, length, seed);
        });
    }

    private long invokeHash64(byte[] data, int offset, int length, int seed) throws Exception {
        Method method = MurmurHash3.class.getDeclaredMethod("hash64", byte[].class, int.class, int.class, int.class);
        method.setAccessible(true);
        return (long) method.invoke(null, data, offset, length, seed);
    }

    private long invokeFmix64(long hash) throws Exception {
        Method method = MurmurHash3.class.getDeclaredMethod("fmix64", long.class);
        method.setAccessible(true);
        return (long) method.invoke(null, hash);
    }
}
