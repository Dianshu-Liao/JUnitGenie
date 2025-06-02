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

public class JsonPointer_matchProperty_16_0_Test {

    private JsonPointer jsonPointer;

    @BeforeEach
    public void setUp() {
        // Setting up a JsonPointer with a matching property name
        JsonPointer nextSegment = new JsonPointer("fullString", 0, "segment", null);
        jsonPointer = new JsonPointer("fullString", 0, "propertyName", nextSegment);
    }

    @Test
    public void testMatchProperty_WithMatchingName_ReturnsNextSegment() {
        JsonPointer result = jsonPointer.matchProperty("propertyName");
        assertNotNull(result);
        assertEquals(jsonPointer._nextSegment, result);
    }

    @Test
    public void testMatchProperty_WithNonMatchingName_ReturnsNull() {
        JsonPointer result = jsonPointer.matchProperty("nonMatchingName");
        assertNull(result);
    }

    @Test
    public void testMatchProperty_WhenNextSegmentIsNull_ReturnsNull() {
        JsonPointer jsonPointerWithoutNext = new JsonPointer("fullString", 0, "propertyName", null);
        JsonPointer result = jsonPointerWithoutNext.matchProperty("propertyName");
        assertNull(result);
    }

    @Test
    public void testMatchProperty_WhenNoMatchingPropertyName_ReturnsNull() {
        JsonPointer jsonPointerWithDifferentName = new JsonPointer("fullString", 0, "differentPropertyName", new JsonPointer());
        JsonPointer result = jsonPointerWithDifferentName.matchProperty("propertyName");
        assertNull(result);
    }
}
