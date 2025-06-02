package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharTypes;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class ReaderBasedJsonParser__parseName2_43_0_Test {

    private ReaderBasedJsonParser parser;

    private CharsToNameCanonicalizer symbols;

    private BufferRecycler bufferRecycler;

    private IOContext ioContext;

    private ObjectCodec objectCodec;

    private char[] inputBuffer;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
        symbols = CharsToNameCanonicalizer.createRoot();
        ioContext = new IOContext(bufferRecycler, null, true);
        objectCodec = null;
        inputBuffer = new char[1024];
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("testName"), objectCodec, symbols, inputBuffer, 0, 10, true);
    }

    @Test
    public void testParseName2() throws Exception {
        int startPtr = 0;
        int hash = 0;
        int endChar = ' ';
        Method parseName2Method = ReaderBasedJsonParser.class.getDeclaredMethod("_parseName2", int.class, int.class, int.class);
        parseName2Method.setAccessible(true);
        String result = (String) parseName2Method.invoke(parser, startPtr, hash, endChar);
        assertNotNull(result);
        assertEquals("testName", result);
    }

    @Test
    public void testParseName2HandlesEscapedCharacters() throws Exception {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("test\\name"), objectCodec, symbols, inputBuffer, 0, 10, true);
        int startPtr = 0;
        int hash = 0;
        int endChar = ' ';
        Method parseName2Method = ReaderBasedJsonParser.class.getDeclaredMethod("_parseName2", int.class, int.class, int.class);
        parseName2Method.setAccessible(true);
        String result = (String) parseName2Method.invoke(parser, startPtr, hash, endChar);
        assertNotNull(result);
        assertEquals("test/name", result);
    }

    @Test
    public void testParseName2HandlesEndCharacter() throws Exception {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("nameEnd"), objectCodec, symbols, inputBuffer, 0, 10, true);
        int startPtr = 0;
        int hash = 0;
        int endChar = 'd';
        Method parseName2Method = ReaderBasedJsonParser.class.getDeclaredMethod("_parseName2", int.class, int.class, int.class);
        parseName2Method.setAccessible(true);
        String result = (String) parseName2Method.invoke(parser, startPtr, hash, endChar);
        assertNotNull(result);
        assertEquals("nameEnd", result);
    }

    @Test
    public void testParseName2HandlesInvalidEOF() {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("nameIncomplete"), objectCodec, symbols, inputBuffer, 0, 10, true);
        int startPtr = 0;
        int hash = 0;
        int endChar = 'd';
        Method parseName2Method;
        try {
            parseName2Method = ReaderBasedJsonParser.class.getDeclaredMethod("_parseName2", int.class, int.class, int.class);
            parseName2Method.setAccessible(true);
            String result = (String) parseName2Method.invoke(parser, startPtr, hash, endChar);
            // Assuming the method handles invalid EOF by returning null
            assertNull(result);
        } catch (Exception e) {
            fail("Exception occurred while invoking _parseName2: " + e.getMessage());
        }
    }
}
