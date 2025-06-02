package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.MurmurHash3;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash32x86_20_0_Test {

    @Test
    public void testHash32x86_withFullBlock() throws Exception {
        byte[] data = "test".getBytes();
        int seed = MurmurHash3.DEFAULT_SEED;
        // Expected output for the input data
        int expectedHash = -1028477387;
        int actualHash = invokeHash32x86(data, 0, data.length, seed);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash32x86_withPartialBlock() throws Exception {
        byte[] data = "te".getBytes();
        int seed = MurmurHash3.DEFAULT_SEED;
        // Expected output for the input data
        int expectedHash = -1451627724;
        int actualHash = invokeHash32x86(data, 0, data.length, seed);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash32x86_withEmptyData() throws Exception {
        byte[] data = new byte[0];
        int seed = MurmurHash3.DEFAULT_SEED;
        // Expected output for empty data
        int expectedHash = 104729;
        int actualHash = invokeHash32x86(data, 0, data.length, seed);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash32x86_withNullData() throws Exception {
        byte[] data = null;
        int seed = MurmurHash3.DEFAULT_SEED;
        try {
            invokeHash32x86(data, 0, 0, seed);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    private int invokeHash32x86(byte[] data, int offset, int length, int seed) throws Exception {
        Method method = MurmurHash3.class.getDeclaredMethod("hash32x86", byte[].class, int.class, int.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(null, data, offset, length, seed);
    }
}
