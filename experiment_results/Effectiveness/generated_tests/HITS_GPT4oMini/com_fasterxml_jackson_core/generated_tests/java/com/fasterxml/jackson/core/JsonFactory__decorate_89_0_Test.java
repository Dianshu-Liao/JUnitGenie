package com.fasterxml.jackson.core;

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
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory__decorate_89_0_Test {

    private JsonFactory jsonFactory;

    private IOContext ioContext;

    private InputDecorator inputDecorator;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
        ioContext = mock(IOContext.class);
        inputDecorator = mock(InputDecorator.class);
        jsonFactory.setInputDecorator(inputDecorator);
    }

    @Test
    public void testDecorate_WithInputDecorator_ReturnsDecoratedInputStream() throws IOException {
        // Arrange
        InputStream originalStream = new ByteArrayInputStream("test".getBytes());
        InputStream decoratedStream = new ByteArrayInputStream("decorated".getBytes());
        doReturn(decoratedStream).when(inputDecorator).decorate(ioContext, originalStream);
        // Act
        InputStream result = jsonFactory._decorate(originalStream, ioContext);
        // Assert
        assertNotNull(result);
        assertEquals(decoratedStream, result);
    }

    @Test
    public void testDecorate_WithoutInputDecorator_ReturnsOriginalInputStream() throws IOException {
        // Arrange
        InputStream originalStream = new ByteArrayInputStream("test".getBytes());
        // No input decorator
        jsonFactory.setInputDecorator(null);
        // Act
        InputStream result = jsonFactory._decorate(originalStream, ioContext);
        // Assert
        assertNotNull(result);
        assertEquals(originalStream, result);
    }

    @Test
    public void testDecorate_WithInputDecoratorReturningNull_ReturnsOriginalInputStream() throws IOException {
        // Arrange
        InputStream originalStream = new ByteArrayInputStream("test".getBytes());
        doReturn(null).when(inputDecorator).decorate(ioContext, originalStream);
        // Act
        InputStream result = jsonFactory._decorate(originalStream, ioContext);
        // Assert
        assertNotNull(result);
        assertEquals(originalStream, result);
    }
}
