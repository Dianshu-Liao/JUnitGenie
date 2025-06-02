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

public class NumberOutput__leading3_19_0_Test {

    private static NumberOutput numberOutput;

    @BeforeAll
    public static void setUp() {
        numberOutput = new NumberOutput();
    }

    @Test
    public void testLeading3WithSingleDigit() throws Exception {
        char[] buffer = new char[3];
        int offset = invokeLeading3(5, buffer, 0);
        assertArrayEquals(new char[] { '5', '\u0000', '\u0000' }, buffer);
        assertEquals(1, offset);
    }

    @Test
    public void testLeading3WithDoubleDigit() throws Exception {
        char[] buffer = new char[3];
        int offset = invokeLeading3(12, buffer, 0);
        assertArrayEquals(new char[] { '1', '2', '\u0000' }, buffer);
        assertEquals(2, offset);
    }

    @Test
    public void testLeading3WithTripleDigit() throws Exception {
        char[] buffer = new char[3];
        int offset = invokeLeading3(123, buffer, 0);
        assertArrayEquals(new char[] { '1', '2', '3' }, buffer);
        assertEquals(3, offset);
    }

    @Test
    public void testLeading3WithGreaterThan99() throws Exception {
        char[] buffer = new char[3];
        int offset = invokeLeading3(999, buffer, 0);
        assertArrayEquals(new char[] { '9', '9', '9' }, buffer);
        assertEquals(3, offset);
    }

    @Test
    public void testLeading3WithZero() throws Exception {
        char[] buffer = new char[3];
        int offset = invokeLeading3(0, buffer, 0);
        assertArrayEquals(new char[] { '0', '\u0000', '\u0000' }, buffer);
        assertEquals(1, offset);
    }

    @Test
    public void testLeading3WithNegativeSingleDigit() throws Exception {
        char[] buffer = new char[3];
        int offset = invokeLeading3(-5, buffer, 0);
        assertArrayEquals(new char[] { '\u0000', '\u0000', '\u0000' }, buffer);
        assertEquals(0, offset);
    }

    private int invokeLeading3(int t, char[] b, int off) throws Exception {
        Method method = NumberOutput.class.getDeclaredMethod("_leading3", int.class, char[].class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(null, t, b, off);
    }
}
