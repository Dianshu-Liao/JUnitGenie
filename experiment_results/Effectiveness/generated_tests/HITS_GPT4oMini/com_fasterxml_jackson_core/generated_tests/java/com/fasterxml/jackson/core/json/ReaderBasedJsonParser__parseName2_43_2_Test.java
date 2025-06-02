package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.lang.reflect.Method;
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

public class ReaderBasedJsonParser__parseName2_43_2_Test {

    private ReaderBasedJsonParser parser;

    private CharsToNameCanonicalizer symbols;

    private IOContext ioContext;

    private char[] inputBuffer;

    @BeforeEach
    public void setUp() {
        symbols = CharsToNameCanonicalizer.createRoot();
        ioContext = new IOContext(null, null, true);
        inputBuffer = new char[1024];
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(""), null, symbols, inputBuffer, 0, 0, true);
    }

    private String invokeParseName2(int startPtr, int hash, int endChar) throws Exception {
        Method method = ReaderBasedJsonParser.class.getDeclaredMethod("_parseName2", int.class, int.class, int.class);
        method.setAccessible(true);
        return (String) method.invoke(parser, startPtr, hash, endChar);
    }

    @Test
    public void testParseName2_ValidInput() throws Exception {
        String input = "{\"name\":\"value\"}";
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(input), null, symbols, inputBuffer, 0, input.length(), true);
        // Start parsing after '{'
        String result = invokeParseName2(1, 0, '"');
        assertEquals("name", result);
    }

    @Test
    public void testParseName2_EscapedCharacters() throws Exception {
        String input = "{\"name\\u0022\":\"value\"}";
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(input), null, symbols, inputBuffer, 0, input.length(), true);
        // Start parsing after '{'
        String result = invokeParseName2(1, 0, '"');
        assertEquals("name\"", result);
    }

    @Test
    public void testParseName2_EmptyInput() throws Exception {
        String input = "{}";
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(input), null, symbols, inputBuffer, 0, input.length(), true);
        // Start parsing after '{'
        String result = invokeParseName2(1, 0, '}');
        assertEquals("", result);
    }

    @Test
    public void testParseName2_InvalidEOF() {
        String input = "{\"name\":\"value";
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(input), null, symbols, inputBuffer, 0, input.length(), true);
        assertThrows(IOException.class, () -> {
            // Start parsing after '{'
            invokeParseName2(1, 0, '"');
        });
    }
}
