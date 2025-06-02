package com.fasterxml.jackson.core.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.core.*;

class JsonParserSequence_createFlattened_0_1_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    void testCreateFlattened_withTwoRegularParsers() throws IOException {
        String json1 = "{\"name\":\"John\"}";
        String json2 = "{\"age\":30}";
        JsonParser parser1 = jsonFactory.createParser(new StringReader(json1));
        JsonParser parser2 = jsonFactory.createParser(new StringReader(json2));
        JsonParserSequence sequence = JsonParserSequence.createFlattened(false, parser1, parser2);
        assertNotNull(sequence);
        assertEquals(2, sequence._parsers.length);
    }

    @Test
    void testCreateFlattened_withFirstParserAsSequence() throws IOException {
        String json1 = "{\"name\":\"John\"}";
        String json2 = "{\"age\":30}";
        JsonParser parser1 = jsonFactory.createParser(new StringReader(json1));
        JsonParserSequence sequence1 = JsonParserSequence.createFlattened(false, parser1, parser1);
        JsonParser parser2 = jsonFactory.createParser(new StringReader(json2));
        JsonParserSequence sequence = JsonParserSequence.createFlattened(false, sequence1, parser2);
        assertNotNull(sequence);
        assertEquals(3, sequence._parsers.length);
    }

    @Test
    void testCreateFlattened_withSecondParserAsSequence() throws IOException {
        String json1 = "{\"name\":\"John\"}";
        String json2 = "{\"age\":30}";
        JsonParser parser1 = jsonFactory.createParser(new StringReader(json1));
        JsonParser parser2 = jsonFactory.createParser(new StringReader(json2));
        JsonParserSequence sequence2 = JsonParserSequence.createFlattened(false, parser2, parser2);
        JsonParserSequence sequence = JsonParserSequence.createFlattened(false, parser1, sequence2);
        assertNotNull(sequence);
        assertEquals(3, sequence._parsers.length);
    }

    @Test
    void testCreateFlattened_withBothParsersAsSequence() throws IOException {
        String json1 = "{\"name\":\"John\"}";
        String json2 = "{\"age\":30}";
        JsonParser parser1 = jsonFactory.createParser(new StringReader(json1));
        JsonParserSequence sequence1 = JsonParserSequence.createFlattened(false, parser1, parser1);
        JsonParserSequence sequence2 = JsonParserSequence.createFlattened(false, parser1, parser1);
        JsonParserSequence sequence = JsonParserSequence.createFlattened(false, sequence1, sequence2);
        assertNotNull(sequence);
        assertEquals(4, sequence._parsers.length);
    }

    @Test
    void testCreateFlattened_withNullParser() {
        JsonParser parser1 = null;
        JsonParser parser2 = null;
        assertThrows(NullPointerException.class, () -> {
            JsonParserSequence.createFlattened(false, parser1, parser2);
        });
    }
}
