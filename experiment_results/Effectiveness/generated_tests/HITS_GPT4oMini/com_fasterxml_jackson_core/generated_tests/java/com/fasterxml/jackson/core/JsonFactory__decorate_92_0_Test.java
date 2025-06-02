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

public class JsonFactory__decorate_92_0_Test {

    private JsonFactory jsonFactory;

    private OutputDecorator outputDecorator;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
        outputDecorator = mock(OutputDecorator.class);
        jsonFactory.setOutputDecorator(outputDecorator);
        StreamReadConstraints streamReadConstraints = StreamReadConstraints.defaults();
        StreamWriteConstraints streamWriteConstraints = StreamWriteConstraints.defaults();
        ErrorReportConfiguration errorReportConfiguration = ErrorReportConfiguration.defaults();
        BufferRecycler bufferRecycler = new BufferRecycler();
        ContentReference contentReference = ContentReference.rawReference(new Object());
        ioContext = new IOContext(streamReadConstraints, streamWriteConstraints, errorReportConfiguration, bufferRecycler, contentReference, true);
    }

    @Test
    public void testDecorateWithCustomOutputDecorator() throws IOException {
        OutputStream originalOutput = new ByteArrayOutputStream();
        OutputStream decoratedOutput = new ByteArrayOutputStream();
        when(outputDecorator.decorate(ioContext, originalOutput)).thenReturn(decoratedOutput);
        OutputStream result = jsonFactory._decorate(originalOutput, ioContext);
        assertNotNull(result);
        assertSame(decoratedOutput, result);
    }

    @Test
    public void testDecorateWithoutCustomOutputDecorator() throws IOException {
        jsonFactory.setOutputDecorator(null);
        OutputStream originalOutput = new ByteArrayOutputStream();
        OutputStream result = jsonFactory._decorate(originalOutput, ioContext);
        assertNotNull(result);
        assertSame(originalOutput, result);
    }
}
