package com.fasterxml.jackson.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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

public class JsonPointer_hashCode_23_0_Test {

    private JsonPointer jsonPointer1;

    private JsonPointer jsonPointer2;

    private JsonPointer jsonPointer3;

    @BeforeEach
    public void setUp() {
        // Using default constructor
        jsonPointer1 = new JsonPointer();
        jsonPointer2 = createJsonPointer("fullString", 0, "segment", null);
        jsonPointer3 = createJsonPointer("fullString", 0, "segment", jsonPointer2);
    }

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
    public void testHashCode_EmptyPointer() {
        int expectedHashCode = jsonPointer1.toString().hashCode();
        int actualHashCode = jsonPointer1.hashCode();
        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    public void testHashCode_NonEmptyPointer() {
        int expectedHashCode = jsonPointer2.toString().hashCode();
        int actualHashCode = jsonPointer2.hashCode();
        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    public void testHashCode_NonEmptyPointerWithNext() {
        int expectedHashCode = jsonPointer3.toString().hashCode();
        int actualHashCode = jsonPointer3.hashCode();
        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    public void testHashCode_CachedHashCode() throws Exception {
        // Ensure that the hash code is cached after the first computation
        int firstHashCode = jsonPointer2.hashCode();
        // Reset the cached hash code
        setPrivateField(jsonPointer2, "_hashCode", 0);
        int secondHashCode = jsonPointer2.hashCode();
        assertEquals(firstHashCode, secondHashCode);
    }

    private void setPrivateField(JsonPointer jsonPointer, String fieldName, Object value) throws Exception {
        Field field = JsonPointer.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(jsonPointer, value);
    }
}
