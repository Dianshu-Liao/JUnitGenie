package com.fasterxml.jackson.core.json;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class DupDetector_isDup_6_0_Test {

    private DupDetector dupDetector;

    @BeforeEach
    public void setUp() {
        // Using reflection to access the private constructor
        try {
            Class<?> clazz = DupDetector.class;
            java.lang.reflect.Constructor<?> constructor = clazz.getDeclaredConstructor(Object.class);
            constructor.setAccessible(true);
            dupDetector = (DupDetector) constructor.newInstance(new Object());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            fail("Failed to create DupDetector instance: " + e.getMessage());
        }
    }

    @Test
    public void testIsDup_FirstNameIsNull() throws JsonParseException {
        assertFalse(dupDetector.isDup("Alice"));
    }

    @Test
    public void testIsDup_FirstNameIsSet() throws JsonParseException {
        dupDetector.isDup("Alice");
        assertTrue(dupDetector.isDup("Alice"));
    }

    @Test
    public void testIsDup_SecondNameIsNull() throws JsonParseException {
        dupDetector.isDup("Alice");
        assertFalse(dupDetector.isDup("Bob"));
    }

    @Test
    public void testIsDup_SecondNameIsSet() throws JsonParseException {
        dupDetector.isDup("Alice");
        dupDetector.isDup("Bob");
        assertTrue(dupDetector.isDup("Bob"));
    }

    @Test
    public void testIsDup_SeenIsNull() throws JsonParseException {
        dupDetector.isDup("Alice");
        dupDetector.isDup("Bob");
        assertFalse(dupDetector.isDup("Charlie"));
    }

    @Test
    public void testIsDup_SeenContainsName() throws JsonParseException {
        dupDetector.isDup("Alice");
        dupDetector.isDup("Bob");
        dupDetector.isDup("Charlie");
        assertTrue(dupDetector.isDup("Alice"));
        assertTrue(dupDetector.isDup("Bob"));
    }

    @Test
    public void testIsDup_EmptyString() throws JsonParseException {
        assertFalse(dupDetector.isDup(""));
        dupDetector.isDup("Alice");
        assertFalse(dupDetector.isDup(""));
    }

    @Test
    public void testIsDup_SpecialCharacters() throws JsonParseException {
        dupDetector.isDup("Alice");
        assertFalse(dupDetector.isDup("@lice"));
        assertFalse(dupDetector.isDup("#lice"));
        assertTrue(dupDetector.isDup("Alice"));
    }

    @Test
    public void testIsDup_NullName() {
        assertThrows(JsonParseException.class, () -> {
            dupDetector.isDup(null);
        });
    }
}
