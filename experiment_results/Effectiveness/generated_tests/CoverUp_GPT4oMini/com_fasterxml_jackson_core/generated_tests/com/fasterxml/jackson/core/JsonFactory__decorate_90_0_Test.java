package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
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
import com.fasterxml.jackson.core.format.MatchStrength;
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

    private Reader mockReader;

    private InputDecorator mockInputDecorator;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
        mockReader = new StringReader("test");
        mockInputDecorator = mock(InputDecorator.class);
        jsonFactory.setInputDecorator(mockInputDecorator);
        BufferRecycler bufferRecycler = new BufferRecycler();
        StreamReadConstraints readConstraints = StreamReadConstraints.defaults();
        StreamWriteConstraints writeConstraints = StreamWriteConstraints.defaults();
        ErrorReportConfiguration errorReportConfiguration = ErrorReportConfiguration.defaults();
        ioContext = new IOContext(readConstraints, writeConstraints, errorReportConfiguration, bufferRecycler, null, true);
    }

    @Test
    void testDecorateWithInputDecoratorReturnsDecoratedReader() throws IOException {
        Reader decoratedReader = new StringReader("decorated");
        when(mockInputDecorator.decorate(ioContext, mockReader)).thenReturn(decoratedReader);
        Reader result = invokePrivateDecorate(mockReader, ioContext);
        assertSame(decoratedReader, result);
        verify(mockInputDecorator).decorate(ioContext, mockReader);
    }

    @Test
    void testDecorateWithoutInputDecoratorReturnsOriginalReader() throws IOException {
        jsonFactory.setInputDecorator(null);
        Reader result = invokePrivateDecorate(mockReader, ioContext);
        assertSame(mockReader, result);
    }

    private Reader invokePrivateDecorate(Reader in, IOContext ctxt) throws IOException {
        try {
            Method method = JsonFactory.class.getDeclaredMethod("_decorate", Reader.class, IOContext.class);
            method.setAccessible(true);
            return (Reader) method.invoke(jsonFactory, in, ctxt);
        } catch (Exception e) {
            throw new IOException("Failed to invoke _decorate method", e);
        }
    }
}
