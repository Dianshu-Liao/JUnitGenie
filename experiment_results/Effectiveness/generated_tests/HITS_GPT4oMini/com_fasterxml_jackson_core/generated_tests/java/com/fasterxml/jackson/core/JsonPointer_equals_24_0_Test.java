package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.util.ArrayList;
import com.fasterxml.jackson.core.io.NumberInput;

public class JsonPointer_equals_24_0_Test {

    @Test
    public void testEquals_SameInstance() {
        JsonPointer pointer = new JsonPointer();
        assertTrue(pointer.equals(pointer), "Same instance should be equal");
    }

    @Test
    public void testEquals_Null() {
        JsonPointer pointer = new JsonPointer();
        assertFalse(pointer.equals(null), "Should not be equal to null");
    }

    @Test
    public void testEquals_DifferentClass() {
        JsonPointer pointer = new JsonPointer();
        String notJsonPointer = "Not a JsonPointer";
        assertFalse(pointer.equals(notJsonPointer), "Should not be equal to an object of a different class");
    }

    @Test
    public void testEquals_DifferentJsonPointers() {
        JsonPointer pointer1 = new JsonPointer("/a/b", 0, "a", null);
        JsonPointer pointer2 = new JsonPointer("/a/b", 0, "a", null);
        assertTrue(pointer1.equals(pointer2), "JsonPointers with same string representation should be equal");
    }

    @Test
    public void testEquals_DifferentJsonPointerContents() {
        JsonPointer pointer1 = new JsonPointer("/a/b", 0, "a", null);
        JsonPointer pointer2 = new JsonPointer("/a/c", 0, "c", null);
        assertFalse(pointer1.equals(pointer2), "JsonPointers with different string representations should not be equal");
    }

    @Test
    public void testEquals_EmptyJsonPointers() {
        JsonPointer pointer1 = new JsonPointer();
        JsonPointer pointer2 = new JsonPointer();
        assertTrue(pointer1.equals(pointer2), "Two empty JsonPointers should be equal");
    }

    @Test
    public void testEquals_SimilarJsonPointers() {
        JsonPointer pointer1 = new JsonPointer("/a/b", 0, "a", null);
        JsonPointer pointer2 = new JsonPointer("/a/b", 0, "a", null);
        assertTrue(pointer1.equals(pointer2), "Similar JsonPointers should be equal");
    }

    @Test
    public void testEquals_NonMatchingJsonPointers() {
        JsonPointer pointer1 = new JsonPointer("/a/b", 0, "a", null);
        JsonPointer pointer2 = new JsonPointer("/a/b/c", 0, "c", null);
        assertFalse(pointer1.equals(pointer2), "JsonPointers with different paths should not be equal");
    }

    @Test
    public void testEquals_SameContentDifferentOffsets() {
        JsonPointer pointer1 = new JsonPointer("/a/b", 0, "a", null);
        JsonPointer pointer2 = new JsonPointer("/a/b", 1, "b", null);
        assertFalse(pointer1.equals(pointer2), "JsonPointers with same content but different offsets should not be equal");
    }
}
