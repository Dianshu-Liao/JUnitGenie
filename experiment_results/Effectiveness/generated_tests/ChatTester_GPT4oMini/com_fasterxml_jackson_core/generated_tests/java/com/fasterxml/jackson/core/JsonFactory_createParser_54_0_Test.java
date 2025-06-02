package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import java.net.URL;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
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
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory_createParser_54_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParser_ValidURL() throws Exception {
        // Arrange
        URL url = new URL("http://example.com");
        InputStream inputStreamMock = mock(InputStream.class);
        IOContext ioContextMock = mock(IOContext.class);
        Method optimizedStreamMethod = jsonFactory.getClass().getDeclaredMethod("_optimizedStreamFromURL", URL.class);
        optimizedStreamMethod.setAccessible(true);
        Method createContextMethod = jsonFactory.getClass().getDeclaredMethod("_createContext", Object.class, boolean.class);
        createContextMethod.setAccessible(true);
        Method createParserMethod = jsonFactory.getClass().getDeclaredMethod("_createParser", InputStream.class, IOContext.class);
        createParserMethod.setAccessible(true);
        when(optimizedStreamMethod.invoke(jsonFactory, url)).thenReturn(inputStreamMock);
        when(createContextMethod.invoke(jsonFactory, any(), eq(true))).thenReturn(ioContextMock);
        JsonParser parserMock = mock(JsonParser.class);
        when(createParserMethod.invoke(jsonFactory, inputStreamMock, ioContextMock)).thenReturn(parserMock);
        // Act
        JsonParser parser = jsonFactory.createParser(url);
        // Assert
        assertNotNull(parser);
        assertEquals(parserMock, parser);
    }

    @Test
    public void testCreateParser_InvalidURL() {
        // Arrange
        URL invalidUrl = null;
        // Act & Assert
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(invalidUrl);
        });
    }

    @Test
    public void testCreateParser_ThrowsJsonParseException() throws Exception {
        // Arrange
        URL url = new URL("http://example.com");
        InputStream inputStreamMock = mock(InputStream.class);
        IOContext ioContextMock = mock(IOContext.class);
        Method optimizedStreamMethod = jsonFactory.getClass().getDeclaredMethod("_optimizedStreamFromURL", URL.class);
        optimizedStreamMethod.setAccessible(true);
        Method createContextMethod = jsonFactory.getClass().getDeclaredMethod("_createContext", Object.class, boolean.class);
        createContextMethod.setAccessible(true);
        Method createParserMethod = jsonFactory.getClass().getDeclaredMethod("_createParser", InputStream.class, IOContext.class);
        createParserMethod.setAccessible(true);
        when(optimizedStreamMethod.invoke(jsonFactory, url)).thenReturn(inputStreamMock);
        when(createContextMethod.invoke(jsonFactory, any(), eq(true))).thenReturn(ioContextMock);
        when(createParserMethod.invoke(jsonFactory, inputStreamMock, ioContextMock)).thenThrow(new JsonParseException(null, "Parsing error"));
        // Act & Assert
        assertThrows(JsonParseException.class, () -> {
            jsonFactory.createParser(url);
        });
    }
}
