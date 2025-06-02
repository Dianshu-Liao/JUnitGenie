package com.fasterxml.jackson.core.io.schubfach;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog10pow2;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog10threeQuartersPow2;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog2pow10;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.g0;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.g1;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.multiplyHigh;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.pow10;
import static java.lang.Double.doubleToRawLongBits;
import static java.lang.Long.numberOfLeadingZeros;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DoubleToDecimal_append8Digits_10_0_Test {

    private DoubleToDecimal doubleToDecimal;

    @BeforeEach
    public void setUp() {
        // Instantiate DoubleToDecimal using reflection
        try {
            Class<?> clazz = Class.forName("com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal");
            doubleToDecimal = (DoubleToDecimal) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            fail("Failed to instantiate DoubleToDecimal: " + e.getMessage());
        }
    }

    @Test
    public void testAppend8Digits() throws Exception {
        // Use reflection to access the private method
        Method append8DigitsMethod = DoubleToDecimal.class.getDeclaredMethod("append8Digits", int.class);
        append8DigitsMethod.setAccessible(true);
        // Prepare test data
        int testValue = 12345678;
        byte[] expectedBytes = new byte[doubleToDecimal.MAX_CHARS];
        // Manually calculate expected bytes for verification
        expectedBytes[0] = 1;
        expectedBytes[1] = 2;
        expectedBytes[2] = 3;
        expectedBytes[3] = 4;
        expectedBytes[4] = 5;
        expectedBytes[5] = 6;
        expectedBytes[6] = 7;
        expectedBytes[7] = 8;
        // Invoke the private method
        append8DigitsMethod.invoke(doubleToDecimal, testValue);
        // Retrieve the bytes array using reflection
        byte[] actualBytes = (byte[]) DoubleToDecimal.class.getDeclaredField("bytes").get(doubleToDecimal);
        // Assert that the expected output matches the actual output
        assertArrayEquals(expectedBytes, actualBytes);
    }
}
