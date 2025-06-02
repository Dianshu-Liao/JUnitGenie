package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Name2_equals_2_0_Test {

    private Name2 name2Instance;

    @BeforeEach
    public void setUp() {
        name2Instance = new Name2("testName", 1, 10, 20);
    }

    @Test
    public void testEqualsWithDifferentValues() throws Exception {
        // Using reflection to access the private equals method
        Method equalsMethod = Name2.class.getDeclaredMethod("equals", int.class, int.class, int.class);
        equalsMethod.setAccessible(true);
        // Test with different values
        boolean result = (boolean) equalsMethod.invoke(name2Instance, 30, 40, 0);
        assertFalse(result, "Expected false for non-matching values");
    }

    @Test
    public void testEqualsWithMatchingValues() throws Exception {
        // Using reflection to access the private equals method
        Method equalsMethod = Name2.class.getDeclaredMethod("equals", int.class, int.class, int.class);
        equalsMethod.setAccessible(true);
        // Test with matching values
        boolean result = (boolean) equalsMethod.invoke(name2Instance, 10, 20, 0);
        assertTrue(result, "Expected true for matching values");
    }

    @Test
    public void testEqualsWithDifferentQuad3() throws Exception {
        // Using reflection to access the private equals method
        Method equalsMethod = Name2.class.getDeclaredMethod("equals", int.class, int.class, int.class);
        equalsMethod.setAccessible(true);
        // Test with matching quad1 and quad2 but different quad3
        boolean result = (boolean) equalsMethod.invoke(name2Instance, 10, 20, 5);
        assertTrue(result, "Expected true for matching values with different q3");
    }

    @Test
    public void testEqualsWithNegativeValues() throws Exception {
        // Using reflection to access the private equals method
        Method equalsMethod = Name2.class.getDeclaredMethod("equals", int.class, int.class, int.class);
        equalsMethod.setAccessible(true);
        // Test with negative values
        boolean result = (boolean) equalsMethod.invoke(name2Instance, -10, -20, -5);
        assertFalse(result, "Expected false for non-matching negative values");
    }
}
