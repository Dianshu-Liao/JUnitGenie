package com.fasterxml.jackson.core.sym;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Name2_equals_0_0_Test {

    private Name2 name2;

    @BeforeEach
    public void setUp() {
        // Initialize the Name2 object with dummy values
        name2 = new Name2("testName", 0, 1, 2);
    }

    @Test
    public void testEqualsWithDifferentQuad() throws Exception {
        // Test with a different quad value
        int quad = 3;
        boolean result = invokeEqualsMethod(name2, quad);
        assertFalse(result, "Expected equals(int) to return false for a different quad value");
    }

    @Test
    public void testEqualsWithSameQuad() throws Exception {
        // Test with the same quad value
        // Using the first quad value for the test
        int quad = 1;
        boolean result = invokeEqualsMethod(name2, quad);
        assertFalse(result, "Expected equals(int) to return false for the same quad value");
    }

    // Reflection method to invoke the private equals(int) method
    private boolean invokeEqualsMethod(Name2 instance, int quad) throws Exception {
        java.lang.reflect.Method method = Name2.class.getDeclaredMethod("equals", int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(instance, quad);
    }
}
