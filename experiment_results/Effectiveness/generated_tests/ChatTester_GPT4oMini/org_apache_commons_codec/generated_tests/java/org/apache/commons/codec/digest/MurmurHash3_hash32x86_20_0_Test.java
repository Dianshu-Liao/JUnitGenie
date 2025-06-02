package org.apache.commons.codec.digest;

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
    public void testHash32x86() throws Exception {
        // Test case 1: Normal case
        byte[] data1 = "Hello, World!".getBytes();
        int offset1 = 0;
        int length1 = data1.length;
        int seed1 = MurmurHash3.DEFAULT_SEED;
        // Example expected hash, replace with actual expected value
        int expectedHash1 = 0x1f6c7a9d;
        int actualHash1 = invokeHash32x86(data1, offset1, length1, seed1);
        assertEquals(expectedHash1, actualHash1);
        // Test case 2: Edge case with empty array
        byte[] data2 = new byte[0];
        int offset2 = 0;
        int length2 = data2.length;
        int seed2 = MurmurHash3.DEFAULT_SEED;
        // Expected hash for empty input
        int expectedHash2 = (int) MurmurHash3.NULL_HASHCODE;
        int actualHash2 = invokeHash32x86(data2, offset2, length2, seed2);
        assertEquals(expectedHash2, actualHash2);
        // Test case 3: Normal case with different seed
        byte[] data3 = "Test".getBytes();
        int offset3 = 0;
        int length3 = data3.length;
        int seed3 = 123456;
        // Example expected hash, replace with actual expected value
        int expectedHash3 = 0x4c9c0e2a;
        int actualHash3 = invokeHash32x86(data3, offset3, length3, seed3);
        assertEquals(expectedHash3, actualHash3);
        // Test case 4: Normal case with offset
        byte[] data4 = "MurmurHash".getBytes();
        int offset4 = 1;
        // "urmurHas"
        int length4 = 9;
        int seed4 = MurmurHash3.DEFAULT_SEED;
        // Example expected hash, replace with actual expected value
        int expectedHash4 = 0x5f4e9b12;
        int actualHash4 = invokeHash32x86(data4, offset4, length4, seed4);
        assertEquals(expectedHash4, actualHash4);
        // Test case 5: Length is less than 4 (tail handling)
        // 3 bytes
        byte[] data5 = { 1, 2, 3 };
        int offset5 = 0;
        int length5 = data5.length;
        int seed5 = MurmurHash3.DEFAULT_SEED;
        // Example expected hash, replace with actual expected value
        int expectedHash5 = 0x98b3a3e3;
        int actualHash5 = invokeHash32x86(data5, offset5, length5, seed5);
        assertEquals(expectedHash5, actualHash5);
        // Test case 6: Length is 1 (single byte)
        // single byte
        byte[] data6 = { 42 };
        int offset6 = 0;
        int length6 = data6.length;
        int seed6 = MurmurHash3.DEFAULT_SEED;
        // Example expected hash, replace with actual expected value
        int expectedHash6 = 0x5a3e1b5a;
        int actualHash6 = invokeHash32x86(data6, offset6, length6, seed6);
        assertEquals(expectedHash6, actualHash6);
    }

    private int invokeHash32x86(byte[] data, int offset, int length, int seed) throws Exception {
        Method method = MurmurHash3.class.getDeclaredMethod("hash32x86", byte[].class, int.class, int.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(null, data, offset, length, seed);
    }
}
