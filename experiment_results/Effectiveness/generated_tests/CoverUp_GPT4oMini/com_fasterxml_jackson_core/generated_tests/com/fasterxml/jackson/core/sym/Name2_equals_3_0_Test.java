package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Name2_equals_3_0_Test {

    private Name2 name2Instance;

    @BeforeEach
    public void setUp() {
        // Initialize the instance with sample values
        name2Instance = new Name2("sampleName", 123, 1, 2);
    }

    @Test
    public void testEquals_WithMatchingQuads_ReturnsTrue() throws Exception {
        int[] quads = { 1, 2 };
        int qlen = 2;
        // Invoke the private equals method using reflection
        Method equalsMethod = Name2.class.getDeclaredMethod("equals", int[].class, int.class);
        equalsMethod.setAccessible(true);
        boolean result = (boolean) equalsMethod.invoke(name2Instance, quads, qlen);
        assertTrue(result);
    }

    @Test
    public void testEquals_WithNonMatchingQuads_ReturnsFalse() throws Exception {
        int[] quads = { 2, 3 };
        int qlen = 2;
        Method equalsMethod = Name2.class.getDeclaredMethod("equals", int[].class, int.class);
        equalsMethod.setAccessible(true);
        boolean result = (boolean) equalsMethod.invoke(name2Instance, quads, qlen);
        assertFalse(result);
    }

    @Test
    public void testEquals_WithDifferentLength_ReturnsFalse() throws Exception {
        int[] quads = { 1, 2, 3 };
        int qlen = 3;
        Method equalsMethod = Name2.class.getDeclaredMethod("equals", int[].class, int.class);
        equalsMethod.setAccessible(true);
        boolean result = (boolean) equalsMethod.invoke(name2Instance, quads, qlen);
        assertFalse(result);
    }

    @Test
    public void testEquals_WithZeroLength_ReturnsFalse() throws Exception {
        int[] quads = {};
        int qlen = 0;
        Method equalsMethod = Name2.class.getDeclaredMethod("equals", int[].class, int.class);
        equalsMethod.setAccessible(true);
        boolean result = (boolean) equalsMethod.invoke(name2Instance, quads, qlen);
        assertFalse(result);
    }
}
