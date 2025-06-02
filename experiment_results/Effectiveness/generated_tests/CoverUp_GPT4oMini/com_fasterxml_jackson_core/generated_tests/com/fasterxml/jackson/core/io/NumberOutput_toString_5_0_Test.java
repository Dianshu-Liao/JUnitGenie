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

public class NumberOutput_toString_5_0_Test {

    @Test
    public void testToString_PositiveSmallInteger() throws Exception {
        assertEquals("0", invokeToString(0));
        assertEquals("1", invokeToString(1));
        assertEquals("2", invokeToString(2));
        assertEquals("3", invokeToString(3));
        assertEquals("4", invokeToString(4));
        assertEquals("5", invokeToString(5));
        assertEquals("6", invokeToString(6));
        assertEquals("7", invokeToString(7));
        assertEquals("8", invokeToString(8));
        assertEquals("9", invokeToString(9));
        assertEquals("10", invokeToString(10));
    }

    @Test
    public void testToString_NegativeSmallInteger() throws Exception {
        assertEquals("-1", invokeToString(-1));
        assertEquals("-2", invokeToString(-2));
        assertEquals("-3", invokeToString(-3));
        assertEquals("-4", invokeToString(-4));
        assertEquals("-5", invokeToString(-5));
        assertEquals("-6", invokeToString(-6));
        assertEquals("-7", invokeToString(-7));
        assertEquals("-8", invokeToString(-8));
        assertEquals("-9", invokeToString(-9));
        assertEquals("-10", invokeToString(-10));
    }

    @Test
    public void testToString_PositiveLargeInteger() throws Exception {
        assertEquals("100", invokeToString(100));
        assertEquals("1000", invokeToString(1000));
        assertEquals("10000", invokeToString(10000));
        assertEquals("123456789", invokeToString(123456789));
    }

    @Test
    public void testToString_NegativeLargeInteger() throws Exception {
        assertEquals("-100", invokeToString(-100));
        assertEquals("-1000", invokeToString(-1000));
        assertEquals("-10000", invokeToString(-10000));
        assertEquals("-123456789", invokeToString(-123456789));
    }

    @Test
    public void testToString_IntegerMin() throws Exception {
        assertEquals(String.valueOf(Integer.MIN_VALUE), invokeToString(Integer.MIN_VALUE));
    }

    @Test
    public void testToString_IntegerMax() throws Exception {
        assertEquals(String.valueOf(Integer.MAX_VALUE), invokeToString(Integer.MAX_VALUE));
    }

    private String invokeToString(int value) throws Exception {
        Method method = NumberOutput.class.getDeclaredMethod("toString", int.class);
        method.setAccessible(true);
        return (String) method.invoke(null, value);
    }
}
