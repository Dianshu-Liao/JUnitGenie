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

public class JsonPointer_toStringBuilder_22_0_Test {

    private JsonPointer jsonPointerDefault;

    private JsonPointer jsonPointerWithSegment;

    @BeforeEach
    public void setUp() {
        // Initialize a JsonPointer with default constructor
        jsonPointerDefault = new JsonPointer();
        // Initialize a JsonPointer with a segment
        jsonPointerWithSegment = new JsonPointer("fullString", 5, "segment", null);
    }

    @Test
    public void testToStringBuilder_WithDefaultPointer() {
        // Testing toStringBuilder with default JsonPointer
        StringBuilder result = jsonPointerDefault.toStringBuilder(0);
        assertNotNull(result);
        assertEquals("", result.toString());
    }

    @Test
    public void testToStringBuilder_WithNonDefaultPointer() {
        // Testing toStringBuilder with non-default JsonPointer
        StringBuilder result = jsonPointerWithSegment.toStringBuilder(10);
        assertNotNull(result);
        // "fullString" from offset 5
        assertEquals("tring", result.toString());
    }

    @Test
    public void testToStringBuilder_WithSlack() {
        // Testing toStringBuilder with slack parameter
        StringBuilder result = jsonPointerWithSegment.toStringBuilder(5);
        assertNotNull(result);
        // "fullString" from offset 5
        assertEquals("tring", result.toString());
        // Initial capacity should be len - offset + slack
        assertEquals(15, result.capacity());
    }

    @Test
    public void testToStringBuilder_WithNegativeOffset() {
        // Testing toStringBuilder with negative offset
        JsonPointer negativeOffsetPointer = new JsonPointer("fullString", -1, "segment", null);
        StringBuilder result = negativeOffsetPointer.toStringBuilder(0);
        assertNotNull(result);
        assertEquals("fullString", result.toString());
    }

    @Test
    public void testToStringBuilder_WithZeroOffset() {
        // Testing toStringBuilder with zero offset
        JsonPointer zeroOffsetPointer = new JsonPointer("fullString", 0, "segment", null);
        StringBuilder result = zeroOffsetPointer.toStringBuilder(0);
        assertNotNull(result);
        assertEquals("fullString", result.toString());
    }
}
