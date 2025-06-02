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

class ReaderBasedJsonParser_nextBooleanValue_30_0_Test {

    private ReaderBasedJsonParser parser;

    private IOContext ioContext;

    private CharsToNameCanonicalizer charsToNameCanonicalizer;

    @BeforeEach
    void setUp() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        ioContext = new IOContext(null, bufferRecycler, null, true);
        charsToNameCanonicalizer = CharsToNameCanonicalizer.createRoot();
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(""), null, charsToNameCanonicalizer);
    }

    @Test
    void testNextBooleanValueWithTrueToken() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("{\"key\": true}"), null, charsToNameCanonicalizer);
        // move to FIELD_NAME
        parser.nextToken();
        // move to VALUE_TRUE
        parser.nextToken();
        Boolean result = parser.nextBooleanValue();
        assertTrue(result);
    }

    @Test
    void testNextBooleanValueWithFalseToken() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("{\"key\": false}"), null, charsToNameCanonicalizer);
        // move to FIELD_NAME
        parser.nextToken();
        // move to VALUE_FALSE
        parser.nextToken();
        Boolean result = parser.nextBooleanValue();
        assertFalse(result);
    }

    @Test
    void testNextBooleanValueWithNullToken() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("{\"key\": null}"), null, charsToNameCanonicalizer);
        // move to FIELD_NAME
        parser.nextToken();
        // move to VALUE_NULL
        parser.nextToken();
        Boolean result = parser.nextBooleanValue();
        assertNull(result);
    }

    @Test
    void testNextBooleanValueWithStartArrayToken() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("{\"key\": [true]}"), null, charsToNameCanonicalizer);
        // move to FIELD_NAME
        parser.nextToken();
        // move to START_ARRAY
        parser.nextToken();
        Boolean result = parser.nextBooleanValue();
        // Should return null as it's an array
        assertNull(result);
    }

    @Test
    void testNextBooleanValueWithStartObjectToken() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("{\"key\": {}}"), null, charsToNameCanonicalizer);
        // move to FIELD_NAME
        parser.nextToken();
        // move to START_OBJECT
        parser.nextToken();
        Boolean result = parser.nextBooleanValue();
        // Should return null as it's an object
        assertNull(result);
    }
}
