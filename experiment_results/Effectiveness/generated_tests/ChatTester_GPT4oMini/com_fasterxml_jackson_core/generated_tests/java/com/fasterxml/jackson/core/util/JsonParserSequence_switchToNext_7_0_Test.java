// Test method
package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class JsonParserSequence_switchToNext_7_0_Test {

    private JsonParserSequence jsonParserSequence;

    private JsonParser[] parsers;

    @BeforeEach
    public void setUp() {
        // Assuming we have 3 parsers for testing
        parsers = new JsonParser[3];
        jsonParserSequence = new JsonParserSequence(true, parsers);
        // Initialize index for testing
        jsonParserSequence._nextParserIndex = 0;
    }

    @Test
    public void testSwitchToNext_WithAvailableParsers_ReturnsTrue() throws Exception {
        // Act
        Method method = JsonParserSequence.class.getDeclaredMethod("switchToNext");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(jsonParserSequence);
        // Assert
        assertTrue(result);
        assertEquals(1, jsonParserSequence._nextParserIndex);
    }

    @Test
    public void testSwitchToNext_NoMoreParsers_ReturnsFalse() throws Exception {
        // Set index to length
        jsonParserSequence._nextParserIndex = parsers.length;
        // Act
        Method method = JsonParserSequence.class.getDeclaredMethod("switchToNext");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(jsonParserSequence);
        // Assert
        assertFalse(result);
        assertEquals(parsers.length, jsonParserSequence._nextParserIndex);
    }
}
