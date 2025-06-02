package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash64_21_0_Test {

    @Test
    public void testHash64_withNullData() {
        byte[] data = null;
        long result = invokeHash64(data);
        assertEquals(MurmurHash3.NULL_HASHCODE, result);
    }

    @Test
    public void testHash64_withEmptyData() {
        byte[] data = new byte[0];
        long result = invokeHash64(data);
        assertEquals(MurmurHash3.NULL_HASHCODE, result);
    }

    @Test
    public void testHash64_withSingleByteData() {
        byte[] data = new byte[] { 1 };
        long result = invokeHash64(data);
        assertNotEquals(MurmurHash3.NULL_HASHCODE, result);
    }

    @Test
    public void testHash64_withMultipleBytesData() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5 };
        long result = invokeHash64(data);
        assertNotEquals(MurmurHash3.NULL_HASHCODE, result);
    }

    @Test
    public void testHash64_withNegativeByteData() {
        byte[] data = new byte[] { -1, -2, -3, -4, -5 };
        long result = invokeHash64(data);
        assertNotEquals(MurmurHash3.NULL_HASHCODE, result);
    }

    @Test
    public void testHash64_withLargeByteData() {
        // Large data
        byte[] data = new byte[1024];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (i % 256);
        }
        long result = invokeHash64(data);
        assertNotEquals(MurmurHash3.NULL_HASHCODE, result);
    }

    private long invokeHash64(byte[] data) {
        try {
            Method method = MurmurHash3.class.getDeclaredMethod("hash64", byte[].class);
            method.setAccessible(true);
            return (long) method.invoke(null, (Object) data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
