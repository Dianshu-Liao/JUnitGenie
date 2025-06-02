package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

class NameN__equals2_5_0_Test {

    private NameN nameN;

    @BeforeEach
    void setUp() {
        // Initialize the NameN object with the correct parameters
        nameN = new NameN("test", 1, 2, 3, 4, 5, new int[] { 5, 6, 7, 8 }, 4);
    }

    @Test
    void testEquals2_WithMatchingArrays() throws Exception {
        // Matching values for comparison
        int[] quads = new int[] { 5, 6, 7, 8, 9, 10 };
        Method method = NameN.class.getDeclaredMethod("_equals2", int[].class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(nameN, quads);
        assertTrue(result, "Expected _equals2 to return true for matching arrays");
    }

    @Test
    void testEquals2_WithNonMatchingArrays() throws Exception {
        // Non-matching values for comparison
        int[] quads = new int[] { 5, 6, 7, 8, 11, 12 };
        Method method = NameN.class.getDeclaredMethod("_equals2", int[].class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(nameN, quads);
        assertFalse(result, "Expected _equals2 to return false for non-matching arrays");
    }

    @Test
    void testEquals2_WithShorterArray() throws Exception {
        // Shorter array than expected
        int[] quads = new int[] { 5, 6 };
        Method method = NameN.class.getDeclaredMethod("_equals2", int[].class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(nameN, quads);
        assertFalse(result, "Expected _equals2 to return false for shorter arrays");
    }

    @Test
    void testEquals2_WithEmptyArray() throws Exception {
        // Empty array
        int[] quads = new int[] {};
        Method method = NameN.class.getDeclaredMethod("_equals2", int[].class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(nameN, quads);
        assertFalse(result, "Expected _equals2 to return false for empty arrays");
    }
}
