package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash64_22_0_Test {

    @Test
    public void testHash64_ValidInput() {
        byte[] data = "test".getBytes();
        long expectedHash = invokeHash64(data, 0, data.length);
        long actualHash = MurmurHash3.hash64(data, 0, data.length);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_EmptyInput() {
        byte[] data = new byte[0];
        long expectedHash = invokeHash64(data, 0, data.length);
        long actualHash = MurmurHash3.hash64(data, 0, data.length);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_NegativeOffset() {
        byte[] data = "test".getBytes();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            MurmurHash3.hash64(data, -1, data.length);
        });
    }

    @Test
    public void testHash64_OffsetOutOfBounds() {
        byte[] data = "test".getBytes();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            MurmurHash3.hash64(data, data.length + 1, data.length);
        });
    }

    @Test
    public void testHash64_LengthOutOfBounds() {
        byte[] data = "test".getBytes();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            MurmurHash3.hash64(data, 0, data.length + 1);
        });
    }

    private long invokeHash64(byte[] data, int offset, int length) {
        try {
            return (long) MurmurHash3.class.getDeclaredMethod("hash64", byte[].class, int.class, int.class, int.class).invoke(null, data, offset, length, MurmurHash3.DEFAULT_SEED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
