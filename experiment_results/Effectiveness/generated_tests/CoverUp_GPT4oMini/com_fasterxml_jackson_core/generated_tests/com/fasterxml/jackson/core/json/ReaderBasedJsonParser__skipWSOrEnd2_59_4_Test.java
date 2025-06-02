package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.io.IOContext;
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

class ReaderBasedJsonParser__skipWSOrEnd2_59_4_Test {

    private ReaderBasedJsonParser parser;

    private IOContext ioContext;

    private CharsToNameCanonicalizer symbols;

    private ObjectCodec codec;

    private char[] inputBuffer;

    @BeforeEach
    void setUp() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        StreamReadConstraints streamReadConstraints = StreamReadConstraints.defaults();
        ioContext = new IOContext(streamReadConstraints, bufferRecycler, null, true);
        symbols = CharsToNameCanonicalizer.createRoot();
        codec = mock(ObjectCodec.class);
        inputBuffer = new char[1024];
    }

    private void initializeParser(String input) {
        StringReader reader = new StringReader(input);
        parser = new ReaderBasedJsonParser(ioContext, 0, reader, codec, symbols, inputBuffer, 0, input.length(), true);
    }

    @Test
    void testSkipWhitespace() {
        assertDoesNotThrow(() -> {
            initializeParser("   \n\t  \r\n  {\"key\": \"value\"}");
            int result = invokePrivateSkipWSOrEnd2();
            assertEquals('{', result);
        });
    }

    @Test
    void testSkipComment() {
        assertDoesNotThrow(() -> {
            initializeParser("// This is a comment\n{\"key\": \"value\"}");
            int result = invokePrivateSkipWSOrEnd2();
            assertEquals('{', result);
        });
    }

    @Test
    void testSkipYAMLComment() {
        assertDoesNotThrow(() -> {
            initializeParser("# This is a YAML comment\n{\"key\": \"value\"}");
            int result = invokePrivateSkipWSOrEnd2();
            assertEquals('{', result);
        });
    }

    @Test
    void testEndOfInput() {
        assertDoesNotThrow(() -> {
            initializeParser("");
            int result = invokePrivateSkipWSOrEnd2();
            assertEquals(-1, result);
        });
    }

    private int invokePrivateSkipWSOrEnd2() throws Exception {
        java.lang.reflect.Method method = ReaderBasedJsonParser.class.getDeclaredMethod("_skipWSOrEnd2");
        method.setAccessible(true);
        return (int) method.invoke(parser);
    }
}
