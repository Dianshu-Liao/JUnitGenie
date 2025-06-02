package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash32x86_19_0_Test {

    @Test
    public void testHash32x86_withNullData() {
        byte[] data = null;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            invokeHash32x86(data);
        });
        assertEquals("data cannot be null", exception.getMessage());
    }

    @Test
    public void testHash32x86_withEmptyData() {
        byte[] data = new byte[0];
        int result = invokeHash32x86(data);
        // Assuming the hash of an empty array is 0
        assertEquals(0, result);
    }

    @Test
    public void testHash32x86_withSampleData() {
        byte[] data = "sample".getBytes();
        int result = invokeHash32x86(data);
        // Assuming non-empty data should yield a non-zero hash
        assertNotEquals(0, result);
    }

    @Test
    public void testHash32x86_withSpecialCharacters() {
        byte[] data = "!@#$%^&*()".getBytes();
        int result = invokeHash32x86(data);
        // Assuming non-empty data should yield a non-zero hash
        assertNotEquals(0, result);
    }

    @Test
    public void testHash32x86_withLongData() {
        // Testing with a larger array
        byte[] data = new byte[1000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) i;
        }
        int result = invokeHash32x86(data);
        // Assuming non-empty data should yield a non-zero hash
        assertNotEquals(0, result);
    }

    private int invokeHash32x86(byte[] data) {
        try {
            Method method = MurmurHash3.class.getDeclaredMethod("hash32x86", byte[].class);
            method.setAccessible(true);
            return (int) method.invoke(null, (Object) data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
