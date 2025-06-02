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

public class JsonFactory__decorate_93_0_Test {

    private JsonFactory jsonFactory;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
        StreamReadConstraints streamReadConstraints = StreamReadConstraints.defaults();
        StreamWriteConstraints streamWriteConstraints = StreamWriteConstraints.defaults();
        ErrorReportConfiguration errorReportConfiguration = ErrorReportConfiguration.defaults();
        BufferRecycler bufferRecycler = new BufferRecycler();
        ioContext = new IOContext(streamReadConstraints, streamWriteConstraints, errorReportConfiguration, bufferRecycler, null, true);
    }

    @Test
    public void testDecorate_WithNullOutputDecorator() throws IOException {
        Writer writer = new StringWriter();
        Writer result = jsonFactory._decorate(writer, ioContext);
        assertEquals(writer, result, "The writer should be the same when output decorator is null");
    }

    @Test
    public void testDecorate_WithOutputDecorator() throws IOException {
        OutputDecorator outputDecorator = mock(OutputDecorator.class);
        Writer originalWriter = new StringWriter();
        Writer decoratedWriter = new StringWriter();
        jsonFactory.setOutputDecorator(outputDecorator);
        when(outputDecorator.decorate(ioContext, originalWriter)).thenReturn(decoratedWriter);
        Writer result = jsonFactory._decorate(originalWriter, ioContext);
        assertEquals(decoratedWriter, result, "The writer should be decorated by the output decorator");
    }

    @Test
    public void testDecorate_WithOutputDecoratorReturningNull() throws IOException {
        OutputDecorator outputDecorator = mock(OutputDecorator.class);
        Writer originalWriter = new StringWriter();
        jsonFactory.setOutputDecorator(outputDecorator);
        when(outputDecorator.decorate(ioContext, originalWriter)).thenReturn(null);
        Writer result = jsonFactory._decorate(originalWriter, ioContext);
        assertEquals(originalWriter, result, "The writer should be the same when output decorator returns null");
    }
}
