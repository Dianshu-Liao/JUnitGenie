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

public class NumberOutput_toString_9_0_Test {

    @Test
    public void testToStringPositiveFloat() throws Exception {
        float input = 5.5f;
        String expected = invokeToString(input);
        assertEquals("5.5", expected);
    }

    @Test
    public void testToStringNegativeFloat() throws Exception {
        float input = -3.3f;
        String expected = invokeToString(input);
        assertEquals("-3.3", expected);
    }

    @Test
    public void testToStringZeroFloat() throws Exception {
        float input = 0.0f;
        String expected = invokeToString(input);
        assertEquals("0.0", expected);
    }

    @Test
    public void testToStringLargeFloat() throws Exception {
        // Test a large float value
        float input = 1.0E10f;
        String expected = invokeToString(input);
        assertEquals("1.0E10", expected);
    }

    @Test
    public void testToStringSmallFloat() throws Exception {
        // Test a small float value
        float input = 1.0E-10f;
        String expected = invokeToString(input);
        assertEquals("1.0E-10", expected);
    }

    @Test
    public void testToStringNegativeSmallFloat() throws Exception {
        // Test a negative small float value
        float input = -1.0E-10f;
        String expected = invokeToString(input);
        assertEquals("-1.0E-10", expected);
    }

    @Test
    public void testToStringNegativeLargeFloat() throws Exception {
        // Test a negative large float value
        float input = -1.0E10f;
        String expected = invokeToString(input);
        assertEquals("-1.0E10", expected);
    }

    private String invokeToString(float value) throws Exception {
        Method method = NumberOutput.class.getDeclaredMethod("toString", float.class);
        method.setAccessible(true);
        return (String) method.invoke(null, value);
    }
}
