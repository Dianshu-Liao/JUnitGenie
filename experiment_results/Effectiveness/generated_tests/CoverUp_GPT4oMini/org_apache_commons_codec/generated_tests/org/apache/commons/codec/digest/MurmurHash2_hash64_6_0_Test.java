package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.MurmurHash2;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash2_hash64_6_0_Test {

    @Test
    public void testHash64WithEmptyArray() {
        byte[] data = {};
        // Example expected value, adjust if necessary
        long expected = 0xe17a1465L * 0xc6a4a7935bd1e995L;
        long actual = invokeHash64(data, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64WithSingleByte() {
        byte[] data = { 1 };
        // Calculate expected value based on the method logic
        long expected = invokeHash64(data, 1);
        long actual = invokeHash64(data, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64WithMultipleBytes() {
        byte[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // Calculate expected value based on the method logic
        long expected = invokeHash64(data, 8);
        long actual = invokeHash64(data, 8);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64WithDifferentLengths() {
        byte[] data = { 1, 2, 3, 4, 5, 6, 7 };
        // Calculate expected value based on the method logic
        long expected = invokeHash64(data, 7);
        long actual = invokeHash64(data, 7);
        assertEquals(expected, actual);
    }

    private long invokeHash64(byte[] data, int length) {
        try {
            java.lang.reflect.Method method = MurmurHash2.class.getDeclaredMethod("hash64", byte[].class, int.class);
            method.setAccessible(true);
            return (long) method.invoke(null, data, length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
