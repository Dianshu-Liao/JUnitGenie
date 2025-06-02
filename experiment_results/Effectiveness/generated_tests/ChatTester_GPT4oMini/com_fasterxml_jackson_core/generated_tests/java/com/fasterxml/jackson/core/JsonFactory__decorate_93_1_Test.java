package com.fasterxml.jackson.core;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class JsonFactory__decorate_93_1_Test {

    private JsonFactory jsonFactory;

    private IOContext ioContext;

    private Writer writer;

    private OutputDecorator outputDecorator;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
        ioContext = mock(IOContext.class);
        writer = new StringWriter();
        outputDecorator = mock(OutputDecorator.class);
        // Set the output decorator
        jsonFactory._outputDecorator = outputDecorator;
    }

    @Test
    void testDecorate_WithOutputDecorator_ReturnsDecoratedWriter() throws IOException {
        Writer decoratedWriter = new StringWriter();
        when(outputDecorator.decorate(ioContext, writer)).thenReturn(decoratedWriter);
        Writer result = invokeDecorate(writer, ioContext);
        assertEquals(decoratedWriter, result);
        verify(outputDecorator).decorate(ioContext, writer);
    }

    @Test
    void testDecorate_WithoutOutputDecorator_ReturnsOriginalWriter() throws IOException {
        // Remove the output decorator
        jsonFactory._outputDecorator = null;
        Writer result = invokeDecorate(writer, ioContext);
        assertEquals(writer, result);
    }

    private Writer invokeDecorate(Writer out, IOContext ctxt) throws IOException {
        try {
            Method method = JsonFactory.class.getDeclaredMethod("_decorate", Writer.class, IOContext.class);
            method.setAccessible(true);
            return (Writer) method.invoke(jsonFactory, out, ctxt);
        } catch (Exception e) {
            throw new IOException("Failed to invoke _decorate method", e);
        }
    }
}
