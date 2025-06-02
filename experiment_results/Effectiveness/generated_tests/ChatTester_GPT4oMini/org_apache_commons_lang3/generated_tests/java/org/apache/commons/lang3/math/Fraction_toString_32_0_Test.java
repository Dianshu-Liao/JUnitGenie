package org.apache.commons.lang3.math;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigInteger;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

public class Fraction_toString_32_0_Test {

    private Fraction fraction;

    @BeforeEach
    public void setUp() throws Exception {
        // Creating a fraction instance using reflection
        Constructor<Fraction> constructor = Fraction.class.getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);
        fraction = constructor.newInstance(1, 2);
    }

    @Test
    public void testToStringInitialCall() throws Exception {
        // Invoke the private method using reflection
        Method toStringMethod = Fraction.class.getDeclaredMethod("toString");
        toStringMethod.setAccessible(true);
        // Call toString for the first time
        String result = (String) toStringMethod.invoke(fraction);
        assertEquals("1/2", result);
    }

    @Test
    public void testToStringSubsequentCall() throws Exception {
        // Invoke the private method using reflection
        Method toStringMethod = Fraction.class.getDeclaredMethod("toString");
        toStringMethod.setAccessible(true);
        // Call toString for the second time
        String firstCallResult = (String) toStringMethod.invoke(fraction);
        String secondCallResult = (String) toStringMethod.invoke(fraction);
        // Ensure the result is cached and the same
        assertEquals("1/2", firstCallResult);
        assertEquals(firstCallResult, secondCallResult);
    }

    @Test
    public void testToStringWithDifferentFractions() throws Exception {
        // Creating different fractions using reflection
        Constructor<Fraction> constructor = Fraction.class.getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);
        Fraction fraction1 = constructor.newInstance(3, 4);
        Fraction fraction2 = constructor.newInstance(-1, 2);
        Fraction fraction3 = constructor.newInstance(2, 5);
        // Invoke the private method using reflection
        Method toStringMethod = Fraction.class.getDeclaredMethod("toString");
        toStringMethod.setAccessible(true);
        // Validate toString for different fractions
        assertEquals("3/4", toStringMethod.invoke(fraction1));
        assertEquals("-1/2", toStringMethod.invoke(fraction2));
        assertEquals("2/5", toStringMethod.invoke(fraction3));
    }
}
