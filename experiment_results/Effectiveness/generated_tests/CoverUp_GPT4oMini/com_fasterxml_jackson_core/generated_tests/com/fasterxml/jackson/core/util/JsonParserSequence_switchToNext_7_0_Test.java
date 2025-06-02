package com.fasterxml.jackson.core.util;

import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.core.*;

class JsonParserSequence_switchToNext_7_0_Test {

    private JsonParser parser1;

    private JsonParser parser2;

    private JsonParserSequence jsonParserSequence;

    @BeforeEach
    void setUp() {
        parser1 = mock(JsonParser.class);
        parser2 = mock(JsonParser.class);
        jsonParserSequence = new JsonParserSequence(new JsonParser[] { parser1, parser2 });
    }

    @Test
    void testSwitchToNext_WithMoreParsers() throws IOException {
        // Arrange
        when(parser1.nextToken()).thenReturn(JsonToken.START_OBJECT);
        when(parser2.nextToken()).thenReturn(null);
        // Act
        boolean result1 = invokeSwitchToNext(jsonParserSequence);
        boolean result2 = invokeSwitchToNext(jsonParserSequence);
        // Assert
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    void testSwitchToNext_WithNoParsers() throws IOException {
        // Arrange
        JsonParserSequence emptySequence = new JsonParserSequence(new JsonParser[] {});
        // Act
        boolean result = invokeSwitchToNext(emptySequence);
        // Assert
        assertFalse(result);
    }

    private boolean invokeSwitchToNext(JsonParserSequence sequence) {
        try {
            return (boolean) sequence.getClass().getDeclaredMethod("switchToNext").invoke(sequence);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
