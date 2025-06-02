package org.apache.commons.codec.digest;

import org.apache.commons.codec.binary.StringUtils;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class MurmurHash2_hash64_8_0_Test {

    @Test
    public void testHash64_EmptyString() throws Exception {
        String input = "";
        // Expected hash for empty byte array
        long expectedHash = MurmurHash2.hash64(new byte[0], 0);
        long actualHash = invokeHash64(input);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_NonEmptyString() throws Exception {
        String input = "test";
        long expectedHash = MurmurHash2.hash64(StringUtils.getBytesUtf8(input), input.length());
        long actualHash = invokeHash64(input);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHash64_NullInput() {
        assertThrows(NullPointerException.class, () -> {
            invokeHash64(null);
        });
    }

    private long invokeHash64(String text) throws Exception {
        Method method = MurmurHash2.class.getDeclaredMethod("hash64", String.class);
        method.setAccessible(true);
        return (long) method.invoke(null, text);
    }
}
