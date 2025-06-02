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

public class MurmurHash3_hash64_21_0_Test {

    @Test
    public void testHash64_EmptyArray() throws Exception {
        byte[] input = new byte[0];
        // Expected output for empty input
        long expected = MurmurHash3.NULL_HASHCODE;
        long result = invokeHash64(input);
        assertEquals(expected, result);
    }

    @Test
    public void testHash64_NonEmptyArray() throws Exception {
        byte[] input = new byte[] { 1, 2, 3, 4, 5 };
        // Example expected output, replace with actual expected value
        long expected = 0x5c3b1d3f0b3e8e77L;
        long result = invokeHash64(input);
        assertEquals(expected, result);
    }

    @Test
    public void testHash64_SingleByte() throws Exception {
        byte[] input = new byte[] { 42 };
        // Example expected output, replace with actual expected value
        long expected = 0x8c7b2c2d4f8d7f6dL;
        long result = invokeHash64(input);
        assertEquals(expected, result);
    }

    @Test
    public void testHash64_TailHandling() throws Exception {
        byte[] input = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // Example expected output, replace with actual expected value
        long expected = 0x7b3b1d3f0b3e8e77L;
        long result = invokeHash64(input);
        assertEquals(expected, result);
    }

    private long invokeHash64(byte[] data) throws Exception {
        Method method = MurmurHash3.class.getDeclaredMethod("hash64", byte[].class);
        method.setAccessible(true);
        return (long) method.invoke(null, data);
    }
}
