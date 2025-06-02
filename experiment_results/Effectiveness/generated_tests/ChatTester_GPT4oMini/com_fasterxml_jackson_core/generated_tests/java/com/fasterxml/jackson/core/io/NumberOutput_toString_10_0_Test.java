package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

public class NumberOutput_toString_10_0_Test {

    @Test
    public void testToStringWithFastWriter() throws Exception {
        float input = 123.456f;
        boolean useFastWriter = true;
        // Use reflection to invoke the method
        String result = (String) NumberOutput.class.getMethod("toString", float.class, boolean.class).invoke(null, input, useFastWriter);
        // Assuming FloatToDecimal.toString(float) returns the same as Float.toString(float) for this test case
        assertEquals(Float.toString(input), result);
    }

    @Test
    public void testToStringWithoutFastWriter() throws Exception {
        float input = -789.123f;
        boolean useFastWriter = false;
        // Use reflection to invoke the method
        String result = (String) NumberOutput.class.getMethod("toString", float.class, boolean.class).invoke(null, input, useFastWriter);
        // Direct comparison with Float.toString() since useFastWriter is false
        assertEquals(Float.toString(input), result);
    }

    @Test
    public void testToStringWithZero() throws Exception {
        float input = 0.0f;
        boolean useFastWriter = true;
        // Use reflection to invoke the method
        String result = (String) NumberOutput.class.getMethod("toString", float.class, boolean.class).invoke(null, input, useFastWriter);
        assertEquals(Float.toString(input), result);
    }

    @Test
    public void testToStringWithNegativeZero() throws Exception {
        float input = -0.0f;
        boolean useFastWriter = true;
        // Use reflection to invoke the method
        String result = (String) NumberOutput.class.getMethod("toString", float.class, boolean.class).invoke(null, input, useFastWriter);
        assertEquals(Float.toString(input), result);
    }

    @Test
    public void testToStringWithInfinity() throws Exception {
        float input = Float.POSITIVE_INFINITY;
        boolean useFastWriter = true;
        // Use reflection to invoke the method
        String result = (String) NumberOutput.class.getMethod("toString", float.class, boolean.class).invoke(null, input, useFastWriter);
        assertEquals(Float.toString(input), result);
    }

    @Test
    public void testToStringWithNaN() throws Exception {
        float input = Float.NaN;
        boolean useFastWriter = true;
        // Use reflection to invoke the method
        String result = (String) NumberOutput.class.getMethod("toString", float.class, boolean.class).invoke(null, input, useFastWriter);
        assertEquals(Float.toString(input), result);
    }
}
