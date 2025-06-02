package com.fasterxml.jackson.core.json;

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
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class UTF8StreamJsonParser__decodeUtf8_4_86_1_Test {

    private UTF8StreamJsonParser parser;

    @BeforeEach
    void setUp() throws IOException {
        ByteQuadsCanonicalizer symbolTable = ByteQuadsCanonicalizer.createRoot();
        // Use null for constraints
        IOContext context = new IOContext(null, null, true);
        // Example UTF-8 bytes for U+1F601
        byte[] inputBuffer = new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x81 };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBuffer);
        parser = new UTF8StreamJsonParser(context, 0, inputStream, null, symbolTable, inputBuffer, 0, inputBuffer.length, true);
    }

    @Test
    void testDecodeUtf8_4() throws IOException {
        // Since _decodeUtf8_4 is private, we will test it indirectly through the parser's public methods.
        parser.nextToken();
        // U+1F601
        int expectedCodePoint = 0x1F601;
        // This should call the appropriate method that leads to _decodeUtf8_4
        int actualCodePoint = parser.getValueAsInt();
        assertEquals(expectedCodePoint, actualCodePoint);
    }
}
