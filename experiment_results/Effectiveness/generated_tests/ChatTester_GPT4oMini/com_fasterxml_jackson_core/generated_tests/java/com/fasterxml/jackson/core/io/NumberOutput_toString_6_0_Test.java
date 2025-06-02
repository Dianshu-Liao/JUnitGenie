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

public class NumberOutput_toString_6_0_Test {

    @Test
    public void testToString_withIntValue() throws Exception {
        // Arrange
        // Within the range of Integer
        long input = 100;
        String expected = "100";
        // Act
        String result = invokeToString(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withNegativeIntValue() throws Exception {
        // Arrange
        // Within the range of Integer
        long input = -100;
        String expected = "-100";
        // Act
        String result = invokeToString(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withLongValue() throws Exception {
        // Arrange
        // Outside the range of Integer
        long input = 10000000000L;
        String expected = "10000000000";
        // Act
        String result = invokeToString(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withNegativeLongValue() throws Exception {
        // Arrange
        // Outside the range of Integer
        long input = -10000000000L;
        String expected = "-10000000000";
        // Act
        String result = invokeToString(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withMinIntegerValue() throws Exception {
        // Arrange
        // Edge case
        long input = Integer.MIN_VALUE;
        String expected = String.valueOf(Integer.MIN_VALUE);
        // Act
        String result = invokeToString(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withMaxIntegerValue() throws Exception {
        // Arrange
        // Edge case
        long input = Integer.MAX_VALUE;
        String expected = String.valueOf(Integer.MAX_VALUE);
        // Act
        String result = invokeToString(input);
        // Assert
        assertEquals(expected, result);
    }

    private String invokeToString(long input) throws Exception {
        Method method = NumberOutput.class.getDeclaredMethod("toString", long.class);
        method.setAccessible(true);
        return (String) method.invoke(null, input);
    }
}
