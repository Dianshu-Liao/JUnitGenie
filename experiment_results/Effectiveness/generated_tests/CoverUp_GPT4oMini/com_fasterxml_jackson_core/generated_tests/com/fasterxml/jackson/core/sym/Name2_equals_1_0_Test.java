package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Name2_equals_1_0_Test {

    private Name2 name2Instance;

    @BeforeEach
    public void setUp() throws Exception {
        // Using reflection to access the private constructor
        Constructor<Name2> constructor = Name2.class.getDeclaredConstructor(String.class, int.class, int.class, int.class);
        constructor.setAccessible(true);
        name2Instance = constructor.newInstance("testName", 0, 1, 2);
    }

    @Test
    public void testEqualsWithMatchingValues() throws Exception {
        // Test case where both parameters match the internal state
        assertTrue(invokeEquals(name2Instance, 1, 2));
    }

    @Test
    public void testEqualsWithNonMatchingFirstValue() throws Exception {
        // Test case where the first parameter does not match
        assertFalse(invokeEquals(name2Instance, 0, 2));
    }

    @Test
    public void testEqualsWithNonMatchingSecondValue() throws Exception {
        // Test case where the second parameter does not match
        assertFalse(invokeEquals(name2Instance, 1, 3));
    }

    @Test
    public void testEqualsWithNonMatchingBothValues() throws Exception {
        // Test case where both parameters do not match
        assertFalse(invokeEquals(name2Instance, 0, 3));
    }

    private boolean invokeEquals(Name2 instance, int quad1, int quad2) throws Exception {
        // Using reflection to invoke the private equals method
        Method equalsMethod = Name2.class.getDeclaredMethod("equals", int.class, int.class);
        equalsMethod.setAccessible(true);
        return (boolean) equalsMethod.invoke(instance, quad1, quad2);
    }
}
