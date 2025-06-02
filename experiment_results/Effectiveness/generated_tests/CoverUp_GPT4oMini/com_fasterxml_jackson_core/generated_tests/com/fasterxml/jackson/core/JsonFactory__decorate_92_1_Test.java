package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
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
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.util.*;

class JsonFactory__decorate_92_1_Test {

    private JsonFactory jsonFactory;

    private IOContext ioContext;

    private OutputDecorator mockOutputDecorator;

    @BeforeEach
    void setUp() {
        // Initialize JsonFactory and dependencies
        jsonFactory = new JsonFactory();
        ioContext = new IOContext(new StreamReadConstraints(0, 0, 0, 0), new BufferRecycler(), null, false);
        mockOutputDecorator = mock(OutputDecorator.class);
        jsonFactory.setOutputDecorator(mockOutputDecorator);
    }

    @Test
    void testDecorateWithOutputDecorator() throws IOException {
        // Arrange
        ByteArrayOutputStream originalOutputStream = new ByteArrayOutputStream();
        OutputStream decoratedOutputStream = new ByteArrayOutputStream();
        when(mockOutputDecorator.decorate(ioContext, originalOutputStream)).thenReturn(decoratedOutputStream);
        // Act
        OutputStream result = invokePrivateDecorate(originalOutputStream, ioContext);
        // Assert
        assertSame(decoratedOutputStream, result);
        verify(mockOutputDecorator).decorate(ioContext, originalOutputStream);
    }

    @Test
    void testDecorateWithoutOutputDecorator() throws IOException {
        // Arrange
        jsonFactory.setOutputDecorator(null);
        ByteArrayOutputStream originalOutputStream = new ByteArrayOutputStream();
        // Act
        OutputStream result = invokePrivateDecorate(originalOutputStream, ioContext);
        // Assert
        assertSame(originalOutputStream, result);
    }

    private OutputStream invokePrivateDecorate(OutputStream out, IOContext ctxt) throws IOException {
        try {
            Method method = JsonFactory.class.getDeclaredMethod("_decorate", OutputStream.class, IOContext.class);
            method.setAccessible(true);
            return (OutputStream) method.invoke(jsonFactory, out, ctxt);
        } catch (Exception e) {
            throw new IOException("Failed to invoke _decorate method", e);
        }
    }
}
