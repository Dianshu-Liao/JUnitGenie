package com.fasterxml.jackson.core.io;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

public class NumberOutput__outputSmallestL_24_0_Test {

    @Test
    public void testOutputSmallestL() throws Exception {
        // Prepare input
        // Length of SMALLEST_LONG ("-9223372036854775808") is 20 + 1 for null terminator
        byte[] buffer = new byte[21];
        int offset = 0;
        // Invoke the private method using reflection
        Method method = NumberOutput.class.getDeclaredMethod("_outputSmallestL", byte[].class, int.class);
        method.setAccessible(true);
        int newOffset = (int) method.invoke(null, buffer, offset);
        // Expected output
        // "-9223372036854775808"
        String expectedString = String.valueOf(Long.MIN_VALUE);
        byte[] expectedBytes = expectedString.getBytes();
        // Validate output
        assertArrayEquals(expectedBytes, buffer, "The byte array does not match the expected output.");
        assertEquals(newOffset, expectedBytes.length, "The new offset should match the expected length.");
    }
}
