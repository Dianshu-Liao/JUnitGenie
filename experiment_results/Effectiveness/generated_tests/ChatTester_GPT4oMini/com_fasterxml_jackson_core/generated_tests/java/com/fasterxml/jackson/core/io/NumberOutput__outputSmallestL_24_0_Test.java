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
        // Arrange
        byte[] buffer = new byte[20];
        int offset = 0;
        String expected = NumberOutput.SMALLEST_LONG;
        // Act
        Method method = NumberOutput.class.getDeclaredMethod("_outputSmallestL", byte[].class, int.class);
        method.setAccessible(true);
        int newOffset = (int) method.invoke(null, buffer, offset);
        // Assert
        byte[] expectedBytes = expected.getBytes();
        byte[] actualBytes = new byte[newOffset];
        System.arraycopy(buffer, 0, actualBytes, 0, newOffset);
        assertArrayEquals(expectedBytes, actualBytes);
    }
}
