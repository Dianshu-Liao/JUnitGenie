package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MurmurHash3_hash64_24_1_Test {

    @Test
    public void testHash64() throws Exception {
        // Test with a sample integer
        int input = 12345;
        long expectedHash = calculateExpectedHash(input);
        long actualHash = invokeHash64(input);
        assertEquals(expectedHash, actualHash);
        // Test with another sample integer
        input = 67890;
        expectedHash = calculateExpectedHash(input);
        actualHash = invokeHash64(input);
        assertEquals(expectedHash, actualHash);
        // Test with zero
        input = 0;
        expectedHash = calculateExpectedHash(input);
        actualHash = invokeHash64(input);
        assertEquals(expectedHash, actualHash);
        // Test with negative integer
        input = -12345;
        expectedHash = calculateExpectedHash(input);
        actualHash = invokeHash64(input);
        assertEquals(expectedHash, actualHash);
    }

    private long invokeHash64(int data) throws Exception {
        Method method = MurmurHash3.class.getDeclaredMethod("hash64", int.class);
        method.setAccessible(true);
        return (long) method.invoke(null, data);
    }

    private long calculateExpectedHash(int data) {
        long k1 = Integer.reverseBytes(data) & 0xffffffffL;
        long hash = MurmurHash3.DEFAULT_SEED;
        // Replaced MurmurHash3.C1 with its actual value
        k1 *= 0xcc9e2d51;
        k1 = Long.rotateLeft(k1, 15);
        // Replaced MurmurHash3.C2 with its actual value
        k1 *= 0x1b873593;
        hash ^= k1;
        hash ^= Integer.BYTES;
        return fmix64(hash);
    }

    private long fmix64(long k) {
        k ^= k >>> 33;
        k *= 0xff51afda721f054bL;
        k ^= k >>> 33;
        k *= 0xc4ceb9fe1a85ec53L;
        k ^= k >>> 33;
        return k;
    }
}
