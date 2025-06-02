package com.fasterxml.jackson.core.io.schubfach;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog10pow2;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog10threeQuartersPow2;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog2pow10;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.g1;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.multiplyHigh;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.pow10;
import static java.lang.Float.floatToRawIntBits;
import static java.lang.Integer.numberOfLeadingZeros;

class FloatToDecimal_toChars_5_0_Test {

    private FloatToDecimal floatToDecimal;

    private Method toCharsMethod;

    @BeforeEach
    void setUp() throws Exception {
        // Use reflection to instantiate the private constructor
        floatToDecimal = FloatToDecimal.class.getDeclaredConstructor().newInstance();
        // Use reflection to access the private toChars method
        toCharsMethod = FloatToDecimal.class.getDeclaredMethod("toChars", int.class, int.class);
        // Make the method accessible
        toCharsMethod.setAccessible(true);
    }

    public int toCharsPublic(int f, int e) throws Exception {
        // Invoke the private method using reflection
        return (int) toCharsMethod.invoke(floatToDecimal, f, e);
    }

    @Test
    void testToChars_withValidInputs() throws Exception {
        assertEquals(0, toCharsPublic(100, 2));
        assertEquals(0, toCharsPublic(99999999, 0));
        assertEquals(0, toCharsPublic(1, -1));
        assertEquals(0, toCharsPublic(12345678, 3));
        assertEquals(0, toCharsPublic(0, 0));
        assertEquals(0, toCharsPublic(10, 1));
        assertEquals(0, toCharsPublic(123456789, 8));
    }
}
