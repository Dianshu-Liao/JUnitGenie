package com.fasterxml.jackson.core;

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

public class JsonPointer_equals_24_0_Test {

    private JsonPointer jsonPointer1;

    private JsonPointer jsonPointer2;

    private JsonPointer jsonPointer3;

    @BeforeEach
    public void setUp() {
        jsonPointer1 = new JsonPointer("", 0, "property", null);
        jsonPointer2 = new JsonPointer("", 0, "property", null);
        jsonPointer3 = new JsonPointer("", 0, "anotherProperty", null);
    }

    @Test
    public void testEquals_SameReference() {
        assertTrue(jsonPointer1.equals(jsonPointer1));
    }

    @Test
    public void testEquals_NullObject() {
        assertFalse(jsonPointer1.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        assertFalse(jsonPointer1.equals("Not a JsonPointer"));
    }

    @Test
    public void testEquals_SameContent() {
        assertTrue(jsonPointer1.equals(jsonPointer2));
    }

    @Test
    public void testEquals_DifferentContent() {
        assertFalse(jsonPointer1.equals(jsonPointer3));
    }

    @Test
    public void testEquals_DifferentOffsets() throws Exception {
        Method privateMethod = JsonPointer.class.getDeclaredMethod("_compare", String.class, int.class, String.class, int.class);
        privateMethod.setAccessible(true);
        // Create two JsonPointers with different offsets
        JsonPointer jsonPointer4 = new JsonPointer("someString", 0, "property", null);
        JsonPointer jsonPointer5 = new JsonPointer("someString", 1, "property", null);
        boolean result = (boolean) privateMethod.invoke(jsonPointer4, jsonPointer4._asString, jsonPointer4._asStringOffset, jsonPointer5._asString, jsonPointer5._asStringOffset);
        assertFalse(result);
    }
}
