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

public class MurmurHash3_hash64_22_0_Test {

    @Test
    public void testHash64WithFullLength() throws Exception {
        byte[] data = "example".getBytes();
        int offset = 0;
        int length = data.length;
        long expectedHash = MurmurHash3.hash64(data, offset, length, MurmurHash3.DEFAULT_SEED);
        long actualHash = invokeHash64(data, offset, length);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64WithPartialLength() throws Exception {
        byte[] data = "example".getBytes();
        int offset = 0;
        // "examp"
        int length = 5;
        long expectedHash = MurmurHash3.hash64(data, offset, length, MurmurHash3.DEFAULT_SEED);
        long actualHash = invokeHash64(data, offset, length);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64WithZeroLength() throws Exception {
        byte[] data = "example".getBytes();
        int offset = 0;
        int length = 0;
        long expectedHash = MurmurHash3.hash64(data, offset, length, MurmurHash3.DEFAULT_SEED);
        long actualHash = invokeHash64(data, offset, length);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64WithOffset() throws Exception {
        byte[] data = "example".getBytes();
        // starting from 'a'
        int offset = 2;
        // "ampl"
        int length = 5;
        long expectedHash = MurmurHash3.hash64(data, offset, length, MurmurHash3.DEFAULT_SEED);
        long actualHash = invokeHash64(data, offset, length);
        assertEquals(expectedHash, actualHash);
    }

    private long invokeHash64(byte[] data, int offset, int length) throws Exception {
        Method hash64Method = MurmurHash3.class.getDeclaredMethod("hash64", byte[].class, int.class, int.class, int.class);
        hash64Method.setAccessible(true);
        return (long) hash64Method.invoke(null, data, offset, length, MurmurHash3.DEFAULT_SEED);
    }
}
