package com.fasterxml.jackson.core;

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

public class JsonPointer_hashCode_23_1_Test {

    private JsonPointer jsonPointer;

    @BeforeEach
    public void setUp() {
        jsonPointer = new JsonPointer();
    }

    @Test
    public void testHashCode_default() throws Exception {
        // Test the default hashCode when not set
        int hashCode = invokeHashCode(jsonPointer);
        assertEquals(-1, hashCode);
    }

    @Test
    public void testHashCode_afterSettingValue() throws Exception {
        // Test that hashCode is calculated after setting a value
        setHashCode(jsonPointer, 12345);
        int hashCode = invokeHashCode(jsonPointer);
        assertEquals(12345, hashCode);
    }

    @Test
    public void testHashCode_sameObject() throws Exception {
        // Test that hashCode is consistent for the same object
        int hashCode1 = invokeHashCode(jsonPointer);
        int hashCode2 = invokeHashCode(jsonPointer);
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    public void testHashCode_differentInstances() throws Exception {
        // Test that different instances can have different hash codes
        JsonPointer anotherPointer = new JsonPointer();
        int hashCode1 = invokeHashCode(jsonPointer);
        int hashCode2 = invokeHashCode(anotherPointer);
        assertNotEquals(hashCode1, hashCode2);
    }

    private int invokeHashCode(JsonPointer jsonPointer) throws Exception {
        Method hashCodeMethod = JsonPointer.class.getDeclaredMethod("hashCode");
        hashCodeMethod.setAccessible(true);
        return (int) hashCodeMethod.invoke(jsonPointer);
    }

    private void setHashCode(JsonPointer jsonPointer, int value) throws Exception {
        Field hashCodeField = JsonPointer.class.getDeclaredField("_hashCode");
        hashCodeField.setAccessible(true);
        hashCodeField.setInt(jsonPointer, value);
    }
}
