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
        // Example initialization with q1 = 1, q2 = 2
        name2 = new Name2("TestName", 0, 1, 2);
    }

    @Test
    public void testEqualsWithQuad1() throws Exception {
        // Test with quad equal to q1
        // Assuming q1 = 1
        assertTrue(invokeEqualsMethod(1));
    }

    @Test
    public void testEqualsWithQuad2() throws Exception {
        // Test with quad equal to q2
        // Assuming q2 = 2
        assertTrue(invokeEqualsMethod(2));
    }

    @Test
    public void testEqualsWithDifferentQuad() throws Exception {
        // Test with quad that is neither q1 nor q2
        // A value that is neither q1 nor q2
        assertFalse(invokeEqualsMethod(3));
    }

    private boolean invokeEqualsMethod(int quad) throws Exception {
        // Using reflection to access the private equals method
        java.lang.reflect.Method method = Name2.class.getDeclaredMethod("equals", int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(name2, quad);
    }
}
