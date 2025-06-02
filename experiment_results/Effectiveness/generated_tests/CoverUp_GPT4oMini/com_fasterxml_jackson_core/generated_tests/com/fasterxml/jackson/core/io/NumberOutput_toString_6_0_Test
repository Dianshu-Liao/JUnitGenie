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
    public void testToStringWithSmallPositiveValue() throws Exception {
        long input = 5L;
        String expected = "5";
        String result = invokeToString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithSmallNegativeValue() throws Exception {
        long input = -3L;
        String expected = "-3";
        String result = invokeToString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithZero() throws Exception {
        long input = 0L;
        String expected = "0";
        String result = invokeToString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithPositiveValueAboveIntegerMax() throws Exception {
        // Integer.MAX_VALUE + 1
        long input = 2147483648L;
        String expected = "2147483648";
        String result = invokeToString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithNegativeValueBelowIntegerMin() throws Exception {
        // Integer.MIN_VALUE - 1
        long input = -2147483649L;
        String expected = "-2147483649";
        String result = invokeToString(input);
        assertEquals(expected, result);
    }

    private String invokeToString(long value) throws Exception {
        Method method = NumberOutput.class.getDeclaredMethod("toString", long.class);
        method.setAccessible(true);
        return (String) method.invoke(null, value);
    }
}
