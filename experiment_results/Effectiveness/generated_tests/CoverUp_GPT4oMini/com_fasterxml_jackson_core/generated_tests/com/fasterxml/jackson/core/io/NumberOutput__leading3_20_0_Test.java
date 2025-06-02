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

public class NumberOutput__leading3_20_0_Test {

    private static NumberOutput numberOutput;

    @BeforeAll
    public static void setUp() {
        numberOutput = new NumberOutput();
    }

    @Test
    public void testLeading3SingleDigit() throws Exception {
        byte[] buffer = new byte[3];
        int off = invokeLeading3(5, buffer, 0);
        // TRIPLET_TO_CHARS[5] = 5
        byte[] expected = new byte[] { 0, 0, 5 };
        assertArrayEquals(expected, buffer);
        assertEquals(1, off);
    }

    @Test
    public void testLeading3DoubleDigit() throws Exception {
        byte[] buffer = new byte[3];
        int off = invokeLeading3(12, buffer, 0);
        // TRIPLET_TO_CHARS[12] = 12
        byte[] expected = new byte[] { 0, 0, 12 };
        assertArrayEquals(expected, buffer);
        assertEquals(1, off);
    }

    @Test
    public void testLeading3TripleDigit() throws Exception {
        byte[] buffer = new byte[3];
        int off = invokeLeading3(123, buffer, 0);
        // TRIPLET_TO_CHARS[123] = 123
        byte[] expected = new byte[] { 0, 0, 123 };
        assertArrayEquals(expected, buffer);
        assertEquals(2, off);
    }

    @Test
    public void testLeading3GreaterThan99() throws Exception {
        byte[] buffer = new byte[3];
        int off = invokeLeading3(100, buffer, 0);
        // TRIPLET_TO_CHARS[100] = 100
        byte[] expected = new byte[] { 0, 0, 100 };
        assertArrayEquals(expected, buffer);
        assertEquals(3, off);
    }

    private int invokeLeading3(int t, byte[] b, int off) throws Exception {
        Method method = NumberOutput.class.getDeclaredMethod("_leading3", int.class, byte[].class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(null, t, b, off);
    }
}
