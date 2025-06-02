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

public class MurmurHash3_hash32x86_19_0_Test {

    @Test
    public void testHash32x86_EmptyArray() throws Exception {
        byte[] data = new byte[0];
        int expected = MurmurHash3.DEFAULT_SEED;
        int result = MurmurHash3.hash32x86(data);
        assertEquals(expected, result);
    }

    @Test
    public void testHash32x86_SingleByte() throws Exception {
        byte[] data = new byte[] { 1 };
        int expected = MurmurHash3.hash32x86(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        int result = MurmurHash3.hash32x86(data);
        assertEquals(expected, result);
    }

    @Test
    public void testHash32x86_TwoBytes() throws Exception {
        byte[] data = new byte[] { 1, 2 };
        int expected = MurmurHash3.hash32x86(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        int result = MurmurHash3.hash32x86(data);
        assertEquals(expected, result);
    }

    @Test
    public void testHash32x86_ThreeBytes() throws Exception {
        byte[] data = new byte[] { 1, 2, 3 };
        int expected = MurmurHash3.hash32x86(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        int result = MurmurHash3.hash32x86(data);
        assertEquals(expected, result);
    }

    @Test
    public void testHash32x86_FourBytes() throws Exception {
        byte[] data = new byte[] { 1, 2, 3, 4 };
        int expected = MurmurHash3.hash32x86(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        int result = MurmurHash3.hash32x86(data);
        assertEquals(expected, result);
    }

    @Test
    public void testHash32x86_MultipleBytes() throws Exception {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        int expected = MurmurHash3.hash32x86(data, 0, data.length, MurmurHash3.DEFAULT_SEED);
        int result = MurmurHash3.hash32x86(data);
        assertEquals(expected, result);
    }

    private int invokeHash32x86(byte[] data) throws Exception {
        Method method = MurmurHash3.class.getDeclaredMethod("hash32x86", byte[].class);
        method.setAccessible(true);
        return (int) method.invoke(null, (Object) data);
    }
}
