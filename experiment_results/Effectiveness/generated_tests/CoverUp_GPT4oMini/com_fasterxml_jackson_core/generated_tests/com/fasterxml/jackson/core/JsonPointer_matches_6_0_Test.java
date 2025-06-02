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

    private JsonPointer emptyPointer;

    private JsonPointer singleSegmentPointer;

    private JsonPointer multiSegmentPointer;

    @BeforeEach
    public void setUp() {
        emptyPointer = JsonPointer.empty();
        singleSegmentPointer = new JsonPointer("/single", 0, "single", null);
        multiSegmentPointer = new JsonPointer("/multi/segment", 0, "multi", new JsonPointer("/segment", 0, "segment", null));
    }

    @Test
    public void testMatches_EmptyPointer() {
        assertTrue(emptyPointer.matches(), "Empty JsonPointer should match.");
    }

    @Test
    public void testMatches_SingleSegmentPointer() {
        assertTrue(singleSegmentPointer.matches(), "Single segment JsonPointer should match.");
    }

    @Test
    public void testMatches_MultiSegmentPointer() {
        assertFalse(multiSegmentPointer.matches(), "Multi-segment JsonPointer should not match.");
    }

    @Test
    public void testMatches_NullPointer() {
        // This would be an invalid state in practice.
        JsonPointer nullPointer = new JsonPointer();
        assertFalse(nullPointer.matches(), "Null JsonPointer should not match.");
    }

    // Reflection test case to invoke private method if needed
    @Test
    public void testPrivateMethodUsingReflection() throws Exception {
        // Example of invoking private method, if necessary
        // Method privateMethod = JsonPointer.class.getDeclaredMethod("privateMethodName");
        // privateMethod.setAccessible(true);
        // Object result = privateMethod.invoke(multiSegmentPointer);
        // assertEquals(expectedValue, result);
    }
}
