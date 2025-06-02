package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import java.net.URL;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.lang.ref.SoftReference;
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

public class JsonFactory_createParser_54_2_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParser_ValidUrl() throws Exception {
        // Arrange
        URL validUrl = new URL("http://example.com/test.json");
        InputStream mockInputStream = mock(InputStream.class);
        IOContext mockContext = mock(IOContext.class);
        JsonParser mockParser = mock(JsonParser.class);
        // Use reflection to access private methods and mock their behavior
        Method optimizedStreamMethod = jsonFactory.getClass().getDeclaredMethod("_optimizedStreamFromURL", URL.class);
        optimizedStreamMethod.setAccessible(true);
        when(optimizedStreamMethod.invoke(jsonFactory, validUrl)).thenReturn(mockInputStream);
        Method createContextMethod = jsonFactory.getClass().getDeclaredMethod("_createContext", Object.class, boolean.class);
        createContextMethod.setAccessible(true);
        when(createContextMethod.invoke(jsonFactory, null, false)).thenReturn(mockContext);
        Method createParserMethod = jsonFactory.getClass().getDeclaredMethod("_createParser", InputStream.class, IOContext.class);
        createParserMethod.setAccessible(true);
        when(createParserMethod.invoke(jsonFactory, mockInputStream, mockContext)).thenReturn(mockParser);
        // Act
        JsonParser parser = invokeCreateParser(validUrl);
        // Assert
        assertNotNull(parser);
        // Ensure parser is closed
        verify(mockParser, times(1)).close();
    }

    @Test
    public void testCreateParser_InvalidUrl() {
        // Arrange
        URL invalidUrl = null;
        // Act & Assert
        assertThrows(IOException.class, () -> invokeCreateParser(invalidUrl));
    }

    @Test
    public void testCreateParser_ThrowsJsonParseException() throws Exception {
        // Arrange
        URL validUrl = new URL("http://example.com/test.json");
        InputStream mockInputStream = mock(InputStream.class);
        IOContext mockContext = mock(IOContext.class);
        // Use reflection to access private methods and mock their behavior
        Method optimizedStreamMethod = jsonFactory.getClass().getDeclaredMethod("_optimizedStreamFromURL", URL.class);
        optimizedStreamMethod.setAccessible(true);
        when(optimizedStreamMethod.invoke(jsonFactory, validUrl)).thenReturn(mockInputStream);
        Method createContextMethod = jsonFactory.getClass().getDeclaredMethod("_createContext", Object.class, boolean.class);
        createContextMethod.setAccessible(true);
        when(createContextMethod.invoke(jsonFactory, null, false)).thenReturn(mockContext);
        Method createParserMethod = jsonFactory.getClass().getDeclaredMethod("_createParser", InputStream.class, IOContext.class);
        createParserMethod.setAccessible(true);
        when(createParserMethod.invoke(jsonFactory, mockInputStream, mockContext)).thenThrow(new JsonParseException(null, "Parsing error"));
        // Act & Assert
        assertThrows(JsonParseException.class, () -> invokeCreateParser(validUrl));
    }

    private JsonParser invokeCreateParser(URL url) throws Exception {
        return (JsonParser) jsonFactory.getClass().getDeclaredMethod("createParser", URL.class).invoke(jsonFactory, url);
    }
}
