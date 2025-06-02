package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.lang.reflect.Method;
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
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.*;

class JsonFactory_createParser_57_1_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    void testCreateParser_WithValidData() throws Exception {
        byte[] jsonData = "{\"key\":\"value\"}".getBytes();
        JsonParser parser = jsonFactory.createParser(jsonData);
        assertNotNull(parser);
        assertEquals(JsonParser.Feature.AUTO_CLOSE_SOURCE.enabledIn(jsonFactory.getParserFeatures()), parser.isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE));
    }

    @Test
    void testCreateParser_WithInputDecorator() throws Exception {
        // Mock InputDecorator
        InputDecorator inputDecorator = mock(InputDecorator.class);
        jsonFactory.setInputDecorator(inputDecorator);
        byte[] jsonData = "{\"key\":\"value\"}".getBytes();
        when(inputDecorator.decorate(any(), any(byte[].class), anyInt(), anyInt())).thenReturn(null);
        JsonParser parser = jsonFactory.createParser(jsonData);
        assertNotNull(parser);
        verify(inputDecorator).decorate(any(), eq(jsonData), eq(0), eq(jsonData.length));
    }

    @Test
    void testCreateParser_WithDecoratedInputStream() throws Exception {
        // Mock InputDecorator
        InputDecorator inputDecorator = mock(InputDecorator.class);
        jsonFactory.setInputDecorator(inputDecorator);
        byte[] jsonData = "{\"key\":\"value\"}".getBytes();
        InputStream mockedInputStream = new ByteArrayInputStream(jsonData);
        when(inputDecorator.decorate(any(), any(byte[].class), anyInt(), anyInt())).thenReturn(mockedInputStream);
        JsonParser parser = jsonFactory.createParser(jsonData);
        assertNotNull(parser);
        verify(inputDecorator).decorate(any(), eq(jsonData), eq(0), eq(jsonData.length));
    }

    @Test
    void testCreateParser_WithIOException() {
        byte[] jsonData = "{\"key\":\"value\"}".getBytes();
        // Simulate IOException in _createParser
        try {
            Method method = JsonFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);
            IOContext ioContext = mock(IOContext.class);
            when(ioContext.isResourceManaged()).thenReturn(true);
            assertThrows(IOException.class, () -> {
                method.invoke(jsonFactory, jsonData, 0, jsonData.length, ioContext);
            });
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }
}
