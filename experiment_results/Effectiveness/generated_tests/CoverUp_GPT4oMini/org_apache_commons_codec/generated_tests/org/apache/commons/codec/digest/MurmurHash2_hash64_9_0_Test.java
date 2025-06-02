package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.MurmurHash2;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash2_hash64_9_0_Test {

    @Test
    public void testHash64_ValidInput() throws Exception {
        String text = "Hello, World!";
        int from = 0;
        int length = 5;
        long expectedHash = invokeHash64(text.substring(from, from + length));
        long actualHash = MurmurHash2.hash64(text, from, length);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_EmptyString() {
        String text = "";
        int from = 0;
        int length = 0;
        long actualHash = MurmurHash2.hash64(text, from, length);
        assertEquals(0, actualHash);
    }

    @Test
    public void testHash64_OutOfBounds() {
        String text = "Hello";
        int from = 0;
        int length = 10;
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            MurmurHash2.hash64(text, from, length);
        });
    }

    @Test
    public void testHash64_NegativeLength() {
        String text = "Hello";
        int from = 0;
        int length = -1;
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            MurmurHash2.hash64(text, from, length);
        });
    }

    private long invokeHash64(String text) throws Exception {
        Method method = MurmurHash2.class.getDeclaredMethod("hash64", String.class);
        method.setAccessible(true);
        return (long) method.invoke(null, text);
    }
}
