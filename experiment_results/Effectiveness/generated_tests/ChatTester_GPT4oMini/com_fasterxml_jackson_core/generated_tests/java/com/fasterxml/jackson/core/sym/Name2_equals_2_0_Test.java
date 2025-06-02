package com.fasterxml.jackson.core.sym;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Name2_equals_2_0_Test {

    private Name2 name2;

    @BeforeEach
    public void setUp() {
        name2 = new Name2("testName", 123, 1, 2);
    }

    @Test
    public void testEquals_WithMatchingValuesAndThirdParameter() {
        // Assuming the equals method is supposed to check if the provided values match the instance variables
        boolean result = invokeEqualsMethod(name2, 1, 2, 3);
        // The method implementation returns false regardless of input
        assertFalse(result);
    }

    @Test
    public void testEquals_WithNonMatchingFirstAndSecondValues() {
        boolean result = invokeEqualsMethod(name2, 2, 3, 4);
        // The method implementation returns false regardless of input
        assertFalse(result);
    }

    @Test
    public void testEquals_WithMatchingFirstAndSecondValuesAndDifferentThirdParameter() {
        boolean result = invokeEqualsMethod(name2, 1, 2, 5);
        // The method implementation returns false regardless of input
        assertFalse(result);
    }

    private boolean invokeEqualsMethod(Name2 instance, int quad1, int quad2, int q3) {
        try {
            java.lang.reflect.Method method = Name2.class.getDeclaredMethod("equals", int.class, int.class, int.class);
            method.setAccessible(true);
            return (boolean) method.invoke(instance, quad1, quad2, q3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
