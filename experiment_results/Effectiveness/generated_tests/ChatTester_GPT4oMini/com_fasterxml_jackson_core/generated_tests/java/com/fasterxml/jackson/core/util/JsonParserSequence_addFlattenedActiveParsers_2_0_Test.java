// Test method
package com.fasterxml.jackson.core.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class JsonParserSequence_addFlattenedActiveParsers_2_0_Test {

    private JsonParserSequence jsonParserSequence;

    private JsonParser[] mockParsers;

    @BeforeEach
    public void setUp() {
        // Initialize the mock parsers
        mockParsers = new JsonParser[3];
        mockParsers[0] = mock(JsonParser.class);
        mockParsers[1] = mock(JsonParser.class);
        mockParsers[2] = mock(JsonParserSequence.class);
        // Create an instance of JsonParserSequence
        jsonParserSequence = new JsonParserSequence(false, mockParsers);
        // Set the index to test the loop
        jsonParserSequence._nextParserIndex = 1;
    }

    @Test
    public void testAddFlattenedActiveParsers_withSingleJsonParser() throws Exception {
        // Arrange
        List<JsonParser> listToAddIn = new ArrayList<>();
        // Mocking behavior
        when(mockParsers[0].getCurrentToken()).thenReturn(null);
        // Act
        invokeAddFlattenedActiveParsers(listToAddIn);
        // Assert
        assertEquals(1, listToAddIn.size());
        assertEquals(mockParsers[0], listToAddIn.get(0));
    }

    @Test
    public void testAddFlattenedActiveParsers_withJsonParserSequence() throws Exception {
        // Arrange
        List<JsonParser> listToAddIn = new ArrayList<>();
        JsonParserSequence nestedParserSequence = mock(JsonParserSequence.class);
        // Mocking behavior
        when(mockParsers[2].getCurrentToken()).thenReturn(null);
        when(nestedParserSequence._parsers).thenReturn(new JsonParser[] { mockParsers[0] });
        when(mockParsers[2]).thenReturn(nestedParserSequence);
        // Act
        invokeAddFlattenedActiveParsers(listToAddIn);
        // Assert
        assertEquals(1, listToAddIn.size());
        assertEquals(mockParsers[0], listToAddIn.get(0));
    }

    @Test
    public void testAddFlattenedActiveParsers_withMultipleParsers() throws Exception {
        // Arrange
        List<JsonParser> listToAddIn = new ArrayList<>();
        // Mocking behavior
        when(mockParsers[0].getCurrentToken()).thenReturn(null);
        // Mocking behavior
        when(mockParsers[1].getCurrentToken()).thenReturn(null);
        JsonParserSequence nestedParserSequence = mock(JsonParserSequence.class);
        when(nestedParserSequence._parsers).thenReturn(new JsonParser[] { mockParsers[1] });
        when(mockParsers[2]).thenReturn(nestedParserSequence);
        // Act
        invokeAddFlattenedActiveParsers(listToAddIn);
        // Assert
        assertEquals(2, listToAddIn.size());
        assertEquals(mockParsers[0], listToAddIn.get(0));
        assertEquals(mockParsers[1], listToAddIn.get(1));
    }

    private void invokeAddFlattenedActiveParsers(List<JsonParser> listToAddIn) throws Exception {
        // Fixed Buggy Line
        java.lang.reflect.Method method = JsonParserSequence.class.getDeclaredMethod("addFlattenedActiveParsers", List.class);
        method.setAccessible(true);
        method.invoke(jsonParserSequence, listToAddIn);
    }
}
