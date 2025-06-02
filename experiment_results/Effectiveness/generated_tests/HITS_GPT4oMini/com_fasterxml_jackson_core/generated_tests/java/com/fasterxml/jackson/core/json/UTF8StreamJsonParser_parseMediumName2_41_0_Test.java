package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
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

public class UTF8StreamJsonParser_parseMediumName2_41_0_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private byte[] inputBuffer;

    @BeforeEach
    public void setUp() {
        // Initialize the ByteQuadsCanonicalizer and IOContext
        // Using the method to create an instance
        symbols = ByteQuadsCanonicalizer.createRoot();
        IOContext context = new IOContext(null, null, true);
        // Set a default size for the input buffer
        inputBuffer = new byte[16];
        parser = new UTF8StreamJsonParser(context, 0, new ByteArrayInputStream(inputBuffer), null, symbols, inputBuffer, 0, inputBuffer.length, true);
    }

    @Test
    public void testParseMediumName2_ValidInput_Quotes() throws IOException {
        // Setup input buffer with a valid name followed by a quote
        inputBuffer[0] = (byte) 'n';
        inputBuffer[1] = (byte) 'a';
        inputBuffer[2] = (byte) 'm';
        inputBuffer[3] = (byte) 'e';
        inputBuffer[4] = (byte) '"';
        // Reset pointer to the start of the input buffer
        parser = new UTF8StreamJsonParser(new IOContext(null, null, true), 0, new ByteArrayInputStream(inputBuffer), null, symbols, inputBuffer, 0, inputBuffer.length, true);
        String result = parser.parseMediumName2(0, 0);
        assertEquals("name", result);
    }

    @Test
    public void testParseMediumName2_ValidInput_NoQuotes() throws IOException {
        // Setup input buffer with a valid name without quotes
        inputBuffer[0] = (byte) 't';
        inputBuffer[1] = (byte) 'e';
        inputBuffer[2] = (byte) 's';
        inputBuffer[3] = (byte) 't';
        inputBuffer[4] = (byte) '1';
        // Reset pointer to the start of the input buffer
        parser = new UTF8StreamJsonParser(new IOContext(null, null, true), 0, new ByteArrayInputStream(inputBuffer), null, symbols, inputBuffer, 0, inputBuffer.length, true);
        String result = parser.parseMediumName2(0, 0);
        assertEquals("test1", result);
    }
}
