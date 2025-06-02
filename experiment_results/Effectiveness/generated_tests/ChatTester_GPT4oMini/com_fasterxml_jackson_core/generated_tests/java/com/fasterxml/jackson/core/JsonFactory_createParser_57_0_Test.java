// Test method
package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
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

public class JsonFactory_createParser_57_0_Test {

    private JsonFactory jsonFactory;

    private ObjectCodec mockObjectCodec;

    private InputDecorator mockInputDecorator;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
        mockInputDecorator = mock(InputDecorator.class);
        // Set the input decorator
        jsonFactory._inputDecorator = mockInputDecorator;
    }

    @Test
    public void testCreateParser_WithInputDecorator() throws IOException, JsonParseException {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        IOContext mockContext = mock(IOContext.class);
        InputStream mockInputStream = new ByteArrayInputStream(data);
        when(mockInputDecorator.decorate(any(IOContext.class), any(byte[].class), anyInt(), anyInt())).thenReturn(mockInputStream);
        JsonParser parser = jsonFactory.createParser(data);
        assertNotNull(parser);
        verify(mockInputDecorator).decorate(any(IOContext.class), eq(data), eq(0), eq(data.length));
        // Additional verifications can be added here based on parser behavior
    }

    @Test
    public void testCreateParser_WithoutInputDecorator() throws IOException, JsonParseException {
        // No input decorator
        jsonFactory._inputDecorator = null;
        byte[] data = "{\"key\":\"value\"}".getBytes();
        JsonParser parser = jsonFactory.createParser(data);
        assertNotNull(parser);
        // Validate the parser's state or behavior
    }

    @Test
    public void testCreateParser_WithNullData() {
        assertThrows(NullPointerException.class, () -> {
            // Fixed the buggy line to specify byte[] explicitly
            jsonFactory.createParser((byte[]) null);
        });
    }

    // Additional test case to validate the behavior when the input decorator returns null
    @Test
    public void testCreateParser_InputDecoratorReturnsNull() throws IOException, JsonParseException {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        when(mockInputDecorator.decorate(any(IOContext.class), any(byte[].class), anyInt(), anyInt())).thenReturn(null);
        JsonParser parser = jsonFactory.createParser(data);
        assertNotNull(parser);
        // Here you would need to validate the parser's state or behavior
    }
}
