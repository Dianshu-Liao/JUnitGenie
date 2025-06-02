package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash2_hash64_6_0_Test {

    @Test
    public void testHash64() throws Exception {
        // Test case 1: Regular case with known input
        byte[] data1 = "Hello, World!".getBytes();
        int length1 = data1.length;
        long expectedHash1 = invokeHash64(data1, length1);
        long actualHash1 = MurmurHash2.hash64(data1, length1);
        assertEquals(expectedHash1, actualHash1);
        // Test case 2: Empty byte array
        byte[] data2 = {};
        int length2 = 0;
        long expectedHash2 = invokeHash64(data2, length2);
        long actualHash2 = MurmurHash2.hash64(data2, length2);
        assertEquals(expectedHash2, actualHash2);
        // Test case 3: Single byte
        byte[] data3 = { 1 };
        int length3 = 1;
        long expectedHash3 = invokeHash64(data3, length3);
        long actualHash3 = MurmurHash2.hash64(data3, length3);
        assertEquals(expectedHash3, actualHash3);
        // Test case 4: Longer byte array
        byte[] data4 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int length4 = data4.length;
        long expectedHash4 = invokeHash64(data4, length4);
        long actualHash4 = MurmurHash2.hash64(data4, length4);
        assertEquals(expectedHash4, actualHash4);
    }

    private long invokeHash64(byte[] data, int length) throws Exception {
        Method method = MurmurHash2.class.getDeclaredMethod("hash64", byte[].class, int.class, int.class);
        method.setAccessible(true);
        return (long) method.invoke(null, data, length, 0xe17a1465);
    }
}
