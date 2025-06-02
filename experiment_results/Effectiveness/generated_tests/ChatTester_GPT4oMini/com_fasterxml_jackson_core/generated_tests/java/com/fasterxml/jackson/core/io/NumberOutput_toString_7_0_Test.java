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

public class NumberOutput_toString_7_0_Test {

    @Test
    public void testToStringPositiveDouble() throws Exception {
        double input = 1234.56;
        String expectedOutput = invokeToString(input);
        assertEquals("1234.56", expectedOutput);
    }

    @Test
    public void testToStringNegativeDouble() throws Exception {
        double input = -1234.56;
        String expectedOutput = invokeToString(input);
        assertEquals("-1234.56", expectedOutput);
    }

    @Test
    public void testToStringZero() throws Exception {
        double input = 0.0;
        String expectedOutput = invokeToString(input);
        assertEquals("0.0", expectedOutput);
    }

    @Test
    public void testToStringLargeDouble() throws Exception {
        double input = 1234567890.123;
        String expectedOutput = invokeToString(input);
        assertEquals("1234567890.123", expectedOutput);
    }

    @Test
    public void testToStringSmallDouble() throws Exception {
        double input = 0.000123;
        String expectedOutput = invokeToString(input);
        assertEquals("0.000123", expectedOutput);
    }

    @Test
    public void testToStringNegativeSmallDouble() throws Exception {
        double input = -0.000123;
        String expectedOutput = invokeToString(input);
        assertEquals("-0.000123", expectedOutput);
    }

    private String invokeToString(double value) throws Exception {
        Method method = NumberOutput.class.getDeclaredMethod("toString", double.class);
        method.setAccessible(true);
        return (String) method.invoke(null, value);
    }
}
