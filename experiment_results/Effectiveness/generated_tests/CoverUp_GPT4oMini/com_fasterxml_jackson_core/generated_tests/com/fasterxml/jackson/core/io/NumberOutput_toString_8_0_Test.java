package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

public class NumberOutput_toString_8_0_Test {

    @Test
    public void testToStringWithFastWriter() throws Exception {
        double value = 123.456;
        boolean useFastWriter = true;
        // Invoke the focal method
        String result = invokeToString(value, useFastWriter);
        // Verify the result
        String expected = DoubleToDecimal.toString(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithoutFastWriter() throws Exception {
        double value = 123.456;
        boolean useFastWriter = false;
        // Invoke the focal method
        String result = invokeToString(value, useFastWriter);
        // Verify the result
        String expected = Double.toString(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithNegativeValueUsingFastWriter() throws Exception {
        double value = -123.456;
        boolean useFastWriter = true;
        // Invoke the focal method
        String result = invokeToString(value, useFastWriter);
        // Verify the result
        String expected = DoubleToDecimal.toString(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithNegativeValueWithoutFastWriter() throws Exception {
        double value = -123.456;
        boolean useFastWriter = false;
        // Invoke the focal method
        String result = invokeToString(value, useFastWriter);
        // Verify the result
        String expected = Double.toString(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithZeroUsingFastWriter() throws Exception {
        double value = 0.0;
        boolean useFastWriter = true;
        // Invoke the focal method
        String result = invokeToString(value, useFastWriter);
        // Verify the result
        String expected = DoubleToDecimal.toString(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithZeroWithoutFastWriter() throws Exception {
        double value = 0.0;
        boolean useFastWriter = false;
        // Invoke the focal method
        String result = invokeToString(value, useFastWriter);
        // Verify the result
        String expected = Double.toString(value);
        assertEquals(expected, result);
    }

    private String invokeToString(double v, boolean useFastWriter) throws Exception {
        Method method = NumberOutput.class.getDeclaredMethod("toString", double.class, boolean.class);
        method.setAccessible(true);
        return (String) method.invoke(null, v, useFastWriter);
    }
}
