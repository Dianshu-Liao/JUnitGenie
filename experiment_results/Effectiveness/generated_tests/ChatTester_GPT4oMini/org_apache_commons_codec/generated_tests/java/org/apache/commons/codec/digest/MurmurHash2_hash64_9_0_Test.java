package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash2_hash64_9_0_Test {

    @Test
    public void testHash64ValidSubstring() {
        String text = "Hello, World!";
        // Assuming the hash of "Hello"
        long expectedHash = invokeHash64(text, 0, 5);
        long actualHash = MurmurHash2.hash64(text, 0, 5);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64MiddleSubstring() {
        String text = "Hello, World!";
        // Assuming the hash of "World"
        long expectedHash = invokeHash64(text, 7, 5);
        long actualHash = MurmurHash2.hash64(text, 7, 5);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64FullString() {
        String text = "Hello, World!";
        // Hash of the full string
        long expectedHash = invokeHash64(text, 0, text.length());
        long actualHash = MurmurHash2.hash64(text, 0, text.length());
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64EmptySubstring() {
        String text = "Hello, World!";
        // Assuming the hash of an empty string
        long expectedHash = invokeHash64(text, 0, 0);
        long actualHash = MurmurHash2.hash64(text, 0, 0);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64InvalidFromIndex() {
        String text = "Hello, World!";
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            MurmurHash2.hash64(text, -1, 5);
        });
    }

    @Test
    public void testHash64InvalidLength() {
        String text = "Hello, World!";
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            // Length exceeds the string length
            MurmurHash2.hash64(text, 0, 20);
        });
    }

    // Reflection method to invoke the private hash64 method
    private long invokeHash64(String text, int from, int length) {
        try {
            java.lang.reflect.Method method = MurmurHash2.class.getDeclaredMethod("hash64", String.class);
            method.setAccessible(true);
            return (long) method.invoke(null, text.substring(from, from + length));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
