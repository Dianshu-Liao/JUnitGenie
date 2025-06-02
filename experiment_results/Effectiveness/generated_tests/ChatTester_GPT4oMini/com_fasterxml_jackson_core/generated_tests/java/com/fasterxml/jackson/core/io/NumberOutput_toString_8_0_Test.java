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

public class NumberOutput_toString_8_0_Test {

    @Test
    public void testToString_WithFastWriter() throws Exception {
        // Arrange
        double input = 123.456;
        boolean useFastWriter = true;
        // Assuming DoubleToDecimal.toString() returns this for the input.
        String expected = "123.456";
        // Act
        String result = invokeToString(input, useFastWriter);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_WithoutFastWriter() throws Exception {
        // Arrange
        double input = 123.456;
        boolean useFastWriter = false;
        // Double.toString() should return this for the input.
        String expected = "123.456";
        // Act
        String result = invokeToString(input, useFastWriter);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_NegativeValue_WithFastWriter() throws Exception {
        // Arrange
        double input = -123.456;
        boolean useFastWriter = true;
        // Assuming DoubleToDecimal.toString() returns this for the input.
        String expected = "-123.456";
        // Act
        String result = invokeToString(input, useFastWriter);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_NegativeValue_WithoutFastWriter() throws Exception {
        // Arrange
        double input = -123.456;
        boolean useFastWriter = false;
        // Double.toString() should return this for the input.
        String expected = "-123.456";
        // Act
        String result = invokeToString(input, useFastWriter);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_Zero_WithFastWriter() throws Exception {
        // Arrange
        double input = 0.0;
        boolean useFastWriter = true;
        // Assuming DoubleToDecimal.toString() returns this for the input.
        String expected = "0.0";
        // Act
        String result = invokeToString(input, useFastWriter);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_Zero_WithoutFastWriter() throws Exception {
        // Arrange
        double input = 0.0;
        boolean useFastWriter = false;
        // Double.toString() should return this for the input.
        String expected = "0.0";
        // Act
        String result = invokeToString(input, useFastWriter);
        // Assert
        assertEquals(expected, result);
    }

    private String invokeToString(double v, boolean useFastWriter) throws Exception {
        Method method = NumberOutput.class.getDeclaredMethod("toString", double.class, boolean.class);
        method.setAccessible(true);
        return (String) method.invoke(null, v, useFastWriter);
    }
}
