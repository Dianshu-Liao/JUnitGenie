package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
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

public class UTF8StreamJsonParser_getText_5_0_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext ioContext;

    private BufferRecycler bufferRecycler;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
        symbols = ByteQuadsCanonicalizer.createRoot();
        ioContext = new IOContext(null, bufferRecycler, true);
    }

    @Test
    public void testGetTextWithValueString() throws IOException {
        String json = "\"Hello, World!\"";
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(json.getBytes()), null, symbols, null, 0, json.length(), true);
        parser.nextToken();
        String result = parser.getText();
        assertEquals("Hello, World!", result);
    }

    @Test
    public void testGetTextWithIncompleteValueString() throws IOException, NoSuchFieldException, IllegalAccessException {
        String json = "\"Hello, ";
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(json.getBytes()), null, symbols, null, 0, json.length(), true);
        parser.nextToken();
        // using reflection to set private field
        java.lang.reflect.Field tokenIncompleteField = UTF8StreamJsonParser.class.getDeclaredField("_tokenIncomplete");
        tokenIncompleteField.setAccessible(true);
        tokenIncompleteField.set(parser, true);
        String result = parser.getText();
        assertEquals("Hello, ", result);
    }

    @Test
    public void testGetTextWithNullToken() throws IOException {
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(new byte[0]), null, symbols, null, 0, 0, true);
        parser.nextToken();
        String result = parser.getText();
        assertNull(result);
    }

    @Test
    public void testGetTextWithFieldName() throws IOException {
        String json = "{\"name\":\"John\"}";
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(json.getBytes()), null, symbols, null, 0, json.length(), true);
        parser.nextToken();
        parser.nextToken();
        String result = parser.getText();
        assertEquals("John", result);
    }

    @Test
    public void testGetTextWithNumber() throws IOException {
        String json = "123";
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(json.getBytes()), null, symbols, null, 0, json.length(), true);
        parser.nextToken();
        String result = parser.getText();
        assertEquals("123", result);
    }

    @Test
    public void testGetTextThrowsIOException() throws Exception {
        String json = "\"Hello, World!\"";
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(json.getBytes()), null, symbols, null, 0, json.length(), true);
        parser.nextToken();
        assertThrows(IOException.class, () -> {
            // Simulating an IOException
            java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("getText");
            method.setAccessible(true);
            method.invoke(parser);
        });
    }
}
