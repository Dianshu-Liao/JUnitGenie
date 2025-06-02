package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class ReaderBasedJsonParser_nextTextValue_27_0_Test {

    private ReaderBasedJsonParser parser;

    @BeforeEach
    public void setUp() {
        // Create a BufferRecycler and IOContext for the parser
        BufferRecycler bufferRecycler = new BufferRecycler();
        IOContext ioContext = new IOContext(null, bufferRecycler, null, true);
        CharsToNameCanonicalizer symbols = CharsToNameCanonicalizer.createRoot();
        // Initialize the parser with a StringReader
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(""), null, symbols);
    }

    @Test
    public void testNextTextValueWithFieldName() throws Exception {
        // Setup the parser with a JSON input containing a field name and string value
        parser = new ReaderBasedJsonParser(new IOContext(null, new BufferRecycler(), null, true), 0, new StringReader("{\"name\":\"value\"}"), null, CharsToNameCanonicalizer.createRoot());
        // Move to the first token (FIELD_NAME)
        // Move to FIELD_NAME
        parser.nextToken();
        // Move to VALUE_STRING
        parser.nextToken();
        // Call nextTextValue and verify the result
        String result = parser.nextTextValue();
        assertEquals("value", result);
    }

    @Test
    public void testNextTextValueWithIncompleteString() throws Exception {
        // Setup the parser with an incomplete JSON string
        parser = new ReaderBasedJsonParser(new IOContext(null, new BufferRecycler(), null, true), 0, new StringReader("{\"name\":\"incomplete"), null, CharsToNameCanonicalizer.createRoot());
        // Move to the first token (FIELD_NAME)
        // Move to FIELD_NAME
        parser.nextToken();
        // Move to VALUE_STRING
        parser.nextToken();
        // Call nextTextValue and verify the result
        String result = parser.nextTextValue();
        // Expect null due to incomplete string
        assertNull(result);
    }

    @Test
    public void testNextTextValueWithStartArray() throws Exception {
        // Setup the parser with a JSON array
        parser = new ReaderBasedJsonParser(new IOContext(null, new BufferRecycler(), null, true), 0, new StringReader("{\"array\":[\"value1\", \"value2\"]}"), null, CharsToNameCanonicalizer.createRoot());
        // Move to the first token (FIELD_NAME)
        // Move to FIELD_NAME
        parser.nextToken();
        // Move to START_ARRAY
        parser.nextToken();
        // Call nextTextValue and verify the result
        String result = parser.nextTextValue();
        // Expect null since the next token is START_ARRAY
        assertNull(result);
    }

    @Test
    public void testNextTextValueWithStartObject() throws Exception {
        // Setup the parser with a JSON object
        parser = new ReaderBasedJsonParser(new IOContext(null, new BufferRecycler(), null, true), 0, new StringReader("{\"object\":{\"key\":\"value\"}}"), null, CharsToNameCanonicalizer.createRoot());
        // Move to the first token (FIELD_NAME)
        // Move to FIELD_NAME
        parser.nextToken();
        // Move to START_OBJECT
        parser.nextToken();
        // Call nextTextValue and verify the result
        String result = parser.nextTextValue();
        // Expect null since the next token is START_OBJECT
        assertNull(result);
    }

    @Test
    public void testNextTextValueWithNoValue() throws Exception {
        // Setup the parser with a JSON input with no value
        parser = new ReaderBasedJsonParser(new IOContext(null, new BufferRecycler(), null, true), 0, new StringReader("{\"empty\":}"), null, CharsToNameCanonicalizer.createRoot());
        // Move to the first token (FIELD_NAME)
        // Move to FIELD_NAME
        parser.nextToken();
        // Move to the end of the object
        parser.nextToken();
        // Call nextTextValue and verify the result
        String result = parser.nextTextValue();
        // Expect null since there is no value
        assertNull(result);
    }
}
