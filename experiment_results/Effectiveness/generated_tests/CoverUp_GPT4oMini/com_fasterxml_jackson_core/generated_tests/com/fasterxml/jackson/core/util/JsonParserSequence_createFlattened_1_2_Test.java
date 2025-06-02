package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.JsonParserSequence;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class JsonParserSequence_createFlattened_1_2_Test {

    private JsonParser firstParser;

    private JsonParser secondParser;

    @BeforeEach
    public void setUp() {
        firstParser = mock(JsonParser.class);
        secondParser = mock(JsonParser.class);
    }

    @Test
    public void testCreateFlattened_withTwoParsers() {
        JsonParserSequence sequence = JsonParserSequence.createFlattened(firstParser, secondParser);
        assertNotNull(sequence);
        assertNotNull(sequence._parsers);
        assertEquals(2, sequence._parsers.length);
        assertEquals(firstParser, sequence._parsers[0]);
        assertEquals(secondParser, sequence._parsers[1]);
    }

    @Test
    public void testCreateFlattened_withJsonParserSequence() {
        JsonParserSequence sequence1 = JsonParserSequence.createFlattened(firstParser, secondParser);
        JsonParserSequence sequence2 = JsonParserSequence.createFlattened(sequence1, secondParser);
        assertNotNull(sequence2);
        assertNotNull(sequence2._parsers);
        // Should contain more than two parsers
        assertTrue(sequence2._parsers.length > 2);
    }

    @Test
    public void testCreateFlattened_withFirstParserAsSequence() {
        JsonParserSequence sequence1 = JsonParserSequence.createFlattened(firstParser, secondParser);
        JsonParserSequence sequence2 = JsonParserSequence.createFlattened(sequence1, firstParser);
        assertNotNull(sequence2);
        assertNotNull(sequence2._parsers);
        // Should contain more than two parsers
        assertTrue(sequence2._parsers.length > 2);
    }

    @Test
    public void testCreateFlattened_withSecondParserAsSequence() {
        JsonParserSequence sequence1 = JsonParserSequence.createFlattened(firstParser, secondParser);
        JsonParserSequence sequence2 = JsonParserSequence.createFlattened(firstParser, sequence1);
        assertNotNull(sequence2);
        assertNotNull(sequence2._parsers);
        // Should contain more than two parsers
        assertTrue(sequence2._parsers.length > 2);
    }

    @Test
    public void testCreateFlattened_withBothAsSequence() {
        JsonParserSequence sequence1 = JsonParserSequence.createFlattened(firstParser, secondParser);
        JsonParserSequence sequence2 = JsonParserSequence.createFlattened(sequence1, sequence1);
        assertNotNull(sequence2);
        assertNotNull(sequence2._parsers);
        // Should contain more than two parsers
        assertTrue(sequence2._parsers.length > 2);
    }
}
