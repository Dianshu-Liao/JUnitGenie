package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;

public class NumberOutput_toString_10_0_Test {

    @Test
    public void testToStringWithFastWriter() throws Exception {
        // Arrange
        float value = 123.45f;
        boolean useFastWriter = true;
        // Act
        String result = invokeToString(value, useFastWriter);
        // Assert
        assertEquals(FloatToDecimal.toString(value), result);
    }

    @Test
    public void testToStringWithoutFastWriter() throws Exception {
        // Arrange
        float value = 123.45f;
        boolean useFastWriter = false;
        // Act
        String result = invokeToString(value, useFastWriter);
        // Assert
        assertEquals(Float.toString(value), result);
    }

    @Test
    public void testToStringWithNegativeValueAndFastWriter() throws Exception {
        // Arrange
        float value = -123.45f;
        boolean useFastWriter = true;
        // Act
        String result = invokeToString(value, useFastWriter);
        // Assert
        assertEquals(FloatToDecimal.toString(value), result);
    }

    @Test
    public void testToStringWithNegativeValueWithoutFastWriter() throws Exception {
        // Arrange
        float value = -123.45f;
        boolean useFastWriter = false;
        // Act
        String result = invokeToString(value, useFastWriter);
        // Assert
        assertEquals(Float.toString(value), result);
    }

    @Test
    public void testToStringWithZeroAndFastWriter() throws Exception {
        // Arrange
        float value = 0.0f;
        boolean useFastWriter = true;
        // Act
        String result = invokeToString(value, useFastWriter);
        // Assert
        assertEquals(FloatToDecimal.toString(value), result);
    }

    @Test
    public void testToStringWithZeroWithoutFastWriter() throws Exception {
        // Arrange
        float value = 0.0f;
        boolean useFastWriter = false;
        // Act
        String result = invokeToString(value, useFastWriter);
        // Assert
        assertEquals(Float.toString(value), result);
    }

    private String invokeToString(float value, boolean useFastWriter) throws Exception {
        Method method = NumberOutput.class.getDeclaredMethod("toString", float.class, boolean.class);
        method.setAccessible(true);
        return (String) method.invoke(null, value, useFastWriter);
    }
}
