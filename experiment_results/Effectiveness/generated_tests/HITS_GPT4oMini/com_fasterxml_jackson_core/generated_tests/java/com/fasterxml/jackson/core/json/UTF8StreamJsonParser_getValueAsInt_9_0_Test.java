package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
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
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser_getValueAsInt_9_0_Test {

    private UTF8StreamJsonParser parser;

    @BeforeEach
    public void setUp() throws IOException {
        BufferRecycler bufferRecycler = new BufferRecycler();
        ByteQuadsCanonicalizer canonicalizer = ByteQuadsCanonicalizer.createRoot();
        IOContext ioContext = new IOContext(StreamReadConstraints.defaults(), bufferRecycler, null, true);
        // Simulating a valid JSON input stream
        String json = "{\"value\": 42}";
        InputStream inputStream = new ByteArrayInputStream(json.getBytes());
        parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, canonicalizer, null, 0, 0, false);
        // Move to the first token
        parser.nextToken();
        // Move to the value token
        parser.nextToken();
    }

    @Test
    public void testGetValueAsInt() throws IOException {
        int result = parser.getValueAsInt();
        assertEquals(42, result);
    }

    @Test
    public void testGetValueAsIntWithInvalidToken() throws IOException {
        // Move to the end of the object
        parser.nextToken();
        assertEquals(0, parser.getValueAsInt());
    }

    @Test
    public void testGetValueAsIntWithNull() throws IOException {
        BufferRecycler bufferRecycler = new BufferRecycler();
        ByteQuadsCanonicalizer canonicalizer = ByteQuadsCanonicalizer.createRoot();
        IOContext ioContext = new IOContext(StreamReadConstraints.defaults(), bufferRecycler, null, true);
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream("null".getBytes()), null, canonicalizer, null, 0, 0, false);
        // Move to the null token
        parser.nextToken();
        assertEquals(0, parser.getValueAsInt());
    }

    @Test
    public void testGetValueAsIntWithException() throws IOException {
        BufferRecycler bufferRecycler = new BufferRecycler();
        ByteQuadsCanonicalizer canonicalizer = ByteQuadsCanonicalizer.createRoot();
        IOContext ioContext = new IOContext(StreamReadConstraints.defaults(), bufferRecycler, null, true);
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream("invalid".getBytes()), null, canonicalizer, null, 0, 0, false);
        // Move to the invalid token
        parser.nextToken();
        assertThrows(IOException.class, () -> {
            parser.getValueAsInt();
        });
    }
}
