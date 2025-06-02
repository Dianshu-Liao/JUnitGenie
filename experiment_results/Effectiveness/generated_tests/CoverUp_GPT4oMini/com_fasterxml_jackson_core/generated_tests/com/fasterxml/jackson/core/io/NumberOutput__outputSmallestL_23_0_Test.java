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

public class NumberOutput__outputSmallestL_23_0_Test {

    @Test
    public void testOutputSmallestL() throws Exception {
        // Arrange
        char[] buffer = new char[20];
        int offset = 0;
        // Act
        Method method = NumberOutput.class.getDeclaredMethod("_outputSmallestL", char[].class, int.class);
        method.setAccessible(true);
        int newOffset = (int) method.invoke(null, buffer, offset);
        // Assert
        String expectedOutput = NumberOutput.SMALLEST_LONG;
        char[] expectedChars = expectedOutput.toCharArray();
        assertArrayEquals(expectedChars, buffer, "The output characters do not match the expected smallest long value.");
        assertEquals(expectedChars.length + offset, newOffset, "The new offset is not correct.");
    }

    @Test
    public void testOutputSmallestLWithDifferentOffset() throws Exception {
        // Arrange
        char[] buffer = new char[20];
        int offset = 5;
        // Act
        Method method = NumberOutput.class.getDeclaredMethod("_outputSmallestL", char[].class, int.class);
        method.setAccessible(true);
        int newOffset = (int) method.invoke(null, buffer, offset);
        // Assert
        String expectedOutput = NumberOutput.SMALLEST_LONG;
        char[] expectedChars = expectedOutput.toCharArray();
        // Manually copy for assertion
        System.arraycopy(expectedChars, 0, buffer, offset, expectedChars.length);
        assertArrayEquals(expectedChars, buffer, "The output characters do not match the expected smallest long value.");
        assertEquals(expectedChars.length + offset, newOffset, "The new offset is not correct.");
    }
}
