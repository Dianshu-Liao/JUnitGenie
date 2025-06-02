package org.apache.commons.codec.digest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash64_24_0_Test {

    @Test
    public void testHash64PositiveInteger() throws Exception {
        int input = 123456;
        long expectedHash = calculateExpectedHash(input);
        long actualHash = invokeHash64(input);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64NegativeInteger() throws Exception {
        int input = -123456;
        long expectedHash = calculateExpectedHash(input);
        long actualHash = invokeHash64(input);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64Zero() throws Exception {
        int input = 0;
        long expectedHash = calculateExpectedHash(input);
        long actualHash = invokeHash64(input);
        assertEquals(expectedHash, actualHash);
    }

    private long invokeHash64(int data) throws Exception {
        Method method = MurmurHash3.class.getDeclaredMethod("hash64", int.class);
        method.setAccessible(true);
        return (long) method.invoke(null, data);
    }

    private long calculateExpectedHash(int data) throws Exception {
        long k1 = Integer.reverseBytes(data) & -1L >>> 32;
        long hash = getDefaultSeed();
        k1 *= getC1();
        k1 = Long.rotateLeft(k1, getR1());
        k1 *= getC2();
        hash ^= k1;
        hash ^= Integer.BYTES;
        return fmix64(hash);
    }

    private long fmix64(long hash) {
        hash ^= hash >>> 33;
        hash *= 0xff51afd7ed558ccdL;
        hash ^= hash >>> 33;
        hash *= 0xc4ceb9fe1a85ec53L;
        hash ^= hash >>> 33;
        return hash;
    }

    private long getC1() throws Exception {
        Field field = MurmurHash3.class.getDeclaredField("C1");
        field.setAccessible(true);
        return (long) field.get(null);
    }

    private long getC2() throws Exception {
        Field field = MurmurHash3.class.getDeclaredField("C2");
        field.setAccessible(true);
        return (long) field.get(null);
    }

    private int getR1() throws Exception {
        Field field = MurmurHash3.class.getDeclaredField("R1");
        field.setAccessible(true);
        return (int) field.get(null);
    }

    private long getDefaultSeed() throws Exception {
        Field field = MurmurHash3.class.getDeclaredField("DEFAULT_SEED");
        field.setAccessible(true);
        return (int) field.get(null);
    }
}
