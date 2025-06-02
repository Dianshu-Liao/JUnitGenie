// Adjust the package name as necessary
package com.fasterxml.jackson.core.io;

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
    public void testToStringWithPositiveDoubleUsingFastWriter() {
        double value = 12345.6789;
        boolean useFastWriter = true;
        // Expected output using fast writer
        String expected = DoubleToDecimal.toString(value);
        String actual = NumberOutput.toString(value, useFastWriter);
        assertEquals(expected, actual, "The output should match the expected fast writer output.");
    }

    @Test
    public void testToStringWithPositiveDoubleWithoutFastWriter() {
        double value = 12345.6789;
        boolean useFastWriter = false;
        // Expected output without fast writer
        String expected = Double.toString(value);
        String actual = NumberOutput.toString(value, useFastWriter);
        assertEquals(expected, actual, "The output should match the expected non-fast writer output.");
    }

    @Test
    public void testToStringWithNegativeDoubleUsingFastWriter() {
        double value = -98765.4321;
        boolean useFastWriter = true;
        // Expected output using fast writer
        String expected = DoubleToDecimal.toString(value);
        String actual = NumberOutput.toString(value, useFastWriter);
        assertEquals(expected, actual, "The output should match the expected fast writer output.");
    }

    @Test
    public void testToStringWithNegativeDoubleWithoutFastWriter() {
        double value = -98765.4321;
        boolean useFastWriter = false;
        // Expected output without fast writer
        String expected = Double.toString(value);
        String actual = NumberOutput.toString(value, useFastWriter);
        assertEquals(expected, actual, "The output should match the expected non-fast writer output.");
    }

    @Test
    public void testToStringWithZeroUsingFastWriter() {
        double value = 0.0;
        boolean useFastWriter = true;
        // Expected output using fast writer
        String expected = DoubleToDecimal.toString(value);
        String actual = NumberOutput.toString(value, useFastWriter);
        assertEquals(expected, actual, "The output should match the expected fast writer output.");
    }

    @Test
    public void testToStringWithZeroWithoutFastWriter() {
        double value = 0.0;
        boolean useFastWriter = false;
        // Expected output without fast writer
        String expected = Double.toString(value);
        String actual = NumberOutput.toString(value, useFastWriter);
        assertEquals(expected, actual, "The output should match the expected non-fast writer output.");
    }

    @Test
    public void testToStringWithNaNUsingFastWriter() {
        double value = Double.NaN;
        boolean useFastWriter = true;
        // Expected output using fast writer
        String expected = DoubleToDecimal.toString(value);
        String actual = NumberOutput.toString(value, useFastWriter);
        assertEquals(expected, actual, "The output should match the expected fast writer output.");
    }

    @Test
    public void testToStringWithNaNWithoutFastWriter() {
        double value = Double.NaN;
        boolean useFastWriter = false;
        // Expected output without fast writer
        String expected = Double.toString(value);
        String actual = NumberOutput.toString(value, useFastWriter);
        assertEquals(expected, actual, "The output should match the expected non-fast writer output.");
    }

    @Test
    public void testToStringWithInfinityUsingFastWriter() {
        double value = Double.POSITIVE_INFINITY;
        boolean useFastWriter = true;
        // Expected output using fast writer
        String expected = DoubleToDecimal.toString(value);
        String actual = NumberOutput.toString(value, useFastWriter);
        assertEquals(expected, actual, "The output should match the expected fast writer output.");
    }

    @Test
    public void testToStringWithInfinityWithoutFastWriter() {
        double value = Double.POSITIVE_INFINITY;
        boolean useFastWriter = false;
        // Expected output without fast writer
        String expected = Double.toString(value);
        String actual = NumberOutput.toString(value, useFastWriter);
        assertEquals(expected, actual, "The output should match the expected non-fast writer output.");
    }

    @Test
    public void testToStringWithNegativeInfinityUsingFastWriter() {
        double value = Double.NEGATIVE_INFINITY;
        boolean useFastWriter = true;
        // Expected output using fast writer
        String expected = DoubleToDecimal.toString(value);
        String actual = NumberOutput.toString(value, useFastWriter);
        assertEquals(expected, actual, "The output should match the expected fast writer output.");
    }
}
