package com.fasterxml.jackson.core.util;

import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.core.*;

class JsonParserSequence_switchAndReturnNext_8_0_Test {

    private JsonParserSequence jsonParserSequence;

    private JsonParser mockParser1;

    private JsonParser mockParser2;

    @BeforeEach
    void setUp() {
        mockParser1 = mock(JsonParser.class);
        mockParser2 = mock(JsonParser.class);
    }

    @Test
    void testSwitchAndReturnNext_WithCurrentToken() throws Exception {
        JsonToken token1 = JsonToken.VALUE_STRING;
        JsonToken token2 = JsonToken.VALUE_NUMBER_INT;
        JsonParser[] parsers = { mockParser1, mockParser2 };
        jsonParserSequence = new JsonParserSequence(true, parsers);
        // Setup mock behavior for parser 1
        when(mockParser1.hasCurrentToken()).thenReturn(true);
        when(mockParser1.getCurrentToken()).thenReturn(token1);
        // Setup mock behavior for parser 2
        when(mockParser2.nextToken()).thenReturn(token2);
        // Invoke the focal method using reflection
        Method method = JsonParserSequence.class.getDeclaredMethod("switchAndReturnNext");
        method.setAccessible(true);
        JsonToken result = (JsonToken) method.invoke(jsonParserSequence);
        assertEquals(token1, result);
        verify(mockParser1).hasCurrentToken();
        verify(mockParser1).getCurrentToken();
        verifyNoInteractions(mockParser2);
    }

    @Test
    void testSwitchAndReturnNext_NoCurrentToken() throws Exception {
        JsonToken token2 = JsonToken.VALUE_NUMBER_INT;
        JsonParser[] parsers = { mockParser1, mockParser2 };
        jsonParserSequence = new JsonParserSequence(true, parsers);
        // Setup mock behavior for parser 1
        when(mockParser1.hasCurrentToken()).thenReturn(false);
        when(mockParser1.nextToken()).thenReturn(null);
        // Setup mock behavior for parser 2
        when(mockParser2.nextToken()).thenReturn(token2);
        // Invoke the focal method using reflection
        Method method = JsonParserSequence.class.getDeclaredMethod("switchAndReturnNext");
        method.setAccessible(true);
        JsonToken result = (JsonToken) method.invoke(jsonParserSequence);
        assertEquals(token2, result);
        verify(mockParser1).hasCurrentToken();
        verify(mockParser1).nextToken();
        verify(mockParser2).nextToken();
    }

    @Test
    void testSwitchAndReturnNext_NoTokens() throws Exception {
        JsonParser[] parsers = { mockParser1, mockParser2 };
        jsonParserSequence = new JsonParserSequence(true, parsers);
        // Setup mock behavior for parser 1
        when(mockParser1.hasCurrentToken()).thenReturn(false);
        when(mockParser1.nextToken()).thenReturn(null);
        // Setup mock behavior for parser 2
        when(mockParser2.nextToken()).thenReturn(null);
        // Invoke the focal method using reflection
        Method method = JsonParserSequence.class.getDeclaredMethod("switchAndReturnNext");
        method.setAccessible(true);
        JsonToken result = (JsonToken) method.invoke(jsonParserSequence);
        assertNull(result);
        verify(mockParser1).hasCurrentToken();
        verify(mockParser1).nextToken();
        verify(mockParser2).nextToken();
    }

    @Test
    void testSwitchAndReturnNext_WithMultipleParsers() throws Exception {
        JsonToken token1 = JsonToken.VALUE_STRING;
        JsonToken token2 = JsonToken.VALUE_NUMBER_INT;
        JsonToken token3 = JsonToken.VALUE_FALSE;
        JsonParser[] parsers = { mockParser1, mockParser2 };
        jsonParserSequence = new JsonParserSequence(true, parsers);
        // Setup mock behavior for parser 1
        when(mockParser1.hasCurrentToken()).thenReturn(false);
        when(mockParser1.nextToken()).thenReturn(token1);
        // Setup mock behavior for parser 2
        when(mockParser2.nextToken()).thenReturn(token2).thenReturn(token3);
        // Invoke the focal method using reflection
        Method method = JsonParserSequence.class.getDeclaredMethod("switchAndReturnNext");
        method.setAccessible(true);
        JsonToken result1 = (JsonToken) method.invoke(jsonParserSequence);
        JsonToken result2 = (JsonToken) method.invoke(jsonParserSequence);
        assertEquals(token1, result1);
        assertEquals(token2, result2);
        verify(mockParser1).hasCurrentToken();
        verify(mockParser1).nextToken();
        verify(mockParser2, times(2)).nextToken();
    }
}
