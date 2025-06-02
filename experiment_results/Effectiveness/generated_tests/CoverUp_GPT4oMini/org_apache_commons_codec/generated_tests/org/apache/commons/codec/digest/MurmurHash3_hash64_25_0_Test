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

public class MurmurHash3_hash64_25_0_Test {

    @Test
    public void testHash64() throws Exception {
        // Test cases
        long input1 = 0L;
        // Expected hash value for input 0L
        long expectedHash1 = -1608298971849038651L;
        long input2 = 123456789L;
        // Expected hash value for input 123456789L
        long expectedHash2 = -8379515323462442950L;
        long input3 = -987654321L;
        // Expected hash value for input -987654321L
        long expectedHash3 = 2768822173016671506L;
        // Invoke the private method using reflection
        Method method = MurmurHash3.class.getDeclaredMethod("hash64", long.class);
        method.setAccessible(true);
        // Test case 1
        long result1 = (long) method.invoke(null, input1);
        assertEquals(expectedHash1, result1);
        // Test case 2
        long result2 = (long) method.invoke(null, input2);
        assertEquals(expectedHash2, result2);
        // Test case 3
        long result3 = (long) method.invoke(null, input3);
        assertEquals(expectedHash3, result3);
    }
}
