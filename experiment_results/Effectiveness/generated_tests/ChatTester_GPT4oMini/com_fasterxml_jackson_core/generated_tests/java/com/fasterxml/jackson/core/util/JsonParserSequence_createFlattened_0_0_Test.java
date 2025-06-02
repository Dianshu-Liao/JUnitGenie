package com.fasterxml.jackson.core.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class JsonParserSequence_createFlattened_0_0_Test {

    private JsonParser mockParser1;

    private JsonParser mockParser2;

    private JsonParserSequence jsonParserSequence;

    @BeforeEach
    public void setUp() {
        mockParser1 = mock(JsonParser.class);
        mockParser2 = mock(JsonParser.class);
    }

    @Test
    public void testCreateFlattened_NeitherParserIsJsonParserSequence() {
        jsonParserSequence = JsonParserSequence.createFlattened(false, mockParser1, mockParser2);
        assertNotNull(jsonParserSequence);
        assertEquals(2, jsonParserSequence._parsers.length);
        assertEquals(mockParser1, jsonParserSequence._parsers[0]);
        assertEquals(mockParser2, jsonParserSequence._parsers[1]);
    }

    @Test
    public void testCreateFlattened_FirstParserIsJsonParserSequence() {
        JsonParserSequence seq1 = mock(JsonParserSequence.class);
        when(seq1._parsers).thenReturn(new JsonParser[] { mockParser1 });
        jsonParserSequence = JsonParserSequence.createFlattened(false, seq1, mockParser2);
        assertNotNull(jsonParserSequence);
        assertEquals(2, jsonParserSequence._parsers.length);
        assertEquals(mockParser1, jsonParserSequence._parsers[0]);
        assertEquals(mockParser2, jsonParserSequence._parsers[1]);
    }

    @Test
    public void testCreateFlattened_SecondParserIsJsonParserSequence() {
        JsonParserSequence seq2 = mock(JsonParserSequence.class);
        when(seq2._parsers).thenReturn(new JsonParser[] { mockParser2 });
        jsonParserSequence = JsonParserSequence.createFlattened(false, mockParser1, seq2);
        assertNotNull(jsonParserSequence);
        assertEquals(2, jsonParserSequence._parsers.length);
        assertEquals(mockParser1, jsonParserSequence._parsers[0]);
        assertEquals(mockParser2, jsonParserSequence._parsers[1]);
    }

    @Test
    public void testCreateFlattened_BothParsersAreJsonParserSequences() {
        JsonParserSequence seq1 = mock(JsonParserSequence.class);
        JsonParserSequence seq2 = mock(JsonParserSequence.class);
        ArrayList<JsonParser> parsersList = new ArrayList<>();
        parsersList.add(mockParser1);
        parsersList.add(mockParser2);
        when(seq1._parsers).thenReturn(new JsonParser[] { mockParser1 });
        when(seq2._parsers).thenReturn(new JsonParser[] { mockParser2 });
        jsonParserSequence = JsonParserSequence.createFlattened(false, seq1, seq2);
        assertNotNull(jsonParserSequence);
        assertEquals(2, jsonParserSequence._parsers.length);
        assertEquals(mockParser1, jsonParserSequence._parsers[0]);
        assertEquals(mockParser2, jsonParserSequence._parsers[1]);
    }
}
