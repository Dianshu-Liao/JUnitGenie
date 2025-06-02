package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
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

    private IOContext ioContext;

    private CharsToNameCanonicalizer symbols;

    @BeforeEach
    public void setUp() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        ioContext = new IOContext(bufferRecycler, null, true);
        symbols = CharsToNameCanonicalizer.createRoot();
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("{\"key\": \"value\"}"), null, symbols);
    }

    @Test
    public void testNextTextValueWhenFieldName() throws IOException {
        // move to field name
        parser.nextToken();
        assertEquals("key", parser.nextTextValue());
    }

    @Test
    public void testNextTextValueWhenValueString() throws IOException {
        // move to field name
        parser.nextToken();
        // move to value
        parser.nextToken();
        assertEquals("value", parser.nextTextValue());
    }

    @Test
    public void testNextTextValueWhenTokenIncomplete() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("{\"key\": \"incomplete"), null, symbols);
        // move to field name
        parser.nextToken();
        // move to value
        parser.nextToken();
        // token incomplete, should return null
        assertNull(parser.nextTextValue());
    }

    @Test
    public void testNextTextValueWhenNotFieldName() throws IOException {
        // move to field name
        parser.nextToken();
        // move to value
        parser.nextToken();
        // move to end
        parser.nextToken();
        // no field name, should return null
        assertNull(parser.nextTextValue());
    }
}
