package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.MurmurHash2;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash2_hash64_7_0_Test {

    @Test
    public void testHash64_withFullBlock() throws Exception {
        byte[] data = "Test data for hashing".getBytes();
        int length = data.length;
        int seed = 42;
        // Replace with the expected hash value for your input
        long expectedHash = 0x4f6d0c1d7c6b3e8fL;
        long actualHash = invokeHash64(data, length, seed);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_withPartialBlock() throws Exception {
        byte[] data = "Test".getBytes();
        int length = data.length;
        int seed = 42;
        // Replace with the expected hash value for your input
        long expectedHash = 0x5f1dbf3d4e8f2a5bL;
        long actualHash = invokeHash64(data, length, seed);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_withEmptyInput() throws Exception {
        byte[] data = {};
        int length = data.length;
        int seed = 42;
        // Replace with the expected hash value for your input
        long expectedHash = 0x7c0f0d4e1f0b3b0fL;
        long actualHash = invokeHash64(data, length, seed);
        assertEquals(expectedHash, actualHash);
    }

    private long invokeHash64(byte[] data, int length, int seed) throws Exception {
        Method method = MurmurHash2.class.getDeclaredMethod("hash64", byte[].class, int.class, int.class);
        method.setAccessible(true);
        return (long) method.invoke(null, data, length, seed);
    }
}
