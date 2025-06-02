package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash64_25_0_Test {

    @Test
    public void testHash64() throws Exception {
        // Test cases for the hash64 method
        long input1 = 0L;
        // Replace with the expected result from your implementation
        long expected1 = -3002503098720498456L;
        assertEquals(expected1, invokeHash64(input1));
        long input2 = 1L;
        // Replace with the expected result from your implementation
        long expected2 = 8852155015766442448L;
        assertEquals(expected2, invokeHash64(input2));
        long input3 = 123456789L;
        // Replace with the expected result from your implementation
        long expected3 = -1603877473860800549L;
        assertEquals(expected3, invokeHash64(input3));
        long input4 = Long.MAX_VALUE;
        // Replace with the expected result from your implementation
        long expected4 = 3979454363891129514L;
        assertEquals(expected4, invokeHash64(input4));
        long input5 = Long.MIN_VALUE;
        // Replace with the expected result from your implementation
        long expected5 = 1188130761693187285L;
        assertEquals(expected5, invokeHash64(input5));
    }

    private long invokeHash64(long data) throws Exception {
        Method method = MurmurHash3.class.getDeclaredMethod("hash64", long.class);
        method.setAccessible(true);
        return (long) method.invoke(null, data);
    }
}
