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

public class MurmurHash3_hash64_26_0_Test {

    @Test
    public void testHash64() throws Exception {
        // Arrange
        // test with zero
        short input1 = 0;
        // test with a small positive number
        short input2 = 1;
        // test with a small negative number
        short input3 = -1;
        // test with maximum short value
        short input4 = Short.MAX_VALUE;
        // test with minimum short value
        short input5 = Short.MIN_VALUE;
        long expectedHash1 = invokeHash64(input1);
        long expectedHash2 = invokeHash64(input2);
        long expectedHash3 = invokeHash64(input3);
        long expectedHash4 = invokeHash64(input4);
        long expectedHash5 = invokeHash64(input5);
        // Act & Assert
        assertEquals(expectedHash1, MurmurHash3.hash64(input1));
        assertEquals(expectedHash2, MurmurHash3.hash64(input2));
        assertEquals(expectedHash3, MurmurHash3.hash64(input3));
        assertEquals(expectedHash4, MurmurHash3.hash64(input4));
        assertEquals(expectedHash5, MurmurHash3.hash64(input5));
    }

    private long invokeHash64(short data) throws Exception {
        Method method = MurmurHash3.class.getDeclaredMethod("hash64", short.class);
        method.setAccessible(true);
        return (long) method.invoke(null, data);
    }
}
