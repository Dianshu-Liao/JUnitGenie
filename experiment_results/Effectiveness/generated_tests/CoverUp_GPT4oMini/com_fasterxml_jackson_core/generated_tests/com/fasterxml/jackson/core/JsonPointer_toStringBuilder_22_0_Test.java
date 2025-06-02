package com.fasterxml.jackson.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
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

    private JsonPointer jsonPointerEmpty;

    private JsonPointer jsonPointerWithSegment;

    @BeforeEach
    public void setUp() {
        // Creating an instance of JsonPointer with an empty segment
        jsonPointerEmpty = new JsonPointer();
        // Creating an instance of JsonPointer with a segment
        jsonPointerWithSegment = createJsonPointer("example", 0, "segment", null);
    }

    // Helper method to create JsonPointer instance using reflection
    private JsonPointer createJsonPointer(String fullString, int fullStringOffset, String segment, JsonPointer next) {
        try {
            Constructor<JsonPointer> constructor = JsonPointer.class.getDeclaredConstructor(String.class, int.class, String.class, JsonPointer.class);
            constructor.setAccessible(true);
            return constructor.newInstance(fullString, fullStringOffset, segment, next);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testToStringBuilder_EmptyOffset() throws Exception {
        // Test case where _asStringOffset <= 0
        Method method = JsonPointer.class.getDeclaredMethod("toStringBuilder", int.class);
        method.setAccessible(true);
        StringBuilder result = (StringBuilder) method.invoke(jsonPointerEmpty, 0);
        assertEquals("", result.toString());
    }

    @Test
    public void testToStringBuilder_NonEmptyOffset() throws Exception {
        // Test case where _asStringOffset > 0
        Method method = JsonPointer.class.getDeclaredMethod("toStringBuilder", int.class);
        method.setAccessible(true);
        StringBuilder result = (StringBuilder) method.invoke(jsonPointerWithSegment, 5);
        assertEquals("segment", result.toString());
    }

    @Test
    public void testToStringBuilder_WithSlack() throws Exception {
        // Test case with slack added
        Method method = JsonPointer.class.getDeclaredMethod("toStringBuilder", int.class);
        method.setAccessible(true);
        StringBuilder result = (StringBuilder) method.invoke(jsonPointerWithSegment, 10);
        assertEquals("segment", result.toString());
        assertTrue(result.capacity() >= 10 + (jsonPointerWithSegment.getMatchingProperty().length() - jsonPointerWithSegment._asStringOffset));
    }
}
