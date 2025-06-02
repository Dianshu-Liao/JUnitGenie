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

public class ReaderBasedJsonParser__isNextTokenNameMaybe_25_0_Test {

    private ReaderBasedJsonParser parser;

    private IOContext ioContext;

    private CharsToNameCanonicalizer symbols;

    @BeforeEach
    public void setUp() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        ioContext = new IOContext(bufferRecycler, null, true);
        symbols = CharsToNameCanonicalizer.createRoot();
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(""), null, symbols);
    }

    @Test
    public void testIsNextTokenNameMaybe_QuotedString_MatchingName() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("\"testName\": \"value\""), null, symbols);
        boolean result = parser._isNextTokenNameMaybe(JsonToken.FIELD_NAME.id(), "testName");
        assertTrue(result, "Expected to match the quoted name 'testName'");
    }

    @Test
    public void testIsNextTokenNameMaybe_QuotedString_NonMatchingName() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("\"testName\": \"value\""), null, symbols);
        boolean result = parser._isNextTokenNameMaybe(JsonToken.FIELD_NAME.id(), "nonMatchingName");
        assertFalse(result, "Expected not to match the quoted name 'nonMatchingName'");
    }

    @Test
    public void testIsNextTokenNameMaybe_OddName() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("{testName: \"value\"}"), null, symbols);
        boolean result = parser._isNextTokenNameMaybe(JsonToken.FIELD_NAME.id(), "testName");
        assertTrue(result, "Expected to match the unquoted name 'testName'");
    }

    @Test
    public void testIsNextTokenNameMaybe_OddName_NonMatching() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("{testName: \"value\"}"), null, symbols);
        boolean result = parser._isNextTokenNameMaybe(JsonToken.FIELD_NAME.id(), "nonMatchingName");
        assertFalse(result, "Expected not to match the unquoted name 'nonMatchingName'");
    }

    @Test
    public void testIsNextTokenNameMaybe_EmptyInput() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(""), null, symbols);
        boolean result = parser._isNextTokenNameMaybe(JsonToken.FIELD_NAME.id(), "testName");
        assertFalse(result, "Expected not to match any name in empty input");
    }

    @Test
    public void testIsNextTokenNameMaybe_InvalidInput() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("12345"), null, symbols);
        boolean result = parser._isNextTokenNameMaybe(JsonToken.FIELD_NAME.id(), "testName");
        assertFalse(result, "Expected not to match any name in invalid input");
    }
}
