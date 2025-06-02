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

public class JsonPointer_matches_6_0_Test {

    @Test
    public void testMatches_WhenNextSegmentIsNull_ShouldReturnTrue() {
        // Assuming a constructor that initializes _nextSegment to null
        JsonPointer jsonPointer = new JsonPointer();
        assertTrue(jsonPointer.matches(), "Expected matches() to return true when _nextSegment is null.");
    }

    @Test
    public void testMatches_WhenNextSegmentIsNotNull_ShouldReturnFalse() {
        // Assuming a constructor for creating a new JsonPointer
        JsonPointer nextSegment = new JsonPointer();
        JsonPointer jsonPointer = new JsonPointer("fullString", 0, "segment", nextSegment);
        assertFalse(jsonPointer.matches(), "Expected matches() to return false when _nextSegment is not null.");
    }

    @Test
    public void testMatches_WhenPointerIsEmpty_ShouldReturnTrue() {
        // Using the static EMPTY instance
        JsonPointer jsonPointer = JsonPointer.EMPTY;
        assertTrue(jsonPointer.matches(), "Expected matches() to return true for the EMPTY instance.");
    }

    @Test
    public void testMatches_WhenPointerHasMultipleSegments_ShouldReturnFalse() {
        JsonPointer nextSegment = new JsonPointer("fullString", 0, "segment", null);
        JsonPointer jsonPointer = new JsonPointer("fullString", 0, "segment", nextSegment);
        assertFalse(jsonPointer.matches(), "Expected matches() to return false for a pointer with multiple segments.");
    }
}
