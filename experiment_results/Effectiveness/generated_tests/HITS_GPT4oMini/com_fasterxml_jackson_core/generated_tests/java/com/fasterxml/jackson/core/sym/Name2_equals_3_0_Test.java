package com.fasterxml.jackson.core.sym;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Name2_equals_3_0_Test {

    @Test
    public void testEquals_WithMatchingQuads() {
        Name2 name2 = new Name2("", 1, 2, 0);
        int[] quads = { 1, 2 };
        int qlen = 2;
        assertTrue(name2.equals(quads, qlen), "Expected equals to return true for matching quads.");
    }

    @Test
    public void testEquals_WithNonMatchingFirstQuad() {
        Name2 name2 = new Name2("", 1, 2, 0);
        int[] quads = { 3, 2 };
        int qlen = 2;
        assertFalse(name2.equals(quads, qlen), "Expected equals to return false for non-matching first quad.");
    }

    @Test
    public void testEquals_WithNonMatchingSecondQuad() {
        Name2 name2 = new Name2("", 1, 2, 0);
        int[] quads = { 1, 3 };
        int qlen = 2;
        assertFalse(name2.equals(quads, qlen), "Expected equals to return false for non-matching second quad.");
    }

    @Test
    public void testEquals_WithDifferentLength() {
        Name2 name2 = new Name2("", 1, 2, 0);
        int[] quads = { 1, 2, 3 };
        int qlen = 3;
        assertFalse(name2.equals(quads, qlen), "Expected equals to return false for quads array of different length.");
    }

    @Test
    public void testEquals_WithEmptyArray() {
        Name2 name2 = new Name2("", 1, 2, 0);
        int[] quads = {};
        int qlen = 0;
        assertFalse(name2.equals(quads, qlen), "Expected equals to return false for empty quads array.");
    }

    @Test
    public void testEquals_WithNullArray() {
        Name2 name2 = new Name2("", 1, 2, 0);
        int[] quads = null;
        int qlen = 0;
        assertFalse(name2.equals(quads, qlen), "Expected equals to return false for null quads array.");
    }
}
