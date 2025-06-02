package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash2_hash64_7_1_Test {

    @Test
    public void testHash64() throws Exception {
        // Test case 1: Basic input
        byte[] data1 = "hello".getBytes();
        int length1 = data1.length;
        int seed1 = 0;
        // Replace with the expected hash value
        long expected1 = 0x5c6c4e9c0c5a1d3bL;
        long actual1 = invokeHash64(data1, length1, seed1);
        assertEquals(expected1, actual1);
        // Test case 2: Empty input
        byte[] data2 = new byte[0];
        int length2 = data2.length;
        int seed2 = 0;
        // Replace with the expected hash value
        long expected2 = 0x1c8b5e4c6f8e9e1cL;
        long actual2 = invokeHash64(data2, length2, seed2);
        assertEquals(expected2, actual2);
        // Test case 3: Single byte input
        byte[] data3 = { 0x01 };
        int length3 = data3.length;
        int seed3 = 0;
        // Replace with the expected hash value
        long expected3 = 0x7e1c3ca3e3a5f2b4L;
        long actual3 = invokeHash64(data3, length3, seed3);
        assertEquals(expected3, actual3);
        // Test case 4: Longer input
        byte[] data4 = "MurmurHash".getBytes();
        int length4 = data4.length;
        int seed4 = 123456;
        // Replace with the expected hash value
        long expected4 = 0x9d8c6e4f3b8e9e1cL;
        long actual4 = invokeHash64(data4, length4, seed4);
        assertEquals(expected4, actual4);
        // Test case 5: Input with length that is not a multiple of 8
        byte[] data5 = { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07 };
        int length5 = data5.length;
        int seed5 = 0;
        // Replace with the expected hash value
        long expected5 = 0x8e1c3ca3e3a5f2b4L;
        long actual5 = invokeHash64(data5, length5, seed5);
        assertEquals(expected5, actual5);
    }

    private long invokeHash64(byte[] data, int length, int seed) throws Exception {
        Method method = MurmurHash2.class.getDeclaredMethod("hash64", byte[].class, int.class, int.class);
        method.setAccessible(true);
        return (long) method.invoke(null, data, length, seed);
    }
}
