package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory_createParser_58_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParser_ValidInput() throws IOException, JsonParseException {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        int offset = 0;
        int len = data.length;
        JsonParser parser = jsonFactory.createParser(data, offset, len);
        assertNotNull(parser);
    }

    @Test
    public void testCreateParser_WithInputDecorator() throws IOException, JsonParseException {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        int offset = 0;
        int len = data.length;
        InputDecorator mockInputDecorator = Mockito.mock(InputDecorator.class);
        InputStream mockInputStream = Mockito.mock(InputStream.class);
        jsonFactory._inputDecorator = mockInputDecorator;
        when(mockInputDecorator.decorate(Mockito.any(IOContext.class), Mockito.eq(data), Mockito.eq(offset), Mockito.eq(len))).thenReturn(mockInputStream);
        JsonParser parser = jsonFactory.createParser(data, offset, len);
        assertNotNull(parser);
    }

    @Test
    public void testCreateParser_InvalidRange() {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        // Invalid offset
        int offset = -1;
        int len = data.length;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            jsonFactory.createParser(data, offset, len);
        });
    }

    @Test
    public void testCreateParser_NullData() {
        byte[] data = null;
        int offset = 0;
        int len = 0;
        assertThrows(NullPointerException.class, () -> {
            jsonFactory.createParser(data, offset, len);
        });
    }

    @Test
    public void testCreateParser_ZeroLength() throws IOException, JsonParseException {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        int offset = 0;
        // Zero length
        int len = 0;
        JsonParser parser = jsonFactory.createParser(data, offset, len);
        assertNotNull(parser);
    }

    @Test
    public void testCreateParser_OffsetExceedsLength() {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        // Offset exceeds length
        int offset = data.length;
        int len = 1;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            jsonFactory.createParser(data, offset, len);
        });
    }

    @Test
    public void testCreateParser_NegativeLength() {
        byte[] data = "{\"key\":\"value\"}".getBytes();
        int offset = 0;
        // Invalid negative length
        int len = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            jsonFactory.createParser(data, offset, len);
        });
    }
}
