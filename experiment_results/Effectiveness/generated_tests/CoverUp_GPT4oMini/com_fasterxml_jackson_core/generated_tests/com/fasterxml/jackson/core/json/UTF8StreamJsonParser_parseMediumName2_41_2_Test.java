package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class UTF8StreamJsonParser_parseMediumName2_41_2_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbolTable;

    private IOContext ioContext;

    private byte[] inputBuffer;

    @BeforeEach
    void setUp() {
        // Initialize the required components for UTF8StreamJsonParser
        symbolTable = ByteQuadsCanonicalizer.createRoot();
        ioContext = new IOContext(null, null, null, null, null, false);
        inputBuffer = new byte[] { '"', 't', 'e', 's', 't', '"', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(inputBuffer), null, symbolTable, inputBuffer, 0, inputBuffer.length, true);
    }

    @Test
    void testParseMediumName2_ExactQuote() throws IOException {
        // Test case for when the input is exactly 9 bytes long and ends with a quote
        String result = invokeParseMediumName2(0, 0);
        assertEquals("test", result);
    }

    @Test
    void testParseMediumName2_QuoteAfterEscapedChar() throws IOException {
        // Test case for when the input has an escaped character before the quote
        // Simulate an escaped character
        inputBuffer[1] = '\\';
        String result = invokeParseMediumName2(0, 0);
        assertEquals("test", result);
    }

    @Test
    void testParseMediumName2_LongName() throws IOException {
        // Test case for when the input exceeds the medium name length
        inputBuffer = new byte[] { '"', 'l', 'o', 'n', 'g', 'e', 'r', 'n', 'a', 'm', 'e', 'f', 'o', 'r', 't', 'e', 's', 't', '"' };
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(inputBuffer), null, symbolTable, inputBuffer, 0, inputBuffer.length, true);
        String result = invokeParseMediumName2(0, 0);
        assertEquals("longernamefortest", result);
    }

    private String invokeParseMediumName2(int q3, int q2) throws IOException {
        try {
            return (String) UTF8StreamJsonParser.class.getDeclaredMethod("parseMediumName2", int.class, int.class).invoke(parser, q3, q2);
        } catch (Exception e) {
            throw new IOException("Failed to invoke parseMediumName2", e);
        }
    }
}
