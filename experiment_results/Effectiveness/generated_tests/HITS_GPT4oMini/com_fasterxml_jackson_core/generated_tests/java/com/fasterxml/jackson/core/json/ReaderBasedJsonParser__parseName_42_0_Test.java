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

public class ReaderBasedJsonParser__parseName_42_0_Test {

    private ReaderBasedJsonParser parser;

    private CharsToNameCanonicalizer symbols;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        symbols = CharsToNameCanonicalizer.createRoot();
        ioContext = new IOContext(bufferRecycler, null, true);
        char[] inputBuffer = new char[256];
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(""), null, symbols, inputBuffer, 0, 0, true);
    }

    @Test
    public void testParseName_SimpleName() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("\"testName\""), null, symbols, new char[256], 0, 10, true);
        String result = parser._parseName();
        assertEquals("testName", result);
    }

    @Test
    public void testParseName_EscapedCharacters() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("\"test\\nName\""), null, symbols, new char[256], 0, 15, true);
        String result = parser._parseName();
        assertEquals("test\nName", result);
    }

    @Test
    public void testParseName_EmptyString() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("\"\""), null, symbols, new char[256], 0, 2, true);
        String result = parser._parseName();
        assertEquals("", result);
    }

    @Test
    public void testParseName_InvalidEOF() {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("\"testName"), null, symbols, new char[256], 0, 10, true);
        assertThrows(IOException.class, parser::_parseName);
    }

    @Test
    public void testParseName_WhitespaceInName() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("\"test Name\""), null, symbols, new char[256], 0, 12, true);
        String result = parser._parseName();
        assertEquals("test Name", result);
    }

    @Test
    public void testParseName_SpecialCharacters() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("\"test@#name$%^\""), null, symbols, new char[256], 0, 18, true);
        String result = parser._parseName();
        assertEquals("test@#name$%^", result);
    }
}
