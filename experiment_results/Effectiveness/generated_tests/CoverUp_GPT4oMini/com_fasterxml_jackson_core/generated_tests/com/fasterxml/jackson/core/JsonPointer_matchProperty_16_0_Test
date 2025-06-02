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

    private JsonPointer pointerWithMatchingProperty;

    private JsonPointer pointerWithoutMatchingProperty;

    private JsonPointer emptyPointer;

    @BeforeEach
    public void setUp() {
        // Setting up a JsonPointer with a matching property
        pointerWithMatchingProperty = new JsonPointer("test", 0, "property", new JsonPointer());
        // Setting up a JsonPointer without a matching property
        pointerWithoutMatchingProperty = new JsonPointer("test", 0, "otherProperty", new JsonPointer());
        // Setting up an empty JsonPointer
        emptyPointer = new JsonPointer();
    }

    @Test
    public void testMatchProperty_WithMatchingProperty() {
        JsonPointer result = pointerWithMatchingProperty.matchProperty("property");
        assertNotNull(result);
        assertSame(pointerWithMatchingProperty._nextSegment, result);
    }

    @Test
    public void testMatchProperty_WithNonMatchingProperty() {
        JsonPointer result = pointerWithMatchingProperty.matchProperty("nonMatching");
        assertNull(result);
    }

    @Test
    public void testMatchProperty_EmptyPointer() {
        JsonPointer result = emptyPointer.matchProperty("property");
        assertNull(result);
    }

    @Test
    public void testMatchProperty_NullPointer() {
        JsonPointer result = pointerWithoutMatchingProperty.matchProperty(null);
        assertNull(result);
    }

    @Test
    public void testMatchProperty_EmptyString() {
        JsonPointer result = pointerWithMatchingProperty.matchProperty("");
        assertNull(result);
    }
}
