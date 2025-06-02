package com.fasterxml.jackson.core.util;

import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.core.*;

class JsonParserSequence_switchAndReturnNext_8_1_Test {

    private JsonParserSequence jsonParserSequence;

    private JsonParser mockParser1;

    private JsonParser mockParser2;

    @BeforeEach
    void setUp() {
        mockParser1 = mock(JsonParser.class);
        mockParser2 = mock(JsonParser.class);
    }

    @Test
    void testSwitchAndReturnNext_WithCurrentToken() throws IOException {
        // Arrange
        JsonParser[] parsers = { mockParser1, mockParser2 };
        jsonParserSequence = new JsonParserSequence(true, parsers);
        when(mockParser1.hasCurrentToken()).thenReturn(true);
        when(mockParser1.getCurrentToken()).thenReturn(JsonToken.VALUE_STRING);
        // Act
        JsonToken result = invokeSwitchAndReturnNext();
        // Assert
        assertEquals(JsonToken.VALUE_STRING, result);
        verify(mockParser1).hasCurrentToken();
        verify(mockParser1).getCurrentToken();
        verify(mockParser1, never()).nextToken();
        verify(mockParser2, never()).nextToken();
    }

    @Test
    void testSwitchAndReturnNext_WithNextToken() throws IOException {
        // Arrange
        JsonParser[] parsers = { mockParser1, mockParser2 };
        jsonParserSequence = new JsonParserSequence(false, parsers);
        when(mockParser1.hasCurrentToken()).thenReturn(false);
        when(mockParser1.nextToken()).thenReturn(JsonToken.START_ARRAY);
        // Act
        JsonToken result = invokeSwitchAndReturnNext();
        // Assert
        assertEquals(JsonToken.START_ARRAY, result);
        verify(mockParser1).nextToken();
        verify(mockParser1).hasCurrentToken();
        verify(mockParser2, never()).nextToken();
    }

    @Test
    void testSwitchAndReturnNext_WithNoTokens() throws IOException {
        // Arrange
        JsonParser[] parsers = { mockParser1, mockParser2 };
        jsonParserSequence = new JsonParserSequence(false, parsers);
        when(mockParser1.hasCurrentToken()).thenReturn(false);
        when(mockParser1.nextToken()).thenReturn(null);
        when(mockParser2.nextToken()).thenReturn(JsonToken.END_ARRAY);
        // Act
        JsonToken result = invokeSwitchAndReturnNext();
        // Assert
        assertEquals(JsonToken.END_ARRAY, result);
        verify(mockParser1).nextToken();
        verify(mockParser2).nextToken();
    }

    @Test
    void testSwitchAndReturnNext_WithAllTokensNull() throws IOException {
        // Arrange
        JsonParser[] parsers = { mockParser1, mockParser2 };
        jsonParserSequence = new JsonParserSequence(false, parsers);
        when(mockParser1.hasCurrentToken()).thenReturn(false);
        when(mockParser1.nextToken()).thenReturn(null);
        when(mockParser2.nextToken()).thenReturn(null);
        // Act
        JsonToken result = invokeSwitchAndReturnNext();
        // Assert
        assertNull(result);
        verify(mockParser1).nextToken();
        verify(mockParser2).nextToken();
    }

    private JsonToken invokeSwitchAndReturnNext() throws IOException {
        try {
            java.lang.reflect.Method method = JsonParserSequence.class.getDeclaredMethod("switchAndReturnNext");
            method.setAccessible(true);
            return (JsonToken) method.invoke(jsonParserSequence);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
