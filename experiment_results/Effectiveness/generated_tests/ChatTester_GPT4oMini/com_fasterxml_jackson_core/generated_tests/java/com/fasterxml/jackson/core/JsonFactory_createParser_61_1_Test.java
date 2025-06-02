package com.fasterxml.jackson.core;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.format.InputAccessor;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory_createParser_61_1_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParserWithValidInput() throws IOException {
        char[] content = "valid json".toCharArray();
        int offset = 0;
        int len = content.length;
        JsonParser parser = jsonFactory.createParser(content, offset, len);
        assertNotNull(parser);
        // Additional assertions can be added here based on expected parser behavior
    }

    @Test
    public void testCreateParserWithNullContent() {
        assertThrows(IOException.class, () -> {
            // Fixed the buggy line
            jsonFactory.createParser((char[]) null, 0, 0);
        });
    }

    @Test
    public void testCreateParserWithNegativeOffset() {
        char[] content = "valid json".toCharArray();
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(content, -1, 5);
        });
    }

    @Test
    public void testCreateParserWithOutOfBoundsOffset() {
        char[] content = "valid json".toCharArray();
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(content, 10, 5);
        });
    }

    @Test
    public void testCreateParserWithZeroLength() throws IOException {
        char[] content = "valid json".toCharArray();
        JsonParser parser = jsonFactory.createParser(content, 0, 0);
        assertNotNull(parser);
        // Additional assertions can be added here based on expected parser behavior
    }

    @Test
    public void testCreateParserWithInputDecorator() throws IOException {
        // Mock InputDecorator
        InputDecorator mockInputDecorator = Mockito.mock(InputDecorator.class);
        jsonFactory.setInputDecorator(mockInputDecorator);
        char[] content = "valid json".toCharArray();
        int offset = 0;
        int len = content.length;
        JsonParser parser = jsonFactory.createParser(content, offset, len);
        assertNotNull(parser);
        // Fixed the buggy line
        verify(mockInputDecorator).decorate(any(IOContext.class), any(Reader.class));
    }

    @Test
    public void testCreateParserWithInputDecoratorNull() throws IOException {
        // Test when _inputDecorator is null
        char[] content = "valid json".toCharArray();
        int offset = 0;
        int len = content.length;
        JsonParser parser = jsonFactory.createParser(content, offset, len);
        assertNotNull(parser);
        // Additional assertions can be added here based on expected parser behavior
    }
}
