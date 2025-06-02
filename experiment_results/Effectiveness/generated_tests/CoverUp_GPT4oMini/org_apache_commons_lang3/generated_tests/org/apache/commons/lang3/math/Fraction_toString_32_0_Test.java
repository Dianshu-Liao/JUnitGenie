package org.apache.commons.lang3.math;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Objects;

public class Fraction_toString_32_0_Test {

    @Test
    public void testToStringWithZero() throws Exception {
        Fraction fraction = invokePrivateConstructor(0, 1);
        String result = invokeToString(fraction);
        assertEquals("0/1", result);
    }

    @Test
    public void testToStringWithOne() throws Exception {
        Fraction fraction = invokePrivateConstructor(1, 1);
        String result = invokeToString(fraction);
        assertEquals("1/1", result);
    }

    @Test
    public void testToStringWithOneHalf() throws Exception {
        Fraction fraction = invokePrivateConstructor(1, 2);
        String result = invokeToString(fraction);
        assertEquals("1/2", result);
    }

    @Test
    public void testToStringWithNegativeFraction() throws Exception {
        Fraction fraction = invokePrivateConstructor(-1, 2);
        String result = invokeToString(fraction);
        assertEquals("-1/2", result);
    }

    @Test
    public void testToStringCaching() throws Exception {
        Fraction fraction = invokePrivateConstructor(3, 4);
        String firstCall = invokeToString(fraction);
        String secondCall = invokeToString(fraction);
        assertEquals(firstCall, secondCall);
        assertNotNull(firstCall);
    }

    private Fraction invokePrivateConstructor(int numerator, int denominator) throws Exception {
        Constructor<Fraction> constructor = Fraction.class.getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);
        return constructor.newInstance(numerator, denominator);
    }

    private String invokeToString(Fraction fraction) throws Exception {
        Method method = Fraction.class.getDeclaredMethod("toString");
        method.setAccessible(true);
        return (String) method.invoke(fraction);
    }
}
