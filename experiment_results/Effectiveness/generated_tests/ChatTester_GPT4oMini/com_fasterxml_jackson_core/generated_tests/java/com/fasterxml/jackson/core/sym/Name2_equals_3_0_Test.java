package com.fasterxml.jackson.core.sym;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Name2_equals_3_0_Test {

    private Name2 name2;

    @BeforeEach
    public void setUp() {
        // Initialize the Name2 object with example values
        name2 = new Name2("example", 12345, 10, 20);
    }

    @Test
    public void testEquals_ValidInput() {
        int[] quads = { 10, 20 };
        int qlen = 2;
        assertTrue(name2.equals(quads, qlen), "Expected equals to return true for valid input.");
    }

    @Test
    public void testEquals_InvalidLength() {
        int[] quads = { 10 };
        int qlen = 1;
        assertFalse(name2.equals(quads, qlen), "Expected equals to return false for invalid length.");
    }

    @Test
    public void testEquals_InvalidFirstElement() {
        int[] quads = { 15, 20 };
        int qlen = 2;
        assertFalse(name2.equals(quads, qlen), "Expected equals to return false for invalid first element.");
    }

    @Test
    public void testEquals_InvalidSecondElement() {
        int[] quads = { 10, 25 };
        int qlen = 2;
        assertFalse(name2.equals(quads, qlen), "Expected equals to return false for invalid second element.");
    }

    @Test
    public void testEquals_EmptyArray() {
        int[] quads = {};
        int qlen = 0;
        assertFalse(name2.equals(quads, qlen), "Expected equals to return false for empty array.");
    }

    @Test
    public void testEquals_NullArray() {
        int qlen = 2;
        assertFalse(name2.equals(null, qlen), "Expected equals to return false for null array.");
    }
}
