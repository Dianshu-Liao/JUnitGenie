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

final class FloatToDecimal_removeTrailingZeroes_10_0_Test {

    private FloatToDecimal floatToDecimal;

    @BeforeEach
    void setUp() {
        floatToDecimal = createFloatToDecimalInstance();
    }

    @Test
    void testRemoveTrailingZeroes() throws Exception {
        // Prepare the test data
        invokeAppend(floatToDecimal, '1');
        invokeAppend(floatToDecimal, '0');
        invokeAppend(floatToDecimal, '0');
        invokeAppend(floatToDecimal, '.');
        invokeAppend(floatToDecimal, '0');
        invokeAppend(floatToDecimal, '0');
        invokeAppend(floatToDecimal, '0');
        // Invoke the private method removeTrailingZeroes
        invokePrivateMethod(floatToDecimal, "removeTrailingZeroes");
        // Check the result
        String result = invokePrivateMethod(floatToDecimal, "charsToString");
        assertEquals("100.0", result);
        // Test case with trailing zeroes after decimal
        floatToDecimal = createFloatToDecimalInstance();
        invokeAppend(floatToDecimal, '2');
        invokeAppend(floatToDecimal, '5');
        invokeAppend(floatToDecimal, '.');
        invokeAppend(floatToDecimal, '0');
        invokeAppend(floatToDecimal, '0');
        invokeAppend(floatToDecimal, '0');
        invokePrivateMethod(floatToDecimal, "removeTrailingZeroes");
        result = invokePrivateMethod(floatToDecimal, "charsToString");
        assertEquals("25.0", result);
        // Test case with only zeroes
        floatToDecimal = createFloatToDecimalInstance();
        invokeAppend(floatToDecimal, '0');
        invokeAppend(floatToDecimal, '.');
        invokeAppend(floatToDecimal, '0');
        invokePrivateMethod(floatToDecimal, "removeTrailingZeroes");
        result = invokePrivateMethod(floatToDecimal, "charsToString");
        assertEquals("0.0", result);
    }

    private FloatToDecimal createFloatToDecimalInstance() {
        try {
            return (FloatToDecimal) FloatToDecimal.class.getDeclaredConstructors()[0].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void invokeAppend(FloatToDecimal instance, char c) throws Exception {
        Method appendMethod = FloatToDecimal.class.getDeclaredMethod("append", int.class);
        appendMethod.setAccessible(true);
        appendMethod.invoke(instance, (int) c);
    }

    private <T> T invokePrivateMethod(Object instance, String methodName, Object... args) throws Exception {
        Class<?>[] argTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        Method method = instance.getClass().getDeclaredMethod(methodName, argTypes);
        method.setAccessible(true);
        return (T) method.invoke(instance, args);
    }
}
