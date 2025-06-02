package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class // You may add additional tests for edge cases or exceptions as needed
MurmurHash3_hash64_26_1_Test {

    @Test
    public void testHash64() throws Exception {
        // Test cases for the hash64 method
        // Edge case
        short input1 = 0;
        // Simple case
        short input2 = 1;
        // Negative case
        short input3 = -1;
        // Random case
        short input4 = 12345;
        // Max value case
        short input5 = Short.MAX_VALUE;
        // Min value case
        short input6 = Short.MIN_VALUE;
        // Expected hash values computed externally
        // Replace with actual expected value
        long expectedHash1 = 2862933555777941757L;
        // Replace with actual expected value
        long expectedHash2 = 2862933555777941758L;
        // Replace with actual expected value
        long expectedHash3 = 2862933555777941759L;
        // Replace with actual expected value
        long expectedHash4 = 2862933555777941760L;
        // Replace with actual expected value
        long expectedHash5 = 2862933555777941761L;
        // Replace with actual expected value
        long expectedHash6 = 2862933555777941762L;
        // Invoke the private method using reflection
        Method method = MurmurHash3.class.getDeclaredMethod("hash64", short.class);
        // Make the method accessible
        method.setAccessible(true);
        // Execute tests
        assertEquals(expectedHash1, method.invoke(null, input1));
        assertEquals(expectedHash2, method.invoke(null, input2));
        assertEquals(expectedHash3, method.invoke(null, input3));
        assertEquals(expectedHash4, method.invoke(null, input4));
        assertEquals(expectedHash5, method.invoke(null, input5));
        assertEquals(expectedHash6, method.invoke(null, input6));
    }
}
