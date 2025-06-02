package com.fasterxml.jackson.core;

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
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

class JsonFactory__decorate_90_0_Test {

    private JsonFactory jsonFactory;

    private IOContext ioContext;

    private InputDecorator inputDecorator;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
        ioContext = Mockito.mock(IOContext.class);
        inputDecorator = Mockito.mock(InputDecorator.class);
        // Set the input decorator for testing
        jsonFactory._inputDecorator = inputDecorator;
    }

    @Test
    void testDecorate_WithInputDecorator_ReturnsDecoratedReader() throws Exception {
        // Arrange
        Reader originalReader = new StringReader("test input");
        Reader decoratedReader = new StringReader("decorated input");
        Mockito.when(inputDecorator.decorate(ioContext, originalReader)).thenReturn(decoratedReader);
        // Act
        Reader result = invokePrivateDecorate(jsonFactory, originalReader, ioContext);
        // Assert
        assertNotNull(result);
        assertEquals("decorated input", readAll(result));
    }

    @Test
    void testDecorate_WithoutInputDecorator_ReturnsOriginalReader() throws Exception {
        // Arrange
        // No input decorator
        jsonFactory._inputDecorator = null;
        Reader originalReader = new StringReader("test input");
        // Act
        Reader result = invokePrivateDecorate(jsonFactory, originalReader, ioContext);
        // Assert
        assertNotNull(result);
        assertEquals("test input", readAll(result));
    }

    @Test
    void testDecorate_InputDecoratorReturnsNull_ReturnsOriginalReader() throws Exception {
        // Arrange
        Reader originalReader = new StringReader("test input");
        Mockito.when(inputDecorator.decorate(ioContext, originalReader)).thenReturn(null);
        // Act
        Reader result = invokePrivateDecorate(jsonFactory, originalReader, ioContext);
        // Assert
        assertNotNull(result);
        assertEquals("test input", readAll(result));
    }

    private Reader invokePrivateDecorate(JsonFactory factory, Reader in, IOContext ctxt) throws Exception {
        Method method = JsonFactory.class.getDeclaredMethod("_decorate", Reader.class, IOContext.class);
        method.setAccessible(true);
        return (Reader) method.invoke(factory, in, ctxt);
    }

    private String readAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[1024];
        int numRead;
        while ((numRead = reader.read(buffer)) != -1) {
            sb.append(buffer, 0, numRead);
        }
        return sb.toString();
    }
}
