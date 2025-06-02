package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamReadConstraints;
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

@ExtendWith(MockitoExtension.class)
class JsonFactory__decorate_89_1_Test {

    private JsonFactory jsonFactory;

    private IOContext ioContext;

    private BufferRecycler bufferRecycler;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
        bufferRecycler = mock(BufferRecycler.class);
        StreamReadConstraints streamReadConstraints = StreamReadConstraints.defaults();
        ioContext = new IOContext(streamReadConstraints, bufferRecycler, null, true);
    }

    @Test
    void testDecorateWithInputDecorator() throws IOException {
        InputDecorator inputDecorator = mock(InputDecorator.class);
        InputStream inputStream = new ByteArrayInputStream("test".getBytes());
        InputStream decoratedStream = new ByteArrayInputStream("decorated".getBytes());
        jsonFactory.setInputDecorator(inputDecorator);
        when(inputDecorator.decorate(ioContext, inputStream)).thenReturn(decoratedStream);
        InputStream result = invokePrivateDecorateMethod(inputStream, ioContext);
        assertSame(decoratedStream, result);
    }

    @Test
    void testDecorateWithoutInputDecorator() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("test".getBytes());
        InputStream result = invokePrivateDecorateMethod(inputStream, ioContext);
        assertSame(inputStream, result);
    }

    private InputStream invokePrivateDecorateMethod(InputStream in, IOContext ctxt) {
        try {
            Method method = JsonFactory.class.getDeclaredMethod("_decorate", InputStream.class, IOContext.class);
            method.setAccessible(true);
            return (InputStream) method.invoke(jsonFactory, in, ctxt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
