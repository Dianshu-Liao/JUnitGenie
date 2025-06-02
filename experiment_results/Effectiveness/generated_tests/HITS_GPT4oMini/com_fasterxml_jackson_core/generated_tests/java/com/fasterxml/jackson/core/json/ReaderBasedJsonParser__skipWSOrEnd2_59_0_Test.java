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

public class ReaderBasedJsonParser__skipWSOrEnd2_59_0_Test {

    private ReaderBasedJsonParser parser;

    private IOContext ioContext;

    private CharsToNameCanonicalizer symbols;

    private char[] inputBuffer;

    @BeforeEach
    public void setUp() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        // Use public method to create an instance
        symbols = CharsToNameCanonicalizer.createRoot();
        ioContext = new IOContext(bufferRecycler, null, false);
        inputBuffer = new char[1024];
    }

    @Test
    public void testSkipWhitespace() throws IOException {
        String input = "   \n   \t   \n \nabc";
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(input), null, symbols, inputBuffer, 0, input.length(), true);
        // Use public method to get the first character
        int result = parser.getText().charAt(0);
        assertEquals('a', result);
    }

    @Test
    public void testSkipComment() throws IOException {
        String input = "// This is a comment\n  \n   abc";
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(input), null, symbols, inputBuffer, 0, input.length(), true);
        // Use public method to get the first character
        int result = parser.getText().charAt(0);
        assertEquals('a', result);
    }

    @Test
    public void testSkipYAMLComment() throws IOException {
        String input = "# This is a YAML comment\n  \n   abc";
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(input), null, symbols, inputBuffer, 0, input.length(), true);
        // Use public method to get the first character
        int result = parser.getText().charAt(0);
        assertEquals('a', result);
    }

    @Test
    public void testEndOfInput() throws IOException {
        String input = "";
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(input), null, symbols, inputBuffer, 0, input.length(), true);
        assertThrows(IOException.class, () -> {
            // Attempt to read from an empty parser
            parser.getText();
        });
    }

    @Test
    public void testInvalidCharacter() {
        String input = " \u0001abc";
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(input), null, symbols, inputBuffer, 0, input.length(), true);
        assertThrows(IOException.class, () -> {
            // Attempt to read invalid character
            parser.getText();
        });
    }
}
