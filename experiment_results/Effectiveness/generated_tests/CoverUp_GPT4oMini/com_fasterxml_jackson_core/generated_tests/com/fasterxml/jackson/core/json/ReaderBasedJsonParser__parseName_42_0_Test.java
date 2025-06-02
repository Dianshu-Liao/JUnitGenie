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

class ReaderBasedJsonParser__parseName_42_0_Test {

    private ReaderBasedJsonParser parser;

    private CharsToNameCanonicalizer symbols;

    private BufferRecycler bufferRecycler;

    private IOContext ioContext;

    @BeforeEach
    void setUp() {
        bufferRecycler = new BufferRecycler();
        symbols = CharsToNameCanonicalizer.createRoot();
        ioContext = new IOContext(StreamReadConstraints.defaults(), bufferRecycler, null, true);
        char[] inputBuffer = new char[1024];
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("\"testName\""), null, symbols, inputBuffer, 0, 12, true);
    }

    @Test
    void testParseName() throws IOException {
        String name = invokeParseName();
        assertEquals("testName", name);
    }

    @Test
    void testParseNameWithEscape() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("\"test\\nName\""), null, symbols, new char[1024], 0, 14, true);
        String name = invokeParseName();
        assertEquals("test\nName", name);
    }

    @Test
    void testParseNameWithBoundary() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("\"testName\" more text"), null, symbols, new char[1024], 0, 12, true);
        String name = invokeParseName();
        assertEquals("testName", name);
    }

    private String invokeParseName() throws IOException {
        try {
            return (String) ReaderBasedJsonParser.class.getDeclaredMethod("_parseName").invoke(parser);
        } catch (Exception e) {
            throw new IOException("Failed to invoke _parseName", e);
        }
    }
}
